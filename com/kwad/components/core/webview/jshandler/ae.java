package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ae implements com.kwad.sdk.core.webview.c.a {
    protected b aeS;
    protected final com.kwad.sdk.core.webview.b aen;

    public interface b {
        void c(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public ae(com.kwad.sdk.core.webview.b bVar) {
        this.aen = bVar;
    }

    public final void a(b bVar) {
        this.aeS = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        b bVar = this.aeS;
        if (bVar != null) {
            bVar.c(aVar);
        } else {
            aVar.width = this.aen.Vu.getWidth();
            aVar.height = this.aen.Vu.getHeight();
        }
        cVar.a(aVar);
    }

    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }
}
