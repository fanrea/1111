package com.kwad.components.core.webview.jshandler;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b aen;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getScreenOrientation";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public aj(com.kwad.sdk.core.webview.b bVar) {
        this.aen = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (this.aen.adx()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        aVar.screenOrientation = !com.kwad.sdk.utils.aq.isOrientationPortrait() ? 1 : 0;
        cVar.a(aVar);
    }

    public static final class a implements com.kwad.sdk.core.b {
        public int screenOrientation;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "screenOrientation", this.screenOrientation);
            return jSONObject;
        }
    }
}
