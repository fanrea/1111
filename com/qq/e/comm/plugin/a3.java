package com.qq.e.comm.plugin;

import android.content.Context;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a3 {
    private static long a(Context context, int i) {
        return pro.getJresult(403, 1, context, Integer.valueOf(i));
    }

    public static void a() {
        pro.getVresult(404, 1, new Object[0]);
    }

    static /* synthetic */ void a(int i) {
        pro.getVresult(405, 1, Integer.valueOf(i));
    }

    private static boolean a(int i, int i2) {
        return pro.getZresult(406, 1, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private static int b(Context context, int i) {
        return pro.getIresult(407, 1, context, Integer.valueOf(i));
    }

    private static void b(int i) {
        pro.getVresult(408, 1, Integer.valueOf(i));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a3.a(this.a);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }
}
