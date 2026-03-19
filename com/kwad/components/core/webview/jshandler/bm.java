package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bm implements com.kwad.sdk.core.webview.c.a {
    private static Handler agB;
    private com.kwad.components.core.e.d.c QQ;
    private com.kwad.sdk.core.webview.b agA;
    private b agC;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int oz;
    }

    public interface b {
        void ae(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bm(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, b bVar2) {
        this.agA = bVar;
        this.QQ = cVar;
        this.agC = bVar2;
        if (agB == null) {
            agB = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.oz;
            agB.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bm.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (bm.this.agC != null) {
                        bm.this.agC.ae(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
