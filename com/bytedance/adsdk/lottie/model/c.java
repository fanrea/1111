package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.model.hc.cb;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private final String an;
    private final double b;
    private final double c;
    private final List<cb> d;
    private final char hc;
    private final String u;

    public static int d(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public c(List<cb> list, char c, double d, double d2, String str, String str2) {
        this.d = list;
        this.hc = c;
        this.b = d;
        this.c = d2;
        this.u = str;
        this.an = str2;
    }

    public List<cb> d() {
        return this.d;
    }

    public double hc() {
        return this.c;
    }

    public int hashCode() {
        return d(this.hc, this.an, this.u);
    }
}
