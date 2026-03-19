package com.bytedance.sdk.component.hc.d.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class h {
    static an d;
    static long hc;

    private h() {
    }

    static an d() {
        synchronized (h.class) {
            an anVar = d;
            if (anVar != null) {
                d = anVar.an;
                anVar.an = null;
                hc -= 8192;
                return anVar;
            }
            return new an();
        }
    }

    static void d(an anVar) {
        if (anVar.an != null || anVar.h != null) {
            throw new IllegalArgumentException();
        }
        if (anVar.c) {
            return;
        }
        synchronized (h.class) {
            long j = hc;
            if (j + 8192 > 65536) {
                return;
            }
            hc = j + 8192;
            anVar.an = d;
            anVar.b = 0;
            anVar.hc = 0;
            d = anVar;
        }
    }
}
