package com.apm.insight.runtime;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e {
    private static HashMap<String, e> a = new HashMap<>();
    private JSONObject b = null;
    private JSONObject c = null;
    private boolean d = false;
    private String e;

    public e(JSONObject jSONObject, String str) {
        this.e = str;
        a(jSONObject);
        a.put(this.e, this);
        com.apm.insight.o.q.a((Object) ("after update aid " + str));
    }

    public static void a(String str, JSONObject jSONObject) {
        e eVar = a.get(str);
        if (eVar != null) {
            eVar.a(jSONObject);
        } else {
            new e(jSONObject, str);
        }
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.b = jSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.d = jSONObjectOptJSONObject.optInt("switcher") == 1 && jSONObjectOptJSONObject.optInt("err_sampling_rate") == 1;
    }

    public static boolean b(String str) {
        return a.get(str) != null;
    }

    public static JSONObject c(String str) {
        e eVar = a.get(str);
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public static e d(String str) {
        return a.get(str);
    }

    public static long e(String str) {
        e eVar = a.get(str);
        if (eVar == null) {
            return 3600000L;
        }
        try {
            return Long.decode(com.apm.insight.o.m.b(eVar.a(), "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    public static boolean f(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.b() && eVar.h();
    }

    public static boolean g(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.c() && eVar.h();
    }

    public static boolean h(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.d() && eVar.h();
    }

    public static boolean i(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.e() && eVar.b() && eVar.h();
    }

    public static boolean j(String str) {
        e eVar = a.get(str);
        return eVar == null || eVar.h();
    }

    public static int k(String str) {
        e eVar = a.get(str);
        if (eVar == null) {
            return 300;
        }
        return eVar.k();
    }

    public static boolean l(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.f() && eVar.h();
    }

    public static boolean m(String str) {
        e eVar = a.get(str);
        return eVar != null && eVar.g() && eVar.h();
    }

    public static int n(String str) {
        try {
            return a.get(str).o();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public static int o(String str) {
        try {
            return a.get(str).p();
        } catch (Throwable unused) {
            return 2;
        }
    }

    public static boolean q() {
        try {
            e eVar = a.get(com.apm.insight.entity.b.b(com.apm.insight.f.a()));
            if (eVar != null && eVar.i() && eVar.b()) {
                return eVar.h();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean r() {
        try {
            e eVar = a.get(com.apm.insight.entity.b.b(com.apm.insight.f.a()));
            if (eVar == null || !eVar.j()) {
                return false;
            }
            return eVar.h();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONArray s() {
        try {
            return a.get(com.apm.insight.entity.b.b(com.apm.insight.f.a())).l();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int t() {
        try {
            return a.get(com.apm.insight.entity.b.b(com.apm.insight.f.a())).m();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean u() {
        try {
            return a.get(com.apm.insight.entity.b.b(com.apm.insight.f.a())).n();
        } catch (Throwable unused) {
            return false;
        }
    }

    public JSONObject a() {
        return this.b;
    }

    public boolean a(String str) {
        if (this.b == null) {
            return false;
        }
        return this.d;
    }

    public boolean b() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean c() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean d() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "crash_module", "switcher");
    }

    public boolean e() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "crash_module", "upload_alog");
    }

    public boolean f() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "crash_module", "apmplus_alog_rate");
    }

    public boolean g() {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                return false;
            }
            if (jSONObject.has("crash_optimizer_module")) {
                return 1 == com.apm.insight.o.m.a(this.b, 0, "crash_optimizer_module", "switcher");
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean h() {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject != null) {
                return jSONObject.optInt("status") == 0;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public boolean i() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "crash_module", "custom_file_sampling_rate");
    }

    public boolean j() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "exit_module", "switcher") && 1 == com.apm.insight.o.m.a(this.b, 0, "exit_module", "exit_sampling_rate");
    }

    public int k() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return 300;
        }
        return com.apm.insight.o.m.a(jSONObject, 300, "crash_module", "alog_crash_before_time");
    }

    public JSONArray l() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return null;
        }
        return com.apm.insight.o.m.a(jSONObject, "protector_module", "metas");
    }

    public int m() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return 0;
        }
        return com.apm.insight.o.m.a(jSONObject, 5, "protector_module", "max_portrait_count_per_proc");
    }

    public boolean n() {
        JSONObject jSONObject = this.b;
        return jSONObject != null && 1 == com.apm.insight.o.m.a(jSONObject, 0, "protector_module", "switcher");
    }

    public int o() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return 100;
        }
        return com.apm.insight.o.m.a(jSONObject, 100, "error_module", "all_limit");
    }

    public int p() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return 5;
        }
        return com.apm.insight.o.m.a(jSONObject, 5, "error_module", "stack_limit");
    }
}
