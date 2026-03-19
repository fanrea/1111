package com.qq.e.comm.plugin;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class w00 {
    private static final AtomicInteger a = new AtomicInteger(1);

    static v00 a(wt wtVar) {
        return (v00) pro.getobjresult(675, 1, wtVar);
    }

    static JSONObject a(List<v00> list) throws JSONException {
        if (list == null || list.size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(new jn(list.get(i).c()).a());
        }
        jn jnVarB = q00.b();
        jnVarB.a("perfs", jSONArray);
        return jnVarB.a();
    }

    static v00 a(int i, String str) {
        return new v00(i, str);
    }
}
