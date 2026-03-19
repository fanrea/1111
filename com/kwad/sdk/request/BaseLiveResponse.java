package com.kwad.sdk.request;

import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class BaseLiveResponse extends CommonOfflineCompoResultData implements Serializable {
    private static final long serialVersionUID = 3620010017495361650L;
    public String liveBody;

    @Override // com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData
    public void parseJson(JSONObject jSONObject) throws JSONException {
        super.parseJson(jSONObject);
        parseJson(this, jSONObject);
    }

    @Override // com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData
    public JSONObject toJson() throws JSONException {
        JSONObject json = super.toJson();
        toJson(this, json);
        return json;
    }

    public void parseJson(BaseLiveResponse baseLiveResponse, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseLiveResponse.liveBody = jSONObject.optString("liveBody");
        if (jSONObject.opt("liveBody") == JSONObject.NULL) {
            baseLiveResponse.liveBody = "";
        }
    }

    public JSONObject toJson(BaseLiveResponse baseLiveResponse, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "liveBody", baseLiveResponse.liveBody);
        return jSONObject;
    }
}
