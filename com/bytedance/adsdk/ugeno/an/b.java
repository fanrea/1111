package com.bytedance.adsdk.ugeno.an;

import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    public static float d(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            mq.d(e);
            return f;
        }
    }

    public static int d(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            mq.d(e);
            return i;
        }
    }

    public static long d(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            mq.d(e);
            return j;
        }
    }

    public static double d(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            mq.d(e);
            return d;
        }
    }

    public static boolean d(String str, boolean z) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e) {
            mq.d(e);
            return z;
        }
    }
}
