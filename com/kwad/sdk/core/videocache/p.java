package com.kwad.sdk.core.videocache;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class p implements m {
    protected volatile String bJL;
    protected volatile int length = Integer.MIN_VALUE;
    protected String url;

    public abstract String ade();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.bJL + "'}";
    }
}
