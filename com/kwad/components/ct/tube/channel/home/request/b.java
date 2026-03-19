package com.kwad.components.ct.tube.channel.home.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.h;
import com.kwad.sdk.live.audience.model.KSLiveTopUser;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends d {
    public b(ImpInfo impInfo, c cVar, g gVar) {
        putBody("impInfo", aa.a(new JSONArray(), impInfo.toJson()));
        putBody(KSLiveTopUser.KEY_USER_INFO, gVar);
        putBody("tubeParam", cVar);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Tn();
    }
}
