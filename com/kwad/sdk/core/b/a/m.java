package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.AdConversionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.AdConversionInfo) bVar, jSONObject);
    }

    private static void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        if (JSONObject.NULL.toString().equals(adConversionInfo.h5Url)) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkUrl)) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
            }
        }
        adConversionInfo.deeplinkExtra = jSONObject.optString("deeplinkExtra");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkExtra)) {
            adConversionInfo.deeplinkExtra = "";
        }
        adConversionInfo.adExt = jSONObject.optString("adExt");
        if (JSONObject.NULL.toString().equals(adConversionInfo.adExt)) {
            adConversionInfo.adExt = "";
        }
        adConversionInfo.appSecondConfirmationSwitch = jSONObject.optBoolean("appSecondConfirmationSwitch");
        adConversionInfo.h5SecondConfirmationSwitch = jSONObject.optBoolean("h5SecondConfirmationSwitch");
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.appDownloadUrl)) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.marketUrl)) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.playableUrl)) {
            adConversionInfo.playableUrl = "";
        }
        adConversionInfo.playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.liveServiceToken = jSONObject.optString("liveServiceToken");
        if (JSONObject.NULL.toString().equals(adConversionInfo.liveServiceToken)) {
            adConversionInfo.liveServiceToken = "";
        }
        adConversionInfo.liveVisitorId = jSONObject.optLong("liveVisitorId");
        adConversionInfo.smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrl)) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrlInfo)) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.interceptH5JumpAppMkt = jSONObject.optBoolean("interceptH5JumpAppMkt");
        adConversionInfo.interceptH5JumpTimeOut = jSONObject.optInt("interceptH5JumpTimeOut", new Integer(com.sigmob.sdk.base.n.i).intValue());
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.isSupportKeepPlaying = jSONObject.optBoolean("isSupportKeepPlaying");
        adConversionInfo.keepPlayingBackOffTime = jSONObject.optLong("keepPlayingBackOffTime", new Long("3000").longValue());
    }

    private static JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adConversionInfo.h5Url != null && !adConversionInfo.h5Url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5Url", adConversionInfo.h5Url);
        }
        if (adConversionInfo.h5Type != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5Type", adConversionInfo.h5Type);
        }
        if (adConversionInfo.deeplinkUrl != null && !adConversionInfo.deeplinkUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkConf", adConversionInfo.deeplinkConf);
        if (adConversionInfo.deeplinkExtra != null && !adConversionInfo.deeplinkExtra.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        if (adConversionInfo.adExt != null && !adConversionInfo.adExt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "adExt", adConversionInfo.adExt);
        }
        if (adConversionInfo.appSecondConfirmationSwitch) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appSecondConfirmationSwitch", adConversionInfo.appSecondConfirmationSwitch);
        }
        if (adConversionInfo.h5SecondConfirmationSwitch) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "h5SecondConfirmationSwitch", adConversionInfo.h5SecondConfirmationSwitch);
        }
        if (adConversionInfo.appDownloadUrl != null && !adConversionInfo.appDownloadUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        if (adConversionInfo.marketUrl != null && !adConversionInfo.marketUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        }
        if (adConversionInfo.supportThirdDownload != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "supportThirdDownload", adConversionInfo.supportThirdDownload);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        if (adConversionInfo.playableUrl != null && !adConversionInfo.playableUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        if (adConversionInfo.liveServiceToken != null && !adConversionInfo.liveServiceToken.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveServiceToken", adConversionInfo.liveServiceToken);
        }
        if (adConversionInfo.liveVisitorId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveVisitorId", adConversionInfo.liveVisitorId);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        if (adConversionInfo.webUriSourceType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "webUriSourceType", adConversionInfo.webUriSourceType);
        }
        if (adConversionInfo.callbackUrl != null && !adConversionInfo.callbackUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        if (adConversionInfo.callbackUrlInfo != null && !adConversionInfo.callbackUrlInfo.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        if (adConversionInfo.blockCallbackIfSpam) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "blockCallbackIfSpam", adConversionInfo.blockCallbackIfSpam);
        }
        if (adConversionInfo.needDeeplinkReplaceAdapta) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "needDeeplinkReplaceAdapta", adConversionInfo.needDeeplinkReplaceAdapta);
        }
        if (adConversionInfo.interceptH5JumpAppMkt) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "interceptH5JumpAppMkt", adConversionInfo.interceptH5JumpAppMkt);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "interceptH5JumpTimeOut", adConversionInfo.interceptH5JumpTimeOut);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        if (adConversionInfo.isSupportKeepPlaying) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isSupportKeepPlaying", adConversionInfo.isSupportKeepPlaying);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "keepPlayingBackOffTime", adConversionInfo.keepPlayingBackOffTime);
        return jSONObject;
    }
}
