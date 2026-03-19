package com.kwad.components.ct.request;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o implements com.kwad.sdk.core.b {
    public boolean aUR;
    public int aUS;
    public int aUT;
    public List<Long> aUU;

    public o() {
        this.aUU = new ArrayList();
    }

    public o(int i) {
        this.aUU = new ArrayList();
        this.aUR = true;
        this.aUS = 1;
    }

    public o(List<CtAdTemplate> list) {
        this.aUU = new ArrayList();
        this.aUR = false;
        if (list != null) {
            this.aUT = list.size();
            Iterator<CtAdTemplate> it = list.iterator();
            while (it.hasNext()) {
                this.aUU.add(Long.valueOf(com.kwad.components.ct.response.a.a.bg(it.next())));
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aUR = jSONObject.optBoolean("preload");
        this.aUS = jSONObject.optInt("requestVideoCount", 0);
        this.aUT = jSONObject.optInt("preloadedVideoCount", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("preloadedVideoList");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        this.aUU = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            this.aUU.add(Long.valueOf(jSONArrayOptJSONArray.optLong(i)));
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "preload", this.aUR);
        if (this.aUR) {
            aa.putValue(jSONObject, "requestVideoCount", this.aUS);
        } else {
            aa.putValue(jSONObject, "preloadedVideoCount", this.aUT);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.aUU.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            aa.putValue(jSONObject, "preloadedVideoList", jSONArray);
        }
        return jSONObject;
    }
}
