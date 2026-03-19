package com.bytedance.sdk.component.b.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class cb {
    static e d;
    static long hc;

    private cb() {
    }

    static e d() {
        synchronized (cb.class) {
            e eVar = d;
            if (eVar != null) {
                d = eVar.an;
                eVar.an = null;
                hc -= 8192;
                return eVar;
            }
            return new e();
        }
    }

    static void d(e eVar) {
        if (eVar.an != null || eVar.h != null) {
            throw new IllegalArgumentException();
        }
        if (eVar.c) {
            return;
        }
        synchronized (cb.class) {
            long j = hc;
            if (j + 8192 > 65536) {
                return;
            }
            hc = j + 8192;
            eVar.an = d;
            eVar.b = 0;
            eVar.hc = 0;
            d = eVar;
        }
    }
}
