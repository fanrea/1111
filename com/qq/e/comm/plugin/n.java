package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.MultiProcessFlag;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class n extends g10 {
    private final Map<String, b> b = new ConcurrentHashMap();
    private final Map<String, Long> c = new ConcurrentHashMap();

    /* compiled from: A */
    private static final class a {
        static n a = new n();
    }

    /* compiled from: A */
    public static final class b {
        public int a;
        public int b;
        public int c;
    }

    public int d(Context context, String str) {
        return a(context, str, true);
    }

    public int c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        b bVarB = b(context, str);
        if (bVarB.a == 4) {
            return bVarB.b;
        }
        return 0;
    }

    public b b(Context context, String str) {
        String strA = q.a(str);
        b bVar = this.b.get(strA);
        if (bVar == null || bVar.a == 8) {
            File fileB = gu.b(strA + ".apk");
            if (bVar == null) {
                bVar = new b();
            }
            if (bVar.a == 8 && fileB != null && fileB.exists()) {
                bVar.b = 100;
            } else if (q.a(fileB, str, context)) {
                bVar.a = 8;
                bVar.b = 100;
            } else {
                bVar.a = 0;
                bVar.b = 0;
            }
            this.b.put(strA, bVar);
        }
        return bVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, 1, 100, 0L);
        b bVar = new b();
        bVar.a = 1;
        bVar.b = 100;
        a(str, bVar, 0L);
    }

    public void b(String str) {
        String strA = q.a(str);
        b bVar = this.b.get(strA);
        if (this.c.get(strA) == null) {
            this.c.put(strA, 0L);
        }
        if (bVar != null) {
            bVar.b = 0;
            return;
        }
        b bVar2 = new b();
        bVar2.b = 0;
        this.b.put(strA, bVar2);
    }

    private int a(Context context, String str) {
        return q.b(context, str) ? 1 : 0;
    }

    public int a(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (z && h10.f(a(context, str))) {
            return 1;
        }
        return b(context, str).a;
    }

    public void a(String str, int i, long j) {
        String strA = q.a(str);
        b bVar = this.b.get(strA);
        if (this.c.get(strA) == null) {
            this.c.put(strA, Long.valueOf(j));
        }
        boolean z = true;
        if (bVar != null) {
            if (bVar.b != i) {
                bVar.b = i;
            } else {
                z = false;
            }
        } else {
            bVar = new b();
            bVar.b = i;
            this.b.put(strA, bVar);
        }
        if (z) {
            a(str, bVar.a, bVar.b, j);
            if (bVar.b % 5 == 0) {
                a(str, bVar, j);
            }
        }
    }

    public void a(String str, int i) {
        a(str, i, 0);
    }

    public void a(String str, int i, int i2) {
        String strA = q.a(str);
        b bVar = this.b.get(strA);
        if (bVar != null) {
            bVar.a = i;
            bVar.c = i2;
        } else {
            bVar = new b();
            bVar.a = i;
            bVar.c = i2;
            this.b.put(strA, bVar);
        }
        if (h10.a(i)) {
            bVar.b = 0;
        }
        Long l = this.c.get(strA);
        long jLongValue = l == null ? 0L : l.longValue();
        a(str, bVar.a, bVar.b, jLongValue);
        a(str, bVar, jLongValue);
    }

    public static n a() {
        return a.a;
    }

    private void a(String str, b bVar, long j) {
        if (MultiProcessFlag.isMultiProcess()) {
            com.qq.e.comm.plugin.apkmanager.j.a(str, bVar.a, bVar.b, j);
        }
    }
}
