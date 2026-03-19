package ca.da.da;

import android.content.Context;
import ca.da.da.n;
import com.bytedance.apm.common.utility.PackageUtils;

/* compiled from: HWOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class h implements n {
    public static final ca.da.da.b<Boolean> a = new a();

    /* compiled from: HWOaidImpl.java */
    public static class a extends ca.da.da.b<Boolean> {
        @Override // ca.da.da.b
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf(PackageUtils.existsPackage((Context) objArr[0], "com.huawei.hwid"));
        }
    }

    /* compiled from: HWOaidImpl.java */
    public static class b extends n.a {
        public long c = 0;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return a.b(context).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    @Override // ca.da.da.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ca.da.da.n.a a(android.content.Context r6) {
        /*
            r5 = this;
            ca.da.da.h$b r0 = new ca.da.da.h$b
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r1 < r2) goto L3b
            android.content.ContentResolver r1 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L37
            java.lang.String r2 = "pps_oaid"
            java.lang.String r1 = android.provider.Settings.Global.getString(r1, r2)     // Catch: java.lang.Throwable -> L37
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L37
            java.lang.String r3 = "pps_track_limit"
            java.lang.String r2 = android.provider.Settings.Global.getString(r2, r3)     // Catch: java.lang.Throwable -> L37
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L37
            if (r3 != 0) goto L3b
            r0.a = r1     // Catch: java.lang.Throwable -> L37
            boolean r1 = java.lang.Boolean.parseBoolean(r2)     // Catch: java.lang.Throwable -> L37
            r0.b = r1     // Catch: java.lang.Throwable -> L37
            r1 = 202003021704(0x2f08517f88, double:9.980275338E-313)
            r0.c = r1     // Catch: java.lang.Throwable -> L37
            goto L7b
        L37:
            r1 = move-exception
            r1.printStackTrace()
        L3b:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "com.uodis.opendevice.OPENIDS_SERVICE"
            r1.<init>(r2)
            java.lang.String r2 = "com.huawei.hwid"
            android.content.Intent r1 = r1.setPackage(r2)
            ca.da.da.v r3 = new ca.da.da.v
            ca.da.da.i r4 = new ca.da.da.i
            r4.<init>()
            r3.<init>(r6, r1, r4)
            java.lang.Object r1 = r3.a()
            android.util.Pair r1 = (android.util.Pair) r1
            if (r1 == 0) goto L7b
            java.lang.Object r3 = r1.first
            java.lang.String r3 = (java.lang.String) r3
            r0.a = r3
            java.lang.Object r1 = r1.second
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.b = r1
            r1 = 0
            android.content.pm.PackageInfo r6 = com.bytedance.apm.common.utility.PackageUtils.getPackageInfo(r6, r2)     // Catch: java.lang.Exception -> L74
            if (r6 == 0) goto L78
            int r1 = r6.versionCode     // Catch: java.lang.Exception -> L74
            goto L78
        L74:
            r6 = move-exception
            r6.printStackTrace()
        L78:
            long r1 = (long) r1
            r0.c = r1
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.da.h.a(android.content.Context):ca.da.da.n$a");
    }

    @Override // ca.da.da.n
    public boolean b(Context context) {
        return c(context);
    }
}
