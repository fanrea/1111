package com.apm.insight.runtime;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    private static ConcurrentLinkedQueue<Object> a = new ConcurrentLinkedQueue<>();

    public static int a(int i, String... strArr) {
        return com.apm.insight.o.m.a(a(), i, strArr);
    }

    public static int a(String... strArr) {
        return com.apm.insight.o.m.a(a(), -1, strArr);
    }

    public static String a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("exception_modules")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("npth");
    }

    public static JSONObject a() {
        return e.c(com.apm.insight.g.a().e());
    }

    public static JSONObject a(JSONArray jSONArray, String str) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i).optJSONObject(str);
                if (jSONObjectOptJSONObject != null) {
                    return jSONObjectOptJSONObject;
                }
            }
        }
        return null;
    }

    public static void a(JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        com.apm.insight.o.q.a("apmconfig", "fromnet " + z + " : " + jSONArray);
        if (z) {
            com.apm.insight.n.o.f();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String next = jSONObjectOptJSONObject.keys().next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                com.apm.insight.o.q.a((Object) ("update config " + next + " : " + jSONObjectOptJSONObject2));
                e.a(next, jSONObjectOptJSONObject2);
                if (z) {
                    com.apm.insight.n.o.a(next);
                }
            } catch (Throwable unused) {
            }
        }
        o.a(a(jSONArray, String.valueOf(com.apm.insight.g.a().e())));
        if (z) {
            com.apm.insight.n.o.a(false, jSONArray);
        }
    }

    public static boolean a(Object obj) {
        String strB = com.apm.insight.entity.b.b(obj);
        if (strB != null) {
            return e.b(strB);
        }
        return false;
    }

    public static boolean a(Object obj, String str) {
        e eVarD;
        String strB = com.apm.insight.entity.b.b(obj);
        return strB != null && (eVarD = e.d(strB)) != null && eVarD.a(str) && e.j(strB);
    }

    public static boolean a(String str) {
        if (!e.b(str)) {
            com.apm.insight.n.a.b();
        }
        return e.f(str);
    }

    public static int b(Object obj) {
        try {
            String strB = com.apm.insight.entity.b.b(obj);
            if (e.b(strB)) {
                return 100;
            }
            e.n(strB);
            return 100;
        } catch (Throwable unused) {
            return 100;
        }
    }

    public static boolean b() {
        return p.e();
    }

    public static boolean b(String str) {
        if (!e.b(str)) {
            com.apm.insight.n.a.b();
        }
        return e.h(str);
    }

    public static int c(Object obj) {
        try {
            String strB = com.apm.insight.entity.b.b(obj);
            if (e.b(strB)) {
                return 2;
            }
            e.o(strB);
            return 2;
        } catch (Throwable unused) {
            return 2;
        }
    }

    public static JSONArray c() {
        return com.apm.insight.o.m.a(a(), "custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore");
    }

    public static boolean c(String str) {
        if (!e.b(str)) {
            com.apm.insight.n.a.b();
        }
        return e.g(str);
    }

    public static boolean d() {
        return a("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    public static boolean d(String str) {
        if (e.b(str)) {
            return e.i(str);
        }
        return false;
    }

    public static int e(String str) {
        if (e.b(str)) {
            return e.k(str);
        }
        return 300;
    }

    public static boolean e() {
        return a("custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native") == 1;
    }

    public static boolean f() {
        return a("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") == 1;
    }

    public static boolean f(String str) {
        if (e.b(str)) {
            return e.l(str);
        }
        return false;
    }

    public static boolean g() {
        return a("custom_event_settings", "npth_simple_setting", "upload_crash_crash") == 1;
    }

    public static boolean g(String str) {
        if (e.b(str)) {
            return e.m(str);
        }
        return false;
    }

    public static long h(String str) {
        if (e.b(str)) {
            return 3600000L;
        }
        e.e(str);
        return 3600000L;
    }

    public static boolean h() {
        return a("custom_event_settings", "npth_simple_setting", "force_apm_crash") == 1;
    }

    public static boolean i() {
        return a("custom_event_settings", "npth_simple_setting", "enable_killed_anr") == 1;
    }

    public static boolean j() {
        return a("custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace") == 1;
    }

    public static boolean k() {
        return e.q();
    }

    public static boolean l() {
        return e.r();
    }

    public static JSONArray m() {
        return e.s();
    }

    public static int n() {
        return e.t();
    }

    public static boolean o() {
        return e.u();
    }
}
