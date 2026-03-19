package com.alliance.ssp.ad.o0;

/* compiled from: StringUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class r {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean b(String str) {
        int length;
        boolean z = false;
        if (str == null || (length = str.length()) == 0) {
            z = true;
        } else {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    break;
                }
            }
            z = true;
        }
        return !z;
    }
}
