package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bj implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aeJ;
    private b agq;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "setHeaderBar";
    }

    public bj(b bVar) {
        this.agq = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        bx.postOnUiThread(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bj.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                bj.this.b(aVar);
                if (bj.this.aeJ != null) {
                    bj.this.aeJ.a(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.agq;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agq = null;
        this.aeJ = null;
    }
}
