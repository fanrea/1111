package com.kwai.player.vr;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.kwai.player.vr.KwaiVR;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiGestureHelper {
    private static final int MODE_INIT = 0;
    private static final int MODE_PINCH = 1;
    private static final String TAG = "KwaiGestureHelperf";
    private static final float mDamping = 0.2f;
    private static final float mDensity = Resources.getSystem().getDisplayMetrics().density;
    private KwaiVR.IAdvanceGestureListener mAdvanceGestureListener;
    private GestureDetector mGestureDetector;
    private ValueAnimator valueAnimator;
    private int mCurrentMode = 0;
    private PinchInfo mPinchInfo = new PinchInfo();
    private boolean mGestureEnabled = false;
    private boolean mPinchEnabled = false;
    private float minScale = 1.0f;
    private float maxScale = 4.0f;
    private float mSensitivity = 1.0f;
    private float defaultScale = 1.0f;
    private float mGlobalScale = 1.0f;
    private float mTouchSensitivity = 1.0f;
    private float mPreDistanceX = 0.0f;
    private float mPreDistanceY = 0.0f;
    private boolean mFlingEnabled = true;
    private KwaiFlingConfig mFlingConfig = new KwaiFlingConfig();

    public KwaiGestureHelper(Context context) {
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.kwai.player.vr.KwaiGestureHelper.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return KwaiGestureHelper.this.mCurrentMode != 1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (KwaiGestureHelper.this.mCurrentMode == 1) {
                    return false;
                }
                KwaiGestureHelper kwaiGestureHelper = KwaiGestureHelper.this;
                kwaiGestureHelper.onDrag(kwaiGestureHelper.scaled(f), KwaiGestureHelper.this.scaled(f2));
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (KwaiGestureHelper.this.mCurrentMode == 1 || !KwaiGestureHelper.this.mFlingEnabled) {
                    return false;
                }
                KwaiGestureHelper.this.animStart(f, f2);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float scaled(float f) {
        return (f / this.mGlobalScale) * this.mTouchSensitivity;
    }

    private void animCancel() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animStart(float f, float f2) {
        animCancel();
        ValueAnimator duration = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("vx", f, 0.0f), PropertyValuesHolder.ofFloat("vy", f2, 0.0f)).setDuration(this.mFlingConfig.getDuring());
        this.valueAnimator = duration;
        duration.setInterpolator(this.mFlingConfig.getInterpolator());
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwai.player.vr.KwaiGestureHelper.2
            private long lastTime = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                long currentPlayTime = valueAnimator.getCurrentPlayTime();
                float f3 = currentPlayTime - this.lastTime;
                float fFloatValue = ((((Float) valueAnimator.getAnimatedValue("vx")).floatValue() * f3) / (-1000.0f)) * KwaiGestureHelper.this.mFlingConfig.getSensitivity();
                float fFloatValue2 = ((((Float) valueAnimator.getAnimatedValue("vy")).floatValue() * f3) / (-1000.0f)) * KwaiGestureHelper.this.mFlingConfig.getSensitivity();
                this.lastTime = currentPlayTime;
                KwaiGestureHelper kwaiGestureHelper = KwaiGestureHelper.this;
                kwaiGestureHelper.onDrag(kwaiGestureHelper.scaled(fFloatValue), KwaiGestureHelper.this.scaled(fFloatValue2));
            }
        });
        this.valueAnimator.start();
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            this.mCurrentMode = 0;
        } else if (action == 6) {
            if (this.mCurrentMode == 1 && motionEvent.getPointerCount() > 2) {
                if ((motionEvent.getAction() >> 8) == 0) {
                    markPinchInfo(motionEvent.getX(1), motionEvent.getY(1), motionEvent.getX(2), motionEvent.getY(2));
                } else if ((motionEvent.getAction() >> 8) == 1) {
                    markPinchInfo(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(2), motionEvent.getY(2));
                }
            }
        } else if (action == 5) {
            this.mCurrentMode = 1;
            markPinchInfo(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
        } else if (action == 2) {
            if (this.mCurrentMode == 1 && motionEvent.getPointerCount() > 1) {
                handlePinch(calDistance(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1)));
            }
        } else if (action == 0) {
            animCancel();
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public void scaleTo(float f) {
        setScaleInner(this.mPinchInfo.setScale(f));
    }

    public void reset() {
        setScaleInner(this.mPinchInfo.reset());
    }

    private void handlePinch(float f) {
        if (this.mPinchEnabled) {
            setScaleInner(this.mPinchInfo.pinch(f));
        }
    }

    private void setScaleInner(float f) {
        KwaiVR.IAdvanceGestureListener iAdvanceGestureListener = this.mAdvanceGestureListener;
        if (iAdvanceGestureListener != null) {
            iAdvanceGestureListener.onPinch(f);
        }
        this.mGlobalScale = f;
    }

    private void markPinchInfo(float f, float f2, float f3, float f4) {
        this.mPinchInfo.mark(f, f2, f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float calDistance(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow(f - f3, 2.0d) + Math.pow(f2 - f4, 2.0d));
    }

    public void setAdvanceGestureListener(KwaiVR.IAdvanceGestureListener iAdvanceGestureListener) {
        this.mAdvanceGestureListener = iAdvanceGestureListener;
    }

    public boolean isPinchEnabled() {
        return this.mPinchEnabled;
    }

    public void setPinchEnabled(boolean z) {
        this.mPinchEnabled = z;
    }

    public boolean isGestureEnabled() {
        return this.mGestureEnabled;
    }

    public void setGestureEnabled(boolean z) {
        this.mGestureEnabled = z;
    }

    public boolean isFlingEnabled() {
        return this.mFlingEnabled;
    }

    public void setFlingEnabled(boolean z) {
        this.mFlingEnabled = z;
    }

    public void setTouchSensitivity(float f) {
        this.mTouchSensitivity = f;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    class PinchInfo {
        private float currentScale;
        private float oDistance;
        private float prevScale;
        private float x1;
        private float x2;
        private float y1;
        private float y2;

        private PinchInfo() {
        }

        public void mark(float f, float f2, float f3, float f4) {
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
            this.oDistance = KwaiGestureHelper.calDistance(f, f2, f3, f4);
            this.prevScale = this.currentScale;
        }

        public float pinch(float f) {
            if (this.oDistance == 0.0f) {
                this.oDistance = f;
            }
            float f2 = this.prevScale + (((f / this.oDistance) - 1.0f) * KwaiGestureHelper.this.mSensitivity * 3.0f);
            this.currentScale = f2;
            float fMax = Math.max(f2, KwaiGestureHelper.this.minScale);
            this.currentScale = fMax;
            float fMin = Math.min(fMax, KwaiGestureHelper.this.maxScale);
            this.currentScale = fMin;
            return fMin;
        }

        public float setScale(float f) {
            this.prevScale = f;
            this.currentScale = f;
            return f;
        }

        public float reset() {
            return setScale(KwaiGestureHelper.this.defaultScale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDrag(float f, float f2) {
        if (this.mGestureEnabled) {
            float f3 = this.mPreDistanceX;
            float f4 = mDensity;
            float f5 = f3 - ((f / f4) * 0.2f);
            float f6 = this.mPreDistanceY - ((f2 / f4) * 0.2f);
            KwaiVR.IAdvanceGestureListener iAdvanceGestureListener = this.mAdvanceGestureListener;
            if (iAdvanceGestureListener != null) {
                iAdvanceGestureListener.onDrag(f5, f6);
            }
            this.mPreDistanceX = f5;
            this.mPreDistanceY = f6;
        }
    }
}
