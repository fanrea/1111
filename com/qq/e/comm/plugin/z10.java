package com.qq.e.comm.plugin;

import android.util.Pair;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class z10 {
    public final String a;
    public final z10[] b;
    public final Map<String, f10> c;
    public final Map<String, f10> d;
    public final Map<String, ob> e;
    public final rc[] f;
    public final e10[] g;
    public final s2[] h;
    public final a7 i;
    public final boolean j;
    public final boolean k;
    public String l;
    private final int m;
    private final int n;
    public String o;

    /* compiled from: A */
    public static class b {
        public String a;
        public z10[] b;
        public rc[] e;
        public e10[] f;
        public s2[] g;
        public int i;
        public String j;
        public a7 k;
        public Map<String, f10> c = new HashMap(10);
        public Map<String, ob> d = new HashMap();
        public int h = 0;

        public z10 a() {
            return new z10(this);
        }
    }

    private z10(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c.size() > 0 ? bVar.c : null;
        this.e = bVar.d.size() > 0 ? bVar.d : null;
        this.f = bVar.e;
        this.g = bVar.f;
        this.h = bVar.g;
        Pair<Boolean, Map<String, f10>> pairE = e();
        this.j = ((Boolean) pairE.first).booleanValue() || a();
        this.d = (Map) pairE.second;
        this.k = d();
        this.m = bVar.h;
        this.n = bVar.i;
        this.o = bVar.j;
        this.i = bVar.k;
    }

    private boolean a() {
        if (this.e == null) {
            return false;
        }
        for (String str : u3.b) {
            if (this.e.get(str) != null) {
                return true;
            }
        }
        for (String str2 : u3.a) {
            if (this.e.get(str2) != null) {
                return true;
            }
        }
        return false;
    }

    private Pair<Boolean, Map<String, f10>> e() {
        boolean z;
        Map<String, f10> mapA;
        Map<String, f10> map = null;
        if (this.c == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        for (String str : u3.b) {
            f10 f10Var = this.c.get(str);
            if (f10Var != null && (f10Var.c(new JSONObject[0]).c() || f10Var.c(new JSONObject[0]).d())) {
                z = true;
                break;
            }
        }
        z = false;
        for (String str2 : u3.a) {
            f10 f10Var2 = this.c.get(str2);
            if (f10Var2 != null) {
                Object objE = f10Var2.e(new JSONObject[0]);
                if (objE instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objE;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        iz izVarC = t30.c((Object) jSONArray.optString(i)).c(new JSONObject[0]);
                        if (izVarC != null && (izVarC.c() || izVarC.d())) {
                            mapA = a(map, str2, f10Var2);
                            map = mapA;
                            z = true;
                            break;
                        }
                    }
                } else if (f10Var2.c(new JSONObject[0]).c() || f10Var2.c(new JSONObject[0]).d()) {
                    mapA = a(map, str2, f10Var2);
                    map = mapA;
                    z = true;
                    break;
                    break;
                }
            }
        }
        return new Pair<>(Boolean.valueOf(z), map);
    }

    private boolean d() {
        z10[] z10VarArr = this.b;
        if (z10VarArr == null) {
            return false;
        }
        for (z10 z10Var : z10VarArr) {
            if (z10Var != null && z10Var.j) {
                return true;
            }
        }
        return false;
    }

    public int b() {
        return this.m;
    }

    public int c() {
        return this.n;
    }

    private Map<String, f10> a(Map<String, f10> map, String str, f10 f10Var) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str, f10Var);
        this.c.remove(str);
        return map;
    }
}
