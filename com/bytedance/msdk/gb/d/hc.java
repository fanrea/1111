package com.bytedance.msdk.gb.d;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private String b;
    private String c;
    private String d;
    private String hc;
    private long u;

    public void d(String str) {
        this.d = str;
    }

    public void hc(String str) {
        this.hc = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(long j) {
        this.u = j;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.d + "', adnRit='" + this.hc + "', adnName='" + this.b + "', adAction='" + this.c + "', timeStamp=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.u)) + '}';
    }
}
