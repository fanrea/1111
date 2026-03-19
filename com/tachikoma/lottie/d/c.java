package com.tachikoma.lottie.d;

import android.view.Choreographer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends a implements Choreographer.FrameCallback {
    private com.tachikoma.lottie.e GD;
    private float Nt = 1.0f;
    private boolean Nu = false;
    private long Nv = 0;
    private float Nw = 0.0f;
    private int repeatCount = 0;
    private float Nx = -2.1474836E9f;
    private float Ny = 2.1474836E9f;
    protected boolean Nz = false;

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(lY());
    }

    public final float lY() {
        com.tachikoma.lottie.e eVar = this.GD;
        if (eVar == null) {
            return 0.0f;
        }
        return (this.Nw - eVar.ju()) / (this.GD.jv() - this.GD.ju());
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.GD == null) {
            return 0.0f;
        }
        if (kQ()) {
            minFrame = getMaxFrame() - this.Nw;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.Nw - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        com.tachikoma.lottie.e eVar = this.GD;
        if (eVar == null) {
            return 0L;
        }
        return (long) eVar.jt();
    }

    public final float lZ() {
        return this.Nw;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.Nz;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        mc();
        if (this.GD == null || !isRunning()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        float fMa = (jNanoTime - this.Nv) / ma();
        float f = this.Nw;
        if (kQ()) {
            fMa = -fMa;
        }
        this.Nw = f + fMa;
        boolean z = !e.e(this.Nw, getMinFrame(), getMaxFrame());
        this.Nw = e.d(this.Nw, getMinFrame(), getMaxFrame());
        this.Nv = jNanoTime;
        lX();
        if (z) {
            if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                this.Nw = getMaxFrame();
                md();
                T(kQ());
            } else {
                lV();
                this.repeatCount++;
                if (getRepeatMode() == 2) {
                    this.Nu = !this.Nu;
                    mb();
                } else {
                    this.Nw = kQ() ? getMaxFrame() : getMinFrame();
                }
                this.Nv = jNanoTime;
            }
        }
        me();
    }

    private float ma() {
        com.tachikoma.lottie.e eVar = this.GD;
        if (eVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / eVar.getFrameRate()) / Math.abs(this.Nt);
    }

    public final void jn() {
        this.GD = null;
        this.Nx = -2.1474836E9f;
        this.Ny = 2.1474836E9f;
    }

    public final void setComposition(com.tachikoma.lottie.e eVar) {
        boolean z = this.GD == null;
        this.GD = eVar;
        if (z) {
            o((int) Math.max(this.Nx, eVar.ju()), (int) Math.min(this.Ny, eVar.jv()));
        } else {
            o((int) eVar.ju(), (int) eVar.jv());
        }
        float f = this.Nw;
        this.Nw = 0.0f;
        setFrame((int) f);
    }

    public final void setFrame(int i) {
        float f = i;
        if (this.Nw == f) {
            return;
        }
        this.Nw = e.d(f, getMinFrame(), getMaxFrame());
        this.Nv = System.nanoTime();
        lX();
    }

    public final void setMinFrame(int i) {
        o(i, (int) this.Ny);
    }

    public final void l(float f) {
        o(this.Nx, f);
    }

    public final void o(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.tachikoma.lottie.e eVar = this.GD;
        float fJu = eVar == null ? -3.4028235E38f : eVar.ju();
        com.tachikoma.lottie.e eVar2 = this.GD;
        float fJv = eVar2 == null ? Float.MAX_VALUE : eVar2.jv();
        this.Nx = e.d(f, fJu, fJv);
        this.Ny = e.d(f2, fJu, fJv);
        setFrame((int) e.d(this.Nw, f, f2));
    }

    private void mb() {
        setSpeed(-getSpeed());
    }

    public final void setSpeed(float f) {
        this.Nt = f;
    }

    public final float getSpeed() {
        return this.Nt;
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.Nu) {
            return;
        }
        this.Nu = false;
        mb();
    }

    public final void jj() {
        this.Nz = true;
        S(kQ());
        setFrame((int) (kQ() ? getMaxFrame() : getMinFrame()));
        this.Nv = System.nanoTime();
        this.repeatCount = 0;
        mc();
    }

    public final void jE() {
        md();
        T(kQ());
    }

    public final void jm() {
        md();
    }

    public final void jk() {
        this.Nz = true;
        mc();
        this.Nv = System.nanoTime();
        if (kQ() && lZ() == getMinFrame()) {
            this.Nw = getMaxFrame();
        } else {
            if (kQ() || lZ() != getMaxFrame()) {
                return;
            }
            this.Nw = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        lW();
        md();
    }

    private boolean kQ() {
        return getSpeed() < 0.0f;
    }

    public final float getMinFrame() {
        com.tachikoma.lottie.e eVar = this.GD;
        if (eVar == null) {
            return 0.0f;
        }
        float f = this.Nx;
        return f == -2.1474836E9f ? eVar.ju() : f;
    }

    public final float getMaxFrame() {
        com.tachikoma.lottie.e eVar = this.GD;
        if (eVar == null) {
            return 0.0f;
        }
        float f = this.Ny;
        return f == 2.1474836E9f ? eVar.jv() : f;
    }

    private void mc() {
        if (isRunning()) {
            U(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    private void md() {
        U(true);
    }

    private void U(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.Nz = false;
        }
    }

    private void me() {
        if (this.GD == null) {
            return;
        }
        float f = this.Nw;
        if (f < this.Nx || f > this.Ny) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.Nx), Float.valueOf(this.Ny), Float.valueOf(this.Nw)));
        }
    }
}
