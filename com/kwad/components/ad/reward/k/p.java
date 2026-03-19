package com.kwad.components.ad.reward.k;

import com.kwad.components.core.webview.jshandler.an;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p extends an {
    private long Cy;
    private String Cz;
    private WeakReference<com.kwad.components.ad.reward.g> uS;

    public p(com.kwad.components.ad.reward.g gVar, String str, long j, com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
        this.Cz = str;
        this.Cy = j;
        if (gVar != null) {
            this.uS = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.an
    public final void b(boolean z, AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.ad.reward.j.b.a(z, adTemplate, null, bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.an
    public final void a(an.c cVar) {
        if (b(cVar)) {
            return;
        }
        super.a(cVar);
    }

    private boolean b(an.c cVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference;
        if (cVar.getActionType() != 140 || !com.kwad.sdk.core.config.e.Uv() || !Z(cVar.vb()) || (weakReference = this.uS) == null || weakReference.get() == null) {
            return false;
        }
        final com.kwad.components.ad.reward.g gVar = this.uS.get();
        bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.components.ad.reward.k.p.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                gVar.F(p.this.Cz);
            }
        }, 1500L);
        return true;
    }

    private static boolean Z(String str) {
        try {
            return new JSONObject(str).optInt("elementType") == 18;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.an
    public final void a(com.kwad.sdk.core.adlog.c.b bVar) {
        super.a(bVar);
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.uS;
        if (weakReference != null && weakReference.get() != null) {
            bVar.aV(this.uS.get().tu.getPlayDuration());
            return;
        }
        long j = this.Cy;
        if (j > 0) {
            bVar.aV(j);
        }
    }
}
