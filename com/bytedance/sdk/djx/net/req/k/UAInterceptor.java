package com.bytedance.sdk.djx.net.req.k;

import android.text.TextUtils;
import com.bytedance.sdk.djx.net.UAUtil;
import com.bytedance.sdk.djx.net.k3.Interceptor;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.utils.debug.DebugInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UAInterceptor implements Interceptor {
    private static final UAInterceptor sDefault = new UAInterceptor();
    private Map<String, String> header = new HashMap();

    public static UAInterceptor DEFAULT() {
        return sDefault;
    }

    private UAInterceptor() {
    }

    @Override // com.bytedance.sdk.djx.net.k3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builderAddHeader = chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", UAUtil.getUserAgent());
        Map<String, String> map = this.header;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : this.header.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    builderAddHeader.addHeader(key, value);
                }
            }
        }
        addPPEOrBOE(builderAddHeader);
        return chain.proceed(builderAddHeader.build());
    }

    public void setHeader(Map<String, String> map) {
        this.header = map;
    }

    public void addPPEOrBOE(Request.Builder builder) {
        Map mapPpe;
        if (builder == null || (mapPpe = DebugInfo.Bridge.ppe()) == null || mapPpe.size() <= 0) {
            return;
        }
        for (Map.Entry entry : mapPpe.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                builder.addHeader(str, str2);
            }
        }
    }
}
