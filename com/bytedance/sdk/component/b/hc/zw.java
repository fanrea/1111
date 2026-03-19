package com.bytedance.sdk.component.b.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class zw {
    long an;
    long b;
    long c;
    long d = System.currentTimeMillis();
    long h;
    long hc;
    long u;

    public void d() {
        this.b = System.currentTimeMillis();
    }

    public void hc() {
        this.c = System.currentTimeMillis();
    }

    public void b() {
        this.u = System.currentTimeMillis();
    }

    public long c() {
        return this.d;
    }

    public long u() {
        return this.b;
    }

    public long an() {
        return this.c;
    }

    public long h() {
        return this.u;
    }

    public long gb() {
        return this.an;
    }

    public void d(long j) {
        this.an = j;
    }

    public long tt() {
        return this.h;
    }

    public void hc(long j) {
        this.h = j;
    }

    public long tc() {
        return this.hc;
    }

    public void mk() {
        this.hc = System.currentTimeMillis();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.d + ", asyncCallExecTs=" + this.hc + ", requestStartExecTs=" + this.b + ", requestConnectStartTs=" + this.c + ", requestConnectFinishTs=" + this.u + ", reqCallServerStartTs=" + this.an + ", reqCallServerFinishTs=" + this.h + '}';
    }
}
