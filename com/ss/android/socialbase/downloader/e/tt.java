package com.ss.android.socialbase.downloader.e;

import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt {
    public static StringBuilder d(StringBuilder sb, String str) {
        sb.append('\"').append(str).append('\"');
        return sb;
    }

    public static StringBuilder d(StringBuilder sb, String str, String str2) {
        sb.append(str).append(".\"").append(str2).append('\"');
        return sb;
    }

    public static StringBuilder d(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append('\"').append(strArr[i]).append('\"');
            if (i < length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    public static StringBuilder d(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder hc(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            d(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    public static StringBuilder d(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            d(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        return sb;
    }

    public static String d(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"').append(str2).append('\"').append(" (");
        d(sb, strArr);
        sb.append(") VALUES (");
        d(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String d(String str, String[] strArr) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            d(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String d(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2).append(" SET ");
        hc(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            d(sb, str2, strArr2);
        }
        return sb.toString();
    }

    public static String hc(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + '\"').append(" (");
        d(sb, strArr);
        sb.append(") VALUES (");
        d(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }
}
