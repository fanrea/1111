package com.bytedance.sdk.djx.core.business.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.WeakHandler;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXPeriscopeLayout extends FrameLayout implements WeakHandler.IHandler {
    private int curIndex;
    private int dHeight;
    private int dWidth;
    private Drawable[] drawables;
    private boolean isRtl;
    private FrameLayout.LayoutParams lp;
    private int mCycle;
    private int mDuration;
    private final WeakHandler mHandler;
    private int mHeight;
    private Queue<ImageView> mImageViews;
    private final Runnable mRunnable;
    private int mWidth;
    private final Random random;

    public void handleMsg(Message message) {
    }

    public DJXPeriscopeLayout(Context context) throws Resources.NotFoundException {
        super(context);
        this.random = new Random();
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mRunnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXPeriscopeLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DJXPeriscopeLayout.this.showView();
                if (DJXPeriscopeLayout.this.mHandler != null) {
                    DJXPeriscopeLayout.this.mHandler.postDelayed(this, DJXPeriscopeLayout.this.mCycle);
                }
            }
        };
        this.curIndex = 0;
        init();
    }

    public DJXPeriscopeLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.random = new Random();
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mRunnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXPeriscopeLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DJXPeriscopeLayout.this.showView();
                if (DJXPeriscopeLayout.this.mHandler != null) {
                    DJXPeriscopeLayout.this.mHandler.postDelayed(this, DJXPeriscopeLayout.this.mCycle);
                }
            }
        };
        this.curIndex = 0;
        init();
    }

    public DJXPeriscopeLayout(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.random = new Random();
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mRunnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXPeriscopeLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DJXPeriscopeLayout.this.showView();
                if (DJXPeriscopeLayout.this.mHandler != null) {
                    DJXPeriscopeLayout.this.mHandler.postDelayed(this, DJXPeriscopeLayout.this.mCycle);
                }
            }
        };
        this.curIndex = 0;
        init();
    }

    public DJXPeriscopeLayout(Context context, AttributeSet attributeSet, int i, int i2) throws Resources.NotFoundException {
        super(context, attributeSet, i, i2);
        this.random = new Random();
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mRunnable = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXPeriscopeLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DJXPeriscopeLayout.this.showView();
                if (DJXPeriscopeLayout.this.mHandler != null) {
                    DJXPeriscopeLayout.this.mHandler.postDelayed(this, DJXPeriscopeLayout.this.mCycle);
                }
            }
        };
        this.curIndex = 0;
        init();
    }

    private void init() throws Resources.NotFoundException {
        this.mImageViews = new LinkedList();
        this.drawables = new Drawable[3];
        Drawable drawable = getResources().getDrawable(R.drawable.djx_music_note1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.djx_music_note2);
        Drawable drawable3 = getResources().getDrawable(R.drawable.djx_music_note3);
        Drawable[] drawableArr = this.drawables;
        drawableArr[0] = drawable;
        drawableArr[1] = drawable2;
        drawableArr[2] = drawable3;
        this.dHeight = drawable.getIntrinsicHeight();
        this.dWidth = drawable.getIntrinsicWidth();
        this.lp = new FrameLayout.LayoutParams(this.dWidth * 2, this.dHeight * 2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.isRtl = ViewCompat.getLayoutDirection(this) == 1;
    }

    private ImageView obtainImage() {
        if (this.mImageViews.isEmpty()) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(this.lp);
            addView(imageView);
            return imageView;
        }
        return this.mImageViews.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleView(View view) {
        BezierListener bezierListener;
        if (view == null || view.getTag() == null) {
            return;
        }
        this.mImageViews.add((ImageView) view);
        ValueAnimator valueAnimator = (ValueAnimator) view.getTag();
        if (valueAnimator != null) {
            valueAnimator.setTarget(null);
            valueAnimator.cancel();
            valueAnimator.removeAllListeners();
            valueAnimator.removeAllUpdateListeners();
        }
        if ((view.getTag(R.id.djx_id_draw_video_music) instanceof BezierListener) && (bezierListener = (BezierListener) view.getTag(R.id.djx_id_draw_video_music)) != null) {
            bezierListener.setTarget(null);
        }
        view.setAlpha(0.0f);
        view.setScaleX(0.3f);
        view.setScaleY(0.3f);
        view.setRotation(0.0f);
        view.setTag(null);
    }

    private void recycleAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            recycleView(getChildAt(i));
        }
    }

    public void showView() {
        ImageView imageViewObtainImage = obtainImage();
        Drawable[] drawableArr = this.drawables;
        int i = this.curIndex;
        this.curIndex = i + 1;
        imageViewObtainImage.setImageDrawable(drawableArr[i % 3]);
        ValueAnimator bezierValueAnimator = getBezierValueAnimator(imageViewObtainImage);
        imageViewObtainImage.setTag(bezierValueAnimator);
        bezierValueAnimator.start();
    }

    public void showView(int i, int i2) {
        this.mDuration = i2;
        startTimer(i);
    }

    public void pause() {
        stopTimer();
        this.mHandler.removeCallbacks(this.mRunnable);
        recycleAllViews();
    }

    public void stop() {
        recycleAllViews();
        stopTimer();
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    private void startTimer(int i) {
        this.mCycle = i;
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mHandler.postDelayed(this.mRunnable, this.random.nextInt(4) * 100);
    }

    private void stopTimer() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    private Animator getAnimator(View view) {
        ValueAnimator bezierValueAnimator = getBezierValueAnimator(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(bezierValueAnimator);
        animatorSet.setTarget(view);
        return animatorSet;
    }

    private ValueAnimator getBezierValueAnimator(View view) {
        float fDp2px;
        float fDp2px2 = UIUtil.dp2px(48.0f);
        float fDp2px3 = UIUtil.dp2px(20.0f);
        float fDp2px4 = UIUtil.dp2px(20.0f);
        if (this.isRtl) {
            int i = this.mWidth;
            fDp2px2 = (i - fDp2px2) - fDp2px4;
            fDp2px3 = (i - fDp2px3) - fDp2px4;
        }
        BezierEvaluator bezierEvaluator = new BezierEvaluator(new PointF(fDp2px2, (this.mHeight - this.dHeight) - UIUtil.dp2px(8.0f)), new PointF(fDp2px3, UIUtil.dp2px(51.0f)));
        Object[] objArr = new Object[2];
        objArr[0] = new PointF(this.isRtl ? this.dWidth - fDp2px4 : this.mWidth - this.dWidth, (this.mHeight - this.dHeight) - UIUtil.dp2px(2.0f));
        if (this.isRtl) {
            fDp2px = (this.mWidth - fDp2px4) - UIUtil.dp2px(this.random.nextInt(30) + 12);
        } else {
            fDp2px = UIUtil.dp2px(this.random.nextInt(30) + 12);
        }
        objArr[1] = new PointF(fDp2px, 0.0f);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(bezierEvaluator, objArr);
        BezierListener bezierListener = new BezierListener(view);
        valueAnimatorOfObject.addUpdateListener(bezierListener);
        valueAnimatorOfObject.setTarget(view);
        view.setTag(R.id.djx_id_draw_video_music, bezierListener);
        valueAnimatorOfObject.setDuration(this.mDuration);
        return valueAnimatorOfObject;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    private class BezierListener implements ValueAnimator.AnimatorUpdateListener {
        private final int rotation1;
        private final int rotation2;
        private View target;
        private final float MAX_SCALE = 0.6f;
        private final float MAX_ALPHA = 0.9f;

        public BezierListener(View view) {
            this.target = view;
            this.rotation1 = DJXPeriscopeLayout.this.random.nextBoolean() ? 1 : -1;
            this.rotation2 = DJXPeriscopeLayout.this.random.nextBoolean() ? 1 : -1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                View view = this.target;
                if (view != null && view.getTag() != null) {
                    PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                    this.target.setX(pointF.x);
                    this.target.setY(pointF.y);
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    if (animatedFraction <= 0.7f) {
                        float f = animatedFraction / 0.7f;
                        this.target.setAlpha(0.9f * f);
                        float f2 = (f * 0.3f) + 0.3f;
                        this.target.setScaleX(f2);
                        this.target.setScaleY(f2);
                    } else if (animatedFraction <= 0.8d) {
                        this.target.setAlpha(0.9f);
                        this.target.setScaleX(0.6f);
                        this.target.setScaleY(0.6f);
                    } else if (animatedFraction <= 1.0f) {
                        float f3 = (animatedFraction - 0.8f) / 0.2f;
                        this.target.setAlpha((1.0f - f3) * 0.9f);
                        float f4 = (f3 * 0.1f) + 0.6f;
                        this.target.setScaleX(f4);
                        this.target.setScaleY(f4);
                        if (1.0f - animatedFraction < 1.0E-10d) {
                            DJXPeriscopeLayout.this.recycleView(this.target);
                            return;
                        }
                    }
                    if (animatedFraction <= 0.5f) {
                        this.target.setRotation((animatedFraction / 0.5f) * 20.0f * this.rotation1);
                    } else {
                        this.target.setRotation((((animatedFraction - 0.5f) / 0.5f) * 20.0f * this.rotation2) + (this.rotation1 * 20));
                    }
                }
            } catch (Throwable unused) {
            }
        }

        public void setTarget(View view) {
            this.target = view;
        }
    }
}
