package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rx extends c30 {

    /* compiled from: A */
    private static final class a {
        static final rx a = new rx();
    }

    public static final rx b() {
        return a.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "sdkServerReport";
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        JSONObject jSONObjectD = ugVar.d();
        int iOptInt = jSONObjectD.optInt("code", 0);
        JSONObject jSONObjectOptJSONObject = jSONObjectD.optJSONObject("paras");
        if (jSONObjectOptJSONObject != null) {
            b10.a(90002, null, Integer.valueOf(iOptInt), new ja(jSONObjectOptJSONObject));
        }
    }
}
