package com.bytedance.bdtracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class t4 {
    public static final Map<String, Boolean> a = new ConcurrentHashMap();
    public static final Map<String, PackageInfo> b = new ConcurrentHashMap();

    public static int a(Context context) {
        PackageInfo packageInfoA = a(context, context.getPackageName(), 0);
        if (packageInfoA != null) {
            return packageInfoA.versionCode;
        }
        return 0;
    }

    public static PackageInfo a(Context context, String str, int i) {
        PackageInfo packageInfo;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = i + ":" + context.hashCode() + "@" + str;
        Map<String, PackageInfo> map = b;
        synchronized (map) {
            if (!map.containsKey(str2)) {
                try {
                    map.put(str2, context.getPackageManager().getPackageInfo(str, i));
                } catch (Throwable unused) {
                }
            }
            packageInfo = b.get(str2);
        }
        return packageInfo;
    }

    public static boolean a(Context context, String str) {
        boolean zEquals;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = context.hashCode() + "@" + str;
        Map<String, Boolean> map = a;
        synchronized (map) {
            if (map.containsKey(str2)) {
                zEquals = Boolean.TRUE.equals(a.get(str2));
            } else {
                try {
                    map.put(str2, Boolean.valueOf(context.getPackageManager().getPackageInfo(str, 16384) != null));
                } catch (Throwable unused) {
                    a.put(str2, false);
                }
                zEquals = Boolean.TRUE.equals(a.get(str2));
            }
        }
        return zEquals;
    }

    public static String b(Context context) {
        PackageInfo packageInfoA = a(context, context.getPackageName(), 0);
        return packageInfoA != null ? packageInfoA.versionName : "";
    }
}
