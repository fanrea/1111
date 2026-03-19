package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.v8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yq {
    int a;
    String b;
    String c;
    int d;
    v9 e;
    private volatile String f;
    private JSONObject g;
    private String h;
    public int i;
    public volatile int j;
    public boolean k;

    public yq(String str, int i) {
        this.j = -1;
        this.k = false;
        this.b = str;
        this.a = i;
        this.i = 4;
    }

    public final int n() {
        return this.i;
    }

    public final int v() {
        return this.a;
    }

    public final String m() {
        return this.b;
    }

    public final String u() {
        if (this.f == null && !TextUtils.isEmpty(this.c)) {
            synchronized (this) {
                if (this.f == null && !TextUtils.isEmpty(this.c)) {
                    v8.a aVarB = v8.b();
                    try {
                        this.f = lx.b(this.c);
                        if (TextUtils.isEmpty(this.f)) {
                            this.j = 7;
                            a();
                        } else {
                            this.f = new JSONObject(this.f).optString("origin_data");
                        }
                    } catch (Exception e) {
                        this.j = e instanceof JSONException ? 9 : 8;
                        a();
                    }
                    f5 f5Var = new f5();
                    f5Var.d(m());
                    v8.b(2230100, aVarB, f5Var);
                }
            }
        }
        return this.f;
    }

    private void a() {
        this.f = null;
        this.c = null;
    }

    public boolean I() {
        return TextUtils.isEmpty(this.f) && TextUtils.isEmpty(this.c);
    }

    public String c() {
        return this.c;
    }

    public boolean B() {
        return this.d == 2;
    }

    public int p() {
        return this.d;
    }

    public String q() throws JSONException {
        if (TextUtils.isEmpty(this.h)) {
            if (this.g == null) {
                jn jnVar = new jn();
                jnVar.a("id", this.b);
                if (!TextUtils.isEmpty(this.c)) {
                    jnVar.a("data", this.c);
                }
                this.g = jnVar.a();
            }
            this.h = this.g.toString();
        }
        return this.h;
    }

    public boolean C() {
        return this.e.a;
    }

    public boolean y() {
        return TextUtils.isEmpty(this.e.c) || this.e.d <= 0;
    }

    public yq(JSONObject jSONObject) {
        this.j = -1;
        this.k = false;
        this.g = jSONObject;
        zq.a(this, jSONObject);
        this.i = TextUtils.isEmpty(this.c) ? 4 : 1;
    }

    public String l() {
        return this.e.c;
    }

    public int k() {
        return this.e.d;
    }

    public boolean w() {
        return this.e.b;
    }

    public int e() {
        return this.e.e.a;
    }

    public int g() {
        return this.e.e.b;
    }

    public int o() {
        return this.e.e.d;
    }

    public int f() {
        return this.e.e.e;
    }

    public boolean x() {
        return this.e.e.f;
    }

    public boolean F() {
        return this.e.e.i;
    }

    public boolean z() {
        return this.e.e.j;
    }

    public int h() {
        return this.e.e.k;
    }

    public int r() {
        return this.e.e.m;
    }

    public JSONArray b() {
        return this.e.e.n;
    }

    public float d() {
        return (float) this.e.e.g;
    }

    int i() {
        return this.e.e.h;
    }

    public String t() {
        return this.e.e.o;
    }

    public yq(JSONObject jSONObject, int i) {
        this(jSONObject);
        this.i = i;
    }

    public boolean A() {
        return this.e.e.u;
    }

    public boolean D() {
        return this.e.e.l;
    }

    public String j() {
        return this.e.e.p;
    }

    public boolean E() {
        return this.e.e.q;
    }

    public int s() {
        return this.e.e.r;
    }

    public boolean G() {
        return this.e.e.s;
    }

    public boolean H() {
        return this.e.e.t;
    }

    public void a(boolean z) {
        this.e.e.q = z;
    }

    public void a(int i) {
        this.e.e.r = i;
    }
}
