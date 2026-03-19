package com.bytedance.adsdk.lottie.model.hc;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb implements b {
    private final boolean b;
    private final String d;
    private final List<b> hc;

    public cb(String str, List<b> list, boolean z) {
        this.d = str;
        this.hc = list;
        this.b = z;
    }

    public String d() {
        return this.d;
    }

    public List<b> hc() {
        return this.hc;
    }

    public boolean b() {
        return this.b;
    }

    @Override // com.bytedance.adsdk.lottie.model.hc.b
    public com.bytedance.adsdk.lottie.d.d.b d(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.an anVar, com.bytedance.adsdk.lottie.model.layer.b bVar) {
        return new com.bytedance.adsdk.lottie.d.d.c(gbVar, bVar, this, anVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.d + "' Shapes: " + Arrays.toString(this.hc.toArray()) + '}';
    }
}
