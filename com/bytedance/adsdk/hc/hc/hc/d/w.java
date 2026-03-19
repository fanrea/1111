package com.bytedance.adsdk.hc.hc.hc.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class w implements com.bytedance.adsdk.hc.hc.hc.d {
    protected com.bytedance.adsdk.hc.hc.c.b b;
    protected com.bytedance.adsdk.hc.hc.hc.d d;
    protected com.bytedance.adsdk.hc.hc.hc.d hc;

    protected w(com.bytedance.adsdk.hc.hc.c.b bVar) {
        this.b = bVar;
    }

    public void d(com.bytedance.adsdk.hc.hc.hc.d dVar) {
        this.d = dVar;
    }

    public void hc(com.bytedance.adsdk.hc.hc.hc.d dVar) {
        this.hc = dVar;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public com.bytedance.adsdk.hc.hc.c.u d() {
        return com.bytedance.adsdk.hc.hc.c.an.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public String hc() {
        return this.d.hc() + this.b.d() + this.hc.hc();
    }

    public String toString() {
        return hc();
    }
}
