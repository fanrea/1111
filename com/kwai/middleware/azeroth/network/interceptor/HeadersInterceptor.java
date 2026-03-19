package com.kwai.middleware.azeroth.network.interceptor;

import com.kwai.middleware.azeroth.network.AzerothApiParams;
import com.kwai.middleware.azeroth.utils.TextUtils;
import java.net.HttpURLConnection;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class HeadersInterceptor implements ConnectionInterceptor {
    private final AzerothApiParams mParams;

    public HeadersInterceptor(AzerothApiParams azerothApiParams) {
        this.mParams = azerothApiParams;
    }

    @Override // com.kwai.middleware.azeroth.network.interceptor.ConnectionInterceptor
    public void intercept(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, String> entry : this.mParams.getHeaders().entrySet()) {
            if (TextUtils.isEmpty(entry.getKey()) || TextUtils.isEmpty(entry.getValue())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
