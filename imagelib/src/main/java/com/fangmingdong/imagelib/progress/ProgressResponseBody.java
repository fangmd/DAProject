package com.fangmingdong.imagelib.progress;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Glide 加载进度监听
 * Created by double on 2018/4/8.
 */

public class ProgressResponseBody extends ResponseBody {

    private ResponseBody mResponseBody;
    private ProgressListener mProgressListener;
    private BufferedSource bufferedSource;

    public ProgressResponseBody(String url, ResponseBody responseBody) {
        mResponseBody = responseBody;
        mProgressListener = ProgressInterceptor.LISTENER_MAP.get(url);
    }

    @Override
    public MediaType contentType() {
        return mResponseBody.contentType();
    }

    @Override
    public long contentLength() {
        return mResponseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null) {
            return bufferedSource = Okio.buffer(new ProgressSource(mResponseBody.source()));
        }
        return bufferedSource;
    }

    private class ProgressSource extends ForwardingSource {

        long totalBytesRead = 0;

        int currentProgress;

        ProgressSource(Source source) {
            super(source);
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            long bytesRead = super.read(sink, byteCount);
            long fullLength = mResponseBody.contentLength();
            if (bytesRead == -1) {
                totalBytesRead = fullLength;
            } else {
                totalBytesRead += bytesRead;
            }
            int progress = (int) (100f * totalBytesRead / fullLength);

            if (mProgressListener != null && progress != currentProgress) {
                mProgressListener.onProgress(progress);
            }
            if (mProgressListener != null && totalBytesRead == fullLength) {
                mProgressListener = null;
            }

            currentProgress = progress;
            return bytesRead;
        }
    }
}
