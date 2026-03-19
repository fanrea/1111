package com.kwai.video.ksliveplayer;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveTextureView extends FrameLayout implements TextureView.SurfaceTextureListener {
    private int mDegree;
    private int mScaleMode;
    private SurfaceTexture mSurfaceTexture;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private RenderTextureView mTextureView;
    private int mVideoHeight;
    private int mVideoWidth;

    public LiveTextureView(Context context) {
        super(context);
        this.mDegree = 0;
        this.mScaleMode = 1;
        initVideoView(context);
    }

    public LiveTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDegree = 0;
        this.mScaleMode = 1;
        initVideoView(context);
    }

    private void initVideoView(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.mTextureView = new RenderTextureView(context);
        this.mTextureView.setLayoutParams(layoutParams);
        this.mTextureView.setSurfaceTextureListener(this);
        addView(this.mTextureView);
        this.mTextureView.setVerticalOrientation(true);
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.mTextureView.setScaleMode(this.mScaleMode);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.mTextureView == null) {
            super.onMeasure(i, i2);
            return;
        }
        measureChildren(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (mode == 1073741824) {
                int measureHeight = this.mTextureView.getMeasureHeight();
                if ((this.mDegree / 90) % 2 != 0) {
                    measureHeight = this.mTextureView.getMeasureWidth();
                }
                if (measureHeight <= size2) {
                    size2 = measureHeight;
                }
            } else if (mode2 == 1073741824) {
                int measureWidth = this.mTextureView.getMeasureWidth();
                if ((this.mDegree / 90) % 2 != 0) {
                    measureWidth = this.mTextureView.getMeasureHeight();
                }
                if (measureWidth <= size) {
                    size = measureWidth;
                }
            } else {
                int measureWidth2 = this.mTextureView.getMeasureWidth();
                int measureHeight2 = this.mTextureView.getMeasureHeight();
                if ((this.mDegree / 90) % 2 != 0) {
                    int measureWidth3 = this.mTextureView.getMeasureWidth();
                    measureHeight2 = measureWidth3;
                    measureWidth2 = this.mTextureView.getMeasureHeight();
                }
                if (measureWidth2 <= size) {
                    size = measureWidth2;
                }
                if (measureHeight2 <= size2) {
                    size2 = measureHeight2;
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurfaceTexture = surfaceTexture;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
        requestLayout();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            return surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void setVideoScalingMode(int i) {
        RenderTextureView renderTextureView = this.mTextureView;
        if (renderTextureView != null) {
            this.mScaleMode = i;
            renderTextureView.setScaleMode(i);
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public float getVideoScaleRatio() {
        RenderTextureView renderTextureView = this.mTextureView;
        if (renderTextureView != null) {
            return renderTextureView.getVideoScaleRatio();
        }
        return 1.0f;
    }

    public void setVideoSize(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.mTextureView.setMeasureSize(i, i2);
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        this.mSurfaceTextureListener = surfaceTextureListener;
    }

    class RenderTextureView extends TextureView implements TextureView.SurfaceTextureListener {
        public static final int STATUS_NORMAL = 1;
        private int mCurrentDispStatus;
        private float mCurrentVideoHeight;
        private float mCurrentVideoWidth;
        private int mDegree;
        private float mHOffset;
        private int mLayoutHeight;
        private int mLayoutWidth;
        private TextureView.SurfaceTextureListener mListener;
        private Matrix mMatrix;
        private int mMeasureHeight;
        private int mMeasureWidth;
        private boolean mMirror;
        private int mScaleMode;
        private float mTotalRatio;
        private float mTotalTranslateX;
        private float mTotalTranslateY;
        boolean mUseSettingRatio;
        private float mVOffset;
        private boolean mVerticalOrientation;
        private int mVideoHeight;
        private int mVideoSarDen;
        private int mVideoSarNum;
        private int mVideoWidth;

        public RenderTextureView(Context context) {
            super(context);
            this.mUseSettingRatio = false;
            this.mScaleMode = 1;
            this.mMirror = false;
            this.mHOffset = 0.0f;
            this.mVOffset = 0.0f;
            this.mMatrix = new Matrix();
            this.mTotalRatio = 1.0f;
            this.mCurrentDispStatus = 1;
            super.setSurfaceTextureListener(this);
        }

        public RenderTextureView(LiveTextureView liveTextureView, Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public RenderTextureView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mUseSettingRatio = false;
            this.mScaleMode = 1;
            this.mMirror = false;
            this.mHOffset = 0.0f;
            this.mVOffset = 0.0f;
            this.mMatrix = new Matrix();
            this.mTotalRatio = 1.0f;
            this.mCurrentDispStatus = 1;
            super.setSurfaceTextureListener(this);
        }

        private void Normal(int i, int i2) {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            int i3;
            int i4;
            int i5 = this.mVideoWidth;
            int i6 = this.mVideoHeight;
            int i7 = this.mLayoutWidth;
            int i8 = this.mLayoutHeight;
            Matrix matrix = this.mMatrix;
            int i9 = this.mVideoSarNum;
            if (i9 > 0 && (i4 = this.mVideoSarDen) > 0) {
                i5 = (i5 * i9) / i4;
            }
            float f9 = i5 / this.mLayoutWidth;
            float f10 = i6 / this.mLayoutHeight;
            if ((this.mDegree / 90) % 2 != 0) {
                i6 = this.mVideoWidth;
                i5 = this.mVideoHeight;
                int i10 = this.mVideoSarNum;
                if (i10 > 0 && (i3 = this.mVideoSarDen) > 0) {
                    i6 = (i6 * i10) / i3;
                }
            }
            int i11 = this.mScaleMode;
            float fMin = 1.0f;
            float f11 = 0.0f;
            if (i11 != 1) {
                if (i11 == 2) {
                    fMin = Math.max(i7 / i5, i8 / i6);
                    this.mTotalRatio = fMin;
                } else if (i11 == 3) {
                    if ((this.mDegree / 90) % 2 != 0) {
                        float f12 = i8;
                        float f13 = i7;
                        f9 = f12 / f13;
                        f10 = f13 / f12;
                    } else {
                        f = 0.0f;
                        f2 = 0.0f;
                        f9 = 1.0f;
                        f10 = 1.0f;
                    }
                }
                f = 0.0f;
                f2 = 0.0f;
            } else {
                fMin = Math.min(i7 / i5, i8 / i6);
                f = this.mHOffset;
                f2 = this.mVOffset;
                this.mTotalRatio = fMin;
            }
            if ((this.mDegree / 90) % 2 != 0) {
                this.mCurrentVideoWidth = i8 * f10 * fMin;
                this.mCurrentVideoHeight = i7 * f9 * fMin;
            } else {
                this.mCurrentVideoWidth = i7 * f9 * fMin;
                this.mCurrentVideoHeight = i8 * f10 * fMin;
            }
            matrix.reset();
            matrix.postScale(fMin * f9, fMin * f10);
            matrix.postRotate(this.mDegree);
            int i12 = this.mDegree;
            if (i12 == -270) {
                f11 = (i7 + this.mCurrentVideoWidth) / 2.0f;
                f3 = i8;
                f4 = this.mCurrentVideoHeight;
            } else {
                if (i12 == -180) {
                    f11 = (i7 + this.mCurrentVideoWidth) / 2.0f;
                    f7 = i8;
                    f8 = this.mCurrentVideoHeight;
                } else if (i12 == -90) {
                    f11 = (i7 - this.mCurrentVideoWidth) / 2.0f;
                    f7 = i8;
                    f8 = this.mCurrentVideoHeight;
                } else if (i12 == 0) {
                    f11 = (i7 - this.mCurrentVideoWidth) / 2.0f;
                    f3 = i8;
                    f4 = this.mCurrentVideoHeight;
                } else {
                    f6 = 0.0f;
                    float f14 = i7;
                    this.mTotalTranslateX = f11 + ((f * f14) / 2.0f);
                    float f15 = i8;
                    this.mTotalTranslateY = f6 - ((f2 * f15) / 2.0f);
                    matrix.postTranslate(this.mTotalTranslateX, this.mTotalTranslateY);
                    this.mMeasureWidth = (int) (f14 * fMin * f9);
                    this.mMeasureHeight = (int) (f15 * fMin * f10);
                }
                f5 = f7 + f8;
                f6 = f5 / 2.0f;
                float f142 = i7;
                this.mTotalTranslateX = f11 + ((f * f142) / 2.0f);
                float f152 = i8;
                this.mTotalTranslateY = f6 - ((f2 * f152) / 2.0f);
                matrix.postTranslate(this.mTotalTranslateX, this.mTotalTranslateY);
                this.mMeasureWidth = (int) (f142 * fMin * f9);
                this.mMeasureHeight = (int) (f152 * fMin * f10);
            }
            f5 = f3 - f4;
            f6 = f5 / 2.0f;
            float f1422 = i7;
            this.mTotalTranslateX = f11 + ((f * f1422) / 2.0f);
            float f1522 = i8;
            this.mTotalTranslateY = f6 - ((f2 * f1522) / 2.0f);
            matrix.postTranslate(this.mTotalTranslateX, this.mTotalTranslateY);
            this.mMeasureWidth = (int) (f1422 * fMin * f9);
            this.mMeasureHeight = (int) (f1522 * fMin * f10);
        }

        private void Measure(int i, int i2) {
            if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            this.mLayoutWidth = size;
            this.mLayoutHeight = size2;
            if (this.mCurrentDispStatus == 1) {
                Normal(mode, mode2);
            }
            setTransform(this.mMatrix);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            Measure(i, i2);
            setMeasuredDimension(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i, i2);
            }
            requestLayout();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            }
            LiveTextureView.this.mTextureView.setScaleMode(this.mScaleMode);
            requestLayout();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mListener;
            if (surfaceTextureListener != null) {
                return surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
            }
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            TextureView.SurfaceTextureListener surfaceTextureListener = this.mListener;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
            }
        }

        @Override // android.view.TextureView
        public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
            this.mListener = surfaceTextureListener;
        }

        public void setMeasureSize(int i, int i2) {
            this.mVideoWidth = i;
            this.mVideoHeight = i2;
            requestLayout();
        }

        public void setScaleMode(int i) {
            this.mScaleMode = i;
            this.mUseSettingRatio = false;
            this.mCurrentDispStatus = 1;
            requestLayout();
        }

        public float getVideoScaleRatio() {
            return this.mTotalRatio;
        }

        public void setVerticalOrientation(boolean z) {
            this.mVerticalOrientation = z;
            this.mCurrentDispStatus = 1;
            requestLayout();
        }

        public int getMeasureWidth() {
            return this.mMeasureWidth;
        }

        public int getMeasureHeight() {
            return this.mMeasureHeight;
        }
    }
}
