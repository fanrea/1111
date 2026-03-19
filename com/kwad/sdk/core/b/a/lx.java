package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class lx implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashMonitorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashMonitorInfo) bVar, jSONObject);
    }

    private static void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.status = jSONObject.optInt("status");
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.preloadId)) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.checkStatus = jSONObject.optInt("check_status");
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.beforeLoadDataTime = jSONObject.optLong("before_load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ids");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                splashMonitorInfo.ids.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong("size");
        splashMonitorInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.url)) {
            splashMonitorInfo.url = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong("creative_id");
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                splashMonitorInfo.creativeIds.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                splashMonitorInfo.preloadIds.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
        splashMonitorInfo.materialTypes = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("material_types");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                splashMonitorInfo.materialTypes.add((Integer) jSONArrayOptJSONArray4.opt(i4));
            }
        }
        splashMonitorInfo.updateType = jSONObject.optInt("update_type");
        splashMonitorInfo.clearCount = jSONObject.optInt("clear_count");
        splashMonitorInfo.clearImageCount = jSONObject.optInt("clear_image_count");
        splashMonitorInfo.clearVideoCount = jSONObject.optInt("clear_video_count");
        splashMonitorInfo.requestType = jSONObject.optInt("request_type");
        splashMonitorInfo.loadType = jSONObject.optInt("load_type");
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
        splashMonitorInfo.viewSource = jSONObject.optInt("view_source");
        splashMonitorInfo.elementTypes = new ArrayList();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("element_types");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                splashMonitorInfo.elementTypes.add((Integer) jSONArrayOptJSONArray5.opt(i5));
            }
        }
        splashMonitorInfo.interactiveStyle = jSONObject.optString("interactive_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactiveStyle)) {
            splashMonitorInfo.interactiveStyle = "";
        }
        splashMonitorInfo.interactivityDefaultStyle = jSONObject.optString("interactivity_default_style");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.interactivityDefaultStyle)) {
            splashMonitorInfo.interactivityDefaultStyle = "";
        }
        splashMonitorInfo.showEndTime = jSONObject.optLong("show_end_time");
        splashMonitorInfo.isRotateComposeTimeout = jSONObject.optBoolean("is_rotate_compose_timeout");
        splashMonitorInfo.tkDefaultTimeout = jSONObject.optLong("tk_default_timeout");
        splashMonitorInfo.soSource = jSONObject.optInt("so_source");
        splashMonitorInfo.soLoadTime = jSONObject.optLong("so_load_time");
        splashMonitorInfo.offlineSource = jSONObject.optInt("offline_source");
        splashMonitorInfo.offlineLoadTime = jSONObject.optLong("offline_load_time");
        splashMonitorInfo.tkFileLoadTime = jSONObject.optLong("tk_file_load_time");
        splashMonitorInfo.tkInitTime = jSONObject.optLong("tk_init_time");
        splashMonitorInfo.tkRenderTime = jSONObject.optLong("tk_render_time");
        splashMonitorInfo.nativeLoadTime = jSONObject.optLong("native_load_time");
        splashMonitorInfo.isWebTimeout = jSONObject.optBoolean("is_web_timeout");
        splashMonitorInfo.webLoadTime = jSONObject.optLong("web_load_time");
        splashMonitorInfo.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(splashMonitorInfo.templateId)) {
            splashMonitorInfo.templateId = "";
        }
        splashMonitorInfo.templateVersionCode = jSONObject.optInt("template_version_code");
        splashMonitorInfo.tkTotalTime = jSONObject.optLong("tk_total_time");
        splashMonitorInfo.actionType = jSONObject.optInt("action_type");
        splashMonitorInfo.callbackType = jSONObject.optInt("callback_type");
        splashMonitorInfo.tkRenderType = jSONObject.optLong("tk_render_type");
        splashMonitorInfo.loadProcessType = jSONObject.optLong("load_process_type");
        splashMonitorInfo.rootVisible = jSONObject.optBoolean("root_visible");
        splashMonitorInfo.parentVisible = jSONObject.optBoolean("parent_visible");
        splashMonitorInfo.addLoadTime = jSONObject.optLong("add_load_time");
        splashMonitorInfo.buriedPointOptimizeType = jSONObject.optInt("buried_point_optimize_type");
        splashMonitorInfo.visibleCheckDelayTime = jSONObject.optLong("visible_check_delay_time");
        splashMonitorInfo.requestLoadTime = jSONObject.optLong("request_load_Time");
        splashMonitorInfo.showType = jSONObject.optInt("show_type");
        splashMonitorInfo.showDurationMs = jSONObject.optLong("show_duration_ms");
        splashMonitorInfo.hasUnbind = jSONObject.optBoolean("has_unbind");
    }

    private static JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (splashMonitorInfo.status != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "status", splashMonitorInfo.status);
        }
        if (splashMonitorInfo.type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "type", splashMonitorInfo.type);
        }
        if (splashMonitorInfo.preloadId != null && !splashMonitorInfo.preloadId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "preload_id", splashMonitorInfo.preloadId);
        }
        if (splashMonitorInfo.checkStatus != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "check_status", splashMonitorInfo.checkStatus);
        }
        if (splashMonitorInfo.loadDataTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_data_duration_ms", splashMonitorInfo.loadDataTime);
        }
        if (splashMonitorInfo.beforeLoadDataTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "before_load_data_duration_ms", splashMonitorInfo.beforeLoadDataTime);
        }
        if (splashMonitorInfo.checkDataTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "check_data_duration_ms", splashMonitorInfo.checkDataTime);
        }
        if (splashMonitorInfo.loadAndCheckDataTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_and_check_data_duration_ms", splashMonitorInfo.loadAndCheckDataTime);
        }
        if (splashMonitorInfo.costTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "duration_ms", splashMonitorInfo.costTime);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "ids", splashMonitorInfo.ids);
        if (splashMonitorInfo.count != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "count", splashMonitorInfo.count);
        }
        if (splashMonitorInfo.cacheValidTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "validity_period_ms", splashMonitorInfo.cacheValidTime);
        }
        if (splashMonitorInfo.size != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "size", splashMonitorInfo.size);
        }
        if (splashMonitorInfo.url != null && !splashMonitorInfo.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", splashMonitorInfo.url);
        }
        if (splashMonitorInfo.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", splashMonitorInfo.creativeId);
        }
        if (splashMonitorInfo.materialType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "material_type", splashMonitorInfo.materialType);
        }
        if (splashMonitorInfo.totalCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_count", splashMonitorInfo.totalCount);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "preload_ids", splashMonitorInfo.preloadIds);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "material_types", splashMonitorInfo.materialTypes);
        if (splashMonitorInfo.updateType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "update_type", splashMonitorInfo.updateType);
        }
        if (splashMonitorInfo.clearCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clear_count", splashMonitorInfo.clearCount);
        }
        if (splashMonitorInfo.clearImageCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clear_image_count", splashMonitorInfo.clearImageCount);
        }
        if (splashMonitorInfo.clearVideoCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "clear_video_count", splashMonitorInfo.clearVideoCount);
        }
        if (splashMonitorInfo.requestType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_type", splashMonitorInfo.requestType);
        }
        if (splashMonitorInfo.loadType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_type", splashMonitorInfo.loadType);
        }
        if (splashMonitorInfo.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pos_Id", splashMonitorInfo.posId);
        }
        if (splashMonitorInfo.viewSource != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "view_source", splashMonitorInfo.viewSource);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "element_types", splashMonitorInfo.elementTypes);
        if (splashMonitorInfo.interactiveStyle != null && !splashMonitorInfo.interactiveStyle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interactive_style", splashMonitorInfo.interactiveStyle);
        }
        if (splashMonitorInfo.interactivityDefaultStyle != null && !splashMonitorInfo.interactivityDefaultStyle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interactivity_default_style", splashMonitorInfo.interactivityDefaultStyle);
        }
        if (splashMonitorInfo.showEndTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "show_end_time", splashMonitorInfo.showEndTime);
        }
        if (splashMonitorInfo.isRotateComposeTimeout) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_rotate_compose_timeout", splashMonitorInfo.isRotateComposeTimeout);
        }
        if (splashMonitorInfo.tkDefaultTimeout != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_default_timeout", splashMonitorInfo.tkDefaultTimeout);
        }
        if (splashMonitorInfo.soSource != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "so_source", splashMonitorInfo.soSource);
        }
        if (splashMonitorInfo.soLoadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "so_load_time", splashMonitorInfo.soLoadTime);
        }
        if (splashMonitorInfo.offlineSource != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "offline_source", splashMonitorInfo.offlineSource);
        }
        if (splashMonitorInfo.offlineLoadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "offline_load_time", splashMonitorInfo.offlineLoadTime);
        }
        if (splashMonitorInfo.tkFileLoadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_file_load_time", splashMonitorInfo.tkFileLoadTime);
        }
        if (splashMonitorInfo.tkInitTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_init_time", splashMonitorInfo.tkInitTime);
        }
        if (splashMonitorInfo.tkRenderTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_render_time", splashMonitorInfo.tkRenderTime);
        }
        if (splashMonitorInfo.nativeLoadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "native_load_time", splashMonitorInfo.nativeLoadTime);
        }
        if (splashMonitorInfo.isWebTimeout) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_web_timeout", splashMonitorInfo.isWebTimeout);
        }
        if (splashMonitorInfo.webLoadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "web_load_time", splashMonitorInfo.webLoadTime);
        }
        if (splashMonitorInfo.templateId != null && !splashMonitorInfo.templateId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", splashMonitorInfo.templateId);
        }
        if (splashMonitorInfo.templateVersionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_version_code", splashMonitorInfo.templateVersionCode);
        }
        if (splashMonitorInfo.tkTotalTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_total_time", splashMonitorInfo.tkTotalTime);
        }
        if (splashMonitorInfo.actionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "action_type", splashMonitorInfo.actionType);
        }
        if (splashMonitorInfo.callbackType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callback_type", splashMonitorInfo.callbackType);
        }
        if (splashMonitorInfo.tkRenderType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_render_type", splashMonitorInfo.tkRenderType);
        }
        if (splashMonitorInfo.loadProcessType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "load_process_type", splashMonitorInfo.loadProcessType);
        }
        if (splashMonitorInfo.rootVisible) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "root_visible", splashMonitorInfo.rootVisible);
        }
        if (splashMonitorInfo.parentVisible) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "parent_visible", splashMonitorInfo.parentVisible);
        }
        if (splashMonitorInfo.addLoadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "add_load_time", splashMonitorInfo.addLoadTime);
        }
        if (splashMonitorInfo.buriedPointOptimizeType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "buried_point_optimize_type", splashMonitorInfo.buriedPointOptimizeType);
        }
        if (splashMonitorInfo.visibleCheckDelayTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "visible_check_delay_time", splashMonitorInfo.visibleCheckDelayTime);
        }
        if (splashMonitorInfo.requestLoadTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_load_Time", splashMonitorInfo.requestLoadTime);
        }
        if (splashMonitorInfo.showType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "show_type", splashMonitorInfo.showType);
        }
        if (splashMonitorInfo.showDurationMs != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "show_duration_ms", splashMonitorInfo.showDurationMs);
        }
        if (splashMonitorInfo.hasUnbind) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "has_unbind", splashMonitorInfo.hasUnbind);
        }
        return jSONObject;
    }
}
