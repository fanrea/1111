package com.tachikoma.lottie;

import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class p {
    private final Map<String, String> Iw;
    private boolean Ix;

    private static String Z(String str) {
        return str;
    }

    public final String aa(String str) {
        if (this.Ix && this.Iw.containsKey(str)) {
            return this.Iw.get(str);
        }
        String strZ = Z(str);
        if (this.Ix) {
            this.Iw.put(str, strZ);
        }
        return strZ;
    }
}
