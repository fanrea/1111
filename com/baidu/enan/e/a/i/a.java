package com.baidu.enan.e.a.i;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return b(context) ? "1" : "0";
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return false;
        }
    }
}
