package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXExpandableTextView extends TextView {
    public static String DEFAULT_TEXT_CONTRACT = "收起";
    public static String DEFAULT_TEXT_EXPAND = "展开";
    public static final String NEW_LINE_CHAR = "\n";
    private boolean mAttached;
    private String mContractText;
    private int mContractTextColor;
    private int mCurrentLines;
    private String mExpandText;
    private int mExpandTextColor;
    private boolean mHideLabel;
    private Layout mLayout;
    private float mLineY;
    private int mMaxContractLines;
    private boolean mMeasured;
    private TextPaint mPaint;
    private String mRawContent;
    private int mTotalLineCount;
    private int mViewWidth;
    private int mWidth;
    private OnLineCountListener onLineCountListener;
    private int retryTime;

    public interface OnLineCountListener {
        void onLineCount(int i, boolean z);
    }

    public enum StatusType {
        EXPAND,
        CONTRACT
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 1.0f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public DJXExpandableTextView(Context context) {
        super(context);
        this.retryTime = 0;
        initView(context, null);
    }

    public DJXExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.retryTime = 0;
        init(context, attributeSet);
    }

    public DJXExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.retryTime = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        initView(context, attributeSet);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXExpandableTextView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (!DJXExpandableTextView.this.mAttached) {
                    DJXExpandableTextView.this.setContentInternalPre();
                }
                DJXExpandableTextView.this.mAttached = true;
            }
        });
    }

    private void initView(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DJXExpandableTextView);
            this.mMaxContractLines = typedArrayObtainStyledAttributes.getInt(R.styleable.DJXExpandableTextView_djx_contract_max_lines, 5);
            this.mHideLabel = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXExpandableTextView_djx_hide_label, false);
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.DJXExpandableTextView_djx_contract_text);
            this.mContractText = string;
            if (TextUtils.isEmpty(string)) {
                this.mContractText = DEFAULT_TEXT_CONTRACT;
            }
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.DJXExpandableTextView_djx_expand_text);
            this.mExpandText = string2;
            if (TextUtils.isEmpty(string2)) {
                this.mExpandText = DEFAULT_TEXT_EXPAND;
            }
            this.mExpandTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DJXExpandableTextView_djx_expand_color, -1);
            this.mContractTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.DJXExpandableTextView_djx_contract_color, Color.parseColor("#999999"));
            this.mCurrentLines = this.mMaxContractLines;
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mPaint = getPaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentInternal(CharSequence charSequence) {
        int i;
        String str;
        StaticLayout staticLayout = new StaticLayout(charSequence, this.mPaint, this.mWidth, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0.0f, true);
        this.mLayout = staticLayout;
        int lineCount = staticLayout.getLineCount();
        this.mTotalLineCount = lineCount;
        int i2 = this.mCurrentLines - 1;
        int i3 = lineCount - 1;
        String str2 = String.format(Locale.getDefault(), "  %s", this.mContractText);
        String str3 = String.format(Locale.getDefault(), "  %s", this.mExpandText);
        OnLineCountListener onLineCountListener = this.onLineCountListener;
        if (onLineCountListener != null) {
            int i4 = this.mTotalLineCount;
            onLineCountListener.onLineCount(i4, i4 > this.mMaxContractLines);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (canExpand()) {
            int i5 = this.mCurrentLines;
            int i6 = this.mTotalLineCount;
            if (i5 >= i6) {
                i2 = i3;
            }
            if (i5 >= i6) {
                int i7 = this.mContractTextColor;
                String str4 = this.mContractText;
                spannableStringBuilder.append((CharSequence) charSequence.toString());
                i = i7;
                str = str4;
            } else {
                int i8 = this.mExpandTextColor;
                String str5 = this.mExpandText;
                String strSubstring = charSequence.toString().substring(0, getRightIndex(str3, this.mLayout.getLineEnd(i2), this.mLayout.getLineStart(i2), this.mLayout.getLineWidth(i2), this.mPaint.measureText(str3)));
                if (strSubstring.endsWith("\n")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                }
                spannableStringBuilder.append((CharSequence) strSubstring);
                if (this.mHideLabel) {
                    spannableStringBuilder.append((CharSequence) "...");
                }
                str2 = str3;
                i = i8;
                str = str5;
            }
            setEndLabel(this.mHideLabel, str2, str, i, spannableStringBuilder);
        } else {
            spannableStringBuilder.append((CharSequence) charSequence.toString());
        }
        setHighlightColor(0);
        setText(spannableStringBuilder.toString());
    }

    private void setEndLabel(boolean z, String str, String str2, final int i, SpannableStringBuilder spannableStringBuilder) {
        if (z) {
            return;
        }
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.bytedance.sdk.djx.core.business.view.DJXExpandableTextView.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                DJXExpandableTextView.this.action();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(i);
                textPaint.setUnderlineText(false);
            }
        }, spannableStringBuilder.length() - str2.length(), spannableStringBuilder.length(), 17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(getCurrentTextColor());
        this.mPaint.setLetterSpacing(0.0f);
        this.mPaint.drawableState = getDrawableState();
        this.mViewWidth = getMeasuredWidth();
        String string = getText().toString();
        this.mLineY = 0.0f;
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        float measuredHeight = (getMeasuredHeight() * 1.0f) / layout.getLineCount();
        this.mLineY = getTextSize();
        for (int i = 0; i < layout.getLineCount(); i++) {
            String strSubstring = string.substring(layout.getLineStart(i), layout.getLineEnd(i));
            if (i < layout.getLineCount() - 1) {
                if (needScale(strSubstring)) {
                    float fMeasureText = ((this.mWidth - this.mPaint.measureText(strSubstring)) / (strSubstring.length() - 1)) / this.mPaint.getTextSize();
                    this.mPaint.setLetterSpacing(fMeasureText);
                    canvas.save();
                    canvas.translate(((-fMeasureText) * this.mPaint.getTextSize()) / 2.0f, 0.0f);
                    canvas.drawText(strSubstring, 0.0f, this.mLineY + getPaddingTop(), this.mPaint);
                    canvas.restore();
                    this.mPaint.setLetterSpacing(0.0f);
                } else {
                    canvas.drawText(strSubstring, 0.0f, this.mLineY, this.mPaint);
                }
            } else {
                canvas.drawText(strSubstring, 0.0f, this.mLineY, this.mPaint);
            }
            this.mLineY += measuredHeight;
        }
    }

    private boolean needScale(String str) {
        return (str == null || str.length() == 0 || str.charAt(str.length() - 1) == '\n') ? false : true;
    }

    public void setRawContent(String str) {
        this.mRawContent = str;
        if (this.mAttached) {
            setContentInternalPre();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentInternalPre() {
        if (this.mRawContent == null) {
            return;
        }
        this.mCurrentLines = this.mMaxContractLines;
        if (this.mWidth <= 0) {
            this.mWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        if (this.mWidth <= 0) {
            setText(" ");
            post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXExpandableTextView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (DJXExpandableTextView.this.mWidth <= 0) {
                        DJXExpandableTextView dJXExpandableTextView = DJXExpandableTextView.this;
                        dJXExpandableTextView.mWidth = (dJXExpandableTextView.getWidth() - DJXExpandableTextView.this.getPaddingLeft()) - DJXExpandableTextView.this.getPaddingRight();
                    }
                    DJXExpandableTextView dJXExpandableTextView2 = DJXExpandableTextView.this;
                    dJXExpandableTextView2.setContentInternal(dJXExpandableTextView2.mRawContent);
                }
            });
        } else {
            setContentInternal(this.mRawContent);
        }
    }

    public StatusType getStatus() {
        if (this.mCurrentLines < this.mTotalLineCount) {
            return StatusType.CONTRACT;
        }
        return StatusType.EXPAND;
    }

    public boolean canExpand() {
        return this.mMaxContractLines < this.mTotalLineCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void action() {
        action(null);
    }

    public void action(StatusType statusType) {
        boolean z = this.mCurrentLines < this.mTotalLineCount;
        if (statusType == getStatus()) {
            return;
        }
        if (z) {
            this.mCurrentLines = this.mTotalLineCount;
        } else {
            this.mCurrentLines = this.mMaxContractLines;
        }
        setContentInternal(this.mRawContent);
    }

    private int getRightIndex(String str, int i, int i2, float f, float f2) {
        for (int i3 = i; i3 > i2; i3--) {
            if (this.mPaint.measureText(this.mRawContent.substring(i2, i3)) <= f - f2) {
                return i3;
            }
        }
        return i;
    }

    public OnLineCountListener getOnLineCountListener() {
        return this.onLineCountListener;
    }

    public void setOnLineCountListener(OnLineCountListener onLineCountListener) {
        this.onLineCountListener = onLineCountListener;
    }
}
