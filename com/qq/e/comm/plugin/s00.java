package com.qq.e.comm.plugin;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s00 {
    private static final AtomicInteger a = new AtomicInteger(1);

    static r00 a(qc qcVar) {
        return (r00) pro.getobjresult(629, 1, qcVar);
    }

    static JSONObject a(List<r00> list) throws JSONException {
        if (list == null || list.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(new jn(list.get(i).c()).a());
        }
        jn jnVarB = q00.b();
        jnVarB.a("events", jSONArray);
        return jnVarB.a();
    }

    static r00 a(int i, String str) {
        return new r00(i, str);
    }
}
