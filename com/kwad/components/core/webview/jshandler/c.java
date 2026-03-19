package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c aeb;
    private com.kwad.components.core.proxy.launchdialog.b aec = uY();
    private final com.kwad.sdk.core.webview.b gC;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "dpInterceptPopupListener";
    }

    public c(com.kwad.sdk.core.webview.b bVar) {
        this.gC = bVar;
        com.kwad.components.core.proxy.launchdialog.e.sq().a(this.aec);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeb = cVar;
    }

    private com.kwad.components.core.proxy.launchdialog.b uY() {
        return new com.kwad.components.core.proxy.launchdialog.b() { // from class: com.kwad.components.core.webview.jshandler.c.1
            @Override // com.kwad.components.core.proxy.launchdialog.b
            public final void b(long j, int i) {
                try {
                    String strValueOf = String.valueOf(j);
                    AdTemplate adTemplateEA = c.this.gC.eA(strValueOf);
                    if (c.this.aeb == null || adTemplateEA == null) {
                        return;
                    }
                    a aVar = new a();
                    aVar.status = i;
                    aVar.PD = strValueOf;
                    c.this.aeb.a(aVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeb = null;
        com.kwad.components.core.proxy.launchdialog.e.sq().b(this.aec);
        this.aec = null;
    }

    public static final class a implements com.kwad.sdk.core.b {
        String PD;
        int status;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", this.status);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.PD);
            return jSONObject;
        }
    }
}
