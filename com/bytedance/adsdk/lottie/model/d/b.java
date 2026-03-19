package com.bytedance.adsdk.lottie.model.d;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends k<com.bytedance.adsdk.lottie.model.hc.c, com.bytedance.adsdk.lottie.model.hc.c> {
    @Override // com.bytedance.adsdk.lottie.model.d.k, com.bytedance.adsdk.lottie.model.d.uo
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    @Override // com.bytedance.adsdk.lottie.model.d.k, com.bytedance.adsdk.lottie.model.d.uo
    public /* bridge */ /* synthetic */ boolean hc() {
        return super.hc();
    }

    @Override // com.bytedance.adsdk.lottie.model.d.k
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public b(List<com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.c>> list) {
        super(d(list));
    }

    private static List<com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.c>> d(List<com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.c>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, d(list.get(i)));
        }
        return list;
    }

    private static com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.c> d(com.bytedance.adsdk.lottie.an.d<com.bytedance.adsdk.lottie.model.hc.c> dVar) {
        com.bytedance.adsdk.lottie.model.hc.c cVar = dVar.d;
        com.bytedance.adsdk.lottie.model.hc.c cVar2 = dVar.hc;
        if (cVar == null || cVar2 == null || cVar.d().length == cVar2.d().length) {
            return dVar;
        }
        float[] fArrD = d(cVar.d(), cVar2.d());
        return dVar.d(cVar.d(fArrD), cVar2.d(fArrD));
    }

    static float[] d(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.d.uo
    public com.bytedance.adsdk.lottie.d.hc.d<com.bytedance.adsdk.lottie.model.hc.c, com.bytedance.adsdk.lottie.model.hc.c> d() {
        return new com.bytedance.adsdk.lottie.d.hc.u(this.d);
    }
}
