package com.android.gdt.qone.af;

import android.util.Log;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class c {
    public static void a(String str, String str2, Object... objArr) {
        if (a.a()) {
            Log.e("qm_tag", a.a("Qm-Core-Error: " + str + " " + str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a.a()) {
            Log.i("qm_tag", a.a("Qm-Core-Info: " + str + " " + str2, objArr));
        }
    }

    public static void a(Throwable th) {
        if (a.a()) {
            th.printStackTrace();
        } else {
            th.getMessage();
        }
    }
}
