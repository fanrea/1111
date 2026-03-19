package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bk implements com.kwad.sdk.core.webview.c.a {
    private a agt;

    public interface a {
        void uR();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bk(a aVar) {
        this.agt = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        vj();
    }

    private void vj() {
        if (com.kwad.components.core.e.c.b.pe()) {
            return;
        }
        bx.runOnUiThread(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bk.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (bk.this.agt != null) {
                    bk.this.agt.uR();
                }
            }
        });
    }
}
