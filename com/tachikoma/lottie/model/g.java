package com.tachikoma.lottie.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g {
    private static String KX = "\r";
    public final float GT;
    public final float KY;
    private final String name;

    public g(String str, float f, float f2) {
        this.name = str;
        this.KY = f2;
        this.GT = f;
    }

    public final boolean ag(String str) {
        if (this.name.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.name.endsWith(KX)) {
            String str2 = this.name;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
