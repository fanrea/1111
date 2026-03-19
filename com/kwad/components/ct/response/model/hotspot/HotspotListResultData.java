package com.kwad.components.ct.response.model.hotspot;

import android.text.TextUtils;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HotspotListResultData extends BaseResultData implements b {
    private static final String TAG = "HotspotListResultData";
    private static final long serialVersionUID = 5203393014166710381L;
    public final HotspotListData hotspotListData = new HotspotListData();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("data");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        try {
            this.hotspotListData.parseJson(new JSONObject(d.getResponseData(strOptString)));
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        aa.a(new JSONObject(), "data", this.hotspotListData);
        return new JSONObject();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        if (!this.hotspotListData.trends.isEmpty()) {
            return false;
        }
        c.e(TAG, "trends list is empty");
        return true;
    }
}
