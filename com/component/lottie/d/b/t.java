package com.component.lottie.d.b;

import com.component.lottie.a.a.y;
import com.component.lottie.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t implements c {
    private final String a;
    private final a b;
    private final com.component.lottie.d.a.b c;
    private final com.component.lottie.d.a.b d;
    private final com.component.lottie.d.a.b e;
    private final boolean f;

    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a a(int i) {
            switch (i) {
                case 1:
                    return SIMULTANEOUSLY;
                case 2:
                    return INDIVIDUALLY;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    public t(String str, a aVar, com.component.lottie.d.a.b bVar, com.component.lottie.d.a.b bVar2, com.component.lottie.d.a.b bVar3, boolean z) {
        this.a = str;
        this.b = aVar;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
        this.f = z;
    }

    public String a() {
        return this.a;
    }

    public a b() {
        return this.b;
    }

    public com.component.lottie.d.a.b c() {
        return this.d;
    }

    public com.component.lottie.d.a.b d() {
        return this.c;
    }

    public com.component.lottie.d.a.b e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new y(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + com.alipay.sdk.m.u.i.d;
    }
}
