package com.kwai.middleware.azeroth.utils;

import java.io.File;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TextUtils {
    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    private TextUtils() {
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String toStringOrEmpty(Object obj) {
        return obj != null ? emptyIfNull(obj.toString()) : "";
    }

    public static String take(String str, int i) {
        return (str == null || i < 0) ? "" : str.substring(0, Math.min(i, str.length()));
    }

    public static String leftPad(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < i) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String defaultIfEmpty(String str, String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static boolean matchFileType(File file, String... strArr) {
        return file != null && matchFileType(file.getName(), strArr);
    }

    public static boolean matchFileType(String str, String... strArr) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        for (String str2 : strArr) {
            if (lowerCase.endsWith(str2.toLowerCase(Locale.US))) {
                return true;
            }
        }
        return false;
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
