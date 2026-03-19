package com.component.lottie.g;

import android.view.Choreographer;
import com.component.lottie.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends a implements Choreographer.FrameCallback {
    private t i;
    private float b = 1.0f;
    private boolean c = false;
    private long d = 0;
    private float e = 0.0f;
    private int f = 0;
    private float g = -2.1474836E9f;
    private float h = 2.1474836E9f;
    protected boolean a = false;

    public t d() {
        return this.i;
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(e());
    }

    public float e() {
        if (this.i == null) {
            return 0.0f;
        }
        return (this.e - this.i.g()) / (this.i.h() - this.i.g());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        if (this.i == null) {
            return 0.0f;
        }
        if (s()) {
            return (o() - this.e) / (o() - n());
        }
        return (this.e - n()) / (o() - n());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.i == null) {
            return 0L;
        }
        return (long) this.i.f();
    }

    public float f() {
        return this.e;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.a;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        p();
        if (this.i == null || !isRunning()) {
            return;
        }
        com.component.lottie.c.a("LottieValueAnimator#doFrame");
        float fR = (this.d != 0 ? j - this.d : 0L) / r();
        float f = this.e;
        if (s()) {
            fR = -fR;
        }
        this.e = f + fR;
        boolean z = !f.c(this.e, n(), o());
        this.e = f.b(this.e, n(), o());
        this.d = j;
        c();
        if (z) {
            if (getRepeatCount() != -1 && this.f >= getRepeatCount()) {
                this.e = this.b < 0.0f ? n() : o();
                q();
                b(s());
            } else {
                a();
                this.f++;
                if (getRepeatMode() == 2) {
                    this.c = !this.c;
                    h();
                } else {
                    this.e = s() ? o() : n();
                }
                this.d = j;
            }
        }
        t();
        com.component.lottie.c.b("LottieValueAnimator#doFrame");
    }

    private float r() {
        if (this.i == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.i.i()) / Math.abs(this.b);
    }

    public void g() {
        this.i = null;
        this.g = -2.1474836E9f;
        this.h = 2.1474836E9f;
    }

    public void a(t tVar) {
        boolean z = this.i == null;
        this.i = tVar;
        if (z) {
            a((int) Math.max(this.g, tVar.g()), (int) Math.min(this.h, tVar.h()));
        } else {
            a((int) tVar.g(), (int) tVar.h());
        }
        float f = this.e;
        this.e = 0.0f;
        a((int) f);
        c();
    }

    public void a(float f) {
        if (this.e == f) {
            return;
        }
        this.e = f.b(f, n(), o());
        this.d = 0L;
        c();
    }

    public void a(int i) {
        a(i, (int) this.h);
    }

    public void b(float f) {
        a(this.g, f);
    }

    public void a(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        float fG = this.i == null ? -3.4028235E38f : this.i.g();
        float fH = this.i == null ? Float.MAX_VALUE : this.i.h();
        float fB = f.b(f, fG, fH);
        float fB2 = f.b(f2, fG, fH);
        if (fB != this.g || fB2 != this.h) {
            this.g = fB;
            this.h = fB2;
            a((int) f.b(this.e, fB, fB2));
        }
    }

    public void h() {
        c(-i());
    }

    public void c(float f) {
        this.b = f;
    }

    public float i() {
        return this.b;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.c) {
            this.c = false;
            h();
        }
    }

    public void j() {
        this.a = true;
        a(s());
        a((int) (s() ? o() : n()));
        this.d = 0L;
        this.f = 0;
        p();
    }

    public void k() {
        q();
        b(s());
    }

    public void l() {
        q();
    }

    public void m() {
        this.a = true;
        p();
        this.d = 0L;
        if (s() && f() == n()) {
            this.e = o();
        } else if (!s() && f() == o()) {
            this.e = n();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        b();
        q();
    }

    private boolean s() {
        return i() < 0.0f;
    }

    public float n() {
        if (this.i == null) {
            return 0.0f;
        }
        return this.g == -2.1474836E9f ? this.i.g() : this.g;
    }

    public float o() {
        if (this.i == null) {
            return 0.0f;
        }
        return this.h == 2.1474836E9f ? this.i.h() : this.h;
    }

    @Override // com.component.lottie.g.a
    void b() {
        super.b();
        b(s());
    }

    protected void p() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void q() {
        c(true);
    }

    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.a = false;
        }
    }

    private void t() {
        if (this.i == null) {
            return;
        }
        if (this.e < this.g || this.e > this.h) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.g), Float.valueOf(this.h), Float.valueOf(this.e)));
        }
    }
}
