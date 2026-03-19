package com.tk.core.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c {
    private static b ahK;

    public static b rA() {
        if (ahK == null) {
            if (!com.tk.core.a.oP().isInitSuccess() || com.tk.core.a.oP().isReleaseMode()) {
                ahK = new a();
            } else {
                try {
                    ahK = (b) Class.forName("com.tachikoma.debug.preference.TKDebugPreferenceImpl").getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
                } catch (Throwable th) {
                    com.tk.core.i.a.a("TKDebugStorage", "call TKDebugPreferenceImpl.get() failed", th);
                    ahK = new a();
                }
            }
        }
        return ahK;
    }
}
