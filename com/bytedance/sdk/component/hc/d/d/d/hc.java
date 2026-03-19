package com.bytedance.sdk.component.hc.d.d.d;

import com.bytedance.sdk.component.b.hc.np;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements d {
    @Override // com.bytedance.sdk.component.hc.d.d.d.d
    public void d(com.bytedance.sdk.component.b.hc.u uVar, InetSocketAddress inetSocketAddress, Proxy proxy, np npVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.c.b) AutoService.d(com.bytedance.sdk.component.c.b.class)).d("okhttp_connectFailed", d(uVar), iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.d.d.d
    public void d(com.bytedance.sdk.component.b.hc.u uVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.c.b) AutoService.d(com.bytedance.sdk.component.c.b.class)).d("okhttp_callFailed", d(uVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject d(com.bytedance.sdk.component.b.hc.u uVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", hc(uVar));
        return jSONObject;
    }

    private String hc(com.bytedance.sdk.component.b.hc.u uVar) throws NullPointerException {
        return uVar.d().d().toString();
    }
}
