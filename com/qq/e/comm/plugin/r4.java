package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class r4 {
    private final int a;
    private final JSONObject b;
    private f5 c;
    private ja d;
    private long e;

    protected abstract String d();

    protected r4(int i) {
        this.b = new JSONObject();
        this.a = i;
        a(d(), Integer.valueOf(i));
    }

    public int c() {
        return this.a;
    }

    public ja b() {
        return this.d;
    }

    protected r4(String str) {
        JSONObject jSONObjectA = jn.a(str).a();
        this.b = jSONObjectA;
        this.a = jSONObjectA.optInt(d());
    }

    public f5 a() {
        return this.c;
    }

    public JSONObject e() {
        return this.b;
    }

    public String toString() {
        return this.b.toString();
    }

    protected void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            this.b.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(f5 f5Var) {
        if (f5Var != null) {
            this.c = f5Var;
            a(com.alipay.sdk.m.k.b.l, f5Var.j());
        }
    }

    public void a(ja jaVar) {
        if (jaVar != null) {
            this.d = jaVar;
            a("ext", jaVar.a());
        }
    }

    public void a(String str) {
        a("ep", str);
    }

    void a(int i) {
        a(com.baidu.mobads.container.adrequest.g.ag, Integer.valueOf(i));
    }

    void a(long j) {
        this.e = j;
        a(com.baidu.mobads.container.components.command.j.s, Long.valueOf(j));
    }
}
