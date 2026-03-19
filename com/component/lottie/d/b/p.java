package com.component.lottie.d.b;

import com.component.lottie.af;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class p implements c {
    private final String a;
    private final List<c> b;
    private final boolean c;

    public p(String str, List<c> list, boolean z) {
        this.a = str;
        this.b = list;
        this.c = z;
    }

    public String a() {
        return this.a;
    }

    public List<c> b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        return new com.component.lottie.a.a.e(afVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
