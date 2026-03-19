package com.sigmob.sdk.videocache;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class v {
    public final String a;
    public final long b;
    public final String c;

    public v(String url, long length, String mime) {
        this.a = url;
        this.b = length;
        this.c = mime;
    }

    public String toString() {
        return "SourceInfo{url='" + this.a + "', length=" + this.b + ", mime='" + this.c + "'}";
    }
}
