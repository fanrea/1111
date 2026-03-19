package com.kwad.components.ad.h.a.a;

import com.kwad.sdk.core.webview.c.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private c sd;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        this.sd = cVar;
    }

    public final void fT() {
        c cVar = this.sd;
        if (cVar != null) {
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.sd = null;
    }
}
