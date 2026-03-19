package com.kwad.sdk.commercial.smallApp;

import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String buH;
    public String buI;
    public String buJ;
    public String bub;
    public String buj;
    public int status;
    public String url;

    public static b a(JumpFrom jumpFrom) {
        return new b(jumpFrom);
    }

    private b(JumpFrom jumpFrom) {
        if (jumpFrom != null) {
            this.buJ = jumpFrom.getValue();
        }
    }

    public final b er(int i) {
        this.status = i;
        return this;
    }

    public final b en(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.bub = url.getHost();
            this.buj = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b eo(String str) {
        this.buH = str;
        return this;
    }

    public final b ep(String str) {
        this.buI = str;
        return this;
    }
}
