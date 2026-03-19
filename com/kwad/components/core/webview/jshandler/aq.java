package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class aq implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b gC;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String afE;
    }

    public static final class b extends com.kwad.sdk.core.response.a.a {
        public double afL;
        public double afM;
        public long soFarBytes;
        public int status;
        public long totalBytes;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.afE));
        } catch (Exception e) {
            adTemplate = null;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (adTemplate == null || !com.kwad.sdk.core.response.b.e.eH(adTemplate) || this.gC.bLw == null) {
            return;
        }
        com.kwad.components.core.e.d.c cVar2 = new com.kwad.components.core.e.d.c(adTemplate);
        String strPL = cVar2.pL();
        cVar2.b(bf(strPL));
        this.gC.bLw.a(strPL, cVar2);
        this.gC.bLw.b(strPL, cVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        if (this.gC.bLw != null) {
            this.gC.bLw.release();
        }
    }

    private KsAppDownloadListener bf(String str) {
        return new com.kwad.sdk.core.download.a.a(str) { // from class: com.kwad.components.core.webview.jshandler.aq.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (aq.this.gC.bLw != null) {
                    aq.this.a(1, 0.0f, aq.this.gC.bLw.iu(pL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (aq.this.gC.bLw != null) {
                    aq.this.a(2, (i * 1.0f) / 100.0f, aq.this.gC.bLw.iu(pL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (aq.this.gC.bLw != null) {
                    aq.this.a(5, 1.0f, aq.this.gC.bLw.iu(pL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (aq.this.gC.bLw != null) {
                    aq.this.a(1, 0.0f, aq.this.gC.bLw.iu(pL()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (aq.this.gC.bLw != null) {
                    aq.this.a(6, 1.0f, aq.this.gC.bLw.iu(pL()));
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                if (aq.this.gC.bLw != null) {
                    aq.this.a(3, (i * 1.0f) / 100.0f, aq.this.gC.bLw.iu(pL()));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.c.c cVar) {
        if (cVar != null) {
            b bVar = new b();
            bVar.afL = f;
            bVar.status = i;
            bVar.totalBytes = com.kwad.sdk.core.response.b.e.eP(this.gC.getAdTemplate()).totalBytes;
            bVar.soFarBytes = com.kwad.sdk.core.response.b.e.eP(this.gC.getAdTemplate()).soFarBytes;
            if (bVar.totalBytes > 0) {
                bVar.afM = (bVar.soFarBytes * 1.0d) / bVar.totalBytes;
            } else {
                bVar.afM = 0.0d;
            }
            cVar.a(bVar);
        }
    }
}
