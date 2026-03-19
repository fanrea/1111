package com.kwad.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l {
    private boolean enabled = false;
    private final Set<Object> bld = new ArraySet();
    private final Map<String, com.kwad.lottie.d.d> ble = new HashMap();
    private final Comparator<Pair<String, Float>> blf = new Comparator<Pair<String, Float>>() { // from class: com.kwad.lottie.l.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            return a(pair, pair2);
        }

        private static int a(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.second.floatValue();
            float fFloatValue2 = pair2.second.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final void a(String str, float f) {
        if (this.enabled) {
            com.kwad.lottie.d.d dVar = this.ble.get(str);
            if (dVar == null) {
                dVar = new com.kwad.lottie.d.d();
                this.ble.put(str, dVar);
            }
            dVar.H(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.bld.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
