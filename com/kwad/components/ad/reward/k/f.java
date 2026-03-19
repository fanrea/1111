package com.kwad.components.ad.reward.k;

import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f implements com.kwad.sdk.core.webview.c.a {

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean Cu;
    }

    public void V(boolean z) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, com.kwad.sdk.core.webview.c.c cVar) {
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.k.f.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                boolean z;
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    z = aVar.Cu;
                } catch (Exception unused) {
                    z = false;
                }
                f.this.V(z);
            }
        });
    }
}
