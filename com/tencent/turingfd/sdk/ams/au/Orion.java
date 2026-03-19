package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Orion {
    public static final Dew<String> a = new Dew<>();

    public static String a() {
        Iterator it = ((ArrayList) ComaBerenices.a()).iterator();
        while (it.hasNext()) {
            Cthrows cthrows = (Cthrows) it.next();
            if (cthrows.a.contains(Ginkgo.c)) {
                return cthrows.b;
            }
        }
        return "";
    }

    public static int b(Context context) {
        Intent intentRegisterReceiver = null;
        try {
            intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (intentRegisterReceiver == null) {
            return 0;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        if (intExtra != 2 && intExtra != 5) {
            return 1;
        }
        int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
        if (intExtra2 == 2) {
            return 3;
        }
        return intExtra2 == 1 ? 2 : 0;
    }

    public static String c(Context context) {
        String string;
        Dew<String> dew = a;
        synchronized (dew) {
            String strA = dew.a();
            if (strA != null) {
                return strA;
            }
            StringBuilder sb = new StringBuilder();
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                sb.append(telephonyManager.getSimState());
                if (Build.VERSION.SDK_INT >= 23) {
                    int phoneCount = telephonyManager.getPhoneCount();
                    sb.append(",");
                    sb.append(phoneCount);
                }
                string = sb.toString();
                dew.a(string, 30000L);
            } catch (Throwable unused) {
                string = sb.toString();
                a.a(string, 30000L);
            }
            return string;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            r2 = 0
            if (r0 < r1) goto L8
            return r2
        L8:
            int[] r0 = com.tencent.turingfd.sdk.ams.au.Cfinally.n0
            java.lang.String r0 = com.tencent.turingfd.sdk.ams.au.Cfinally.a(r0)
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            java.util.HashMap<java.lang.String, com.tencent.turingfd.sdk.ams.au.strictfp$do> r0 = com.tencent.turingfd.sdk.ams.au.Cstrictfp.a
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L29
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L29
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L29
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = r0.readLine()     // Catch: java.lang.Throwable -> L27
            com.tencent.turingfd.sdk.ams.au.Cstrictfp.a(r0)
            goto L31
        L27:
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L2f
            com.tencent.turingfd.sdk.ams.au.Cstrictfp.a(r0)
        L2f:
            java.lang.String r1 = ""
        L31:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L38
            return r2
        L38:
            java.lang.String r0 = "CONFIGURED"
            boolean r0 = r0.equals(r1)
            r3 = 3
            if (r0 == 0) goto L50
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = "adb_enabled"
            int r4 = android.provider.Settings.Secure.getInt(r4, r0, r2)     // Catch: java.lang.Throwable -> L4f
            if (r4 <= 0) goto L4f
            r4 = 1
            return r4
        L4f:
            return r3
        L50:
            java.lang.String r4 = "DISCONNECTED"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L5a
            r4 = 2
            return r4
        L5a:
            java.lang.String r4 = "CONNECTED"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L63
            return r3
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Orion.d(android.content.Context):int");
    }

    public static boolean e(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0) {
                return false;
            }
        } else if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0) {
            return false;
        }
        return true;
    }

    public static String f(Context context) {
        Map<String, Set<String>> map = Bagasse.a;
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            String strA = Virgo.a(context, packageName);
            Cthrows cthrows = new Cthrows();
            cthrows.a = Ginkgo.a + Ginkgo.b;
            cthrows.b = packageName + Config.replace + strA;
            arrayList.add(cthrows);
        }
        return arrayList.size() != 0 ? ((Cthrows) arrayList.get(0)).b : "";
    }

    public static int a(Context context) {
        boolean z = false;
        int iA = Cthis.a(Cthis.a(0, e(context), 0), Build.VERSION.SDK_INT >= 17 && Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        try {
            if ((context.getApplicationInfo().flags & 2) > 0) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        return Cthis.a(Cthis.a(iA, z, 2), Debug.isDebuggerConnected(), 3);
    }

    public static String b() {
        Iterator it = ((ArrayList) ComaBerenices.a()).iterator();
        while (it.hasNext()) {
            Cthrows cthrows = (Cthrows) it.next();
            if (cthrows.a.contains(Ginkgo.d)) {
                return cthrows.b;
            }
        }
        return "";
    }

    public static String c() {
        Context context;
        StringBuilder sb = new StringBuilder();
        try {
            synchronized (Ccase.class) {
                context = Ccase.a;
            }
            Lacerta lacertaA = Lyra.a(context);
            for (int i = 0; i < lacertaA.a.a(); i++) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                Locale localeA = lacertaA.a.a(i);
                if (localeA != null) {
                    sb.append(localeA.getLanguage());
                    sb.append("-");
                    sb.append(localeA.getCountry());
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
