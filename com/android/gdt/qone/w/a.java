package com.android.gdt.qone.w;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.android.gdt.qone.ar.d;
import io.netty.util.internal.StringUtil;
import java.io.File;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static volatile String a;
    public static volatile String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;

    public static synchronized String a() {
        String str = f;
        if (str != null) {
            return str;
        }
        Context contextA = d.h().a();
        if (contextA == null) {
            return "";
        }
        try {
            String strA = com.android.gdt.qone.ae.a.a(contextA.getPackageManager().getApplicationInfo(contextA.getPackageName(), 0).sourceDir);
            f = strA;
            return strA;
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized String b() {
        String absolutePath;
        if (TextUtils.isEmpty(e)) {
            Context contextA = d.h().a();
            if (contextA == null) {
                absolutePath = "";
            } else {
                File file = new File(contextA.getFilesDir(), "qm");
                absolutePath = (file.exists() || file.mkdirs()) ? file.getAbsolutePath() : "";
            }
            e = absolutePath;
        }
        return e;
    }

    public static String c() {
        String str = d;
        if (str != null) {
            return str;
        }
        try {
            String str2 = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", null).invoke(null, null);
            d = str2;
            return str2;
        } catch (Throwable th) {
            com.android.gdt.qone.af.c.a(th);
            return "";
        }
    }

    public static long d() {
        Context contextA = d.h().a();
        if (contextA == null) {
            return 0L;
        }
        try {
            return contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0).firstInstallTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static String e() {
        Context contextA = d.h().a();
        String packageName = contextA != null ? contextA.getPackageName() : null;
        return TextUtils.isEmpty(packageName) ? "" : packageName;
    }

    public static synchronized String f() {
        String strE = e();
        if (TextUtils.isEmpty(strE)) {
            return "";
        }
        try {
            PackageInfo packageInfo = d.h().a().getPackageManager().getPackageInfo(strE, 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str != null && str.trim().length() > 0) {
                String strReplace = str.trim().replace('\n', ' ').replace(StringUtil.CARRIAGE_RETURN, ' ').replace("|", "%7C");
                int i2 = 0;
                for (char c2 : strReplace.toCharArray()) {
                    if (c2 == '.') {
                        i2++;
                    }
                }
                if (i2 < 3) {
                    strReplace = strReplace + "." + i;
                }
                return strReplace;
            }
            return "" + i;
        } catch (Exception e2) {
            com.android.gdt.qone.af.c.a(e2);
            e2.toString();
            return "";
        }
    }

    public static boolean g() {
        Context contextA = d.h().a();
        if (contextA != null) {
            String strC = c();
            if (TextUtils.isEmpty(strC) || strC.equals(contextA.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static int h() {
        Context contextA = d.h().a();
        int i = 0;
        if (contextA == null) {
            return 0;
        }
        ApplicationInfo applicationInfo = contextA.getApplicationInfo();
        int i2 = applicationInfo != null ? applicationInfo.flags : 0;
        if (i2 >= 0 && (i2 & 1) == 1) {
            i = 2;
        }
        String absolutePath = contextA.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath) || !absolutePath.startsWith("/system")) {
            return i;
        }
        return 1;
    }

    public static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String packageName = context.getPackageName();
        if (packageName == null || packageName.trim().length() <= 0 || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null || runningAppProcesses.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100) {
                for (String str : runningAppProcessInfo.pkgList) {
                    if (packageName.equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static synchronized void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(a) && !"0IOS0HZ21B510CEZ".equals(str)) {
            a = str;
        }
    }

    public static void a(String str, String str2, com.android.gdt.qone.x.a aVar) {
        if (!g()) {
            com.android.gdt.qone.at.a.a(str);
            com.android.gdt.qone.af.c.a("[appInfo]", "appKey:%s is not store process return", str);
        } else {
            com.android.gdt.qone.af.c.b("[appInfo]", "appKey:%s is store process,query lock state %b", str, Boolean.valueOf(new com.android.gdt.qone.x.b().a(str2, aVar, 3)));
        }
    }
}
