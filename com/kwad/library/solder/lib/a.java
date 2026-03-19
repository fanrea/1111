package com.kwad.library.solder.lib;

import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static String Pf() {
        return "";
    }

    public static void e(String str, String str2) {
        Log.e("Sodler", I(str, str2));
    }

    public static void e(String str, Throwable th) {
        Log.e("Sodler", I(str, ""), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e("Sodler", I(str, str2), th);
    }

    private static String I(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + Pf();
    }
}
