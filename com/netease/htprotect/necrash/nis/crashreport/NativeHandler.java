package com.netease.htprotect.necrash.nis.crashreport;

import android.os.Build;
import android.text.TextUtils;
import com.netease.htprotect.necrash.nis.p003O8oO888.o8o0;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class NativeHandler {

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final String f164Ooo = "NativeHandler";

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static final NativeHandler f165o0o0 = new NativeHandler();

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private boolean f166O8oO888 = false;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private Oo0 f167O8;

    private NativeHandler() {
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    static NativeHandler m596O8oO888() {
        return f165o0o0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m597O8oO888(String str, String str2) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return str2;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return str2;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return str2;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return str2;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m598O8oO888(String str) {
        Oo0 oo0 = f165o0o0.f167O8;
        if (oo0 != null) {
            try {
                oo0.mo612O8oO888(str);
            } catch (Exception e) {
                o8o0.m582Ooo(f164Ooo, "NativeHandler native crash callback.onCrash failed" + e.getMessage());
            }
        }
    }

    private static native int nativeInit(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, String[] strArr, boolean z8, boolean z9, int i6, int i7, int i8, boolean z10, boolean z11);

    private static native void nativeNotifyJavaCrashed();

    private static native void nativeTestCrash(int i);

    /* renamed from: 〇O8, reason: contains not printable characters */
    private static String m599O8() {
        if (Build.VERSION.SDK_INT >= 21) {
            return TextUtils.join(",", Build.SUPPORTED_ABIS);
        }
        String str = Build.CPU_ABI;
        String str2 = Build.CPU_ABI2;
        return TextUtils.isEmpty(str2) ? str : str + "," + str2;
    }

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private static boolean m600o0o0() {
        return !TextUtils.isEmpty(m597O8oO888("ro.miui.ui.version.name", ""));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: 〇oO, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m601oO() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.SecurityException {
        /*
            java.lang.String r0 = "ro.miui.ui.version.name"
            java.lang.String r1 = ""
            java.lang.String r0 = m597O8oO888(r0, r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            r0 = r0 ^ r2
            if (r0 == 0) goto L6c
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.String r3 = "get"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r2] = r6     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.reflect.Method r3 = r0.getDeclaredMethod(r3, r5)     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.String r6 = "ro.product.marketname"
            r5[r7] = r6     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            r5[r2] = r1     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.Object r5 = r3.invoke(r0, r5)     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.ClassNotFoundException -> L54 java.lang.IllegalAccessException -> L5a java.lang.NoSuchMethodException -> L60 java.lang.reflect.InvocationTargetException -> L66
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.ClassNotFoundException -> L4c java.lang.IllegalAccessException -> L4e java.lang.NoSuchMethodException -> L50 java.lang.reflect.InvocationTargetException -> L52
            if (r6 == 0) goto L6e
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.ClassNotFoundException -> L4c java.lang.IllegalAccessException -> L4e java.lang.NoSuchMethodException -> L50 java.lang.reflect.InvocationTargetException -> L52
            java.lang.String r6 = "ro.product.model"
            r4[r7] = r6     // Catch: java.lang.ClassNotFoundException -> L4c java.lang.IllegalAccessException -> L4e java.lang.NoSuchMethodException -> L50 java.lang.reflect.InvocationTargetException -> L52
            r4[r2] = r1     // Catch: java.lang.ClassNotFoundException -> L4c java.lang.IllegalAccessException -> L4e java.lang.NoSuchMethodException -> L50 java.lang.reflect.InvocationTargetException -> L52
            java.lang.Object r0 = r3.invoke(r0, r4)     // Catch: java.lang.ClassNotFoundException -> L4c java.lang.IllegalAccessException -> L4e java.lang.NoSuchMethodException -> L50 java.lang.reflect.InvocationTargetException -> L52
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.ClassNotFoundException -> L4c java.lang.IllegalAccessException -> L4e java.lang.NoSuchMethodException -> L50 java.lang.reflect.InvocationTargetException -> L52
            r5 = r0
            goto L6e
        L4c:
            r0 = move-exception
            goto L56
        L4e:
            r0 = move-exception
            goto L5c
        L50:
            r0 = move-exception
            goto L62
        L52:
            r0 = move-exception
            goto L68
        L54:
            r0 = move-exception
            r5 = r1
        L56:
            r0.printStackTrace()
            goto L6e
        L5a:
            r0 = move-exception
            r5 = r1
        L5c:
            r0.printStackTrace()
            goto L6e
        L60:
            r0 = move-exception
            r5 = r1
        L62:
            r0.printStackTrace()
            goto L6e
        L66:
            r0 = move-exception
            r5 = r1
        L68:
            r0.printStackTrace()
            goto L6e
        L6c:
            java.lang.String r5 = android.os.Build.MODEL
        L6e:
            if (r5 != 0) goto L71
            goto L72
        L71:
            r1 = r5
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.necrash.nis.crashreport.NativeHandler.m601oO():java.lang.String");
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final int m602O8oO888(String str, String str2, Oo0 oo0) {
        int i;
        String str3;
        String strJoin;
        try {
            System.loadLibrary("htpcrash");
            this.f167O8 = oo0;
            try {
                i = Build.VERSION.SDK_INT;
                str3 = Build.VERSION.RELEASE;
                if (Build.VERSION.SDK_INT >= 21) {
                    strJoin = TextUtils.join(",", Build.SUPPORTED_ABIS);
                } else {
                    strJoin = Build.CPU_ABI;
                    String str4 = Build.CPU_ABI2;
                    if (!TextUtils.isEmpty(str4)) {
                        strJoin = strJoin + "," + str4;
                    }
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (nativeInit(i, str3, strJoin, Build.MANUFACTURER, Build.BRAND, m601oO(), Build.FINGERPRINT, "", "", str2, str, true, true, 0, 0, 0, false, false, false, false, false, 0, new String[]{"^com\\.netease.\\necrash.\\demo$", "^Signal Catcher$", "^Jit thread pool$", ".*(R|r)ender.*", ".*Chrome.*"}, false, false, 0, 0, 0, false, false) != 0) {
                    o8o0.m582Ooo(f164Ooo, "NativeHandler init failed");
                    return -3;
                }
                this.f166O8oO888 = true;
                return 0;
            } catch (Throwable th2) {
                th = th2;
                o8o0.m582Ooo(f164Ooo, "NativeHandler init failed" + th.getMessage());
                return -3;
            }
        } catch (Throwable th3) {
            o8o0.m582Ooo(f164Ooo, "NativeHandler System.loadLibrary failed" + th3.getMessage());
            return -2;
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    final void m603Ooo() {
        if (this.f166O8oO888) {
            nativeTestCrash(0);
        }
    }
}
