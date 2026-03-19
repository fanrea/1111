package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient;
import com.bytedance.sdk.component.hc.d.b;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.e;
import com.bytedance.sdk.component.hc.d.hc;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import com.bytedance.sdk.component.hc.d.tc;
import com.bytedance.sdk.component.hc.d.w;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final tc JSON = tc.d("application/json");
    private static mq mClient;
    private hc mCall;

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new mq().hc().d(10L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).hc(10L, TimeUnit.SECONDS).d();
            }
        }
        k.d dVarD = new k.d().d(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                dVarD.d(str2, map.get(str2));
            }
        }
        hc hcVarD = mClient.d(dVarD.hc());
        this.mCall = hcVarD;
        hcVarD.d(new b() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.1
            @Override // com.bytedance.sdk.component.hc.d.b
            public void onFailure(hc hcVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.hc.d.b
            public void onResponse(hc hcVar, cb cbVar) throws Throwable {
                w wVarAn;
                Throwable th;
                JSONObject jSONObject;
                try {
                    wVarAn = cbVar.an();
                } catch (Throwable th2) {
                    wVarAn = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject = new JSONObject(wVarAn.hc());
                        e = null;
                    } catch (Exception e) {
                        e = e;
                        com.bytedance.sdk.component.utils.mq.d(e);
                        jSONObject = null;
                    }
                    if (e == null && !cbVar.c()) {
                        e = new Exception("http fail");
                        cbVar.b();
                    }
                    if (wVarAn != null) {
                        try {
                            wVarAn.close();
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
                    if (wVarAn != null) {
                        try {
                            wVarAn.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void startTask(String str, Map<String, String> map, JSONObject jSONObject, int i, final AVMDLNetClient.CompletionListener completionListener) {
        synchronized (AVMDLHTTPNetwork.class) {
            if (mClient == null) {
                mClient = new mq().hc().d(10L, TimeUnit.SECONDS).b(10L, TimeUnit.SECONDS).hc(10L, TimeUnit.SECONDS).d();
            }
        }
        k.d dVarD = new k.d().d(str);
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                dVarD.hc(str2, map.get(str2));
            }
        }
        if (i == 1) {
            dVarD.d(e.d(JSON, String.valueOf(jSONObject)));
        }
        hc hcVarD = mClient.d(dVarD.hc());
        this.mCall = hcVarD;
        hcVarD.d(new b() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLHTTPNetwork.2
            @Override // com.bytedance.sdk.component.hc.d.b
            public void onFailure(hc hcVar, IOException iOException) {
                completionListener.onCompletion(null, new Error(0, null, null, iOException.toString()));
            }

            @Override // com.bytedance.sdk.component.hc.d.b
            public void onResponse(hc hcVar, cb cbVar) throws Throwable {
                w wVarAn;
                Throwable th;
                String string;
                JSONObject jSONObject2;
                try {
                    wVarAn = cbVar.an();
                } catch (Throwable th2) {
                    wVarAn = null;
                    th = th2;
                }
                try {
                    try {
                        jSONObject2 = new JSONObject(wVarAn.hc());
                        string = null;
                    } catch (Exception e) {
                        string = e.toString();
                        com.bytedance.sdk.component.utils.mq.d(e);
                        jSONObject2 = null;
                    }
                    if (!cbVar.c()) {
                        string = cbVar.u();
                        cbVar.b();
                    }
                    if (wVarAn != null) {
                        try {
                            wVarAn.close();
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
                    if (wVarAn != null) {
                        try {
                            wVarAn.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
        });
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLNetClient
    public void cancel() {
        hc hcVar = this.mCall;
        if (hcVar == null || hcVar.b()) {
            return;
        }
        this.mCall.hc();
    }
}
