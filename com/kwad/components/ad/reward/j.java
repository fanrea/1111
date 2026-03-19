package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.components.core.playable.PlayableSource;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends com.kwad.components.ad.l.b {
    private com.kwad.components.ad.reward.c.d uR;
    private WeakReference<g> uS;

    public j(g gVar, JSONObject jSONObject, String str) {
        super(jSONObject, null);
        this.uS = new WeakReference<>(gVar);
    }

    public final void a(com.kwad.components.ad.reward.c.d dVar) {
        this.uR = dVar;
    }

    @Override // com.kwad.components.ad.l.b
    public final void gA() {
        WeakReference<g> weakReference = this.uS;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gB() {
        WeakReference<g> weakReference = this.uS;
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, (weakReference != null ? weakReference.get() : null) != null, "end_card", L(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gC() {
        WeakReference<g> weakReference = this.uS;
        com.kwad.components.ad.reward.monitor.c.a((weakReference != null ? weakReference.get() : null) != null, "end_card", L(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        aVar.a(new com.kwad.components.ad.reward.i.b(this.gz.getContext(), this.mAdTemplate, PlayableSource.ENDCARD_CLICK));
        aVar.a(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar) {
                if (j.this.uR != null) {
                    j.this.uR.a(bVar);
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.j(new com.kwad.components.core.webview.jshandler.p() { // from class: com.kwad.components.ad.reward.j.2
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    jVar.a(com.kwad.components.ad.reward.c.a.hZ().ia());
                }
            }
        }));
        WeakReference<g> weakReference = this.uS;
        aVar.b(new com.kwad.components.ad.reward.k.p(weakReference != null ? weakReference.get() : null, "native_id", -1L, this.gC));
    }
}
