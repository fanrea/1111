package com.ss.mediakit.net;

import com.ss.mediakit.net.AVMDLNetClient;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final MediaType JSON = MediaType.parse("application/json");
    private static OkHttpClient mClient;
    private Call mCall;

    @Override // com.ss.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new OkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build();
            }
        }
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                builderUrl.header(str2, map.get(str2));
            }
        }
        Call callNewCall = mClient.newCall(builderUrl.build());
        this.mCall = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.ss.mediakit.net.AVMDLHTTPNetwork.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws Throwable {
                ResponseBody responseBodyBody;
                Throwable th;
                JSONObject jSONObject;
                try {
                    responseBodyBody = response.body();
                } catch (Throwable th2) {
                    responseBodyBody = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject = new JSONObject(responseBodyBody.string());
                        e = null;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        jSONObject = null;
                    }
                    if (e == null && !response.isSuccessful()) {
                        e = new Exception("http fail");
                        response.code();
                    }
                    if (responseBodyBody != null) {
                        try {
                            responseBodyBody.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (e == null) {
                        completionListener.onCompletion(jSONObject, null);
                    } else {
                        completionListener.onCompletion(jSONObject, new Error(0, null, null, e.toString()));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (responseBodyBody != null) {
                        try {
                            responseBodyBody.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.ss.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new OkHttpClient().newBuilder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build();
            }
        }
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                builderUrl.addHeader(str2, map.get(str2));
            }
        }
        if (i == 1) {
            builderUrl.post(RequestBody.create(JSON, String.valueOf(jSONObject)));
        }
        Call callNewCall = mClient.newCall(builderUrl.build());
        this.mCall = callNewCall;
        callNewCall.enqueue(new Callback() { // from class: com.ss.mediakit.net.AVMDLHTTPNetwork.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws Throwable {
                ResponseBody responseBodyBody;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    responseBodyBody = response.body();
                } catch (Throwable th2) {
                    responseBodyBody = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject2 = new JSONObject(responseBodyBody.string());
                        string = null;
                    } catch (Exception e) {
                        string = e.toString();
                        e.printStackTrace();
                        jSONObject2 = null;
                    }
                    if (!response.isSuccessful()) {
                        string = response.message();
                        response.code();
                    }
                    if (responseBodyBody != null) {
                        try {
                            responseBodyBody.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (string == null) {
                        completionListener.onCompletion(jSONObject2, null);
                    } else {
                        completionListener.onCompletion(jSONObject2, new Error(0, null, null, string.toString()));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (responseBodyBody != null) {
                        try {
                            responseBodyBody.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.ss.mediakit.net.AVMDLNetClient
    public void cancel() {
        Call call = this.mCall;
        if (call == null || call.getCanceled()) {
            return;
        }
        this.mCall.cancel();
    }
}
