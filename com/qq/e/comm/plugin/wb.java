package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.SplashAd;
import com.qq.e.comm.plugin.vb;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wb {
    public static vb c() {
        return a("eaecc", "");
    }

    public static vb d() {
        return a("eagsm", "");
    }

    public static vb e() {
        return a("eiac", "");
    }

    public static String f() {
        return a("eacsuc", "", "", (ku) null);
    }

    public static vb b(e2 e2Var) {
        String strA = a(e2Var, "eapcfg2", "", "");
        if (a(strA)) {
            return vb.v;
        }
        return new vb.b().a(4).a(-1L).a(e2Var).b(2).c("eapr2").a(strA);
    }

    public static vb a(e2 e2Var, String str, ku kuVar) {
        String strA = a(e2Var, "eaetcfg", "", str, kuVar);
        if (a(strA)) {
            return vb.v;
        }
        return new vb.b().a(4).a(-1L).a(e2Var).b(2).c("eaet").a(strA);
    }

    public static vb a(h4 h4Var) {
        return a(h4Var.k(), h4Var.y0(), h4Var.x0());
    }

    public static vb b(String str, e2 e2Var, String str2, List<JSONObject> list, int i) throws JSONException {
        return new vb.b().a(e2Var).c("patr_" + str2).c(a(str2, e2Var, list, i)).a(str);
    }

    public static vb a(String str, long j, long j2) {
        if (a(str)) {
            return vb.v;
        }
        return new vb.b().c("csur").a(1, 2).c(new jn().a("lrt", j).a("fiut", j2).a()).a(str);
    }

    public static String b(e2 e2Var, String str) {
        return a(e2Var, "eapatc", "", str);
    }

    public static vb b() {
        return a("eaacuic", "");
    }

    private static JSONObject a(String str, e2 e2Var, List<JSONObject> list, int i) throws JSONException {
        int iA;
        JSONArray jSONArray = new JSONArray();
        for (JSONObject jSONObject : list) {
            jn jnVarA = new jn().a("aid", jSONObject.opt("cl")).a("prid", jSONObject.opt("productid")).a("tid", jSONObject.opt("traceid")).a("aetime", jSONObject.opt("ad_expire")).a("actime", jSONObject.opt("adCachedTime")).a("prld", jSONObject.optInt("prld", 0));
            long jOptLong = jSONObject.optLong("adReturnTime");
            if (jOptLong > 0 && (iA = xb.a(e2Var)) > 0) {
                jnVarA.a("ufztime", jOptLong + (iA * 60 * 1000));
            }
            int iOptInt = jSONObject.optInt(SplashAd.KEY_BIDFAIL_ECPM, -1);
            if (iOptInt != -1) {
                jnVarA.a(SplashAd.KEY_BIDFAIL_ECPM, iOptInt);
            }
            int iA2 = h4.a(jSONObject, str);
            if (iA2 != -1) {
                jnVarA.a("mp", iA2);
            }
            jnVarA.a("adext", jSONObject.optJSONObject("ext3"));
            jSONArray.put(jnVarA.a());
        }
        return new jn().a("cindex", i).a("pid", str).a("alist", jSONArray).a();
    }

    private static vb a(String str, String str2) {
        String strA = a(str, str2, "", (ku) null);
        if (a(strA)) {
            return vb.v;
        }
        return new vb.b().a(1).a(-1L).a(strA);
    }

    public static vb a(h4 h4Var, JSONObject jSONObject, int i) {
        vb.b bVarA = new vb.b().a(i);
        if (h4Var != null) {
            bVarA.a(h4Var.k()).b(h4Var.y0());
        }
        return bVarA.a(jSONObject);
    }

    public static vb a(e2 e2Var) {
        String strA = a(e2Var, "eapcfg", "", "");
        if (a(strA)) {
            return vb.v;
        }
        return new vb.b().a(4).a(-1L).a(e2Var).b(2).c("eapr").a(strA);
    }

    public static vb a(String str, e2 e2Var, String str2, List<JSONObject> list, int i) throws JSONException {
        return new vb.b().a(e2Var).a(1, 2).b(3).b(str2).c("pasr").c(a(str2, e2Var, list, i)).a(str);
    }

    private static String a(e2 e2Var, String str, String str2, String str3, ku kuVar) {
        if (e2Var != null) {
            String strA = vx.a(str, e2Var);
            if (!TextUtils.isEmpty(r1.d().f().a(strA, str3, (String) null))) {
                return a(strA, str2, str3, kuVar);
            }
        }
        return a(str, str2, str3, kuVar);
    }

    private static String a(String str, String str2, String str3, ku kuVar) {
        return xc.a(str, str3, str2, kuVar);
    }

    private static String a(e2 e2Var, String str, String str2, String str3) {
        if (e2Var == null) {
            return xc.a(str, "APP", str3, str2);
        }
        String strA = vx.a(str, e2Var);
        if (!TextUtils.isEmpty(r1.d().f().a(strA, str3, (String) null))) {
            return xc.a(strA, e2Var.c(), str3, str2);
        }
        return xc.a(str, e2Var.c(), str3, str2);
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || "{}".equals(str);
    }

    public static vb a() {
        String strA = a("adtcec", "", "", b.c().d());
        if (a(strA)) {
            return vb.v;
        }
        return new vb.b().c("adtc").a(-1L).a(strA);
    }

    public static String a(e2 e2Var, String str) {
        return a(e2Var, "eapasc", e2.REWARDVIDEOAD == e2Var ? "{\"sn\":\"ca1cf6dac1eb2a4ef55c1b8acd598f30\",\"p\":{\"clientRerankerExp\":\"0.5,0.9#1020034:-0.5,1022016:-0.5,4000000:1.5#1\"},\"rse\":1,\"pf\":1}" : "{}", str);
    }

    public static vb a(long j, zj zjVar) {
        String strA = a("eapuoc", "", "", (ku) null);
        if (a(strA)) {
            return vb.v;
        }
        return new vb.b().c("puor").a(1, 3).a(-1L).c(new jn().a("fu", j).a()).a(strA).a(zjVar);
    }
}
