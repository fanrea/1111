package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bl implements com.kwad.sdk.core.webview.c.a {
    private Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aeJ;
    private a agy;

    public interface a {
        void vl();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "zoomIn";
    }

    public bl(a aVar) {
        this.agy = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeJ = cVar;
        this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bl.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                bl.this.vk();
                if (bl.this.aeJ != null) {
                    bl.this.aeJ.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.agy = null;
        this.aeJ = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        a aVar = this.agy;
        if (aVar != null) {
            aVar.vl();
        }
    }
}
