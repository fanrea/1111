package com.apm.insight.n;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class o {
    private static File a = null;
    private static volatile boolean b = false;
    private static volatile boolean c = false;
    private static volatile long d = System.currentTimeMillis();
    private static String e = "exception_modules";
    private static String f = "npth";
    private static Map<String, String> g = null;

    public static void a(final Object obj) {
        if (System.currentTimeMillis() - d > 3600000) {
            com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.n.o.2
                @Override // java.lang.Runnable
                public void run() {
                    long unused = o.d = System.currentTimeMillis();
                    try {
                        if (o.i().lastModified() + com.apm.insight.runtime.a.h(com.apm.insight.entity.b.b(obj)) < o.d) {
                            a.a();
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        }
    }

    public static void a(String str) {
        if (g == null) {
            g = new HashMap();
        }
        g.put(str, String.valueOf(System.currentTimeMillis()));
    }

    public static void a(boolean z, JSONArray jSONArray) {
        try {
            com.apm.insight.o.j.a(new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/configCrash/configFile"), jSONArray, false);
        } catch (IOException unused) {
        }
        try {
            com.apm.insight.o.j.a(i(), g);
        } catch (Throwable unused2) {
        }
    }

    static boolean a() {
        return b;
    }

    static boolean a(boolean z) {
        File fileI = i();
        try {
            Map<String, String> mapE = g;
            if (mapE == null) {
                mapE = com.apm.insight.o.j.e(fileI);
            }
            g = mapE;
            if (mapE == null) {
                g = new HashMap();
                return true;
            }
            if (mapE.size() < com.apm.insight.entity.b.c()) {
                return true;
            }
            Iterator<String> it = com.apm.insight.entity.b.d().iterator();
            while (it.hasNext()) {
                if (!g.containsKey(it.next())) {
                    return true;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z2 = false;
            for (Map.Entry<String, String> entry : g.entrySet()) {
                try {
                    long jLongValue = Long.decode(entry.getValue()).longValue();
                    if (com.apm.insight.runtime.e.b(entry.getKey())) {
                        if (jCurrentTimeMillis - jLongValue > com.apm.insight.runtime.e.e(entry.getKey())) {
                            z2 = true;
                        }
                    }
                } catch (Throwable th) {
                    com.apm.insight.o.q.a(th);
                }
            }
            com.apm.insight.o.q.a((Object) (z2 ? "config should be updated" : "config should not be updated"));
            return z2;
        } catch (Throwable th2) {
            Log.e("npth", NotificationCompat.CATEGORY_ERROR, th2);
            return true;
        }
    }

    public static boolean b() {
        return c;
    }

    public static void c() {
        try {
            if (!b && com.apm.insight.runtime.p.e()) {
                c = true;
                File file = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/configCrash/configFile");
                if (file.exists()) {
                    com.apm.insight.runtime.a.a(new JSONArray(com.apm.insight.o.j.c(file)), false);
                    b = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        c();
        if (a(false)) {
            a.a();
        }
    }

    public static void e() {
        com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.n.o.1
            @Override // java.lang.Runnable
            public void run() {
                o.c();
                if (o.a(false)) {
                    a.a();
                }
            }
        });
    }

    public static void f() {
        Map<String, String> map = g;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File i() {
        if (a == null) {
            a = new File(com.apm.insight.o.p.j(com.apm.insight.g.f()), "apminsight/configCrash/configInvalid");
        }
        return a;
    }
}
