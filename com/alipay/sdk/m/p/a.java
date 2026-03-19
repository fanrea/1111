package com.alipay.sdk.m.p;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split(com.alipay.sdk.m.s.a.n);
        if (strArrSplit.length == 0) {
            return "";
        }
        String strE = null;
        String strD = null;
        String strF = null;
        String strC = null;
        for (String str2 : strArrSplit) {
            if (TextUtils.isEmpty(strE)) {
                strE = e(str2);
            }
            if (TextUtils.isEmpty(strD)) {
                strD = d(str2);
            }
            if (TextUtils.isEmpty(strF)) {
                strF = f(str2);
            }
            if (TextUtils.isEmpty(strC)) {
                strC = c(str2);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(strE)) {
            sb.append("biz_type=" + strE + i.b);
        }
        if (!TextUtils.isEmpty(strD)) {
            sb.append("biz_no=" + strD + i.b);
        }
        if (!TextUtils.isEmpty(strF)) {
            sb.append("trade_no=" + strF + i.b);
        }
        if (!TextUtils.isEmpty(strC)) {
            sb.append("app_userid=" + strC + i.b);
        }
        String string = sb.toString();
        return string.endsWith(i.b) ? string.substring(0, string.length() - 1) : string;
    }

    public static String b(String str) {
        String[] strArrSplit = str.split("=");
        if (strArrSplit.length <= 1) {
            return null;
        }
        String str2 = strArrSplit[1];
        return str2.contains("\"") ? str2.replaceAll("\"", "") : str2;
    }

    public static String c(String str) {
        if (str.contains("app_userid")) {
            return b(str);
        }
        return null;
    }

    public static String d(String str) {
        if (str.contains("biz_no")) {
            return b(str);
        }
        return null;
    }

    public static String e(String str) {
        if (str.contains("biz_type")) {
            return b(str);
        }
        return null;
    }

    public static String f(String str) {
        if (!str.contains(com.alipay.sdk.m.k.b.B0) || str.startsWith(com.alipay.sdk.m.k.b.A0)) {
            return null;
        }
        return b(str);
    }
}
