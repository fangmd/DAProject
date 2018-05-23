

# 介绍

X5WebView 版本：v3.6.01234_43608

# 使用

Application 中初始化：

```
    private void initX5WebView() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                LoggerUtils.d("WebView", "X5WebView onViewInitFinished init finished:" + arg0);
            }

            @Override
            public void onCoreInitFinished() {

            }
        };
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
```


# proguard

```
-keep class com.njfae.xwebview.** {*;}
```