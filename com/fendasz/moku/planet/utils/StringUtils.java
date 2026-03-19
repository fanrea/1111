package com.fendasz.moku.planet.utils;

import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class StringUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    public static String getNumber(String str) {
        if (isEmpty(str)) {
            return "0";
        }
        String strRemoveNotNumber = removeNotNumber(str);
        return isValid(strRemoveNotNumber) ? strRemoveNotNumber : "0";
    }

    public static boolean isValid(String str) {
        return !isEmpty(str) && str.length() > 0;
    }

    public static String removeNotNumber(String str) {
        String str2 = "";
        if (!isValid(str)) {
            return "";
        }
        String strTrim = str.trim();
        for (int i = 0; i < strTrim.length(); i++) {
            if (strTrim.charAt(i) <= '9' && strTrim.charAt(i) >= '0') {
                str2 = str2 + strTrim.charAt(i);
            }
        }
        return str2;
    }

    public static boolean isNumber(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (char c : str.trim().toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static String formatMoney(String str) {
        if (str == null) {
            return "";
        }
        if (!str.contains(".")) {
            return str;
        }
        String string = new StringBuilder(str).reverse().toString();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < string.length(); i++) {
            if (z) {
                sb.append(string.charAt(i));
            } else if (string.charAt(i) == '.') {
                z = true;
            } else if (string.charAt(i) != '0') {
                sb.append(string.charAt(i));
                z = true;
            }
        }
        return sb.reverse().toString();
    }

    public static int compare(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length() < str2.length() ? str.length() : str2.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        if (str.length() == str2.length()) {
            return -1;
        }
        return length;
    }

    public static String cutFrontAndLastZeroString(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String strTrim = str.trim();
        int length = strTrim.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (strTrim.charAt(length) == '0');
        int i = 0;
        if (length != strTrim.length() - 1) {
            strTrim = strTrim.substring(0, length + 1);
        }
        while (i < strTrim.length() && strTrim.charAt(i) == '0') {
            i++;
        }
        return strTrim.substring(i);
    }

    public static List<Integer> splitIndex(String str, char c) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }
}
