package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.b.f;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bq;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public boolean isDataEmpty() {
        return false;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString("errorMsg");
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String strOptString = jSONObject.optString("extra");
        if (!bq.isNullString(strOptString)) {
            this.extra = ((e) d.g(e.class)).getResponseData(strOptString);
        }
        h hVar = (h) d.g(h.class);
        if (hVar != null) {
            hVar.av(jSONObject.optString("egid"));
            hVar.C(jSONObject.optLong("gidExpireTimeMs"));
        }
        String strOptString2 = jSONObject.optString("cookie");
        this.cookie = strOptString2;
        if (TextUtils.isEmpty(strOptString2)) {
            return;
        }
        f.abL().fO(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "llsid", this.llsid);
        aa.putValue(jSONObject, "extra", this.extra);
        aa.putValue(jSONObject, "result", this.result);
        aa.putValue(jSONObject, "hasAd", this.hasAd);
        aa.putValue(jSONObject, "errorMsg", this.errorMsg);
        aa.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        aa.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean hasData() {
        return this.hasAd;
    }
}
