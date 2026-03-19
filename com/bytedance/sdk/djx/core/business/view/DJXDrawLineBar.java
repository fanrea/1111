package com.bytedance.sdk.djx.core.business.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawLineBar extends FrameLayout {
    private ObjectAnimator mEndAnimator;
    private View mLineBelow;
    private View mLineUp;
    private View mRoot;
    private ObjectAnimator mStartAnimator;
    private ValueAnimator mValueAnimator;
    private ValueAnimator.AnimatorUpdateListener mValueListener;

    public DJXDrawLineBar(Context context) {
        super(context);
        initView(context);
    }

    public DJXDrawLineBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public DJXDrawLineBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public DJXDrawLineBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }

    private void initView(Context context) {
        View viewInflate = inflate(context, R.layout.djx_view_draw_line_bar, this);
        this.mRoot = viewInflate;
        this.mLineUp = viewInflate.findViewById(R.id.djx_draw_linebar_line_up);
        this.mLineBelow = this.mRoot.findViewById(R.id.djx_draw_linebar_line_below);
        this.mLineUp.setAlpha(0.0f);
        this.mLineBelow.setAlpha(0.0f);
        initValueAnimListener();
    }

    private void initValueAnimListener() {
        this.mValueListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawLineBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (fIntValue > 0.0f && fIntValue <= 100.0f) {
                    float f = fIntValue / 100.0f;
                    DJXDrawLineBar.this.mLineUp.setAlpha(f);
                    DJXDrawLineBar.this.mLineUp.setScaleX(f * 0.8f);
                } else {
                    if (fIntValue <= 100.0f || fIntValue > 200.0f) {
                        return;
                    }
                    float f2 = (fIntValue - 100.0f) / 100.0f;
                    DJXDrawLineBar.this.mLineUp.setAlpha(1.0f - f2);
                    DJXDrawLineBar.this.mLineUp.setScaleX((f2 * 0.2f) + 0.8f);
                }
            }
        };
    }

    private void addStartAnimListener() {
        ObjectAnimator objectAnimator = this.mStartAnimator;
        if (objectAnimator == null) {
            return;
        }
        if (objectAnimator.getListeners() == null || this.mStartAnimator.getListeners().isEmpty()) {
            this.mStartAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawLineBar.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (DJXDrawLineBar.this.mValueAnimator != null) {
                        if (DJXDrawLineBar.this.mValueAnimator.getListeners() == null || DJXDrawLineBar.this.mValueAnimator.getListeners().isEmpty()) {
                            DJXDrawLineBar.this.mValueAnimator.addUpdateListener(DJXDrawLineBar.this.mValueListener);
                        }
                        DJXDrawLineBar.this.mValueAnimator.start();
                    }
                }
            });
        }
    }

    public void startAnimation() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (this.mValueAnimator == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 200);
            this.mValueAnimator = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(600L);
            this.mValueAnimator.setRepeatCount(-1);
            this.mValueAnimator.addUpdateListener(this.mValueListener);
        }
        if (this.mStartAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mLineBelow, "alpha", 0.0f, 1.0f);
            this.mStartAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            addStartAnimListener();
        }
        ObjectAnimator objectAnimator = this.mEndAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mEndAnimator.cancel();
            startStartAnim();
        } else {
            if (this.mStartAnimator.isRunning() || this.mValueAnimator.isRunning()) {
                return;
            }
            startStartAnim();
        }
    }

    private void startStartAnim() {
        addStartAnimListener();
        this.mStartAnimator.start();
    }

    public void stopAnimation() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.mEndAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.mEndAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawLineBar.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (DJXDrawLineBar.this.mValueAnimator != null) {
                    DJXDrawLineBar.this.mValueAnimator.cancel();
                }
                DJXDrawLineBar.this.setAlpha(1.0f);
                DJXDrawLineBar.this.setVisibility(4);
            }
        });
        this.mEndAnimator.start();
    }

    public void onDestroyView() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mValueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = this.mStartAnimator;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.mStartAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.mEndAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
            this.mEndAnimator.cancel();
        }
    }
}
