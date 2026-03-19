package com.bytedance.sdk.djx.net.req.k;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.sdk.commonsdk.api.utils.CommonSdkUtils;
import com.bytedance.sdk.commonsdk.api.utils.JSON;
import com.bytedance.sdk.djx.net.ISendRequestLogCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.k3.Call;
import com.bytedance.sdk.djx.net.k3.Callback;
import com.bytedance.sdk.djx.net.k3.FormBody;
import com.bytedance.sdk.djx.net.k3.Headers;
import com.bytedance.sdk.djx.net.k3.MediaType;
import com.bytedance.sdk.djx.net.k3.OkHttpClient;
import com.bytedance.sdk.djx.net.k3.Request;
import com.bytedance.sdk.djx.net.k3.RequestBody;
import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import java.io.IOException;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OkPostBuilder extends NetBuilder<OkPostBuilder> {
    private final Handler mDelivery;
    private final ISendRequestLogCallback mSendRequestLogCallback;
    private MediaType mediaType;
    private final OkHttpClient okHttpClient;
    private final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    private final ArrayMap<String, Long> mMap = new ArrayMap<>();
    private final Context context = CommonSdkUtils.getContext();

    static /* synthetic */ int access$508(OkPostBuilder okPostBuilder) {
        int i = okPostBuilder.mRetryCurrent;
        okPostBuilder.mRetryCurrent = i + 1;
        return i;
    }

    public OkPostBuilder(OkHttpClient okHttpClient, Handler handler, ISendRequestLogCallback iSendRequestLogCallback) {
        this.okHttpClient = okHttpClient;
        this.mDelivery = handler;
        this.mSendRequestLogCallback = iSendRequestLogCallback;
    }

    @Override // com.bytedance.sdk.djx.net.req.NetBuilder
    public void go(final NetCallback netCallback) {
        Request requestBuildRequest = buildRequest();
        if (netCallback != null) {
            this.mDelivery.post(new Runnable() { // from class: com.bytedance.sdk.djx.net.req.k.OkPostBuilder.1
                @Override // java.lang.Runnable
                public void run() {
                    netCallback.onNetStart(OkPostBuilder.this);
                }
            });
        }
        this.mMap.put(requestBuildRequest.toString(), Long.valueOf(SystemClock.elapsedRealtime()));
        this.okHttpClient.newCall(requestBuildRequest).enqueue(new Callback() { // from class: com.bytedance.sdk.djx.net.req.k.OkPostBuilder.2
            @Override // com.bytedance.sdk.djx.net.k3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (OkPostBuilder.this.mSendRequestLogCallback != null) {
                    ISendRequestLogCallback iSendRequestLogCallback = OkPostBuilder.this.mSendRequestLogCallback;
                    String strEncodedPath = call.request().url().encodedPath();
                    Long l = (Long) OkPostBuilder.this.mMap.remove(call.request().toString());
                    iSendRequestLogCallback.sendRequestLog(strEncodedPath, l == null ? -1L : l.longValue(), false, "POST");
                }
                if (!(iOException instanceof SocketException) && OkPostBuilder.this.mRetryCurrent < OkPostBuilder.this.mMaxRetryCount && OkPostBuilder.this.mMaxRetryCount > 0) {
                    OkPostBuilder.access$508(OkPostBuilder.this);
                    OkPostBuilder.this.okHttpClient.newCall(call.request()).enqueue(this);
                } else {
                    String str = iOException != null ? "unknown:" + iOException : "unknown";
                    OkPostBuilder okPostBuilder = OkPostBuilder.this;
                    okPostBuilder.sendFailResultCallback(netCallback, okPostBuilder.mDelivery, -1, str, iOException);
                }
            }

            @Override // com.bytedance.sdk.djx.net.k3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Map<String, String> headers;
                if (OkPostBuilder.this.mSendRequestLogCallback != null) {
                    ISendRequestLogCallback iSendRequestLogCallback = OkPostBuilder.this.mSendRequestLogCallback;
                    String strEncodedPath = call.request().url().encodedPath();
                    Long l = (Long) OkPostBuilder.this.mMap.remove(call.request().toString());
                    iSendRequestLogCallback.sendRequestLog(strEncodedPath, l == null ? -1L : l.longValue(), true, "POST");
                }
                try {
                    headers = OkConvertUtils.parseHeaders(response);
                    OkPostBuilder.this.mResponseHeaders.putAll(headers);
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
                    OkPostBuilder okPostBuilder = OkPostBuilder.this;
                    okPostBuilder.sendFailResultCallback(netCallback, okPostBuilder.mDelivery, -1, "cancel", new IOException("Canceled!"));
                } else {
                    if (!response.isSuccessful()) {
                        OkPostBuilder okPostBuilder2 = OkPostBuilder.this;
                        okPostBuilder2.sendFailResultCallback(netCallback, okPostBuilder2.mDelivery, response.code(), response.message(), null);
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
                        final NetResponse netResponseHeaders = NetResponse.success(OkPostBuilder.this, type == JSONObject.class ? OkConvertUtils.convert2JsonObject(response.body()) : type == JSONArray.class ? OkConvertUtils.convert2JsonArray(response.body()) : OkConvertUtils.convert2String(response.body())).code(iCode).message(strMessage).headers(headers);
                        OkPostBuilder.this.mDelivery.post(new Runnable() { // from class: com.bytedance.sdk.djx.net.req.k.OkPostBuilder.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (netCallback != null) {
                                    netCallback.onNetSuccess(OkPostBuilder.this, netResponseHeaders);
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
        RequestBody requestBodyAppendParams;
        Headers headersAppendHeaders;
        Request.Builder builder = new Request.Builder();
        builder.url(this.mUrl);
        if (this.mTag != null) {
            builder.tag(this.mTag);
        }
        if (this.mHeaders != null && !this.mHeaders.isEmpty() && (headersAppendHeaders = appendHeaders(this.mHeaders)) != null) {
            builder.headers(headersAppendHeaders);
        }
        if (this.mJsonParams != null) {
            requestBodyAppendParams = appendJsonParams(this.mJsonParams);
        } else {
            requestBodyAppendParams = appendParams(this.mParams);
        }
        if (requestBodyAppendParams != null) {
            builder.post(requestBodyAppendParams);
        }
        return builder.build();
    }

    private RequestBody appendParams(Map<String, String> map) {
        try {
            if (this.mHeaders != null && this.mHeaders.containsKey("Content-Type") && "application/json".equals(this.mHeaders.get("Content-Type"))) {
                return RequestBody.create(this.MEDIA_TYPE_JSON, JSON.build(map).toString());
            }
            FormBody.Builder builder = new FormBody.Builder();
            for (String str : map.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = map.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    builder.add(str, str2);
                }
            }
            return builder.build();
        } catch (Throwable unused) {
            return null;
        }
    }

    private RequestBody appendJsonParams(JSONObject jSONObject) {
        try {
            if (this.mHeaders != null && this.mHeaders.containsKey("Content-Type") && "application/json".equals(this.mHeaders.get("Content-Type"))) {
                return RequestBody.create(this.MEDIA_TYPE_JSON, jSONObject.toString());
            }
            FormBody.Builder builder = new FormBody.Builder();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    String str = (String) jSONObject.opt(next);
                    if (str == null) {
                        str = "";
                    }
                    builder.add(next, str);
                }
            }
            return builder.build();
        } catch (Throwable unused) {
            return null;
        }
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
}
