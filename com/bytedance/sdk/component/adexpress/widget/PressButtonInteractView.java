package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PressButtonInteractView extends FrameLayout {
    private SplashDiffuseView b;
    private AnimatorSet c;
    private Context d;
    private ImageView hc;
    private boolean u;

    public PressButtonInteractView(Context context) {
        super(context);
        this.u = true;
        this.d = context;
        this.c = new AnimatorSet();
        b();
        c();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.hc.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.b.getMeasuredHeight() / 2.0f) - gb.d(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.b.getMeasuredWidth() / 2.0f) - gb.d(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.b.getMeasuredHeight()) / 2.0f) + gb.d(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.b.getMeasuredWidth()) / 2.0f) + gb.d(PressButtonInteractView.this.getContext(), 5.0f));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                    layoutParams.setMarginEnd(layoutParams.rightMargin);
                }
                PressButtonInteractView.this.hc.setLayoutParams(layoutParams);
            }
        });
    }

    private void b() {
        this.b = new SplashDiffuseView(this.d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) gb.d(this.d, 40.0f), (int) gb.d(this.d, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.b, layoutParams);
        this.hc = new ImageView(this.d);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gb.d(this.d, 62.0f), (int) gb.d(this.d, 62.0f));
        layoutParams2.gravity = 16;
        this.hc.setImageResource(jh.u(this.d, "tt_splash_hand"));
        addView(this.hc, layoutParams2);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hc, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.hc, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.hc.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.u) {
                    PressButtonInteractView.this.b.d();
                }
                PressButtonInteractView.this.u = !r2.u;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hc, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.c.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
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
