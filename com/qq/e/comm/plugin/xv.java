package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xv {
    private String a;
    private long b;

    private xv() {
    }

    public String a() {
        return this.a;
    }

    public static xv a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xv xvVar = new xv();
        xvVar.a(jSONObject.optString("url"));
        xvVar.a(jSONObject.optLong("reporttime"));
        return xvVar;
    }

    public static List<xv> a(JSONArray jSONArray) {
        xv xvVarA;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                Object objOpt = jSONArray.opt(i);
                if ((objOpt instanceof JSONObject) && (xvVarA = a((JSONObject) objOpt)) != null) {
                    arrayList.add(xvVarA);
                }
            }
        }
        return arrayList;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str) {
        this.a = str;
    }
}
