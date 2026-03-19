package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.b.tc;
import com.bytedance.sdk.component.utils.de;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ShakeAnimationView extends LinearLayout {
    private TextView an;
    private TextView b;
    private ImageView c;
    public int d;
    private d gb;
    private TextView h;
    private TextView hc;
    private boolean mk;
    private tc tc;
    private LinearLayout tt;
    private de u;

    public interface d {
        void d(boolean z);
    }

    public ShakeAnimationView(Context context, View view, tc tcVar, boolean z, int i) {
        super(context);
        this.tc = tcVar;
        this.mk = z;
        this.d = i;
        d(context, view);
    }

    protected void d(Context context, View view) {
        addView(view);
        this.tt = (LinearLayout) findViewById(2097610727);
        this.c = (ImageView) findViewById(2097610725);
        this.hc = (TextView) findViewById(2097610724);
        this.b = (TextView) findViewById(2097610726);
        this.an = (TextView) findViewById(2097610723);
        this.h = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.tt.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.an.setVisibility(8);
            this.h.setVisibility(8);
        } else {
            this.an.setText(str);
        }
    }

    public LinearLayout getShakeLayout() {
        return this.tt;
    }

    public void setOnShakeViewListener(d dVar) {
        this.gb = dVar;
    }

    public void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.c != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new hc(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.c.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }
                });
                ShakeAnimationView.this.c.startAnimation(rotateAnimation);
            }
        }
    }

    private static class hc implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private hc() {
        }

        /* synthetic */ hc(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.u == null) {
                this.u = new de(getContext().getApplicationContext(), 1, this.mk);
            }
            this.u.d(new de.d() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.de.d
                public void d(int i) {
                    boolean zD = ShakeAnimationView.this.u != null ? ShakeAnimationView.this.u.d() : false;
                    if (i == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.gb != null) {
                        ShakeAnimationView.this.gb.d(zD);
                    }
                }
            });
            if (this.tc != null) {
                this.u.d(r0.d());
                this.u.b(this.tc.h());
                this.u.b(this.tc.hc());
                this.u.u(this.tc.c());
                this.u.hc(this.tc.b());
                this.u.an(this.tc.u());
                this.u.d(this.tc.an());
                this.u.hc(this.tc.gb());
                this.u.d(this.d);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        de deVar = this.u;
        if (deVar != null) {
            if (z) {
                deVar.d(this.d);
            } else {
                deVar.hc(this.d);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        de deVar = this.u;
        if (deVar != null) {
            deVar.hc(this.d);
        }
    }
}
