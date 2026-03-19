package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    private boolean aeA;
    private Handler aeI;
    private boolean aeM;
    private boolean aeN;
    private final com.kwad.sdk.core.webview.b aen;
    private com.kwad.sdk.core.webview.d.a.a gF;
    private final com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "convert";
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, boolean z2, boolean z3) {
        this.aeM = false;
        this.aeN = false;
        this.aeA = z;
        this.aeI = new Handler(Looper.getMainLooper());
        this.aen = bVar;
        this.mApkDownloadHelper = cVar;
        this.aeM = false;
        if (cVar != null) {
            cVar.aM(1);
        }
        this.gF = aVar;
        this.aeN = z3;
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public ac(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, byte b) {
        this(bVar, cVar, aVar, false, false, false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.aen.adx()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.QI = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.aen.bLx) {
            this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.ac.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (ac.this.aen.bLy || aVar.afD) {
                        ac.this.aen.getAdTemplate();
                        com.kwad.components.core.e.d.a.a(ac.this.aen.Vu.getContext(), ac.this.aen.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.ac.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (ac.this.gF != null) {
                                    ac.this.gF.a(aVar);
                                }
                            }
                        }, ac.this.mApkDownloadHelper, aVar.afD, ac.this.aeA, ac.this.aeM, ac.this.aeN);
                    }
                }
            });
        } else if (this.gF != null) {
            this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.ac.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (ac.this.gF != null) {
                        ac.this.gF.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeI.removeCallbacksAndMessages(null);
        this.gF = null;
    }
}
