package com.tk.core.o;

import android.graphics.Color;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class r {
    public static int aR(int i, int i2) {
        if (i2 == 255) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static int ed(int i) {
        int i2 = i >>> 24;
        if (i2 == 255) {
            return -1;
        }
        return i2 == 0 ? -2 : -3;
    }

    private static int ee(int i) {
        return (i >>> 8) | ((i & 255) << 24);
    }

    public static int parseColor(String str) {
        return a(str, (com.tk.core.bridge.a) null);
    }

    public static int a(String str, com.tk.core.bridge.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.charAt(0) == '#') {
            return b(str, aVar);
        }
        if (str.charAt(0) == 'r') {
            a(aVar, new IllegalArgumentException("Wrong color format rgb() or rgba(), " + str));
            return 0;
        }
        if (str.charAt(0) != '#' && (str.length() == 6 || str.length() == 8)) {
            com.tk.core.i.a.z("TKColorUtil", "Wrong color format without '#' header, " + str);
            return b("#" + str, aVar);
        }
        a(aVar, new IllegalArgumentException("Unknown color format, " + str));
        return 0;
    }

    private static int b(String str, com.tk.core.bridge.a aVar) {
        try {
            int color = Color.parseColor(str);
            return str.length() == 9 ? ee(color) : color;
        } catch (Throwable unused) {
            a(aVar, new IllegalArgumentException("Wrong color string, " + str));
            return 0;
        }
    }

    private static void a(com.tk.core.bridge.a aVar, Throwable th) {
        com.tk.core.exception.a.b(th, aVar != null ? aVar.pg() : -1);
    }
}
