package com.apm.insight.i;

import com.apm.insight.g;
import com.apm.insight.o.j;
import com.apm.insight.runtime.q;
import com.apm.insight.runtime.s;
import java.io.File;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    private static HashMap<String, String> a;

    public static String a() {
        return g.f().getFilesDir() + "/apminsight/selflib/";
    }

    public static String a(String str) {
        return g.f().getFilesDir() + "/apminsight/selflib/lib" + str + ".so";
    }

    public static void b(final String str) {
        q.b().a(new Runnable() { // from class: com.apm.insight.i.b.1
            boolean a = false;

            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3;
                b.d();
                if (b.f(str)) {
                    return;
                }
                s.a("updateSo", str);
                File file = new File(b.a(str));
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                com.apm.insight.o.q.a("doUnpackLibrary: " + str);
                String strA = null;
                try {
                    strA = c.a(g.f(), str, file);
                } catch (Throwable th) {
                    s.a("updateSoError", str);
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                }
                if (strA == null) {
                    b.a.put(file.getName(), "1.5.7.oversea");
                    try {
                        j.a(new File(b.e(str)), "1.5.7.oversea", false);
                    } catch (Throwable unused) {
                    }
                    str2 = str;
                    str3 = "updateSoSuccess";
                } else {
                    if (!this.a) {
                        this.a = true;
                        s.a("updateSoPostRetry", str);
                        q.b().a(this, com.alipay.sdk.m.u.b.a);
                        return;
                    }
                    str2 = str;
                    str3 = "updateSoFailed";
                }
                s.a(str3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        if (a != null) {
            return;
        }
        a = new HashMap<>();
        File file = new File(g.f().getFilesDir(), "/apminsight/selflib/");
        String[] list = file.list();
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (str.endsWith(".ver")) {
                try {
                    a.put(str.substring(0, str.length() - 4), j.c(file.getAbsolutePath() + "/" + str));
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                }
            } else if (!str.endsWith(".so")) {
                j.a(new File(file, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        return g.f().getFilesDir() + "/apminsight/selflib/" + str + ".ver";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(String str) {
        return "1.5.7.oversea".equals(a.get(str)) && new File(a(str)).exists();
    }
}
