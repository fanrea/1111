package com.kwad.sdk.mobileid.model;

import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bq;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class UaidTokenResponse extends BaseResultData implements Serializable {
    private static final long serialVersionUID = -8501365728042530876L;
    public String uaid;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("data");
            e eVar = (e) d.g(e.class);
            if (bq.isNullString(strOptString)) {
                return;
            }
            String responseData = eVar.getResponseData(strOptString);
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            this.uaid = new JSONObject(responseData).optString("uaid");
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }
}
