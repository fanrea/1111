package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bn implements com.kwad.sdk.core.webview.c.a {
    private Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aeJ;
    private a agE;

    public interface a {
        void vn();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "replayVideo";
    }

    public bn(a aVar) {
        this.agE = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bn.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                bn.this.vm();
                if (bn.this.aeJ != null) {
                    bn.this.aeJ.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agE = null;
        this.aeJ = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm() {
        a aVar = this.agE;
        if (aVar != null) {
            aVar.vn();
        }
    }
}
