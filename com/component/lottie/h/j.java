package com.component.lottie.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j<T> {
    private final b<T> a;
    private com.component.lottie.a.b.a<?, ?> b;
    protected T e;

    public j() {
        this.a = new b<>();
        this.e = null;
    }

    public j(T t) {
        this.a = new b<>();
        this.e = null;
        this.e = t;
    }

    public T a(b<T> bVar) {
        return this.e;
    }

    public final void a(T t) {
        this.e = t;
        if (this.b != null) {
            this.b.b();
        }
    }

    public final T a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a((b) this.a.a(f, f2, t, t2, f3, f4, f5));
    }

    public final void a(com.component.lottie.a.b.a<?, ?> aVar) {
        this.b = aVar;
    }
}
