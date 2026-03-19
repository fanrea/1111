package com.tachikoma.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tachikoma.lottie.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class a<T> {
    private final e GD;
    public final float GT;
    public final T NG;
    public T NH;
    public final Interpolator NI;
    public Float NJ;
    private float NK;
    private float NL;
    private int NM;
    private int NN;
    private float NO;
    private float NP;
    public PointF NQ;
    public PointF NR;

    public a(e eVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.NK = -3987645.8f;
        this.NL = -3987645.8f;
        this.NM = 784923401;
        this.NN = 784923401;
        this.NO = Float.MIN_VALUE;
        this.NP = Float.MIN_VALUE;
        this.NQ = null;
        this.NR = null;
        this.GD = eVar;
        this.NG = t;
        this.NH = t2;
        this.NI = interpolator;
        this.GT = f;
        this.NJ = f2;
    }

    public a(T t) {
        this.NK = -3987645.8f;
        this.NL = -3987645.8f;
        this.NM = 784923401;
        this.NN = 784923401;
        this.NO = Float.MIN_VALUE;
        this.NP = Float.MIN_VALUE;
        this.NQ = null;
        this.NR = null;
        this.GD = null;
        this.NG = t;
        this.NH = t;
        this.NI = null;
        this.GT = Float.MIN_VALUE;
        this.NJ = Float.valueOf(Float.MAX_VALUE);
    }

    public final float lC() {
        e eVar = this.GD;
        if (eVar == null) {
            return 0.0f;
        }
        if (this.NO == Float.MIN_VALUE) {
            this.NO = (this.GT - eVar.ju()) / this.GD.jA();
        }
        return this.NO;
    }

    public final float kg() {
        if (this.GD == null) {
            return 1.0f;
        }
        if (this.NP == Float.MIN_VALUE) {
            if (this.NJ == null) {
                this.NP = 1.0f;
            } else {
                this.NP = lC() + ((this.NJ.floatValue() - this.GT) / this.GD.jA());
            }
        }
        return this.NP;
    }

    public final boolean kC() {
        return this.NI == null;
    }

    public final boolean n(float f) {
        return f >= lC() && f < kg();
    }

    public final float mg() {
        if (this.NK == -3987645.8f) {
            this.NK = ((Float) this.NG).floatValue();
        }
        return this.NK;
    }

    public final float mh() {
        if (this.NL == -3987645.8f) {
            this.NL = ((Float) this.NH).floatValue();
        }
        return this.NL;
    }

    public final int mi() {
        if (this.NM == 784923401) {
            this.NM = ((Integer) this.NG).intValue();
        }
        return this.NM;
    }

    public final int mj() {
        if (this.NN == 784923401) {
            this.NN = ((Integer) this.NH).intValue();
        }
        return this.NN;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.NG + ", endValue=" + this.NH + ", startFrame=" + this.GT + ", endFrame=" + this.NJ + ", interpolator=" + this.NI + '}';
    }
}
