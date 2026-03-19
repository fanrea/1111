package com.kwad.tachikoma.l;

import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements IOfflineCompoJsonParse {
    private final String CQ;
    private final int result;

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public final void parseJson(JSONObject jSONObject) {
    }

    public d(int i, String str) {
        this.result = i;
        this.CQ = str;
    }

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public final JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JsonHelper.putValue(jSONObject, "result", this.result);
        JsonHelper.putValue(jSONObject, "error_msg", this.CQ);
        return jSONObject;
    }
}
