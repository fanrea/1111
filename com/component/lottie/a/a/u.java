package com.component.lottie.a.a;

import android.graphics.PointF;
import com.component.lottie.a.b.a;
import com.component.lottie.af;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class u implements w, a.InterfaceC0322a {
    private static final float a = 0.5519f;
    private final af b;
    private final String c;
    private final com.component.lottie.a.b.a<Float, Float> d;
    private com.component.lottie.d.b.n e;

    public u(af afVar, com.component.lottie.d.c.a aVar, com.component.lottie.d.b.m mVar) {
        this.b = afVar;
        this.c = mVar.a();
        this.d = mVar.b().a();
        aVar.a(this.d);
        this.d.a(this);
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.c;
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        this.b.invalidateSelf();
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
    }

    public com.component.lottie.a.b.a<Float, Float> c() {
        return this.d;
    }

    @Override // com.component.lottie.a.a.w
    public com.component.lottie.d.b.n a(com.component.lottie.d.b.n nVar) {
        List<com.component.lottie.d.a> list;
        boolean z;
        List<com.component.lottie.d.a> listC = nVar.c();
        if (listC.size() <= 2) {
            return nVar;
        }
        float fFloatValue = this.d.g().floatValue();
        if (fFloatValue == 0.0f) {
            return nVar;
        }
        com.component.lottie.d.b.n nVarB = b(nVar);
        nVarB.a(nVar.a().x, nVar.a().y);
        List<com.component.lottie.d.a> listC2 = nVarB.c();
        boolean zB = nVar.b();
        int i = 0;
        int i2 = 0;
        while (i < listC.size()) {
            com.component.lottie.d.a aVar = listC.get(i);
            com.component.lottie.d.a aVar2 = listC.get(a(i - 1, listC.size()));
            com.component.lottie.d.a aVar3 = listC.get(a(i - 2, listC.size()));
            PointF pointFC = (i != 0 || zB) ? aVar2.c() : nVar.a();
            PointF pointFB = (i != 0 || zB) ? aVar2.b() : pointFC;
            PointF pointFA = aVar.a();
            PointF pointFC2 = aVar3.c();
            PointF pointFC3 = aVar.c();
            boolean z2 = !nVar.b() && i == 0 && i == listC.size() + (-1);
            if (!pointFB.equals(pointFC) || !pointFA.equals(pointFC) || z2) {
                list = listC;
                z = zB;
                com.component.lottie.d.a aVar4 = listC2.get(a(i2 - 1, listC2.size()));
                com.component.lottie.d.a aVar5 = listC2.get(i2);
                aVar4.b(aVar2.c().x, aVar2.c().y);
                aVar4.c(aVar2.c().x, aVar2.c().y);
                aVar5.a(aVar.c().x, aVar.c().y);
            } else {
                float f = pointFC.x - pointFC2.x;
                float f2 = pointFC.y - pointFC2.y;
                float f3 = pointFC3.x - pointFC.x;
                float f4 = pointFC3.y - pointFC.y;
                list = listC;
                z = zB;
                float fHypot = (float) Math.hypot(f, f2);
                float fHypot2 = (float) Math.hypot(f3, f4);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f5 = pointFC.x + ((pointFC2.x - pointFC.x) * fMin);
                float f6 = pointFC.y + ((pointFC2.y - pointFC.y) * fMin);
                float f7 = pointFC.x + ((pointFC3.x - pointFC.x) * fMin2);
                float f8 = pointFC.y + ((pointFC3.y - pointFC.y) * fMin2);
                float f9 = f5 - ((f5 - pointFC.x) * a);
                float f10 = f6 - ((f6 - pointFC.y) * a);
                float f11 = f7 - ((f7 - pointFC.x) * a);
                float f12 = f8 - ((f8 - pointFC.y) * a);
                com.component.lottie.d.a aVar6 = listC2.get(a(i2 - 1, listC2.size()));
                com.component.lottie.d.a aVar7 = listC2.get(i2);
                aVar6.b(f5, f6);
                aVar6.c(f5, f6);
                if (i == 0) {
                    nVarB.a(f5, f6);
                }
                aVar7.a(f9, f10);
                i2++;
                com.component.lottie.d.a aVar8 = listC2.get(i2);
                aVar7.b(f11, f12);
                aVar7.c(f7, f8);
                aVar8.a(f7, f8);
            }
            i2++;
            i++;
            listC = list;
            zB = z;
        }
        return nVarB;
    }

    private com.component.lottie.d.b.n b(com.component.lottie.d.b.n nVar) {
        List<com.component.lottie.d.a> listC = nVar.c();
        boolean zB = nVar.b();
        int size = listC.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.component.lottie.d.a aVar = listC.get(size);
            com.component.lottie.d.a aVar2 = listC.get(a(size - 1, listC.size()));
            PointF pointFC = (size != 0 || zB) ? aVar2.c() : nVar.a();
            PointF pointFB = (size != 0 || zB) ? aVar2.b() : pointFC;
            PointF pointFA = aVar.a();
            boolean z = !nVar.b() && size == 0 && size == listC.size() - 1;
            if (pointFB.equals(pointFC) && pointFA.equals(pointFC) && !z) {
                i += 2;
            } else {
                i++;
            }
            size--;
        }
        if (this.e == null || this.e.c().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.component.lottie.d.a());
            }
            this.e = new com.component.lottie.d.b.n(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.e.a(zB);
        return this.e;
    }

    private static int a(int i, int i2) {
        return i - (b(i, i2) * i2);
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i2 * i3 != i) {
            return i3 - 1;
        }
        return i3;
    }
}
