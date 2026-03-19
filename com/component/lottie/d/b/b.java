package com.component.lottie.d.b;

import android.graphics.PointF;
import com.component.lottie.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements c {
    private final String a;
    private final com.component.lottie.d.a.m<PointF, PointF> b;
    private final com.component.lottie.d.a.f c;
    private final boolean d;
    private final boolean e;

    public b(String str, com.component.lottie.d.a.m<PointF, PointF> mVar, com.component.lottie.d.a.f fVar, boolean z, boolean z2) {
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.d = z;
        this.e = z2;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new com.component.lottie.a.a.g(afVar, aVar, this);
    }

    public String a() {
        return this.a;
    }

    public com.component.lottie.d.a.m<PointF, PointF> b() {
        return this.b;
    }

    public com.component.lottie.d.a.f c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}
