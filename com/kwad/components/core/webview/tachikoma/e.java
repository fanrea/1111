package com.kwad.components.core.webview.tachikoma;

import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c sd;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerConvertStatusListener";
    }

    public final void b(final com.kwad.sdk.core.response.a.a aVar) {
        if (this.sd != null) {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.e.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    e.this.sd.a(aVar);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.sd = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.sd = null;
    }
}
