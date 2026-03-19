package com.kwad.components.core.webview.jshandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class az implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aeb;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String afY;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeb = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeb = null;
    }

    public final void bb(boolean z) {
        if (z) {
            bg("windowFocusGet");
        } else {
            bg("windowFocusLost");
        }
    }

    private void bg(String str) {
        if (this.aeb != null) {
            a aVar = new a();
            aVar.afY = str;
            this.aeb.a(aVar);
        }
    }
}
