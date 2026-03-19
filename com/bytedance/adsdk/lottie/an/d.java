package com.bytedance.adsdk.lottie.an;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d<T> {
    public final float an;
    public final Interpolator b;
    public final Interpolator c;
    private float cb;
    public final T d;
    private float e;
    public PointF gb;
    public Float h;
    public T hc;
    private int k;
    private float mk;
    private float mq;
    private final an tc;
    public PointF tt;
    public final Interpolator u;
    private int uo;

    public d(an anVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.mk = -3987645.8f;
        this.mq = -3987645.8f;
        this.uo = 784923401;
        this.k = 784923401;
        this.e = Float.MIN_VALUE;
        this.cb = Float.MIN_VALUE;
        this.gb = null;
        this.tt = null;
        this.tc = anVar;
        this.d = t;
        this.hc = t2;
        this.b = interpolator;
        this.c = null;
        this.u = null;
        this.an = f;
        this.h = f2;
    }

    public d(an anVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.mk = -3987645.8f;
        this.mq = -3987645.8f;
        this.uo = 784923401;
        this.k = 784923401;
        this.e = Float.MIN_VALUE;
        this.cb = Float.MIN_VALUE;
        this.gb = null;
        this.tt = null;
        this.tc = anVar;
        this.d = t;
        this.hc = t2;
        this.b = null;
        this.c = interpolator;
        this.u = interpolator2;
        this.an = f;
        this.h = f2;
    }

    protected d(an anVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.mk = -3987645.8f;
        this.mq = -3987645.8f;
        this.uo = 784923401;
        this.k = 784923401;
        this.e = Float.MIN_VALUE;
        this.cb = Float.MIN_VALUE;
        this.gb = null;
        this.tt = null;
        this.tc = anVar;
        this.d = t;
        this.hc = t2;
        this.b = interpolator;
        this.c = interpolator2;
        this.u = interpolator3;
        this.an = f;
        this.h = f2;
    }

    public d(T t) {
        this.mk = -3987645.8f;
        this.mq = -3987645.8f;
        this.uo = 784923401;
        this.k = 784923401;
        this.e = Float.MIN_VALUE;
        this.cb = Float.MIN_VALUE;
        this.gb = null;
        this.tt = null;
        this.tc = null;
        this.d = t;
        this.hc = t;
        this.b = null;
        this.c = null;
        this.u = null;
        this.an = Float.MIN_VALUE;
        this.h = Float.valueOf(Float.MAX_VALUE);
    }

    private d(T t, T t2) {
        this.mk = -3987645.8f;
        this.mq = -3987645.8f;
        this.uo = 784923401;
        this.k = 784923401;
        this.e = Float.MIN_VALUE;
        this.cb = Float.MIN_VALUE;
        this.gb = null;
        this.tt = null;
        this.tc = null;
        this.d = t;
        this.hc = t2;
        this.b = null;
        this.c = null;
        this.u = null;
        this.an = Float.MIN_VALUE;
        this.h = Float.valueOf(Float.MAX_VALUE);
    }

    public d<T> d(T t, T t2) {
        return new d<>(t, t2);
    }

    public float b() {
        an anVar = this.tc;
        if (anVar == null) {
            return 0.0f;
        }
        if (this.e == Float.MIN_VALUE) {
            this.e = (this.an - anVar.an()) / this.tc.yo();
        }
        return this.e;
    }

    public float c() {
        if (this.tc == null) {
            return 1.0f;
        }
        if (this.cb == Float.MIN_VALUE) {
            if (this.h == null) {
                this.cb = 1.0f;
            } else {
                this.cb = b() + ((this.h.floatValue() - this.an) / this.tc.yo());
            }
        }
        return this.cb;
    }

    public boolean u() {
        return this.b == null && this.c == null && this.u == null;
    }

    public boolean d(float f) {
        return f >= b() && f < c();
    }

    public float an() {
        if (this.mk == -3987645.8f) {
            this.mk = ((Float) this.d).floatValue();
        }
        return this.mk;
    }

    public float h() {
        if (this.mq == -3987645.8f) {
            this.mq = ((Float) this.hc).floatValue();
        }
        return this.mq;
    }

    public int gb() {
        if (this.uo == 784923401) {
            this.uo = ((Integer) this.d).intValue();
        }
        return this.uo;
    }

    public int tt() {
        if (this.k == 784923401) {
            this.k = ((Integer) this.hc).intValue();
        }
        return this.k;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.d + ", endValue=" + this.hc + ", startFrame=" + this.an + ", endFrame=" + this.h + ", interpolator=" + this.b + '}';
    }
}
