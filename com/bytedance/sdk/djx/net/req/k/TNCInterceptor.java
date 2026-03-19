package com.bytedance.sdk.djx.net.req.k;

import com.bytedance.sdk.adtnc.AdTNCSdk;
import com.bytedance.sdk.adtnc.sdk.bean.TNCRequest;
import com.bytedance.sdk.adtnc.sdk.bean.TNCResponse;
import com.bytedance.sdk.djx.net.k3.Headers;
import com.bytedance.sdk.djx.net.k3.HttpUrl;
import com.bytedance.sdk.djx.net.k3.Interceptor;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class TNCInterceptor implements Interceptor {
    private String aid;

    public static TNCInterceptor DEFAULT() {
        return new TNCInterceptor("540060");
    }

    private TNCInterceptor(String str) {
        this.aid = str;
    }

    @Override // com.bytedance.sdk.djx.net.k3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request requestInterceptorRequest = interceptorRequest(chain);
        try {
            Response responseProceed = chain.proceed(requestInterceptorRequest);
            if (responseProceed.isSuccessful()) {
                interceptorResponse(requestInterceptorRequest, responseProceed);
            } else {
                interceptorResponseError(requestInterceptorRequest, new IOException());
            }
            return responseProceed;
        } catch (Throwable th) {
            interceptorResponseError(requestInterceptorRequest, th);
            throw th;
        }
    }

    private Request interceptorRequest(Interceptor.Chain chain) {
        try {
            Request request = chain.request();
            HttpUrl httpUrlUrl = request.url();
            String string = httpUrlUrl.url().toString();
            String strFilterUrl = AdTNCSdk.getInstance().filterUrl(this.aid, string);
            if (string.equals(strFilterUrl)) {
                return request;
            }
            return request.newBuilder().url(httpUrlUrl.newBuilder(strFilterUrl).build()).build();
        } catch (Throwable unused) {
            return chain.request();
        }
    }

    private void interceptorResponse(Request request, Response response) {
        try {
            AdTNCSdk.getInstance().onResponse(this.aid, new TNCRequest(request.url().toString()), new TNCResponse(response.code(), convertResponseHeader(response.headers())));
        } catch (Throwable unused) {
        }
    }

    private void interceptorResponseError(Request request, Throwable th) {
        try {
            AdTNCSdk.getInstance().onError(this.aid, new TNCRequest(request.url().toString()), th);
        } catch (Throwable unused) {
        }
    }

    private Map<String, String> convertResponseHeader(Headers headers) {
        HashMap map = new HashMap();
        if (headers != null && headers.size() > 0) {
            for (int i = 0; i < headers.size(); i++) {
                map.put(headers.name(i), headers.value(i));
            }
        }
        return map;
    }
}
