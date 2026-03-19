package com.kwad.sdk.core.b.a;

import com.kwad.sdk.resourceCache.model.WarmUpReportMessage;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ob implements com.kwad.sdk.core.d<WarmUpReportMessage> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WarmUpReportMessage) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WarmUpReportMessage) bVar, jSONObject);
    }

    private static void a(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        warmUpReportMessage.downloadStatus = jSONObject.optInt("status", new Integer("0").intValue());
        warmUpReportMessage.resourceType = jSONObject.optInt("resource_type");
        warmUpReportMessage.resourceKey = jSONObject.optString("resource_key");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.resourceKey)) {
            warmUpReportMessage.resourceKey = "";
        }
        warmUpReportMessage.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.url)) {
            warmUpReportMessage.url = "";
        }
        warmUpReportMessage.localItems = jSONObject.optString("local_items");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.localItems)) {
            warmUpReportMessage.localItems = "";
        }
        warmUpReportMessage.configItems = jSONObject.optString("config_items");
        if (JSONObject.NULL.toString().equals(warmUpReportMessage.configItems)) {
            warmUpReportMessage.configItems = "";
        }
        warmUpReportMessage.freeDisk = jSONObject.optLong("free_disk");
    }

    private static JSONObject b(WarmUpReportMessage warmUpReportMessage, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "status", warmUpReportMessage.downloadStatus);
        if (warmUpReportMessage.resourceType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_type", warmUpReportMessage.resourceType);
        }
        if (warmUpReportMessage.resourceKey != null && !warmUpReportMessage.resourceKey.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_key", warmUpReportMessage.resourceKey);
        }
        if (warmUpReportMessage.url != null && !warmUpReportMessage.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", warmUpReportMessage.url);
        }
        if (warmUpReportMessage.localItems != null && !warmUpReportMessage.localItems.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "local_items", warmUpReportMessage.localItems);
        }
        if (warmUpReportMessage.configItems != null && !warmUpReportMessage.configItems.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "config_items", warmUpReportMessage.configItems);
        }
        if (warmUpReportMessage.freeDisk != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "free_disk", warmUpReportMessage.freeDisk);
        }
        return jSONObject;
    }
}
