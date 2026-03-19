package com.baidu.mobads.container.util.animation;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i {
    public Animation d;
    public ObjectAnimator e;
    private long f = 1000;
    public long a = this.f;
    public int b = 0;
    public boolean c = true;

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.d = new ScaleAnimation(f, f2, f3, f4, f5, f6);
        this.d.setDuration(this.a);
        this.d.setRepeatCount(this.b);
        this.d.setFillAfter(false);
        this.d.setFillEnabled(true);
    }

    public void a(float f) {
        this.d = new RotateAnimation(0.0f, f, 1, 0.5f, 1, 0.5f);
        this.d.setDuration(this.a);
        this.d.setRepeatCount(this.b);
        this.d.setFillAfter(this.c);
    }

    public void a(float f, float f2) {
        this.d = new TranslateAnimation(1, 0.0f, 0, f, 1, 0.0f, 0, f2);
        this.d.setDuration(this.a);
        this.d.setRepeatCount(this.b);
        this.d.setFillAfter(this.c);
    }

    public void b(float f, float f2) {
        this.d = new AlphaAnimation(f, f2);
        this.d.setDuration(this.a);
        this.d.setRepeatCount(this.b);
        this.d.setFillAfter(this.c);
    }

    public void a(View view) {
        view.startAnimation(this.d);
    }

    public void a() {
        this.d.cancel();
        this.d.reset();
    }
}
