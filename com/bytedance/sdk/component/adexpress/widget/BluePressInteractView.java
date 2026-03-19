package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BluePressInteractView extends FrameLayout {
    private View an;
    private boolean b;
    private View c;
    private AnimatorSet d;
    private int gb;
    private ImageView h;
    private ObjectAnimator hc;
    private Context tc;
    private int tt;
    private View u;

    public BluePressInteractView(Context context, int i, int i2) {
        super(context);
        this.b = false;
        this.d = new AnimatorSet();
        this.gb = i;
        this.tt = i2;
        this.tc = context;
        b();
        c();
    }

    private void b() {
        View view = new View(this.tc);
        this.c = view;
        view.setBackground(d("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (this.gb * 0.45d), (int) (this.tt * 0.45d));
        layoutParams.gravity = 17;
        this.c.setLayoutParams(layoutParams);
        addView(this.c);
        View view2 = new View(this.tc);
        this.u = view2;
        view2.setBackground(d("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (this.gb * 0.25d), (int) (this.tt * 0.25d));
        layoutParams2.gravity = 17;
        this.u.setLayoutParams(layoutParams2);
        addView(this.u);
        View view3 = new View(this.tc);
        this.an = view3;
        view3.setBackground(d("#807BBEFF", "#FF7BBEFF"));
        int i = this.gb;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (i * 0.25d), (int) (i * 0.25d));
        layoutParams3.gravity = 17;
        this.an.setLayoutParams(layoutParams3);
        addView(this.an);
        ImageView imageView = new ImageView(this.tc);
        this.h = imageView;
        imageView.setImageResource(jh.u(getContext(), "tt_blue_hand"));
        this.h.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (this.gb * 0.62d), (int) (this.tt * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.h.setLayoutParams(layoutParams4);
        addView(this.h);
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.u, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.u, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.an, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.an, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.h, "rotation", 0.0f, -20.0f, 0.0f);
        this.hc = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.d.setDuration(1500L);
        this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.d.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.b) {
                    return;
                }
                BluePressInteractView.this.hc.start();
                BluePressInteractView.this.d.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.b = true;
            }
        });
    }

    private GradientDrawable d(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void d() {
        this.b = false;
        ObjectAnimator objectAnimator = this.hc;
        if (objectAnimator == null || this.d == null) {
            return;
        }
        objectAnimator.start();
        this.d.start();
    }

    public void hc() {
        this.b = true;
        ObjectAnimator objectAnimator = this.hc;
        if (objectAnimator == null || this.d == null) {
            return;
        }
        objectAnimator.cancel();
        this.d.cancel();
    }
}
