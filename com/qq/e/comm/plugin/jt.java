package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jt {
    private static final int a;
    private static final boolean b;

    /* compiled from: A */
    interface d {
        String a();

        String a(Context context);
    }

    /* compiled from: A */
    private static class f {
        private static final d[] a;

        static {
            a = new d[]{new b(), new c(), new e()};
        }
    }

    static {
        int iNextInt = new Random(System.currentTimeMillis()).nextInt(10000);
        a = iNextInt;
        b = iNextInt < r1.d().f().a("rgkp", 0);
    }

    /* compiled from: A */
    private static class b implements d {
        @Override // com.qq.e.comm.plugin.jt.d
        public String a() {
            return "gkp_a";
        }

        @Override // com.qq.e.comm.plugin.jt.d
        public String a(Context context) {
            return (String) pro.getobjresult(542, 0, this, context);
        }

        private b() {
        }
    }

    /* compiled from: A */
    private static class c implements d {
        @Override // com.qq.e.comm.plugin.jt.d
        public String a() {
            return "gkp_c";
        }

        @Override // com.qq.e.comm.plugin.jt.d
        public String a(Context context) {
            return (String) pro.getobjresult(366, 0, this, context);
        }

        private c() {
        }
    }

    /* compiled from: A */
    private static class e implements d {
        @Override // com.qq.e.comm.plugin.jt.d
        public String a() {
            return "gkp_p";
        }

        @Override // com.qq.e.comm.plugin.jt.d
        public String a(Context context) {
            return (String) pro.getobjresult(26, 0, this, context);
        }

        private e() {
        }
    }

    public static void a() {
        a(9200021, (f5) null);
    }

    public static void a(f5 f5Var, JSONObject jSONObject) throws JSONException {
        if (b) {
            f5 f5Var2 = new f5();
            f5Var2.c(f5Var.e());
            f5Var2.a(f5Var.b());
            if (jSONObject != null) {
                f5Var2.a(jSONObject);
            }
            a(9200022, f5Var2);
        }
    }

    public static void a(h4 h4Var) {
        if (!b || h4Var == null) {
            return;
        }
        f5 f5Var = new f5();
        f5Var.e(h4Var.S0());
        f5Var.c(h4Var.y0());
        f5Var.a(h4Var.k());
        a(9200022, f5Var);
    }

    private static void a(int i, f5 f5Var) throws JSONException {
        int iA = r1.d().f().a("tgkp", 0);
        if (iA <= 0) {
            return;
        }
        b0 b0VarB = r1.d().b();
        Context contextA = r1.d().a();
        ja jaVar = new ja();
        String strB = b0VarB.b();
        d[] dVarArr = f.a;
        String strConcat = "";
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < dVarArr.length; i4++) {
            d dVar = dVarArr[i4];
            int i5 = 1 << i4;
            if ((iA & i5) != 0) {
                try {
                    String strA = dVar.a(contextA);
                    if (TextUtils.isEmpty(strA)) {
                        i2 |= i5;
                    } else if (!TextUtils.equals(strA, strB)) {
                        i3 |= i5;
                        try {
                            jaVar.a(dVar.a() + "_e", m10.b(strA));
                        } catch (Throwable unused) {
                        }
                    }
                    jaVar.a(dVar.a(), strA);
                } catch (Throwable th) {
                    i2 |= i5;
                    strConcat = strConcat.concat(dVar.a()).concat(":").concat(th.getMessage()).concat(com.alipay.sdk.m.u.i.b);
                }
            }
        }
        if (!TextUtils.isEmpty(strConcat)) {
            jaVar.a("msg", strConcat);
        }
        if (jaVar.a() != null) {
            b10.a(i, f5Var, Integer.valueOf(i3), Integer.valueOf(i2), jaVar);
        }
    }
}
