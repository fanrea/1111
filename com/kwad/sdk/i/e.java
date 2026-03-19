package com.kwad.sdk.i;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class e implements com.kwad.sdk.i.b {
    public double bun;
    public int cfu;
    public b cfv;
    public a cfw;

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return null;
    }

    e() {
    }

    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.bun = jSONObject.optDouble(com.sigmob.sdk.base.n.C);
        this.cfu = jSONObject.optInt("kcType", 1);
        b bVar = new b();
        this.cfv = bVar;
        bVar.parseJson(jSONObject.optJSONObject("scopeConfig"));
        a aVar = new a();
        this.cfw = aVar;
        aVar.parseJson(jSONObject.optJSONObject("logConfig"));
    }

    public static class b implements com.kwad.sdk.i.b {
        public static int OK = 1;
        public static int cfA = 0;
        public static int cfz = -1;
        public List<String> bMD;
        public List<String> bME;
        public List<String> cfB;
        public int cfC = cfz;

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }

        public final void dh(boolean z) {
            this.cfC = z ? OK : cfA;
        }

        public final boolean alp() {
            return this.cfC == OK;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.bMD = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appIdList");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.bMD.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.bME = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.bME.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            this.cfB = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("deviceIdList");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.cfB.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
        }
    }

    public static class a implements com.kwad.sdk.i.b {
        public List<String> cfx;
        public List<String> cfy;
        public List<String> tagList;

        @Override // com.kwad.sdk.i.b
        public final JSONObject toJson() {
            return null;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.cfx = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("levelList");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.cfx.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.tagList = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tagList");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.tagList.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            this.cfy = new ArrayList();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("keywordList");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.cfy.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
        }
    }
}
