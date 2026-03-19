package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends com.kwad.sdk.core.network.d {
    public m(AdTemplate adTemplate) {
        String strCb = com.kwad.sdk.core.response.b.a.cb(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        try {
            String strCc = com.kwad.sdk.core.response.b.a.cc(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            String strCd = com.kwad.sdk.core.response.b.a.cd(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            if (!TextUtils.isEmpty(strCd)) {
                putBody("adExt", strCd);
            }
            if (!TextUtils.isEmpty(strCc)) {
                putBody("serverExt", new JSONObject(strCc));
            }
            if (!TextUtils.isEmpty(strCb) && strCb != null) {
                putBody("callbackUrlInfo", new JSONObject(strCb).toString());
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.TB();
    }
}
