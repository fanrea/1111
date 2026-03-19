package com.ss.android.downloadlib.h;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.ss.android.d.d.hc.yo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class uo {
    private static Object[] hc = new Object[0];
    private static Object[] b = new Object[73];
    static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String c = null;

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean hc(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static long d(JSONObject jSONObject, String str) {
        return com.ss.android.d.d.an.hc.d(jSONObject, str);
    }

    public static JSONObject d(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.d.d.an.hc.d(jSONObject, jSONObject2);
    }

    public static JSONObject d(JSONObject jSONObject) {
        return com.ss.android.d.d.an.hc.d(jSONObject);
    }

    public static JSONObject d(JSONObject... jSONObjectArr) {
        return com.ss.android.d.d.an.hc.d(jSONObjectArr);
    }

    public static boolean d(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null) {
                if (!listQueryIntentActivities.isEmpty()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String d(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        }
        if (j >= 1048576) {
            return (j / 1048576) + "M";
        }
        return decimalFormat.format(j / 1048576.0f) + "M";
    }

    public static PackageInfo d(com.ss.android.hc.d.hc.hc hcVar) {
        com.ss.android.socialbase.downloader.h.b bVarGb;
        if (hcVar == null || (bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.downloadlib.addownload.mq.getContext()).gb(hcVar.rf())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.b.d(com.ss.android.downloadlib.addownload.mq.getContext(), bVarGb, bVarGb.mk(), bVarGb.gb());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable d(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return null;
    }

    public static int hc(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static String b(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Drawable c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean u(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.mq.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.hc.b d(String str, int i, String str2) throws PackageManager.NameNotFoundException {
        com.ss.android.downloadlib.addownload.hc.b bVar = new com.ss.android.downloadlib.addownload.hc.b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.mq.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                bVar.hc(packageInfo.versionCode);
                bVar.d(com.ss.android.downloadlib.addownload.hc.b.hc);
                yo yoVarH = com.ss.android.downloadlib.addownload.mq.h();
                if (yoVarH != null && yoVarH.d() && !d(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    bVar.d(com.ss.android.downloadlib.addownload.hc.b.b);
                }
            }
        } catch (Exception e) {
            com.ss.android.socialbase.downloader.an.d.u("ToolUtils", "getInstalledAppInfo:" + e.getMessage());
        }
        return bVar;
    }

    private static boolean d(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || d(str, str2) >= 0;
    }

    public static boolean hc(com.ss.android.hc.d.hc.hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        return d(hcVar.u(), hcVar.mt(), hcVar.r()).d();
    }

    public static boolean d(com.ss.android.d.d.b.b bVar) {
        if (bVar == null) {
            return false;
        }
        return d(bVar.he(), bVar.de(), bVar.v()).d();
    }

    public static boolean hc(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.mq.getContext();
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static boolean d(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i == packageInfo.versionCode;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    public static boolean an(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    public static Intent h(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Signature[] gb(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return null;
        }
    }

    public static Signature[] tt(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return null;
        }
    }

    public static boolean d(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i = 0; i < signatureArr.length; i++) {
            Signature signature = signatureArr[i];
            if ((signature == null && signatureArr2[i] != null) || (signature != null && !signature.equals(signatureArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str) throws PackageManager.NameNotFoundException {
        File file;
        Context context = com.ss.android.downloadlib.addownload.mq.getContext();
        if (TextUtils.isEmpty(str) || !u(context, str)) {
            return false;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.mq.tt().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.mq.tt().optInt("get_ext_dir_mode") == 1) {
                file = tc(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/".concat(String.valueOf(str)));
            }
            if (!file.exists()) {
                return false;
            }
            long jD = h.d(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < jD) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return true;
        }
    }

    public static File tc(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        com.ss.android.socialbase.downloader.an.d.hc("ToolUtils", "getExtDir: file.toString()-->" + file.toString());
        return file;
    }

    public static int d(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String d(String str, int i) {
        return i == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static int d(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i = 0;
                int i2 = 0;
                while (i < iMin) {
                    i2 = Integer.parseInt(strArrSplit[i]) - Integer.parseInt(strArrSplit2[i]);
                    if (i2 != 0) {
                        break;
                    }
                    i++;
                }
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
                for (int i3 = i; i3 < strArrSplit.length; i3++) {
                    if (Integer.parseInt(strArrSplit[i3]) > 0) {
                        return 1;
                    }
                }
                while (i < strArrSplit2.length) {
                    if (Integer.parseInt(strArrSplit2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String d(String... strArr) {
        return com.ss.android.d.d.an.hc.d(strArr);
    }

    public static <T> T d(T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("args is null");
        }
        for (T t : tArr) {
            if (t != null) {
                return t;
            }
        }
        throw new IllegalArgumentException("args is null");
    }

    public static long hc(long j) {
        try {
            return d(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return j;
        }
    }

    public static boolean d() {
        try {
            if (com.ss.android.downloadlib.addownload.mq.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.mq.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion >= 33) {
                return Build.VERSION.SDK_INT >= 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return false;
        }
    }

    public static long d(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.ss.android.socialbase.downloader.e.an.c(file.getAbsolutePath());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return j;
        }
    }

    public static long d(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            return -1L;
        }
    }

    public static boolean hc() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void d(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    public static void b() {
        try {
            if (com.ss.android.downloadlib.addownload.mq.u().d(com.ss.android.downloadlib.addownload.mq.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.mq.getContext().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.mq.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    public static HashMap<String, String> hc(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.optString(next));
                }
                return map;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return map;
    }
}
