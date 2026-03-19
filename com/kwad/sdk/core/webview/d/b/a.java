package com.kwad.sdk.core.webview.d.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends com.kwad.sdk.core.response.a.a {

    @Deprecated
    public boolean QI;
    public String Rj;
    public AdTemplate adTemplate;

    @Deprecated
    public boolean afD;
    public int afF;
    public d afG;
    public int bMr;
    public int bMs;
    public int oz;
    public boolean QV = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean bMt = false;
    public boolean bMu = false;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.oz == 0 && this.bMs == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logParam");
                    this.oz = jSONObjectOptJSONObject.getInt("itemClickType");
                    this.bMs = jSONObjectOptJSONObject.getInt("sceneType");
                    this.bMt = jSONObjectOptJSONObject.optBoolean("isCallbackOnly");
                }
                String strOptString = jSONObject.optString("adTemplate");
                if (bq.isNullString(strOptString)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e) {
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean adM() {
        return 1 == this.afF;
    }
}
