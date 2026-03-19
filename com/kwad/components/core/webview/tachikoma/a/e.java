package com.kwad.components.core.webview.tachikoma.a;

import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.components.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private KsAppDownloadListener adL;
    private KsAppDownloadListener agf;
    private o ahJ;
    private com.kwad.sdk.core.webview.b gC;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public e(com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.b bVar, o oVar) {
        this.gC = bVar;
        this.mApkDownloadHelper = cVar;
        this.ahJ = oVar;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.adL;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener ksAppDownloadListenerUX = uX();
                this.adL = ksAppDownloadListenerUX;
                this.mApkDownloadHelper.b(ksAppDownloadListenerUX);
                return;
            }
            cVar.d(ksAppDownloadListener);
        }
    }

    private KsAppDownloadListener uX() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.a.e.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                e.this.a(2, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                e.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                e.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                e.this.a(6, 1.0f);
                if (e.this.agf != null) {
                    e.this.agf.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                e.this.a(3, (i * 1.0f) / 100.0f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        bd.a aVar = new bd.a();
        aVar.agh = f;
        aVar.status = i;
        aVar.totalBytes = com.kwad.sdk.core.response.b.e.eP(this.gC.getAdTemplate()).totalBytes;
        aVar.soFarBytes = com.kwad.sdk.core.response.b.e.eP(this.gC.getAdTemplate()).soFarBytes;
        if (aVar.totalBytes > 0) {
            aVar.agi = (aVar.soFarBytes * 1.0f) / aVar.totalBytes;
        } else {
            aVar.agi = 0.0f;
        }
        this.ahJ.setDownloadProgress(aVar.toJson().toString());
    }
}
