package com.fendasz.moku.planet.utils.system.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.FileProvider;
import com.alibaba.fastjson.JSON;
import com.fendasz.moku.planet.utils.AppUsageStatsManager;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PermissionUtils;
import com.fendasz.moku.planet.utils.TimeUtil;
import com.fendasz.moku.planet.utils.system.entity.PackageInfoEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SystemUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String SCREEN_READER_INTENT_ACTION = "android.accessibilityservice.AccessibilityService";
    private static final String SCREEN_READER_INTENT_CATEGORY = "android.accessibilityservice.category.FEEDBACK_SPOKEN";
    private static final String TAG = "moku_system_util:";

    public static class VERSON {
        public static final int ANDROID_10 = 29;
        public static final int ANDROID_11 = 30;
        public static final int ANDROID_4_1 = 16;
        public static final int ANDROID_4_2 = 17;
        public static final int ANDROID_4_3 = 18;
        public static final int ANDROID_4_4 = 19;
        public static final int ANDROID_4_4_W = 20;
        public static final int ANDROID_5 = 21;
        public static final int ANDROID_5_1 = 22;
        public static final int ANDROID_6 = 23;
        public static final int ANDROID_7 = 24;
        public static final int ANDROID_7_1 = 25;
        public static final int ANDROID_8 = 26;
        public static final int ANDROID_8_1 = 27;
        public static final int ANDROID_9 = 28;
        public static final int ANDROID_VERSION = Build.VERSION.SDK_INT;
    }

    public static boolean isActivityDestroyed(Activity activity) {
        if (activity == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        return false;
    }

    public static void openSettings(Context context) {
        context.startActivity(new Intent("android.settings.SETTINGS"));
    }

    public static List<String> getAllInstalledPackageName(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            arrayList.add(packageInfo.packageName);
            int i2 = packageInfo.applicationInfo.flags;
        }
        return arrayList;
    }

    public static List<PackageInfoEntity> getAllInstalledPackageInfo(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            PackageInfoEntity packageInfoEntity = new PackageInfoEntity();
            packageInfoEntity.setPackageName(packageInfo.packageName);
            long j = packageInfo.firstInstallTime;
            if (j > 0) {
                packageInfoEntity.setFirstInstallTime(TimeUtil.formatTime(Long.valueOf(j)));
            }
            long j2 = packageInfo.lastUpdateTime;
            if (j2 > 0) {
                packageInfoEntity.setLastUpdateTime(TimeUtil.formatTime(Long.valueOf(j2)));
            }
            packageInfoEntity.setApplicationLabel(context.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString());
            arrayList.add(packageInfoEntity);
            if (packageInfo.packageName.startsWith("com.gotokeep.keep")) {
                LogUtils.logD(TAG, "KEEP install info,firstInstallTime=>" + packageInfo.firstInstallTime + ",lastUpdateTime=>" + packageInfo.lastUpdateTime);
            }
        }
        LogUtils.logD(TAG, "packageInfoEntity_list=>" + JSON.toJSONString(arrayList));
        return arrayList;
    }

    public static List<String> getAppByRunCommand() throws IOException {
        ArrayList arrayList;
        IOException e;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("pm list packages").getInputStream()));
            arrayList = new ArrayList();
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    arrayList.add(line.replace("package:", ""));
                } catch (IOException e2) {
                    e = e2;
                    LogUtils.logE(TAG, "app run commmand to get applist error,msg=>" + e.getMessage());
                    return arrayList;
                }
            }
            LogUtils.logD(TAG, "getAppByRunCommand=>" + JSON.toJSONString(arrayList));
        } catch (IOException e3) {
            arrayList = null;
            e = e3;
        }
        return arrayList;
    }

    public static void installApp(Context context, File file) {
        try {
            LogUtils.log(TAG, "即将安装" + file);
            Intent intent = new Intent("android.intent.action.VIEW");
            if (VERSON.ANDROID_VERSION >= 24) {
                intent.setFlags(1);
                LogUtils.log(TAG, context.getPackageName() + ".fileProvider");
                intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".mokuFileProvider", file), "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(268435456);
            }
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                context.startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uninstallApp(Context context, String str) {
        LogUtils.log(TAG, "即将卸载" + str);
        context.startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + str)));
    }

    public static void openPackage(Context context, String str) {
        LogUtils.log(TAG, "即将打开" + str);
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
        } catch (Exception e) {
            LogUtils.log(TAG, e.toString());
            e.printStackTrace();
        }
    }

    public static boolean isAppExist(Context context, String str) throws PackageManager.NameNotFoundException {
        if (str == null) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isAppExistEver(Context context, String str) {
        if (PermissionUtils.checkUsageStatsPermissions(context) && Build.VERSION.SDK_INT >= 22) {
            try {
                boolean zIsAppExistEver = AppUsageStatsManager.getInstance().isAppExistEver(context, str);
                LogUtils.logD(TAG, "isAppExistEver_package Name：" + str + ",isAppExistEver:" + zIsAppExistEver);
                return zIsAppExistEver;
            } catch (Exception e) {
                e.printStackTrace();
                return isAppExist(context, str);
            }
        }
        return isAppExist(context, str);
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return "当前应用";
        }
    }

    public static void openBrowser(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyToClipboard(Context context, String str, String str2) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
    }

    public static int getSimulatorCode(Context context) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        int i = 1;
        int i2 = 0;
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            i2 = -1;
        } else {
            LogUtils.log(TAG, "can not call phone");
        }
        if (Build.FINGERPRINT.startsWith("generic")) {
            LogUtils.log(TAG, "the FINGERPRINT of your device is " + Build.FINGERPRINT + " and it's startsWith generic");
        } else {
            i = i2;
        }
        if (Build.FINGERPRINT.toLowerCase().contains("vbox")) {
            i = 2;
            LogUtils.log(TAG, "the FINGERPRINT of your device is " + Build.FINGERPRINT + " and it's contains vbox");
        }
        if (Build.FINGERPRINT.toLowerCase().contains("test-keys")) {
            i = 3;
            LogUtils.log(TAG, "the FINGERPRINT of your device is " + Build.FINGERPRINT + " and it's contains test-keys");
        }
        if (Build.MODEL.contains("google_sdk")) {
            i = 4;
            LogUtils.log(TAG, "the MODEL of your device is " + Build.MODEL + " and it's contains google_sdk");
        }
        if (Build.MODEL.contains("Emulator")) {
            i = 5;
            LogUtils.log(TAG, "the MODEL of your device is " + Build.MODEL + " and it's contains Emulator");
        }
        if (Build.MODEL.contains("MuMu")) {
            i = 6;
            LogUtils.log(TAG, "the MODEL of your device is " + Build.MODEL + " and it's contains MuMu");
        }
        if (Build.MODEL.contains("virtual")) {
            i = 7;
            LogUtils.log(TAG, "the MODEL of your device is " + Build.MODEL + " and it's contains virtual");
        }
        if ("android".equalsIgnoreCase(Build.SERIAL)) {
            i = 8;
            LogUtils.log(TAG, "the SERIAL of your device is " + Build.SERIAL + " and it's equals android");
        }
        if (Build.MANUFACTURER.contains("Genymotion")) {
            i = 9;
            LogUtils.log(TAG, "the MANUFACTURER of your device is " + Build.MANUFACTURER + " and it's contains Genymotion");
        }
        if (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) {
            i = 10;
            LogUtils.log(TAG, "the BRAND of your device is " + Build.BRAND + " the DEVICE of your device is " + Build.DEVICE + " and the BRAND is startsWith generic and the DEVICE is startsWith generic");
        }
        if ("google_sdk".equals(Build.PRODUCT)) {
            i = 11;
            LogUtils.log(TAG, "the PRODUCT of your device is " + Build.PRODUCT + " and it's equals google_sdk");
        }
        if ("android".equals(((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().toLowerCase())) {
            i = 12;
            LogUtils.log(TAG, "the NetworkOperatorName of your device is android");
        }
        if (checkIsNotRealPhoneCpu()) {
            i = 13;
            LogUtils.log(TAG, "the cpu of your device is not arm");
        }
        if (!notHasBasebandVersion().booleanValue()) {
            return i;
        }
        LogUtils.log(TAG, "No baseband version information was obtained");
        return 14;
    }

    private static boolean notHasLightSensorManager(Context context) {
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) == null;
    }

    private static boolean notHasBlueTooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter == null || TextUtils.isEmpty(defaultAdapter.getName());
    }

    private static boolean checkIsNotRealPhoneCpu() throws IOException {
        String cpuInfo = readCpuInfo();
        return cpuInfo.toLowerCase().contains("intel") || cpuInfo.toLowerCase().contains("amd");
    }

    private static String readCpuInfo() throws IOException {
        try {
            Process processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), "utf-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    bufferedReader.close();
                    return sb.toString().toLowerCase();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static Boolean notHasBasebandVersion() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String basebandVer = getBasebandVer();
        if (Build.VERSION.SDK_INT >= 28 || !basebandVer.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String getBasebandVer() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isAdbEnabled(Context context) {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 17 ? Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtils.log(TAG, "isAdbEnabled >> " + z);
        return z;
    }

    public static boolean isAccessibilityEnabled(Context context) throws RuntimeException {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            boolean zIsEnabled = ((AccessibilityManager) context.getSystemService("accessibility")).isEnabled();
            boolean zIsScreenReaderActive = isScreenReaderActive(context);
            if (zIsEnabled && zIsScreenReaderActive) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtils.log(TAG, "isAccessibilityEnabled >> " + z);
        return z;
    }

    private static boolean isScreenReaderActive(Context context) {
        Intent intent = new Intent(SCREEN_READER_INTENT_ACTION);
        intent.addCategory(SCREEN_READER_INTENT_CATEGORY);
        boolean zIsAccessibilitySettingsOn = false;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices.size() <= 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT <= 15) {
            ContentResolver contentResolver = context.getContentResolver();
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            while (it.hasNext()) {
                Cursor cursorQuery = contentResolver.query(Uri.parse("content://" + it.next().serviceInfo.packageName + ".providers.StatusProvider"), null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    int i = cursorQuery.getInt(0);
                    cursorQuery.close();
                    if (i == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                zIsAccessibilitySettingsOn |= isAccessibilitySettingsOn(context, resolveInfo.serviceInfo.packageName + "/" + resolveInfo.serviceInfo.name);
            }
            return zIsAccessibilitySettingsOn;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ActivityManager.RunningServiceInfo> it2 = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().service.getPackageName());
        }
        Iterator<ResolveInfo> it3 = listQueryIntentServices.iterator();
        while (it3.hasNext()) {
            if (arrayList.contains(it3.next().serviceInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAccessibilitySettingsOn(Context context, String str) {
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        String string = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        com.fendasz.moku.planet.utils.LogUtils.logD("length:", "" + r0.length);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Class[] getMethodParamTypes(java.lang.String r5) throws java.lang.SecurityException {
        /*
            r0 = 0
            java.lang.Class<android.telephony.TelephonyManager> r1 = android.telephony.TelephonyManager.class
            java.lang.reflect.Method[] r1 = r1.getDeclaredMethods()     // Catch: java.lang.Exception -> L3e
            r2 = 0
        L8:
            int r3 = r1.length     // Catch: java.lang.Exception -> L3e
            if (r2 >= r3) goto L48
            r3 = r1[r2]     // Catch: java.lang.Exception -> L3e
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L3e
            boolean r3 = r5.equals(r3)     // Catch: java.lang.Exception -> L3e
            if (r3 == 0) goto L3b
            r3 = r1[r2]     // Catch: java.lang.Exception -> L3e
            java.lang.Class[] r0 = r3.getParameterTypes()     // Catch: java.lang.Exception -> L3e
            int r3 = r0.length     // Catch: java.lang.Exception -> L3e
            r4 = 1
            if (r3 < r4) goto L3b
            java.lang.String r5 = "length:"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3e
            r1.<init>()     // Catch: java.lang.Exception -> L3e
            java.lang.String r2 = ""
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L3e
            int r2 = r0.length     // Catch: java.lang.Exception -> L3e
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L3e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L3e
            com.fendasz.moku.planet.utils.LogUtils.logD(r5, r1)     // Catch: java.lang.Exception -> L3e
            goto L48
        L3b:
            int r2 = r2 + 1
            goto L8
        L3e:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = "moku_system_util:"
            com.fendasz.moku.planet.utils.LogUtils.logE(r1, r5)
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.system.utils.SystemUtils.getMethodParamTypes(java.lang.String):java.lang.Class[]");
    }

    public static boolean isAppRunningForeground(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context.getApplicationInfo().processName)) {
                return true;
            }
        }
        return false;
    }

    public static void openAppStoreWithInfo(Context context, String str, String str2, int i) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + str2));
            if (isAppExist(context, str)) {
                intent.setPackage(str);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } catch (Exception unused) {
            Log.e(TAG, "application not found");
        }
    }

    public static void openGameCenter(Context context, String str, String str2, int i) {
        String[] strArr = new String[2];
        String str3 = "vivogame://openjump/detail?pkgname=" + str2;
        try {
            if (isAppExist(context, str)) {
                if (i == 1 || i == 2 || i != 3) {
                }
                Intent intent = new Intent();
                intent.setAction("com.vivo.game.action.OPEN_JUMP");
                context.startActivity(intent);
            }
        } catch (Exception unused) {
            Log.e(TAG, "game not found");
        }
    }

    public static boolean isNative(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("moku_system_util:,class or method name is null");
        }
        List listAsList = Arrays.asList(cls.getMethods());
        List listAsList2 = Arrays.asList(cls.getDeclaredMethods());
        ArrayList<Method> arrayList = new ArrayList();
        arrayList.addAll(listAsList);
        arrayList.addAll(listAsList2);
        for (Method method : arrayList) {
            method.setAccessible(true);
            if (Modifier.isNative(method.getModifiers())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNative(Class<?> cls, String str) {
        if (cls == null || str == null) {
            throw new NullPointerException("moku_system_util:,class or method name is null");
        }
        for (Method method : Arrays.asList(cls.getMethods())) {
            if (str.equals(method.getName())) {
                LogUtils.logD(TAG, "method isNative:" + method.getName());
                if (Modifier.isNative(method.getModifiers())) {
                    return true;
                }
            }
        }
        List<Method> listAsList = Arrays.asList(cls.getDeclaredMethods());
        if (listAsList.isEmpty()) {
            return false;
        }
        for (Method method2 : listAsList) {
            LogUtils.logD(TAG, "declared method isNative:" + method2.getName());
            if (Modifier.isNative(method2.getModifiers())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppOpened(Context context, String str) {
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, -1);
        Iterator<UsageStats> it = usageStatsManager.queryUsageStats(0, calendar.getTimeInMillis(), jCurrentTimeMillis).iterator();
        while (it.hasNext()) {
            if (it.next().getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppOpened(Context context, String str, long j, long j2) {
        Iterator<UsageStats> it = ((UsageStatsManager) context.getSystemService("usagestats")).queryUsageStats(0, j, j2).iterator();
        while (it.hasNext()) {
            if (it.next().getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
