package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o40 {
    private static int a(String str) {
        return (TextUtils.isEmpty(str) || !(str.contains("f140112.mp4") || str.contains("f140110.mp4"))) ? 2 : 1;
    }

    public static void b(f5 f5Var, long j, long j2, boolean z) {
        a(f5Var, new ja().a("duration", Long.valueOf(j)).a("position", Long.valueOf(j2)), z ? 5 : 4);
    }

    static void b(f5 f5Var, long j, int i) {
        wt wtVarB = new wt(2020005).b(i).b(j);
        wtVarB.a(f5Var);
        b10.a(wtVarB);
    }

    private static int a(h4 h4Var, ja jaVar, int i) throws JSONException {
        if (h4Var == null) {
            return 0;
        }
        int iB = oi.a().b();
        String strV0 = h4Var.V0();
        int iA = a(strV0);
        int iZ0 = h4Var.Z0();
        if (iZ0 == 1 && iA != 1) {
            jaVar.a("url", strV0);
        }
        return (i * 1000) + (iB * 100) + ((iZ0 + 1) * 10) + iA;
    }

    private static void a(f5 f5Var, ja jaVar, int i) {
        b10.a(1130300, f5Var, Integer.valueOf(i), jaVar);
    }

    private static void a(f5 f5Var, ja jaVar, int i, Integer num) {
        b10.a(1130300, f5Var, Integer.valueOf(i), num, jaVar);
    }

    public static void a(f5 f5Var, long j, int i, boolean z) {
        a(f5Var, new ja().a("duration", Long.valueOf(j)).a("play_times", Integer.valueOf(i)), z ? 8 : 7);
    }

    static void a(f5 f5Var, long j) {
        a(f5Var, new ja().a("duration", Long.valueOf(j)), 6);
    }

    public static void a(f5 f5Var, long j, int i, String str, h4 h4Var, int i2, int i3) throws JSONException {
        ja jaVar = new ja();
        jaVar.a("duration", Long.valueOf(j));
        jaVar.a("msg", str);
        jaVar.a("ver", Integer.valueOf(i3));
        b10.a(1130301, f5Var, Integer.valueOf(a(h4Var, jaVar, i2)), Integer.valueOf(i), jaVar);
    }

    public static void a(f5 f5Var, long j, long j2, boolean z) {
        a(f5Var, new ja().a("duration", Long.valueOf(j)).a("position", Long.valueOf(j2)), z ? 3 : 2);
    }

    public static void a(f5 f5Var, mk mkVar, boolean z, h4 h4Var) throws JSONException {
        int iH;
        DisplayMetrics displayMetricsL = r1.d().c().l();
        int i = 0;
        if (displayMetricsL == null) {
            iH = 0;
        } else {
            int iF = displayMetricsL.widthPixels == 0 ? 0 : (mkVar.f() * 100) / displayMetricsL.widthPixels;
            if (displayMetricsL.heightPixels == 0) {
                i = iF;
                iH = 0;
            } else {
                iH = (mkVar.h() * 100) / displayMetricsL.heightPixels;
                i = iF;
            }
        }
        ja jaVarA = new ja().a("duration", Integer.valueOf(mkVar.getDuration())).a("ver", Integer.valueOf(mkVar.getPlayerVersion())).a("width", Integer.valueOf(i)).a("heignt", Integer.valueOf(iH));
        a(f5Var, jaVarA, z ? 1 : 0, Integer.valueOf(a(h4Var, jaVarA, p40.a(mkVar.g()))));
    }

    static void a(f5 f5Var, long j, int i) {
        wt wtVar = new wt(2020004);
        wtVar.a(f5Var);
        wtVar.b(j).b(i);
        b10.a(wtVar);
    }

    public static void a(h4 h4Var) {
        qc qcVar = new qc(1130302);
        qcVar.a(f5.a(h4Var));
        ja jaVar = new ja();
        jaVar.a("vu", h4Var.V0());
        qcVar.a(jaVar);
        b10.a(qcVar);
    }
}
