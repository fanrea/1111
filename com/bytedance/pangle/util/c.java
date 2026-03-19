package com.bytedance.pangle.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static <T> boolean d(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean d(T[] tArr, T t) {
        return hc(tArr, t) != -1;
    }

    public static <T> int hc(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == t || (t2 != null && t2.equals(t))) {
                return i;
            }
        }
        return -1;
    }

    public static <T> boolean d(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!d(tArr, t)) {
                return false;
            }
        }
        return true;
    }
}
