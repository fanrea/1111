package com.kwad.components.ad.reward.c;

import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private d uR;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateExtraReward";
    }

    public f(d dVar) {
        this.uR = dVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (f.this.uR != null) {
                        f.this.uR.a(bVar);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.uR = null;
    }
}
