package com.kwad.sdk.core.b.a;

import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class jf implements com.kwad.sdk.core.d<NewsInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((NewsInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((NewsInfo) bVar, jSONObject);
    }

    private static void a(NewsInfo newsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        newsInfo.authorInfo = new CtPhotoInfo.AuthorInfo();
        newsInfo.authorInfo.parseJson(jSONObject.optJSONObject("authorInfo"));
        newsInfo.photoId = jSONObject.optLong("photoId");
        newsInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(newsInfo.title)) {
            newsInfo.title = "";
        }
        newsInfo.content = jSONObject.optString("content");
        if (JSONObject.NULL.toString().equals(newsInfo.content)) {
            newsInfo.content = "";
        }
        newsInfo.graphicSourceDesc = jSONObject.optString("graphicSourceDesc");
        if (JSONObject.NULL.toString().equals(newsInfo.graphicSourceDesc)) {
            newsInfo.graphicSourceDesc = "";
        }
        newsInfo.imageInfo = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("imageInfo");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                NewsInfo.ImageInfo imageInfo = new NewsInfo.ImageInfo();
                imageInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                newsInfo.imageInfo.add(imageInfo);
            }
        }
        newsInfo.thumbnailInfo = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("thumbnailInfo");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                NewsInfo.ImageInfo imageInfo2 = new NewsInfo.ImageInfo();
                imageInfo2.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                newsInfo.thumbnailInfo.add(imageInfo2);
            }
        }
        newsInfo.templateUrl = jSONObject.optString("templateUrl");
        if (JSONObject.NULL.toString().equals(newsInfo.templateUrl)) {
            newsInfo.templateUrl = "";
        }
        newsInfo.publishTimestamp = jSONObject.optLong("publishTimestamp");
        newsInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    private static JSONObject b(NewsInfo newsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "authorInfo", newsInfo.authorInfo);
        if (newsInfo.photoId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", newsInfo.photoId);
        }
        if (newsInfo.title != null && !newsInfo.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", newsInfo.title);
        }
        if (newsInfo.content != null && !newsInfo.content.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "content", newsInfo.content);
        }
        if (newsInfo.graphicSourceDesc != null && !newsInfo.graphicSourceDesc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "graphicSourceDesc", newsInfo.graphicSourceDesc);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "imageInfo", newsInfo.imageInfo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "thumbnailInfo", newsInfo.thumbnailInfo);
        if (newsInfo.templateUrl != null && !newsInfo.templateUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "templateUrl", newsInfo.templateUrl);
        }
        if (newsInfo.publishTimestamp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "publishTimestamp", newsInfo.publishTimestamp);
        }
        if (newsInfo.contentSourceType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentSourceType", newsInfo.contentSourceType);
        }
        return jSONObject;
    }
}
