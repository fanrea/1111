package com.bytedance.sdk.djx.core.api;

import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.utils.DeviceUtils;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.NetUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AntiFraudApi {
    public static void loadAntiFraud(final IApiCallback<Boolean> iApiCallback) {
        NetClient.post().url("https://reward-api.csjplatform.com/luckycat/open/v1/init/video").addHeader("Content-Type", "application/json").addParam("ran_id", DeviceUtils.getAndroidId()).addParam("roa_id", DeviceUtils.getOaid()).addParam("rap_id", DeviceUtils.getDid()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.AntiFraudApi.1
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
                    JSONObject jSONObjectBuild = JSON.build(netResponse.data);
                    int i = JSON.getInt(jSONObjectBuild, "err_no");
                    if (i == 0) {
                        JSONObject jsonObject = JSON.getJsonObject(jSONObjectBuild, "data");
                        if (jsonObject != null) {
                            boolean z = JSON.getBoolean(jsonObject, "is_block", false);
                            IApiCallback iApiCallback2 = iApiCallback;
                            if (iApiCallback2 != null) {
                                iApiCallback2.onApiSuccess(Boolean.valueOf(z));
                            }
                        }
                    } else {
                        String string = JSON.getString(jSONObjectBuild, "err_tips");
                        if (iApiCallback != null) {
                            DJXError dJXErrorBuild = DJXError.build(i, string);
                            NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                            iApiCallback.onApiFailure(dJXErrorBuild, false);
                        }
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
}
