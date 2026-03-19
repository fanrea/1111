package com.bytedance.msdk.core.gb;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private long b;
    private List<String> d;
    private List<String> hc;

    public long d() {
        return this.b;
    }

    public void d(long j) {
        this.b = j;
    }

    public List<String> hc() {
        return this.d;
    }

    public void d(List<String> list) {
        this.d = list;
    }

    public List<String> b() {
        return this.hc;
    }

    public void hc(List<String> list) {
        this.hc = list;
    }

    public String toString() {
        return "AdnLoadFailShowConfigBean{ breadRequestErrorCode=" + this.d + ",ritList=" + this.hc + ",breadRequestDuration=" + this.b + " }";
    }
}
