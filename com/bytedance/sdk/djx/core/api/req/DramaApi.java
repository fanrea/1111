package com.bytedance.sdk.djx.core.api.req;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.api.ApiUrl;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaDetailRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaFeedRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaParamsRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaUnlockModel;
import com.bytedance.sdk.djx.core.api.rsp.DramaUnlockRsp;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DJXEpisodeStatus;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXImage;
import com.bytedance.sdk.djx.model.DJXLock;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.DramaDrawAd;
import com.bytedance.sdk.djx.model.DramaFeed;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import com.bytedance.sdk.djx.net.api.BaseRsp;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.net.req.k.OkPostBuilder;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaApi {
    public static final int ALL = 1;
    public static final String ERR_SUB_RET_DRAMA_NOT_EXIST = "04005";
    public static final int FAVORITE_FOLDER_TYPE_FAVOR = 1;
    public static final int FAVORITE_FOLDER_TYPE_LIKE = 2;
    public static final int NOT_ALL = 0;
    private static final String TAG = "DramaApi";
    public static final int TYPE_ORDER_POSITIVE = 0;
    public static final int TYPE_ORDER_RECOMMEND = 2;
    public static final int TYPE_ORDER_REVERSE = 1;

    public static void loadDramaList(String str, List<String> list, int i, int i2, int i3, final IApiCallback<DramaRsp> iApiCallback) {
        OkPostBuilder okPostBuilderAddParam = NetClient.post().url(ApiUrl.dramaList()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("category", str).addParam("page", String.valueOf(i)).addParam("order", String.valueOf(i3)).addParam("num", String.valueOf(i2));
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            okPostBuilderAddParam.addParam("top_shortplay_id", sb.toString());
        }
        okPostBuilderAddParam.go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i4, String str2, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i4, str2);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    DramaRsp dramaRsp = DramaApi.parseDramaRsp(JSON.build(netResponse.data));
                    dramaRsp.parseDuration = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (dramaRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void loadDramaListByCategory(String str, int i, int i2, int i3, final IApiCallback<DramaRsp> iApiCallback) {
        if (i3 != 0 && i3 != 1) {
            i3 = 0;
        }
        NetClient.post().url(ApiUrl.dramaList()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("category", str).addParam("page", String.valueOf(i)).addParam("num", String.valueOf(i2)).addParam("order", String.valueOf(i3)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.2
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i4, String str2, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i4, str2);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaRsp dramaRsp = DramaApi.parseDramaRsp(JSON.build(netResponse.data));
                    if (dramaRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void loadDramaCategoryList(final IApiCallback<BaseRsp<List<String>>> iApiCallback) {
        NetClient.post().url(ApiUrl.dramaCategoryList()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.3
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
                    BaseDjxRsp dramaCategoryRsp = DramaApi.parseDramaCategoryRsp(JSON.build(netResponse.data));
                    if (dramaCategoryRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaCategoryRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaCategoryRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaCategoryRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void searchDrama(String str, boolean z, int i, int i2, final IApiCallback<DramaRsp> iApiCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NetClient.post().url(ApiUrl.dramaSearch()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("query", str.trim()).addParam("is_fuzzy", z ? "1" : "0").addParam("page", i >= 1 ? String.valueOf(i) : "1").addParam("num", i2 < 1 ? "20" : String.valueOf(i2)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.4
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i3, String str2, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i3, str2);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaRsp dramaRsp = DramaApi.parseDramaRsp(JSON.build(netResponse.data));
                    if (dramaRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void loadDramaAllList(int i, String str, int i2, int i3, int i4, final IApiCallback<DramaRsp> iApiCallback) {
        OkPostBuilder okPostBuilderAddParam = NetClient.post().url(ApiUrl.dramaAllList()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("order", String.valueOf(i4)).addParam("is_all", String.valueOf(i));
        if (i == 1) {
            okPostBuilderAddParam.addParam("page", String.valueOf(i2)).addParam("num", String.valueOf(i3));
        } else {
            okPostBuilderAddParam.addParam("shortplays", str);
        }
        okPostBuilderAddParam.go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.5
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i5, String str2, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i5, str2);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaRsp dramaRsp = DramaApi.parseDramaRsp(JSON.build(netResponse.data));
                    if (dramaRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void loadDramaDetail(long j, int i, int i2, int i3, List<Integer> list, final IApiCallback<DramaFeedRsp> iApiCallback) {
        OkPostBuilder okPostBuilderAddParam = NetClient.post().url(ApiUrl.dramaDetail()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("lock_free", String.valueOf(i3)).addParam("shortplay_id", String.valueOf(j)).addParam("not_include", String.valueOf(0)).addParam("direction", String.valueOf(0)).addParam("count", String.valueOf(i2)).addParam("index", String.valueOf(i));
        if (list != null && !list.isEmpty()) {
            okPostBuilderAddParam.addParam("draw_ad_index", String.valueOf(list));
        }
        okPostBuilderAddParam.go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.6
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i4, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i4, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaFeedRsp dramaFeedRsp = DramaApi.parseDramaFeedRsp(JSON.build(netResponse.data));
                    if (dramaFeedRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaFeedRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaFeedRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaFeedRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void postDramaAction(String str, long j, int i, Map<String, Object> map, final IApiCallback<DramaActionRsp> iApiCallback) {
        String strUserAction = ApiUrl.userAction();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("shortplay_id", j);
            jSONObject.put("index", i);
            jSONObject.put("action_time", System.currentTimeMillis() / 1000);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    jSONObject.put(str2, map.get(str2));
                }
            }
            jSONArray.put(jSONObject);
        } catch (Throwable unused) {
        }
        NetClient.post().url(strUserAction).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("action", str).addParam("params", jSONArray.toString()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.7
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i2, String str3, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i2, str3);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaActionRsp dramaActionRsp = DramaApi.parseDramaActionRsp(JSON.build(netResponse.data));
                    if (dramaActionRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaActionRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaActionRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaActionRsp);
                    }
                } catch (Throwable unused2) {
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void postDramaPlayAction(List<Drama> list, final IApiCallback<DramaActionRsp> iApiCallback) {
        String strUserAction = ApiUrl.userAction();
        JSONArray jSONArray = new JSONArray();
        try {
            for (Drama drama : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("shortplay_id", drama.id);
                jSONObject.put("index", drama.index);
                jSONObject.put("action_time", Math.max(drama.actionTime, System.currentTimeMillis() / 1000));
                jSONArray.put(jSONObject);
            }
        } catch (Throwable unused) {
        }
        NetClient.post().url(strUserAction).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("action", "shortplay_play").addParam("params", jSONArray.toString()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.8
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
                    DramaActionRsp dramaActionRsp = DramaApi.parseDramaActionRsp(JSON.build(netResponse.data));
                    if (dramaActionRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaActionRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaActionRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaActionRsp);
                    }
                } catch (Throwable unused2) {
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void syncHuoshanHistory(JSONArray jSONArray, final IApiCallback<DramaActionRsp> iApiCallback) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        NetClient.post().url(ApiUrl.userAction()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("action", "shortplay_play_sync").addParam("params", jSONArray.toString()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.9
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
                    DramaActionRsp dramaActionRsp = DramaApi.parseDramaActionRsp(JSON.build(netResponse.data));
                    if (dramaActionRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaActionRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaActionRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaActionRsp);
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

    public static void loadDramaHistory(int i, int i2, final IApiCallback<DramaRsp> iApiCallback) {
        NetClient.post().url(ApiUrl.dramaHistory()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("page", String.valueOf(i)).addParam("num", String.valueOf(i2)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.10
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i3, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i3, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaRsp dramaRsp = DramaApi.parseDramaRsp(JSON.build(netResponse.data));
                    if (dramaRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    public static void postDramaAdUnlock(Drama drama, int i, int i2, int i3, final IApiCallback<DramaUnlockRsp> iApiCallback) {
        NetClient.post().url(ApiUrl.dramaAdUnlock()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("lock_index", String.valueOf(i)).addParam("shortplay_id", String.valueOf(drama.id)).addParam("lock_free", String.valueOf(i2)).addParam("lock_ad", String.valueOf(i3)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.11
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i4, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i4, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaUnlockRsp dramaUnlockRsp = DramaApi.parseDramaUnlockRsp(JSON.build(netResponse.data));
                    if (dramaUnlockRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaUnlockRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaUnlockRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaUnlockRsp);
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

    public static void clearDramaHistory(final IApiCallback<DramaActionRsp> iApiCallback) {
        NetClient.post().url(ApiUrl.userAction()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("action", "shortplay_clean").addParam("action_time", String.valueOf(System.currentTimeMillis() / 1000)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.12
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
                    DramaActionRsp dramaActionRsp = DramaApi.parseDramaActionRsp(JSON.build(netResponse.data));
                    if (dramaActionRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaActionRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaActionRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaActionRsp);
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

    public static void verifyDramaParams(int i, int i2, int i3, final IApiCallback<DramaParamsRsp> iApiCallback) {
        NetClient.post().url(ApiUrl.dramaParamsCheck()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("lock_ad", String.valueOf(i3)).addParam("lock_free", String.valueOf(i2)).addParam("episode_count", String.valueOf(i)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.13
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i4, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i4, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaParamsRsp dramaParamsRsp = DramaApi.parseDramaParamsRsp(JSON.build(netResponse.data));
                    if (dramaParamsRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaParamsRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaParamsRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaParamsRsp);
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

    public static void dramaFavorAction(long j, int i, int i2, boolean z, final IApiCallback<DramaActionRsp> iApiCallback) {
        NetClient.post().url(ApiUrl.favoriteAction()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("shortplay_id", String.valueOf(j)).addParam("episode_index", String.valueOf(i)).addParam(j.m, String.valueOf(i2)).addParam("state", String.valueOf(z ? 1 : 2)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.14
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i3, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i3, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaActionRsp dramaActionRsp = DramaApi.parseDramaActionRsp(JSON.build(netResponse.data));
                    if (dramaActionRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaActionRsp);
                            return;
                        }
                        return;
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaActionRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaActionRsp);
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

    public static void getStoryFavoriteList(int i, int i2, final IApiCallback<DramaRsp> iApiCallback) {
        NetClient.post().url(ApiUrl.favoriteList()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams()).addParam("page", String.valueOf(i)).addParam("num", String.valueOf(i2)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.DramaApi.15
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i3, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i3, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    DramaRsp dramaRsp = DramaApi.parseDramaRsp(JSON.build(netResponse.data));
                    if (dramaRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(dramaRsp);
                            return;
                        }
                        return;
                    }
                    int code = dramaRsp.getCode();
                    if (TextUtils.isEmpty(dramaRsp.getMsg())) {
                        ErrCode.msg(code);
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = dramaRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, dramaRsp);
                    }
                } catch (Throwable th) {
                    LG.e(DramaApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    private static Map<String, String> buildParams() {
        return new HashMap(NetClient.getCommonParams());
    }

    public static DramaRsp parseDramaRsp(JSONObject jSONObject) {
        DramaRsp dramaRsp = new DramaRsp();
        dramaRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        dramaRsp.setData(parseDramaList(dramaRsp.getRequestId(), JSON.getJsonArray(jsonObject, "list")));
        dramaRsp.setHasMore(JSON.getBoolean(jsonObject, "has_more"));
        dramaRsp.setTotal(JSON.getInt(jsonObject, Config.EXCEPTION_MEMORY_TOTAL));
        return dramaRsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BaseDjxRsp<List<String>> parseDramaCategoryRsp(JSONObject jSONObject) {
        BaseDjxRsp<List<String>> baseDjxRsp = new BaseDjxRsp<>();
        baseDjxRsp.parseComm(jSONObject);
        JSONArray jsonArray = JSON.getJsonArray(JSON.getJsonObject(jSONObject, "data"), "old_list");
        ArrayList arrayList = new ArrayList();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    arrayList.add(jsonArray.getString(i));
                } catch (JSONException unused) {
                }
            }
        }
        baseDjxRsp.setData(arrayList);
        return baseDjxRsp;
    }

    private static List<Drama> parseDramaList(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                Drama drama = parseDrama(jSONObjectOptJSONObject);
                drama.reqId = str;
                drama.recMap.put("request_id", str);
                arrayList.add(drama);
            }
        }
        return arrayList;
    }

    public static Drama parseDrama(JSONObject jSONObject) {
        Drama drama = new Drama();
        String string = JSON.getString(jSONObject, "request_id");
        if (TextUtils.isEmpty(string)) {
            drama.reqId = string;
            drama.recMap.put("request_id", string);
        }
        drama.id = JSON.getLong(jSONObject, "shortplay_id");
        drama.status = JSON.getInt(jSONObject, "status");
        drama.total = JSON.getInt(jSONObject, Config.EXCEPTION_MEMORY_TOTAL);
        drama.title = JSON.getString(jSONObject, "title");
        drama.coverImage = JSON.getString(jSONObject, "cover_image");
        drama.coverImages2 = parseImageList(JSON.getJsonArray(jSONObject, "cover_image_v2s"));
        drama.freeSet = JSON.getInt(jSONObject, "lock_free");
        drama.lockSet = JSON.getInt(jSONObject, "lock_ad", 1);
        drama.index = JSON.getInt(jSONObject, "index", 0);
        drama.unlockIndex = JSON.getInt(jSONObject, "lock_index");
        drama.type = JSON.getString(jSONObject, ILogConst.Keys.KEY_CATEGORY_NAME);
        drama.typeId = JSON.getInt(jSONObject, "category_id");
        drama.desc = JSON.getString(jSONObject, RemoteRewardActivity.JSON_BANNER_DESC_ID);
        drama.scriptAuthor = JSON.getString(jSONObject, "source_novel_author");
        drama.scriptName = JSON.getString(jSONObject, "source_novel_name");
        drama.createTime = JSON.getLong(jSONObject, "create_time");
        drama.actionTime = JSON.getLong(jSONObject, "action_time");
        drama.visibility = JSON.getInt(jSONObject, "visibility", 0) == 1;
        drama.icpNumber = JSON.getString(jSONObject, NativeUnifiedADAppInfoImpl.Keys.ICP_NUMBER);
        try {
            drama.groupId = Long.parseLong(JSON.getString(jSONObject, "episode_id"));
        } catch (NumberFormatException unused) {
            drama.groupId = -1L;
        }
        drama.providerId = JSON.getInt(jSONObject, "provider_id");
        drama.rankId = JSON.getInt(jSONObject, "rank_id");
        try {
            drama.channelId = Long.parseLong(JSON.getString(jSONObject, "channel_id"));
        } catch (NumberFormatException unused2) {
            drama.channelId = 0L;
        }
        drama.isFavor = JSON.getInt(jSONObject, "favorite_state", 0) == 1;
        drama.favoriteTime = JSON.getLong(jSONObject, "favorite_time", 0L);
        drama.favoriteCount = JSON.getInt(jSONObject, "favorite_count", 0);
        drama.recMap.put("provider_id", Integer.valueOf(drama.providerId));
        drama.recMap.put("rank_id", Integer.valueOf(drama.rankId));
        drama.recMap.put("channel_id", Long.valueOf(drama.channelId));
        drama.levelLabel = JSON.getInt(jSONObject, "level_label");
        drama.isPotential = JSON.getBoolean(jSONObject, "is_potential");
        return drama;
    }

    private static DramaDetailRsp parseDramaDetailRsp(JSONObject jSONObject) {
        DramaDetailRsp dramaDetailRsp = new DramaDetailRsp();
        dramaDetailRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        List<DJXEpisodeStatus> episodeStatusList = parseEpisodeStatusList(JSON.getJsonArray(jsonObject, "episode_right_list"));
        List<DramaDetail> dramaDetailList = parseDramaDetailList(JSON.getJsonArray(jsonObject, "list"), dramaDetailRsp.getRequestId());
        dramaDetailRsp.setData(dramaDetailList);
        if (!dramaDetailList.isEmpty()) {
            dramaDetailRsp.setDrama(dramaDetailList.get(0).getDrama());
            dramaDetailRsp.setEpisodeStatusList(episodeStatusList);
        }
        return dramaDetailRsp;
    }

    private static List<DramaDetail> parseDramaDetailList(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                DramaDetail dramaDetail = parseDramaDetail(jSONObjectOptJSONObject);
                dramaDetail.setReqId(str);
                dramaDetail.getDrama().reqId = dramaDetail.getReqId();
                dramaDetail.getDrama().recMap.put("request_id", dramaDetail.getReqId());
                arrayList.add(dramaDetail);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DramaFeedRsp parseDramaFeedRsp(JSONObject jSONObject) {
        DramaFeedRsp dramaFeedRsp = new DramaFeedRsp();
        dramaFeedRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        dramaFeedRsp.setEpisodeStatusList(parseEpisodeStatusList(JSON.getJsonArray(jsonObject, "episode_right_list")));
        List<DramaFeed> dramaFeedList = parseDramaFeedList(JSON.getJsonArray(jsonObject, "list"), dramaFeedRsp.getRequestId());
        dramaFeedRsp.setData(dramaFeedList);
        if (!dramaFeedList.isEmpty()) {
            int i = 0;
            while (true) {
                if (i >= dramaFeedList.size()) {
                    break;
                }
                DramaFeed dramaFeed = dramaFeedList.get(i);
                if (dramaFeed instanceof DramaDetail) {
                    dramaFeedRsp.setDrama(((DramaDetail) dramaFeed).getDrama());
                    break;
                }
                i++;
            }
        }
        return dramaFeedRsp;
    }

    private static List<DramaFeed> parseDramaFeedList(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                int i2 = JSON.getInt(jSONObjectOptJSONObject, "cell_type");
                if (i2 == 3202) {
                    DramaDetail dramaDetail = parseDramaDetail(jSONObjectOptJSONObject);
                    dramaDetail.setReqId(str);
                    dramaDetail.getDrama().reqId = dramaDetail.getReqId();
                    dramaDetail.getDrama().recMap.put("request_id", dramaDetail.getReqId());
                    arrayList.add(dramaDetail);
                } else if (i2 == 3203) {
                    arrayList.add(parseDramaDrawAd(jSONObjectOptJSONObject));
                }
            }
        }
        return arrayList;
    }

    private static DramaDrawAd parseDramaDrawAd(JSONObject jSONObject) {
        DramaDrawAd dramaDrawAd = new DramaDrawAd(JSON.getInt(jSONObject, "ad_index", -1));
        dramaDrawAd.setDrawAd(JSON.getBoolean(jSONObject, "draw_ad", false));
        dramaDrawAd.setCellType(JSON.getInt(jSONObject, "cell_type", -1));
        return dramaDrawAd;
    }

    public static DramaDetail parseDramaDetail(JSONObject jSONObject) {
        DramaDetail dramaDetail = new DramaDetail();
        dramaDetail.setSkitId(JSON.getLong(jSONObject, "shortplay_id"));
        dramaDetail.setGroupId(JSON.getLong(jSONObject, "episode_id"));
        dramaDetail.setNextGroupId(JSON.getLong(jSONObject, "next_recommend_shortplay_id"));
        dramaDetail.setFrontGroupId(JSON.getLong(jSONObject, "front_episode_id"));
        dramaDetail.setIndex(JSON.getInt(jSONObject, "index"));
        dramaDetail.setStatus(JSON.getInt(jSONObject, "status"));
        dramaDetail.setSkitTotal(JSON.getInt(jSONObject, Config.EXCEPTION_MEMORY_TOTAL));
        dramaDetail.setSkitName(JSON.getString(jSONObject, "title"));
        dramaDetail.setNextRecommendSkitId(JSON.getLong(jSONObject, "next_recommend_shortplay_id"));
        dramaDetail.setVideoModel(FeedApi.parseVideoModel(JSON.getJsonObject(jSONObject, "video_model")));
        dramaDetail.setProviderId(JSON.getInt(jSONObject, "provider_id"));
        dramaDetail.setRankId(JSON.getInt(jSONObject, "rank_id"));
        try {
            dramaDetail.setChannelId(Long.parseLong(JSON.getString(jSONObject, "channel_id")));
        } catch (NumberFormatException unused) {
            dramaDetail.setChannelId(0L);
        }
        dramaDetail.setFirstCovers(parseImageList(JSON.getJsonArray(jSONObject, "poster_image_v2s")));
        dramaDetail.setDrama(parseDrama(jSONObject));
        dramaDetail.setDrawAd(JSON.getBoolean(jSONObject, "draw_ad", false));
        dramaDetail.setCellType(JSON.getInt(jSONObject, "cell_type", -1));
        dramaDetail.setIsLiked(JSON.getInt(jSONObject, "like_state", 0) == 1);
        dramaDetail.setLikeTime(JSON.getLong(jSONObject, "like_time", 0L));
        dramaDetail.setLikeCount(JSON.getInt(jSONObject, "like_count", 0));
        return dramaDetail;
    }

    public static List<DJXImage> parseImageList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            DJXImage image = parseImage(JSON.getJSONObject(jSONArray, i));
            if (image != null) {
                arrayList.add(image);
            }
        }
        return arrayList;
    }

    public static DJXImage parseImage(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DJXImage dJXImage = new DJXImage();
        dJXImage.url = JSON.getString(jSONObject, "main_url");
        dJXImage.backupUrl = JSON.getString(jSONObject, "backup_url");
        dJXImage.definition = JSON.getString(jSONObject, "definition");
        return dJXImage;
    }

    private static List<DJXEpisodeStatus> parseEpisodeStatusList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            DJXEpisodeStatus episodeStatus = parseEpisodeStatus(JSON.getJSONObject(jSONArray, i));
            if (episodeStatus != null) {
                arrayList.add(episodeStatus);
            }
        }
        return arrayList;
    }

    private static DJXEpisodeStatus parseEpisodeStatus(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new DJXEpisodeStatus(JSON.getInt(jSONObject, "index"), !JSON.getString(jSONObject, "lock_type").equals(Config.EXCEPTION_MEMORY_FREE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DramaActionRsp parseDramaActionRsp(JSONObject jSONObject) {
        DramaActionRsp dramaActionRsp = new DramaActionRsp();
        dramaActionRsp.parseComm(jSONObject);
        return dramaActionRsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DramaUnlockRsp parseDramaUnlockRsp(JSONObject jSONObject) {
        DramaUnlockRsp dramaUnlockRsp = new DramaUnlockRsp();
        dramaUnlockRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        int i = JSON.getInt(jsonObject, "lock_ad");
        JSONArray jsonArray = JSON.getJsonArray(jsonObject, "episode_index_list");
        ArrayList arrayList = new ArrayList();
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(Integer.valueOf(jsonArray.optInt(i2)));
            }
        }
        dramaUnlockRsp.setData(new DramaUnlockModel(i, arrayList));
        return dramaUnlockRsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DramaParamsRsp parseDramaParamsRsp(JSONObject jSONObject) {
        DramaParamsRsp dramaParamsRsp = new DramaParamsRsp();
        dramaParamsRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        DJXLock dJXLock = new DJXLock();
        dJXLock.lockSet = JSON.getInt(jsonObject, "lock_ad");
        dJXLock.freeSet = JSON.getInt(jsonObject, "lock_free");
        dramaParamsRsp.setData(dJXLock);
        return dramaParamsRsp;
    }
}
