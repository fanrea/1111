package com.component.lottie.f;

import android.graphics.PointF;
import com.baidu.mobstat.forbes.Config;
import com.component.lottie.f.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class aj implements ap<com.component.lottie.d.b.n> {
    public static final aj a = new aj();
    private static final c.a b = c.a.a("c", "v", "i", Config.OS);

    private aj() {
    }

    @Override // com.component.lottie.f.ap
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.component.lottie.d.b.n b(com.component.lottie.f.a.c cVar, float f) {
        if (cVar.f() == c.b.BEGIN_ARRAY) {
            cVar.a();
        }
        cVar.c();
        List<PointF> listA = null;
        List<PointF> listA2 = null;
        List<PointF> listA3 = null;
        boolean zJ = false;
        while (cVar.e()) {
            switch (cVar.a(b)) {
                case 0:
                    zJ = cVar.j();
                    break;
                case 1:
                    listA = s.a(cVar, f);
                    break;
                case 2:
                    listA2 = s.a(cVar, f);
                    break;
                case 3:
                    listA3 = s.a(cVar, f);
                    break;
                default:
                    cVar.h();
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        if (cVar.f() == c.b.END_ARRAY) {
            cVar.b();
        }
        if (listA == null || listA2 == null || listA3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listA.isEmpty()) {
            return new com.component.lottie.d.b.n(new PointF(), false, Collections.emptyList());
        }
        int size = listA.size();
        PointF pointF = listA.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listA.get(i);
            int i2 = i - 1;
            arrayList.add(new com.component.lottie.d.a(com.component.lottie.g.f.a(listA.get(i2), listA3.get(i2)), com.component.lottie.g.f.a(pointF2, listA2.get(i)), pointF2));
        }
        if (zJ) {
            PointF pointF3 = listA.get(0);
            int i3 = size - 1;
            arrayList.add(new com.component.lottie.d.a(com.component.lottie.g.f.a(listA.get(i3), listA3.get(i3)), com.component.lottie.g.f.a(pointF3, listA2.get(0)), pointF3));
        }
        return new com.component.lottie.d.b.n(pointF, zJ, arrayList);
    }
}
