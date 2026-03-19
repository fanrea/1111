package com.qq.e.comm.plugin.nativeadunified;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.b10;
import com.qq.e.comm.plugin.d50;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.ja;
import com.qq.e.comm.plugin.x6;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class i {
    static void g(f5 f5Var) {
        b10.a(1401000, f5Var);
    }

    static void h(f5 f5Var) {
        b10.a(1401002, f5Var);
    }

    public static void a(f5 f5Var, long j) {
        x6.a(f5Var, j);
    }

    public static void d(f5 f5Var) {
        b10.a(1405003, f5Var);
    }

    static void f(f5 f5Var) {
        b10.a(1060033, f5Var);
    }

    static void b(f5 f5Var) {
        b10.a(1060031, f5Var, 0);
    }

    static void c(f5 f5Var) {
        b10.a(1060031, f5Var, 1);
    }

    static void e(f5 f5Var) {
        b10.a(1060031, f5Var, 2);
    }

    public static void d(f5 f5Var, long j) {
        x6.d(f5Var, j);
    }

    static void b(f5 f5Var, long j) {
        x6.b(f5Var, j);
    }

    static void c(f5 f5Var, long j) {
        x6.c(f5Var, j);
    }

    static void a(f5 f5Var) {
        b10.a(1060031, f5Var, 3);
    }

    static void b(f5 f5Var, int i, long j, long j2) {
        b10.a(1130115, f5Var, 0, new ja().a("progress", Integer.valueOf(i)).a("finished", Long.valueOf(j)).a(Config.EXCEPTION_MEMORY_TOTAL, Long.valueOf(j2)));
    }

    static void a(f5 f5Var, int i) {
        b10.a(1060032, f5Var, Integer.valueOf(i));
    }

    static void a(f5 f5Var, int i, long j, long j2) {
        b10.a(1130114, f5Var, 0, new ja().a("progress", Integer.valueOf(i)).a("finished", Long.valueOf(j)).a(Config.EXCEPTION_MEMORY_TOTAL, Long.valueOf(j2)));
    }

    static void a(f5 f5Var, int i, String str) throws JSONException {
        ja jaVar = new ja();
        if (!TextUtils.isEmpty(str)) {
            jaVar.a("msg", str);
        }
        b10.b(1401001, f5Var, Integer.valueOf(i), jaVar);
    }

    static void a(f5 f5Var, boolean z) {
        b10.a(1060029, f5Var, Integer.valueOf(z ? 1 : 2), 0, null);
    }

    static void a(boolean z, f5 f5Var, int i) {
        if (z) {
            b10.a(1060014, f5Var);
        } else {
            b10.b(1060013, f5Var, Integer.valueOf(i));
        }
    }

    public static boolean a(f5 f5Var, View... viewArr) throws JSONException {
        ja jaVar = new ja();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < viewArr.length; i++) {
                View view = viewArr[i];
                if (view != null && (view.isShown() || (view.getWidth() > 0 && view.getHeight() > 0))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("w", Integer.valueOf(view.getWidth()));
                    jSONObject.putOpt("h", Integer.valueOf(view.getHeight()));
                    jSONObject.putOpt("a", Integer.valueOf((int) (d50.a(view) * 100.0f)));
                    jSONArray.put(i, jSONObject);
                }
                return false;
            }
            jaVar.a("nvi", jSONArray);
        } catch (JSONException e) {
            e.getMessage();
        }
        b10.a(1060021, f5Var, null, null, jaVar);
        return true;
    }
}
