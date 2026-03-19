package com.bytedance.msdk.core;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static volatile com.bytedance.msdk.u.hc.d<com.bytedance.msdk.u.d> b;
    private static volatile Context d;
    private static volatile com.bytedance.msdk.core.k.b hc;

    public static Context getContext() {
        if (d == null) {
            d(null);
        }
        return d;
    }

    public static com.bytedance.msdk.u.hc.d<com.bytedance.msdk.u.d> d() {
        if (b == null) {
            synchronized (hc.class) {
                if (b == null) {
                    b = new com.bytedance.msdk.u.hc.hc();
                }
            }
        }
        return b;
    }

    public static synchronized void d(Context context) {
        if (d == null) {
            synchronized (hc.class) {
                if (d.d() != null) {
                    try {
                        Application applicationD = d.d();
                        d = applicationD;
                        if (applicationD != null) {
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (context != null) {
                    d = context.getApplicationContext();
                }
            }
        }
    }

    public static com.bytedance.msdk.core.k.b hc() {
        if (hc == null) {
            synchronized (com.bytedance.msdk.core.k.b.class) {
                if (hc == null) {
                    hc = new com.bytedance.msdk.core.k.b();
                }
            }
        }
        return hc;
    }

    public static class d {
        private static volatile Application d;

        public static Application d() {
            return d;
        }

        static {
            try {
                Object objHc = hc();
                d = (Application) objHc.getClass().getMethod("getApplication", new Class[0]).invoke(objHc, new Object[0]);
                com.bytedance.msdk.d.u.b.c("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.msdk.d.u.b.hc("MyApplication", "application get failed", th);
            }
        }

        private static Object hc() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.msdk.d.u.b.hc("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
