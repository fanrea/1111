package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements com.kwad.sdk.core.webview.c.c {
    private final IOfflineCompoCallBackFunction bcb;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.bcb = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void a(final com.kwad.sdk.core.b bVar) {
        if (com.kwad.sdk.core.config.e.Yd()) {
            GlobalThreadPools.acm().submit(new Runnable() { // from class: com.kwad.components.offline.d.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    final String string = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
                    bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.offline.d.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (a.this.bcb != null) {
                                a.this.bcb.onSuccess(string);
                            }
                        }
                    });
                }
            });
            return;
        }
        String string = new com.kwad.sdk.core.webview.c.f(bVar).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.bcb;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(string);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.c
    public final void onError(int i, String str) {
        String string = new com.kwad.sdk.core.webview.c.e(i, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.bcb;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(string);
        }
    }
}
