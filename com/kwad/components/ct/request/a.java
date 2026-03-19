package com.kwad.components.ct.request;

import com.kwad.sdk.core.scene.URLPackage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.core.network.d {
    public a(String str, int i) {
        putBody(URLPackage.KEY_AUTHOR_ID, str);
        putBody("actionType", i);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.Tf();
    }
}
