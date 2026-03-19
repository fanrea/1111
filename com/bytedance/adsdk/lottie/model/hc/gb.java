package com.bytedance.adsdk.lottie.model.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private final com.bytedance.adsdk.lottie.model.d.c b;
    private final boolean c;
    private final d d;
    private final com.bytedance.adsdk.lottie.model.d.gb hc;

    public enum d {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public gb(d dVar, com.bytedance.adsdk.lottie.model.d.gb gbVar, com.bytedance.adsdk.lottie.model.d.c cVar, boolean z) {
        this.d = dVar;
        this.hc = gbVar;
        this.b = cVar;
        this.c = z;
    }

    public d d() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.d.gb hc() {
        return this.hc;
    }

    public com.bytedance.adsdk.lottie.model.d.c b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
