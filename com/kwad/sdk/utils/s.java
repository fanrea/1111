package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class s {
    private static boolean clH;
    private static boolean clI;

    public static synchronized void dy(boolean z) {
        if (clI) {
            return;
        }
        clI = true;
        clH = true;
        GlobalThreadPools.acm().execute(new Runnable() { // from class: com.kwad.sdk.utils.s.1
            @Override // java.lang.Runnable
            public final void run() {
                ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).TL();
            }
        });
    }

    public static boolean anX() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(2L)) & clH;
    }

    public static boolean anY() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(4L)) & clH;
    }

    public static boolean anZ() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(2048L)) & clH;
    }

    public static boolean aoa() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Uc() && clH;
    }

    public static boolean aob() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(16L)) & clH;
    }

    public static boolean aoc() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(4096L)) & clH;
    }

    public static boolean aod() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(1L)) & clH;
    }

    public static boolean aoe() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(128L)) & clH;
    }

    public static boolean aof() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(128L)) & clH;
    }
}
