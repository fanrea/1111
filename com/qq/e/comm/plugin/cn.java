package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class cn extends bn {
    private final String d;
    private boolean e;
    private boolean f;

    @Override // com.qq.e.comm.plugin.r6
    public void b(long j) {
        int iA;
        if (ke.a() < ke.b()) {
            boolean z = ((long) ke.a()) - j < 1000;
            this.f = z;
            if (z && (iA = a(j)) > 0) {
                this.b = true;
                a(iA);
                return;
            }
        }
        super.b(j);
    }

    public cn(l20 l20Var, h4 h4Var) {
        super(l20Var, h4Var);
        this.e = true;
        this.f = false;
        this.d = fn.b(h4Var);
    }

    private void e() {
        k7 k7VarA = this.a.a();
        if (k7VarA == null) {
            return;
        }
        this.a.setVisibility(4);
        k7VarA.post(new a(k7VarA));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ k7 a;

        a(k7 k7Var) {
            this.a = k7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredWidth = (cn.this.a.b() == null ? 0 : cn.this.a.b().getMeasuredWidth()) + this.a.getWidth() + cn.this.a.getPaddingLeft() + cn.this.a.getPaddingRight() + yu.a(cn.this.a.getContext(), 4);
            l20 l20Var = cn.this.a;
            ObjectAnimator duration = ObjectAnimator.ofInt(l20Var, "width", yu.a(l20Var.getContext(), 20), measuredWidth).setDuration(400L);
            duration.addUpdateListener(new C0704a(measuredWidth));
            duration.addListener(new b());
            duration.start();
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.cn$a$a, reason: collision with other inner class name */
        class C0704a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ int a;

            C0704a(int i) {
                this.a = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!(valueAnimator.getAnimatedValue() instanceof Integer) || cn.this.a == null) {
                    return;
                }
                cn.this.a.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue() / this.a);
            }
        }

        /* compiled from: A */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                cn.this.a.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = cn.this.a.getLayoutParams();
                layoutParams.width = -2;
                cn.this.a.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.bn, com.qq.e.comm.plugin.r6
    protected void c() {
        if (this.a.b() == null) {
            this.a.a(gw.a(ne.a));
        }
        this.a.a(String.format(Locale.getDefault(), "已获得%s", this.d));
        if (this.e) {
            this.e = false;
            e();
        }
    }

    private void a(int i) {
        if (this.a.b() == null) {
            this.a.a(gw.a(ne.a));
        }
        SpannableString spannableString = new SpannableString(String.format(Locale.getDefault(), "秒后可获得 %s", this.d));
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFBE00")), (spannableString.length() - this.d.length()) - 1, spannableString.length(), 33);
        this.a.a("观看", String.valueOf(i), spannableString);
        if (this.e) {
            this.e = false;
            e();
        }
    }

    @Override // com.qq.e.comm.plugin.bn, com.qq.e.comm.plugin.r6
    public int a() {
        return this.f ? ke.b() : ke.a();
    }
}
