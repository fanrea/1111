package com.qq.e.comm.plugin;

import android.content.SharedPreferences;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p5 {
    private static volatile p5 b;
    private boolean a;

    private void a() {
        SharedPreferences.Editor editorEdit = r1.d().a().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.remove("2c39b77689");
        editorEdit.apply();
    }

    public static p5 b() {
        if (b == null) {
            synchronized (p5.class) {
                if (b == null) {
                    b = new p5();
                }
            }
        }
        return b;
    }

    private void d() {
        SharedPreferences.Editor editorEdit = r1.d().a().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.putString("2c39b77689", su.c());
        editorEdit.apply();
    }

    public void c() {
        try {
            if (r1.d().f().a("buglyRate", 0) > 0) {
                d();
                this.a = true;
            } else {
                a();
                this.a = false;
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private p5() {
    }
}
