package com.bytedance.adsdk.lottie.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private final String b;
    public final float d;
    public final float hc;

    public an(String str, float f, float f2) {
        this.b = str;
        this.hc = f2;
        this.d = f;
    }

    public boolean d(String str) {
        if (this.b.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.b.endsWith("\r")) {
            String str2 = this.b;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
