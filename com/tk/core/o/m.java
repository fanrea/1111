package com.tk.core.o;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.DeviceUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class m {
    private static final ConcurrentHashMap<String, String> aje = new ConcurrentHashMap<>();
    private static String ajf;
    private static String ajg;
    private static String ajh;
    private static String aji;
    private static String ajj;

    public static boolean sG() {
        return cX(DeviceUtils.ROM_MIUI);
    }

    public static boolean sH() {
        return cX(DeviceUtils.ROM_VIVO);
    }

    public static boolean sI() {
        return cX(DeviceUtils.ROM_OPPO);
    }

    private static String sJ() throws ClassNotFoundException {
        String str = ajf;
        if (str == null) {
            return "";
        }
        if (!str.equals(DeviceUtils.ROM_EMUI)) {
            return ajf;
        }
        String strCY = cY(com.alipay.sdk.m.c.a.a);
        String strCY2 = cY("ro.build.version.magic");
        if (strCY.contains("MagicUI") || strCY2.contains("MagicUI")) {
            return "MAGIC";
        }
        if (strCY.contains("EmotionUI")) {
            return cY("ro.product.brand").toLowerCase().equals("honor") ? "MAGIC" : "EMOTION";
        }
        return ajf;
    }

    private static void sK() throws ClassNotFoundException, IOException {
        File fileSL = sL();
        if (fileSL != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileSL)));
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        String strTrim = line.trim();
                        String[] strArrSplit = strTrim.split("￥");
                        if (strArrSplit.length == 4) {
                            ajf = strArrSplit[0];
                            ajg = strArrSplit[1];
                            ajh = strArrSplit[2];
                            aji = strArrSplit[3];
                            Log.i("RomUtils", strTrim);
                            return;
                        }
                    }
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String strCY = cY("ro.build.version.opporom");
        ajg = strCY;
        if (!TextUtils.isEmpty(strCY)) {
            ajf = DeviceUtils.ROM_OPPO;
        } else {
            String strCY2 = cY("ro.vivo.os.version");
            ajg = strCY2;
            if (!TextUtils.isEmpty(strCY2)) {
                ajf = DeviceUtils.ROM_VIVO;
            } else {
                String strCY3 = cY(com.alipay.sdk.m.c.a.a);
                ajg = strCY3;
                if (!TextUtils.isEmpty(strCY3)) {
                    ajf = DeviceUtils.ROM_EMUI;
                } else {
                    String strCY4 = cY("ro.build.version.magic");
                    ajg = strCY4;
                    if (!TextUtils.isEmpty(strCY4)) {
                        ajf = "MAGIC";
                    } else {
                        String strCY5 = cY("ro.miui.ui.version.name");
                        ajg = strCY5;
                        if (!TextUtils.isEmpty(strCY5)) {
                            ajf = DeviceUtils.ROM_MIUI;
                        } else {
                            String strCY6 = cY("ro.product.system.manufacturer");
                            ajg = strCY6;
                            if (!TextUtils.isEmpty(strCY6) && ajg.equalsIgnoreCase("meizu")) {
                                ajf = DeviceUtils.ROM_FLYME;
                            } else {
                                String strCY7 = cY("ro.smartisan.version");
                                ajg = strCY7;
                                if (!TextUtils.isEmpty(strCY7)) {
                                    ajf = DeviceUtils.ROM_SMARTISAN;
                                } else {
                                    String strCY8 = cY("ro.product.manufacturer");
                                    ajj = strCY8;
                                    if (!TextUtils.isEmpty(strCY8)) {
                                        if (ajj.equalsIgnoreCase(DeviceUtils.ROM_OPPO)) {
                                            ajf = DeviceUtils.ROM_OPPO;
                                            ajg = cY("ro.build.version.oplusrom");
                                        } else if (ajj.equalsIgnoreCase("SAMSUNG")) {
                                            ajf = "SAMSUNG";
                                        } else if (ajj.equalsIgnoreCase("OnePlus")) {
                                            ajg = cY("ro.build.version.oplusrom");
                                            ajf = "OnePlus";
                                        } else {
                                            sM();
                                        }
                                    } else {
                                        sM();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        ajh = cY("ro.vendor.build.fingerprint");
        aji = cY("ro.board.platform");
        if (fileSL == null) {
            return;
        }
        if (!ajf.contains("￥") && !ajg.contains("￥") && !ajh.contains("￥")) {
            aji.contains("￥");
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileSL)));
            try {
                bufferedWriter.write(ajf + "￥" + ajg + "￥" + ajh + "￥" + aji);
                bufferedWriter.flush();
            } finally {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static File sL() {
        try {
            return new File(s.getContext().getFilesDir(), "rom.dat");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static void sM() {
        String str = Build.DISPLAY;
        ajg = str;
        if (str.toUpperCase().contains(DeviceUtils.ROM_FLYME)) {
            ajf = DeviceUtils.ROM_FLYME;
        } else {
            ajg = "unknown";
            ajf = Build.MANUFACTURER.toUpperCase();
        }
    }

    private static boolean cX(String str) throws ClassNotFoundException, IOException {
        if (ajf == null) {
            sK();
        }
        if (str.equals("EMOTION") || str.equals("MAGIC")) {
            return sJ().equals(str);
        }
        return ajf.equals(str);
    }

    private static String cY(String str) throws ClassNotFoundException {
        String str2 = aje.get(str);
        if (str2 == null) {
            str2 = a.get(str);
            if (str2 == null) {
                str2 = "";
            }
            aje.put(str, str2);
        }
        return str2;
    }

    static class a {
        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String get(java.lang.String r6) throws java.lang.ClassNotFoundException {
            /*
                java.lang.String r0 = "android.os.SystemProperties"
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                java.lang.String r1 = "get"
                r2 = 1
                java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                java.lang.Class<java.lang.String> r4 = java.lang.String.class
                r5 = 0
                r3[r5] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                java.lang.reflect.Method r1 = r0.getDeclaredMethod(r1, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                r2[r5] = r6     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                java.lang.Object r0 = r1.invoke(r0, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.reflect.InvocationTargetException -> L1f java.lang.IllegalAccessException -> L24 java.lang.NoSuchMethodException -> L29 java.lang.ClassNotFoundException -> L2e
                goto L33
            L1f:
                r0 = move-exception
                r0.printStackTrace()
                goto L32
            L24:
                r0 = move-exception
                r0.printStackTrace()
                goto L32
            L29:
                r0 = move-exception
                r0.printStackTrace()
                goto L32
            L2e:
                r0 = move-exception
                r0.printStackTrace()
            L32:
                r0 = 0
            L33:
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 == 0) goto L4b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "getprop "
                r0.<init>(r1)
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                java.lang.String r0 = com.tk.core.o.l.cW(r6)
            L4b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tk.core.o.m.a.get(java.lang.String):java.lang.String");
        }
    }
}
