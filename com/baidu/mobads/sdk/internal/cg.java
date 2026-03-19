package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class cg implements an.b {
    final /* synthetic */ double a;
    final /* synthetic */ ca b;

    cg(ca caVar, double d) {
        this.b = caVar;
        this.a = d;
    }

    @Override // com.baidu.mobads.sdk.internal.an.b
    public void a(String str, String str2) {
        this.b.w = new by(str);
        double dB = cn.b();
        float f = this.b.m().getFloat(ca.c, 0.0f);
        Boolean boolValueOf = Boolean.valueOf(((float) this.b.w.b()) == f);
        Boolean boolValueOf2 = Boolean.valueOf(dB <= this.b.w.b() && Math.floor(dB) == Math.floor(this.b.w.b()));
        this.b.z.a(ca.a, "try to download apk badVer=" + f + ", isBad=" + boolValueOf + ", compatible=" + boolValueOf2);
        if (this.a >= this.b.w.b() || this.b.w == null || !this.b.w.a().booleanValue() || !boolValueOf2.booleanValue() || boolValueOf.booleanValue()) {
            if (this.b.A) {
                this.b.A = false;
                this.b.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        ca caVar = this.b;
        caVar.a(caVar.w);
    }

    @Override // com.baidu.mobads.sdk.internal.an.b
    public void a(String str, int i) {
        if (this.b.A) {
            this.b.A = false;
            this.b.a(false, "remote update Network access failed");
        }
    }
}
