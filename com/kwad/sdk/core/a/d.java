package com.kwad.sdk.core.a;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.h;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    private static g bCb;

    public static void j(Map<String, String> map) {
        qn().j(map);
    }

    public static String ax(String str) {
        return qn().ax(str);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
        return qn().getResponseData(str);
    }

    public static void a(String str, Map<String, String> map, String str2) {
        qn().a(str, map, str2);
    }

    private static g qn() {
        g gVar = bCb;
        if (gVar != null) {
            return gVar;
        }
        h hVar = (h) com.kwad.sdk.components.d.g(h.class);
        if (hVar != null) {
            hVar.qn();
            bCb = hVar.qn();
        } else {
            bCb = new a();
        }
        return bCb;
    }
}
