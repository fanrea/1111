package com.component.lottie.d.b;

import android.graphics.PointF;
import com.component.lottie.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j implements c {
    private final String a;
    private final a b;
    private final com.component.lottie.d.a.b c;
    private final com.component.lottie.d.a.m<PointF, PointF> d;
    private final com.component.lottie.d.a.b e;
    private final com.component.lottie.d.a.b f;
    private final com.component.lottie.d.a.b g;
    private final com.component.lottie.d.a.b h;
    private final com.component.lottie.d.a.b i;
    private final boolean j;
    private final boolean k;

    public enum a {
        STAR(1),
        POLYGON(2);

        private final int c;

        a(int i) {
            this.c = i;
        }

        public static a a(int i) {
            for (a aVar : values()) {
                if (aVar.c == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public j(String str, a aVar, com.component.lottie.d.a.b bVar, com.component.lottie.d.a.m<PointF, PointF> mVar, com.component.lottie.d.a.b bVar2, com.component.lottie.d.a.b bVar3, com.component.lottie.d.a.b bVar4, com.component.lottie.d.a.b bVar5, com.component.lottie.d.a.b bVar6, boolean z, boolean z2) {
        this.a = str;
        this.b = aVar;
        this.c = bVar;
        this.d = mVar;
        this.e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
        this.j = z;
        this.k = z2;
    }

    public String a() {
        return this.a;
    }

    public a b() {
        return this.b;
    }

    public com.component.lottie.d.a.b c() {
        return this.c;
    }

    public com.component.lottie.d.a.m<PointF, PointF> d() {
        return this.d;
    }

    public com.component.lottie.d.a.b e() {
        return this.e;
    }

    public com.component.lottie.d.a.b f() {
        return this.f;
    }

    public com.component.lottie.d.a.b g() {
        return this.g;
    }

    public com.component.lottie.d.a.b h() {
        return this.h;
    }

    public com.component.lottie.d.a.b i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.k;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new com.component.lottie.a.a.q(afVar, aVar, this);
    }
}
