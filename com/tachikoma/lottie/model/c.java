package com.tachikoma.lottie.model;

import com.tachikoma.lottie.model.content.j;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c {
    private final double KG;
    private final String KO;
    private final List<j> KP;
    private final char KQ;
    private final double KR;
    private final String KS;

    public static int a(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public c(List<j> list, char c, double d, double d2, String str, String str2) {
        this.KP = list;
        this.KQ = c;
        this.KG = d;
        this.KR = d2;
        this.KO = str;
        this.KS = str2;
    }

    public final List<j> kw() {
        return this.KP;
    }

    public final double kx() {
        return this.KR;
    }

    public final int hashCode() {
        return a(this.KQ, this.KS, this.KO);
    }
}
