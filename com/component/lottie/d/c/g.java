package com.component.lottie.d.c;

import com.component.lottie.t;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    private final List<com.component.lottie.d.b.c> a;
    private final t b;
    private final String c;
    private final long d;
    private final a e;
    private final long f;
    private final String g;
    private final List<com.component.lottie.d.b.h> h;
    private final com.component.lottie.d.a.l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final com.component.lottie.d.a.j q;
    private final com.component.lottie.d.a.k r;
    private final com.component.lottie.d.a.b s;
    private final List<com.component.lottie.h.a<Float>> t;
    private final b u;
    private final boolean v;
    private final com.component.lottie.d.b.a w;
    private final com.component.lottie.f.j x;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public g(List<com.component.lottie.d.b.c> list, t tVar, String str, long j, a aVar, long j2, String str2, List<com.component.lottie.d.b.h> list2, com.component.lottie.d.a.l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, com.component.lottie.d.a.j jVar, com.component.lottie.d.a.k kVar, List<com.component.lottie.h.a<Float>> list3, b bVar, com.component.lottie.d.a.b bVar2, boolean z, com.component.lottie.d.b.a aVar2, com.component.lottie.f.j jVar2) {
        this.a = list;
        this.b = tVar;
        this.c = str;
        this.d = j;
        this.e = aVar;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
        this.w = aVar2;
        this.x = jVar2;
    }

    t a() {
        return this.b;
    }

    float b() {
        return this.m;
    }

    float c() {
        return this.n / this.b.p();
    }

    List<com.component.lottie.h.a<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.d;
    }

    String f() {
        return this.c;
    }

    String g() {
        return this.g;
    }

    int h() {
        return this.o;
    }

    int i() {
        return this.p;
    }

    List<com.component.lottie.d.b.h> j() {
        return this.h;
    }

    public a k() {
        return this.e;
    }

    b l() {
        return this.u;
    }

    long m() {
        return this.f;
    }

    List<com.component.lottie.d.b.c> n() {
        return this.a;
    }

    com.component.lottie.d.a.l o() {
        return this.i;
    }

    int p() {
        return this.l;
    }

    int q() {
        return this.k;
    }

    int r() {
        return this.j;
    }

    com.component.lottie.d.a.j s() {
        return this.q;
    }

    com.component.lottie.d.a.k t() {
        return this.r;
    }

    com.component.lottie.d.a.b u() {
        return this.s;
    }

    public boolean v() {
        return this.v;
    }

    public com.component.lottie.d.b.a w() {
        return this.w;
    }

    public com.component.lottie.f.j x() {
        return this.x;
    }

    public String toString() {
        return a("");
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(f()).append("\n");
        g gVarA = this.b.a(m());
        if (gVarA != null) {
            sb.append("\t\tParents: ").append(gVarA.f());
            g gVarA2 = this.b.a(gVarA.m());
            while (gVarA2 != null) {
                sb.append("->").append(gVarA2.f());
                gVarA2 = this.b.a(gVarA2.m());
            }
            sb.append(str).append("\n");
        }
        if (!j().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(j().size()).append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.component.lottie.d.b.c> it = this.a.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
