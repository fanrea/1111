package com.component.lottie.d.b;

import android.graphics.Path;
import com.component.lottie.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o implements c {
    private final boolean a;
    private final Path.FillType b;
    private final String c;
    private final com.component.lottie.d.a.a d;
    private final com.component.lottie.d.a.d e;
    private final boolean f;

    public o(String str, boolean z, Path.FillType fillType, com.component.lottie.d.a.a aVar, com.component.lottie.d.a.d dVar, boolean z2) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = aVar;
        this.e = dVar;
        this.f = z2;
    }

    public String a() {
        return this.c;
    }

    public com.component.lottie.d.a.a b() {
        return this.d;
    }

    public com.component.lottie.d.a.d c() {
        return this.e;
    }

    public Path.FillType d() {
        return this.b;
    }

    public boolean e() {
        return this.f;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new com.component.lottie.a.a.h(afVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
