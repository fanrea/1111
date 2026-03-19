package com.component.lottie.h;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
abstract class f<T> extends j<T> {
    private final T a;
    private final T b;
    private final Interpolator c;

    abstract T a(T t, T t2, float f);

    f(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    f(T t, T t2, Interpolator interpolator) {
        this.a = t;
        this.b = t2;
        this.c = interpolator;
    }

    @Override // com.component.lottie.h.j
    public T a(b<T> bVar) {
        return a(this.a, this.b, this.c.getInterpolation(bVar.g()));
    }
}
