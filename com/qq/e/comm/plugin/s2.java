package com.qq.e.comm.plugin;

import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s2 {
    public static final String q = null;
    public final int a;
    public final String b;
    public final JSONArray c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final JSONArray j;
    public final int k;
    public final int l;
    public final int m;
    private final String n;
    private JSONArray o;
    private final JSONObject p;

    /* compiled from: A */
    public static class b {
        public int a;
        public String b;
        public JSONArray c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h = 1;
        public int i;
        public JSONArray j;
        public JSONObject k;

        public s2 a() {
            return new s2(this);
        }
    }

    private s2(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        JSONArray jSONArray = bVar.c;
        this.c = jSONArray;
        if (jSONArray != null) {
            this.n = jSONArray.toString();
        } else {
            this.n = null;
        }
        int i = bVar.d;
        this.d = i;
        int i2 = bVar.e;
        this.e = i2;
        int i3 = bVar.f;
        this.f = i3;
        int i4 = bVar.g;
        this.g = i4;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.p = bVar.k;
        this.k = i4 < 0 ? -1 : i + i2 + (i4 * (i3 + i2));
        this.l = i + i2;
        this.m = i3 + i2;
    }

    public final boolean d() {
        return this.h == 2;
    }

    public final boolean c() {
        return this.h == 1;
    }

    public String b() {
        return this.n;
    }

    public JSONArray a() {
        JSONArray jSONArray = this.o;
        return jSONArray != null ? jSONArray : this.c;
    }

    public void a(JSONArray jSONArray) {
        this.o = jSONArray;
    }
}
