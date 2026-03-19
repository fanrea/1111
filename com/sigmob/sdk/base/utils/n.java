package com.sigmob.sdk.base.utils;

import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n {
    private static final String a = "^((?!^10\\.)((?!^127\\.)((?!^192\\.168\\.)((?!^172\\.1[6-9]\\.)((?!^172\\.2[0-9]\\.)((?!^172\\.3[0-1]\\.)[0-9]{1,3}\\.){3}[0-9]{1,3}|^::1$|^([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}$)))))";

    public static boolean a(Boolean value) {
        return b((Object) value) && value.booleanValue();
    }

    public static boolean a(Number value) {
        return b(value) && value.intValue() > 0;
    }

    public static boolean a(Object value) {
        return value == null;
    }

    public static boolean a(String ipAddress) {
        if (a((Object) ipAddress)) {
            return false;
        }
        return Pattern.compile(a).matcher(ipAddress).matches();
    }

    public static boolean b(Boolean value) {
        return b((Object) value) && !value.booleanValue();
    }

    public static boolean b(Object value) {
        return value != null;
    }

    public static boolean c(Object value) {
        return value == null || ((value instanceof String) && m.a((CharSequence) value));
    }

    public static boolean d(Object value) {
        return !c(value);
    }
}
