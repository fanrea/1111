package com.baidu.enan.e.d;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends HandlerThread {
    private static a a;
    private static Handler b;

    private a() {
        super("BackgroundThread", 10);
    }

    public static a a() {
        a aVar;
        try {
            synchronized (a.class) {
                c();
                aVar = a;
            }
            return aVar;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return a;
        }
    }

    public static Handler b() {
        Handler handler;
        try {
            synchronized (a.class) {
                c();
                handler = b;
            }
            return handler;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return b;
        }
    }

    private static void c() {
        if (a == null) {
            a aVar = new a();
            a = aVar;
            aVar.start();
            b = new Handler(a.getLooper());
        }
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            b().post(runnable);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }
}
