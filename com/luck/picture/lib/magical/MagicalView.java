package com.luck.picture.lib.magical;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.DensityUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MagicalView extends FrameLayout {
    private final long animationDuration;
    private final int appInScreenHeight;
    private final View backgroundView;
    private final FrameLayout contentLayout;
    private boolean isAnimating;
    private final boolean isPreviewFullScreenMode;
    private float mAlpha;
    private int mOriginHeight;
    private int mOriginLeft;
    private int mOriginTop;
    private int mOriginWidth;
    private final MagicalViewWrapper magicalWrapper;
    private OnMagicalViewCallback onMagicalViewCallback;
    private int realHeight;
    private int realWidth;
    private int screenHeight;
    private int screenWidth;
    private final SelectorConfig selectorConfig;
    private int startX;
    private int startY;
    private int targetEndLeft;
    private int targetImageHeight;
    private int targetImageTop;
    private int targetImageWidth;

    public MagicalView(Context context) {
        this(context, null);
    }

    public MagicalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MagicalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAlpha = 0.0f;
        this.animationDuration = 250L;
        this.isAnimating = false;
        SelectorConfig selectorConfig = SelectorProviders.getInstance().getSelectorConfig();
        this.selectorConfig = selectorConfig;
        this.isPreviewFullScreenMode = selectorConfig.isPreviewFullScreenMode;
        this.appInScreenHeight = DensityUtil.getRealScreenHeight(getContext());
        getScreenSize();
        View view = new View(context);
        this.backgroundView = view;
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setAlpha(this.mAlpha);
        addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        this.contentLayout = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        this.magicalWrapper = new MagicalViewWrapper(frameLayout);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundView.setBackgroundColor(i);
    }

    public void startNormal(int i, int i2, boolean z) {
        this.realWidth = i;
        this.realHeight = i2;
        this.mOriginLeft = 0;
        this.mOriginTop = 0;
        this.mOriginWidth = 0;
        this.mOriginHeight = 0;
        setVisibility(0);
        setOriginParams();
        showNormalMin(this.targetImageTop, this.targetEndLeft, this.targetImageWidth, this.targetImageHeight);
        if (z) {
            this.mAlpha = 1.0f;
            this.backgroundView.setAlpha(1.0f);
        } else {
            this.mAlpha = 0.0f;
            this.backgroundView.setAlpha(0.0f);
            this.contentLayout.setAlpha(0.0f);
            this.contentLayout.animate().alpha(1.0f).setDuration(250L).start();
            this.backgroundView.animate().alpha(1.0f).setDuration(250L).start();
        }
        setShowEndParams();
    }

    public void start(boolean z) {
        float f;
        if (z) {
            f = 1.0f;
            this.mAlpha = 1.0f;
        } else {
            f = 0.0f;
        }
        this.mAlpha = f;
        this.backgroundView.setAlpha(f);
        setVisibility(0);
        setOriginParams();
        beginShow(z);
    }

    public void resetStart() {
        getScreenSize();
        start(true);
    }

    private void getScreenSize() {
        this.screenWidth = DensityUtil.getRealScreenWidth(getContext());
        if (this.isPreviewFullScreenMode) {
            this.screenHeight = DensityUtil.getRealScreenHeight(getContext());
        } else {
            this.screenHeight = DensityUtil.getScreenHeight(getContext());
        }
    }

    public void changeRealScreenHeight(int i, int i2, boolean z) {
        int i3;
        int i4;
        if (this.isPreviewFullScreenMode || (i3 = this.screenWidth) > (i4 = this.screenHeight)) {
            return;
        }
        if (((int) (i3 / (i / i2))) > i4) {
            this.screenHeight = this.appInScreenHeight;
            if (z) {
                this.magicalWrapper.setWidth(i3);
                this.magicalWrapper.setHeight(this.screenHeight);
            }
        }
    }

    public void resetStartNormal(int i, int i2, boolean z) {
        getScreenSize();
        startNormal(i, i2, z);
    }

    public void setViewParams(int i, int i2, int i3, int i4, int i5, int i6) {
        this.realWidth = i5;
        this.realHeight = i6;
        this.mOriginLeft = i;
        this.mOriginTop = i2;
        this.mOriginWidth = i3;
        this.mOriginHeight = i4;
    }

    private void setOriginParams() {
        this.contentLayout.getLocationOnScreen(new int[2]);
        this.targetEndLeft = 0;
        int i = this.screenWidth;
        int i2 = this.screenHeight;
        float f = i / i2;
        int i3 = this.realWidth;
        int i4 = this.realHeight;
        if (f < i3 / i4) {
            this.targetImageWidth = i;
            int i5 = (int) (i * (i4 / i3));
            this.targetImageHeight = i5;
            this.targetImageTop = (i2 - i5) / 2;
        } else {
            this.targetImageHeight = i2;
            int i6 = (int) (i2 * (i3 / i4));
            this.targetImageWidth = i6;
            this.targetImageTop = 0;
            this.targetEndLeft = (i - i6) / 2;
        }
        this.magicalWrapper.setWidth(this.mOriginWidth);
        this.magicalWrapper.setHeight(this.mOriginHeight);
        this.magicalWrapper.setMarginLeft(this.mOriginLeft);
        this.magicalWrapper.setMarginTop(this.mOriginTop);
    }

    private void beginShow(boolean z) {
        Interpolator interpolatorNewInterpolator;
        if (z) {
            this.mAlpha = 1.0f;
            this.backgroundView.setAlpha(1.0f);
            showNormalMin(this.targetImageTop, this.targetEndLeft, this.targetImageWidth, this.targetImageHeight);
            setShowEndParams();
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.luck.picture.lib.magical.MagicalView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView.this.showNormalMin(fFloatValue, r0.mOriginTop, MagicalView.this.targetImageTop, MagicalView.this.mOriginLeft, MagicalView.this.targetEndLeft, MagicalView.this.mOriginWidth, MagicalView.this.targetImageWidth, MagicalView.this.mOriginHeight, MagicalView.this.targetImageHeight);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.magical.MagicalView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MagicalView.this.setShowEndParams();
            }
        });
        if (this.selectorConfig.interpolatorFactory != null && (interpolatorNewInterpolator = this.selectorConfig.interpolatorFactory.newInterpolator()) != null) {
            valueAnimatorOfFloat.setInterpolator(interpolatorNewInterpolator);
        }
        valueAnimatorOfFloat.setDuration(250L).start();
        changeBackgroundViewAlpha(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowEndParams() {
        this.isAnimating = false;
        changeContentViewToFullscreen();
        OnMagicalViewCallback onMagicalViewCallback = this.onMagicalViewCallback;
        if (onMagicalViewCallback != null) {
            onMagicalViewCallback.onBeginMagicalAnimComplete(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalMin(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        showNormalMin(false, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    private void showNormalMin(float f, float f2, float f3, float f4) {
        showNormalMin(true, 0.0f, 0.0f, f, 0.0f, f2, 0.0f, f3, 0.0f, f4);
    }

    private void showNormalMin(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (z) {
            this.magicalWrapper.setWidth(f7);
            this.magicalWrapper.setHeight(f9);
            this.magicalWrapper.setMarginLeft((int) f5);
            this.magicalWrapper.setMarginTop((int) f3);
            return;
        }
        float f10 = (f5 - f4) * f;
        float f11 = (f7 - f6) * f;
        float f12 = (f9 - f8) * f;
        this.magicalWrapper.setWidth(f6 + f11);
        this.magicalWrapper.setHeight(f8 + f12);
        this.magicalWrapper.setMarginLeft((int) (f4 + f10));
        this.magicalWrapper.setMarginTop((int) (f2 + (f * (f3 - f2))));
    }

    public void backToMin() {
        if (this.isAnimating) {
            return;
        }
        if (this.mOriginWidth == 0 || this.mOriginHeight == 0) {
            backToMinWithoutView();
            return;
        }
        OnMagicalViewCallback onMagicalViewCallback = this.onMagicalViewCallback;
        if (onMagicalViewCallback != null) {
            onMagicalViewCallback.onBeginBackMinAnim();
        }
        beginBackToMin(false);
        backToMinWithTransition();
    }

    private void backToMinWithTransition() {
        this.contentLayout.post(new Runnable() { // from class: com.luck.picture.lib.magical.MagicalView.3
            @Override // java.lang.Runnable
            public void run() {
                TransitionManager.beginDelayedTransition((ViewGroup) MagicalView.this.contentLayout.getParent(), new TransitionSet().setDuration(250L).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()));
                MagicalView.this.beginBackToMin(true);
                MagicalView.this.contentLayout.setTranslationX(0.0f);
                MagicalView.this.contentLayout.setTranslationY(0.0f);
                MagicalView.this.magicalWrapper.setWidth(MagicalView.this.mOriginWidth);
                MagicalView.this.magicalWrapper.setHeight(MagicalView.this.mOriginHeight);
                MagicalView.this.magicalWrapper.setMarginTop(MagicalView.this.mOriginTop);
                MagicalView.this.magicalWrapper.setMarginLeft(MagicalView.this.mOriginLeft);
                MagicalView.this.changeBackgroundViewAlpha(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginBackToMin(boolean z) {
        if (z) {
            this.onMagicalViewCallback.onBeginBackMinMagicalFinish(true);
        }
    }

    private void backToMinWithoutView() {
        this.contentLayout.animate().alpha(0.0f).setDuration(250L).setListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.magical.MagicalView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onMagicalViewFinish();
                }
            }
        }).start();
        this.backgroundView.animate().alpha(0.0f).setDuration(250L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeBackgroundViewAlpha(final boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mAlpha, z ? 0.0f : 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.luck.picture.lib.magical.MagicalView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MagicalView.this.isAnimating = true;
                MagicalView.this.mAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView.this.backgroundView.setAlpha(MagicalView.this.mAlpha);
                if (MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onBackgroundAlpha(MagicalView.this.mAlpha);
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.luck.picture.lib.magical.MagicalView.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MagicalView.this.isAnimating = false;
                if (!z || MagicalView.this.onMagicalViewCallback == null) {
                    return;
                }
                MagicalView.this.onMagicalViewCallback.onMagicalViewFinish();
            }
        });
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.start();
    }

    public void setMagicalContent(View view) {
        this.contentLayout.addView(view);
    }

    private void changeContentViewToFullscreen() {
        int i = this.screenHeight;
        this.targetImageHeight = i;
        this.targetImageWidth = this.screenWidth;
        this.targetImageTop = 0;
        this.magicalWrapper.setHeight(i);
        this.magicalWrapper.setWidth(this.screenWidth);
        this.magicalWrapper.setMarginTop(0);
        this.magicalWrapper.setMarginLeft(0);
    }

    public void setBackgroundAlpha(float f) {
        this.mAlpha = f;
        this.backgroundView.setAlpha(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.widget.FrameLayout r0 = r5.contentLayout
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto Le
            androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
            goto Lf
        Le:
            r0 = 0
        Lf:
            int r1 = r6.getAction()
            r2 = 1
            if (r1 == 0) goto L53
            if (r1 == r2) goto L4d
            r3 = 2
            if (r1 == r3) goto L1f
            r3 = 3
            if (r1 == r3) goto L4d
            goto L66
        L1f:
            float r1 = r6.getX()
            int r1 = (int) r1
            float r3 = r6.getY()
            int r3 = (int) r3
            int r4 = r5.startX
            int r1 = r1 - r4
            int r1 = java.lang.Math.abs(r1)
            int r4 = r5.startY
            int r4 = r3 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r1 <= r4) goto L40
            if (r0 == 0) goto L66
            r0.setUserInputEnabled(r2)
            goto L66
        L40:
            if (r0 == 0) goto L66
            int r1 = r5.startY
            int r1 = r1 - r3
            boolean r1 = r5.canScrollVertically(r1)
            r0.setUserInputEnabled(r1)
            goto L66
        L4d:
            if (r0 == 0) goto L66
            r0.setUserInputEnabled(r2)
            goto L66
        L53:
            float r1 = r6.getX()
            int r1 = (int) r1
            r5.startX = r1
            float r1 = r6.getY()
            int r1 = (int) r1
            r5.startY = r1
            if (r0 == 0) goto L66
            r0.setUserInputEnabled(r2)
        L66:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.magical.MagicalView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnMojitoViewCallback(OnMagicalViewCallback onMagicalViewCallback) {
        this.onMagicalViewCallback = onMagicalViewCallback;
    }
}
