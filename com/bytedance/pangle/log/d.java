package com.bytedance.pangle.log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private String b;
    private long c;
    private String d;
    private String hc;
    private long u;

    public static d d(String str, String str2, String str3) {
        return new d(str, str2, str3);
    }

    private d(String str, String str2, String str3) {
        this.d = str;
        this.hc = str2;
        this.b = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.u = jCurrentTimeMillis;
        this.c = jCurrentTimeMillis;
        ZeusLogger.i(this.d, this.hc + String.format(" watcher[%s]-start", str3));
    }

    public long d(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.u;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.c;
        ZeusLogger.i(this.d, this.hc + String.format(" watcher[%s]-%s cost=%s, total=%s", this.b, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public long d() {
        return System.currentTimeMillis() - this.c;
    }
}
