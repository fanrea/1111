package com.kwad.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a<T> {
    private final com.kwad.lottie.d bjG;
    public final float bjS;
    public final T bpN;
    public final T bpO;
    public final Interpolator bpP;
    public Float bpQ;
    private float bpR;
    private float bpS;
    public PointF bpT;
    public PointF bpU;

    public a(com.kwad.lottie.d dVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.bpR = Float.MIN_VALUE;
        this.bpS = Float.MIN_VALUE;
        this.bpT = null;
        this.bpU = null;
        this.bjG = dVar;
        this.bpN = t;
        this.bpO = t2;
        this.bpP = interpolator;
        this.bjS = f;
        this.bpQ = f2;
    }

    public a(T t) {
        this.bpR = Float.MIN_VALUE;
        this.bpS = Float.MIN_VALUE;
        this.bpT = null;
        this.bpU = null;
        this.bjG = null;
        this.bpN = t;
        this.bpO = t;
        this.bpP = null;
        this.bjS = Float.MIN_VALUE;
        this.bpQ = Float.valueOf(Float.MAX_VALUE);
    }

    public final float Sf() {
        com.kwad.lottie.d dVar = this.bjG;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.bpR == Float.MIN_VALUE) {
            this.bpR = (this.bjS - dVar.Qe()) / this.bjG.Qk();
        }
        return this.bpR;
    }

    public final float QR() {
        if (this.bjG == null) {
            return 1.0f;
        }
        if (this.bpS == Float.MIN_VALUE) {
            if (this.bpQ == null) {
                this.bpS = 1.0f;
            } else {
                this.bpS = Sf() + ((this.bpQ.floatValue() - this.bjS) / this.bjG.Qk());
            }
        }
        return this.bpS;
    }

    public final boolean SJ() {
        return this.bpP == null;
    }

    public final boolean I(float f) {
        return f >= Sf() && f < QR();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.bpN + ", endValue=" + this.bpO + ", startFrame=" + this.bjS + ", endFrame=" + this.bpQ + ", interpolator=" + this.bpP + '}';
    }
}
