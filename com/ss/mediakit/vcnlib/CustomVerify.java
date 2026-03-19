package com.ss.mediakit.vcnlib;

import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CustomVerify {
    public static final int CUSTOM_VERFIY_STATUS_IS_EXCEPTION = -99996;
    public static final int CUSTOM_VERFIY_STATUS_IS_GET_METHOD_EXCEPTION = -99995;
    private static Method getVerifyStatusMethod = null;
    private static boolean hasInited = false;
    private static Method verifyMethod;
    private static Class<?> verifyResultClass;

    private static final native void _init();

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.String r0 = "getStatus"
            java.lang.Class<byte[][]> r1 = byte[][].class
            java.lang.String r2 = "verifyServerCertificates"
            java.lang.String r3 = "found verify class or method exception:"
            java.lang.String r4 = "custom_verify"
            r5 = 2
            r6 = 3
            r7 = 1
            r8 = 0
            java.lang.String r9 = "com.ttnet.org.chromium.net.X509Util"
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch: java.lang.Exception -> L41
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L41
            r10[r8] = r1     // Catch: java.lang.Exception -> L41
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r7] = r11     // Catch: java.lang.Exception -> L41
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            r10[r5] = r11     // Catch: java.lang.Exception -> L41
            java.lang.reflect.Method r9 = r9.getMethod(r2, r10)     // Catch: java.lang.Exception -> L41
            com.ss.mediakit.vcnlib.CustomVerify.verifyMethod = r9     // Catch: java.lang.Exception -> L41
            java.lang.String r9 = "com.ttnet.org.chromium.net.AndroidCertVerifyResult"
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch: java.lang.Exception -> L41
            com.ss.mediakit.vcnlib.CustomVerify.verifyResultClass = r9     // Catch: java.lang.Exception -> L41
            java.lang.Class[] r10 = new java.lang.Class[r8]     // Catch: java.lang.Exception -> L41
            java.lang.reflect.Method r9 = r9.getMethod(r0, r10)     // Catch: java.lang.Exception -> L41
            com.ss.mediakit.vcnlib.CustomVerify.getVerifyStatusMethod = r9     // Catch: java.lang.Exception -> L41
            java.lang.String r9 = "find ttnet verify suc"
            android.util.Log.e(r4, r9)     // Catch: java.lang.Exception -> L3e
            r10 = r7
            goto L60
        L3e:
            r9 = move-exception
            r10 = r7
            goto L43
        L41:
            r9 = move-exception
            r10 = r8
        L43:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.StringBuilder r11 = r11.append(r3)
            java.lang.String r9 = r9.getMessage()
            java.lang.StringBuilder r9 = r11.append(r9)
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r4, r9)
            java.lang.String r9 = "find ttnet verify fail"
            android.util.Log.e(r4, r9)
        L60:
            if (r10 != 0) goto Lae
            java.lang.String r9 = "com.ss.mediakit.vcnlib.X509Util"
            java.lang.Class r9 = java.lang.Class.forName(r9)     // Catch: java.lang.Exception -> L90
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L90
            r6[r8] = r1     // Catch: java.lang.Exception -> L90
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r6[r7] = r1     // Catch: java.lang.Exception -> L90
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            r6[r5] = r1     // Catch: java.lang.Exception -> L90
            java.lang.reflect.Method r1 = r9.getMethod(r2, r6)     // Catch: java.lang.Exception -> L90
            com.ss.mediakit.vcnlib.CustomVerify.verifyMethod = r1     // Catch: java.lang.Exception -> L90
            java.lang.String r1 = "com.ss.mediakit.vcnlib.AndroidCertVerifyResult"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L90
            com.ss.mediakit.vcnlib.CustomVerify.verifyResultClass = r1     // Catch: java.lang.Exception -> L90
            java.lang.Class[] r2 = new java.lang.Class[r8]     // Catch: java.lang.Exception -> L90
            java.lang.reflect.Method r0 = r1.getMethod(r0, r2)     // Catch: java.lang.Exception -> L90
            com.ss.mediakit.vcnlib.CustomVerify.getVerifyStatusMethod = r0     // Catch: java.lang.Exception -> L90
            java.lang.String r0 = "find default verify suc"
            android.util.Log.e(r4, r0)     // Catch: java.lang.Exception -> L90
            goto Lae
        L90:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r4, r0)
            java.lang.String r0 = "find default verify fail"
            android.util.Log.e(r4, r0)
        Lae:
            com.ss.mediakit.vcnlib.CustomVerify.hasInited = r7
            java.lang.reflect.Method r0 = com.ss.mediakit.vcnlib.CustomVerify.verifyMethod
            if (r0 == 0) goto Lbd
            java.lang.Class<?> r0 = com.ss.mediakit.vcnlib.CustomVerify.verifyResultClass
            if (r0 == 0) goto Lbd
            java.lang.String r0 = "get verify method or verify result class suc"
            android.util.Log.e(r4, r0)
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.mediakit.vcnlib.CustomVerify.<clinit>():void");
    }

    public static int doVerify(byte[][] bArr, String str, String str2) {
        if (verifyMethod == null || verifyResultClass == null || getVerifyStatusMethod == null) {
            Log.e("custom_verify", "verify method is null ecception");
            return -99995;
        }
        try {
            Log.e("custom_verify", "host: " + str2 + "  authType: " + str);
            Object objInvoke = verifyMethod.invoke(null, bArr, str, str2);
            Log.e("custom_verify", "get status end");
            int iIntValue = ((Integer) getVerifyStatusMethod.invoke(objInvoke, new Object[0])).intValue();
            Log.e("custom_verify", "verify result status: " + iIntValue);
            return iIntValue;
        } catch (Throwable th) {
            th.printStackTrace();
            Log.e("custom_verify", "verify exception stacktrace:" + th.getMessage());
            return -99996;
        }
    }

    public static void init() {
        Log.e("custom_verify", "start init native");
        _init();
        Log.e("custom_verify", "end init native");
    }
}
