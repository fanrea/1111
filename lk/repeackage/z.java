package lk.repeackage;

import android.net.Uri;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class z {
    public static final Uri a;

    static {
        new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();
        a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r5, android.net.Uri r6) {
        /*
            r0 = 0
            if (r5 == 0) goto La9
            if (r6 == 0) goto La9
            int r1 = lk.repeackage.a0.a
            java.lang.String r1 = "StmUt"
            if (r5 != 0) goto Lc
            goto L66
        Lc:
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = lk.repeackage.g.c(r5)     // Catch: java.lang.Throwable -> L47
            r4 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r3, r4)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L66
            android.os.Bundle r2 = r2.metaData     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L66
            java.lang.String r3 = "ppskit_ver_code"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L66
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r3.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = "ppskit_ver_code:"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L47
            java.lang.StringBuilder r3 = r3.append(r2)     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L47
            lk.repeackage.f.a(r3)     // Catch: java.lang.Throwable -> L47
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L47
            goto L67
        L47:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getPpsKitVerCode ex: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r1, r2)
        L66:
            r2 = 0
        L67:
            r3 = 1
            if (r2 == 0) goto La9
            int r2 = r2.intValue()
            r4 = 30462100(0x1d0d094, float:7.670643E-38)
            if (r4 > r2) goto La9
            if (r5 == 0) goto La9
            if (r6 == 0) goto La9
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            java.lang.String r6 = r6.getAuthority()
            android.content.pm.ProviderInfo r6 = r2.resolveContentProvider(r6, r0)
            if (r6 != 0) goto L8b
            java.lang.String r5 = "verify provider invalid param"
            android.util.Log.e(r1, r5)
            goto La9
        L8b:
            android.content.pm.ApplicationInfo r6 = r6.applicationInfo
            if (r6 != 0) goto L90
            goto La9
        L90:
            java.lang.String r1 = r6.packageName
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L99
            goto La9
        L99:
            java.lang.String r5 = r5.getPackageName()
            int r5 = r2.checkSignatures(r5, r1)
            if (r5 == 0) goto La8
            int r5 = r6.flags
            r5 = r5 & r3
            if (r5 != r3) goto La9
        La8:
            r0 = r3
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lk.repeackage.z.a(android.content.Context, android.net.Uri):boolean");
    }
}
