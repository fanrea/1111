package com.baidu.mobads.container.s;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends RelativeLayout {
    Context a;
    ao b;
    ObjectAnimator c;
    int d;
    int e;

    public a(Context context) {
        this(context, 67, -16777216);
    }

    public a(Context context, int i, int i2) {
        super(context);
        this.d = 67;
        this.e = -16777216;
        this.a = context;
        this.d = i;
        this.e = i2;
        c();
    }

    private void c() {
        try {
            e();
            d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d() {
        ImageView imageView = new ImageView(this.a);
        Context context = this.a;
        double d = this.d;
        Double.isNaN(d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(context, (float) (d * 0.64d)), com.baidu.mobads.container.util.ab.a(this.a, this.d));
        layoutParams.addRule(13);
        com.component.b.a.a().a(imageView, "ic_twist_phone");
        addView(imageView, layoutParams);
        this.c = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, -30.0f, 0.0f, 30.0f, 0.0f, -30.0f, 0.0f, 0.0f, 0.0f);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.setDuration(1800L);
        this.c.setRepeatCount(-1);
    }

    public void a() {
        com.baidu.mobads.container.util.h.a(new b(this));
    }

    public void b() {
        com.baidu.mobads.container.util.h.a(new c(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    private void e() {
        this.b = new ao(this.a);
        this.b.a(this.e);
        addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(float f) {
        if (this.b != null) {
            this.b.a(f);
        }
    }
}
