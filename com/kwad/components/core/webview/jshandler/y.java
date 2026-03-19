package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> aey;
    private com.kwad.sdk.core.webview.b gC;
    private b to;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    public interface b {
        void X(AdTemplate adTemplate);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public y(List<AdTemplate> list) {
        this.aey = list;
    }

    public y(com.kwad.sdk.core.webview.b bVar) {
        this.gC = bVar;
    }

    public final void a(b bVar) {
        this.to = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate adTemplateB = com.kwad.sdk.core.response.b.e.b(uZ(), aVar.creativeId, aVar.adStyle);
            b bVar = this.to;
            if (bVar != null) {
                bVar.X(adTemplateB);
            }
        } catch (JSONException unused) {
        }
    }

    private List<AdTemplate> uZ() {
        List<AdTemplate> list = this.aey;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.gC;
        if (bVar != null) {
            return bVar.xc();
        }
        return null;
    }
}
