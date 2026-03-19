package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class an implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b aen;
    private int aft = 0;
    private a afu;
    private b afv;

    public interface a {
        void onClick();
    }

    public interface b {
        void onAdShow();
    }

    protected void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return com.baidu.mobads.container.components.j.a.b;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public an(com.kwad.sdk.core.webview.b bVar) {
        this.aen = bVar;
    }

    public final void a(a aVar) {
        this.afu = aVar;
    }

    public final void a(b bVar) {
        this.afv = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            c cVar2 = new c();
            cVar2.parseJson(new JSONObject(str));
            if (c(cVar2) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(cVar2);
            cVar.a(null);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }

    protected void b(boolean z, AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.u.b.tq().a(adTemplate, null, bVar);
    }

    protected void a(c cVar) {
        com.kwad.sdk.core.d.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + cVar.actionType);
        if (cVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b bVarEH = new com.kwad.sdk.core.adlog.c.b().eH(cVar.QX);
            b bVar = this.afv;
            if (bVar != null) {
                bVar.onAdShow();
            }
            if (cVar.adTemplate != null) {
                bVarEH.eT(this.aft);
                b(true, cVar.adTemplate, null, bVarEH);
                return;
            }
            if (bq.isNullString(cVar.oA())) {
                b(true, this.aen.getAdTemplate(), null, bVarEH);
                return;
            }
            if (this.aen.xc() != null) {
                for (AdTemplate adTemplate : this.aen.xc()) {
                    if (bq.isEquals(cVar.oA(), String.valueOf(com.kwad.sdk.core.response.b.e.eV(adTemplate)))) {
                        b(false, adTemplate, null, bVarEH);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (cVar.actionType == 2) {
            com.kwad.sdk.widget.i iVar = this.aen.bLv;
            a aVar = this.afu;
            if (aVar != null) {
                aVar.onClick();
            }
            com.kwad.sdk.core.adlog.c.b bVarEH2 = new com.kwad.sdk.core.adlog.c.b().eT(this.aft).eH(cVar.QX);
            if (iVar != null) {
                bVarEH2.f(iVar.getTouchCoords());
            }
            a(bVarEH2);
            com.kwad.sdk.core.adlog.c.a(c(cVar), bVarEH2, this.aen.mReportExtData);
            return;
        }
        if (cVar.actionType == 12006) {
            com.kwad.components.core.q.a.ss().f(c(cVar), cVar.afw, this.aft);
            return;
        }
        if (cVar.actionType == 140) {
            com.kwad.sdk.core.adlog.c.d(c(cVar), this.aen.mReportExtData, new com.kwad.sdk.core.adlog.c.b().eH(cVar.QX));
        } else if (cVar.actionType == 141) {
            com.kwad.sdk.core.adlog.c.e(c(cVar), this.aen.mReportExtData, new com.kwad.sdk.core.adlog.c.b().eH(cVar.QX));
        } else {
            com.kwad.sdk.core.adlog.c.b(c(cVar), cVar.actionType, this.aen.mReportExtData, cVar.QX);
            com.kwad.components.core.webview.tachikoma.e.a.wk().bq(cVar.QX);
        }
    }

    private AdTemplate c(c cVar) {
        return cVar.adTemplate != null ? cVar.adTemplate : this.aen.eA(cVar.PD);
    }

    public static final class c extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String PD;
        private String QX;
        private int actionType;
        private AdTemplate adTemplate;
        private int afw;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.afw = jSONObject.optInt("refreshType");
            this.QX = jSONObject.optString("payload");
            this.PD = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.p.a.e.a.a.aO(jSONObject.optInt("adCacheId")), this.PD);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.aa.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "payload", this.QX);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "refreshType", this.afw);
            com.kwad.sdk.utils.aa.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creativeId", this.PD);
            return jSONObject;
        }

        public final int getActionType() {
            return this.actionType;
        }

        public final String vb() {
            return this.QX;
        }

        public final String oA() {
            return this.PD;
        }
    }
}
