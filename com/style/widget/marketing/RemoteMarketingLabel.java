package com.style.widget.marketing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mobads.container.a.d;
import com.baidu.mobads.container.util.ab;
import com.component.a.i.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class RemoteMarketingLabel extends LinearLayout {
    private ImageView mIconView;
    public int mLabelFontSizeSp;
    public Typeface mLabelFontTypeFace;
    private TextView mLabelText;
    private String mMarketingDesc;
    private String mMarketingICONUrl;
    private Paint mPaint;
    private final Rect mRect;
    private final RectF mRectF;
    private d mResponse;

    public RemoteMarketingLabel(Context context) {
        this(context, null);
    }

    public RemoteMarketingLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemoteMarketingLabel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRectF = new RectF();
        this.mRect = new Rect();
        this.mLabelFontSizeSp = 10;
        initView();
    }

    public void setAdData(Object obj) {
        try {
            this.mResponse = new d(obj);
            setMarketingDesc(this.mResponse.l());
            setMarketingICONUrl(this.mResponse.k());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMarketingDesc(String str) {
        this.mMarketingDesc = str;
        if (TextUtils.isEmpty(this.mMarketingDesc)) {
            this.mMarketingDesc = "种草优品";
        }
        if (this.mLabelText != null) {
            this.mLabelText.setText(this.mMarketingDesc);
        }
    }

    public void setMarketingICONUrl(String str) {
        this.mMarketingICONUrl = str;
        if (TextUtils.isEmpty(this.mMarketingICONUrl)) {
            this.mMarketingICONUrl = "https://render-server.cdn.bcebos.com/static/images/20201231/zhongcao.png";
        }
        if (this.mIconView != null) {
            com.baidu.mobads.container.util.d.d.a(getContext()).b(this.mIconView, this.mMarketingICONUrl);
        }
    }

    public void setBorderColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(i);
        }
    }

    public void setBorderWidth(int i) {
        if (this.mPaint != null) {
            this.mPaint.setStrokeWidth(ab.a(getContext(), i));
        }
    }

    public void initView() {
        removeAllViews();
        setOrientation(0);
        setWillNotDraw(false);
        this.mPaint = new Paint();
        this.mPaint.setColor(Color.parseColor("#ff3300"));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(ab.a(getContext(), 1.0f));
        this.mLabelText = new TextView(getContext());
        this.mLabelText.setSingleLine();
        this.mLabelText.setTextSize(2, this.mLabelFontSizeSp);
        this.mLabelText.setTextColor(Color.parseColor("#ff3300"));
        if (this.mLabelFontTypeFace != null) {
            this.mLabelText.setTypeface(this.mLabelFontTypeFace);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.mLabelText, layoutParams);
        this.mIconView = new ImageView(getContext());
        this.mIconView.setScaleType(ImageView.ScaleType.FIT_XY);
        int lineHeight = this.mLabelText.getLineHeight();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(lineHeight, lineHeight);
        layoutParams2.gravity = 16;
        double d = lineHeight;
        Double.isNaN(d);
        layoutParams2.rightMargin = (int) (0.2d * d);
        addView(this.mIconView, 0, layoutParams2);
        Double.isNaN(d);
        int i = (int) (d * 0.4d);
        setPadding(i, 0, i, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mRect);
        if (this.mRect.bottom > 0 && this.mRect.right > 0) {
            this.mRect.top += 2;
            this.mRect.left += 2;
            Rect rect = this.mRect;
            rect.bottom -= 2;
            Rect rect2 = this.mRect;
            rect2.right -= 2;
        }
        this.mRectF.set(this.mRect);
        float height = getHeight() / 2;
        canvas.drawRoundRect(this.mRectF, height, height, this.mPaint);
    }

    public void setLabelFontSizeSp(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (i > 0) {
            this.mLabelFontSizeSp = i;
            if (this.mLabelText != null) {
                this.mLabelText.setTextSize(2, this.mLabelFontSizeSp);
                int lineHeight = this.mLabelText.getLineHeight();
                if (this.mIconView != null && (layoutParams = this.mIconView.getLayoutParams()) != null) {
                    layoutParams.width = lineHeight;
                    layoutParams.height = lineHeight;
                    this.mIconView.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        if (typeface != null) {
            this.mLabelFontTypeFace = typeface;
            if (this.mLabelText != null) {
                this.mLabelText.setTypeface(typeface);
            }
        }
    }

    public void setLabelFontUnderLine(int i) {
        TextPaint paint;
        if (this.mLabelText != null && (paint = this.mLabelText.getPaint()) != null && n.a(i)) {
            paint.setFlags(8);
        }
    }
}
