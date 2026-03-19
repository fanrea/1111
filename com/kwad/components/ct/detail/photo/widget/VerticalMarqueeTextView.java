package com.kwad.components.ct.detail.photo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class VerticalMarqueeTextView extends ScrollView {
    private static final String TAG = "com.kwad.components.ct.detail.photo.widget.VerticalMarqueeTextView";
    private boolean axA;
    private int axB;
    private TextView axw;
    private int axx;
    private boolean axy;
    private boolean axz;
    private Handler handler;

    public VerticalMarqueeTextView(Context context) {
        super(context);
        init(context, null);
    }

    public VerticalMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public VerticalMarqueeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public CharSequence getText() {
        return this.axw.getText();
    }

    public void setText(CharSequence charSequence) {
        this.axw.setText(charSequence);
    }

    public int getMarqueeSpeed() {
        return this.axx;
    }

    public void setMarqueeSpeed(int i) {
        this.axx = Math.min(1000, Math.max(1, i));
    }

    private void BT() {
        this.axy = true;
        this.axz = false;
        if (this.axA) {
            return;
        }
        this.axA = true;
        new Thread(new Runnable() { // from class: com.kwad.components.ct.detail.photo.widget.VerticalMarqueeTextView.1
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                VerticalMarqueeTextView.this.BU();
            }
        }).start();
    }

    public final void BB() {
        this.axy = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.axy) {
            BT();
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.axz = true;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = this.axw.getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.handler = new Handler(Looper.getMainLooper());
        this.axB = Math.round(getResources().getDisplayMetrics().density);
        TextView textView = new TextView(context);
        this.axw = textView;
        textView.setGravity(17);
        addView(this.axw, new ViewGroup.LayoutParams(-1, -1));
        this.axw.scrollTo(0, -getHeight());
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(30);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsVerticalMarqueeTextView, 0, 0);
            this.axw.setText(typedArrayObtainStyledAttributes.getText(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_text));
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_text, 0);
            if (resourceId > 0) {
                this.axw.setText(typedArrayObtainStyledAttributes.getText(resourceId));
            }
            this.axw.setTextColor(Color.parseColor("#FFFFFF"));
            if (typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_textColor, 0) > 0) {
                this.axw.setTextColor(Color.parseColor("#FFFFFF"));
            }
            float dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_textSize, 0.0f);
            if (dimension > 0.0f) {
                this.axw.setTextSize(dimension);
            }
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_textSize, 0);
            if (resourceId2 > 0) {
                this.axw.setTextSize(context.getResources().getDimension(resourceId2));
            }
            int i = typedArrayObtainStyledAttributes.getInt(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_typeface, 0);
            this.axw.setTypeface(i == 1 ? Typeface.SANS_SERIF : i == 2 ? Typeface.SERIF : i == 3 ? Typeface.MONOSPACE : Typeface.DEFAULT, typedArrayObtainStyledAttributes.getInt(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_textStyle, 0));
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_textAppearance, 0);
            if (resourceId3 > 0) {
                this.axw.setTextAppearance(context, resourceId3);
            }
            setMarqueeSpeed(typedArrayObtainStyledAttributes.getInt(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_marqueeSpeed, 0));
            int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_marqueeSpeed, 0);
            if (resourceId4 > 0) {
                setMarqueeSpeed(context.getResources().getInteger(resourceId4));
            }
            if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KsVerticalMarqueeTextView_ksad_marqueeSpeed, true)) {
                this.axy = true;
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU() throws InterruptedException {
        a aVar = new a(this.axw);
        long j = 0;
        while (this.axy && !this.axz) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis >= j) {
                this.handler.post(aVar);
                j = jCurrentTimeMillis + ((long) (1000.0d / this.axx));
            }
            try {
                Thread.sleep((long) (1000.0d / this.axx));
            } catch (InterruptedException unused) {
            }
        }
        this.axA = false;
    }

    final class a implements Runnable {
        private final ViewGroup axD;
        private final TextView axw;

        public a(TextView textView) {
            this.axD = (ViewGroup) textView.getParent();
            this.axw = textView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int iC = c(this.axw);
            int height = this.axD.getHeight();
            if (iC <= 0 || height <= 0 || iC <= height) {
                return;
            }
            if (this.axw.getScrollY() < iC) {
                this.axw.scrollBy(0, VerticalMarqueeTextView.this.axB);
            } else {
                this.axw.scrollTo(0, -height);
            }
            this.axw.invalidate();
        }

        private static int c(TextView textView) {
            if (textView.getLineCount() > 0) {
                return textView.getLineHeight() * textView.getLineCount();
            }
            return 0;
        }
    }
}
