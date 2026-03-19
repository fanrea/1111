package com.bytedance.adsdk.lottie.model.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class w implements b {
    private final com.bytedance.adsdk.lottie.model.d.gb b;
    private final boolean c;
    private final String d;
    private final int hc;

    public w(String str, int i, com.bytedance.adsdk.lottie.model.d.gb gbVar, boolean z) {
        this.d = str;
        this.hc = i;
        this.b = gbVar;
        this.c = z;
    }

    public String d() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.d.gb hc() {
        return this.b;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.yo(gbVar, bVar, this);
    }

    public boolean b() {
        return this.c;
    }

    public String toString() {
        return "ShapePath{name=" + this.d + ", index=" + this.hc + '}';
    }
}
