package com.bytedance.adsdk.lottie.u;

import android.view.Choreographer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends d implements Choreographer.FrameCallback {
    private com.bytedance.adsdk.lottie.an tc;
    private float hc = 1.0f;
    private boolean b = false;
    private long c = 0;
    private float u = 0.0f;
    private float an = 0.0f;
    private int h = 0;
    private float gb = -2.1474836E9f;
    private float tt = 2.1474836E9f;
    protected boolean d = false;
    private boolean mk = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(an());
    }

    public float an() {
        com.bytedance.adsdk.lottie.an anVar = this.tc;
        if (anVar == null) {
            return 0.0f;
        }
        return (this.an - anVar.an()) / (this.tc.h() - this.tc.an());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fE;
        float fCb;
        float fE2;
        if (this.tc == null) {
            return 0.0f;
        }
        if (jh()) {
            fE = cb() - this.an;
            fCb = cb();
            fE2 = e();
        } else {
            fE = this.an - e();
            fCb = cb();
            fE2 = e();
        }
        return fE / (fCb - fE2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.bytedance.adsdk.lottie.an anVar = this.tc;
        if (anVar == null) {
            return 0L;
        }
        return (long) anVar.u();
    }

    public float h() {
        return this.an;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.d;
    }

    public void b(boolean z) {
        this.mk = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        w();
        if (this.tc == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.lottie.u.d("LottieValueAnimator#doFrame");
        float fRf = (this.c != 0 ? j - r1 : 0L) / rf();
        float f = this.u;
        if (jh()) {
            fRf = -fRf;
        }
        float f2 = f + fRf;
        boolean z = !gb.b(f2, e(), cb());
        float f3 = this.u;
        float fHc = gb.hc(f2, e(), cb());
        this.u = fHc;
        if (this.mk) {
            fHc = (float) Math.floor(fHc);
        }
        this.an = fHc;
        this.c = j;
        if (!this.mk || this.u != f3) {
            b();
        }
        if (z) {
            if (getRepeatCount() != -1 && this.h >= getRepeatCount()) {
                float fE = this.hc < 0.0f ? e() : cb();
                this.u = fE;
                this.an = fE;
                yo();
                hc(jh());
            } else {
                d();
                this.h++;
                if (getRepeatMode() == 2) {
                    this.b = !this.b;
                    tt();
                } else {
                    float fCb = jh() ? cb() : e();
                    this.u = fCb;
                    this.an = fCb;
                }
                this.c = j;
            }
        }
        sy();
        com.bytedance.adsdk.lottie.u.hc("LottieValueAnimator#doFrame");
    }

    private float rf() {
        com.bytedance.adsdk.lottie.an anVar = this.tc;
        if (anVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / anVar.uo()) / Math.abs(this.hc);
    }

    public void gb() {
        this.tc = null;
        this.gb = -2.1474836E9f;
        this.tt = 2.1474836E9f;
    }

    public void d(com.bytedance.adsdk.lottie.an anVar) {
        boolean z = this.tc == null;
        this.tc = anVar;
        if (z) {
            d(Math.max(this.gb, anVar.an()), Math.min(this.tt, anVar.h()));
        } else {
            d((int) anVar.an(), (int) anVar.h());
        }
        float f = this.an;
        this.an = 0.0f;
        this.u = 0.0f;
        d((int) f);
        b();
    }

    public void d(float f) {
        if (this.u == f) {
            return;
        }
        float fHc = gb.hc(f, e(), cb());
        this.u = fHc;
        if (this.mk) {
            fHc = (float) Math.floor(fHc);
        }
        this.an = fHc;
        this.c = 0L;
        b();
    }

    public void d(int i) {
        d(i, (int) this.tt);
    }

    public void hc(float f) {
        d(this.gb, f);
    }

    public void d(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.bytedance.adsdk.lottie.an anVar = this.tc;
        float fAn = anVar == null ? -3.4028235E38f : anVar.an();
        com.bytedance.adsdk.lottie.an anVar2 = this.tc;
        float fH = anVar2 == null ? Float.MAX_VALUE : anVar2.h();
        float fHc = gb.hc(f, fAn, fH);
        float fHc2 = gb.hc(f2, fAn, fH);
        if (fHc == this.gb && fHc2 == this.tt) {
            return;
        }
        this.gb = fHc;
        this.tt = fHc2;
        d((int) gb.hc(this.an, fHc, fHc2));
    }

    public void tt() {
        b(-tc());
    }

    public void b(float f) {
        this.hc = f;
    }

    public float tc() {
        return this.hc;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.b) {
            return;
        }
        this.b = false;
        tt();
    }

    public void mk() {
        this.d = true;
        d(jh());
        d((int) (jh() ? cb() : e()));
        this.c = 0L;
        this.h = 0;
        w();
    }

    public void mq() {
        yo();
        hc(jh());
    }

    public void uo() {
        yo();
        c();
    }

    public void k() {
        this.d = true;
        w();
        this.c = 0L;
        if (jh() && h() == e()) {
            d(cb());
        } else if (!jh() && h() == cb()) {
            d(e());
        }
        u();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        hc();
        yo();
    }

    private boolean jh() {
        return tc() < 0.0f;
    }

    public float e() {
        com.bytedance.adsdk.lottie.an anVar = this.tc;
        if (anVar == null) {
            return 0.0f;
        }
        float f = this.gb;
        return f == -2.1474836E9f ? anVar.an() : f;
    }

    public float cb() {
        com.bytedance.adsdk.lottie.an anVar = this.tc;
        if (anVar == null) {
            return 0.0f;
        }
        float f = this.tt;
        return f == 2.1474836E9f ? anVar.h() : f;
    }

    @Override // com.bytedance.adsdk.lottie.u.d
    void hc() {
        super.hc();
        hc(jh());
    }

    protected void w() {
        if (isRunning()) {
            c(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void yo() {
        c(true);
    }

    protected void c(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.d = false;
        }
    }

    private void sy() {
        if (this.tc == null) {
            return;
        }
        float f = this.an;
        if (f < this.gb || f > this.tt) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.gb), Float.valueOf(this.tt), Float.valueOf(this.an)));
        }
    }
}
