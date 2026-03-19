package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.utils.jh;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HandLongPressView extends FrameLayout {
    private TextView an;
    private CircleRippleView b;
    private AnimatorSet c;
    private Context d;
    private ImageView hc;
    private boolean u;

    public HandLongPressView(Context context) {
        super(context);
        this.u = true;
        this.d = context;
        this.c = new AnimatorSet();
        b();
        c();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.hc.getLayoutParams();
                layoutParams.topMargin = ((int) ((HandLongPressView.this.b.getMeasuredHeight() / 2.0f) - gb.d(HandLongPressView.this.getContext(), 5.0f))) + ((int) gb.d(HandLongPressView.this.d, 20.0f));
                layoutParams.leftMargin = ((int) ((HandLongPressView.this.b.getMeasuredWidth() / 2.0f) - gb.d(HandLongPressView.this.getContext(), 5.0f))) + ((int) gb.d(HandLongPressView.this.d, 20.0f));
                layoutParams.bottomMargin = (int) (((-HandLongPressView.this.b.getMeasuredHeight()) / 2.0f) + gb.d(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-HandLongPressView.this.b.getMeasuredWidth()) / 2.0f) + gb.d(HandLongPressView.this.getContext(), 5.0f));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                    layoutParams.setMarginEnd(layoutParams.rightMargin);
                }
                HandLongPressView.this.hc.setLayoutParams(layoutParams);
            }
        });
    }

    private void b() {
        this.b = new CircleRippleView(this.d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gb.d(this.d, 80.0f), (int) gb.d(this.d, 80.0f));
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.topMargin = (int) gb.d(this.d, 20.0f);
        layoutParams.leftMargin = (int) gb.d(this.d, 20.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        addView(this.b, layoutParams);
        this.b.d();
        this.hc = new ImageView(this.d);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gb.d(this.d, 80.0f), (int) gb.d(this.d, 80.0f));
        this.hc.setImageResource(jh.u(this.d, "tt_splash_hand"));
        addView(this.hc, layoutParams2);
        TextView textView = new TextView(this.d);
        this.an = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) gb.d(this.d, 10.0f);
        addView(this.an, layoutParams3);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hc, "scaleX", 1.0f, 0.8f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(HandLongPressView.this.hc, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                HandLongPressView.this.hc.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (HandLongPressView.this.u) {
                    HandLongPressView.this.b.d();
                    HandLongPressView.this.b.setAlpha(1.0f);
                } else {
                    HandLongPressView.this.b.hc();
                    HandLongPressView.this.b.setAlpha(0.0f);
                }
                HandLongPressView.this.u = !r2.u;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hc, "scaleY", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.c.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.an.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.an.setTextColor(i);
    }

    public void d() {
        this.c.start();
    }

    public void hc() {
        AnimatorSet animatorSet = this.c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.b;
        if (circleRippleView != null) {
            circleRippleView.hc();
        }
    }
}
