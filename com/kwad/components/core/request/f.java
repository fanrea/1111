package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public long requestStartTime;

    public f(int i, AdTemplate adTemplate) {
        String strCb = com.kwad.sdk.core.response.b.a.cb(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        try {
            String strCc = com.kwad.sdk.core.response.b.a.cc(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            try {
                if (!TextUtils.isEmpty(strCc)) {
                    putBody("serverExt", new JSONObject(strCc));
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            if (!TextUtils.isEmpty(strCb) && strCb != null) {
                JSONObject jSONObject = new JSONObject(strCb);
                aa.putValue(jSONObject, "checkType", i);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.TA();
    }
}
