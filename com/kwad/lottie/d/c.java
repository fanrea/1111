package com.kwad.lottie.d;

import android.view.Choreographer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends a implements Choreographer.FrameCallback {
    private com.kwad.lottie.d bjG;
    private float bpC = 1.0f;
    private boolean bpD = false;
    private long bpE = 0;
    private float bpF = 0.0f;
    private int repeatCount = 0;
    private float bpG = -2.1474836E9f;
    private float bpH = 2.1474836E9f;
    protected boolean bpI = false;

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(SB());
    }

    public final float SB() {
        com.kwad.lottie.d dVar = this.bjG;
        if (dVar == null) {
            return 0.0f;
        }
        return (this.bpF - dVar.Qe()) / (this.bjG.Qf() - this.bjG.Qe());
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.bjG == null) {
            return 0.0f;
        }
        if (Ru()) {
            minFrame = getMaxFrame() - this.bpF;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.bpF - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        com.kwad.lottie.d dVar = this.bjG;
        if (dVar == null) {
            return 0L;
        }
        return (long) dVar.Qd();
    }

    public final float SC() {
        return this.bpF;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.bpI;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        SF();
        if (this.bjG == null || !isRunning()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        float fSD = (jNanoTime - this.bpE) / SD();
        float f = this.bpF;
        if (Ru()) {
            fSD = -fSD;
        }
        float f2 = f + fSD;
        this.bpF = f2;
        boolean z = !e.c(f2, getMinFrame(), getMaxFrame());
        this.bpF = e.clamp(this.bpF, getMinFrame(), getMaxFrame());
        this.bpE = jNanoTime;
        SA();
        if (z) {
            if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                this.bpF = getMaxFrame();
                SG();
                cq(Ru());
            } else {
                Sz();
                this.repeatCount++;
                if (getRepeatMode() == 2) {
                    this.bpD = !this.bpD;
                    SE();
                } else {
                    this.bpF = Ru() ? getMaxFrame() : getMinFrame();
                }
                this.bpE = jNanoTime;
            }
        }
        SH();
    }

    private float SD() {
        com.kwad.lottie.d dVar = this.bjG;
        if (dVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / dVar.getFrameRate()) / Math.abs(this.bpC);
    }

    public final void Qb() {
        this.bjG = null;
        this.bpG = -2.1474836E9f;
        this.bpH = 2.1474836E9f;
    }

    public final void setComposition(com.kwad.lottie.d dVar) {
        boolean z = this.bjG == null;
        this.bjG = dVar;
        if (z) {
            F((int) Math.max(this.bpG, dVar.Qe()), (int) Math.min(this.bpH, dVar.Qf()));
        } else {
            F((int) dVar.Qe(), (int) dVar.Qf());
        }
        setFrame((int) this.bpF);
        this.bpE = System.nanoTime();
    }

    public final void setFrame(int i) {
        float f = i;
        if (this.bpF == f) {
            return;
        }
        this.bpF = e.clamp(f, getMinFrame(), getMaxFrame());
        this.bpE = System.nanoTime();
        SA();
    }

    public final void setMinFrame(int i) {
        F(i, (int) this.bpH);
    }

    public final void setMaxFrame(int i) {
        F((int) this.bpG, i);
    }

    private void F(int i, int i2) {
        com.kwad.lottie.d dVar = this.bjG;
        float fQe = dVar == null ? -3.4028235E38f : dVar.Qe();
        com.kwad.lottie.d dVar2 = this.bjG;
        float fQf = dVar2 == null ? Float.MAX_VALUE : dVar2.Qf();
        float f = i;
        this.bpG = e.clamp(f, fQe, fQf);
        float f2 = i2;
        this.bpH = e.clamp(f2, fQe, fQf);
        setFrame((int) e.clamp(this.bpF, f, f2));
    }

    private void SE() {
        setSpeed(-getSpeed());
    }

    public final void setSpeed(float f) {
        this.bpC = f;
    }

    public final float getSpeed() {
        return this.bpC;
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.bpD) {
            return;
        }
        this.bpD = false;
        SE();
    }

    public final void PZ() {
        this.bpI = true;
        cp(Ru());
        setFrame((int) (Ru() ? getMaxFrame() : getMinFrame()));
        this.bpE = System.nanoTime();
        this.repeatCount = 0;
        SF();
    }

    public final void Qp() {
        SG();
        cq(Ru());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Aj();
        SG();
    }

    private boolean Ru() {
        return getSpeed() < 0.0f;
    }

    public final float getMinFrame() {
        com.kwad.lottie.d dVar = this.bjG;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.bpG;
        return f == -2.1474836E9f ? dVar.Qe() : f;
    }

    public final float getMaxFrame() {
        com.kwad.lottie.d dVar = this.bjG;
        if (dVar == null) {
            return 0.0f;
        }
        float f = this.bpH;
        return f == 2.1474836E9f ? dVar.Qf() : f;
    }

    private void SF() {
        if (isRunning()) {
            cr(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    private void SG() {
        cr(true);
    }

    private void cr(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.bpI = false;
        }
    }

    private void SH() {
        if (this.bjG == null) {
            return;
        }
        float f = this.bpF;
        if (f < this.bpG || f > this.bpH) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.bpG), Float.valueOf(this.bpH), Float.valueOf(this.bpF)));
        }
    }
}
