package com.qq.e.comm.plugin;

import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sx {
    private static final String a = "plc";
    private static final String b = "biz";
    public static final String c = "https://sdk.e.qq.com";
    public static final String d = "https://sdk.e.qq.com/msg";

    public static JSONObject a(j jVar) throws JSONException {
        return (JSONObject) pro.getobjresult(570, 1, jVar);
    }

    public static void a(int i, JSONObject jSONObject, j jVar, qr qrVar) {
        pro.getVresult(571, 1, Integer.valueOf(i), jSONObject, jVar, qrVar);
    }
}
