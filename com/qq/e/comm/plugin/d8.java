package com.qq.e.comm.plugin;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d8 {
    private static int a;
    private static volatile SharedPreferences b;

    static {
        int iA = r1.d().f().a("freqdct", 0);
        a = iA;
        b = iA > 0 ? r1.d().a().getSharedPreferences("com.qq.e.dlcci", 0) : null;
    }

    public static void a() {
        if (b()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - b.getLong("dcflcm", 0L) < 86400000) {
            return;
        }
        SharedPreferences.Editor editorEdit = b.edit();
        boolean z = false;
        for (Map.Entry<String, ?> entry : b.getAll().entrySet()) {
            entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (!TextUtils.isEmpty(str) && jCurrentTimeMillis - new jn(str).a().optLong("fct") > a * 3600000) {
                    editorEdit.remove(entry.getKey());
                    z = true;
                }
            }
        }
        if (z) {
            editorEdit.apply();
        }
    }

    private static boolean b() {
        return b == null;
    }

    public static void b(h4 h4Var) {
        yq yqVarP0;
        if (b() || (yqVarP0 = h4Var.p0()) == null || yqVarP0.y() || yqVarP0.k) {
            return;
        }
        yqVarP0.k = true;
        String strL = yqVarP0.l();
        jn jnVar = new jn(b.getString(strL, ""));
        int iOptInt = jnVar.a().optInt("tct") + 1;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jOptLong = jnVar.a().optLong("fct");
        if (jOptLong <= 0) {
            jOptLong = jCurrentTimeMillis;
        }
        jnVar.a("freqId", strL);
        jnVar.a("max", yqVarP0.k());
        jnVar.a("fct", jOptLong);
        jnVar.a("lct", jCurrentTimeMillis);
        jnVar.a("tct", iOptInt);
        b.edit().putString(strL, jnVar.toString()).apply();
    }

    public static String a(h4 h4Var) {
        yq yqVarP0;
        if (b() || (yqVarP0 = h4Var.p0()) == null || yqVarP0.y()) {
            return "";
        }
        String string = b.getString(yqVarP0.l(), "");
        return TextUtils.isEmpty(string) ? "" : new jn(string).a("max", yqVarP0.k()).toString();
    }
}
