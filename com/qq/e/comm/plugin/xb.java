package com.qq.e.comm.plugin;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xb extends n4 {
    public static boolean d(e2 e2Var) {
        JSONObject jSONObjectA = ub.c().a(wb.a(e2Var));
        if (jSONObjectA == null) {
            return true;
        }
        int iOptInt = jSONObjectA.optInt(Config.STAT_SDK_TYPE, 0);
        int iOptInt2 = jSONObjectA.optInt(Config.EVENT_PATH_MAPPING, 0);
        if (iOptInt < 0 || iOptInt2 < 0) {
            return false;
        }
        if (iOptInt == iOptInt2) {
            return true;
        }
        int iB = k20.b();
        return iOptInt < iOptInt2 ? iB >= iOptInt && iB < iOptInt2 : iB >= iOptInt || iB < iOptInt2;
    }

    public static int c(e2 e2Var) {
        JSONObject jSONObjectA = ub.c().a(wb.b(e2Var));
        if (jSONObjectA == null) {
            return 0;
        }
        return jSONObjectA.optInt(TypedValues.TransitionType.S_TO, 0);
    }

    public static int b(e2 e2Var) {
        JSONObject jSONObjectA = ub.c().a(wb.b(e2Var));
        if (jSONObjectA == null) {
            return 0;
        }
        return jSONObjectA.optInt("cs", 0);
    }

    public static JSONArray a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONArray("alist");
    }

    public static boolean a(long j, e2 e2Var) {
        int iA = a(e2Var);
        return iA > 0 && System.currentTimeMillis() - j <= ((long) (iA * 1000)) * 60;
    }

    public static boolean a(h4 h4Var) {
        return a(h4Var.j0(), h4Var.k());
    }

    public static int a(vb vbVar) {
        JSONObject jSONObjectA = ub.c().a(vbVar);
        if (jSONObjectA != null) {
            return jSONObjectA.optInt(com.kuaishou.weapon.p0.t.k);
        }
        return 0;
    }

    public static int a(zr zrVar, int i) {
        JSONObject jSONObjectA = ub.c().a(wb.a());
        if (jSONObjectA == null) {
            return i;
        }
        if (zr.WIFI.equals(zrVar)) {
            return jSONObjectA.optInt(com.baidu.mobads.container.util.x.m, i);
        }
        return jSONObjectA.optInt("mb", i);
    }

    public static int a(e2 e2Var) {
        JSONObject jSONObjectA = ub.c().a(wb.a(e2Var));
        if (jSONObjectA == null) {
            return 0;
        }
        return jSONObjectA.optInt("fztime", 0);
    }

    public static int a(e2 e2Var, String str, ku kuVar) {
        JSONObject jSONObjectA = ub.c().a(wb.a(e2Var, str, kuVar));
        if (jSONObjectA == null) {
            return 0;
        }
        return jSONObjectA.optInt("aet", 0);
    }
}
