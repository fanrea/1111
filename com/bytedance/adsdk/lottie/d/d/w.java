package com.bytedance.adsdk.lottie.d.d;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.d.hc.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class w implements rf, d.InterfaceC0167d {
    private final com.bytedance.adsdk.lottie.d.hc.d<Float, Float> b;
    private com.bytedance.adsdk.lottie.model.hc.k c;
    private final com.bytedance.adsdk.lottie.gb d;
    private final String hc;

    @Override // com.bytedance.adsdk.lottie.d.d.b
    public void d(List<b> list, List<b> list2) {
    }

    public w(com.bytedance.adsdk.lottie.gb gbVar, com.bytedance.adsdk.lottie.model.layer.b bVar, com.bytedance.adsdk.lottie.model.hc.uo uoVar) {
        this.d = gbVar;
        this.hc = uoVar.d();
        com.bytedance.adsdk.lottie.d.hc.d<Float, Float> dVarD = uoVar.hc().d();
        this.b = dVarD;
        bVar.d(dVarD);
        dVarD.d(this);
    }

    @Override // com.bytedance.adsdk.lottie.d.hc.d.InterfaceC0167d
    public void d() {
        this.d.invalidateSelf();
    }

    public com.bytedance.adsdk.lottie.d.hc.d<Float, Float> hc() {
        return this.b;
    }

    @Override // com.bytedance.adsdk.lottie.d.d.rf
    public com.bytedance.adsdk.lottie.model.hc.k d(com.bytedance.adsdk.lottie.model.hc.k kVar) {
        List<com.bytedance.adsdk.lottie.model.d> list;
        boolean z;
        List<com.bytedance.adsdk.lottie.model.d> listB = kVar.b();
        if (listB.size() <= 2) {
            return kVar;
        }
        float fFloatValue = this.b.h().floatValue();
        if (fFloatValue == 0.0f) {
            return kVar;
        }
        com.bytedance.adsdk.lottie.model.hc.k kVarHc = hc(kVar);
        kVarHc.d(kVar.d().x, kVar.d().y);
        List<com.bytedance.adsdk.lottie.model.d> listB2 = kVarHc.b();
        boolean zHc = kVar.hc();
        int i = 0;
        int i2 = 0;
        while (i < listB.size()) {
            com.bytedance.adsdk.lottie.model.d dVar = listB.get(i);
            com.bytedance.adsdk.lottie.model.d dVar2 = listB.get(d(i - 1, listB.size()));
            com.bytedance.adsdk.lottie.model.d dVar3 = listB.get(d(i - 2, listB.size()));
            PointF pointFB = (i != 0 || zHc) ? dVar2.b() : kVar.d();
            PointF pointFHc = (i != 0 || zHc) ? dVar2.hc() : pointFB;
            PointF pointFD = dVar.d();
            PointF pointFB2 = dVar3.b();
            PointF pointFB3 = dVar.b();
            boolean z2 = !kVar.hc() && i == 0 && i == listB.size() + (-1);
            if (pointFHc.equals(pointFB) && pointFD.equals(pointFB) && !z2) {
                float f = pointFB.x - pointFB2.x;
                float f2 = pointFB.y - pointFB2.y;
                float f3 = pointFB3.x - pointFB.x;
                float f4 = pointFB3.y - pointFB.y;
                list = listB;
                z = zHc;
                float fHypot = (float) Math.hypot(f, f2);
                float fHypot2 = (float) Math.hypot(f3, f4);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f5 = pointFB.x + ((pointFB2.x - pointFB.x) * fMin);
                float f6 = pointFB.y + ((pointFB2.y - pointFB.y) * fMin);
                float f7 = pointFB.x + ((pointFB3.x - pointFB.x) * fMin2);
                float f8 = pointFB.y + ((pointFB3.y - pointFB.y) * fMin2);
                float f9 = f5 - ((f5 - pointFB.x) * 0.5519f);
                float f10 = f6 - ((f6 - pointFB.y) * 0.5519f);
                float f11 = f7 - ((f7 - pointFB.x) * 0.5519f);
                float f12 = f8 - ((f8 - pointFB.y) * 0.5519f);
                com.bytedance.adsdk.lottie.model.d dVar4 = listB2.get(d(i2 - 1, listB2.size()));
                com.bytedance.adsdk.lottie.model.d dVar5 = listB2.get(i2);
                dVar4.hc(f5, f6);
                dVar4.b(f5, f6);
                if (i == 0) {
                    kVarHc.d(f5, f6);
                }
                dVar5.d(f9, f10);
                i2++;
                com.bytedance.adsdk.lottie.model.d dVar6 = listB2.get(i2);
                dVar5.hc(f11, f12);
                dVar5.b(f7, f8);
                dVar6.d(f7, f8);
            } else {
                list = listB;
                z = zHc;
                com.bytedance.adsdk.lottie.model.d dVar7 = listB2.get(d(i2 - 1, listB2.size()));
                com.bytedance.adsdk.lottie.model.d dVar8 = listB2.get(i2);
                dVar7.hc(dVar2.hc().x, dVar2.hc().y);
                dVar7.b(dVar2.b().x, dVar2.b().y);
                dVar8.d(dVar.d().x, dVar.d().y);
            }
            i2++;
            i++;
            listB = list;
            zHc = z;
        }
        return kVarHc;
    }

    private com.bytedance.adsdk.lottie.model.hc.k hc(com.bytedance.adsdk.lottie.model.hc.k kVar) {
        List<com.bytedance.adsdk.lottie.model.d> listB = kVar.b();
        boolean zHc = kVar.hc();
        int size = listB.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.lottie.model.d dVar = listB.get(size);
            com.bytedance.adsdk.lottie.model.d dVar2 = listB.get(d(size - 1, listB.size()));
            PointF pointFB = (size != 0 || zHc) ? dVar2.b() : kVar.d();
            i = (((size != 0 || zHc) ? dVar2.hc() : pointFB).equals(pointFB) && dVar.d().equals(pointFB) && !(!kVar.hc() && size == 0 && size == listB.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.lottie.model.hc.k kVar2 = this.c;
        if (kVar2 == null || kVar2.b().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.lottie.model.d());
            }
            this.c = new com.bytedance.adsdk.lottie.model.hc.k(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.c.d(zHc);
        return this.c;
    }

    private static int d(int i, int i2) {
        return i - (hc(i, i2) * i2);
    }

    private static int hc(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
