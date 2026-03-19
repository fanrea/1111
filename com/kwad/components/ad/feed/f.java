package com.kwad.components.ad.feed;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    public static String m(AdTemplate adTemplate) {
        String strAw = com.kwad.sdk.core.response.b.a.aw(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        if (com.kwad.components.core.c.b.ok()) {
            return (adTemplate.fromCache ? "【cache】" : "") + strAw;
        }
        return strAw;
    }
}
