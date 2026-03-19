package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsSeekBar extends SeekBar {
    private String Xr;
    private int Xx;
    protected Drawable alj;
    protected Drawable alk;
    protected Drawable all;
    protected Drawable alm;
    protected Drawable aln;
    private int alo;
    private Paint alp;
    private boolean alq;
    private boolean alr;
    private boolean als;
    private boolean alt;
    private boolean alu;
    private SeekBar.OnSeekBarChangeListener alv;

    public KsSeekBar(Context context) {
        this(context, null, 0);
    }

    public KsSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsSeekBar(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.alo = -1;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_SeekBar);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_SeekBar_ksad_SeekBarBackground, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_SeekBar_ksad_SeekBarProgress, 0);
        int color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_SeekBar_ksad_SeekBarSecondProgress, 0);
        int color4 = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_SeekBar_ksad_SeekBarProgressTextColor, 0);
        this.alq = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_SeekBar_ksad_SeekBarDisplayProgressText, false);
        this.alr = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_SeekBar_ksad_SeekBarLimitProgressText100, true);
        this.alu = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_SeekBar_ksad_SeekBarShowProgressText, false);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_SeekBar_ksad_SeekBarProgressTextSize, 0);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_SeekBar_ksad_SeekBarProgressTextMargin, context.getResources().getDimensionPixelOffset(R.dimen.ksad_seek_bar_progress_text_margin));
        this.Xx = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_SeekBar_ksad_SeekBarPaddingLeft, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_SeekBar_ksad_SeekBarPaddingRight, 0);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_SeekBar_ksad_SeekBarPaddingTop, 0);
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_SeekBar_ksad_SeekBarPaddingBottom, 0);
        float dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_SeekBar_ksad_SeekBarProgressTextSize, 0);
        if (this.alq) {
            Paint paint = new Paint(1);
            this.alp = paint;
            paint.setTextSize(dimensionPixelSize);
            Paint paint2 = this.alp;
            if (color4 == 0) {
                color4 = color2;
            }
            paint2.setColor(color4);
        }
        setProgressDrawable(a(color, color2, color3, dimensionPixelSize6));
        try {
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_SeekBar_ksad_SeekBarThumb);
            this.alj = drawable;
            if (drawable == null) {
                this.alj = getResources().getDrawable(R.drawable.ksad_seekbar_btn_slider);
            }
        } catch (Exception unused) {
            this.alj = getResources().getDrawable(R.drawable.ksad_seekbar_btn_slider);
        }
        this.alm = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_SeekBar_ksad_SeekBarDefaultIndicator);
        this.aln = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_SeekBar_ksad_SeekBarDefaultIndicatorPass);
        setThumb(this.alj);
        int intrinsicWidth = this.Xx + (this.alj.getIntrinsicWidth() / 2);
        if (this.alq) {
            dimensionPixelSize4 += dimensionPixelSize2 + dimensionPixelSize;
        }
        setPadding(intrinsicWidth, dimensionPixelSize4, dimensionPixelSize3 + (this.alj.getIntrinsicWidth() / 2), dimensionPixelSize5);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnSeekBarChangeListener(new a());
    }

    @Override // android.view.View
    public void setEnabled(boolean z) throws Resources.NotFoundException {
        super.setEnabled(z);
        if (z) {
            Drawable drawable = this.all;
            if (drawable == null) {
                drawable = getResources().getDrawable(R.drawable.ksad_seekbar_btn_slider);
            }
            this.alj = drawable;
        } else {
            Drawable drawable2 = this.alk;
            if (drawable2 == null) {
                drawable2 = getResources().getDrawable(R.drawable.ksad_seekbar_btn_slider_gray);
            }
            this.alj = drawable2;
        }
        setThumb(this.alj);
        postInvalidate();
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.alv = onSeekBarChangeListener;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        String strValueOf;
        int progress;
        if ((this.alq && this.als) || this.alt || this.alu) {
            this.alt = false;
            if (TextUtils.isEmpty(this.Xr)) {
                if (getMax() < 100 || !this.alr) {
                    progress = getProgress();
                } else {
                    progress = (getProgress() * 100) / getMax();
                }
                strValueOf = String.valueOf(progress);
            } else {
                strValueOf = this.Xr;
            }
            canvas.drawText(strValueOf, this.alj.getBounds().left + ((this.alj.getIntrinsicWidth() - this.alp.measureText(strValueOf)) / 2.0f) + this.Xx, this.alp.getTextSize(), this.alp);
        }
        super.onDraw(canvas);
        c(canvas);
    }

    private void c(Canvas canvas) {
        int i;
        Drawable drawable;
        if (this.alm == null || (i = this.alo) < 0 || i > getMax()) {
            return;
        }
        if (getProgress() <= this.alo || (drawable = this.aln) == null) {
            drawable = this.alm;
        }
        drawable.setVisible(true, true);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = this.alm.getIntrinsicWidth() / 2;
        int intrinsicHeight = this.alm.getIntrinsicHeight() / 2;
        drawable.setBounds((getPaddingLeft() - intrinsicWidth) + ((this.alo * width) / getMax()), (getPaddingTop() - intrinsicHeight) + (this.alj.getIntrinsicWidth() / 2), getPaddingLeft() + intrinsicWidth + ((width * this.alo) / getMax()), getPaddingTop() + intrinsicHeight + (this.alj.getIntrinsicWidth() / 2));
        drawable.draw(canvas);
    }

    private static Drawable a(int i, int i2, int i3, float f) {
        RectF rectF = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        float[] fArr = {f, f, f, f, f, f, f, f};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, rectF, fArr));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(fArr, rectF, fArr));
        shapeDrawable2.getPaint().setColor(i2);
        shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
        ClipDrawable clipDrawable = new ClipDrawable(shapeDrawable2, 3, 1);
        if (i3 != 0) {
            ShapeDrawable shapeDrawable3 = new ShapeDrawable(new RoundRectShape(fArr, rectF, fArr));
            shapeDrawable3.getPaint().setColor(i3);
            shapeDrawable3.getPaint().setStyle(Paint.Style.FILL);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, new ClipDrawable(shapeDrawable3, 3, 1), clipDrawable});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{shapeDrawable, clipDrawable});
        layerDrawable2.setId(0, android.R.id.background);
        layerDrawable2.setId(1, android.R.id.progress);
        return layerDrawable2;
    }

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (KsSeekBar.this.alv != null) {
                KsSeekBar.this.alv.onProgressChanged(seekBar, i, z);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            KsSeekBar.this.als = true;
            if (KsSeekBar.this.alv != null) {
                KsSeekBar.this.alv.onStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            KsSeekBar.this.als = false;
            if (KsSeekBar.this.alv != null) {
                KsSeekBar.this.alv.onStopTrackingTouch(seekBar);
            }
        }
    }

    public Paint getProgressTextPaint() {
        return this.alp;
    }

    public void setDefaultIndicatorProgress(int i) {
        this.alo = i;
        invalidate();
    }

    public int getDefaultIndicatorProgress() {
        return this.alo;
    }
}
