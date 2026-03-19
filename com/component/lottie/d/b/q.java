package com.component.lottie.d.b;

import com.component.lottie.a.a.v;
import com.component.lottie.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class q implements c {
    private final String a;
    private final int b;
    private final com.component.lottie.d.a.h c;
    private final boolean d;

    public q(String str, int i, com.component.lottie.d.a.h hVar, boolean z) {
        this.a = str;
        this.b = i;
        this.c = hVar;
        this.d = z;
    }

    public String a() {
        return this.a;
    }

    public com.component.lottie.d.a.h b() {
        return this.c;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new v(afVar, aVar, this);
    }

    public boolean c() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + '}';
    }
}
