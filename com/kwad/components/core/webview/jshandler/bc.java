package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bc implements com.kwad.sdk.core.webview.c.a {
    private final a agd;

    public interface a {
        void cQ();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerMotionListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bc(a aVar) {
        this.agd = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, final com.kwad.sdk.core.webview.c.c cVar) {
        bx.runOnUiThread(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bc.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (bc.this.agd != null) {
                    bc.this.agd.cQ();
                }
                cVar.a(null);
            }
        });
    }
}
