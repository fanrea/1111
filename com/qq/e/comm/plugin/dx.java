package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dx {
    private static final boolean a;

    static {
        a = r1.d().f().a("rcrmc", 0) == 0;
    }

    public static void a(Context context, pw pwVar) {
        pro.getVresult(685, 1, context, pwVar);
    }

    public static void a(h4 h4Var, zw zwVar, ServerSideVerificationOptions serverSideVerificationOptions) {
        pro.getVresult(686, 1, h4Var, zwVar, serverSideVerificationOptions);
    }

    public static int e(h4 h4Var) {
        int iA = r1.d().f().a("rvccd", -1);
        if (iA > 10000) {
            iA = b.c().a(h4Var.x0(), String.valueOf(iA), -1);
        }
        if (iA <= -1) {
            return -1;
        }
        return iA * 100;
    }

    public static int b(h4 h4Var) {
        return xc.a("rewardVideoCardShowTime", h4Var.y0(), 4, h4Var.x0());
    }

    public static int c(h4 h4Var) {
        int iA = r1.d().f().a(h4Var.k().h() ? "ifcfsvdgest" : "rvfsvdgest", h4Var.y0(), -1);
        return iA <= 100 ? iA : b.c().a(h4Var.x0(), String.valueOf(iA), -1);
    }

    public static boolean c(String str) {
        return r1.d().f().a("sksrpaje", str, 1) == 1;
    }

    public static int a(h4 h4Var) {
        return xc.a("racest", h4Var.y0(), 4, h4Var.x0());
    }

    public static JSONObject a(Context context, h4 h4Var) throws JSONException {
        JSONObject jSONObject = new JSONObject(h4Var.i());
        if (k.a(context, h4Var) || !h4Var.k1()) {
            jSONObject.put("custom_button_txt", h4Var.C());
            jSONObject.put("dpa_custom_button_txt", jb.a(h4Var) ? h4Var.L().f : "");
        }
        return jSONObject;
    }

    /* compiled from: A */
    class a implements qr {
        final /* synthetic */ f5 a;

        a(f5 f5Var) {
            this.a = f5Var;
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, Exception exc) {
            b10.b(1020076, this.a, 3000);
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            int iA;
            if (hwVar != null) {
                iA = hwVar.a();
                if (iA == 200) {
                    b10.a(1020075, this.a);
                    return;
                }
            } else {
                iA = 3000;
            }
            b10.a(1020076, this.a, Integer.valueOf(iA), 3005, null);
        }
    }

    public static Pair<String, Boolean> d(h4 h4Var) {
        if (h4Var == null) {
            return new Pair<>("奖励", Boolean.FALSE);
        }
        String strF0 = h4Var.F0();
        if (!TextUtils.isEmpty(strF0)) {
            return new Pair<>(strF0, Boolean.TRUE);
        }
        return new Pair<>(xc.a("te_rarn", h4Var.y0(), "奖励", h4Var.x0()), Boolean.FALSE);
    }

    public static boolean d(String str) {
        return r1.d().f().a("sksrppe", str, 1) == 1;
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? gp.a(str) : "";
    }

    public static int a(h4 h4Var, boolean z) {
        if (z) {
            return 1;
        }
        return jb.a(h4Var) ? 2 : 0;
    }

    public static int a(String str) {
        return xc.a("rewardLoadAdCount", str, 1);
    }

    public static boolean a() {
        return r1.d().f().a("bxgrvbc", 0) == 1;
    }
}
