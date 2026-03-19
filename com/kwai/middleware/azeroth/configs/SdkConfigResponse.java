package com.kwai.middleware.azeroth.configs;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SdkConfigResponse implements JsonAdapter<SdkConfigResponse>, Serializable {
    private static final String KEY_DATA = "data";
    private static final long serialVersionUID = 5997219343616419531L;
    public Map<String, String> mSdkConfigMap;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public SdkConfigResponse fromJson(String str) {
        SdkConfigResponse sdkConfigResponse = new SdkConfigResponse();
        sdkConfigResponse.mSdkConfigMap = JsonUtils.fromJsonToMap(str);
        return sdkConfigResponse;
    }

    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", JsonUtils.toJson(this.mSdkConfigMap));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
