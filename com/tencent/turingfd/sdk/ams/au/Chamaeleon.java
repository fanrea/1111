package com.tencent.turingfd.sdk.ams.au;

import com.alipay.sdk.m.u.i;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Chamaeleon {
    public static String a(String str) {
        int iIndexOf;
        String[] strArrSplit = str.split(" ", 3);
        if (strArrSplit.length <= 2 || !"rwxp".equals(strArrSplit[1]) || (iIndexOf = strArrSplit[2].indexOf(47)) == -1) {
            return null;
        }
        String strTrim = strArrSplit[2].substring(iIndexOf).trim();
        if (strTrim.startsWith("/data/")) {
            return null;
        }
        return strArrSplit[1] + i.b + strTrim;
    }
}
