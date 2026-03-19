package com.component.lottie.d;

import com.component.lottie.d.b.p;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private final List<p> a;
    private final char b;
    private final double c;
    private final double d;
    private final String e;
    private final String f;

    public static int a(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<p> list, char c, double d, double d2, String str, String str2) {
        this.a = list;
        this.b = c;
        this.c = d;
        this.d = d2;
        this.e = str;
        this.f = str2;
    }

    public List<p> a() {
        return this.a;
    }

    public double b() {
        return this.d;
    }

    public int hashCode() {
        return a(this.b, this.f, this.e);
    }
}
