package com.kwad.components.ct.request;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends com.kwad.sdk.core.network.d {
    public m(long j, int i) {
        putBody("photoId", j);
        putBody("shareType", i);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.Td();
    }
}
