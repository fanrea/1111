package com.luck.lib.camerax.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.luck.lib.camerax.CustomCameraConfig;
import com.luck.lib.camerax.listener.CaptureListener;
import com.luck.lib.camerax.listener.IObtainCameraView;
import com.luck.lib.camerax.permissions.PermissionChecker;
import com.luck.lib.camerax.permissions.PermissionResultCallback;
import com.luck.lib.camerax.permissions.SimpleXPermissionUtil;
import com.luck.lib.camerax.utils.DoubleUtils;
import com.luck.lib.camerax.utils.SimpleXSpUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CaptureButton extends View {
    public static final int STATE_BAN = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDER_ING = 4;
    private final Activity activity;
    private int buttonState;
    private float button_inside_radius;
    private float button_outside_radius;
    private float button_radius;
    private int button_size;
    private CaptureListener captureListener;
    private float center_X;
    private float center_Y;
    private int currentRecordedTime;
    private float event_Y;
    private int inside_reduce_size;
    private boolean isTakeCamera;
    private LongPressRunnable longPressRunnable;
    private Paint mPaint;
    private int maxDuration;
    private int minDuration;
    private int outside_add_size;
    private float progress;
    private int progressColor;
    private RectF rectF;
    private int state;
    private float strokeWidth;
    private RecordCountDownTimer timer;

    public CaptureButton(Context context) {
        super(context);
        this.progressColor = -300503530;
        this.isTakeCamera = true;
        this.activity = (Activity) context;
    }

    public CaptureButton(Context context, int i) {
        super(context);
        this.progressColor = -300503530;
        this.isTakeCamera = true;
        this.activity = (Activity) context;
        this.button_size = i;
        float f = i / 2.0f;
        this.button_radius = f;
        this.button_outside_radius = f;
        this.button_inside_radius = f * 0.75f;
        this.strokeWidth = i / 15;
        int i2 = i / 8;
        this.outside_add_size = i2;
        this.inside_reduce_size = i2;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.progress = 0.0f;
        this.longPressRunnable = new LongPressRunnable();
        this.state = 1;
        this.buttonState = 0;
        this.maxDuration = CustomCameraConfig.DEFAULT_MAX_RECORD_VIDEO;
        this.minDuration = 1500;
        int i3 = this.button_size;
        int i4 = this.outside_add_size;
        this.center_X = ((i4 * 2) + i3) / 2;
        this.center_Y = (i3 + (i4 * 2)) / 2;
        float f2 = this.center_X;
        float f3 = this.button_radius;
        int i5 = this.outside_add_size;
        float f4 = this.strokeWidth;
        float f5 = this.center_Y;
        this.rectF = new RectF(f2 - ((i5 + f3) - (f4 / 2.0f)), f5 - ((i5 + f3) - (f4 / 2.0f)), f2 + ((i5 + f3) - (f4 / 2.0f)), f5 + ((f3 + i5) - (f4 / 2.0f)));
        this.timer = new RecordCountDownTimer(this.maxDuration, r15 / 360);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.button_size;
        int i4 = this.outside_add_size;
        setMeasuredDimension((i4 * 2) + i3, i3 + (i4 * 2));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-287515428);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_outside_radius, this.mPaint);
        this.mPaint.setColor(-1);
        canvas.drawCircle(this.center_X, this.center_Y, this.button_inside_radius, this.mPaint);
        if (this.state == 4) {
            this.mPaint.setColor(this.progressColor);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            canvas.drawArc(this.rectF, -90.0f, this.progress, false, this.mPaint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        CaptureListener captureListener;
        int i;
        if (this.isTakeCamera) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    handlerPressByState();
                } else if (action == 2 && (captureListener = this.captureListener) != null && this.state == 4 && ((i = this.buttonState) == 2 || i == 0)) {
                    captureListener.recordZoom(this.event_Y - motionEvent.getY());
                }
            } else if (motionEvent.getPointerCount() <= 1 && this.state == 1) {
                this.event_Y = motionEvent.getY();
                this.state = 2;
                if (this.buttonState != 1) {
                    postDelayed(this.longPressRunnable, 500L);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getCustomCameraView() {
        ComponentCallbacks2 componentCallbacks2 = this.activity;
        if (componentCallbacks2 instanceof IObtainCameraView) {
            return ((IObtainCameraView) componentCallbacks2).getCustomCameraView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerPressByState() {
        int i;
        removeCallbacks(this.longPressRunnable);
        int i2 = this.state;
        if (i2 == 2) {
            if (this.captureListener != null && ((i = this.buttonState) == 1 || i == 0)) {
                startCaptureAnimation(this.button_inside_radius);
            } else {
                this.state = 1;
            }
        } else if ((i2 == 3 || i2 == 4) && PermissionChecker.checkSelfPermission(getContext(), new String[]{PermissionUtils.PERMISSION_RECORD_AUDIO})) {
            this.timer.cancel();
            recordEnd();
        }
        this.state = 1;
    }

    public void recordEnd() {
        CaptureListener captureListener = this.captureListener;
        if (captureListener != null) {
            int i = this.currentRecordedTime;
            if (i < this.minDuration) {
                captureListener.recordShort(i);
            } else {
                captureListener.recordEnd(i);
            }
        }
        resetRecordAnim();
    }

    private void resetRecordAnim() {
        this.state = 5;
        this.progress = 0.0f;
        invalidate();
        float f = this.button_outside_radius;
        float f2 = this.button_radius;
        startRecordAnimation(f, f2, this.button_inside_radius, 0.75f * f2);
    }

    private void startCaptureAnimation(float f) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.75f * f, f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.luck.lib.camerax.widget.CaptureButton$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m468x48e37b0c(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.luck.lib.camerax.widget.CaptureButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (CaptureButton.this.captureListener != null) {
                    CaptureButton.this.captureListener.takePictures();
                }
                CaptureButton.this.state = 5;
            }
        });
        valueAnimatorOfFloat.setDuration(50L);
        valueAnimatorOfFloat.start();
    }

    /* renamed from: lambda$startCaptureAnimation$0$com-luck-lib-camerax-widget-CaptureButton, reason: not valid java name */
    /* synthetic */ void m468x48e37b0c(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecordAnimation(float f, float f2, float f3, float f4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f3, f4);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.luck.lib.camerax.widget.CaptureButton$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m469x1d05dd38(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.luck.lib.camerax.widget.CaptureButton$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m470x2474bf9(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.luck.lib.camerax.widget.CaptureButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (DoubleUtils.isFastDoubleClick()) {
                    return;
                }
                if (CaptureButton.this.state == 3) {
                    if (CaptureButton.this.captureListener != null) {
                        CaptureButton.this.captureListener.recordStart();
                    }
                    CaptureButton.this.state = 4;
                    CaptureButton.this.timer.start();
                    return;
                }
                CaptureButton.this.state = 1;
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    /* renamed from: lambda$startRecordAnimation$1$com-luck-lib-camerax-widget-CaptureButton, reason: not valid java name */
    /* synthetic */ void m469x1d05dd38(ValueAnimator valueAnimator) {
        this.button_outside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* renamed from: lambda$startRecordAnimation$2$com-luck-lib-camerax-widget-CaptureButton, reason: not valid java name */
    /* synthetic */ void m470x2474bf9(ValueAnimator valueAnimator) {
        this.button_inside_radius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j) {
        int i = this.maxDuration;
        this.currentRecordedTime = (int) (i - j);
        this.progress = 360.0f - ((j / i) * 360.0f);
        invalidate();
        CaptureListener captureListener = this.captureListener;
        if (captureListener != null) {
            captureListener.changeTime(j);
        }
    }

    private class RecordCountDownTimer extends CountDownTimer {
        RecordCountDownTimer(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            CaptureButton.this.updateProgress(j);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CaptureButton.this.recordEnd();
        }
    }

    private class LongPressRunnable implements Runnable {
        private LongPressRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CaptureButton.this.state = 3;
            if (!PermissionChecker.checkSelfPermission(CaptureButton.this.getContext(), new String[]{PermissionUtils.PERMISSION_RECORD_AUDIO})) {
                CaptureButton.this.onExplainCallback();
                CaptureButton.this.handlerPressByState();
                PermissionChecker.getInstance().requestPermissions(CaptureButton.this.activity, new String[]{PermissionUtils.PERMISSION_RECORD_AUDIO}, new PermissionResultCallback() { // from class: com.luck.lib.camerax.widget.CaptureButton.LongPressRunnable.1
                    @Override // com.luck.lib.camerax.permissions.PermissionResultCallback
                    public void onGranted() {
                        CaptureButton.this.postDelayed(CaptureButton.this.longPressRunnable, 500L);
                        ViewGroup customCameraView = CaptureButton.this.getCustomCameraView();
                        if (customCameraView == null || CustomCameraConfig.explainListener == null) {
                            return;
                        }
                        CustomCameraConfig.explainListener.onDismiss(customCameraView);
                    }

                    @Override // com.luck.lib.camerax.permissions.PermissionResultCallback
                    public void onDenied() {
                        if (CustomCameraConfig.deniedListener == null) {
                            SimpleXPermissionUtil.goIntentSetting(CaptureButton.this.activity, 1103);
                            return;
                        }
                        SimpleXSpUtils.putBoolean(CaptureButton.this.getContext(), PermissionUtils.PERMISSION_RECORD_AUDIO, true);
                        CustomCameraConfig.deniedListener.onDenied(CaptureButton.this.getContext(), PermissionUtils.PERMISSION_RECORD_AUDIO, 1103);
                        ViewGroup customCameraView = CaptureButton.this.getCustomCameraView();
                        if (customCameraView == null || CustomCameraConfig.explainListener == null) {
                            return;
                        }
                        CustomCameraConfig.explainListener.onDismiss(customCameraView);
                    }
                });
            } else {
                CaptureButton captureButton = CaptureButton.this;
                captureButton.startRecordAnimation(captureButton.button_outside_radius, CaptureButton.this.button_outside_radius + CaptureButton.this.outside_add_size, CaptureButton.this.button_inside_radius, CaptureButton.this.button_inside_radius - CaptureButton.this.inside_reduce_size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExplainCallback() {
        ViewGroup customCameraView;
        if (CustomCameraConfig.explainListener == null || SimpleXSpUtils.getBoolean(getContext(), PermissionUtils.PERMISSION_RECORD_AUDIO, false) || (customCameraView = getCustomCameraView()) == null) {
            return;
        }
        CustomCameraConfig.explainListener.onPermissionDescription(getContext(), customCameraView, PermissionUtils.PERMISSION_RECORD_AUDIO);
    }

    public void setMaxDuration(int i) {
        this.maxDuration = i;
        this.timer = new RecordCountDownTimer(this.maxDuration, r0 / 360);
    }

    public void setMinDuration(int i) {
        this.minDuration = i;
    }

    public void setCaptureListener(CaptureListener captureListener) {
        this.captureListener = captureListener;
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
    }

    public void setButtonFeatures(int i) {
        this.buttonState = i;
    }

    public int getButtonFeatures() {
        return this.buttonState;
    }

    public boolean isIdle() {
        return this.state == 1;
    }

    public void setButtonCaptureEnabled(boolean z) {
        this.isTakeCamera = z;
    }

    public void resetState() {
        this.state = 1;
    }
}
