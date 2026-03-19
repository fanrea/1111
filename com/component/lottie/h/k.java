package com.component.lottie.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k {
    private float a;
    private float b;

    public k(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public k() {
        this(1.0f, 1.0f);
    }

    public float a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public void a(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean b(float f, float f2) {
        return this.a == f && this.b == f2;
    }

    public String toString() {
        return a() + "x" + b();
    }
}
