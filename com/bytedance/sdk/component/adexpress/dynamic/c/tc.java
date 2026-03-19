package com.bytedance.sdk.component.adexpress.dynamic.c;

import com.bytedance.sdk.component.adexpress.dynamic.c.hc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc {
    public static float d(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<hc.d> d(float f, List<hc.d> list) {
        ArrayList<hc.d> arrayList = new ArrayList();
        Iterator<hc.d> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((hc.d) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (hc.d dVar : arrayList) {
            if (dVar.hc) {
                i = (int) (i + dVar.d);
            } else {
                i2 = (int) (i2 + dVar.d);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (hc.d dVar2 : arrayList) {
                if (!dVar2.hc && dVar2.b != 0.0f && dVar2.d * f4 > dVar2.b) {
                    dVar2.d = dVar2.b;
                    dVar2.hc = true;
                    z2 = true;
                }
                arrayList2.add(dVar2);
            }
            if (z2) {
                return d(f, arrayList2);
            }
        }
        int i3 = 0;
        for (hc.d dVar3 : arrayList) {
            if (dVar3.hc) {
                dVar3.d = d(dVar3.d * f3);
            } else {
                dVar3.d = d(dVar3.d * f4);
            }
            i3 = (int) (i3 + dVar3.d);
        }
        float f5 = i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int size = 0; size < arrayList.size() && f6 > 0.0f; size = (size + 1) % arrayList.size()) {
                hc.d dVar4 = (hc.d) arrayList.get(size);
                if ((f < f2 && dVar4.hc) || (f > f2 && !dVar4.hc)) {
                    dVar4.d += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
