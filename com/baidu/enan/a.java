package com.baidu.enan;

import android.content.Context;
import com.baidu.enan.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static volatile boolean a = false;
    private static Context b;

    public static String a() {
        Context context;
        try {
            if (!a || (context = b) == null) {
                return "";
            }
            c.b(context);
            return c.a(b);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    public static void a(int i, String str) {
        try {
            if (a) {
                c.a(i, str);
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }

    public static void a(Context context, int i) {
        if (a) {
            return;
        }
        synchronized (a.class) {
            if (!a) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    b = applicationContext;
                    c.a(applicationContext, i);
                    a = true;
                } catch (Throwable th) {
                    com.baidu.enan.f.a.a(th);
                }
            }
        }
    }

    public static String b() {
        try {
            return !a ? "" : com.baidu.ad.magic.flute.a.f;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return com.baidu.ad.magic.flute.a.f;
        }
    }
}
