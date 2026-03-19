package com.bytedance.sdk.djx.core.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class MathUtils {
    public static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static boolean isInteger(String str) throws NumberFormatException {
        if (str != null && !str.isEmpty()) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public static boolean isLong(String str) throws NumberFormatException {
        if (str != null && !str.isEmpty()) {
            try {
                Long.parseLong(str);
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }
}
