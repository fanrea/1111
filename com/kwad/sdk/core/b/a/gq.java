package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.hotspot.HotspotListData;
import com.kwad.components.ct.response.model.hotspot.TabInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class gq implements com.kwad.sdk.core.d<HotspotListData> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HotspotListData) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HotspotListData) bVar, jSONObject);
    }

    private static void a(HotspotListData hotspotListData, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hotspotListData.trends = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("trends");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                HotspotInfo hotspotInfo = new HotspotInfo();
                hotspotInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                hotspotListData.trends.add(hotspotInfo);
            }
        }
        hotspotListData.tabList = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tabList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                TabInfo tabInfo = new TabInfo();
                tabInfo.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                hotspotListData.tabList.add(tabInfo);
            }
        }
    }

    private static JSONObject b(HotspotListData hotspotListData, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "trends", hotspotListData.trends);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "tabList", hotspotListData.tabList);
        return jSONObject;
    }
}
