package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class v implements com.kwad.sdk.core.webview.c.a {

    public static class b extends com.kwad.sdk.core.response.a.a {
        public String packageName;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "startApp";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (Exception unused) {
        }
        a aVar = new a();
        aVar.aev = com.kwad.sdk.utils.as.aH(ServiceProvider.getContext(), bVar.packageName);
        cVar.a(aVar);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean aev;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isStarted", this.aev);
            return jSONObject;
        }
    }
}
