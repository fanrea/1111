package com.kwad.lottie.model;

import com.kwad.lottie.model.content.j;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private final double bmX;
    private final List<j> bnf;
    private final char bng;
    private final double bnh;
    private final String bni;
    private final String style;

    public static int a(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<j> list, char c, double d, double d2, String str, String str2) {
        this.bnf = list;
        this.bng = c;
        this.bmX = d;
        this.bnh = d2;
        this.style = str;
        this.bni = str2;
    }

    public final List<j> Re() {
        return this.bnf;
    }

    public final double Rf() {
        return this.bnh;
    }

    public final int hashCode() {
        return a(this.bng, this.bni, this.style);
    }
}
