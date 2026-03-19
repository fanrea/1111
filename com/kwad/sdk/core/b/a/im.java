package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class im implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.MerchantLiveReservationInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        merchantLiveReservationInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.title)) {
            merchantLiveReservationInfo.title = "";
        }
        merchantLiveReservationInfo.userHeadUrl = jSONObject.optString("userHeadUrl");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.userHeadUrl)) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        merchantLiveReservationInfo.liveStartTime = jSONObject.optString("liveStartTime");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.liveStartTime)) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                merchantLiveReservationInfo.bookUserUrlList.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        merchantLiveReservationInfo.playEndCard = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    private static JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (merchantLiveReservationInfo.title != null && !merchantLiveReservationInfo.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", merchantLiveReservationInfo.title);
        }
        if (merchantLiveReservationInfo.userHeadUrl != null && !merchantLiveReservationInfo.userHeadUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        if (merchantLiveReservationInfo.bookUserCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bookUserCount", merchantLiveReservationInfo.bookUserCount);
        }
        if (merchantLiveReservationInfo.liveStartTime != null && !merchantLiveReservationInfo.liveStartTime.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        if (merchantLiveReservationInfo.displayWeakCard) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayWeakCard", merchantLiveReservationInfo.displayWeakCard);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        if (merchantLiveReservationInfo.displayBookCount) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "displayBookCount", merchantLiveReservationInfo.displayBookCount);
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }
}
