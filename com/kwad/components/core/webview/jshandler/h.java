package com.kwad.components.core.webview.jshandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private int Ie;
    private com.kwad.sdk.core.webview.c.c aeb;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int loadType;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLoadInfo";
    }

    public h(int i) {
        this.Ie = i;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeb = cVar;
        bl(this.Ie);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeb = null;
    }

    private void bl(int i) {
        if (this.aeb == null) {
            return;
        }
        a aVar = new a();
        aVar.loadType = i;
        this.aeb.a(aVar);
    }
}
