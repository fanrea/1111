package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f00 {
    public static int a = 1;
    public static int b = 2;
    public static int c = 3;
    public static volatile Boolean d;
    static String e;
    static long f;

    public static void g(xz xzVar) {
        if (xzVar == null) {
            return;
        }
        b10.a(1010402, xzVar.c());
    }

    static void f(xz xzVar) {
        if (xzVar == null) {
            return;
        }
        b10.a(1401000, xzVar.c(), Integer.valueOf(xzVar.p ? 11 : 10), Integer.valueOf(xzVar.q ? 1 : 2), null);
        e = xzVar.c().i();
        f = System.currentTimeMillis();
        if (xzVar.g()) {
            b10.a(1011003, xzVar.c());
        }
    }

    static void e(xz xzVar) throws JSONException {
        if (xzVar == null) {
            return;
        }
        f5 f5VarA = f5.a(xzVar.b());
        Boolean bool = xzVar.v.get();
        if (bool != null) {
            f5VarA.a(bool.booleanValue());
        }
        b10.a(1010027, f5VarA);
        if (xzVar.x > 0) {
            x6.a(xzVar.c(), xzVar.b() == null ? 0 : xzVar.b().W0(), System.currentTimeMillis() - xzVar.x);
        }
    }

    static void e(f5 f5Var) {
        if (TextUtils.isEmpty(e) || f5Var == null || !TextUtils.equals(e, f5Var.i())) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - f;
        if (jCurrentTimeMillis > 0) {
            wt wtVar = new wt(2130401);
            wtVar.b(jCurrentTimeMillis);
            wtVar.a(f5Var);
            b10.a(wtVar);
        }
    }

    static void b(xz xzVar) {
        if (xzVar == null) {
            return;
        }
        b10.a(1012053, xzVar.c(), 0);
    }

    static void c(f5 f5Var) {
        b10.a(1013002, f5Var);
    }

    static void d(f5 f5Var) {
        b10.a(1013006, f5Var);
    }

    static void a(xz xzVar, boolean z, int i) {
        if (xzVar == null) {
            return;
        }
        a(z ? 2011002 : 2011001, xzVar.c());
        b10.a(1013005, xzVar.c(), Integer.valueOf(i), Integer.valueOf(z ? 2 : 1), null);
    }

    public static void h(xz xzVar) {
        b10.a(1013003, xzVar.c(), 2);
        if (xzVar.b() == null || TextUtils.isEmpty(xzVar.b().a1())) {
            return;
        }
        b10.a(1013003, xzVar.c(), 4);
    }

    static void d(xz xzVar) {
        if (xzVar != null && xzVar.x > 0) {
            x6.b(xzVar.c(), System.currentTimeMillis() - xzVar.x);
            if (xzVar.g()) {
                b10.a(1011009, xzVar.c());
            }
        }
    }

    static void b(f5 f5Var) {
        a(2011004, f5Var);
    }

    static void a(xz xzVar, String str, int i, Exception exc) {
        if (str == null) {
            str = "";
        }
        String message = exc != null ? exc.getMessage() : "";
        qc qcVar = new qc(1400018);
        if (xzVar != null) {
            qcVar.a(xzVar.c());
        }
        qcVar.d(i);
        qcVar.a(new ja().a("ot", message).a(ContentProviderManager.PROVIDER_URI, str));
        b10.a(qcVar);
    }

    static void c(xz xzVar) {
        if (xzVar != null && xzVar.x > 0) {
            x6.c(xzVar.c(), System.currentTimeMillis() - xzVar.x);
        }
    }

    static void a(xz xzVar) {
        qc qcVar = new qc(1400021);
        if (xzVar != null) {
            qcVar.a(xzVar.c());
        }
        b10.a(qcVar);
    }

    static void b(xz xzVar, boolean z, int i) {
        if (xzVar == null) {
            return;
        }
        b10.a(1013008, xzVar.c(), Integer.valueOf(i), Integer.valueOf(z ? 2 : 1), null);
    }

    static void a(boolean z, f5 f5Var, int i, boolean z2) {
        int i2 = zz.a;
        int i3 = z ? 1013010 : 1013009;
        int iMin = Math.min(i / 500, 20);
        b10.a(i3, f5Var, Integer.valueOf(iMin), Integer.valueOf(Math.min(i2 / 500, 20)), null);
        b10.a(1013021, f5Var, Integer.valueOf(z2 ? 1 : 2), Integer.valueOf(iMin), null);
    }

    static void a(f5 f5Var) {
        b10.a(1013007, f5Var);
    }

    private static void a(int i, f5 f5Var) {
        String strE = f5Var == null ? null : f5Var.e();
        wt wtVar = new wt(i);
        wtVar.b(zz.d(strE));
        wtVar.b(0);
        wtVar.a(f5Var);
        b10.a(wtVar);
    }

    static void a(xz xzVar, boolean z) {
        if (xzVar == null) {
            return;
        }
        b10.a(z ? 1012050 : 1012051, xzVar.c());
    }

    static void a(xz xzVar, long j) {
        if (xzVar == null) {
            return;
        }
        x6.d(xzVar.c(), System.currentTimeMillis() - j);
    }

    public static void a(e2 e2Var, String str, int i) throws JSONException {
        if (e2Var != e2.SPLASH) {
            return;
        }
        if (d == null) {
            d = Boolean.valueOf(r1.d().f().a("sarai", 0) == 1);
        }
        if (d.booleanValue()) {
            f5 f5VarC = new f5().a(e2Var).c(str);
            b0 b0VarB = r1.d().b();
            b10.a(1013028, f5VarC, Integer.valueOf(i), new ja().a("data", b0VarB.b()).a("data2", b0VarB.a()).a("data3", b0VarB.c()).a("msg", ru.b()));
        }
    }

    public static void a(int i, int i2, int i3, int i4, f5 f5Var, ja jaVar) throws JSONException {
        if (jaVar == null) {
            jaVar = new ja();
        }
        jaVar.a("data", Integer.valueOf(i2));
        b10.a(i, f5Var, Integer.valueOf(i3), Integer.valueOf(i4), jaVar);
    }

    static void a(xz xzVar, boolean z, long j, boolean z2) {
        if (xzVar == null) {
            return;
        }
        go.a(xzVar.c(), 1, xzVar.p ? 11 : 10, xzVar.q ? 1 : 2, z, j, z2);
    }

    static void a(xz xzVar, Integer num) throws JSONException {
        if (xzVar == null) {
            return;
        }
        int i = xzVar.p ? 11 : 10;
        f5 f5VarA = f5.a(xzVar.b());
        Boolean bool = xzVar.v.get();
        if (bool != null) {
            f5VarA.a(bool.booleanValue());
        }
        if (num == null) {
            b10.a(1401002, f5VarA, Integer.valueOf(i));
            if (xzVar.g()) {
                b10.a(1011004, xzVar.c());
                return;
            }
            return;
        }
        b10.a(1401001, f5VarA, Integer.valueOf(i), num, null);
    }

    static void a(xz xzVar, int i, boolean z) {
        if (xzVar == null) {
            return;
        }
        int iMin = Math.min(xzVar.o / 500, 20);
        f5 f5VarC = xzVar.c();
        b10.a(1010062, f5VarC, Integer.valueOf(i), Integer.valueOf(iMin), null);
        b10.a(1013022, f5VarC, Integer.valueOf(z ? 1 : 2), Integer.valueOf(iMin), null);
    }

    public static void a(xz xzVar, qj qjVar) {
        if (qjVar == null || xzVar == null) {
            return;
        }
        b10.a(1013004, xzVar.c(), 2, Integer.valueOf(qjVar.a.h), null);
    }

    static void a(f5 f5Var, int i, int i2) throws JSONException {
        ja jaVar = new ja();
        int iE = ua.e();
        jaVar.a("width", Integer.valueOf(i));
        jaVar.a("height", Integer.valueOf(i2));
        jaVar.a("screenWidth", Integer.valueOf(iE));
        jaVar.a("screenHeight", Integer.valueOf(ua.d()));
        jaVar.a(com.sigmob.sdk.base.n.C, Integer.valueOf(i / iE));
        b10.a(1011006, f5Var, null, null, jaVar);
    }

    static void a(f5 f5Var, int i) {
        wt wtVar = new wt(2010020);
        wtVar.a(f5Var);
        wtVar.b(i);
        b10.a(wtVar);
    }
}
