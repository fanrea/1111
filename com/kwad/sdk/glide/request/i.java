package com.kwad.sdk.glide.request;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i extends b<i> {
    private static i bZE;

    public static i b(com.kwad.sdk.glide.load.engine.h hVar) {
        return new i().a(hVar);
    }

    public static i cV(boolean z) {
        if (bZE == null) {
            bZE = new i().cU(true).aiE();
        }
        return bZE;
    }

    public static i j(com.kwad.sdk.glide.load.c cVar) {
        return new i().i(cVar);
    }

    public static i w(Class<?> cls) {
        return new i().v(cls);
    }
}
