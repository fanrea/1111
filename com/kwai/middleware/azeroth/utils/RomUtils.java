package com.kwai.middleware.azeroth.utils;

import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class RomUtils {
    private static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    private static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    private static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    private static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    private static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    private static final String ROM_360 = "360";
    private static final String ROM_EMUI = "EMUI";
    private static final String ROM_FLYME = "FLYME";
    private static final String ROM_MIUI = "MIUI";
    private static final String ROM_ONE_PLUS = "ONEPLUS";
    private static final String ROM_OPPO = "OPPO";
    private static final String ROM_QIKU = "QIKU";
    private static final String ROM_SMARTISAN = "SMARTISAN";
    private static final String ROM_VIVO = "VIVO";
    private static String sName;
    private static String sVersion;

    public static boolean isEmui() {
        return check("EMUI");
    }

    public static boolean isMiui() {
        return check("MIUI");
    }

    public static boolean isVivo() {
        return check("VIVO");
    }

    public static boolean isOppo() {
        return check("OPPO");
    }

    public static boolean isFlyme() {
        return check("FLYME");
    }

    public static boolean is360() {
        return check("QIKU") || check(ROM_360);
    }

    public static boolean isSmartisan() {
        return check("SMARTISAN");
    }

    public static boolean isOnePlus() {
        return check(ROM_ONE_PLUS);
    }

    public static String getName() throws Throwable {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    public static String getVersion() throws Throwable {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean check(String str) throws Throwable {
        String str2 = sName;
        if (str2 != null) {
            return str2.contains(str);
        }
        String prop = getProp(KEY_VERSION_MIUI);
        sVersion = prop;
        if (!android.text.TextUtils.isEmpty(prop)) {
            sName = "MIUI";
        } else {
            String prop2 = getProp("ro.build.version.emui");
            sVersion = prop2;
            if (!android.text.TextUtils.isEmpty(prop2)) {
                sName = "EMUI";
            } else {
                String prop3 = getProp(KEY_VERSION_OPPO);
                sVersion = prop3;
                if (!android.text.TextUtils.isEmpty(prop3)) {
                    sName = "OPPO";
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sVersion = prop4;
                    if (!android.text.TextUtils.isEmpty(prop4)) {
                        sName = "VIVO";
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sVersion = prop5;
                        if (!android.text.TextUtils.isEmpty(prop5)) {
                            sName = "SMARTISAN";
                        } else {
                            String str3 = Build.DISPLAY;
                            sVersion = str3;
                            if (str3.toUpperCase().contains("FLYME")) {
                                sName = "FLYME";
                            } else {
                                sVersion = "unknown";
                                sName = Build.MANUFACTURER.toUpperCase();
                            }
                        }
                    }
                }
            }
        }
        return sName.contains(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getProp(java.lang.String r7) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.String r1 = "android.os.SystemProperties"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            java.lang.String r2 = "get"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            java.lang.reflect.Method r2 = r1.getDeclaredMethod(r2, r4)     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            r3[r6] = r7     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.reflect.InvocationTargetException -> L20 java.lang.IllegalAccessException -> L25 java.lang.NoSuchMethodException -> L2a java.lang.ClassNotFoundException -> L2f
            goto L34
        L20:
            r1 = move-exception
            r1.printStackTrace()
            goto L33
        L25:
            r1 = move-exception
            r1.printStackTrace()
            goto L33
        L2a:
            r1 = move-exception
            r1.printStackTrace()
            goto L33
        L2f:
            r1 = move-exception
            r1.printStackTrace()
        L33:
            r1 = r0
        L34:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L80
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.lang.String r4 = "getprop "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            r3.append(r7)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.lang.Process r7 = r2.exec(r7)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.io.InputStream r7 = r7.getInputStream()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            r7 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r7)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L74
            java.lang.String r7 = r2.readLine()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            java.lang.String r1 = com.kwai.middleware.azeroth.utils.TextUtils.emptyIfNull(r7)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            com.kwai.middleware.azeroth.utils.CloseableUtils.closeQuietly(r2)
            goto L80
        L6c:
            r7 = move-exception
            r0 = r2
            goto L7c
        L6f:
            r7 = move-exception
            r0 = r2
            goto L75
        L72:
            r7 = move-exception
            goto L7c
        L74:
            r7 = move-exception
        L75:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L72
            com.kwai.middleware.azeroth.utils.CloseableUtils.closeQuietly(r0)
            goto L80
        L7c:
            com.kwai.middleware.azeroth.utils.CloseableUtils.closeQuietly(r0)
            throw r7
        L80:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.middleware.azeroth.utils.RomUtils.getProp(java.lang.String):java.lang.String");
    }

    public static boolean isMeitu() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("MEITU");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isSamsung() {
        try {
            return Build.MANUFACTURER.toUpperCase().contains("SAMSUNG");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isM5() {
        try {
            return Build.MODEL.toUpperCase().contains("M5");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
