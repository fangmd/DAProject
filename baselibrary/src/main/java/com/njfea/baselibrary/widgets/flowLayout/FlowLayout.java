package com.njfea.baselibrary.widgets.flowLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.njfea.baselibrary.R;

import java.util.ArrayList;
import java.util.List;

/**
 * FlowLayout
 * Created by nerc on 2017/11/24.
 */

public class FlowLayout extends RelativeLayout {
    private int horizontalSpacing;
    private int verticalSpacing;
    private List<FlowLayout.Line> lines;
    private FlowLayout.Line line;
    private int lineSize;
    private int textSize;
    private int textColor;
    private int backgroundResource;
    private int textPaddingH;
    private int textPaddingV;

    public FlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.horizontalSpacing = this.dp2px(10.0F);
        this.verticalSpacing = this.dp2px(10.0F);
        this.lines = new ArrayList();
        this.lineSize = 0;
        this.textSize = this.sp2px(15.0F);
        this.textColor = -16777216;
        this.backgroundResource = R.drawable.bg_frame;
        this.textPaddingH = this.dp2px(7.0F);
        this.textPaddingV = this.dp2px(4.0F);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.FlowLayoutAttrs, defStyleAttr, 0);
        int count = typedArray.getIndexCount();

        for (int i = 0; i < count; ++i) {
            int attr = typedArray.getIndex(i);
            if (attr == R.styleable.FlowLayoutAttrs_horizontalSpacing) {
                this.horizontalSpacing = typedArray.getDimensionPixelSize(attr, this.dp2px(10.0F));
            } else if (attr == R.styleable.FlowLayoutAttrs_verticalSpacing) {
                this.verticalSpacing = typedArray.getDimensionPixelSize(attr, this.dp2px(10.0F));
            } else if (attr == R.styleable.FlowLayoutAttrs_itemSize) {
                this.textSize = typedArray.getDimensionPixelSize(attr, this.sp2px(15.0F));
            } else if (attr == R.styleable.FlowLayoutAttrs_itemColor) {
                this.textColor = typedArray.getColor(attr, -16777216);
            } else if (attr == R.styleable.FlowLayoutAttrs_backgroundResource) {
                this.backgroundResource = typedArray.getResourceId(attr, R.drawable.bg_frame);
            } else if (attr == R.styleable.FlowLayoutAttrs_textPaddingH) {
                this.textPaddingV = typedArray.getDimensionPixelSize(attr, this.dp2px(7.0F));
            } else if (attr == R.styleable.FlowLayoutAttrs_textPaddingV) {
                this.verticalSpacing = typedArray.getDimensionPixelSize(attr, this.dp2px(4.0F));
            }
        }

        typedArray.recycle();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec) - this.getPaddingLeft() - this.getPaddingRight();
        int height = MeasureSpec.getSize(heightMeasureSpec) - this.getPaddingBottom() - this.getPaddingTop();
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        this.restoreLine();

        int totalHeight;
        for (totalHeight = 0; totalHeight < this.getChildCount(); ++totalHeight) {
            View child = this.getChildAt(totalHeight);
            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, widthMode == MeasureSpec.EXACTLY ? MeasureSpec.AT_MOST : widthMode);
            int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, heightMode == MeasureSpec.EXACTLY ? MeasureSpec.AT_MOST : heightMode);
            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            if (this.line == null) {
                this.line = new FlowLayout.Line();
            }

            int measuredWidth = child.getMeasuredWidth();
            this.lineSize += measuredWidth;
            if (this.lineSize <= width) {
                this.line.addChild(child);
                this.lineSize += this.horizontalSpacing;
            } else {
                this.newLine();
                this.line.addChild(child);
                this.lineSize += child.getMeasuredWidth();
                this.lineSize += this.horizontalSpacing;
            }
        }

        if (this.line != null && !this.lines.contains(this.line)) {
            this.lines.add(this.line);
        }

        totalHeight = 0;

        for (int i = 0; i < this.lines.size(); ++i) {
            totalHeight += ((FlowLayout.Line) this.lines.get(i)).getHeight();
        }

        totalHeight += this.verticalSpacing * (this.lines.size() - 1);
        totalHeight += this.getPaddingBottom();
        totalHeight += this.getPaddingTop();
        this.setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), resolveSize(totalHeight, heightMeasureSpec));
    }

    private void restoreLine() {
        this.lines.clear();
        this.line = new FlowLayout.Line();
        this.lineSize = 0;
    }

    private void newLine() {
        if (this.line != null) {
            this.lines.add(this.line);
        }

        this.line = new FlowLayout.Line();
        this.lineSize = 0;
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int left = this.getPaddingLeft();
        int top = this.getPaddingTop();

        for (int i = 0; i < this.lines.size(); ++i) {
            FlowLayout.Line line = (FlowLayout.Line) this.lines.get(i);
            line.layout(left, top);
            top = top + line.getHeight() + this.verticalSpacing;
        }

    }

    public void setFlowLayout(List<String> list, final FlowLayout.OnItemClickListener onItemClickListener) {
        for (int i = 0; i < list.size(); ++i) {
            final TextView tv = new TextView(this.getContext());
            tv.setText((CharSequence) list.get(i));
            tv.setTextSize(0, (float) this.textSize);
            tv.setTextColor(this.textColor);
            tv.setGravity(17);
            tv.setPadding(this.textPaddingH, this.textPaddingV, this.textPaddingH, this.textPaddingV);
            tv.setClickable(true);
            tv.setBackgroundResource(this.backgroundResource);
            this.addView(tv, new RelativeLayout.LayoutParams(-2, -2));
            tv.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    onItemClickListener.onItemClick(tv.getText().toString());
                }
            });
        }

    }

    public void setHorizontalSpacing(int horizontalSpacing) {
        this.horizontalSpacing = this.dp2px((float) horizontalSpacing);
    }

    public void setVerticalSpacing(int verticalSpacing) {
        this.verticalSpacing = this.dp2px((float) verticalSpacing);
    }

    public void setTextSize(int textSize) {
        this.textSize = this.sp2px((float) textSize);
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setBackgroundResource(int backgroundResource) {
        this.backgroundResource = backgroundResource;
    }

    public void setTextPaddingH(int textPaddingH) {
        this.textPaddingH = this.dp2px((float) textPaddingH);
    }

    public void setTextPaddingV(int textPaddingV) {
        this.textPaddingV = this.dp2px((float) textPaddingV);
    }

    private int dp2px(float dp) {
        return (int) TypedValue.applyDimension(1, dp, this.getResources().getDisplayMetrics());
    }

    private int sp2px(float sp) {
        return (int) TypedValue.applyDimension(2, sp, this.getResources().getDisplayMetrics());
    }

    public interface OnItemClickListener {
        void onItemClick(String var1);
    }

    class Line {
        private List<View> children = new ArrayList();
        int height;

        Line() {
        }

        public void addChild(View childView) {
            this.children.add(childView);
            if (this.height < childView.getMeasuredHeight()) {
                this.height = childView.getMeasuredHeight();
            }

        }

        public void layout(int left, int top) {
            int totalWidth = FlowLayout.this.getMeasuredWidth() - FlowLayout.this.getPaddingLeft() - FlowLayout.this.getPaddingRight();
            int currentLeft = left;

            for (int i = 0; i < this.children.size(); ++i) {
                View view = (View) this.children.get(i);
                view.layout(currentLeft, top, currentLeft + view.getMeasuredWidth(), top + view.getMeasuredHeight());
                currentLeft = currentLeft + view.getMeasuredWidth() + FlowLayout.this.horizontalSpacing;
            }

        }

        public int getHeight() {
            return this.height;
        }

        public int getChildCount() {
            return this.children.size();
        }
    }
}
