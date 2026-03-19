package com.bykv.vk.component.ttvideo.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VersionInfo {
    private static String[] mVersion;

    /* JADX WARN: Removed duplicated region for block: B:39:0x0063 A[Catch: all -> 0x0067, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0067, blocks: (B:9:0x002c, B:13:0x0034, B:39:0x0063, B:29:0x0051, B:8:0x0029, B:24:0x0047), top: B:57:0x000e, inners: #0, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] getVersion() {
        /*
            java.lang.String[] r0 = com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion
            if (r0 != 0) goto L7b
            java.lang.String r0 = "null"
            java.lang.String[] r0 = new java.lang.String[]{r0, r0, r0, r0}
            java.lang.String r1 = "/proc/version"
            r2 = 2
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L44
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L44
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L45
            r5 = 8192(0x2000, float:1.148E-41)
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "\\s+"
            java.lang.String[] r3 = r3.split(r5)     // Catch: java.lang.Throwable -> L42
            r5 = 0
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L42
            r0[r5] = r3     // Catch: java.lang.Throwable -> L42
            r1.close()     // Catch: java.lang.Throwable -> L30
            r4.close()     // Catch: java.lang.Throwable -> L67
            goto L6b
        L30:
            r1 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r1)     // Catch: java.lang.Throwable -> L38
            r4.close()     // Catch: java.lang.Throwable -> L67
            goto L6b
        L38:
            r0 = move-exception
            r4.close()     // Catch: java.lang.Throwable -> L3d
            goto L41
        L3d:
            r1 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r1)
        L41:
            throw r0
        L42:
            r3 = r1
            goto L45
        L44:
            r4 = r3
        L45:
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.lang.Throwable -> L4b
            goto L61
        L4b:
            r1 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r1)     // Catch: java.lang.Throwable -> L55
            if (r4 == 0) goto L6b
            r4.close()     // Catch: java.lang.Throwable -> L67
            goto L6b
        L55:
            r0 = move-exception
            if (r4 == 0) goto L60
            r4.close()     // Catch: java.lang.Throwable -> L5c
            goto L60
        L5c:
            r1 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r1)
        L60:
            throw r0
        L61:
            if (r4 == 0) goto L6b
            r4.close()     // Catch: java.lang.Throwable -> L67
            goto L6b
        L67:
            r1 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r1)
        L6b:
            r1 = 1
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            r0[r1] = r3
            java.lang.String r1 = android.os.Build.MODEL
            r0[r2] = r1
            r1 = 3
            java.lang.String r2 = android.os.Build.DISPLAY
            r0[r1] = r2
            com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion = r0
        L7b:
            java.lang.String[] r0 = com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.VersionInfo.getVersion():java.lang.String[]");
    }
}
