package com.component.lottie.d.b;

import android.graphics.PointF;
import com.component.lottie.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k implements c {
    private final String a;
    private final com.component.lottie.d.a.m<PointF, PointF> b;
    private final com.component.lottie.d.a.m<PointF, PointF> c;
    private final com.component.lottie.d.a.b d;
    private final boolean e;

    public k(String str, com.component.lottie.d.a.m<PointF, PointF> mVar, com.component.lottie.d.a.m<PointF, PointF> mVar2, com.component.lottie.d.a.b bVar, boolean z) {
        this.a = str;
        this.b = mVar;
        this.c = mVar2;
        this.d = bVar;
        this.e = z;
    }

    public String a() {
        return this.a;
    }

    public com.component.lottie.d.a.b b() {
        return this.d;
    }

    public com.component.lottie.d.a.m<PointF, PointF> c() {
        return this.c;
    }

    public com.component.lottie.d.a.m<PointF, PointF> d() {
        return this.b;
    }

    public boolean e() {
        return this.e;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new com.component.lottie.a.a.s(afVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + '}';
    }
}
