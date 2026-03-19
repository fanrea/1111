package com.baidu.mobads.container.util;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class az {
    private static final String a = "mobads_limitpersonalads";
    private static final String b = "limit";
    private static boolean c = false;
    private static com.baidu.mobads.container.b.a.a d;

    public static boolean a(Context context) {
        try {
            if (d == null) {
                d = new com.baidu.mobads.container.b.a.a(context.getApplicationContext(), a);
                if (d.b(b).longValue() == 1) {
                    c = true;
                }
            }
            return c;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void a(Context context, boolean z) {
        long j;
        try {
            if (d == null) {
                d = new com.baidu.mobads.container.b.a.a(context.getApplicationContext(), a);
            }
            if (!z) {
                j = 0;
            } else {
                j = 1;
            }
            d.a(b, Long.valueOf(j));
            c = z;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
