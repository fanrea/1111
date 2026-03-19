package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bz implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.commercial.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.commercial.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong("creative_id");
        aVar.llsid = jSONObject.optLong("llsid");
        aVar.posId = jSONObject.optLong("pos_Id");
        aVar.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(aVar.templateId)) {
            aVar.templateId = "";
        }
        aVar.templateVersion = jSONObject.optString("template_version");
        if (JSONObject.NULL.toString().equals(aVar.templateVersion)) {
            aVar.templateVersion = "";
        }
        aVar.tkPublishType = jSONObject.optInt("tk_publish_type");
        aVar.errorCode = jSONObject.optInt("error_code");
        aVar.errorMsg = jSONObject.optString("error_msg");
        if (JSONObject.NULL.toString().equals(aVar.errorMsg)) {
            aVar.errorMsg = "";
        }
        aVar.campaignType = jSONObject.optInt("campaign_type");
        aVar.ocpcActionType = jSONObject.optInt("ocpc_action_type");
        aVar.industryFirstLevelId = jSONObject.optInt("industry_first_level_id");
        aVar.adOperationType = jSONObject.optInt("ad_operation_type");
        aVar.webUriSourceType = jSONObject.optInt("web_uri_source_type");
    }

    private static JSONObject b(com.kwad.sdk.commercial.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.creativeId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "creative_id", aVar.creativeId);
        }
        if (aVar.llsid != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "llsid", aVar.llsid);
        }
        if (aVar.posId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pos_Id", aVar.posId);
        }
        if (aVar.templateId != null && !aVar.templateId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", aVar.templateId);
        }
        if (aVar.templateVersion != null && !aVar.templateVersion.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_version", aVar.templateVersion);
        }
        if (aVar.tkPublishType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "tk_publish_type", aVar.tkPublishType);
        }
        if (aVar.errorCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_code", aVar.errorCode);
        }
        if (aVar.errorMsg != null && !aVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "error_msg", aVar.errorMsg);
        }
        if (aVar.campaignType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "campaign_type", aVar.campaignType);
        }
        if (aVar.ocpcActionType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ocpc_action_type", aVar.ocpcActionType);
        }
        if (aVar.industryFirstLevelId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "industry_first_level_id", aVar.industryFirstLevelId);
        }
        if (aVar.adOperationType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_operation_type", aVar.adOperationType);
        }
        if (aVar.webUriSourceType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "web_uri_source_type", aVar.webUriSourceType);
        }
        return jSONObject;
    }
}
