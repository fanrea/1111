package com.kwad.components.core.webview.jshandler;

import com.kwad.components.core.webview.jshandler.ae;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class af extends ae {
    @Override // com.kwad.components.core.webview.jshandler.ae, com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getContainerPureLimit";
    }

    public af(com.kwad.sdk.core.webview.b bVar) {
        super(bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.ae, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        if (this.aeS != null) {
            this.aeS.c(aVar);
        } else {
            aVar.width = this.aen.Vu.getWidth();
            aVar.height = this.aen.Vu.getHeight();
        }
        cVar.a(aVar);
    }

    public static class a extends ae.a {
        public int aeT;

        @Override // com.kwad.components.core.webview.jshandler.ae.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.components.core.webview.jshandler.ae.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json = super.toJson();
            if (json == null) {
                json = new JSONObject();
            }
            com.kwad.sdk.utils.aa.putValue(json, "adapterTopHeight", this.aeT);
            return json;
        }
    }
}
