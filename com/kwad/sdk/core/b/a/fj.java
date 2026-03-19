package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class fj implements com.kwad.sdk.core.d<FeedPageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((FeedPageInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((FeedPageInfo) bVar, jSONObject);
    }

    private static void a(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedPageInfo.status = jSONObject.optInt("status");
        feedPageInfo.loadStatus = jSONObject.optInt("load_status");
        feedPageInfo.adNum = jSONObject.optInt("ad_num");
        feedPageInfo.type = jSONObject.optInt("type");
        feedPageInfo.loadType = jSONObject.optLong("load_type");
        feedPageInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        feedPageInfo.resourceLoadDuration = jSONObject.optLong("resource_load_duration_ms");
        feedPageInfo.materialType = jSONObject.optInt("material_type");
        feedPageInfo.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(feedPageInfo.materialUrl)) {
            feedPageInfo.materialUrl = "";
        }
        feedPageInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        feedPageInfo.renderType = jSONObject.optInt("render_type");
        feedPageInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        feedPageInfo.convertDuration = jSONObject.optLong("convert_duartion_ms");
        feedPageInfo.extMsg = jSONObject.optString("ext_msg");
        if (JSONObject.NULL.toString().equals(feedPageInfo.extMsg)) {
            feedPageInfo.extMsg = "";
        }
        feedPageInfo.abParams = jSONObject.optString("ab_params");
        if (JSONObject.NULL.toString().equals(feedPageInfo.abParams)) {
            feedPageInfo.abParams = "";
        }
        feedPageInfo.callbackType = jSONObject.optInt("callback_type");
        feedPageInfo.materialInfoList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("material_info");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                FeedPageInfo.a aVar = new FeedPageInfo.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                feedPageInfo.materialInfoList.add(aVar);
            }
        }
    }

    private static JSONObject b(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (feedPageInfo.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", feedPageInfo.status);
        }
        if (feedPageInfo.loadStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_status", feedPageInfo.loadStatus);
        }
        if (feedPageInfo.adNum != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_num", feedPageInfo.adNum);
        }
        if (feedPageInfo.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", feedPageInfo.type);
        }
        if (feedPageInfo.loadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_type", feedPageInfo.loadType);
        }
        if (feedPageInfo.loadDataDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", feedPageInfo.loadDataDuration);
        }
        if (feedPageInfo.resourceLoadDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "resource_load_duration_ms", feedPageInfo.resourceLoadDuration);
        }
        if (feedPageInfo.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", feedPageInfo.materialType);
        }
        if (feedPageInfo.materialUrl != null && !feedPageInfo.materialUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_url", feedPageInfo.materialUrl);
        }
        if (feedPageInfo.renderDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_duration_ms", feedPageInfo.renderDuration);
        }
        if (feedPageInfo.renderType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "render_type", feedPageInfo.renderType);
        }
        if (feedPageInfo.expectedRenderType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "expected_render_type", feedPageInfo.expectedRenderType);
        }
        if (feedPageInfo.convertDuration != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "convert_duartion_ms", feedPageInfo.convertDuration);
        }
        if (feedPageInfo.extMsg != null && !feedPageInfo.extMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ext_msg", feedPageInfo.extMsg);
        }
        if (feedPageInfo.abParams != null && !feedPageInfo.abParams.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ab_params", feedPageInfo.abParams);
        }
        if (feedPageInfo.callbackType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", feedPageInfo.callbackType);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "material_info", feedPageInfo.materialInfoList);
        return jSONObject;
    }
}
