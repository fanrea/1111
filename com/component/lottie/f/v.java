package com.component.lottie.f;

import com.component.lottie.f.a.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class v {
    static c.a a = c.a.a("k");

    private v() {
    }

    static <T> List<com.component.lottie.h.a<T>> a(com.component.lottie.f.a.c cVar, com.component.lottie.t tVar, float f, ap<T> apVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (cVar.f() == c.b.STRING) {
            tVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.c();
        while (cVar.e()) {
            switch (cVar.a(a)) {
                case 0:
                    if (cVar.f() == c.b.BEGIN_ARRAY) {
                        cVar.a();
                        if (cVar.f() == c.b.NUMBER) {
                            arrayList.add(u.a(cVar, tVar, f, apVar, false, z));
                        } else {
                            while (cVar.e()) {
                                arrayList.add(u.a(cVar, tVar, f, apVar, true, z));
                            }
                        }
                        cVar.b();
                        break;
                    } else {
                        arrayList.add(u.a(cVar, tVar, f, apVar, false, z));
                        break;
                    }
                default:
                    cVar.m();
                    break;
            }
        }
        cVar.d();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends com.component.lottie.h.a<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.component.lottie.h.a<T> aVar = list.get(i2);
            i2++;
            com.component.lottie.h.a<T> aVar2 = list.get(i2);
            aVar.g = Float.valueOf(aVar2.f);
            if (aVar.b == null && aVar2.a != null) {
                aVar.b = aVar2.a;
                if (aVar instanceof com.component.lottie.a.b.k) {
                    ((com.component.lottie.a.b.k) aVar).a();
                }
            }
        }
        com.component.lottie.h.a<T> aVar3 = list.get(i);
        if ((aVar3.a == null || aVar3.b == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
