package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class go {
    private static volatile boolean a;

    private static ja a(w1 w1Var) throws JSONException {
        ja jaVar = new ja();
        if (w1Var != null && w1Var.K()) {
            jaVar.a("tk", w1Var.E());
        }
        return jaVar;
    }

    private static Integer a(j jVar, w1 w1Var) {
        return a(jVar, w1Var, false, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Integer a(com.qq.e.comm.plugin.j r1, com.qq.e.comm.plugin.w1 r2, boolean r3, int r4) {
        /*
            com.qq.e.comm.plugin.e2 r1 = r1.b
            com.qq.e.comm.plugin.e2 r0 = com.qq.e.comm.plugin.e2.SPLASH
            if (r1 != r0) goto L1c
            if (r2 == 0) goto L1c
            java.lang.Integer r1 = r2.s()
            if (r1 == 0) goto L1a
            java.lang.Integer r1 = r2.s()
            int r1 = r1.intValue()
            r0 = 1
            if (r1 != r0) goto L1a
            goto L1d
        L1a:
            r0 = 2
            goto L1d
        L1c:
            r0 = -1
        L1d:
            if (r3 == 0) goto L21
            int r0 = r0 + 10
        L21:
            if (r2 == 0) goto L2c
            int r1 = r2.B()
            if (r1 <= 0) goto L2c
            int r1 = r1 * 100
            int r0 = r0 + r1
        L2c:
            if (r4 <= 0) goto L31
            int r4 = r4 * 1000
            int r0 = r0 + r4
        L31:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.go.a(com.qq.e.comm.plugin.j, com.qq.e.comm.plugin.w1, boolean, int):java.lang.Integer");
    }

    private static boolean b(j jVar, w1 w1Var) {
        if (jVar == null || w1Var == null) {
            return true;
        }
        return jVar.b == e2.SPLASH && w1Var.z() == 1;
    }

    static void a(j jVar, w1 w1Var, int i) throws JSONException {
        if (b(jVar, w1Var)) {
            return;
        }
        f5 f5VarA = a(jVar);
        a(1400001, Integer.valueOf(i), a(jVar, w1Var), f5VarA, w1Var.d(), a(w1Var));
    }

    public static void c(f5 f5Var, int i) {
        a(f5Var, i, (h4) null);
    }

    public static void d(f5 f5Var, int i) {
        a(1400010, Integer.valueOf(i), (Integer) null, f5Var, 1);
    }

    static void b(j jVar, w1 w1Var, boolean z, int i) throws JSONException {
        if (b(jVar, w1Var)) {
            return;
        }
        ja jaVarA = a(w1Var);
        jaVarA.a(com.baidu.mobads.container.adrequest.g.ag, Integer.valueOf(sf.l().f()));
        f5 f5VarA = a(jVar);
        a(1400003, null, a(jVar, w1Var, z, i), f5VarA, w1Var.d(), jaVarA);
        if (w1Var.K()) {
            a(1408002, null, null, f5VarA, w1Var.d(), jaVarA);
        }
        if (a || GlobalSetting.isAgreePrivacyStrategy()) {
            return;
        }
        a = true;
        b10.a(9130008, f5VarA);
    }

    private static void a(f5 f5Var, int i, int i2, ja jaVar, boolean z) {
        b10.a(1400006, f5Var, Integer.valueOf(i2), Integer.valueOf(i), jaVar);
        if (z) {
            b10.a(1408003, f5Var, Integer.valueOf(i2), Integer.valueOf(i), jaVar);
        }
    }

    public static void b(f5 f5Var, int i) {
        a(1400005, (Integer) null, (Integer) null, f5Var, i);
    }

    public static void a(f5 f5Var, int i, boolean z) {
        a(f5Var, i, 0, (ja) null, z);
    }

    static void a(j jVar, w1 w1Var, String str) throws JSONException {
        ja jaVarA;
        if (b(jVar, w1Var)) {
            return;
        }
        f5 f5VarA = a(jVar);
        Integer numA = a(jVar, w1Var);
        if (TextUtils.isEmpty(str)) {
            jaVarA = null;
        } else {
            jaVarA = a(w1Var);
            jaVarA.a("msg", s60.a(str));
        }
        a(f5VarA, 5001, numA.intValue(), jaVarA, w1Var.K());
    }

    static void a(j jVar, w1 w1Var, Throwable th) throws JSONException {
        ja jaVarA;
        if (b(jVar, w1Var)) {
            return;
        }
        f5 f5VarA = a(jVar);
        Integer numA = a(jVar, w1Var);
        if (th != null) {
            jaVarA = a(w1Var);
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            jaVarA.a("msg", s60.a(sb.toString()));
        } else {
            jaVarA = null;
        }
        a(f5VarA, 3000, numA.intValue(), jaVarA, w1Var.K());
    }

    public static void a(f5 f5Var, int i) {
        a(1400007, (Integer) null, (Integer) null, f5Var, i);
    }

    static void a(j jVar, w1 w1Var, int i, boolean z, int i2) throws JSONException {
        if (b(jVar, w1Var)) {
            return;
        }
        f5 f5VarA = a(jVar);
        Integer numA = a(jVar, w1Var, z, i2);
        ja jaVarA = a(w1Var).a("nc", Boolean.valueOf(as.i())).a("nt", Integer.valueOf(r1.d().c().p().b()));
        a(1400004, Integer.valueOf(i), numA, f5VarA, w1Var.d(), jaVarA);
        if (w1Var.K()) {
            a(1408003, Integer.valueOf(i), numA, f5VarA, w1Var.d(), jaVarA);
        }
    }

    static void a(j jVar, w1 w1Var, boolean z) throws JSONException {
        if (b(jVar, w1Var)) {
            return;
        }
        f5 f5VarA = a(jVar);
        a(1400002, null, a(jVar, w1Var), f5VarA, w1Var.d(), z ? new ja().a("data", 1) : null);
        if (w1Var.K()) {
            a(1408001, (Integer) null, (Integer) null, f5VarA, w1Var.d());
        }
    }

    private static void a(int i, Integer num, Integer num2, f5 f5Var, int i2) {
        a(i, num, num2, f5Var, i2, null);
    }

    private static void a(int i, Integer num, Integer num2, f5 f5Var, int i2, ja jaVar) {
        qc qcVar = new qc(i);
        qcVar.b(i2);
        qcVar.a(f5Var);
        if (num2 != null) {
            qcVar.c(num2.intValue());
        }
        if (num != null) {
            qcVar.d(num.intValue());
        }
        if (jaVar != null) {
            qcVar.a(jaVar);
        }
        b10.a(qcVar);
    }

    public static void a(int i, f5 f5Var, int i2) {
        a(1400008, Integer.valueOf(i), (Integer) null, f5Var, i2);
    }

    public static void a(int i, f5 f5Var, int i2, ja jaVar) {
        a(1400008, Integer.valueOf(i), null, f5Var, i2, jaVar);
    }

    public static void a(f5 f5Var, int i, int i2, int i3, boolean z, long j, boolean z2) {
        ja jaVar = new ja();
        jaVar.a("is2s", Integer.valueOf(z ? 1 : 0));
        jaVar.a("du", Long.valueOf(j));
        jaVar.a("ifs", Integer.valueOf(z2 ? 1 : 0));
        a(1400009, Integer.valueOf(i3), Integer.valueOf(i2), f5Var, i, jaVar);
    }

    public static void a(f5 f5Var, int i, h4 h4Var) {
        a(1400009, null, null, f5Var, i, (h4Var == null || h4Var.L0() == 0 || h4Var.X() == 0) ? null : new ja().a("du", Long.valueOf(h4Var.X() - h4Var.L0())));
    }

    private static f5 a(j jVar) throws JSONException {
        f5 f5Var = new f5();
        f5Var.a(jVar.b);
        f5Var.c(jVar.a);
        return f5Var;
    }
}
