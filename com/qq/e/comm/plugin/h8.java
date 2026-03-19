package com.qq.e.comm.plugin;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h8 {
    public final int a;
    public final String b;
    public JSONObject c;
    public final String d;
    public final String e;
    public final JSONObject f;
    public final JSONObject g;
    public final boolean h;
    public final String i;
    public final String j;
    private final Map<String, ob> k;
    private final int l;
    private boolean m;
    private int n;
    private a7 o;
    private int p;
    private final String q;

    public h8(int i, String str) {
        this(i, str, new JSONObject());
    }

    public void a(im imVar, w40<?, ?> w40Var) {
        Map<String, ob> map = this.k;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ob> entry : this.k.entrySet()) {
            imVar.i().a(w40Var, entry.getValue(), this, entry.getKey());
        }
    }

    public int d() {
        return this.n;
    }

    public h8(int i, String str, JSONObject jSONObject) {
        this.m = false;
        this.n = 0;
        this.a = i;
        this.b = str;
        this.d = null;
        this.q = jSONObject.toString();
        this.c = jSONObject;
        this.k = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = null;
        this.l = 0;
        f();
    }

    void e() {
        this.p++;
    }

    public void b() {
        f();
        this.c = new jn(this.q).a();
    }

    private void f() {
        this.p = 0;
        this.m = false;
        this.n = 0;
    }

    public a7 c() {
        return this.o;
    }

    public h8(rc rcVar) {
        this.m = false;
        this.n = 0;
        this.a = rcVar.a;
        this.b = rcVar.b;
        this.d = rcVar.c;
        String str = rcVar.d;
        this.q = str;
        this.c = new jn(str).a();
        this.k = rcVar.e;
        this.e = rcVar.f;
        this.f = rcVar.g;
        this.g = rcVar.h;
        this.h = rcVar.i;
        this.i = rcVar.j;
        this.j = rcVar.k;
        this.l = rcVar.l;
        f();
    }

    boolean a() {
        int i = this.l;
        return i == 0 || i > this.p;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || this.k == null || jSONObject.length() <= 0 || this.k.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ob> entry : this.k.entrySet()) {
            Object objE = (this.m ? entry.getValue() : entry.getValue().a()).e(jSONObject);
            if (objE != null) {
                a(entry.getKey(), objE);
            }
        }
        this.m = true;
    }

    public void a(String str, Object obj) throws JSONException {
        try {
            this.c.putOpt(str, obj);
        } catch (JSONException e) {
            e.getMessage();
        }
    }

    public void a(a7 a7Var) {
        this.o = a7Var;
    }

    public void a(int i) {
        this.n = i;
    }
}
