package com.bytedance.sdk.djx.core.business.view.like;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXLikeLineView extends View {
    private static final float ARC_MAX_PRO = 0.3f;
    private static final float ARC_MAX_RADIUS = 20.0f;
    private static final int DOTS_COUNT = 6;
    private static final int OUTER_DOTS_POSITION_ANGLE = 60;
    private Bitmap arcBitmap;
    private Canvas arcCanvas;
    private float currentProgress;
    private float currentProgressArc;
    private float currentProgressMask;
    private int height;
    private int mLastSize;
    private final Paint mMaskPaint;
    private final Paint mPaint;
    private final Paint mPaintArc;
    private int mPaintColor;
    private final Path mPath;
    private final RectF mRectArc;
    private Bitmap tempBitmap;
    private Canvas tempCanvas;
    private int width;
    static final Property<DJXLikeLineView, Float> DOTS_PROGRESS = new Property<DJXLikeLineView, Float>(Float.class, "dotsProgress") { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeLineView.1
        @Override // android.util.Property
        public Float get(DJXLikeLineView dJXLikeLineView) {
            return Float.valueOf(dJXLikeLineView.getCurrentProgress());
        }

        @Override // android.util.Property
        public void set(DJXLikeLineView dJXLikeLineView, Float f) {
            dJXLikeLineView.setCurrentProgress(f.floatValue());
        }
    };
    static final Property<DJXLikeLineView, Float> DOTS_PROGRESS_MASK = new Property<DJXLikeLineView, Float>(Float.class, "dotsProgressMask") { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeLineView.2
        @Override // android.util.Property
        public Float get(DJXLikeLineView dJXLikeLineView) {
            return Float.valueOf(dJXLikeLineView.getCurrentProgressMask());
        }

        @Override // android.util.Property
        public void set(DJXLikeLineView dJXLikeLineView, Float f) {
            dJXLikeLineView.setCurrentProgressMask(f.floatValue());
        }
    };
    static final Property<DJXLikeLineView, Float> DOTS_PROGRESS_ARC = new Property<DJXLikeLineView, Float>(Float.class, "dotsProgressArc") { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeLineView.3
        @Override // android.util.Property
        public Float get(DJXLikeLineView dJXLikeLineView) {
            return Float.valueOf(dJXLikeLineView.getCurrentProgressArc());
        }

        @Override // android.util.Property
        public void set(DJXLikeLineView dJXLikeLineView, Float f) {
            dJXLikeLineView.setCurrentProgressArc(f.floatValue());
        }
    };

    public DJXLikeLineView(Context context) {
        super(context);
        this.mLastSize = -1;
        this.currentProgress = 0.0f;
        this.currentProgressMask = 0.0f;
        this.currentProgressArc = 0.0f;
        this.mPaint = new Paint();
        this.mMaskPaint = new Paint();
        this.mPath = new Path();
        this.mPaintArc = new Paint();
        this.mRectArc = new RectF();
        this.mPaintColor = Color.parseColor("#F62350");
        init();
    }

    public DJXLikeLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastSize = -1;
        this.currentProgress = 0.0f;
        this.currentProgressMask = 0.0f;
        this.currentProgressArc = 0.0f;
        this.mPaint = new Paint();
        this.mMaskPaint = new Paint();
        this.mPath = new Path();
        this.mPaintArc = new Paint();
        this.mRectArc = new RectF();
        this.mPaintColor = Color.parseColor("#F62350");
        init();
    }

    public DJXLikeLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastSize = -1;
        this.currentProgress = 0.0f;
        this.currentProgressMask = 0.0f;
        this.currentProgressArc = 0.0f;
        this.mPaint = new Paint();
        this.mMaskPaint = new Paint();
        this.mPath = new Path();
        this.mPaintArc = new Paint();
        this.mRectArc = new RectF();
        this.mPaintColor = Color.parseColor("#F62350");
        init();
    }

    private void init() {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setColor(this.mPaintColor);
        this.mPaintArc.setStyle(Paint.Style.STROKE);
        this.mPaintArc.setAntiAlias(true);
        this.mPaintArc.setStrokeWidth(1.0f);
        this.mPaintArc.setColor(this.mPaintColor);
        this.mMaskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mMaskPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int width = getWidth();
        boolean z = width != this.mLastSize;
        if (this.tempBitmap == null || this.tempCanvas == null || z) {
            this.tempBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_4444);
            this.tempCanvas = new Canvas(this.tempBitmap);
        }
        if (this.arcBitmap == null || this.arcCanvas == null || z) {
            this.arcBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_4444);
            this.arcCanvas = new Canvas(this.arcBitmap);
        }
        this.mLastSize = width;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            drawLines(canvas);
        } catch (Throwable unused) {
        }
        try {
            drawArc(canvas);
        } catch (Throwable unused2) {
        }
    }

    private void drawLines(Canvas canvas) {
        int i;
        int i2;
        float f;
        this.tempCanvas.drawColor(16777215, PorterDuff.Mode.CLEAR);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f2 = width;
        float f3 = 0.8f * f2;
        float f4 = this.currentProgress * f3;
        float f5 = this.currentProgressMask * f3;
        int i3 = 0;
        while (i3 < 8) {
            try {
                this.mPath.reset();
                this.tempCanvas.rotate(i3 * (-60), f2, height);
                double d = width;
                double d2 = f5;
                float f6 = f4;
                double d3 = height;
                try {
                    this.mPath.moveTo((float) ((Math.cos(-4.71238898038469d) * d2) + d), (float) (d3 - (d2 * Math.sin(-4.71238898038469d))));
                    f = f6;
                    double d4 = f;
                    try {
                        i = width;
                        i2 = height;
                        double dCos = d + (Math.cos(-1.5184364492350666d) * d4);
                        try {
                            double dSin = (Math.sin(-1.5184364492350666d) * d4) + d3;
                            double dCos2 = d + (Math.cos(-1.6231562043547263d) * d4);
                            double dSin2 = d3 + (d4 * Math.sin(-1.6231562043547263d));
                            this.mPath.lineTo((float) dCos, (float) dSin);
                            this.mPath.lineTo((float) dCos2, (float) dSin2);
                            this.tempCanvas.drawPath(this.mPath, this.mPaint);
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable unused2) {
                        i = width;
                        i2 = height;
                    }
                } catch (Throwable unused3) {
                    i = width;
                    i2 = height;
                    f = f6;
                }
            } catch (Throwable unused4) {
                i = width;
                i2 = height;
                f = f4;
            }
            i3++;
            f4 = f;
            width = i;
            height = i2;
        }
        if (this.currentProgressMask >= 1.0f) {
            this.tempCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        canvas.drawBitmap(this.tempBitmap, 0.0f, 0.0f, (Paint) null);
    }

    private void drawArc(Canvas canvas) {
        this.arcCanvas.drawColor(16777215, PorterDuff.Mode.CLEAR);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f = width;
        float f2 = 0.8f * f * this.currentProgressArc;
        float f3 = height;
        this.mRectArc.set(f - f2, f3 - f2, f + f2, f3 + f2);
        float f4 = this.currentProgressArc;
        if (f4 < ARC_MAX_PRO) {
            this.mPaintArc.setStrokeWidth(ARC_MAX_RADIUS);
        } else {
            this.mPaintArc.setStrokeWidth((1.0f - ((f4 - ARC_MAX_PRO) / 0.7f)) * ARC_MAX_RADIUS);
        }
        this.arcCanvas.drawArc(this.mRectArc, 0.0f, 360.0f, false, this.mPaintArc);
        if (this.currentProgressArc >= 1.0f) {
            this.arcCanvas.drawColor(16777215, PorterDuff.Mode.CLEAR);
        }
        canvas.drawBitmap(this.arcBitmap, 0.0f, 0.0f, (Paint) null);
    }

    public void setCurrentProgress(float f) {
        this.currentProgress = f;
        postInvalidate();
    }

    public float getCurrentProgress() {
        return this.currentProgress;
    }

    public float getCurrentProgressMask() {
        return this.currentProgressMask;
    }

    public void setCurrentProgressMask(float f) {
        this.currentProgressMask = f;
        postInvalidate();
    }

    public float getCurrentProgressArc() {
        return this.currentProgressArc;
    }

    public void setCurrentProgressArc(float f) {
        this.currentProgressArc = f;
        postInvalidate();
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
        requestLayout();
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int i4 = this.width;
        if (i4 == 0 || (i3 = this.height) == 0) {
            return;
        }
        setMeasuredDimension(i4, i3);
    }

    public void setPaintColor(int i) {
        this.mPaintColor = i;
        this.mPaint.setColor(i);
        this.mPaintArc.setColor(i);
    }
}
