package com.baidu.ad.magic.flute.d;

import java.util.Calendar;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static final int a = 2020;
    private static final int b = 2029;
    private static final int c = 6;

    public static long a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("fluteDateString should not be null ");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("fluteDateString should not be empty ");
        }
        if (str.length() != 6) {
            throw new IllegalArgumentException("fluteDateString length should be 6 ");
        }
        if (str == null || str.length() == 0 || str.length() != 6) {
            throw new IllegalArgumentException("fluteDateString should not be null or empty ");
        }
        if (!Pattern.compile("[0-9]*").matcher(str).matches()) {
            throw new IllegalArgumentException("fluteDateString should be all number");
        }
        String str2 = "202" + str.substring(0, 1);
        String strSubstring = str.substring(1, 4);
        String strSubstring2 = str.substring(4, 6);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, Integer.valueOf(str2).intValue());
        calendar.set(6, Integer.valueOf(strSubstring).intValue());
        calendar.set(11, Integer.valueOf(strSubstring2).intValue());
        return calendar.getTimeInMillis();
    }

    public static String a(long j) {
        String strValueOf = String.valueOf(j);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6 - strValueOf.length(); i++) {
            stringBuffer.append(0);
        }
        stringBuffer.append(strValueOf);
        return stringBuffer.toString();
    }
}
