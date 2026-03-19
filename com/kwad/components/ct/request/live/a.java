package com.kwad.components.ct.request.live;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d {

    /* renamed from: com.kwad.components.ct.request.live.a$a, reason: collision with other inner class name */
    public static class C0534a {
        public long authorId;
        public String liveStreamId;
    }

    public a(C0534a c0534a) {
        putBody(URLPackage.KEY_AUTHOR_ID, c0534a.authorId);
        putBody("liveStreamId", c0534a.liveStreamId);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Tm();
    }
}
