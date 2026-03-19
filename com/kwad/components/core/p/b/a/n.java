package com.kwad.components.core.p.b.a;

import com.kwad.components.offline.api.core.network.IIdc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n implements IIdc {
    @Override // com.kwad.components.offline.api.core.network.IIdc
    public final String hostForAPI(String str) {
        if (str.equals("api")) {
            return com.kwad.sdk.h.SV();
        }
        return "https://" + com.kwad.sdk.core.network.idc.a.aaw().ad(str, null);
    }
}
