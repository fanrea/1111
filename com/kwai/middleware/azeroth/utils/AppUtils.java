package com.kwai.middleware.azeroth.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AppUtils {
    public static boolean isDebuggable(Context context) {
        ApplicationInfo appInfoSafely = getAppInfoSafely(context);
        return (appInfoSafely == null || (appInfoSafely.flags & 2) == 0) ? false : true;
    }

    public static ApplicationInfo getAppInfoSafely(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PackageInfo getPackageInfoSafely(Context context, int i) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static int getVersionCode(Context context) {
        PackageInfo packageInfoSafely = getPackageInfoSafely(context, 0);
        if (packageInfoSafely == null) {
            return 0;
        }
        return packageInfoSafely.versionCode;
    }

    public static String getVersionName(Context context) {
        PackageInfo packageInfoSafely = getPackageInfoSafely(context, 0);
        return packageInfoSafely == null ? "" : packageInfoSafely.versionName;
    }

    public static String getMainActivityName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction("android.intent.action.MAIN");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 64)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            IntentFilter intentFilter = resolveInfo.filter;
            if (intentFilter != null && intentFilter.hasAction("android.intent.action.MAIN") && activityInfo.packageName.equals(context.getPackageName())) {
                return activityInfo.name;
            }
        }
        return "";
    }

    public static void startMainActivity(Context context) {
        try {
            String mainActivityName = getMainActivityName(context);
            if (TextUtils.isEmpty(mainActivityName)) {
                return;
            }
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("android.intent.action.MAIN");
            intent.setClassName(context, mainActivityName);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
