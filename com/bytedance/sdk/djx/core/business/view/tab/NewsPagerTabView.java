package com.bytedance.sdk.djx.core.business.view.tab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NewsPagerTabView extends LinearLayout {
    private boolean mIsShowRedPoint;
    private Paint mPaint;
    private int mTabMarin;
    private int mTabWidth;
    private TextView mTextView;

    NewsPagerTabView(Context context, int i, int i2) {
        super(context);
        this.mIsShowRedPoint = false;
        this.mTabMarin = i;
        this.mTabWidth = i2;
        init();
    }

    public NewsPagerTabView(Context context) {
        super(context);
        this.mTabWidth = -2;
        this.mTabMarin = 10;
        this.mIsShowRedPoint = false;
        init();
    }

    public NewsPagerTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabWidth = -2;
        this.mTabMarin = 10;
        this.mIsShowRedPoint = false;
        init();
    }

    public void init() {
        Context context = getContext();
        setGravity(17);
        TextView textView = new TextView(context);
        textView.setTextSize(0, getResources().getDimension(R.dimen.djx_news_channel_text_size));
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTextColor(context.getResources().getColor(R.color.djx_news_tab_text_color));
        textView.setIncludeFontPadding(false);
        textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        int iDp2px = (int) (UIUtil.dp2px(this.mTabMarin) + 0.5f);
        if (this.mTabWidth != -2) {
            iDp2px = 0;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mTabWidth, -2);
        layoutParams.setMargins(iDp2px, 0, iDp2px, 0);
        layoutParams.gravity = 17;
        this.mTextView = textView;
        addView(textView, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mIsShowRedPoint) {
            drawRedPoint(canvas);
        }
    }

    private void drawRedPoint(Canvas canvas) {
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(Color.parseColor("#FFFD2C55"));
        }
        View childAt = getChildAt(0);
        if (childAt != null) {
            float fDp2px = UIUtil.dp2px(4.0f);
            canvas.drawCircle(childAt.getX() + childAt.getWidth() + fDp2px, childAt.getY() + (fDp2px / 2.0f), fDp2px, this.mPaint);
        }
    }

    public boolean isShowRedPoint() {
        return this.mIsShowRedPoint;
    }

    public void setShowRedPoint(boolean z) {
        this.mIsShowRedPoint = z;
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
    }

    public void setTextSize(int i) {
        this.mTextView.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.mTextView.setTextColor(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mTextView.setTextColor(colorStateList);
    }

    public void setStrokeWidth(float f) {
        this.mTextView.getPaint().setStrokeWidth(f);
        this.mTextView.invalidate();
    }
}
