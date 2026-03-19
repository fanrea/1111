package com.tk.core.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private static String TAG = "Tachikoma-NATIVE";

    @Deprecated
    public static void b(String str, Throwable th) {
        a("Logger", str, th);
    }

    public static void a(String str, String str2, Throwable th) {
        if (com.tk.core.a.oP().oS() != null) {
            com.tk.core.a.oP().oS().e(cM(str), str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (com.tk.core.a.oP().oS() != null) {
            com.tk.core.a.oP().oS().d(cM(str), str2, th);
        }
    }

    public static void x(String str, String str2) {
        if (com.tk.core.a.oP().oS() != null) {
            com.tk.core.a.oP().oS().d(cM(str), str2, null);
        }
    }

    public static void y(String str, String str2) {
        if (com.tk.core.a.oP().oS() != null) {
            com.tk.core.a.oP().oS().w(cM(str), str2);
        }
    }

    public static void z(String str, String str2) {
        if (com.tk.core.a.oP().oS() != null) {
            com.tk.core.a.oP().oS().i(cM(str), str2);
        }
    }

    private static String cM(String str) {
        return TAG + "[" + str + "]";
    }
}
