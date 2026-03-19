package com.bytedance.msdk.hc;

import android.text.TextUtils;
import com.bytedance.msdk.gb.fs;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static final String d = fs.c();
    public static boolean hc = true;

    public static int d() {
        return Integer.parseInt(hc().replace(".", ""));
    }

    public static String hc() {
        return com.bytedance.sdk.gromore.init.d.b();
    }

    public static String b() {
        if (TextUtils.isEmpty(hc())) {
            return "";
        }
        String[] strArrSplit = hc().split("\\.");
        if (strArrSplit.length < 4) {
            return "";
        }
        return strArrSplit[0] + "." + strArrSplit[1] + "." + strArrSplit[2];
    }

    public static String c() {
        return com.bytedance.sdk.gromore.init.d.c();
    }
}
