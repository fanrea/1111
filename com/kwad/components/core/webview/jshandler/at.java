package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class at implements com.kwad.sdk.core.webview.c.a {
    private Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aeJ;
    private b gI;
    private String mUrl;

    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "pageStatus";
    }

    @Deprecated
    public at(b bVar) {
        this.gI = bVar;
    }

    public at(b bVar, String str) {
        this.gI = bVar;
        this.mUrl = str;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.at.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    at.this.b(aVar);
                    if (at.this.aeJ != null) {
                        at.this.aeJ.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            com.kwad.sdk.core.webview.b.c.b.an(this.mUrl, e.getMessage());
            cVar.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.gI = null;
        this.aeJ = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.gI;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }
}
