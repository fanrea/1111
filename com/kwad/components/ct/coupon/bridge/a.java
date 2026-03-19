package com.kwad.components.ct.coupon.bridge;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.components.core.webview.a.b ams;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getPageOpenParams";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public a(com.kwad.components.core.webview.a.b bVar) {
        this.ams = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        cVar.a(this.ams);
    }
}
