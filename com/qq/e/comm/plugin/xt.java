package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xt {
    private static volatile Boolean a;

    public static void a(Context context) {
        if (context != null) {
            int i = context.getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT < 30 || i < 30) {
                return;
            }
            b10.a(1130005, null, Integer.valueOf(c(context) ? 1 : -1));
        }
    }

    private static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return false;
        }
        Context contextA = r1.d().a();
        if (contextA.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            return false;
        }
        int i2 = contextA.getApplicationInfo().targetSdkVersion;
        if (i < 29 || i2 < 29) {
            return true;
        }
        return i2 == 29 && Environment.isExternalStorageLegacy();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        com.qq.e.comm.plugin.xt.a = java.lang.Boolean.TRUE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            java.lang.Boolean r1 = com.qq.e.comm.plugin.xt.a
            if (r1 != 0) goto L3f
            java.lang.Class<com.qq.e.comm.plugin.k> r1 = com.qq.e.comm.plugin.k.class
            monitor-enter(r1)
            java.lang.Boolean r2 = com.qq.e.comm.plugin.xt.a     // Catch: java.lang.Throwable -> L3c
            if (r2 != 0) goto L3a
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L3c
            com.qq.e.comm.plugin.xt.a = r2     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> L3c
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L3a
            r3 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r2, r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.String[] r5 = r5.requestedPermissions     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L3a
            int r2 = r5.length     // Catch: java.lang.Throwable -> L3a
        L26:
            if (r0 >= r2) goto L3a
            r3 = r5[r0]     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "android.permission.QUERY_ALL_PACKAGES"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L3a
            if (r3 == 0) goto L37
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L3a
            com.qq.e.comm.plugin.xt.a = r5     // Catch: java.lang.Throwable -> L3a
            goto L3a
        L37:
            int r0 = r0 + 1
            goto L26
        L3a:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L3c
            goto L3f
        L3c:
            r5 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L3c
            throw r5
        L3f:
            java.lang.Boolean r5 = com.qq.e.comm.plugin.xt.a
            boolean r5 = r5.booleanValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.xt.c(android.content.Context):boolean");
    }

    public static boolean b(Context context) {
        if (context != null) {
            return Build.VERSION.SDK_INT < 30 || context.getApplicationInfo().targetSdkVersion < 30 || c(context);
        }
        return true;
    }

    public static void b() {
        int iA = yy.a("estop", 0);
        int i = 1;
        int i2 = a() ? 1 : -1;
        if (iA != i2) {
            yy.b("estop", i2);
        }
        if (iA != 0 && iA != i2) {
            i = -1;
        }
        b10.a(9200002, null, Integer.valueOf(i2), Integer.valueOf(i), null);
    }
}
