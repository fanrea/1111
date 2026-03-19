package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.log.EventBus;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class p3 implements EventBus.DataFetcher {
    public final /* synthetic */ HttpURLConnection a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ byte e;
    public final /* synthetic */ long f;
    public final /* synthetic */ o3 g;

    public p3(o3 o3Var, HttpURLConnection httpURLConnection, String str, String str2, JSONObject jSONObject, byte b, long j) {
        this.g = o3Var;
        this.a = httpURLConnection;
        this.b = str;
        this.c = str2;
        this.d = jSONObject;
        this.e = b;
        this.f = j;
    }

    @Override // com.bytedance.applog.log.EventBus.DataFetcher
    public Object fetch() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            Map<String, List<String>> requestProperties = this.a.getRequestProperties();
            if (!requestProperties.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                    jSONObject2.put(entry.getKey(), TextUtils.join(",", entry.getValue()));
                }
            }
            jSONObject.put("appId", this.g.b.m);
            jSONObject.put("nid", this.b);
            jSONObject.put("url", this.c);
            jSONObject.put("data", this.d);
            jSONObject.put("header", jSONObject2);
            jSONObject.put(com.alipay.sdk.m.p.e.s, (int) this.e);
            jSONObject.put("time", this.f);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
