package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {
    private KsAppDownloadListener adL;
    private com.kwad.sdk.core.webview.c.c aeb;
    private KsAppDownloadListener agf;
    private final com.kwad.sdk.core.webview.b gC;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerProgressListener";
    }

    public bd(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar) {
        this.gC = bVar;
        this.mApkDownloadHelper = cVar;
    }

    public bd(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, KsAppDownloadListener ksAppDownloadListener) {
        this.gC = bVar;
        this.mApkDownloadHelper = cVar;
        this.agf = ksAppDownloadListener;
    }

    public final void setApkDownloadHelper(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper.pZ();
        com.kwad.sdk.core.download.c.ZJ().a(this.mApkDownloadHelper);
        if (com.kwad.sdk.core.config.e.Yt()) {
            NetworkMonitor.getInstance().a(this.mApkDownloadHelper);
        }
        this.mApkDownloadHelper = cVar;
        KsAppDownloadListener ksAppDownloadListenerUX = uX();
        this.adL = ksAppDownloadListenerUX;
        this.mApkDownloadHelper.b(ksAppDownloadListenerUX);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.gC.adx()) {
            cVar.onError(-1, "native photo is null");
            return;
        }
        this.aeb = cVar;
        com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            KsAppDownloadListener ksAppDownloadListener = this.adL;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener ksAppDownloadListenerUX = uX();
                this.adL = ksAppDownloadListenerUX;
                this.mApkDownloadHelper.b(ksAppDownloadListenerUX);
                return;
            }
            cVar2.d(ksAppDownloadListener);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.aeb = null;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.adL) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
        this.adL = null;
    }

    private KsAppDownloadListener uX() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.jshandler.bd.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                bd.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                bd.this.a(2, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                bd.this.a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                bd.this.a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                bd.this.a(6, 1.0f);
                if (bd.this.agf != null) {
                    bd.this.agf.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                bd.this.a(3, (i * 1.0f) / 100.0f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        if (this.aeb != null) {
            a aVar = new a();
            aVar.agh = f;
            aVar.status = i;
            aVar.totalBytes = com.kwad.sdk.core.response.b.e.eP(this.gC.getAdTemplate()).totalBytes;
            aVar.soFarBytes = com.kwad.sdk.core.response.b.e.eP(this.gC.getAdTemplate()).soFarBytes;
            if (aVar.totalBytes > 0) {
                aVar.agi = (aVar.soFarBytes * 1.0f) / aVar.totalBytes;
            } else {
                aVar.agi = 0.0f;
            }
            this.aeb.a(aVar);
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        public float agh;
        public float agi;
        public long creativeId;
        public long soFarBytes;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "progress", this.agh);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "totalBytes", this.totalBytes);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "soFarBytes", this.soFarBytes);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "realProgress", this.agi);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }
}
