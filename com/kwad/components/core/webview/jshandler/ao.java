package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ao implements com.kwad.sdk.core.webview.c.a {
    private final Handler aeI;
    private final com.kwad.sdk.core.webview.b aen;
    private final b afx;

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public boolean afD;
        public String afE;
        public int afF;
        public com.kwad.sdk.core.webview.d.b.d afG;
    }

    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.e.d.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.afE));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (com.kwad.sdk.core.response.b.e.eH(adTemplate)) {
            if (this.aen.bLw != null) {
                cVar2 = (com.kwad.components.core.e.d.c) this.aen.bLw.it(com.kwad.sdk.core.response.b.e.eP(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.aen.bLx) {
                this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.ao.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        com.kwad.components.core.e.d.a.a(new a.C0469a(ao.this.aen.Vu.getContext()).aC(adTemplate).b(cVar2).aG(aVar.afF).aq(true).ar(aVar.afG.QX).as(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ao.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.afx != null) {
                this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.ao.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeI.removeCallbacksAndMessages(null);
    }
}
