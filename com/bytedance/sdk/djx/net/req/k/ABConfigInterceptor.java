package com.bytedance.sdk.djx.net.req.k;

import com.bytedance.sdk.djx.absdk.EMABManager;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import com.bytedance.sdk.djx.net.k3.Interceptor;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.k3.ResponseBody;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ABConfigInterceptor implements Interceptor {
    private static final String TAG = "ABConfigInterceptor";

    @Override // com.bytedance.sdk.djx.net.k3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response responseProceed = chain.proceed(request);
        ResponseBody responseBodyBody = responseProceed.body();
        String strString = responseBodyBody.string();
        ResponseBody responseBodyCreate = ResponseBody.create(responseBodyBody.getMediaType(), strString);
        handleABConfig(request.url().toString(), strString);
        return responseProceed.newBuilder().body(responseBodyCreate).build();
    }

    private void handleABConfig(String str, String str2) {
        if (str != null) {
            try {
                if (str.contains("/csj_sp/api/v1/app/settings")) {
                    JSONObject jSONObjectBuild = JSON.build(str2);
                    BaseDjxRsp baseDjxRsp = new BaseDjxRsp();
                    baseDjxRsp.parseComm(jSONObjectBuild);
                    if (baseDjxRsp.isOk()) {
                        EMABManager.getInstance().refresh(1, baseDjxRsp.getExtra().getABConfig());
                        LG.d(TAG, "ab_config: " + baseDjxRsp.getExtra().getABConfig());
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
