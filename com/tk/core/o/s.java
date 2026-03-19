package com.tk.core.o;

import android.app.Application;
import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class s {
    static Context ajt;

    public static void d(Context context) {
        ajt = context.getApplicationContext();
    }

    public static Context getContext() {
        Context context = ajt;
        if (context != null) {
            return context;
        }
        try {
            Application application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
            if (application != null) {
                ajt = application;
                return application;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Application application2 = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, null);
            if (application2 != null) {
                ajt = application2;
                return application2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        throw new IllegalStateException("ContextHolder is not initialed, it is recommend to init with application context.");
    }
}
