package com.kwad.components.ct.tube.slide.detail.reward.unlock;

import com.kwad.components.ct.tube.channel.home.request.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.request.model.g;
import com.kwad.sdk.h;
import com.kwad.sdk.live.audience.model.KSLiveTopUser;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d {
    public a(c cVar, g gVar) {
        putBody("tubeParam", cVar);
        putBody(KSLiveTopUser.KEY_USER_INFO, gVar);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Tr();
    }
}
