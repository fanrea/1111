package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c;
import com.bytedance.sdk.component.adexpress.c.gb;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SlideUpView extends RelativeLayout {
    private AnimatorSet an;
    private ImageView b;
    private TextView c;
    private ImageView d;
    private AnimatorSet gb;
    private AnimatorSet h;
    private ImageView hc;
    private int mk;
    private String tc;
    private AnimatorSet tt;
    private TextView u;

    public SlideUpView(Context context) {
        super(context);
        this.an = new AnimatorSet();
        this.h = new AnimatorSet();
        this.gb = new AnimatorSet();
        this.tt = new AnimatorSet();
        this.mk = 100;
        d(context);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.an = new AnimatorSet();
        this.h = new AnimatorSet();
        this.gb = new AnimatorSet();
        this.tt = new AnimatorSet();
        this.mk = 100;
        setClipChildren(false);
        this.tc = str;
        d(context);
    }

    protected void d(Context context) {
        if (context == null) {
            context = c.getContext();
        }
        if ("5".equals(this.tc)) {
            addView(com.bytedance.sdk.component.adexpress.b.d.an(context));
            this.mk = (int) (this.mk * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.b.d.u(context));
        }
        this.d = (ImageView) findViewById(2097610734);
        this.hc = (ImageView) findViewById(2097610735);
        this.c = (TextView) findViewById(2097610730);
        this.b = (ImageView) findViewById(2097610733);
        this.u = (TextView) findViewById(2097610731);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.an;
    }

    public void d() {
        b();
        this.an.start();
        this.an.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.an.start();
                    }
                }, 200L);
            }
        });
    }

    public void b() {
        ValueAnimator valueAnimator;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.d, "translationY", 0.0f, gb.d(getContext(), -this.mk));
        if (Build.VERSION.SDK_INT >= 21) {
            objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            objectAnimatorOfFloat3.setInterpolator(com.bytedance.sdk.component.adexpress.d.hc.c.d(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) gb.d(getContext(), this.mk));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (SlideUpView.this.b != null) {
                    Integer num = (Integer) valueAnimator2.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.b.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.b.setLayoutParams(layoutParams);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            valueAnimatorOfInt.setInterpolator(com.bytedance.sdk.component.adexpress.d.hc.c.d(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.b, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.b, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.hc, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.hc, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.hc, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.hc, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.hc, "translationY", 0.0f, gb.d(getContext(), -this.mk));
        if (Build.VERSION.SDK_INT >= 21) {
            valueAnimator = valueAnimatorOfInt;
            objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            valueAnimator = valueAnimatorOfInt;
            objectAnimatorOfFloat10.setInterpolator(com.bytedance.sdk.component.adexpress.d.hc.c.d(0.2f, 0.0f, 0.3f, 1.0f));
        }
        this.h.setDuration(50L);
        this.tt.setDuration(1500L);
        this.gb.setDuration(50L);
        this.h.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.gb.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.tt.playTogether(objectAnimatorOfFloat3, valueAnimator, objectAnimatorOfFloat10);
        this.an.playSequentially(this.gb, this.tt, this.h);
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
            AnimatorSet animatorSet3 = this.h;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.tt;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            mq.b(e.getMessage());
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.u != null) {
            if (TextUtils.isEmpty(str)) {
                this.u.setText("");
            } else {
                this.u.setText(str);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hc();
    }
}
