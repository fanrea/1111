package com.bytedance.sdk.djx.net.req.k;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.commonsdk.api.utils.CommonSdkUtils;
import com.bytedance.sdk.djx.net.ISendRequestLogCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.k3.Call;
import com.bytedance.sdk.djx.net.k3.Callback;
import com.bytedance.sdk.djx.net.k3.Headers;
import com.bytedance.sdk.djx.net.k3.OkHttpClient;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import java.io.IOException;
import java.net.SocketException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OkGetBuilder extends NetBuilder<OkGetBuilder> {
    private final Handler mDelivery;
    private final ISendRequestLogCallback mSendRequestLogCallback;
    private final OkHttpClient okHttpClient;
    private final ArrayMap<String, Long> mMap = new ArrayMap<>();
    private final Context context = CommonSdkUtils.getContext();

    static /* synthetic */ int access$508(OkGetBuilder okGetBuilder) {
        int i = okGetBuilder.mRetryCurrent;
        okGetBuilder.mRetryCurrent = i + 1;
        return i;
    }

    public OkGetBuilder(OkHttpClient okHttpClient, Handler handler, ISendRequestLogCallback iSendRequestLogCallback) {
        this.okHttpClient = okHttpClient;
        this.mDelivery = handler;
        this.mSendRequestLogCallback = iSendRequestLogCallback;
    }

    @Override // com.bytedance.sdk.djx.net.req.NetBuilder
    public void go(final NetCallback netCallback) {
        Request requestBuildRequest = buildRequest();
        if (netCallback != null) {
            this.mDelivery.post(new Runnable() { // from class: com.bytedance.sdk.djx.net.req.k.OkGetBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    netCallback.onNetStart(OkGetBuilder.this);
                }
            });
        }
        this.mMap.put(requestBuildRequest.toString(), Long.valueOf(SystemClock.elapsedRealtime()));
        this.okHttpClient.newCall(requestBuildRequest).enqueue(new Callback() { // from class: com.bytedance.sdk.djx.net.req.k.OkGetBuilder.2
            @Override // com.bytedance.sdk.djx.net.k3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (OkGetBuilder.this.mSendRequestLogCallback != null) {
                    ISendRequestLogCallback iSendRequestLogCallback = OkGetBuilder.this.mSendRequestLogCallback;
                    String strEncodedPath = call.request().url().encodedPath();
                    Long l = (Long) OkGetBuilder.this.mMap.remove(call.request().toString());
                    iSendRequestLogCallback.sendRequestLog(strEncodedPath, l == null ? -1L : l.longValue(), false, "GET");
                }
                if (!(iOException instanceof SocketException) && OkGetBuilder.this.mRetryCurrent < OkGetBuilder.this.mMaxRetryCount && OkGetBuilder.this.mMaxRetryCount > 0) {
                    OkGetBuilder.access$508(OkGetBuilder.this);
                    OkGetBuilder.this.okHttpClient.newCall(call.request()).enqueue(this);
                } else {
                    String str = iOException != null ? "unknown:" + iOException : "unknown";
                    OkGetBuilder okGetBuilder = OkGetBuilder.this;
                    okGetBuilder.sendFailResultCallback(netCallback, okGetBuilder.mDelivery, -1, str, iOException);
                }
            }

            @Override // com.bytedance.sdk.djx.net.k3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Map<String, String> headers;
                if (OkGetBuilder.this.mSendRequestLogCallback != null) {
                    ISendRequestLogCallback iSendRequestLogCallback = OkGetBuilder.this.mSendRequestLogCallback;
                    String strEncodedPath = call.request().url().encodedPath();
                    Long l = (Long) OkGetBuilder.this.mMap.remove(call.request().toString());
                    iSendRequestLogCallback.sendRequestLog(strEncodedPath, l == null ? -1L : l.longValue(), true, "GET");
                }
                try {
                    headers = OkConvertUtils.parseHeaders(response);
                    OkGetBuilder.this.mResponseHeaders.putAll(headers);
                } finally {
                    try {
                        try {
                            response.body().close();
                        } catch (Throwable unused) {
                            return;
                        }
                    } finally {
                        try {
                            response.body().close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
                if (call.isCanceled()) {
                    OkGetBuilder okGetBuilder = OkGetBuilder.this;
                    okGetBuilder.sendFailResultCallback(netCallback, okGetBuilder.mDelivery, -1, "cancel", new IOException("Canceled!"));
                } else {
                    if (!response.isSuccessful()) {
                        OkGetBuilder okGetBuilder2 = OkGetBuilder.this;
                        okGetBuilder2.sendFailResultCallback(netCallback, okGetBuilder2.mDelivery, response.code(), response.message(), null);
                        try {
                            response.body().close();
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                    int iCode = response.code();
                    String strMessage = response.message();
                    NetCallback netCallback2 = netCallback;
                    if (netCallback2 != null) {
                        Class<?> type = netCallback2.getType();
                        final NetResponse netResponseHeaders = NetResponse.success(OkGetBuilder.this, type == JSONObject.class ? OkConvertUtils.convert2JsonObject(response.body()) : type == JSONArray.class ? OkConvertUtils.convert2JsonArray(response.body()) : OkConvertUtils.convert2String(response.body())).code(iCode).message(strMessage).headers(headers);
                        OkGetBuilder.this.mDelivery.post(new Runnable() { // from class: com.bytedance.sdk.djx.net.req.k.OkGetBuilder.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (netCallback != null) {
                                    netCallback.onNetSuccess(OkGetBuilder.this, netResponseHeaders);
                                }
                            }
                        });
                    }
                    response.body().close();
                }
            }
        });
    }

    private Request buildRequest() {
        Headers headersAppendHeaders;
        Request.Builder builder = new Request.Builder();
        builder.url(appendParams(this.mUrl, this.mParams));
        if (this.mTag != null) {
            builder.tag(this.mTag);
        }
        if (this.mHeaders != null && !this.mHeaders.isEmpty() && (headersAppendHeaders = appendHeaders(this.mHeaders)) != null) {
            builder.headers(headersAppendHeaders);
        }
        return builder.build();
    }

    private Headers appendHeaders(Map<String, String> map) {
        Headers.Builder builder = new Headers.Builder();
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (String str : map.keySet()) {
            builder.add(str, map.get(str));
        }
        return builder.build();
    }

    private String appendParams(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(a.n);
        } else {
            sb.append("?");
        }
        for (String str2 : map.keySet()) {
            sb.append(str2).append("=").append(map.get(str2)).append(a.n);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
