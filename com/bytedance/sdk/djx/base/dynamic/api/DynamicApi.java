package com.bytedance.sdk.djx.base.dynamic.api;

import com.alipay.sdk.m.k.b;
import com.bytedance.sdk.djx.base.dynamic.DynamicModel;
import com.bytedance.sdk.djx.base.dynamic.LicenseModel;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.net.ApiConstants;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.setting.SettingApi;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.NetUtils;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicApi {
    public static final String LICENSE = "license";
    public static final String URL = ApiConstants.getHostWithPath() + "/app/ad_config";

    public static void loadConfig(final IApiCallback<DynamicRsp> iApiCallback, String[] strArr) {
        NetClient.post().url(URL).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams(strArr)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.base.dynamic.api.DynamicApi.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DynamicRsp dynamicRsp = DynamicApi.parse(JSON.build(netResponse.data));
                    if (dynamicRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dynamicRsp);
                        }
                    } else if (iApiCallback != null) {
                        DJXError dJXError = dynamicRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dynamicRsp);
                    }
                } catch (Throwable unused) {
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    private static Map<String, String> buildParams(String[] strArr) {
        Map<String, String> mapBuildParams = SettingApi.buildParams();
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                sb.append(strArr[i]);
                if (i < strArr.length - 1) {
                    sb.append(",");
                }
            }
            mapBuildParams.put("site_ids", sb.toString());
        }
        return mapBuildParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DynamicRsp parse(JSONObject jSONObject) {
        DynamicRsp dynamicRsp = new DynamicRsp();
        dynamicRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        dynamicRsp.setData(jsonObject);
        DynamicModel model = parseModel(jsonObject);
        dynamicRsp.addConfig(model.mInitSiteId, model);
        return dynamicRsp;
    }

    public static DynamicModel parseModel(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DynamicModel dynamicModel = new DynamicModel();
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, PointCategory.INIT);
        dynamicModel.mInitAppId = JSON.getString(jsonObject, b.D0);
        dynamicModel.mInitSiteId = JSON.getString(jsonObject, "site_id");
        dynamicModel.mInitPartner = JSON.getString(jsonObject, b.z0);
        dynamicModel.mInitSecureKey = JSON.getString(jsonObject, "secure_key_d");
        dynamicModel.mInitOldSecureKey = JSON.getString(jsonObject, "secure_key");
        JSONObject jsonObject2 = JSON.getJsonObject(jSONObject, "small_video");
        dynamicModel.mSmallDrawCodeId = JSON.getString(jsonObject2, "draw_ad_code_id");
        dynamicModel.mSmallDrawNativeCodeId = JSON.getString(jsonObject2, "draw_native_ad_code_id");
        dynamicModel.mSmallDrawInterstitialCodeId = JSON.getString(jsonObject2, "interstitial_ad_code_id");
        dynamicModel.mSmallDrawHalfScreenInterstitialCodeId = JSON.getString(jsonObject2, "draw_interstitial_ad_code_id");
        dynamicModel.mSmallDrawFullScreenInterstitialCodeId = JSON.getString(jsonObject2, "draw_fullscreen_interstitial_ad_code_id");
        dynamicModel.mSmallDrawNoteCodeId = JSON.getString(jsonObject2, "interstitial_note_ad_code_id");
        dynamicModel.mSmallCardCodeId = JSON.getString(jsonObject2, "video_card_ad_code_id");
        dynamicModel.mSmallCardDrawCodeId = JSON.getString(jsonObject2, "video_card_draw_ad_code_id");
        dynamicModel.mSmallCardDrawNativeCodeId = JSON.getString(jsonObject2, "video_card_draw_native_ad_code_id");
        dynamicModel.mSmallGridCodeId = JSON.getString(jsonObject2, "grid_ad_code_id");
        dynamicModel.mSmallGridDrawCodeId = JSON.getString(jsonObject2, "grid_draw_ad_code_id");
        dynamicModel.mSmallGridDrawNativeCodeId = JSON.getString(jsonObject2, "grid_draw_native_ad_code_id");
        dynamicModel.mSmallStaggeredGridCodeId = JSON.getString(jsonObject2, "staggered_grid_ad_code_id");
        dynamicModel.mSmallStaggeredGridDrawCodeId = JSON.getString(jsonObject2, "staggered_grid_draw_ad_code_id");
        dynamicModel.mSmallStaggeredGridDrawNativeCodeId = JSON.getString(jsonObject2, "staggered_grid_draw_native_ad_code_id");
        dynamicModel.mDrawBannerCodeId = JSON.getString(jsonObject2, "draw_banner_code_id");
        dynamicModel.mDramaRewardedAdCodeId = JSON.getString(jsonObject2, "drama_rewarded_ad_code_id");
        dynamicModel.mDramaRewardedAdCodeId2 = JSON.getString(jsonObject2, "drama_rewarded_ad_code_id_02");
        dynamicModel.mDramaDrawAdCodeId = JSON.getString(jsonObject2, "drama_draw_ad_code_id");
        dynamicModel.mStoryHomeAdCodeId = JSON.getString(jsonObject2, "staggered_grid_ad_code_id_02");
        dynamicModel.mStoryRewardedAdCodeId = JSON.getString(JSON.getJsonObject(jSONObject, "short_story"), "story_rewarded_ad_code_id");
        dynamicModel.mLicenseModel = parseLicense(jSONObject);
        return dynamicModel;
    }

    private static LicenseModel parseLicense(JSONObject jSONObject) {
        String string;
        JSONArray jsonArray = JSON.getJsonArray(jSONObject, "license_config");
        if (jsonArray == null || jsonArray.length() <= 0) {
            return null;
        }
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                string = JSON.getString(jsonArray.getJSONObject(i), "PackageName");
            } catch (JSONException unused) {
            }
            if (ToolUtils.getPackageName() != null && ToolUtils.getPackageName().equals(string)) {
                LicenseModel licenseModel = new LicenseModel();
                licenseModel.licensePackageName = string;
                licenseModel.licenseMainURL = JSON.getString(jsonArray.getJSONObject(i), "MainURL");
                licenseModel.licenseExpireTime = JSON.getString(jsonArray.getJSONObject(i), "ExpireTime");
                licenseModel.licenseId = JSON.getString(jsonArray.getJSONObject(i), "Id");
                licenseModel.licenseSignature = JSON.getString(jsonArray.getJSONObject(i), "Signature");
                licenseModel.licenseBackupURL = JSON.getString(jsonArray.getJSONObject(i), "BackupURL");
                licenseModel.licenseContent = JSON.getString(jsonArray.getJSONObject(i), "Content");
                return licenseModel;
            }
        }
        return null;
    }
}
