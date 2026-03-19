package com.component.lottie.h;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.component.lottie.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a<T> {
    private static final float j = -3987645.8f;
    private static final int k = 784923401;
    public final T a;
    public T b;
    public final Interpolator c;
    public final Interpolator d;
    public final Interpolator e;
    public final float f;
    public Float g;
    public PointF h;
    public PointF i;
    private final t l;
    private float m;
    private float n;
    private int o;
    private int p;
    private float q;
    private float r;

    public a(t tVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.m = j;
        this.n = j;
        this.o = k;
        this.p = k;
        this.q = Float.MIN_VALUE;
        this.r = Float.MIN_VALUE;
        this.h = null;
        this.i = null;
        this.l = tVar;
        this.a = t;
        this.b = t2;
        this.c = interpolator;
        this.d = null;
        this.e = null;
        this.f = f;
        this.g = f2;
    }

    public a(t tVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.m = j;
        this.n = j;
        this.o = k;
        this.p = k;
        this.q = Float.MIN_VALUE;
        this.r = Float.MIN_VALUE;
        this.h = null;
        this.i = null;
        this.l = tVar;
        this.a = t;
        this.b = t2;
        this.c = null;
        this.d = interpolator;
        this.e = interpolator2;
        this.f = f;
        this.g = f2;
    }

    protected a(t tVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.m = j;
        this.n = j;
        this.o = k;
        this.p = k;
        this.q = Float.MIN_VALUE;
        this.r = Float.MIN_VALUE;
        this.h = null;
        this.i = null;
        this.l = tVar;
        this.a = t;
        this.b = t2;
        this.c = interpolator;
        this.d = interpolator2;
        this.e = interpolator3;
        this.f = f;
        this.g = f2;
    }

    public a(T t) {
        this.m = j;
        this.n = j;
        this.o = k;
        this.p = k;
        this.q = Float.MIN_VALUE;
        this.r = Float.MIN_VALUE;
        this.h = null;
        this.i = null;
        this.l = null;
        this.a = t;
        this.b = t;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = Float.MIN_VALUE;
        this.g = Float.valueOf(Float.MAX_VALUE);
    }

    public float c() {
        if (this.l == null) {
            return 0.0f;
        }
        if (this.q == Float.MIN_VALUE) {
            this.q = (this.f - this.l.g()) / this.l.p();
        }
        return this.q;
    }

    public float d() {
        if (this.l == null) {
            return 1.0f;
        }
        if (this.r == Float.MIN_VALUE) {
            if (this.g == null) {
                this.r = 1.0f;
            } else {
                this.r = c() + ((this.g.floatValue() - this.f) / this.l.p());
            }
        }
        return this.r;
    }

    public boolean e() {
        return this.c == null && this.d == null && this.e == null;
    }

    public boolean a(float f) {
        return f >= c() && f < d();
    }

    public float f() {
        if (this.m == j) {
            this.m = ((Float) this.a).floatValue();
        }
        return this.m;
    }

    public float g() {
        if (this.n == j) {
            this.n = ((Float) this.b).floatValue();
        }
        return this.n;
    }

    public int h() {
        if (this.o == k) {
            this.o = ((Integer) this.a).intValue();
        }
        return this.o;
    }

    public int i() {
        if (this.p == k) {
            this.p = ((Integer) this.b).intValue();
        }
        return this.p;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.a + ", endValue=" + this.b + ", startFrame=" + this.f + ", endFrame=" + this.g + ", interpolator=" + this.c + '}';
    }
}
