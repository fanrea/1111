package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.hotspot.TabInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class mr implements com.kwad.sdk.core.d<TabInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((TabInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((TabInfo) bVar, jSONObject);
    }

    private static void a(TabInfo tabInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tabInfo.tabId = jSONObject.optInt("tabId");
        tabInfo.tabName = jSONObject.optString("tabName");
        if (JSONObject.NULL.toString().equals(tabInfo.tabName)) {
            tabInfo.tabName = "";
        }
    }

    private static JSONObject b(TabInfo tabInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (tabInfo.tabId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tabId", tabInfo.tabId);
        }
        if (tabInfo.tabName != null && !tabInfo.tabName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tabName", tabInfo.tabName);
        }
        return jSONObject;
    }
}
