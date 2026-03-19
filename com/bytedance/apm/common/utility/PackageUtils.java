package com.bytedance.apm.common.utility;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PackageUtils {
    private static final Map<String, Boolean> existsPackageMap = new ConcurrentHashMap();
    private static final Map<String, PackageInfo> packageInfoMap = new ConcurrentHashMap();

    public static boolean existsPackage(Context context, String str) {
        boolean zEquals;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = context.hashCode() + "@" + str;
        Map<String, Boolean> map = existsPackageMap;
        synchronized (map) {
            if (!map.containsKey(str2)) {
                try {
                    map.put(str2, Boolean.valueOf(context.getPackageManager().getPackageInfo(str, 16384) != null));
                } catch (Throwable unused) {
                    existsPackageMap.put(str2, false);
                }
                zEquals = Boolean.TRUE.equals(existsPackageMap.get(str2));
            } else {
                zEquals = Boolean.TRUE.equals(existsPackageMap.get(str2));
            }
        }
        return zEquals;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        return getPackage(context, str, 0);
    }

    public static PackageInfo getPackageSignature(Context context, String str) {
        return getPackage(context, str, 64);
    }

    private static PackageInfo getPackage(Context context, String str, int i) {
        PackageInfo packageInfo;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = i + ":" + context.hashCode() + "@" + str;
        Map<String, PackageInfo> map = packageInfoMap;
        synchronized (map) {
            if (!map.containsKey(str2)) {
                try {
                    map.put(str2, context.getPackageManager().getPackageInfo(str, i));
                } catch (Throwable unused) {
                }
            }
            packageInfo = packageInfoMap.get(str2);
        }
        return packageInfo;
    }

    public static String getVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context, context.getPackageName());
        return packageInfo != null ? packageInfo.versionName : "";
    }

    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context, context.getPackageName());
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }
}
