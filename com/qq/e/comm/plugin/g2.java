package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.File;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class g2 {
    private static final long a = System.currentTimeMillis();
    private static Context b;
    private static String c;
    private static int d;
    private static boolean e;
    private static String f;
    private static String g;
    private static long[] h;
    private static long i;
    private static File j;
    private static String k;
    private static String[] l;

    static void a(Object[] objArr) throws Exception {
        pro.getVresult(270, 1, objArr);
    }

    public static String b() {
        return f;
    }

    public static File c() {
        if (j == null) {
            j = new File(g, "cd");
        }
        j.mkdirs();
        return j;
    }

    public static long d() {
        return i;
    }

    public static String e() {
        return k;
    }

    public static long f() {
        return a;
    }

    public static long[] g() {
        return h;
    }

    public static int h() {
        return d;
    }

    public static String[] i() {
        return l;
    }

    public static String j() {
        return c;
    }

    public static boolean k() {
        return e;
    }

    private static long[] a(String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return new long[]{ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT};
        }
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        if (length % 2 == 0) {
            return new long[]{ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT};
        }
        long[] jArr = new long[length];
        int i2 = length - 1;
        jArr[i2] = Long.parseLong(strArrSplit[i2]);
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = Long.parseLong(strArrSplit[i3]);
            if (i3 % 2 == 0) {
                jArr[i3] = j2 + a;
            } else {
                jArr[i3] = j2;
            }
        }
        return jArr;
    }

    public static Context a() {
        return b;
    }
}
