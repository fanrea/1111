package com.bytedance.adsdk.lottie.model.hc;

import android.graphics.Path;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e implements b {
    private final boolean an;
    private final String b;
    private final com.bytedance.adsdk.lottie.model.d.d c;
    private final boolean d;
    private final Path.FillType hc;
    private final com.bytedance.adsdk.lottie.model.d.c u;

    public e(String str, boolean z, Path.FillType fillType, com.bytedance.adsdk.lottie.model.d.d dVar, com.bytedance.adsdk.lottie.model.d.c cVar, boolean z2) {
        this.b = str;
        this.d = z;
        this.hc = fillType;
        this.c = dVar;
        this.u = cVar;
        this.an = z2;
    }

    public String d() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.d.d hc() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.d.c b() {
        return this.u;
    }

    public Path.FillType c() {
        return this.hc;
    }

    public boolean u() {
        return this.an;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.h(gbVar, bVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.d + '}';
    }
}
