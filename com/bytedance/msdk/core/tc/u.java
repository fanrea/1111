package com.bytedance.msdk.core.tc;

import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements Comparable<u> {
    private int b;
    private int c;
    private String d;
    private double hc;

    public u(String str, double d, int i, int i2) {
        this.d = str;
        this.hc = d;
        this.b = i;
        this.c = i2;
    }

    public String d() {
        return this.d;
    }

    public double hc() {
        return this.hc;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String toString() {
        return "{mCsjRitId:" + this.d + ",mEcpm:" + this.hc + ",mLoadSort:" + this.b + ",mShowSort:" + this.c + i.d;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        if (uVar == null) {
            return 1;
        }
        if (this.hc > uVar.hc()) {
            return -1;
        }
        if (this.hc < uVar.hc() || this.b > uVar.b()) {
            return 1;
        }
        if (this.b < uVar.b()) {
            return -1;
        }
        if (this.c > uVar.c()) {
            return 1;
        }
        return this.c < uVar.c() ? -1 : 0;
    }
}
