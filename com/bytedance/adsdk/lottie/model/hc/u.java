package com.bytedance.adsdk.lottie.model.hc;

import android.graphics.Path;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements b {
    private final com.bytedance.adsdk.lottie.model.d.an an;
    private final com.bytedance.adsdk.lottie.model.d.b b;
    private final com.bytedance.adsdk.lottie.model.d.c c;
    private final h d;
    private final com.bytedance.adsdk.lottie.model.d.hc gb;
    private final String h;
    private final Path.FillType hc;
    private final boolean tc;
    private final com.bytedance.adsdk.lottie.model.d.hc tt;
    private final com.bytedance.adsdk.lottie.model.d.an u;

    public u(String str, h hVar, Path.FillType fillType, com.bytedance.adsdk.lottie.model.d.b bVar, com.bytedance.adsdk.lottie.model.d.c cVar, com.bytedance.adsdk.lottie.model.d.an anVar, com.bytedance.adsdk.lottie.model.d.an anVar2, com.bytedance.adsdk.lottie.model.d.hc hcVar, com.bytedance.adsdk.lottie.model.d.hc hcVar2, boolean z) {
        this.d = hVar;
        this.hc = fillType;
        this.b = bVar;
        this.c = cVar;
        this.u = anVar;
        this.an = anVar2;
        this.h = str;
        this.gb = hcVar;
        this.tt = hcVar2;
        this.tc = z;
    }

    public String d() {
        return this.h;
    }

    public h hc() {
        return this.d;
    }

    public Path.FillType b() {
        return this.hc;
    }

    public com.bytedance.adsdk.lottie.model.d.b c() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.d.c u() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.d.an an() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.d.an h() {
        return this.an;
    }

    public boolean gb() {
        return this.tc;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.gb(gbVar, anVar, bVar, this);
    }
}
