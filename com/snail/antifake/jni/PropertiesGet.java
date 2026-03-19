package com.snail.antifake.jni;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PropertiesGet {
    private static native String native_get(String str);

    private static native String native_get(String str, String str2);

    static {
        System.loadLibrary("property_get");
    }

    public static String getString(String str) {
        return native_get(str);
    }

    public static String getString(String str, String str2) {
        return native_get(str, str2);
    }
}
