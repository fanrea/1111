package com.kwad.sdk.commercial.b;

import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String bub;
    public String buj;
    public String buk;
    public int bul;
    public int bum;
    public int status;
    public String url;

    public static b WB() {
        return new b();
    }

    public final b ek(int i) {
        this.status = i;
        return this;
    }

    public final b dY(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.bub = url.getHost();
            this.buj = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b el(int i) {
        this.bul = i;
        return this;
    }

    public final b em(int i) {
        this.bum = i;
        return this;
    }

    public final b dZ(String str) {
        this.buk = str;
        return this;
    }
}
