package com.apm.insight.n;

import android.text.TextUtils;
import com.apm.insight.runtime.v;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    private static Runnable a = new Runnable() { // from class: com.apm.insight.n.a.1
        @Override // java.lang.Runnable
        public void run() {
            v vVarB;
            Runnable runnable;
            long j;
            com.apm.insight.runtime.q.b().b(a.a);
            if (NetworkUtils.isNetworkAvailable(com.apm.insight.g.f())) {
                a.i();
            }
            if (a.b > 0) {
                if (com.apm.insight.o.a.b(com.apm.insight.g.f())) {
                    vVarB = com.apm.insight.runtime.q.b();
                    runnable = a.a;
                    j = 15000;
                } else {
                    vVarB = com.apm.insight.runtime.q.b();
                    runnable = a.a;
                    j = 60000;
                }
                vVarB.a(runnable, j);
            }
        }
    };
    private static int b = 0;

    public static void a() {
        b = 40;
        com.apm.insight.runtime.q.b().a(a);
    }

    public static void b() {
        if (!o.b()) {
            o.c();
        }
        if (NetworkUtils.isNetworkAvailable(com.apm.insight.g.f()) && o.a(false)) {
            i();
        }
    }

    public static boolean c() {
        return false;
    }

    public static void d() {
    }

    private static byte[] h() {
        try {
            JSONArray jSONArrayA = com.apm.insight.entity.b.a();
            try {
                if (com.apm.insight.g.w()) {
                    int length = jSONArrayA.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayA.optJSONObject(i);
                        if (TextUtils.equals(jSONObjectOptJSONObject.optString("aid"), com.apm.insight.f.f())) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put("protector_module#metas");
                            jSONObjectOptJSONObject.put("metas_module", jSONArray);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return f.a(com.apm.insight.g.h().getConfigUrl(), (Map<String, String>) null, jSONArrayA.toString().getBytes());
        } catch (Throwable th) {
            com.apm.insight.o.q.a(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i() {
        int i = b;
        if (i > 0) {
            b = i - 1;
        }
        com.apm.insight.o.q.a((Object) "try fetchApmConfig");
        if (com.apm.insight.o.a.b(com.apm.insight.g.f())) {
            JSONArray jSONArrayOptJSONArray = null;
            try {
                byte[] bArrH = h();
                if (bArrH != null) {
                    jSONArrayOptJSONArray = new JSONObject(new String(bArrH)).optJSONArray("data");
                }
            } catch (Throwable th) {
                com.apm.insight.o.q.a("npth", th);
            }
            com.apm.insight.o.q.a((Object) ("after fetchApmConfig net " + jSONArrayOptJSONArray));
            if (jSONArrayOptJSONArray != null) {
                com.apm.insight.runtime.a.a(jSONArrayOptJSONArray, true);
                b = 0;
            } else {
                b -= 10;
            }
        } else {
            o.c();
            if (o.a()) {
                b = 0;
            }
        }
    }
}
