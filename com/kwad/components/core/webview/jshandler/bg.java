package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bg implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b aen;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "reportBatch";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bg(com.kwad.sdk.core.webview.b bVar) {
        this.aen = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            f(new JSONObject(str));
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    private void f(JSONObject jSONObject) {
        com.kwad.sdk.core.report.n nVar;
        a aVar = new a();
        aVar.parseJson(jSONObject);
        com.kwad.sdk.core.d.c.d("WebCardReportBatchHandler", "reportBatch actionType actionType" + aVar.actionType);
        AdTemplate adTemplateA = a(aVar);
        if (adTemplateA == null) {
            nVar = new com.kwad.sdk.core.report.n(aVar.actionType);
        } else {
            nVar = new com.kwad.sdk.core.report.n(aVar.actionType, adTemplateA);
        }
        if (aVar.agl != null) {
            nVar.setJsonMergeData(aVar.agl);
        }
        com.kwad.sdk.core.report.g.a(nVar);
    }

    private AdTemplate a(a aVar) {
        if (aVar.adTemplate == null) {
            return this.aen.getAdTemplate();
        }
        return aVar.adTemplate;
    }

    public static final class a implements com.kwad.sdk.core.b {
        private int actionType;
        private AdTemplate adTemplate;
        private JSONObject agl;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.agl = jSONObject.optJSONObject("h5Params");
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("adTemplateData");
                if (this.adTemplate == null) {
                    this.adTemplate = new AdTemplate();
                }
                this.adTemplate.parseJson(jSONObjectOptJSONObject);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5Params", this.agl);
            com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", this.adTemplate);
            return jSONObject;
        }
    }
}
