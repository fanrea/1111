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
public class PressInteractView extends FrameLayout {
    private TextView an;
    private SplashDiffuseView b;
    private AnimatorSet c;
    private Context d;
    private ImageView hc;
    private boolean u;

    public PressInteractView(Context context) {
        super(context);
        this.u = true;
        this.d = context;
        this.c = new AnimatorSet();
        b();
        c();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int iD = (int) gb.d(PressInteractView.this.d, 50.0f);
                int iD2 = (int) gb.d(PressInteractView.this.d, 50.0f);
                if (PressInteractView.this.b.getMeasuredHeight() > 0) {
                    iD = PressInteractView.this.b.getMeasuredHeight();
                }
                if (PressInteractView.this.b.getMeasuredWidth() > 0) {
                    iD2 = PressInteractView.this.b.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.hc.getLayoutParams();
                layoutParams.topMargin = ((int) ((iD / 2.0f) - gb.d(PressInteractView.this.getContext(), 5.0f))) + ((int) gb.d(PressInteractView.this.d, 40.0f));
                layoutParams.leftMargin = ((int) ((iD2 / 2.0f) - gb.d(PressInteractView.this.getContext(), 5.0f))) + ((int) gb.d(PressInteractView.this.d, 20.0f));
                layoutParams.bottomMargin = (int) (((-iD) / 2.0f) + gb.d(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iD2) / 2.0f) + gb.d(PressInteractView.this.getContext(), 5.0f));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                    layoutParams.setMarginEnd(layoutParams.rightMargin);
                }
                PressInteractView.this.hc.setLayoutParams(layoutParams);
            }
        });
    }

    private void b() {
        this.b = new SplashDiffuseView(this.d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gb.d(this.d, 50.0f), (int) gb.d(this.d, 50.0f));
        layoutParams.gravity = BadgeDrawable.TOP_START;
        layoutParams.topMargin = (int) gb.d(this.d, 40.0f);
        layoutParams.leftMargin = (int) gb.d(this.d, 20.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        addView(this.b, layoutParams);
        this.hc = new ImageView(this.d);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gb.d(this.d, 78.0f), (int) gb.d(this.d, 78.0f));
        this.hc.setImageResource(jh.u(this.d, "tt_splash_hand"));
        addView(this.hc, layoutParams2);
        TextView textView = new TextView(this.d);
        this.an = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) gb.d(this.d, 10.0f);
        addView(this.an, layoutParams3);
        this.an.setVisibility(8);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hc, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.hc, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.hc.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.u) {
                    PressInteractView.this.b.d();
                }
                PressInteractView.this.u = !r2.u;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hc, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.c.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.an.setVisibility(0);
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
        SplashDiffuseView splashDiffuseView = this.b;
        if (splashDiffuseView != null) {
            splashDiffuseView.hc();
        }
        ImageView imageView = this.hc;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}
