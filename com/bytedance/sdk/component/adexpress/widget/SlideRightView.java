package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.adexpress.d.hc.c;
import com.bytedance.sdk.component.utils.jh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SlideRightView extends FrameLayout {
    private AnimatorSet an;
    private ImageView b;
    private ImageView c;
    private Context d;
    private AnimatorSet gb;
    private AnimatorSet h;
    private ImageView hc;
    private AnimatorSet tt;
    private TextView u;

    public SlideRightView(Context context) {
        super(context);
        this.an = new AnimatorSet();
        this.h = new AnimatorSet();
        this.gb = new AnimatorSet();
        this.tt = new AnimatorSet();
        this.d = context;
        b();
    }

    private void b() {
        ImageView imageView = new ImageView(this.d);
        this.c = imageView;
        imageView.setBackgroundResource(jh.u(this.d, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) gb.d(this.d, 30.0f);
        addView(this.c, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.d);
        this.b = imageView2;
        imageView2.setImageResource(jh.u(this.d, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) gb.d(this.d, 50.0f), (int) gb.d(this.d, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) gb.d(this.d, 30.0f);
        addView(this.b, layoutParams2);
        ImageView imageView3 = new ImageView(this.d);
        this.hc = imageView3;
        imageView3.setImageResource(jh.u(this.d, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) gb.d(this.d, 80.0f), (int) gb.d(this.d, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) gb.d(this.d, 30.0f);
        addView(this.hc, layoutParams3);
        TextView textView = new TextView(this.d);
        this.u = textView;
        textView.setTextColor(-1);
        this.u.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.u, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.hc.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.b.getMeasuredHeight() / 2.0f) - gb.d(SlideRightView.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-SlideRightView.this.b.getMeasuredWidth()) + ((int) gb.d(SlideRightView.this.d, 30.0f));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams5.setMarginStart(layoutParams5.leftMargin);
                    layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                }
                SlideRightView.this.hc.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.c.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.b.getMeasuredHeight() / 2.0f) - gb.d(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.b.getMeasuredWidth() / 2.0f) + ((int) gb.d(SlideRightView.this.d, 30.0f)));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams5.setMarginStart(layoutParams5.leftMargin);
                    layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                }
                SlideRightView.this.c.setLayoutParams(layoutParams6);
            }
        });
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hc, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.b, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.b, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.c, "alpha", 0.0f, 1.0f);
        this.gb.setDuration(300L);
        this.gb.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.hc, "translationX", 0.0f, gb.d(getContext(), 90.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            objectAnimatorOfFloat5.setInterpolator(c.d(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) gb.d(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.c.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.c.setLayoutParams(layoutParams);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            valueAnimatorOfInt.setInterpolator(c.d(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.b, "translationX", 0.0f, gb.d(getContext(), 90.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            objectAnimatorOfFloat6.setInterpolator(c.d(0.2f, 0.0f, 0.3f, 1.0f));
        }
        this.tt.setDuration(1500L);
        this.tt.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.hc, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.c, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.b, "alpha", 1.0f, 0.0f);
        this.h.setDuration(50L);
        this.h.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.an.playSequentially(this.gb, this.tt, this.h);
    }

    public void d() {
        c();
        this.an.start();
        this.an.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.an.start();
                    }
                }, 200L);
            }
        });
    }

    public void hc() {
        try {
            AnimatorSet animatorSet = this.an;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.gb;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.tt;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.h;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void setGuideText(String str) {
        this.u.setText(str);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
