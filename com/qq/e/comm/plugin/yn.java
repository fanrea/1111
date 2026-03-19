package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yn {
    private final String a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final List<tr> j;
    private final List<tr> k;
    private final List<tr> l;
    private final HashMap<String, String> m = new HashMap<>();

    public yn(JSONObject jSONObject) {
        this.a = jSONObject.optString("mediation_id");
        this.b = jSONObject.optInt("total_timeout");
        this.c = jSONObject.optInt("layer_timeout");
        this.d = jSONObject.optInt("bidding_timeout");
        this.e = jSONObject.optInt("s2s_load_ad_timeout");
        this.f = Math.max(jSONObject.optInt("parallel_count", 1), 1);
        this.i = jSONObject.optInt("is_parallel");
        this.g = jSONObject.optInt("exp_group_id");
        this.h = jSONObject.optInt("flow_group_id");
        this.j = a(jSONObject, false, "waterfall_config");
        this.k = a(jSONObject, true, "bidding_config");
        this.l = a(jSONObject, true, "s2s_bidding_config");
    }

    private void a(tr trVar) {
        if (qp.a(trVar)) {
            this.m.put(trVar.p(), trVar.n());
        }
    }

    public String e() {
        return this.a;
    }

    public int i() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int h() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public boolean l() {
        return this.i == 1;
    }

    public List<tr> j() {
        return this.j;
    }

    public List<tr> b() {
        return this.k;
    }

    public List<tr> g() {
        return this.l;
    }

    public HashMap<String, String> k() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("mediationId: " + this.a + ", timeout: " + this.b + ", configs: ");
        for (tr trVar : this.j) {
            sb.append("\n   ");
            sb.append(trVar);
        }
        return sb.toString();
    }

    public int a() {
        return this.d;
    }

    private List<tr> a(JSONObject jSONObject, boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                tr trVar = new tr(jSONArrayOptJSONArray.optJSONObject(i), this.a, z, this.g, this.h);
                arrayList.add(trVar);
                a(trVar);
            }
        }
        return arrayList;
    }
}
