package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.home.PhotoComment;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jw implements com.kwad.sdk.core.d<PhotoComment> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoComment) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoComment) bVar, jSONObject);
    }

    private static void a(PhotoComment photoComment, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoComment.subCommentCount = jSONObject.optLong("subCommentCount");
        photoComment.hot = jSONObject.optBoolean("hot");
        photoComment.likedCount = jSONObject.optLong("likedCount");
        photoComment.time = jSONObject.optString("time");
        if (JSONObject.NULL.toString().equals(photoComment.time)) {
            photoComment.time = "";
        }
        photoComment.timestamp = jSONObject.optLong(com.alipay.sdk.m.t.a.k);
        photoComment.content = jSONObject.optString("content");
        if (JSONObject.NULL.toString().equals(photoComment.content)) {
            photoComment.content = "";
        }
        photoComment.authorArea = jSONObject.optString("authorArea");
        if (JSONObject.NULL.toString().equals(photoComment.authorArea)) {
            photoComment.authorArea = "";
        }
        photoComment.photo_id = jSONObject.optLong("photo_id");
        photoComment.author_id = jSONObject.optLong("author_id");
        photoComment.user_id = jSONObject.optLong("user_id");
        photoComment.user_sex = jSONObject.optString("user_sex");
        if (JSONObject.NULL.toString().equals(photoComment.user_sex)) {
            photoComment.user_sex = "";
        }
        photoComment.comment_id = jSONObject.optLong("comment_id");
        photoComment.headurl = jSONObject.optString("headurl");
        if (JSONObject.NULL.toString().equals(photoComment.headurl)) {
            photoComment.headurl = "";
        }
        photoComment.author_name = jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME);
        if (JSONObject.NULL.toString().equals(photoComment.author_name)) {
            photoComment.author_name = "";
        }
    }

    private static JSONObject b(PhotoComment photoComment, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (photoComment.subCommentCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "subCommentCount", photoComment.subCommentCount);
        }
        if (photoComment.hot) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "hot", photoComment.hot);
        }
        if (photoComment.likedCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likedCount", photoComment.likedCount);
        }
        if (photoComment.time != null && !photoComment.time.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "time", photoComment.time);
        }
        if (photoComment.timestamp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, com.alipay.sdk.m.t.a.k, photoComment.timestamp);
        }
        if (photoComment.content != null && !photoComment.content.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "content", photoComment.content);
        }
        if (photoComment.authorArea != null && !photoComment.authorArea.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "authorArea", photoComment.authorArea);
        }
        if (photoComment.photo_id != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photo_id", photoComment.photo_id);
        }
        if (photoComment.author_id != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "author_id", photoComment.author_id);
        }
        if (photoComment.user_id != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "user_id", photoComment.user_id);
        }
        if (photoComment.user_sex != null && !photoComment.user_sex.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "user_sex", photoComment.user_sex);
        }
        if (photoComment.comment_id != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "comment_id", photoComment.comment_id);
        }
        if (photoComment.headurl != null && !photoComment.headurl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "headurl", photoComment.headurl);
        }
        if (photoComment.author_name != null && !photoComment.author_name.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, photoComment.author_name);
        }
        return jSONObject;
    }
}
