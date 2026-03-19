package com.kwad.lottie;

import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m {
    private final Map<String, String> blh;
    private boolean bli;

    private static String dl(String str) {
        return str;
    }

    public final String dm(String str) {
        if (this.bli && this.blh.containsKey(str)) {
            return this.blh.get(str);
        }
        String strDl = dl(str);
        if (this.bli) {
            this.blh.put(str, strDl);
        }
        return strDl;
    }
}
