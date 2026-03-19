package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.qq.e.comm.plugin.q6;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class b00 extends FrameLayout {
    private final TextView a;

    b00(Context context, q6.b bVar, int i) {
        super(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        int i2 = pz.d;
        int i3 = pz.f;
        linearLayout.setPadding(i3, i2, i3, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(50.0f);
        gradientDrawable.setAlpha(77);
        linearLayout.setBackgroundDrawable(gradientDrawable);
        linearLayout.setGravity(17);
        TextView textView = new TextView(getContext());
        textView.setText("跳过");
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(-1);
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(getContext());
        this.a = textView2;
        textView2.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(Math.round(i / 1000.0f))));
        textView2.setTextSize(2, 13.0f);
        textView2.setTextColor(-1);
        textView2.setIncludeFontPadding(false);
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i2;
        linearLayout.addView(textView2, layoutParams);
        setId(2);
        setPadding(bVar.a, bVar.b, bVar.c, bVar.d);
        addView(linearLayout);
    }

    /* compiled from: A */
    class a implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b00.this.setVisibility(0);
            b00.this.setAlpha(0.0f);
        }
    }

    void a(long j) {
        this.a.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(Math.round(j / 1000.0f))));
    }

    void a() {
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        setVisibility(8);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<b00, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500);
        objectAnimatorOfFloat.setInterpolator(accelerateDecelerateInterpolator);
        objectAnimatorOfFloat.setStartDelay(1000);
        objectAnimatorOfFloat.addListener(new a());
        objectAnimatorOfFloat.start();
    }
}
