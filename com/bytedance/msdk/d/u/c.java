package com.bytedance.msdk.d.u;

import java.util.IllegalFormatException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class c {
    public static void d(Object obj) {
        d(obj, true, "Object can not be null.", "");
    }

    private static boolean d(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String strD = d(str, objArr);
        if (z) {
            throw new NullPointerException(strD);
        }
        b.c("TTMediationSDK_ADAPTER", strD);
        return false;
    }

    private static String d(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException e) {
            b.c("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e.getMessage());
            return strValueOf;
        }
    }
}
