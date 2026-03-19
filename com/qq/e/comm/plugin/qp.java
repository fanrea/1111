package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qp {
    public static boolean a(tr trVar) {
        return b() && trVar.a() == 100;
    }

    public static boolean b() {
        return su.h() < 580;
    }

    public static boolean c(String str) {
        if (b()) {
            return mp.a(r1.d().a()).b(str);
        }
        return false;
    }

    public static boolean e(String str) {
        if (b()) {
            return str.startsWith("com.qq.e.comm.plugin");
        }
        return false;
    }

    public static Map<String, String> b(String str) {
        if (b()) {
            return yv.b(str);
        }
        return null;
    }

    public static Integer a(String str) {
        if (b()) {
            return yv.a(str);
        }
        return null;
    }

    public static HashMap<String, String> a() {
        if (b()) {
            return mp.a(r1.d().a()).b();
        }
        return null;
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 12;
    }
}
