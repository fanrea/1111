package com.baidu.mobads.container.components.h.c;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final String a = "0";
    private static final String b = "1";
    private static final String c = "2";
    private static final String d = "3";
    private static final String e = "4";
    private static final String f = "5";

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.endsWith("00")) {
            return "0";
        }
        if (strTrim.contains("0")) {
            return "1";
        }
        if (a(strTrim, "3") >= 2) {
            return "2";
        }
        if (a(strTrim, "6") >= 2) {
            return "3";
        }
        if (a(strTrim, "4") >= 2) {
            return "4";
        }
        return "5";
    }

    private static int a(String str, String str2) {
        int i = 0;
        if (!str.contains(str2)) {
            return 0;
        }
        while (str.contains(str2)) {
            i++;
            str = str.substring(str.indexOf(str2) + str2.length());
        }
        return i;
    }
}
