package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.AdLabelImpl;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class aa implements com.kwad.sdk.core.d<AdLabelImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdLabelImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdLabelImpl) bVar, jSONObject);
    }

    private static void a(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLabelImpl.thirdAge = jSONObject.optInt("thirdAge");
        adLabelImpl.thirdGender = jSONObject.optInt("thirdGender");
        adLabelImpl.thirdInterest = jSONObject.optString("thirdInterest");
        if (JSONObject.NULL.toString().equals(adLabelImpl.thirdInterest)) {
            adLabelImpl.thirdInterest = "";
        }
        adLabelImpl.prevTitle = jSONObject.optString("prevTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.prevTitle)) {
            adLabelImpl.prevTitle = "";
        }
        adLabelImpl.postTitle = jSONObject.optString("postTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.postTitle)) {
            adLabelImpl.postTitle = "";
        }
        adLabelImpl.historyTitle = jSONObject.optString("historyTitle");
        if (JSONObject.NULL.toString().equals(adLabelImpl.historyTitle)) {
            adLabelImpl.historyTitle = "";
        }
        adLabelImpl.channel = jSONObject.optString("channel");
        if (JSONObject.NULL.toString().equals(adLabelImpl.channel)) {
            adLabelImpl.channel = "";
        }
        adLabelImpl.cpmBidFloor = jSONObject.optLong("cpmBidFloor");
    }

    private static JSONObject b(AdLabelImpl adLabelImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adLabelImpl.thirdAge != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdAge", adLabelImpl.thirdAge);
        }
        if (adLabelImpl.thirdGender != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdGender", adLabelImpl.thirdGender);
        }
        if (adLabelImpl.thirdInterest != null && !adLabelImpl.thirdInterest.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "thirdInterest", adLabelImpl.thirdInterest);
        }
        if (adLabelImpl.prevTitle != null && !adLabelImpl.prevTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "prevTitle", adLabelImpl.prevTitle);
        }
        if (adLabelImpl.postTitle != null && !adLabelImpl.postTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "postTitle", adLabelImpl.postTitle);
        }
        if (adLabelImpl.historyTitle != null && !adLabelImpl.historyTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "historyTitle", adLabelImpl.historyTitle);
        }
        if (adLabelImpl.channel != null && !adLabelImpl.channel.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "channel", adLabelImpl.channel);
        }
        if (adLabelImpl.cpmBidFloor != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cpmBidFloor", adLabelImpl.cpmBidFloor);
        }
        return jSONObject;
    }
}
