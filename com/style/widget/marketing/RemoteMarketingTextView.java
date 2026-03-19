package com.style.widget.marketing;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.a.d;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.x;
import com.component.a.c.c;
import com.component.a.f.e;
import com.component.a.i.f;
import com.component.a.i.n;
import com.component.a.i.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class RemoteMarketingTextView extends RelativeLayout implements c {
    private static final int VIEW_ID_LABEL = 10001;
    private Context mContext;
    private TextUtils.TruncateAt mEllipsize;
    private int mLabelFontSizeSp;
    private Typeface mLabelFontTypeFace;
    private int mLabelVisibility;
    private int mLineSpacingExtra;
    private f mNativeLifeCycle;
    private d mResponse;
    private int mTextFontColor;
    private int mTextFontSizeSp;
    private Typeface mTextFontTypeFace;
    private int mTextMaxLines;
    private String mTitle;
    private TextView mTitleSubView;
    private TextView mTitleView;
    private RemoteMarketingLabel marketingLabel;

    public RemoteMarketingTextView(Context context) {
        this(context, null);
        this.mContext = context;
    }

    public RemoteMarketingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RemoteMarketingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextFontSizeSp = 11;
        this.mTextFontColor = -1;
        this.mTextMaxLines = 3;
        this.mEllipsize = TextUtils.TruncateAt.END;
        this.mLineSpacingExtra = 0;
        this.mLabelVisibility = 0;
        this.mLabelFontSizeSp = -1;
        this.mContext = context;
        initView();
    }

    public void setAdData(Object obj, String str) {
        try {
            this.mResponse = new d(obj);
            this.mTitle = str;
            if (TextUtils.isEmpty(this.mTitle)) {
                this.mTitle = this.mResponse.getTitle();
            }
            setTitleContent(this.mTitle);
            setMarketingLabelDesc(this.mResponse.l());
            setMarketingLabelIcon(this.mResponse.k());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMarketingLabelDesc(String str) {
        if (this.marketingLabel != null) {
            this.marketingLabel.setMarketingDesc(str);
        }
    }

    public void setMarketingLabelIcon(String str) {
        if (this.marketingLabel != null) {
            this.marketingLabel.setMarketingICONUrl(str);
        }
    }

    public void setMarketingLabelBorderWidth(int i) {
        if (this.marketingLabel != null) {
            this.marketingLabel.setBorderWidth(i);
        }
    }

    public void setMarketingLabelBorderColor(int i) {
        if (this.marketingLabel != null) {
            this.marketingLabel.setBorderColor(i);
        }
    }

    public void setTitleContent(String str) {
        this.mTitle = str;
        if (TextUtils.isEmpty(str) || this.mTitleView == null) {
            return;
        }
        this.mTitleView.setText(str);
        this.mTitleView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.style.widget.marketing.RemoteMarketingTextView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                try {
                    Layout layout = RemoteMarketingTextView.this.mTitleView.getLayout();
                    if (layout == null) {
                        return true;
                    }
                    String strSubstring = RemoteMarketingTextView.this.mTitle.substring(layout.getLineEnd(0));
                    if (TextUtils.isEmpty(strSubstring) || RemoteMarketingTextView.this.mTextMaxLines <= 1) {
                        RemoteMarketingTextView.this.mTitleSubView.setVisibility(8);
                    } else {
                        RemoteMarketingTextView.this.mTitleSubView.setText(strSubstring);
                        RemoteMarketingTextView.this.mTitleSubView.setVisibility(0);
                    }
                    RemoteMarketingTextView.this.mTitleView.getViewTreeObserver().removeOnPreDrawListener(this);
                    return false;
                } catch (Throwable th) {
                    bq.a().c(th);
                    try {
                        if (RemoteMarketingTextView.this.mTitleView != null) {
                            RemoteMarketingTextView.this.mTitleView.getViewTreeObserver().removeOnPreDrawListener(this);
                        }
                    } catch (Throwable th2) {
                        bq.a().c(th2);
                    }
                    return false;
                }
            }
        });
    }

    public void setTextContentSize(float f) {
        if (this.mTitleView != null && this.mTitleSubView != null) {
            this.mTitleView.setTextSize(2, f);
            this.mTitleSubView.setTextSize(2, f);
        }
    }

    private void initView() {
        removeAllViews();
        this.mTitleView = new TextView(this.mContext);
        this.mTitleSubView = new TextView(this.mContext);
        this.mTitleView.setMaxLines(1);
        this.mTitleSubView.setMaxLines(this.mTextMaxLines > 1 ? this.mTextMaxLines - 1 : 1);
        this.mTitleView.setTextSize(2, this.mTextFontSizeSp);
        this.mTitleSubView.setTextSize(2, this.mTextFontSizeSp);
        this.mTitleView.setLineSpacing(this.mLineSpacingExtra, 1.0f);
        this.mTitleSubView.setLineSpacing(this.mLineSpacingExtra, 1.0f);
        if (this.mTextMaxLines == 1) {
            this.mTitleView.setEllipsize(this.mEllipsize);
        } else if (this.mEllipsize == TextUtils.TruncateAt.END) {
            this.mTitleSubView.setEllipsize(this.mEllipsize);
        }
        if (this.mTextFontColor != -1) {
            this.mTitleView.setTextColor(this.mTextFontColor);
            this.mTitleSubView.setTextColor(this.mTextFontColor);
        }
        if (this.mTextFontTypeFace != null) {
            this.mTitleView.setTypeface(this.mTextFontTypeFace);
            this.mTitleSubView.setTypeface(this.mTextFontTypeFace);
        }
        this.mTitleSubView.setVisibility(8);
        this.mTitleView.setGravity(16);
        this.mTitleSubView.setGravity(16);
        this.marketingLabel = new RemoteMarketingLabel(this.mContext);
        int fontMetricsInt = this.mTitleView.getPaint().getFontMetricsInt(null);
        if (this.mLabelFontSizeSp > 0) {
            this.marketingLabel.mLabelFontSizeSp = this.mLabelFontSizeSp;
        } else if (this.mTextFontSizeSp > 3) {
            int iC = ab.c(this.mContext, this.mTextFontSizeSp);
            this.marketingLabel.mLabelFontSizeSp = ab.d(this.mContext, iC - (fontMetricsInt - iC));
        }
        if (this.mLabelFontTypeFace != null) {
            this.marketingLabel.mLabelFontTypeFace = this.mLabelFontTypeFace;
        }
        this.marketingLabel.setVisibility(this.mLabelVisibility);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(0);
        linearLayout.setId(10001);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, fontMetricsInt);
        layoutParams.gravity = 16;
        linearLayout.addView(this.marketingLabel, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        if (this.mLabelVisibility != 8) {
            layoutParams2.leftMargin = ab.a(this.mContext, 2.0f);
        }
        linearLayout.addView(this.mTitleView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(10);
        addView(linearLayout, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = this.mLineSpacingExtra;
        layoutParams4.addRule(3, 10001);
        addView(this.mTitleSubView, layoutParams4);
    }

    public void setTextFontSizeSp(int i) {
        if (i > 0) {
            this.mTextFontSizeSp = i;
        }
        if (this.mTitleView != null && this.mTitleSubView != null) {
            this.mTitleView.setTextSize(2, this.mTextFontSizeSp);
            this.mTitleSubView.setTextSize(2, this.mTextFontSizeSp);
            if (this.marketingLabel != null) {
                int fontMetricsInt = this.mTitleView.getPaint().getFontMetricsInt(null);
                ViewGroup.LayoutParams layoutParams = this.marketingLabel.getLayoutParams();
                layoutParams.height = fontMetricsInt;
                this.marketingLabel.setLayoutParams(layoutParams);
            }
        }
    }

    public void setTextFontTypeFace(Typeface typeface) {
        if (typeface != null) {
            this.mTextFontTypeFace = typeface;
            if (this.mTitleView != null && this.mTitleSubView != null) {
                this.mTitleView.setTypeface(this.mTextFontTypeFace);
                this.mTitleSubView.setTypeface(this.mTextFontTypeFace);
            }
        }
    }

    public void setTextFontColor(int i) {
        this.mTextFontColor = i;
        if (this.mTitleView != null && this.mTitleSubView != null) {
            this.mTitleView.setTextColor(this.mTextFontColor);
            this.mTitleSubView.setTextColor(this.mTextFontColor);
        }
    }

    public void setTextMaxLines(int i) {
        this.mTextMaxLines = i;
        if (this.mTitleSubView != null) {
            this.mTitleSubView.setMaxLines(this.mTextMaxLines > 1 ? this.mTextMaxLines - 1 : 1);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.mEllipsize = truncateAt;
        if (this.mTextMaxLines == 1) {
            this.mTitleView.setEllipsize(this.mEllipsize);
        } else if (this.mEllipsize == TextUtils.TruncateAt.END) {
            this.mTitleSubView.setEllipsize(this.mEllipsize);
        }
    }

    public void setLineSpacingExtra(int i) {
        this.mLineSpacingExtra = i;
        if (this.mTitleView != null && this.mTitleSubView != null) {
            this.mTitleView.setLineSpacing(this.mLineSpacingExtra, 1.0f);
            this.mTitleSubView.setLineSpacing(this.mLineSpacingExtra, 1.0f);
        }
    }

    public void setLabelVisibility(int i) {
        this.mLabelVisibility = i;
        if (this.marketingLabel != null) {
            this.marketingLabel.setVisibility(i);
            if (i == 8 && this.mTitleView != null) {
                ViewGroup.LayoutParams layoutParams = this.marketingLabel.getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
                    this.mTitleView.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setLabelFontSizeSp(int i) {
        this.mLabelFontSizeSp = i;
        if (this.marketingLabel != null) {
            this.marketingLabel.setLabelFontSizeSp(i);
        }
    }

    public void setLabelFontTypeFace(Typeface typeface) {
        this.mLabelFontTypeFace = typeface;
        if (this.marketingLabel != null) {
            this.marketingLabel.setLabelFontTypeFace(typeface);
        }
    }

    public void setLabelFontUnderLine(int i) {
        if (this.marketingLabel != null) {
            this.marketingLabel.setLabelFontUnderLine(i);
        }
    }

    public void setTextFontUnderLine(int i) {
        if (this.mTitleView != null && this.mTitleSubView != null) {
            TextPaint paint = this.mTitleView.getPaint();
            if (paint != null && n.a(i)) {
                paint.setFlags(8);
            }
            TextPaint paint2 = this.mTitleSubView.getPaint();
            if (paint2 != null && n.a(i)) {
                paint2.setFlags(8);
            }
        }
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(f fVar) {
        this.mNativeLifeCycle = fVar;
    }

    @Override // com.component.a.c.c
    public f getLifeCycle() {
        return this.mNativeLifeCycle;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mNativeLifeCycle != null) {
            this.mNativeLifeCycle.a(this, z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.mNativeLifeCycle != null) {
            this.mNativeLifeCycle.a((View) this, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mNativeLifeCycle != null) {
            this.mNativeLifeCycle.e(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mNativeLifeCycle != null) {
            this.mNativeLifeCycle.f(this);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.mNativeLifeCycle != null) {
            this.mNativeLifeCycle.b(view, i);
        }
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(e eVar) {
        if (eVar != null) {
            applyViewTextInfo(eVar.g());
            applyViewBgInfo(eVar.h());
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.mNativeLifeCycle != null) {
            this.mNativeLifeCycle.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.mNativeLifeCycle != null) {
            this.mNativeLifeCycle.b(motionEvent, zOnTouchEvent);
        }
        return zOnTouchEvent;
    }

    public void applyViewTextInfo(e.i iVar) {
        if (iVar != null) {
            int iC = iVar.c(16);
            int iD = iVar.d(-16777216);
            int iE = iVar.e(0);
            int iF = iVar.f(0);
            Typeface typefaceA = n.a(iVar, 0);
            setTextFontColor(iD);
            setTextFontSizeSp(iC);
            setTextFontTypeFace(typefaceA);
            setTextFontUnderLine(iE);
            if (iF > 0) {
                setTextMaxLines(iF);
            }
            setEllipsize(getEllipsize(iVar.g(0)));
        }
    }

    public void applyViewBgInfo(e.f fVar) {
        Drawable drawableA = r.a(this.mContext, fVar);
        if (x.a(this.mContext).a() > 16) {
            setBackground(drawableA);
        } else {
            setBackgroundDrawable(drawableA);
        }
    }

    public void applyLabelTextInfo(e eVar) {
        e.i iVarG = eVar.g();
        e.f fVarH = eVar.h();
        setLabelFontSizeSp(this.mTextFontSizeSp - 5);
        setLabelFontTypeFace(n.a(iVarG, 0));
        setLabelFontUnderLine(iVarG.e(0));
        setMarketingLabelBorderWidth(fVarH.f(1));
        setMarketingLabelBorderColor(fVarH.e(Color.parseColor("#ff3300")));
    }

    private TextUtils.TruncateAt getEllipsize(int i) {
        if (1 == i) {
            return TextUtils.TruncateAt.START;
        }
        if (2 == i) {
            return TextUtils.TruncateAt.END;
        }
        if (3 == i) {
            return TextUtils.TruncateAt.MIDDLE;
        }
        if (4 == i) {
            return TextUtils.TruncateAt.MARQUEE;
        }
        return TextUtils.TruncateAt.END;
    }
}
