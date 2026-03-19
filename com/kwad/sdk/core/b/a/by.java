package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PhotoInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class by implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((PhotoInfo.BaseInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((PhotoInfo.BaseInfo) bVar, jSONObject);
    }

    private static void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(baseInfo.sdkExtraData)) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(baseInfo.title)) {
            baseInfo.title = "";
        }
        baseInfo.photoDescribeSize = jSONObject.optInt("photoDescribeSize");
        baseInfo.photoTitleSize = jSONObject.optInt("photoTitleSize");
        baseInfo.shareUrl = jSONObject.optString("shareUrl");
        if (JSONObject.NULL.toString().equals(baseInfo.shareUrl)) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.waterMarkShowDuration = jSONObject.optLong("waterMarkShowDuration", new Long("-1").longValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (JSONObject.NULL.toString().equals(baseInfo.recoExt)) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (JSONObject.NULL.toString().equals(baseInfo.videoDesc)) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
        baseInfo.toolbarDisable = jSONObject.optBoolean("toolbarDisable");
    }

    private static JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (baseInfo.photoId != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoId", baseInfo.photoId);
        }
        if (baseInfo.sdkExtraData != null && !baseInfo.sdkExtraData.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkExtraData", baseInfo.sdkExtraData);
        }
        if (baseInfo.title != null && !baseInfo.title.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "title", baseInfo.title);
        }
        if (baseInfo.photoDescribeSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoDescribeSize", baseInfo.photoDescribeSize);
        }
        if (baseInfo.photoTitleSize != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "photoTitleSize", baseInfo.photoTitleSize);
        }
        if (baseInfo.shareUrl != null && !baseInfo.shareUrl.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "shareUrl", baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "waterMarkPosition", baseInfo.waterMarkPosition);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "waterMarkShowDuration", baseInfo.waterMarkShowDuration);
        if (baseInfo.recoExt != null && !baseInfo.recoExt.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recoExt", baseInfo.recoExt);
        }
        if (baseInfo.likeCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likeCount", baseInfo.likeCount);
        }
        if (baseInfo.commentCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "commentCount", baseInfo.commentCount);
        }
        if (baseInfo.viewCount != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "viewCount", baseInfo.viewCount);
        }
        if (baseInfo.createTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "createTime", baseInfo.createTime);
        }
        if (baseInfo.videoDesc != null && !baseInfo.videoDesc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoDesc", baseInfo.videoDesc);
        }
        if (baseInfo.playTimes != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "playTimes", baseInfo.playTimes);
        }
        if (baseInfo.videoUrlCacheTime != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "videoUrlCacheTime", baseInfo.videoUrlCacheTime);
        }
        if (baseInfo.contentSourceType != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "contentSourceType", baseInfo.contentSourceType);
        }
        if (baseInfo.toolbarDisable) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "toolbarDisable", baseInfo.toolbarDisable);
        }
        return jSONObject;
    }
}
