package com.kwad.components.core.webview.jshandler.a;

import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    private c adH;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "exitWebView";
    }

    public b(c cVar) {
        this.adH = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.adH != null) {
                    b.this.adH.rE();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.adH = null;
    }
}
