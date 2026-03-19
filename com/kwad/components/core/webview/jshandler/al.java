package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class al implements com.kwad.sdk.core.webview.c.a {
    private final Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aeJ;
    private b gH;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int afp = -1;
        public int type;
    }

    public interface b {
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "hide";
    }

    public al(b bVar) {
        this.gH = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.aeJ = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.al.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (al.this.aeJ != null) {
                        al.this.aeJ.a(null);
                    }
                    al.this.b(aVar);
                }
            });
        } catch (Exception e) {
            this.aeJ.onError(-1, e.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.gH = null;
        this.aeJ = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.gH;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }
}
