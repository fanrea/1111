package com.bytedance.sdk.djx.core.api;

import com.bytedance.sdk.djx.base.dynamic.api.DynamicApi;
import com.bytedance.sdk.djx.base.dynamic.api.DynamicRsp;
import com.bytedance.sdk.djx.core.api.req.DramaApi;
import com.bytedance.sdk.djx.core.api.req.FeedApi;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.bytedance.sdk.djx.core.api.req.VideoModelApi;
import com.bytedance.sdk.djx.core.api.rsp.DramaActionRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaFeedRsp;
import com.bytedance.sdk.djx.core.api.rsp.DramaRsp;
import com.bytedance.sdk.djx.core.api.rsp.FeedRsp;
import com.bytedance.sdk.djx.core.api.rsp.VideoModelRsp;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.setting.SettingApi;
import com.bytedance.sdk.djx.setting.SettingRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ApiManager {
    private static volatile ApiManager sInstance;

    public static ApiManager getInstance() {
        if (sInstance == null) {
            synchronized (ApiManager.class) {
                if (sInstance == null) {
                    sInstance = new ApiManager();
                }
            }
        }
        return sInstance;
    }

    private ApiManager() {
    }

    public void feed(IApiCallback<FeedRsp> iApiCallback, FeedReqParams feedReqParams, Map<String, Object> map) {
        FeedApi.loadFeed(iApiCallback, FeedReqParams.build(feedReqParams), map);
    }

    public void dramaDetail(long j, int i, int i2, int i3, List<Integer> list, IApiCallback<DramaFeedRsp> iApiCallback) {
        DramaApi.loadDramaDetail(j, i, i2, i3, list, iApiCallback);
    }

    public void videoModel(int i, long j, long j2, String str, IApiCallback<VideoModelRsp> iApiCallback) {
        VideoModelApi.vid2VM(i, j, j2, str, iApiCallback);
    }

    public void loadSettingCfg(IApiCallback<SettingRsp> iApiCallback) {
        SettingApi.loadSettingCfg(iApiCallback);
    }

    public void dynamic(IApiCallback<DynamicRsp> iApiCallback, String[] strArr) {
        DynamicApi.loadConfig(iApiCallback, strArr);
    }

    public static void postDramaPlayAction(Drama drama, IApiCallback<DramaActionRsp> iApiCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(drama);
        DramaApi.postDramaPlayAction(arrayList, iApiCallback);
    }

    public static void loadAllDramaHistory(IApiCallback<DramaRsp> iApiCallback) {
        DramaApi.loadDramaHistory(0, 0, iApiCallback);
    }

    public static void postFavorDrama(long j, int i, boolean z, IApiCallback<DramaActionRsp> iApiCallback) {
        DramaApi.dramaFavorAction(j, i, 1, z, iApiCallback);
    }

    public static void postLikeDrama(long j, int i, boolean z, IApiCallback<DramaActionRsp> iApiCallback) {
        DramaApi.dramaFavorAction(j, i, 2, z, iApiCallback);
    }
}
