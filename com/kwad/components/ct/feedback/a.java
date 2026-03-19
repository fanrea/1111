package com.kwad.components.ct.feedback;

import com.kwad.components.ct.feedback.b;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d {
    public a(b.a aVar) {
        addHeader("user-agent", p.getUserAgent());
        putBody("fromPageName", aVar.amZ);
        putBody("content", aVar.content);
        putBody("phoneNumber", aVar.aGn);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Tz();
    }
}
