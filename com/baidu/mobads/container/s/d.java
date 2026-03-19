package com.baidu.mobads.container.s;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kuaishou.socket.nano.SocketMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends RelativeLayout {
    Context a;
    ao b;
    ObjectAnimator c;
    View d;
    ObjectAnimator e;
    View f;
    ObjectAnimator g;
    int h;
    int i;
    private int j;

    public d(Context context) {
        this(context, 67, -16777216);
    }

    public d(Context context, int i, int i2) {
        super(context);
        this.j = SocketMessages.PayloadType.SC_LIVE_QUIZ_QUESTION_ASKED;
        this.h = 67;
        this.i = -16777216;
        this.h = i;
        this.i = i2;
        this.a = context;
        c();
    }

    private void c() {
        try {
            g();
            d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d() {
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        Context context = this.a;
        double d = this.h;
        Double.isNaN(d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(context, (float) (d * 0.64d)), com.baidu.mobads.container.util.ab.a(this.a, this.h));
        layoutParams.addRule(13);
        addView(relativeLayout, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.a);
        Context context2 = this.a;
        double d2 = this.h;
        Double.isNaN(d2);
        int iA = com.baidu.mobads.container.util.ab.a(context2, (float) (d2 * 0.53d));
        Context context3 = this.a;
        double d3 = this.h;
        Double.isNaN(d3);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, com.baidu.mobads.container.util.ab.a(context3, (float) (d3 * 0.835d)));
        layoutParams2.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams2);
        this.f = new View(this.a);
        this.f.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.f.setAlpha(0.5f);
        Context context4 = this.a;
        double d4 = this.h;
        Double.isNaN(d4);
        relativeLayout2.addView(this.f, new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(context4, (float) (d4 * 0.265d)), -1));
        this.d = new View(this.a);
        this.d.setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.d.setAlpha(0.5f);
        Context context5 = this.a;
        double d5 = this.h;
        Double.isNaN(d5);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(context5, (float) (d5 * 0.265d)), -1);
        layoutParams3.addRule(11);
        relativeLayout2.addView(this.d, layoutParams3);
        ImageView imageView = new ImageView(this.a);
        com.component.b.a.a().a(imageView, "ic_twist_phone");
        relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        this.c = ObjectAnimator.ofFloat(relativeLayout, "rotationY", 0.0f, -30.0f, 0.0f, 30.0f, 0.0f);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.setDuration(this.j * 4);
        this.c.setRepeatCount(-1);
        f();
        e();
    }

    private void e() {
        View view = this.f;
        Context context = this.a;
        double d = this.h;
        Double.isNaN(d);
        float f = -com.baidu.mobads.container.util.ab.a(context, (float) (d * 0.265d));
        Context context2 = this.a;
        double d2 = this.h;
        Double.isNaN(d2);
        float f2 = -com.baidu.mobads.container.util.ab.a(context2, (float) (d2 * 0.265d));
        Context context3 = this.a;
        double d3 = this.h;
        Double.isNaN(d3);
        float f3 = -com.baidu.mobads.container.util.ab.a(context3, (float) (d3 * 0.265d));
        Context context4 = this.a;
        Double.isNaN(this.h);
        this.g = ObjectAnimator.ofFloat(view, "translationX", f, f2, f3, 0.0f, -com.baidu.mobads.container.util.ab.a(context4, (float) (r7 * 0.265d)));
        this.g.setInterpolator(new LinearInterpolator());
        this.g.setDuration(this.j * 4);
        this.g.setRepeatMode(1);
        this.g.setRepeatCount(-1);
    }

    private void f() {
        View view = this.d;
        Context context = this.a;
        double d = this.h;
        Double.isNaN(d);
        float fA = com.baidu.mobads.container.util.ab.a(context, (float) (d * 0.265d));
        Context context2 = this.a;
        double d2 = this.h;
        Double.isNaN(d2);
        float fA2 = com.baidu.mobads.container.util.ab.a(context2, (float) (d2 * 0.265d));
        Context context3 = this.a;
        double d3 = this.h;
        Double.isNaN(d3);
        float fA3 = com.baidu.mobads.container.util.ab.a(context3, (float) (d3 * 0.265d));
        Context context4 = this.a;
        Double.isNaN(this.h);
        this.e = ObjectAnimator.ofFloat(view, "translationX", fA, 0.0f, fA2, fA3, com.baidu.mobads.container.util.ab.a(context4, (float) (r7 * 0.265d)));
        this.e.setInterpolator(new LinearInterpolator());
        this.e.setDuration(this.j * 4);
        this.e.setRepeatMode(1);
        this.e.setRepeatCount(-1);
    }

    public void a() {
        com.baidu.mobads.container.util.h.a(new e(this));
    }

    public void b() {
        com.baidu.mobads.container.util.h.a(new f(this));
    }

    private void g() {
        this.b = new ao(this.a);
        this.b.a(this.i);
        addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(float f) {
        if (this.b != null) {
            this.b.a(f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }
}
