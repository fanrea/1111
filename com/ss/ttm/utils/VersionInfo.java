package com.ss.ttm.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VersionInfo {
    private static String[] mVersion;

    /* JADX WARN: Removed duplicated region for block: B:41:0x0068 A[Catch: all -> 0x0030, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0030, blocks: (B:9:0x002c, B:15:0x0039, B:41:0x0068, B:31:0x0056, B:26:0x004c, B:8:0x0029), top: B:48:0x000e, inners: #0, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] getVersion() {
        /*
            java.lang.String[] r0 = com.ss.ttm.utils.VersionInfo.mVersion
            if (r0 != 0) goto L7b
            java.lang.String r0 = "null"
            java.lang.String[] r0 = new java.lang.String[]{r0, r0, r0, r0}
            java.lang.String r1 = "/proc/version"
            r2 = 2
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L49
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L49
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4a
            r5 = 8192(0x2000, float:1.148E-41)
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch: java.lang.Throwable -> L47
            r5 = 0
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L47
            r0[r5] = r3     // Catch: java.lang.Throwable -> L47
            r1.close()     // Catch: java.lang.Throwable -> L35
            r4.close()     // Catch: java.lang.Throwable -> L30
            goto L6b
        L30:
            r1 = move-exception
            r1.printStackTrace()
            goto L6b
        L35:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            r4.close()     // Catch: java.lang.Throwable -> L30
            goto L6b
        L3d:
            r0 = move-exception
            r4.close()     // Catch: java.lang.Throwable -> L42
            goto L46
        L42:
            r1 = move-exception
            r1.printStackTrace()
        L46:
            throw r0
        L47:
            r3 = r1
            goto L4a
        L49:
            r4 = r3
        L4a:
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Throwable -> L50
            goto L66
        L50:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            if (r4 == 0) goto L6b
            r4.close()     // Catch: java.lang.Throwable -> L30
            goto L6b
        L5a:
            r0 = move-exception
            if (r4 == 0) goto L65
            r4.close()     // Catch: java.lang.Throwable -> L61
            goto L65
        L61:
            r1 = move-exception
            r1.printStackTrace()
        L65:
            throw r0
        L66:
            if (r4 == 0) goto L6b
            r4.close()     // Catch: java.lang.Throwable -> L30
        L6b:
            r1 = 1
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            r0[r1] = r3
            java.lang.String r1 = android.os.Build.MODEL
            r0[r2] = r1
            r1 = 3
            java.lang.String r2 = android.os.Build.DISPLAY
            r0[r1] = r2
            com.ss.ttm.utils.VersionInfo.mVersion = r0
        L7b:
            java.lang.String[] r0 = com.ss.ttm.utils.VersionInfo.mVersion
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.utils.VersionInfo.getVersion():java.lang.String[]");
    }
}
