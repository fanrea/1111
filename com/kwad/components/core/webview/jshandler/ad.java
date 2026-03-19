package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    private a aeQ;
    private final com.kwad.sdk.core.webview.b aen;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public interface a {
        void cP();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "dislike";
    }

    public ad(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.aen = bVar;
        this.aeQ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.mHandler.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                ad.this.aeQ.cP();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
