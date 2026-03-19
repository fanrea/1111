package com.bytedance.adsdk.lottie.d.hc;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.d.d.rf;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo extends d<com.bytedance.adsdk.lottie.model.hc.k, Path> {
    private List<rf> an;
    private final com.bytedance.adsdk.lottie.model.hc.k c;
    private final Path u;

    public uo(List<com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.k>> list) {
        super(list);
        this.c = new com.bytedance.adsdk.lottie.model.hc.k();
        this.u = new Path();
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public Path d(com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.k> dVar, float f) {
        this.c.d(dVar.d, dVar.hc, f);
        com.bytedance.adsdk.lottie.model.hc.k kVarD = this.c;
        List<rf> list = this.an;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                kVarD = this.an.get(size).d(kVarD);
            }
        }
        com.bytedance.adsdk.lottie.u.gb.d(kVarD, this.u);
        return this.u;
    }

    public void d(List<rf> list) {
        this.an = list;
    }
}
