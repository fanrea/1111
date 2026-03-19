package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.forbes.Config;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class aq {
    private static long a = 0;
    private static int b = -1;

    public static void a(h4 h4Var, zp zpVar, String str) {
    }

    public static void a(zp zpVar, String str) {
    }

    public static boolean a(int i) {
        return i > -1;
    }

    public static void b(h4 h4Var, zp zpVar, String str) {
    }

    public static int a(h4 h4Var) {
        if (h4Var == null) {
            return r1.d().f().a("stcvim", 500);
        }
        return r1.d().f().a("stcvim", h4Var.y0(), 500);
    }

    public static int m(h4 h4Var) {
        if (h4Var == null) {
            return r1.d().f().a("stcvmr", 50);
        }
        return r1.d().f().a("stcvmr", h4Var.y0(), 50);
    }

    private static String g(e2 e2Var) {
        if (e2Var.l()) {
            return "sss";
        }
        if (e2Var.i()) {
            return "sss_ihs";
        }
        if (e2Var.h()) {
            return "sss_ifs";
        }
        if (e2Var.k()) {
            return "sss_reward";
        }
        if (e2Var.f()) {
            return "sss_banner";
        }
        if (e2Var.g()) {
            return "sss_express";
        }
        if (e2Var.j()) {
            return "sss_native";
        }
        return null;
    }

    public static int c(h4 h4Var, h8 h8Var) {
        int iH = h(h4Var);
        return iH > 0 ? iH : h8Var.c.optInt("bv", 153);
    }

    private static String f(e2 e2Var) {
        if (e2Var.l()) {
            return "sstms_3";
        }
        if (e2Var.i()) {
            return "sstms_8";
        }
        if (e2Var.h()) {
            return "sstms_9";
        }
        if (e2Var.k()) {
            return "sstms_5";
        }
        if (e2Var.f()) {
            return "sstms_7";
        }
        if (e2Var.g()) {
            return "sstms_4";
        }
        if (e2Var.j()) {
            return "sstms_6";
        }
        return null;
    }

    public static boolean g(h4 h4Var, h8 h8Var) {
        int iA;
        int iA2;
        if (h4Var == null) {
            iA = r1.d().f().a("svaugg", -1);
        } else {
            String strA = a(h4Var.k());
            if (strA != null && (iA2 = xc.a(strA, h4Var.y0(), -1, h4Var.x0())) >= 0) {
                return iA2 == 1;
            }
            iA = xc.a("svaugg", h4Var.y0(), -1, h4Var.x0());
        }
        return iA >= 0 ? iA == 1 : h8Var.c.optInt("bg", 1) == 1;
    }

    private static String c(e2 e2Var) {
        if (e2Var.l()) {
            return "seroas_3";
        }
        if (e2Var.i()) {
            return "seroas_8";
        }
        if (e2Var.h()) {
            return "seroas_9";
        }
        if (e2Var.k()) {
            return "seroas_5";
        }
        if (e2Var.f()) {
            return "seroas_7";
        }
        if (e2Var.g()) {
            return "seroas_4";
        }
        if (e2Var.j()) {
            return "seroas_6";
        }
        return null;
    }

    public static int b(h4 h4Var, h8 h8Var) {
        int iA;
        int iA2;
        if (h4Var == null) {
            iA = r1.d().f().a("sstms", -1);
        } else {
            String strF = f(h4Var.k());
            if (strF != null && (iA2 = xc.a(strF, h4Var.y0(), -1, h4Var.x0())) > 0) {
                return iA2;
            }
            iA = xc.a("sstms", h4Var.y0(), -1, h4Var.x0());
        }
        return iA > 0 ? iA : h8Var.c.optInt("bc", 2);
    }

    private static String j(e2 e2Var) {
        if (e2Var.l()) {
            return "skstt";
        }
        if (e2Var.i()) {
            return "skstt_ihs";
        }
        if (e2Var.h()) {
            return "skstt_ifs";
        }
        if (e2Var.k()) {
            return "skstt_reward";
        }
        if (e2Var.f()) {
            return "skstt_banner";
        }
        if (e2Var.g()) {
            return "skstt_express";
        }
        if (e2Var.j()) {
            return "skstt_native";
        }
        return null;
    }

    private static int l(h4 h4Var) {
        int iA;
        if (h4Var == null) {
            return r1.d().f().a("skstt_all", 45);
        }
        String strJ = j(h4Var.k());
        return (strJ == null || (iA = xc.a(strJ, h4Var.y0(), -1, h4Var.x0())) <= 0) ? xc.a("skstt_all", h4Var.y0(), 45, h4Var.x0()) : iA;
    }

    public static int a(h4 h4Var, h8 h8Var) {
        int iG = g(h4Var);
        return iG > 0 ? iG : h8Var.c.optInt("bc", 1);
    }

    public static int e(h4 h4Var, h8 h8Var) {
        int iL = l(h4Var);
        return iL > 0 ? iL : h8Var.c.optInt("tt", 45);
    }

    private static String i(e2 e2Var) {
        if (e2Var.l()) {
            return "skstm";
        }
        if (e2Var.i()) {
            return "skstm_ihs";
        }
        if (e2Var.h()) {
            return "skstm_ifs";
        }
        if (e2Var.k()) {
            return "skstm_reward";
        }
        if (e2Var.f()) {
            return "skstm_banner";
        }
        if (e2Var.g()) {
            return "skstm_express";
        }
        if (e2Var.j()) {
            return "skstm_native";
        }
        return null;
    }

    private static int k(h4 h4Var) {
        int iA;
        if (h4Var == null) {
            return r1.d().f().a("skstm_all", -1);
        }
        String strI = i(h4Var.k());
        return (strI == null || (iA = xc.a(strI, h4Var.y0(), -1, h4Var.x0())) <= 0) ? xc.a("skstm_all", h4Var.y0(), -1, h4Var.x0()) : iA;
    }

    public static int d(h4 h4Var, h8 h8Var) {
        int iK = k(h4Var);
        return iK > 0 ? iK : h8Var.c.optInt("tm", 60);
    }

    private static String h(e2 e2Var) {
        if (e2Var.l()) {
            return "tstspct_splash";
        }
        if (e2Var.i()) {
            return "tstspct_ihs";
        }
        if (e2Var.h()) {
            return "tstspct_ifs";
        }
        if (e2Var.k()) {
            return "tstspct_reward";
        }
        if (e2Var.f()) {
            return "tstspct_banner";
        }
        if (e2Var.g()) {
            return "tstspct_feed";
        }
        if (e2Var.j()) {
            return "tstspct_native";
        }
        return null;
    }

    public static w40 a(Set<w40> set, int i, int i2) {
        for (w40 w40Var : set) {
            if (a(w40Var, i, i2)) {
                return w40Var;
            }
        }
        return null;
    }

    public static int f(h4 h4Var) {
        int iH = h(h4Var);
        if (iH > 0) {
            return iH;
        }
        return 153;
    }

    public static int f(h4 h4Var, h8 h8Var) {
        int iA = xc.a("tts", 70, h4Var);
        return iA > 0 ? iA : h8Var.c.optInt("tts", 70);
    }

    private static String d(e2 e2Var) {
        if (e2Var.l()) {
            return "skefes_3";
        }
        if (e2Var.i()) {
            return "skefes_8";
        }
        if (e2Var.h()) {
            return "skefes_9";
        }
        if (e2Var.k()) {
            return "skefes_5";
        }
        if (e2Var.f()) {
            return "skefes_7";
        }
        if (e2Var.g()) {
            return "skefes_4";
        }
        if (e2Var.j()) {
            return "skefes_6";
        }
        return null;
    }

    private static String a(e2 e2Var) {
        if (e2Var.l()) {
            return "svaugg_3";
        }
        if (e2Var.i()) {
            return "svaugg_8";
        }
        if (e2Var.h()) {
            return "svaugg_9";
        }
        if (e2Var.k()) {
            return "svaugg_5";
        }
        if (e2Var.f()) {
            return "svaugg_7";
        }
        if (e2Var.g()) {
            return "svaugg_4";
        }
        if (e2Var.j()) {
            return "svaugg_6";
        }
        return null;
    }

    public static int j(h4 h4Var, h8 h8Var) {
        int iA;
        int iA2;
        if (h4Var == null) {
            iA = r1.d().f().a("skefes", -1);
        } else {
            String strD = d(h4Var.k());
            if (strD != null && (iA2 = xc.a(strD, h4Var.y0(), -1, h4Var.x0())) > 0) {
                return iA2;
            }
            iA = xc.a("skefes", h4Var.y0(), -1, h4Var.x0());
        }
        return iA > 0 ? iA : h8Var.c.optInt("bn", -1);
    }

    public static int d(h4 h4Var) {
        if (h4Var == null) {
            return -1;
        }
        int iA = xc.a("skstcv_" + h4Var.k().d(), h4Var.y0(), -1, h4Var.x0());
        return iA >= 0 ? iA : xc.a("skstcv", h4Var.y0(), -1, (ku) null);
    }

    public static void d() {
        a = System.currentTimeMillis();
    }

    public static long j(h4 h4Var) {
        if (h4Var == null) {
            return r1.d().f().a("nusmi", 3) * 1000;
        }
        return a(h4Var.y0());
    }

    private static int g(h4 h4Var) {
        int iA;
        if (h4Var == null) {
            return r1.d().f().a("ssst_all", 1);
        }
        String strE = e(h4Var.k());
        return (strE == null || (iA = xc.a(strE, h4Var.y0(), -1, h4Var.x0())) <= 0) ? xc.a("ssst_all", h4Var.y0(), 1, h4Var.x0()) : iA;
    }

    public static int i(h4 h4Var, h8 h8Var) {
        int iA;
        int iA2;
        if (h4Var == null) {
            iA = r1.d().f().a("seroas", -1);
        } else {
            String strC = c(h4Var.k());
            if (strC != null && (iA2 = xc.a(strC, h4Var.y0(), -1, h4Var.x0())) > 0) {
                return iA2;
            }
            iA = xc.a("seroas", h4Var.y0(), -1, h4Var.x0());
        }
        return iA > 0 ? iA : h8Var.c.optInt("bx", -1);
    }

    private static boolean a(w40 w40Var, int i, int i2) {
        View viewA;
        if (w40Var == null || (viewA = w40Var.A()) == null || !d50.a(viewA.getContext(), viewA, i, true)) {
            return false;
        }
        if (i2 <= 0) {
            return true;
        }
        qm$h$$ExternalSyntheticBackport0.m(d50.a(viewA, i2).second);
        return !((Boolean) r3.first).booleanValue();
    }

    private static String e(e2 e2Var) {
        if (e2Var.l()) {
            return "ssst";
        }
        if (e2Var.i()) {
            return "ssst_ihs";
        }
        if (e2Var.h()) {
            return "ssst_ifs";
        }
        if (e2Var.k()) {
            return "ssst_reward";
        }
        if (e2Var.f()) {
            return "ssst_banner";
        }
        if (e2Var.g()) {
            return "ssst_express";
        }
        if (e2Var.j()) {
            return "ssst_native";
        }
        return null;
    }

    public static long a(String str) {
        return r1.d().f().a("nusmi", str, 3) * 1000;
    }

    public static boolean a(long j) {
        return System.currentTimeMillis() - a < j;
    }

    public static boolean a() {
        if (b == -1) {
            b = r1.d().f().a("sbgur", 1);
        }
        return b == 1;
    }

    public static int[] h(h4 h4Var, h8 h8Var) {
        String strA;
        String strA2;
        String[] strArrSplit;
        String strValueOf = String.valueOf(-1);
        int[] iArr = {0};
        if (h4Var == null) {
            strA2 = r1.d().f().b("sdaxfe", strValueOf);
            strValueOf.equals(strA2);
        } else {
            String strB = b(h4Var.k());
            if (!strValueOf.equals(strValueOf) || strB == null) {
                strA = strValueOf;
            } else {
                strA = xc.a(strB, h4Var.y0(), strValueOf, h4Var.x0());
                strValueOf.equals(strA);
            }
            if (strValueOf.equals(strA)) {
                strA2 = xc.a("sdaxfe", h4Var.y0(), strValueOf, h4Var.x0());
                strValueOf.equals(strA2);
            } else {
                strA2 = strA;
            }
        }
        if (strValueOf.equals(strA2)) {
            strA2 = h8Var.c.optString(Config.DEVICE_BRAND, strValueOf);
        }
        if (!strValueOf.equals(strA2) && !TextUtils.isEmpty(strA2) && (strArrSplit = strA2.split(",")) != null && strArrSplit.length != 0) {
            int[] iArr2 = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                try {
                    iArr2[i] = Integer.parseInt(strArrSplit[i]);
                } catch (Exception unused) {
                }
            }
            return iArr2;
        }
        return iArr;
    }

    public static boolean c(h4 h4Var) {
        return h4Var == null ? xc.a("tctdl", 1, tc.c()) == 1 : xc.a("tctdl", 1, h4Var) == 1;
    }

    public static float c() {
        return m10.a(r1.d().f().b("sttimed_t", "0.2"), 0.0f);
    }

    public static int b(h4 h4Var) {
        String strH = h(h4Var.k());
        if (strH != null) {
            return xc.a(strH, h4Var.y0(), -1, h4Var.x0());
        }
        return -1;
    }

    public static int i(h4 h4Var) {
        if (h4Var == null) {
            return r1.d().f().a("shake_mode_control", -1);
        }
        return xc.a("shake_mode_control", h4Var.y0(), -1, h4Var.x0());
    }

    private static int h(h4 h4Var) {
        int iA;
        if (h4Var == null) {
            return r1.d().f().a("sss_all", 153);
        }
        String strG = g(h4Var.k());
        return (strG == null || (iA = xc.a(strG, h4Var.y0(), -1, h4Var.x0())) <= 0) ? xc.a("sss_all", h4Var.y0(), 153, h4Var.x0()) : iA;
    }

    private static String b(e2 e2Var) {
        if (e2Var.l()) {
            return "sdaxfe_3";
        }
        if (e2Var.i()) {
            return "sdaxfe_8";
        }
        if (e2Var.h()) {
            return "sdaxfe_9";
        }
        if (e2Var.k()) {
            return "sdaxfe_5";
        }
        if (e2Var.f()) {
            return "sdaxfe_7";
        }
        if (e2Var.g()) {
            return "sdaxfe_4";
        }
        if (e2Var.j()) {
            return "sdaxfe_6";
        }
        return null;
    }

    public static float b() {
        return m10.a(r1.d().f().b("sttimed_s", "0.5"), 0.0f);
    }

    public static int e(h4 h4Var) {
        int iG = g(h4Var);
        if (iG > 0) {
            return iG;
        }
        return 1;
    }
}
