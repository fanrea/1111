package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yo {
    private boolean d = false;
    private final Set<Object> hc = new d();
    private final Map<String, com.bytedance.adsdk.lottie.u.h> b = new HashMap();
    private final Comparator<Pair<String, Float>> c = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.lottie.yo.1
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    void d(boolean z) {
        this.d = z;
    }

    public void d(String str, float f) {
        if (this.d) {
            com.bytedance.adsdk.lottie.u.h hVar = this.b.get(str);
            if (hVar == null) {
                hVar = new com.bytedance.adsdk.lottie.u.h();
                this.b.put(str, hVar);
            }
            hVar.d(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.hc.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
