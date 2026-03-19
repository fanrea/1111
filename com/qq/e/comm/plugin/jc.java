package com.qq.e.comm.plugin;

import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jc {
    private static final SharedPreferences a = r1.d().a().getSharedPreferences(gp.a("com.qq.e.enhance"), 0);

    public static int a(String str) {
        return a.getInt(str + "_fc", 0);
    }

    public static boolean a(String str, int i) {
        String str2 = str + "_uce";
        SharedPreferences sharedPreferences = a;
        boolean z = sharedPreferences.getBoolean(str2, false);
        if (z) {
            sharedPreferences.edit().remove(str2).putInt(str + "_fc", i).apply();
        }
        return z;
    }

    public static void b(String str, int i) {
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.remove(str + "_uce");
        String str2 = str + "_fc";
        if (i <= 0) {
            editorEdit.remove(str2);
        } else {
            editorEdit.putInt(str2, i);
        }
        if (q0.t) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static void b(String str) {
        a.edit().putBoolean(str + "_uce", true).apply();
    }
}
