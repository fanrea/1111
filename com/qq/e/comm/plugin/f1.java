package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f1 {
    private static final ConcurrentHashMap<String, Long> a = new ConcurrentHashMap<>();
    private static final int b = r1.d().f().a("rvncbt", 0);

    private static boolean b() {
        return b <= 0;
    }

    static void c(w1 w1Var, e2 e2Var) {
        if (b() || w1Var == null) {
            return;
        }
        String strE = w1Var.E();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        b10.a(1407052, b(e2Var), 0, 0, b(strE));
        a.remove(strE);
    }

    static void b(w1 w1Var, e2 e2Var) {
        if (b() || w1Var == null) {
            return;
        }
        String strE = w1Var.E();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        ConcurrentHashMap<String, Long> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(strE)) {
            b10.a(1407056, b(e2Var), 0, 0, b(strE));
        }
        concurrentHashMap.put(strE, Long.valueOf(System.currentTimeMillis()));
        b10.a(1407051, b(e2Var), 0, 0, b(strE));
        xo.a(new a(strE, e2Var), b);
    }

    static void b(w1 w1Var, e2 e2Var, int i) {
        if (b() || w1Var == null) {
            return;
        }
        String strE = w1Var.E();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        b10.a(1407055, b(e2Var), Integer.valueOf(i), 0, b(strE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ja b(String str) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("tk", str);
        jaVar.a("limit", Integer.valueOf(b));
        long jCurrentTimeMillis = System.currentTimeMillis();
        jaVar.a("tm", Long.valueOf(jCurrentTimeMillis));
        Long l = a.get(str);
        if (l != null) {
            jaVar.a("stm", l);
            jaVar.a("stmd", Long.valueOf(jCurrentTimeMillis - l.longValue()));
        }
        return jaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f5 b(e2 e2Var) throws JSONException {
        f5 f5Var = new f5();
        f5Var.a(e2Var);
        return f5Var;
    }

    static void a(w1 w1Var, e2 e2Var) {
        if (b() || w1Var == null) {
            return;
        }
        String strE = w1Var.E();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        b10.a(1407053, b(e2Var), 0, 0, b(strE));
        a.remove(strE);
    }

    static void a(w1 w1Var, e2 e2Var, int i) {
        if (b() || w1Var == null) {
            return;
        }
        String strE = w1Var.E();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        b10.a(1407054, b(e2Var), 0, Integer.valueOf(i), b(strE));
    }

    /* compiled from: A */
    private static class a implements Runnable {
        private final String a;
        private final e2 b;

        @Override // java.lang.Runnable
        public void run() {
            if (f1.a.containsKey(this.a)) {
                b10.a(1407050, f1.b(this.b), 0, 0, f1.b(this.a));
            }
        }

        a(String str, e2 e2Var) {
            this.a = str;
            this.b = e2Var;
        }
    }
}
