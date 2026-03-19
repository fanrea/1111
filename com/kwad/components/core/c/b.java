package com.kwad.components.core.c;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static void b(e eVar) {
        aj("使用缓存策略: " + eVar.op());
    }

    private static void aj(String str) {
        if (ok() && com.kwad.sdk.l.UL().TT()) {
            ac.ae(ServiceProvider.getContext(), str);
        }
    }

    public static boolean ok() {
        return false;
    }
}
