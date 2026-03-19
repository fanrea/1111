package com.bytedance.common.utility.device;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CmdSystemProperties {
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private static final String TAG = "CmdSystemProperties";

    private CmdSystemProperties() {
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x006a: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x006a */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String getSystemProperty(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "CmdSystemProperties"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r4.<init>()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r5 = "getprop "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r6 = "UTF-8"
            r5.<init>(r3, r6)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L69
            r4.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L69
            r4.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r7 = move-exception
            android.util.Log.e(r1, r0, r7)
        L41:
            return r3
        L42:
            r3 = move-exception
            goto L48
        L44:
            r7 = move-exception
            goto L6b
        L46:
            r3 = move-exception
            r4 = r2
        L48:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r5.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.String r6 = "Unable to read sysprop "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L69
            java.lang.StringBuilder r7 = r5.append(r7)     // Catch: java.lang.Throwable -> L69
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L69
            android.util.Log.e(r1, r7, r3)     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L68
            r4.close()     // Catch: java.io.IOException -> L64
            goto L68
        L64:
            r7 = move-exception
            android.util.Log.e(r1, r0, r7)
        L68:
            return r2
        L69:
            r7 = move-exception
            r2 = r4
        L6b:
            if (r2 == 0) goto L75
            r2.close()     // Catch: java.io.IOException -> L71
            goto L75
        L71:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L75:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.utility.device.CmdSystemProperties.getSystemProperty(java.lang.String):java.lang.String");
    }
}
