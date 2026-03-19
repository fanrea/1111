package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.tachikoma.b.w;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n extends w {

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerNeoStatusListener";
    }

    public final void aa(boolean z) {
        a aVar = new a();
        aVar.status = z ? 1 : 0;
        b(aVar);
    }
}
