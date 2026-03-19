package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class cm implements com.kwad.sdk.core.d<a.C0576a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0576a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0576a) bVar, jSONObject);
    }

    private static void a(a.C0576a c0576a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0576a.bvi = jSONObject.optInt("ad_retry_type");
        c0576a.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(c0576a.templateId)) {
            c0576a.templateId = "";
        }
        c0576a.bvj = jSONObject.optString("template_sub_id");
        if (JSONObject.NULL.toString().equals(c0576a.bvj)) {
            c0576a.bvj = "";
        }
        c0576a.bvk = jSONObject.optString("default_type");
        if (JSONObject.NULL.toString().equals(c0576a.bvk)) {
            c0576a.bvk = "";
        }
        c0576a.bvm = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c0576a.bvm)) {
            c0576a.bvm = "";
        }
        c0576a.bvn = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c0576a.bvo = jSONObject.optInt("award_task_name");
        c0576a.bvp = jSONObject.optInt("jumps_liveroom_type");
        c0576a.bvq = jSONObject.optInt("universe_feature_freg");
        c0576a.bvr = jSONObject.optInt("replace_url_succ");
        c0576a.bvs = jSONObject.optBoolean("is_dp_opt");
        c0576a.bvt = jSONObject.optString("component_module");
        if (JSONObject.NULL.toString().equals(c0576a.bvt)) {
            c0576a.bvt = "";
        }
        c0576a.bvv = jSONObject.optInt("is_carousel");
        c0576a.bvw = jSONObject.optInt("is_special_preload");
        c0576a.bvx = jSONObject.optInt("card_type");
    }

    private static JSONObject b(a.C0576a c0576a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0576a.bvi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_retry_type", c0576a.bvi);
        }
        if (c0576a.templateId != null && !c0576a.templateId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", c0576a.templateId);
        }
        if (c0576a.bvj != null && !c0576a.bvj.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_sub_id", c0576a.bvj);
        }
        if (c0576a.bvk != null && !c0576a.bvk.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "default_type", c0576a.bvk);
        }
        if (c0576a.bvm != null && !c0576a.bvm.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_show_type", c0576a.bvm);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "network_download_status", c0576a.bvn);
        if (c0576a.bvo != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "award_task_name", c0576a.bvo);
        }
        if (c0576a.bvp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jumps_liveroom_type", c0576a.bvp);
        }
        if (c0576a.bvq != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universe_feature_freg", c0576a.bvq);
        }
        if (c0576a.bvr != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "replace_url_succ", c0576a.bvr);
        }
        if (c0576a.bvs) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_dp_opt", c0576a.bvs);
        }
        if (c0576a.bvt != null && !c0576a.bvt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "component_module", c0576a.bvt);
        }
        if (c0576a.bvv != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_carousel", c0576a.bvv);
        }
        if (c0576a.bvw != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_special_preload", c0576a.bvw);
        }
        if (c0576a.bvx != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "card_type", c0576a.bvx);
        }
        return jSONObject;
    }
}
