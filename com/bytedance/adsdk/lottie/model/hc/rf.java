package com.bytedance.adsdk.lottie.model.hc;

import com.alipay.sdk.m.u.i;
import com.bytedance.adsdk.lottie.d.d.sy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class rf implements b {
    private final boolean an;
    private final com.bytedance.adsdk.lottie.model.d.hc b;
    private final com.bytedance.adsdk.lottie.model.d.hc c;
    private final String d;
    private final d hc;
    private final com.bytedance.adsdk.lottie.model.d.hc u;

    public enum d {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static d d(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public rf(String str, d dVar, com.bytedance.adsdk.lottie.model.d.hc hcVar, com.bytedance.adsdk.lottie.model.d.hc hcVar2, com.bytedance.adsdk.lottie.model.d.hc hcVar3, boolean z) {
        this.d = str;
        this.hc = dVar;
        this.b = hcVar;
        this.c = hcVar2;
        this.u = hcVar3;
        this.an = z;
    }

    public String d() {
        return this.d;
    }

    public d getType() {
        return this.hc;
    }

    public com.bytedance.adsdk.lottie.model.d.hc hc() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.d.hc b() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.d.hc c() {
        return this.u;
    }

    public boolean u() {
        return this.an;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new sy(bVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.b + ", end: " + this.c + ", offset: " + this.u + i.d;
    }
}
