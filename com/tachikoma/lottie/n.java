package com.tachikoma.lottie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class n {
    private boolean enabled = false;
    private final Set<Object> Is = new android.support.v4.d.b();
    private final Map<String, com.tachikoma.lottie.d.d> It = new HashMap();
    private final Comparator<android.support.v4.d.i<String, Float>> Iu = new Comparator<android.support.v4.d.i<String, Float>>() { // from class: com.tachikoma.lottie.n.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(android.support.v4.d.i<String, Float> iVar, android.support.v4.d.i<String, Float> iVar2) {
            return a(iVar, iVar2);
        }

        private static int a(android.support.v4.d.i<String, Float> iVar, android.support.v4.d.i<String, Float> iVar2) {
            float fFloatValue = ((Float) iVar.second).floatValue();
            float fFloatValue2 = ((Float) iVar2.second).floatValue();
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
            com.tachikoma.lottie.d.d dVar = this.It.get(str);
            if (dVar == null) {
                dVar = new com.tachikoma.lottie.d.d();
                this.It.put(str, dVar);
            }
            dVar.m(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.Is.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
