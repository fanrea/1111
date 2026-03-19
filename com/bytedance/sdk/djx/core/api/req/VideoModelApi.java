package com.bytedance.sdk.djx.core.api.req;

import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cm;
import com.bytedance.sdk.djx.core.api.ApiUrl;
import com.bytedance.sdk.djx.core.api.rsp.VideoModelRsp;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.RequestLogUtil;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.NetUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoModelApi {
    public static void vid2VM(int i, long j, long j2, String str, final IApiCallback<VideoModelRsp> iApiCallback) {
        NetClient.post().url(ApiUrl.videoModel()).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams(i, j, j2, str)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.VideoModelApi.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i2, String str2, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i2, str2);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    VideoModelRsp videoModelRsp = VideoModelApi.parse(JSON.build(netResponse.data));
                    RequestLogUtil.sendRequestBeanParseLog("VideoModelRsp", SystemClock.elapsedRealtime() - jElapsedRealtime);
                    if (videoModelRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(videoModelRsp);
                            return;
                        }
                        return;
                    }
                    int code = videoModelRsp.getCode();
                    if (TextUtils.isEmpty(videoModelRsp.getMsg())) {
                        ErrCode.msg(code);
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = videoModelRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, videoModelRsp);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static VideoModelRsp parse(JSONObject jSONObject) {
        VideoModelRsp videoModelRsp = new VideoModelRsp();
        videoModelRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(JSON.getJsonObject(jSONObject, "data"), "video_model");
        if (jsonObject != null) {
            VideoM videoM = new VideoM();
            videoM.setOriginal(jsonObject);
            videoM.setStatus(JSON.getInt(jsonObject, "status"));
            videoM.setMsg(JSON.getString(jsonObject, cm.V));
            videoM.setSupportSsl(JSON.getBoolean(jsonObject, "enable_ssl"));
            videoM.setVideoId(JSON.getString(jsonObject, "video_id"));
            videoM.setDuration(Double.valueOf(JSON.getDouble(jsonObject, "video_duration", 0.0d)).floatValue());
            videoM.setMediaType(JSON.getString(jsonObject, "media_type"));
            videoM.setFallbackApi(JSON.getString(jsonObject, "fallback_api"));
            videoM.setKeySeed(JSON.getString(jsonObject, "key_seed"));
            videoModelRsp.setData(videoM);
        }
        return videoModelRsp;
    }

    private static Map<String, String> buildParams(int i, long j, long j2, String str) {
        HashMap map = new HashMap(NetClient.getCommonParams());
        map.put("video_id", str);
        map.put("lock_free", String.valueOf(i));
        map.put("episode_id", String.valueOf(j));
        map.put("shortplay_id", String.valueOf(j2));
        return map;
    }
}
