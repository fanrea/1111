package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ax {
    static String a;
    static long b;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[e2.values().length];
            c = iArr;
            try {
                iArr[e2.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[e2.REWARDVIDEOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[rw.values().length];
            b = iArr2;
            try {
                iArr2[rw.MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[rw.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[j40.values().length];
            a = iArr3;
            try {
                iArr3[j40.END.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[j40.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[j40.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[j40.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static String a(long j, long j2) {
        return j <= 0 ? "-999" : String.valueOf(j2 - j);
    }

    public static void b(f5 f5Var, long j) {
        x6.b(f5Var, j);
    }

    public static void c(f5 f5Var, long j) {
        x6.c(f5Var, j);
    }

    public static void d(f5 f5Var, long j) {
        x6.d(f5Var, j);
    }

    public static void d(f5 f5Var) {
        if (TextUtils.isEmpty(a) || f5Var == null || !TextUtils.equals(a, f5Var.i())) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - b;
        if (jCurrentTimeMillis > 0) {
            wt wtVar = new wt(2130401);
            wtVar.b(jCurrentTimeMillis);
            wtVar.a(f5Var);
            b10.a(wtVar);
        }
    }

    public static void c(f5 f5Var) {
        b10.b(1020073, f5Var, 1);
    }

    public static String a(j40 j40Var) {
        if (j40Var != null) {
            int i = a.a[j40Var.ordinal()];
            if (i == 1) {
                return "1";
            }
            if (i == 2) {
                return "4";
            }
            if (i == 3) {
                return "2";
            }
            if (i == 4) {
                return "3";
            }
        }
        return "-999";
    }

    public static void b(h4 h4Var) {
        int i;
        qc qcVar = new qc(1400019);
        qcVar.a(f5.a(h4Var));
        String strI0 = h4Var.i0();
        if (TextUtils.isEmpty(strI0)) {
            i = 1;
        } else {
            qcVar.a(new ja().a("url", strI0));
            i = 2;
        }
        qcVar.d(i);
        b10.a(qcVar);
    }

    static void b(f5 f5Var) {
        b10.a(1401000, f5Var);
        if (f5Var != null) {
            a = f5Var.i();
            b = System.currentTimeMillis();
        }
    }

    public static boolean a(f5 f5Var) {
        return (f5Var == null || TextUtils.isEmpty(f5Var.e()) || r1.d().f().a("rdasiy", f5Var.e(), 1) != 1) ? false : true;
    }

    public static void b(rw rwVar, h4 h4Var, long j, long j2, int i, j40 j40Var, boolean z, boolean z2) throws JSONException {
        ja jaVarA;
        int i2;
        f5 f5VarA = f5.a(h4Var);
        int i3 = a.b[rwVar.ordinal()];
        if (i3 == 1) {
            jaVarA = a(j, j2, i, a(j40Var), (String) null);
            jaVarA.a("sr", j40Var == j40.PAUSE ? "1" : "-999");
            i2 = 1020033;
        } else {
            if (i3 != 2) {
                return;
            }
            jaVarA = a(h4Var, i, j2, z, z2, (String) null);
            i2 = 1022032;
        }
        b10.a(i2, f5VarA, null, null, jaVarA, a(f5VarA));
    }

    public static void b(h4 h4Var, int i, long j, boolean z, boolean z2) {
        f5 f5VarA = f5.a(h4Var);
        b10.a(1022030, f5VarA, null, null, a(h4Var, i, j, z, z2, (String) null), a(f5VarA));
    }

    private static ja a(Exception exc, String str) throws JSONException {
        ja jaVar = new ja();
        if (exc != null) {
            jaVar.a("ot", exc.getMessage());
        }
        if (str != null) {
            jaVar.a("rs", str);
        }
        return jaVar;
    }

    public static ja a(h4 h4Var, int i, long j, boolean z, boolean z2, String str) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("rt", String.valueOf(i));
        jaVar.a(com.baidu.mobads.container.adrequest.g.ac, z ? "2" : "1");
        jaVar.a(Config.PLATFORM_TYPE, j == -1 ? "-999" : String.valueOf(j));
        jaVar.a("fi", z2 ? "1" : "-1");
        if (TextUtils.isEmpty(str)) {
            str = "-999";
        }
        jaVar.a("sr", str);
        String strA = a(h4Var);
        if (!TextUtils.isEmpty(strA)) {
            jaVar.a("mt", strA);
        }
        return jaVar;
    }

    public static ja a(long j, long j2, int i, String str, String str2) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("tt", j == -1 ? "-999" : String.valueOf(j));
        jaVar.a(Config.PLATFORM_TYPE, j2 == -1 ? "-999" : String.valueOf(j2));
        jaVar.a("rt", String.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            str = "-999";
        }
        jaVar.a("ps", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "-999";
        }
        jaVar.a("sr", str2);
        return jaVar;
    }

    public static void a(f5 f5Var, long j) {
        x6.a(f5Var, j);
    }

    public static void a(h4 h4Var, int i, long j) throws JSONException {
        b10.a(1022018, f5.a(h4Var), Integer.valueOf(d1.a(h4Var.g0()) ? 1 : 0), a(h4Var, i, j, true, true, (String) null));
    }

    public static void a(h4 h4Var, int i, long j, boolean z, boolean z2) {
        f5 f5VarA = f5.a(h4Var);
        b10.a(1022019, f5VarA, null, null, a(h4Var, i, j, z, z2, (String) null), a(f5VarA));
    }

    public static void a(f5 f5Var, long j, long j2, int i, j40 j40Var, long j3, long j4) throws JSONException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ja jaVarA = a(j, j2, i, a(j40Var), (String) null);
        jaVarA.a("dpu", a(j3, jCurrentTimeMillis));
        jaVarA.a("rcdu", a(j4, jCurrentTimeMillis));
        b10.a(1020034, f5Var, null, null, jaVarA, a(f5Var));
    }

    public static void a(rw rwVar, h4 h4Var, long j, long j2, int i, j40 j40Var, boolean z, boolean z2) throws JSONException {
        ja jaVarA;
        int i2;
        f5 f5VarA = f5.a(h4Var);
        int i3 = a.b[rwVar.ordinal()];
        if (i3 == 1) {
            jaVarA = a(j, j2, i, a(j40Var), (String) null);
            jaVarA.a("sr", j40Var == j40.PAUSE ? "1" : "-999");
            i2 = 1020012;
        } else {
            if (i3 != 2) {
                return;
            }
            jaVarA = a(h4Var, i, j2, z, z2, (String) null);
            i2 = 1022007;
        }
        b10.a(i2, f5VarA, null, null, jaVarA, a(f5VarA));
    }

    static void a(boolean z, int i, String str, String str2, f5 f5Var) throws JSONException {
        if (z) {
            b10.a(1022002, f5Var);
            return;
        }
        ja jaVar = new ja();
        jaVar.a("rs", str);
        jaVar.a("ot", str2);
        b10.b(1022003, f5Var, Integer.valueOf(i), jaVar);
    }

    public static void a(h4 h4Var, int i, long j, long j2, long j3, boolean z, boolean z2) throws JSONException {
        f5 f5VarA = f5.a(h4Var);
        ja jaVarA = a(h4Var, i, j2, z, z2, (String) null);
        long jCurrentTimeMillis = System.currentTimeMillis();
        jaVarA.a("dpu", a(j3, jCurrentTimeMillis));
        jaVarA.a("rcdu", a(j, jCurrentTimeMillis));
        b10.a(1022016, f5VarA, null, null, jaVarA, a(f5VarA));
    }

    public static void a(h4 h4Var, int i, int i2, long j, boolean z, boolean z2) throws JSONException {
        int i3;
        f5 f5VarA = f5.a(h4Var);
        ja jaVarA = a(h4Var, i, j, z, z2, (String) null);
        if (i2 == 1) {
            jaVarA.a("sr", "1");
            i3 = 1022033;
        } else if (i2 == 2) {
            i3 = 1022034;
        } else if (i2 != 3) {
            return;
        } else {
            i3 = 1022016;
        }
        b10.a(i3, f5VarA, null, null, jaVarA, a(f5VarA));
    }

    static void a(f5 f5Var, int i) {
        b10.b(1401001, f5Var, Integer.valueOf(i));
    }

    static void a(f5 f5Var, boolean z, boolean z2) {
        b10.a(1401002, f5Var, Integer.valueOf(!z ? 1 : 2), Integer.valueOf(z2 ? 2 : 1), null);
    }

    public static void a(int i, f5 f5Var, String str, Exception exc, long j, long j2, int i2) throws JSONException {
        ja jaVarA = a(exc, str);
        jaVarA.a("tt", j == -1 ? "-999" : String.valueOf(j));
        jaVarA.a(Config.PLATFORM_TYPE, j2 == -1 ? "-999" : String.valueOf(j2));
        jaVarA.a("rt", String.valueOf(i2));
        jaVarA.a("ps", "3");
        jaVarA.a("sr", "-999");
        b10.a(1020009, f5Var, null, Integer.valueOf(i), jaVarA, a(f5Var));
    }

    public static void a(f5 f5Var, long j, long j2, int i) {
        b10.a(1020006, f5Var, null, null, a(j, j2, i, "4", (String) null), a(f5Var));
    }

    public static void a(rw rwVar, f5 f5Var) {
        int i = a.b[rwVar.ordinal()];
        b10.a(i != 1 ? i != 2 ? 0 : 1022004 : 1020008, f5Var);
    }

    public static void a(j40 j40Var, f5 f5Var, ja jaVar) throws JSONException {
        int i;
        int i2 = a.a[j40Var.ordinal()];
        if (i2 == 1) {
            if (jaVar != null) {
                jaVar.a("ps", "1");
            }
            i = 1020013;
        } else if (i2 == 2) {
            if (jaVar != null) {
                jaVar.a("ps", "4");
            }
            i = 1020011;
        } else {
            if (i2 != 3) {
                return;
            }
            if (jaVar != null) {
                jaVar.a("ps", "2");
                jaVar.a("sr", "1");
            }
            i = 1020010;
        }
        b10.a(i, f5Var, null, null, jaVar, a(f5Var));
    }

    public static void a(f5 f5Var, long j, boolean z, String str) throws JSONException {
        ja jaVarA = new ja().a("page", str).a("hasReward", Boolean.valueOf(z));
        wt wtVar = new wt(2052002);
        wtVar.a(f5Var);
        wtVar.a(jaVarA);
        wtVar.b(j);
        b10.a(wtVar);
    }

    public static void a(h4 h4Var, long j) {
        wt wtVar = new wt(2020038);
        wtVar.a(f5.a(h4Var));
        wtVar.b(j);
        b10.a(wtVar);
    }

    private static String a(h4 h4Var) {
        int i = a.c[h4Var.k().ordinal()];
        return i != 1 ? i != 2 ? "" : "RewardVideo" : ExploreConstants.SCENE_SPLASH;
    }
}
