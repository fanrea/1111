package com.bytedance.msdk.core.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private long b;
    private String c;
    private String d;
    private String hc;

    public d(String str, String str2, long j) {
        this(str, str2, j, null);
    }

    public d(String str, String str2, long j, String str3) {
        this.d = str2;
        this.hc = str;
        this.b = j;
        this.c = str3;
    }

    public long d() {
        return this.b;
    }

    public String hc() {
        return this.c;
    }

    public String toString() {
        return "AdnLoadFailShowBean{slotId='" + this.d + "', adnName='" + this.hc + "', effectiveTime=" + this.b + '}';
    }
}
