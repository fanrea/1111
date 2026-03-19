package com.kwad.sdk.commercial.f;

import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String bub;
    public String buj;
    public int status;
    public String url;

    public static b WF() {
        return new b();
    }

    public final b eo(int i) {
        this.status = i;
        return this;
    }

    public final b eh(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.bub = url.getHost();
            this.buj = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }
}
