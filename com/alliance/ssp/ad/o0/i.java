package com.alliance.ssp.ad.o0;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.content.FileProvider;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.File;
import java.util.Calendar;
import java.util.UUID;

/* compiled from: DeviceUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static String g = "";
    public static String h = "";
    public static String i = "";
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static String m = "";

    public static String a() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d() {
        try {
            return Build.MODEL;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(Context context) {
        String str = k;
        if (str != null && !str.isEmpty()) {
            return k;
        }
        if (context == null) {
            return "";
        }
        String strA = a(context, "com.huawei.appmarket");
        k = strA;
        return strA;
    }

    public static String h(Context context) {
        String str = j;
        if (str != null && !str.isEmpty()) {
            return j;
        }
        if (context == null) {
            return "";
        }
        String strA = a(context, "com.huawei.hwid");
        j = strA;
        return strA;
    }

    public static String i(Context context) {
        String str = g;
        if (str != null && !str.isEmpty()) {
            return g;
        }
        if (context == null) {
            return g;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("adalliancesdk", 0);
        String string = sharedPreferences.getString("onetime", "");
        g = string;
        if (string == null || string.isEmpty()) {
            g = com.alliance.ssp.ad.a.b.a("").append(System.currentTimeMillis()).toString();
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("onetime", g);
            editorEdit.apply();
        }
        String str2 = g;
        int i2 = l.a;
        return str2;
    }

    public static String j(Context context) {
        try {
            String str = d;
            if (str != null && str.length() > 0) {
                return d;
            }
            if (context == null) {
                return d;
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            d = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean k(Context context) {
        try {
            int i2 = context.getResources().getConfiguration().orientation;
            return i2 == 2 || i2 != 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static int l(Context context) throws NumberFormatException {
        if (context == null) {
            return 0;
        }
        try {
            long j2 = Long.parseLong(i(context));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            Calendar calendar2 = Calendar.getInstance();
            if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2)) {
                if (calendar.get(5) == calendar2.get(5)) {
                    return 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static String c(Context context) throws PackageManager.NameNotFoundException {
        try {
            String str = c;
            if (str != null && str.length() > 0) {
                return c;
            }
            if (context == null) {
                c = ILogConst.CACHE_PLAY_REASON_NULL;
                return "";
            }
            PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str2 = packageInfo != null ? packageInfo.versionName : "";
            c = str2;
            return str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String f() {
        return "3.11.4";
    }

    public static String e(Context context) {
        String str = e;
        if (str != null && !str.isEmpty()) {
            return e;
        }
        if (context == null) {
            return e;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("adalliancesdk", 0);
        String string = sharedPreferences.getString("cookieid", "");
        e = string;
        if (string == null || string.isEmpty()) {
            e = UUID.randomUUID().toString().replace("-", "") + Config.replace + com.alliance.ssp.ad.a.b.a("").append(System.currentTimeMillis()).toString();
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("cookieid", e);
            editorEdit.apply();
        }
        String str2 = e;
        int i2 = l.a;
        return str2;
    }

    public static boolean a(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static String b(Context context) throws PackageManager.NameNotFoundException {
        String str;
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        PackageInfo packageInfo3;
        String str2 = i;
        if (str2 != null && !str2.isEmpty()) {
            return i;
        }
        if (context == null || (str = Build.MANUFACTURER) == null || str.isEmpty()) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if ((str.toLowerCase().contains("huawei") || str.toLowerCase().contains("wiko") || str.toLowerCase().contains("cmdc")) && (packageInfo = packageManager.getPackageInfo("com.huawei.appmarket", 0)) != null) {
                i = packageInfo.versionName;
            }
            if (str.toLowerCase().contains("honor") && (packageInfo3 = packageManager.getPackageInfo("com.hihonor.appmarket", 0)) != null) {
                i = packageInfo3.versionName;
            }
            if ((str.toLowerCase().contains("xiaomi") || str.toLowerCase().contains("redmi")) && (packageInfo2 = packageManager.getPackageInfo("com.xiaomi.market", 0)) != null) {
                i = packageInfo2.versionName;
            }
            if (str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme")) {
                PackageInfo packageInfo4 = packageManager.getPackageInfo("com.heytap.market", 0);
                if (packageInfo4 == null) {
                    packageInfo4 = packageManager.getPackageInfo("com.oppo.market", 0);
                }
                if (packageInfo4 != null) {
                    i = "" + packageInfo4.versionCode;
                }
            }
            if (str.toLowerCase().contains("vivo")) {
                PackageInfo packageInfo5 = packageManager.getPackageInfo("com.bbk.appstore", 0);
                if (packageInfo5 == null && (packageInfo5 = packageManager.getPackageInfo("com.heytap.market", 0)) == null) {
                    packageInfo5 = packageManager.getPackageInfo("com.oppo.market", 0);
                }
                if (packageInfo5 != null) {
                    i = "" + packageInfo5.versionCode;
                }
            }
            if (str.toLowerCase().contains("oneplus")) {
                PackageInfo packageInfo6 = packageManager.getPackageInfo("com.oneplus.market", 0);
                if (packageInfo6 == null && (packageInfo6 = packageManager.getPackageInfo("com.heytap.market", 0)) == null) {
                    packageInfo6 = packageManager.getPackageInfo("com.oppo.market", 0);
                }
                if (packageInfo6 != null) {
                    i = "" + packageInfo6.versionCode;
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
            int i2 = l.a;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        r6 = new java.io.BufferedReader(new java.io.InputStreamReader(r3.getInputStream(r1)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        r1 = r6.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        if (r1 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        r2.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        r6.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0072 -> B:55:0x0075). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = com.alliance.ssp.ad.o0.i.h
            if (r0 == 0) goto Ld
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Ld
            java.lang.String r6 = com.alliance.ssp.ad.o0.i.h
            return r6
        Ld:
            java.lang.String r0 = "dev"
            if (r6 != 0) goto L14
            com.alliance.ssp.ad.o0.i.h = r0
            return r0
        L14:
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo()
            java.lang.String r6 = r6.sourceDir
            r1 = 0
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L67
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L67
            java.util.Enumeration r6 = r3.entries()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
        L29:
            boolean r1 = r6.hasMoreElements()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            if (r1 == 0) goto L5c
            java.lang.Object r1 = r6.nextElement()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.lang.String r5 = "META-INF/config_channel.txt"
            boolean r4 = r5.equals(r4)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            if (r4 == 0) goto L29
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            java.io.InputStream r1 = r3.getInputStream(r1)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
        L4f:
            java.lang.String r1 = r6.readLine()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            if (r1 == 0) goto L59
            r2.append(r1)     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
            goto L4f
        L59:
            r6.close()     // Catch: java.lang.Throwable -> L60 java.io.IOException -> L62
        L5c:
            r3.close()     // Catch: java.io.IOException -> L71
            goto L75
        L60:
            r6 = move-exception
            goto L99
        L62:
            r6 = move-exception
            r1 = r3
            goto L68
        L65:
            r6 = move-exception
            goto L98
        L67:
            r6 = move-exception
        L68:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L75
            r1.close()     // Catch: java.io.IOException -> L71
            goto L75
        L71:
            r6 = move-exception
            r6.printStackTrace()
        L75:
            java.lang.String r6 = r2.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L95
            com.google.gson.Gson r6 = new com.google.gson.Gson
            r6.<init>()
            java.lang.String r0 = r2.toString()
            java.lang.Class<com.alliance.ssp.ad.utils.ChannelEntity> r1 = com.alliance.ssp.ad.utils.ChannelEntity.class
            java.lang.Object r6 = r6.fromJson(r0, r1)
            com.alliance.ssp.ad.utils.ChannelEntity r6 = (com.alliance.ssp.ad.utils.ChannelEntity) r6
            java.lang.String r6 = r6.CHANNEL_ID
            com.alliance.ssp.ad.o0.i.h = r6
            return r6
        L95:
            com.alliance.ssp.ad.o0.i.h = r0
            return r0
        L98:
            r3 = r1
        L99:
            if (r3 == 0) goto La3
            r3.close()     // Catch: java.io.IOException -> L9f
            goto La3
        L9f:
            r0 = move-exception
            r0.printStackTrace()
        La3:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alliance.ssp.ad.o0.i.d(android.content.Context):java.lang.String");
    }

    public static String f(Context context) {
        if (a(m)) {
            return m;
        }
        if (context == null) {
            return "";
        }
        try {
            m = Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
        } catch (Exception unused) {
        }
        return m;
    }

    public static void a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || context == null) {
            return;
        }
        File file = new File(str, str2);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".NMSSPFileProvider", file), "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    public static String c() {
        String str = f;
        if (str != null && !str.isEmpty()) {
            return f;
        }
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        f = strReplace;
        int i2 = l.a;
        return strReplace;
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(str, 0) : null;
            if (packageInfo == null) {
                return null;
            }
            return String.valueOf(packageInfo.versionCode);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        if (a(l)) {
            return l;
        }
        if (context == null) {
            return "unknown";
        }
        String packageName = context.getPackageName();
        l = packageName;
        return packageName;
    }

    public static boolean a(String... strArr) {
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
