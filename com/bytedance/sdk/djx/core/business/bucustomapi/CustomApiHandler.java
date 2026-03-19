package com.bytedance.sdk.djx.core.business.bucustomapi;

import android.text.TextUtils;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.commonsdk.api.utils.AppLogDidUtils;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.api.ApiUrl;
import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.util.MathUtils;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOthers;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.AppLogManager;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class CustomApiHandler {
    private static final String I_DETAIL = "playList";
    private static final String I_DID = "did";
    private static final String I_FEED_STREAM = "feedList";
    private static final String I_REPORT_EVENT = "reportEvent";
    private static final String I_UID = "userMeta";
    private static final String I_URL_LIST = "urlList";
    private static final String I_USER_SHORTPLAY = "userShortplay";
    private static final String K_INTERFACE = "interface";
    private static final String[] OUTER_KEYS = {"shortplay_id", "title", RemoteRewardActivity.JSON_BANNER_DESC_ID, ILogConst.Keys.KEY_CATEGORY_NAME, "cover_image", "poster_image", "play_url", Config.EXCEPTION_MEMORY_TOTAL, "index", "favorite_state", "favorite_time", "favorite_count", "like_state", "like_time", "like_count", "duration", "width", "height", "first_category_id", "first_category_name", "episode_id"};
    private static final String TAG = "CustomApiHandler";

    CustomApiHandler() {
    }

    public static boolean checkParamsOK(Map<String, String> map) {
        LG.d(TAG, "custom params:" + String.valueOf(map));
        return (map == null || map.isEmpty() || !map.containsKey(K_INTERFACE)) ? false : true;
    }

    public static void handle(Map<String, String> map, IDJXService.IDJXCallback<JSONObject> iDJXCallback) throws JSONException {
        String str = map.get(K_INTERFACE);
        if (I_FEED_STREAM.equalsIgnoreCase(str)) {
            requestFeed(map, iDJXCallback);
            return;
        }
        if (I_DETAIL.equalsIgnoreCase(str)) {
            requestDetail(map, iDJXCallback);
            return;
        }
        if (I_URL_LIST.equalsIgnoreCase(str)) {
            requestUrlList(map, iDJXCallback);
            return;
        }
        if (I_USER_SHORTPLAY.equalsIgnoreCase(str)) {
            requestUserShortplay(map, iDJXCallback);
            return;
        }
        if ("did".equalsIgnoreCase(str)) {
            handleDidRequest(map, iDJXCallback);
            return;
        }
        if (I_UID.equalsIgnoreCase(str)) {
            handleUserMetaRequest(map, iDJXCallback);
        } else if (I_REPORT_EVENT.equalsIgnoreCase(str)) {
            handleReportEventRequest(map, iDJXCallback);
        } else {
            iDJXCallback.onError(DJXError.build(-1, "参数错误：不支持的请求"));
        }
    }

    private static void handleDidRequest(Map<String, String> map, final IDJXService.IDJXCallback<JSONObject> iDJXCallback) {
        AppLogDidUtils.getInstance(DevInfo.sAppId).addDidListener(new AppLogDidUtils.Callback() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.1
            @Override // com.bytedance.sdk.commonsdk.api.utils.AppLogDidUtils.Callback
            public void onDidResult(boolean z) throws JSONException {
                if (z) {
                    String did = AppLogManager.getAppLogInstance().getDid();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("did", did);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    iDJXCallback.onSuccess(jSONObject, null);
                    return;
                }
                iDJXCallback.onError(DJXError.build(-1, "获取did失败"));
            }
        });
    }

    private static void handleUserMetaRequest(Map<String, String> map, IDJXService.IDJXCallback<JSONObject> iDJXCallback) throws JSONException {
        String userMeta = TokenHelper.getInstance().getUserMeta();
        if (TextUtils.isEmpty(userMeta)) {
            iDJXCallback.onError(DJXError.build(-1, "获取uid失败"));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(I_UID, userMeta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        iDJXCallback.onSuccess(jSONObject, null);
    }

    private static void handleReportEventRequest(final Map<String, String> map, IDJXService.IDJXCallback<JSONObject> iDJXCallback) {
        String str = map.get("event_name");
        String str2 = map.get("shortplay_id");
        String str3 = map.get("episode_id");
        String str4 = map.get("index");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || !MathUtils.isInteger(str4) || !MathUtils.isLong(str3) || !MathUtils.isLong(str2)) {
            iDJXCallback.onError(DJXError.build(-1, "参数错误：params参数非法"));
            return;
        }
        str.hashCode();
        if (str.equals(ILogConst.E_VIDEO_OVER)) {
            String str5 = map.get("duration");
            String str6 = map.get(ILogConst.Keys.KEY_PERCENT);
            if (!MathUtils.isLong(str5) || !MathUtils.isInteger(str6) || Integer.parseInt(str6) < 0 || Integer.parseInt(str6) > 100) {
                iDJXCallback.onError(DJXError.build(-1, "参数错误：duration或percent参数非法"));
                return;
            }
            BLogAgent.build("service", ILogConst.E_VIDEO_OVER_DRAW, null).putLong("group_id", Long.parseLong(str3)).putString(ILogConst.Keys.KEY_CATEGORY_NAME, "").putString(ILogConst.Keys.KEY_ENTER_FROM, "").putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, Long.parseLong(str2)).putLong("duration", Long.parseLong(str5)).putInt(ILogConst.Keys.KEY_PERCENT, Integer.parseInt(str6)).putString(ILogConst.Keys.INTERFACE_TYPE, ILogConst.INTERFACE_TYP_RC).putInt(ILogConst.Keys.KEY_EPISODE, Integer.parseInt(str4)).send();
            HashMap map2 = new HashMap();
            map2.put(ILogConst.Keys.KEY_PERCENT, Integer.valueOf(Integer.parseInt(str6)));
            map2.put("duration", Long.valueOf(Long.parseLong(str5)));
            DramaApi.postDramaAction("play_end", Long.parseLong(str2), Integer.parseInt(str4), map2, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.3
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(DramaActionRsp dramaActionRsp) {
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
                    LG.d(CustomApiHandler.TAG, "上报失败, params:" + map.toString() + "error:" + dJXError.toString());
                }
            });
        } else if (str.equals(ILogConst.E_VIDEO_PLAY)) {
            BLogAgent.build("service", ILogConst.E_VIDEO_PLAY, null).putLong("group_id", Long.parseLong(str3)).putString(ILogConst.Keys.KEY_CATEGORY_NAME, "").putString(ILogConst.Keys.KEY_ENTER_FROM, "").putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, Long.parseLong(str2)).putString(ILogConst.Keys.INTERFACE_TYPE, ILogConst.INTERFACE_TYP_RC).putInt(ILogConst.Keys.KEY_EPISODE, Integer.parseInt(str4)).send();
            DramaApi.postDramaAction("shortplay_play", Long.parseLong(str2), Integer.parseInt(str4), null, new IApiCallback<DramaActionRsp>() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.2
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(DramaActionRsp dramaActionRsp) {
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, DramaActionRsp dramaActionRsp) {
                    LG.d(CustomApiHandler.TAG, "上报失败, params:" + map.toString() + "error:" + dJXError.toString());
                }
            });
        } else {
            iDJXCallback.onError(DJXError.build(-1, "参数错误：event_name参数非法"));
            return;
        }
        iDJXCallback.onSuccess(new JSONObject(), null);
    }

    private static void requestUserShortplay(final Map<String, String> map, final IDJXService.IDJXCallback<JSONObject> iDJXCallback) {
        AppLogDidUtils.getInstance(DevInfo.sAppId).addDidListener(new AppLogDidUtils.Callback() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.4
            @Override // com.bytedance.sdk.commonsdk.api.utils.AppLogDidUtils.Callback
            public void onDidResult(boolean z) {
                if (z) {
                    String did = AppLogManager.getAppLogInstance().getDid();
                    Map<String, String> commonParams = CustomApiHandler.getCommonParams();
                    commonParams.putAll(map);
                    commonParams.put("uuid", did);
                    commonParams.put("uuid_type", "bddid");
                    commonParams.put("sdk_did", DeviceUtils.getLocalDid());
                    NetClient.post().url(ApiUrl.userShortplay()).params(commonParams).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.4.1
                        @Override // com.bytedance.sdk.djx.net.cb.NetCallback
                        public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                            super.onNetSuccess(netBuilder, netResponse);
                            CustomApiHandler.doSuccessTask(iDJXCallback, netBuilder, netResponse);
                        }

                        @Override // com.bytedance.sdk.djx.net.cb.NetCallback
                        public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                            super.onNetError(netBuilder, i, str, th);
                            CustomApiHandler.doErrorTask(iDJXCallback, netBuilder, i, str, th);
                        }
                    });
                }
            }
        });
    }

    private static void requestUrlList(Map<String, String> map, final IDJXService.IDJXCallback<JSONObject> iDJXCallback) {
        Map<String, String> commonParams = getCommonParams();
        commonParams.putAll(map);
        NetClient.post().url(ApiUrl.urlList()).params(commonParams).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.5
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                super.onNetSuccess(netBuilder, netResponse);
                CustomApiHandler.doSuccessTask(iDJXCallback, netBuilder, netResponse);
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                super.onNetError(netBuilder, i, str, th);
                CustomApiHandler.doErrorTask(iDJXCallback, netBuilder, i, str, th);
            }
        });
    }

    private static void requestFeed(Map<String, String> map, final IDJXService.IDJXCallback<JSONObject> iDJXCallback) {
        Map<String, String> commonParams = getCommonParams();
        commonParams.putAll(map);
        commonParams.put("category", "hotsoon_video_detail_draw");
        if (!commonParams.containsKey("lock_free")) {
            commonParams.put("lock_free", "1");
        }
        NetClient.post().url(ApiUrl.feed()).params(commonParams).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.6
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                super.onNetSuccess(netBuilder, netResponse);
                CustomApiHandler.doSuccessTask(iDJXCallback, netBuilder, netResponse);
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                super.onNetError(netBuilder, i, str, th);
                CustomApiHandler.doErrorTask(iDJXCallback, netBuilder, i, str, th);
            }
        });
    }

    private static void requestDetail(Map<String, String> map, final IDJXService.IDJXCallback<JSONObject> iDJXCallback) {
        Map<String, String> commonParams = getCommonParams();
        commonParams.putAll(map);
        if (!commonParams.containsKey("lock_free")) {
            commonParams.put("lock_free", "1");
        }
        commonParams.put("not_include", "0");
        NetClient.post().url(ApiUrl.dramaDetail()).params(commonParams).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.business.bucustomapi.CustomApiHandler.7
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                super.onNetSuccess(netBuilder, netResponse);
                CustomApiHandler.doSuccessTask(iDJXCallback, netBuilder, netResponse);
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                super.onNetError(netBuilder, i, str, th);
                CustomApiHandler.doErrorTask(iDJXCallback, netBuilder, i, str, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doSuccessTask(IDJXService.IDJXCallback<JSONObject> iDJXCallback, NetBuilder netBuilder, NetResponse<String> netResponse) {
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObjectBuild = JSON.build(netResponse.data);
            BaseDjxRsp baseDjxRsp = new BaseDjxRsp();
            baseDjxRsp.parseComm(jSONObjectBuild);
            if (jSONObjectBuild != null) {
                jSONObjectBuild.remove("extra");
            }
            JSONObject jsonObject = JSON.getJsonObject(jSONObjectBuild, "data");
            if (jsonObject != null && jsonObject.length() > 0) {
                jsonObject.remove("episode_right_list");
                JSONArray jsonArray = JSON.getJsonArray(jsonObject, "list");
                JSONArray jSONArrayBuildArr = JSON.buildArr();
                JSON.putObject(jsonObject, "list", jSONArrayBuildArr);
                if (jsonArray != null && jsonArray.length() > 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject jSONObjectOptJSONObject2 = jsonArray.optJSONObject(i);
                            JSONObject jSONObjectBuild2 = JSON.build();
                            jSONArrayBuildArr.put(jSONObjectBuild2);
                            for (String str : OUTER_KEYS) {
                                JSON.putObject(jSONObjectBuild2, str, JSON.getObject(jSONObjectOptJSONObject2, str));
                            }
                            JSONArray jsonArray2 = JSON.getJsonArray(jSONObjectOptJSONObject2, "poster_image_v2s");
                            if (jsonArray2 != null && jsonArray2.length() > 0 && (jSONObjectOptJSONObject = jsonArray2.optJSONObject(0)) != null) {
                                JSON.putObject(jSONObjectBuild2, "poster_image", JSON.getObject(jSONObjectOptJSONObject, "main_url"));
                            }
                        } catch (Throwable th) {
                            LG.d(TAG, "handle drama data error", th);
                        }
                    }
                }
            }
            if (baseDjxRsp.isOk()) {
                if (iDJXCallback != null) {
                    iDJXCallback.onSuccess(jSONObjectBuild, new DJXOthers().setRequestId(baseDjxRsp.getRequestId()));
                }
            } else if (iDJXCallback != null) {
                DJXError dJXError = baseDjxRsp.toDJXError();
                NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                iDJXCallback.onError(dJXError);
            }
        } catch (Throwable th2) {
            LG.e(TAG, "callback error", th2);
            if (iDJXCallback != null) {
                iDJXCallback.onError(DJXError.build(-2, ErrCode.msg(-2)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doErrorTask(IDJXService.IDJXCallback<JSONObject> iDJXCallback, NetBuilder netBuilder, int i, String str, Throwable th) {
        if (iDJXCallback != null) {
            DJXError dJXErrorBuild = DJXError.build(i, str);
            NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
            iDJXCallback.onError(dJXErrorBuild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> getCommonParams() {
        HashMap map = new HashMap(NetClient.getCommonParams());
        map.put("is_outter", "1");
        map.put("site_type", "1");
        map.put("video_type", "1");
        return map;
    }
}
