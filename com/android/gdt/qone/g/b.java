package com.android.gdt.qone.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class b {
    public static boolean a(Context context, String str) {
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = packageManager.getPackageInfo(str, 128);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.android.gdt.qone.af.b.a("getPackageInfo NameNotFoundException");
            } catch (Throwable unused2) {
                com.android.gdt.qone.af.b.a("getPackageInfo Exception");
            }
        }
        return packageInfo != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.android.gdt.qone.g.a a(android.content.Context r6) {
        /*
            java.lang.String r0 = "com.huawei.hwid.tv"
            java.lang.String r1 = "com.huawei.hms"
            java.lang.String r2 = "com.huawei.hwid"
            android.os.Looper r3 = android.os.Looper.myLooper()
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            r5 = 0
            if (r3 != r4) goto L17
            java.lang.String r6 = "Cannot be called from the main thread"
            com.android.gdt.qone.af.b.a(r6)
            return r5
        L17:
            boolean r3 = a(r6, r2)     // Catch: java.lang.Throwable -> Laf
            if (r3 == 0) goto L1f
        L1d:
            r0 = r2
            goto L2d
        L1f:
            boolean r3 = a(r6, r1)     // Catch: java.lang.Throwable -> Laf
            if (r3 == 0) goto L27
            r0 = r1
            goto L2d
        L27:
            boolean r1 = a(r6, r0)     // Catch: java.lang.Throwable -> Laf
            if (r1 == 0) goto L1d
        L2d:
            android.content.pm.PackageManager r1 = r6.getPackageManager()     // Catch: java.lang.Throwable -> Laf
            r2 = 128(0x80, float:1.8E-43)
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r0, r2)     // Catch: java.lang.Throwable -> Laf
            if (r1 != 0) goto L3a
            return r5
        L3a:
            com.android.gdt.qone.g.d r1 = new com.android.gdt.qone.g.d
            r1.<init>()
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "com.uodis.opendevice.OPENIDS_SERVICE"
            r2.<init>(r3)
            r2.setPackage(r0)
            r0 = 1
            boolean r2 = r6.bindService(r2, r1, r0)
            if (r2 == 0) goto La9
            java.lang.String r2 = "bind ok"
            com.android.gdt.qone.af.b.b(r2)
            boolean r2 = r1.a     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            if (r2 == 0) goto L5d
            r6.unbindService(r1)     // Catch: java.lang.Throwable -> L5c
        L5c:
            return r5
        L5d:
            r1.a = r0     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            java.util.concurrent.LinkedBlockingQueue r0 = r1.b     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            java.lang.Object r0 = r0.take()     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            android.os.IBinder r0 = (android.os.IBinder) r0     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            int r2 = com.android.gdt.qone.g.h.a     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            if (r0 != 0) goto L6d
            r2 = r5
            goto L81
        L6d:
            java.lang.String r2 = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            if (r2 == 0) goto L7c
            boolean r3 = r2 instanceof com.android.gdt.qone.g.i     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            if (r3 == 0) goto L7c
            com.android.gdt.qone.g.i r2 = (com.android.gdt.qone.g.i) r2     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            goto L81
        L7c:
            com.android.gdt.qone.g.g r2 = new com.android.gdt.qone.g.g     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
        L81:
            com.android.gdt.qone.g.g r2 = (com.android.gdt.qone.g.g) r2     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            java.lang.String r0 = r2.b()     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            boolean r2 = r2.a()     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            com.android.gdt.qone.g.a r3 = new com.android.gdt.qone.g.a     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            r3.<init>(r0, r2)     // Catch: java.lang.Throwable -> L95 android.os.RemoteException -> L9b
            r6.unbindService(r1)     // Catch: java.lang.Throwable -> L93
        L93:
            r5 = r3
            goto La3
        L95:
            java.lang.String r0 = "bind hms service InterruptedException"
            com.android.gdt.qone.af.b.a(r0)     // Catch: java.lang.Throwable -> La4
            goto La0
        L9b:
            java.lang.String r0 = "bind hms service RemoteException"
            com.android.gdt.qone.af.b.a(r0)     // Catch: java.lang.Throwable -> La4
        La0:
            r6.unbindService(r1)     // Catch: java.lang.Throwable -> La3
        La3:
            return r5
        La4:
            r0 = move-exception
            r6.unbindService(r1)     // Catch: java.lang.Throwable -> La8
        La8:
            throw r0
        La9:
            java.lang.String r6 = "bind failed"
            com.android.gdt.qone.af.b.a(r6)
            return r5
        Laf:
            java.lang.String r6 = "pkg not found"
            com.android.gdt.qone.af.b.a(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.g.b.a(android.content.Context):com.android.gdt.qone.g.a");
    }
}
