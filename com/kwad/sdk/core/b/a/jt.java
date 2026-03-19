package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jt implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdStyleInfo.PlayDetailInfo.PatchAdInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdStyleInfo.PlayDetailInfo.PatchAdInfo) bVar, jSONObject);
    }

    private static void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleIcon)) {
            patchAdInfo.weakStyleIcon = "";
        }
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleTitle)) {
            patchAdInfo.weakStyleTitle = "";
        }
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleDownloadingTitle)) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (JSONObject.NULL.toString().equals(patchAdInfo.weakStyleAdMark)) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleCardUrl)) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleTitle)) {
            patchAdInfo.strongStyleTitle = "";
        }
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleSubTitle)) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (JSONObject.NULL.toString().equals(patchAdInfo.strongStyleAdMark)) {
            patchAdInfo.strongStyleAdMark = "";
        }
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean("true").booleanValue());
        patchAdInfo.weakStyleShowTime = jSONObject.optLong("weakStyleShowTime");
        patchAdInfo.strongStyleShowTime = jSONObject.optLong("strongStyleShowTime");
    }

    private static JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (patchAdInfo.weakStyleIcon != null && !patchAdInfo.weakStyleIcon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        }
        if (patchAdInfo.weakStyleTitle != null && !patchAdInfo.weakStyleTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        }
        if (patchAdInfo.weakStyleDownloadingTitle != null && !patchAdInfo.weakStyleDownloadingTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        }
        if (patchAdInfo.weakStyleAdMark != null && !patchAdInfo.weakStyleAdMark.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        }
        if (patchAdInfo.weakStyleAppearTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleAppearTime", patchAdInfo.weakStyleAppearTime);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        if (patchAdInfo.typePortrait != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "typePortrait", patchAdInfo.typePortrait);
        }
        if (patchAdInfo.strongStyleCardUrl != null && !patchAdInfo.strongStyleCardUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        }
        if (patchAdInfo.strongStyleAppearTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleAppearTime", patchAdInfo.strongStyleAppearTime);
        }
        if (patchAdInfo.strongStyleTitle != null && !patchAdInfo.strongStyleTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        }
        if (patchAdInfo.strongStyleSubTitle != null && !patchAdInfo.strongStyleSubTitle.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        }
        if (patchAdInfo.strongStyleAdMark != null && !patchAdInfo.strongStyleAdMark.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        if (patchAdInfo.weakStyleShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "weakStyleShowTime", patchAdInfo.weakStyleShowTime);
        }
        if (patchAdInfo.strongStyleShowTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "strongStyleShowTime", patchAdInfo.strongStyleShowTime);
        }
        return jSONObject;
    }
}
