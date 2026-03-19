package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bp implements com.kwad.sdk.core.d<CtPhotoInfo.AuthorInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CtPhotoInfo.AuthorInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CtPhotoInfo.AuthorInfo) bVar, jSONObject);
    }

    private static void a(CtPhotoInfo.AuthorInfo authorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        authorInfo.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        authorInfo.kwaiId = jSONObject.optString("kwaiId");
        if (JSONObject.NULL.toString().equals(authorInfo.kwaiId)) {
            authorInfo.kwaiId = "";
        }
        authorInfo.authorName = jSONObject.optString("authorName");
        if (JSONObject.NULL.toString().equals(authorInfo.authorName)) {
            authorInfo.authorName = "";
        }
        authorInfo.rawAuthorName = jSONObject.optString("rawAuthorName");
        if (JSONObject.NULL.toString().equals(authorInfo.rawAuthorName)) {
            authorInfo.rawAuthorName = "";
        }
        authorInfo.authorIcon = jSONObject.optString("authorIcon");
        if (JSONObject.NULL.toString().equals(authorInfo.authorIcon)) {
            authorInfo.authorIcon = "";
        }
        authorInfo.authorGender = jSONObject.optString("authorGender");
        if (JSONObject.NULL.toString().equals(authorInfo.authorGender)) {
            authorInfo.authorGender = "";
        }
        authorInfo.authorText = jSONObject.optString("authorText");
        if (JSONObject.NULL.toString().equals(authorInfo.authorText)) {
            authorInfo.authorText = "";
        }
        authorInfo.authorIconGuide = jSONObject.optString("authorIconGuide");
        if (JSONObject.NULL.toString().equals(authorInfo.authorIconGuide)) {
            authorInfo.authorIconGuide = "";
        }
        authorInfo.authorEid = jSONObject.optString("authorEid");
        if (JSONObject.NULL.toString().equals(authorInfo.authorEid)) {
            authorInfo.authorEid = "";
        }
        authorInfo.authorArea = jSONObject.optString("authorArea");
        if (JSONObject.NULL.toString().equals(authorInfo.authorArea)) {
            authorInfo.authorArea = "";
        }
        authorInfo.isJoinedBlacklist = jSONObject.optBoolean("isJoinedBlacklist");
    }

    private static JSONObject b(CtPhotoInfo.AuthorInfo authorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (authorInfo.authorId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, authorInfo.authorId);
        }
        if (authorInfo.kwaiId != null && !authorInfo.kwaiId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "kwaiId", authorInfo.kwaiId);
        }
        if (authorInfo.authorName != null && !authorInfo.authorName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorName", authorInfo.authorName);
        }
        if (authorInfo.rawAuthorName != null && !authorInfo.rawAuthorName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "rawAuthorName", authorInfo.rawAuthorName);
        }
        if (authorInfo.authorIcon != null && !authorInfo.authorIcon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorIcon", authorInfo.authorIcon);
        }
        if (authorInfo.authorGender != null && !authorInfo.authorGender.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorGender", authorInfo.authorGender);
        }
        if (authorInfo.authorText != null && !authorInfo.authorText.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorText", authorInfo.authorText);
        }
        if (authorInfo.authorIconGuide != null && !authorInfo.authorIconGuide.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorIconGuide", authorInfo.authorIconGuide);
        }
        if (authorInfo.authorEid != null && !authorInfo.authorEid.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorEid", authorInfo.authorEid);
        }
        if (authorInfo.authorArea != null && !authorInfo.authorArea.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorArea", authorInfo.authorArea);
        }
        if (authorInfo.isJoinedBlacklist) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "isJoinedBlacklist", authorInfo.isJoinedBlacklist);
        }
        return jSONObject;
    }
}
