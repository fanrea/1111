package com.tk.core.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class t {
    public static boolean isDebug() {
        return com.tk.core.a.oP().isInitSuccess() && com.tk.core.a.oP().isDebugMode();
    }

    public static boolean sQ() {
        if (com.tk.core.a.oP().isInitSuccess()) {
            return com.tk.core.a.oP().isReleaseMode();
        }
        return true;
    }
}
