package com.kwad.sdk.core.b.a;

import com.dhylive.app.utils.JumpParam;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bb implements com.kwad.sdk.core.d<AdInfo.AdvertiserInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdvertiserInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdvertiserInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        advertiserInfo.userId = jSONObject.optLong(JumpParam.USER_ID);
        advertiserInfo.userName = jSONObject.optString("userName");
        if (JSONObject.NULL.toString().equals(advertiserInfo.userName)) {
            advertiserInfo.userName = "";
        }
        advertiserInfo.rawUserName = jSONObject.optString("rawUserName");
        if (JSONObject.NULL.toString().equals(advertiserInfo.rawUserName)) {
            advertiserInfo.rawUserName = "";
        }
        advertiserInfo.userGender = jSONObject.optString("userGender");
        if (JSONObject.NULL.toString().equals(advertiserInfo.userGender)) {
            advertiserInfo.userGender = "";
        }
        advertiserInfo.portraitUrl = jSONObject.optString("portraitUrl");
        if (JSONObject.NULL.toString().equals(advertiserInfo.portraitUrl)) {
            advertiserInfo.portraitUrl = "";
        }
        advertiserInfo.adAuthorText = jSONObject.optString("adAuthorText");
        if (JSONObject.NULL.toString().equals(advertiserInfo.adAuthorText)) {
            advertiserInfo.adAuthorText = "";
        }
        advertiserInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
        if (JSONObject.NULL.toString().equals(advertiserInfo.authorIconGuide)) {
            advertiserInfo.authorIconGuide = "";
        }
        advertiserInfo.followed = jSONObject.optBoolean("followed");
        advertiserInfo.fansCount = jSONObject.optInt("fansCount");
        advertiserInfo.brief = jSONObject.optString("brief");
        if (JSONObject.NULL.toString().equals(advertiserInfo.brief)) {
            advertiserInfo.brief = "";
        }
    }

    private static JSONObject b(AdInfo.AdvertiserInfo advertiserInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (advertiserInfo.userId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, JumpParam.USER_ID, advertiserInfo.userId);
        }
        if (advertiserInfo.userName != null && !advertiserInfo.userName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userName", advertiserInfo.userName);
        }
        if (advertiserInfo.rawUserName != null && !advertiserInfo.rawUserName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rawUserName", advertiserInfo.rawUserName);
        }
        if (advertiserInfo.userGender != null && !advertiserInfo.userGender.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userGender", advertiserInfo.userGender);
        }
        if (advertiserInfo.portraitUrl != null && !advertiserInfo.portraitUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "portraitUrl", advertiserInfo.portraitUrl);
        }
        if (advertiserInfo.adAuthorText != null && !advertiserInfo.adAuthorText.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adAuthorText", advertiserInfo.adAuthorText);
        }
        if (advertiserInfo.authorIconGuide != null && !advertiserInfo.authorIconGuide.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorIconGuide", advertiserInfo.authorIconGuide);
        }
        if (advertiserInfo.followed) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "followed", advertiserInfo.followed);
        }
        if (advertiserInfo.fansCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fansCount", advertiserInfo.fansCount);
        }
        if (advertiserInfo.brief != null && !advertiserInfo.brief.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "brief", advertiserInfo.brief);
        }
        return jSONObject;
    }
}
