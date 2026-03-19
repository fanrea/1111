package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ZoomImageView extends AppCompatImageView {
    private boolean isAutoScale;
    private boolean isCanDrag;
    private boolean isCheckLeftAndRight;
    private boolean isCheckTopAndBottom;
    private Context mContext;
    private GestureDetector mGestureDetector;
    private float mInitScale;
    private int mLastPointerCount;
    private float mLastX;
    private float mLastY;
    private float mMaxScale;
    private float mMidScale;
    private View.OnClickListener mOnClickListener;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private View.OnLongClickListener mOnLongClickListener;
    private boolean mOnce;
    private ScaleGestureDetector mScaleGestureDetector;
    private Matrix mScaleMatrix;
    private int mTouchSlop;

    public ZoomImageView(Context context) {
        this(context, null);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initLoad(context);
        initListener();
    }

    private void initListener() {
        this.mScaleGestureDetector = new ScaleGestureDetector(this.mContext, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.fendasz.moku.planet.ui.customview.ZoomImageView.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scale = ZoomImageView.this.getScale();
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (ZoomImageView.this.getDrawable() == null) {
                    return true;
                }
                if ((scale < ZoomImageView.this.mMaxScale && scaleFactor > 1.0f) || (scale > ZoomImageView.this.mInitScale && scaleFactor < 1.0f)) {
                    if (scale * scaleFactor < ZoomImageView.this.mInitScale) {
                        scaleFactor = ZoomImageView.this.mInitScale / scale;
                    }
                    if (scale * scaleFactor > ZoomImageView.this.mMaxScale) {
                        scaleFactor = ZoomImageView.this.mMaxScale / scale;
                    }
                    ZoomImageView.this.mScaleMatrix.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    ZoomImageView.this.checkBorderAndCenterWhenScale();
                    ZoomImageView zoomImageView = ZoomImageView.this;
                    zoomImageView.setImageMatrix(zoomImageView.mScaleMatrix);
                }
                return true;
            }
        });
        this.mGestureDetector = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener() { // from class: com.fendasz.moku.planet.ui.customview.ZoomImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (ZoomImageView.this.isAutoScale) {
                    return true;
                }
                ZoomImageView.this.postDelayed(ZoomImageView.this.new AutoScaleRunnable(ZoomImageView.this.getScale() < ZoomImageView.this.mMidScale ? ZoomImageView.this.mMidScale : ZoomImageView.this.mInitScale, motionEvent.getX(), motionEvent.getY()), 16L);
                ZoomImageView.this.isAutoScale = true;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (ZoomImageView.this.mOnLongClickListener != null) {
                    ZoomImageView.this.mOnLongClickListener.onLongClick(ZoomImageView.this);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (ZoomImageView.this.mOnClickListener == null) {
                    return false;
                }
                ZoomImageView.this.mOnClickListener.onClick(ZoomImageView.this);
                return true;
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.customview.ZoomImageView.3
            /* JADX WARN: Removed duplicated region for block: B:47:0x013d  */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
                /*
                    Method dump skipped, instructions count: 385
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.ui.customview.ZoomImageView.AnonymousClass3.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    private void initLoad(Context context) {
        this.mContext = context;
        this.mScaleMatrix = new Matrix();
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
    }

    private class AutoScaleRunnable implements Runnable {
        private final float BIGGER = 1.07f;
        private final float SMALL = 0.93f;
        private float mTargetScale;
        private float tmpScale;
        private float x;
        private float y;

        AutoScaleRunnable(float f, float f2, float f3) {
            this.mTargetScale = f;
            this.x = f2;
            this.y = f3;
            if (ZoomImageView.this.getScale() < f) {
                this.tmpScale = 1.07f;
            }
            if (ZoomImageView.this.getScale() > f) {
                this.tmpScale = 0.93f;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = ZoomImageView.this.mScaleMatrix;
            float f = this.tmpScale;
            matrix.postScale(f, f, this.x, this.y);
            ZoomImageView.this.checkBorderAndCenterWhenScale();
            ZoomImageView zoomImageView = ZoomImageView.this;
            zoomImageView.setImageMatrix(zoomImageView.mScaleMatrix);
            float scale = ZoomImageView.this.getScale();
            float f2 = this.tmpScale;
            if ((f2 > 1.0f && scale < this.mTargetScale) || (f2 < 1.0f && scale > this.mTargetScale)) {
                ZoomImageView.this.postDelayed(this, 16L);
                return;
            }
            float f3 = this.mTargetScale / scale;
            ZoomImageView.this.mScaleMatrix.postScale(f3, f3, this.x, this.y);
            ZoomImageView.this.checkBorderAndCenterWhenScale();
            ZoomImageView zoomImageView2 = ZoomImageView.this;
            zoomImageView2.setImageMatrix(zoomImageView2.mScaleMatrix);
            ZoomImageView.this.isAutoScale = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.fendasz.moku.planet.ui.customview.ZoomImageView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ZoomImageView.this.mOnce) {
                    return;
                }
                int width = ZoomImageView.this.getWidth();
                int height = ZoomImageView.this.getHeight();
                Drawable drawable = ZoomImageView.this.getDrawable();
                if (drawable == null) {
                    return;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > width && intrinsicHeight > height) {
                    Math.min((width * 1.0f) / intrinsicWidth, (height * 1.0f) / intrinsicHeight);
                }
                if (intrinsicWidth < width && intrinsicHeight < height) {
                    Math.min((width * 1.0f) / intrinsicWidth, (height * 1.0f) / intrinsicHeight);
                }
                float f = intrinsicHeight;
                float f2 = intrinsicWidth;
                float f3 = height * 1.0f;
                float f4 = width;
                ZoomImageView.this.mInitScale = (f * 1.0f) / f2 > f3 / f4 ? f3 / f : (f4 * 1.0f) / f2;
                ZoomImageView zoomImageView = ZoomImageView.this;
                zoomImageView.mMaxScale = zoomImageView.mInitScale * 4.0f;
                ZoomImageView zoomImageView2 = ZoomImageView.this;
                zoomImageView2.mMidScale = zoomImageView2.mInitScale * 2.0f;
                ZoomImageView.this.mScaleMatrix.postTranslate((ZoomImageView.this.getWidth() / 2) - (intrinsicWidth / 2), (ZoomImageView.this.getHeight() / 2) - (intrinsicHeight / 2));
                ZoomImageView.this.mScaleMatrix.postScale(ZoomImageView.this.mInitScale, ZoomImageView.this.mInitScale, width / 2, height / 2);
                ZoomImageView zoomImageView3 = ZoomImageView.this;
                zoomImageView3.setImageMatrix(zoomImageView3.mScaleMatrix);
                ZoomImageView.this.mOnce = true;
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    public float getScale() {
        float[] fArr = new float[9];
        this.mScaleMatrix.getValues(fArr);
        return fArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getMatrixRectF() {
        Matrix matrix = this.mScaleMatrix;
        RectF rectF = new RectF();
        if (getDrawable() != null) {
            rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBorderAndCenterWhenScale() {
        float fWidth;
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        float f = width;
        if (matrixRectF.width() >= f) {
            fWidth = matrixRectF.left > 0.0f ? -matrixRectF.left : 0.0f;
            if (matrixRectF.right < f) {
                fWidth = f - matrixRectF.right;
            }
        } else {
            fWidth = 0.0f;
        }
        float f2 = height;
        if (matrixRectF.height() >= f2) {
            fHeight = matrixRectF.top > 0.0f ? -matrixRectF.top : 0.0f;
            if (matrixRectF.bottom < f2) {
                fHeight = f2 - matrixRectF.bottom;
            }
        }
        if (matrixRectF.width() < f) {
            fWidth = (matrixRectF.width() / 2.0f) + ((f / 2.0f) - matrixRectF.right);
        }
        if (matrixRectF.height() < f2) {
            fHeight = ((f2 / 2.0f) - matrixRectF.bottom) + (matrixRectF.height() / 2.0f);
        }
        this.mScaleMatrix.postTranslate(fWidth, fHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBorderWhenTranslate() {
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        float f = 0.0f;
        float f2 = (matrixRectF.top <= 0.0f || !this.isCheckTopAndBottom) ? 0.0f : -matrixRectF.top;
        float f3 = height;
        if (matrixRectF.bottom < f3 && this.isCheckTopAndBottom) {
            f2 = f3 - matrixRectF.bottom;
        }
        if (matrixRectF.left > 0.0f && this.isCheckLeftAndRight) {
            f = -matrixRectF.left;
        }
        float f4 = width;
        if (matrixRectF.right < f4 && this.isCheckLeftAndRight) {
            f = f4 - matrixRectF.right;
        }
        this.mScaleMatrix.postTranslate(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMoveAction(float f, float f2) {
        return Math.sqrt((double) ((f * f) + (f2 * f2))) > ((double) this.mTouchSlop);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
