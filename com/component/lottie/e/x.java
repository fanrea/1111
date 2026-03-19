package com.component.lottie.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class x {
    static final long a = 65536;
    static w b;
    static long c;

    private x() {
    }

    static w a() {
        synchronized (x.class) {
            if (b != null) {
                w wVar = b;
                b = wVar.h;
                wVar.h = null;
                c -= 8192;
                return wVar;
            }
            return new w();
        }
    }

    static void a(w wVar) {
        if (wVar.h != null || wVar.i != null) {
            throw new IllegalArgumentException();
        }
        if (wVar.f) {
            return;
        }
        synchronized (x.class) {
            if (c + 8192 > 65536) {
                return;
            }
            c += 8192;
            wVar.h = b;
            wVar.e = 0;
            wVar.d = 0;
            b = wVar;
        }
    }
}
