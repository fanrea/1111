package com.sigmob.sdk.base.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m {
    public static String a(String input) {
        int i;
        if (a((CharSequence) input)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < input.length()) {
            char cCharAt = input.charAt(i2);
            if (cCharAt == '\\' && (i = i2 + 1) < input.length() && input.charAt(i) == 'u') {
                int i3 = i2 + 2;
                int i4 = i2 + 6;
                try {
                    sb.append((char) Integer.parseInt(input.substring(i3, i4), 16));
                    i = i4;
                } catch (NumberFormatException unused) {
                    sb.append(cCharAt);
                }
                i2 = i;
            } else {
                sb.append(cCharAt);
                i2++;
            }
        }
        return sb.toString();
    }

    public static boolean a(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean a(CharSequence str01, CharSequence str02) {
        return str01 != null && str01.equals(str02);
    }

    public static boolean a(String str01, String str02) {
        return str01 != null && str01.equalsIgnoreCase(str02);
    }

    public static boolean b(CharSequence str) {
        return !a(str);
    }

    public static boolean b(CharSequence str01, CharSequence str02) {
        return !a(str01, str02);
    }
}
