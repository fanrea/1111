package com.apm.insight.b;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g {
    private static volatile g a;
    private static h c;
    private final b b;

    private g(Context context) {
        this.b = new b(context);
        if (com.apm.insight.g.q()) {
            h hVar = new h(0);
            c = hVar;
            hVar.b();
        }
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    public static JSONObject a(long j) {
        h hVar = c;
        if (hVar == null) {
            return null;
        }
        return hVar.a(j).a();
    }

    public static JSONArray c() {
        h hVar = c;
        if (hVar == null) {
            return null;
        }
        return hVar.c();
    }

    public static void d() {
        if (a == null || a.b == null) {
            return;
        }
        a.b.c();
    }

    public static void e() {
        if (a == null || a.b == null) {
            return;
        }
        a.b.f();
    }

    public static void f() {
        if (a == null || a.b == null) {
            return;
        }
        a.b.e();
    }

    public void a() {
        this.b.a();
    }

    public void b() {
        this.b.b();
    }
}
