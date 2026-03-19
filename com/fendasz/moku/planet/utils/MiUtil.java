package com.fendasz.moku.planet.utils;

import com.alipay.sdk.m.c.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MiUtil {
    private static final String TAG = "MiUtil==>";

    public static String miuiName() {
        return getSystemProperty("ro.miui.ui.version.name");
    }

    public static String emuiVersion() {
        return getSystemProperty(a.a);
    }

    public static String getSystemProperty(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0063: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:19:0x0063 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSystemProperty2(java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "MiUtil==>"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r4.<init>()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.String r5 = "getprop "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L62
            r4.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L62
            r4.close()     // Catch: java.io.IOException -> L3b
            goto L3e
        L3b:
            com.fendasz.moku.planet.utils.LogUtils.logE(r1, r0)
        L3e:
            return r3
        L3f:
            r6 = move-exception
            goto L64
        L41:
            r4 = r2
        L42:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r3.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r5 = "Unable to read sysprop "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r6 = r3.append(r6)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L62
            com.fendasz.moku.planet.utils.LogUtils.logE(r1, r6)     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L61
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L61
        L5e:
            com.fendasz.moku.planet.utils.LogUtils.logE(r1, r0)
        L61:
            return r2
        L62:
            r6 = move-exception
            r2 = r4
        L64:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L6a
            goto L6d
        L6a:
            com.fendasz.moku.planet.utils.LogUtils.logE(r1, r0)
        L6d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.MiUtil.getSystemProperty2(java.lang.String):java.lang.String");
    }
}
