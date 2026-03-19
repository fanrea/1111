package com.tk.core.o;

import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    public static boolean cS(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return new File(str).exists();
    }
}
