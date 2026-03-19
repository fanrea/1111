package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class t {
    private static final String a = "t";

    private t() {
    }

    public static Intent a(Context context, Class<?> clazz, Bundle extras) {
        Intent intent = new Intent(context, clazz);
        intent.addFlags(268435456);
        if (extras != null) {
            intent.putExtras(extras);
        }
        return intent;
    }

    private static Uri a(Intent intent) {
        Preconditions.NoThrow.checkNotNull(intent);
        return Uri.parse("market://details?id=" + intent.getPackage());
    }

    public static String a(Context context, Uri uri, List<String> packageNames) {
        if (uri == null || uri.getScheme() == null || !uri.getScheme().equalsIgnoreCase("market")) {
            return null;
        }
        for (String str : packageNames) {
            if (AppPackageUtil.getPackageVersionCode(context, str) != -1) {
                return str;
            }
        }
        return null;
    }

    public static void a(Context context, BroadcastReceiver receiver, IntentFilter intentFilter) {
        a(context, receiver, intentFilter, true);
    }

    public static void a(Context context, BroadcastReceiver receiver, IntentFilter intentFilter, boolean isExported) {
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
            context.registerReceiver(receiver, intentFilter);
        } else {
            context.registerReceiver(receiver, intentFilter, isExported ? 2 : 4);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.czhj.sdk.common.exceptions.IntentNotResolvableException */
    private static void a(Context context, Intent intent, String errMsg) throws IntentNotResolvableException {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            c(context, intent);
        } catch (Throwable th) {
            throw new IntentNotResolvableException(errMsg + "\n" + th.getMessage());
        }
    }

    public static void a(Context context, Uri uri) throws IntentNotResolvableException {
        a(context, uri, (String) null);
    }

    public static void a(Context context, Uri uri, String packageName) throws IntentNotResolvableException {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (com.sigmob.sdk.base.utils.m.b(packageName)) {
            intent.setPackage(packageName);
        }
        b(context, intent);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.czhj.sdk.common.exceptions.IntentNotResolvableException */
    public static void a(Context context, Uri uri, String packageName, boolean enableSmallWindow) throws Exception {
        ActivityOptions activityOptionsMakeCustomAnimation;
        String str = a;
        SigmobLogger.d(str, "launchApp: uri = " + uri + ", packageName = " + packageName + ", enableSmallWindow = " + enableSmallWindow, new Object[0]);
        boolean zB = com.sigmob.sdk.base.utils.n.b(uri);
        boolean zB2 = com.sigmob.sdk.base.utils.m.b(packageName);
        Activity activityI = com.sigmob.sdk.b.i();
        if (activityI == null) {
            activityI = com.sigmob.sdk.b.c();
        }
        if (activityI == null || com.sigmob.sdk.base.utils.n.b(Boolean.valueOf(enableSmallWindow))) {
            SigmobLogger.e(str, "launchApp: error = activity is null.", new Object[0]);
            if (zB && zB2) {
                a(context, uri, packageName);
                return;
            } else if (zB) {
                a(context, uri);
                return;
            } else {
                c(context, packageName);
                return;
            }
        }
        Bundle bundle = null;
        Intent intent = zB ? new Intent("android.intent.action.VIEW", uri) : zB2 ? context.getPackageManager().getLaunchIntentForPackage(packageName) : null;
        if (!com.sigmob.sdk.base.utils.n.b(intent) || !a(context, intent)) {
            throw new IntentNotResolvableException("Could not handle application specific action: " + uri + "\n\tYou may be running in the emulator or another device which does not have the required application.");
        }
        SigmobLogger.d(str, "launchApp: intent = " + intent, new Object[0]);
        intent.setFlags(270532608);
        if (Build.VERSION.SDK_INT >= 16) {
            activityOptionsMakeCustomAnimation = ActivityOptions.makeCustomAnimation(context, 0, 0);
            if (activityOptionsMakeCustomAnimation == null) {
                SigmobLogger.d(str, "launchApp: options is unavailable.", new Object[0]);
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 33) {
                        activityOptionsMakeCustomAnimation.getClass().getMethod("setPendingIntentBackgroundActivityLaunchAllowed", Boolean.TYPE).invoke(activityOptionsMakeCustomAnimation, true);
                    }
                    activityOptionsMakeCustomAnimation.getClass().getMethod("setLaunchWindowingMode", Integer.TYPE).invoke(activityOptionsMakeCustomAnimation, 6);
                } catch (Exception e) {
                    SigmobLogger.e(a, "launchApp: error = " + e.getMessage(), new Object[0]);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    View decorView = activityI.getWindow().getDecorView();
                    WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
                    Rect rect = new Rect(0, 0, decorView.getWidth() / 2, decorView.getHeight() / 2);
                    rect.offsetTo(rootWindowInsets.getSystemWindowInsetLeft() + 50, rootWindowInsets.getSystemWindowInsetTop() + 50);
                    activityOptionsMakeCustomAnimation.setLaunchBounds(rect);
                }
            }
        } else {
            activityOptionsMakeCustomAnimation = null;
        }
        if (activityOptionsMakeCustomAnimation != null) {
            try {
                bundle = activityOptionsMakeCustomAnimation.toBundle();
            } catch (Throwable th) {
                throw new IntentNotResolvableException(("Unable to open intent: " + intent) + "\n" + th.getMessage());
            }
        }
        activityI.startActivity(intent, bundle);
        if (enableSmallWindow) {
            com.sigmob.sdk.b.j();
        }
    }

    public static void a(Context context, String wx_app_id, String wx_app_username, String wx_app_path, int wx_business_type, String wx_ext_msg) throws IntentNotResolvableException {
        if (wx_business_type != 0) {
            if (wx_business_type == 1) {
                if (com.sigmob.sdk.base.utils.m.a((CharSequence) wx_ext_msg)) {
                    throw new IntentNotResolvableException("get mini_program error: " + wx_app_id + "," + wx_app_username + "," + wx_app_path + "," + wx_business_type + "," + wx_ext_msg);
                }
                Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                Method method = cls.getMethod("createWXAPI", Context.class, String.class);
                method.setAccessible(true);
                Object objInvoke = method.invoke(cls, context, wx_app_id);
                Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView$Req");
                Object objNewInstance = cls2.newInstance();
                Field declaredField = cls2.getDeclaredField("businessType");
                declaredField.setAccessible(true);
                declaredField.set(objNewInstance, "nativeOpenAdCanvas");
                Field declaredField2 = cls2.getDeclaredField(com.alipay.sdk.m.s.a.y);
                declaredField2.setAccessible(true);
                declaredField2.set(objNewInstance, wx_ext_msg);
                Method method2 = objInvoke.getClass().getMethod("sendReq", objNewInstance.getClass().getSuperclass());
                method2.setAccessible(true);
                boolean zBooleanValue = ((Boolean) method2.invoke(objInvoke, objNewInstance)).booleanValue();
                SigmobLog.d("openB:isSendReq " + zBooleanValue);
                if (!zBooleanValue) {
                    throw new IntentNotResolvableException("get mini_program error: " + wx_app_id + "," + wx_app_username + "," + wx_app_path + "," + wx_business_type + "," + wx_ext_msg);
                }
                return;
            }
            return;
        }
        if (com.sigmob.sdk.base.utils.m.a((CharSequence) wx_app_id) || com.sigmob.sdk.base.utils.m.a((CharSequence) wx_app_username) || com.sigmob.sdk.base.utils.m.a((CharSequence) wx_app_path)) {
            throw new IntentNotResolvableException("get mini_program error: " + wx_app_id + "," + wx_app_username + "," + wx_app_path + "," + wx_business_type + "," + wx_ext_msg);
        }
        Class<?> cls3 = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
        Method method3 = cls3.getMethod("createWXAPI", Context.class, String.class);
        method3.setAccessible(true);
        Object objInvoke2 = method3.invoke(cls3, context, wx_app_id);
        Class<?> cls4 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
        Object objNewInstance2 = cls4.newInstance();
        Field declaredField3 = cls4.getDeclaredField("userName");
        declaredField3.setAccessible(true);
        declaredField3.set(objNewInstance2, wx_app_username);
        Field declaredField4 = cls4.getDeclaredField("path");
        declaredField4.setAccessible(true);
        declaredField4.set(objNewInstance2, wx_app_path);
        if (com.sigmob.sdk.base.utils.m.b(wx_ext_msg)) {
            Field declaredField5 = cls4.getDeclaredField("extData");
            declaredField5.setAccessible(true);
            declaredField5.set(objNewInstance2, wx_ext_msg);
        }
        Field declaredField6 = cls4.getDeclaredField("miniprogramType");
        declaredField6.setAccessible(true);
        declaredField6.set(objNewInstance2, 0);
        Method method4 = objInvoke2.getClass().getMethod("sendReq", objNewInstance2.getClass().getSuperclass());
        method4.setAccessible(true);
        boolean zBooleanValue2 = ((Boolean) method4.invoke(objInvoke2, objNewInstance2)).booleanValue();
        SigmobLog.d("openB:isSendReq " + zBooleanValue2);
        if (!zBooleanValue2) {
            throw new IntentNotResolvableException("get mini_program error: " + wx_app_id + "," + wx_app_username + "," + wx_app_path + "," + wx_business_type + "," + wx_ext_msg);
        }
    }

    public static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static boolean a(Context context, String packageName) {
        return com.sigmob.sdk.base.o.a().m() == 0 ? e(context, packageName) : d(context, packageName);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.czhj.sdk.common.exceptions.IntentNotResolvableException */
    public static void b(Context context, Intent intent) throws IntentNotResolvableException {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        String str = "Unable to open intent: " + intent;
        if (com.sigmob.sdk.base.o.a().m() == 0 && !a(context, intent)) {
            throw new IntentNotResolvableException("Could not handle application specific action: " + intent.toString() + "\n\tYou may be running in the emulator or another device which does not have the required application.");
        }
        a(context, intent, str);
    }

    public static void b(Context context, Uri uri, String errorMessage) throws IntentNotResolvableException {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(uri);
        a(context, new Intent("android.intent.action.VIEW", uri), errorMessage);
    }

    public static boolean b(Context context, String packageName) {
        File externalCacheDir;
        File parentFile;
        File parentFile2;
        try {
            File file = new File("/data/data", packageName);
            String absolutePath = file.getAbsolutePath();
            boolean zExists = file.exists();
            SigmobLogger.d(a, "launchApp: cacheDir = " + absolutePath + ", exists = " + zExists, new Object[0]);
            if (zExists) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            externalCacheDir = context.getExternalCacheDir();
        } catch (Exception unused2) {
        }
        if (externalCacheDir == null || (parentFile = externalCacheDir.getParentFile()) == null || (parentFile2 = parentFile.getParentFile()) == null) {
            return false;
        }
        File file2 = new File(parentFile2, packageName);
        String absolutePath2 = file2.getAbsolutePath();
        boolean zExists2 = file2.exists();
        SigmobLogger.d(a, "launchApp: packagePath = " + absolutePath2 + ", exists = " + zExists2, new Object[0]);
        return zExists2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.czhj.sdk.common.exceptions.IntentNotResolvableException */
    private static void c(Context context, Intent intent) throws IntentNotResolvableException {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            intent.addFlags(872415232);
            Activity activityI = com.sigmob.sdk.b.i();
            if (activityI == null) {
                activityI = com.sigmob.sdk.b.c();
            }
            if (activityI == null) {
                context.startActivity(intent);
            } else {
                activityI.startActivity(intent);
            }
        } catch (Throwable th) {
            SigmobLog.e("error ", th);
            throw new IntentNotResolvableException(th);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.czhj.sdk.common.exceptions.IntentNotResolvableException */
    public static boolean c(Context context, String packageName) throws IntentNotResolvableException {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage == null) {
            throw new IntentNotResolvableException("Could not handle application specific action: " + packageName + "\n\tYou may be running in the emulator or another.");
        }
        c(context, launchIntentForPackage);
        return true;
    }

    public static boolean d(Context context, String packageName) {
        if (context != null && !com.sigmob.sdk.base.utils.m.a((CharSequence) packageName)) {
            try {
                boolean zB = com.sigmob.sdk.base.utils.n.b(context.getPackageManager().getApplicationInfo(packageName, 0));
                SigmobLogger.d(a, "installedWithAInfo: enable = " + zB, new Object[0]);
                return zB;
            } catch (Exception e) {
                SigmobLogger.e(a, "installedWithAInfo: error = " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    public static boolean e(Context context, String packageName) {
        if (context != null && !com.sigmob.sdk.base.utils.m.a((CharSequence) packageName)) {
            try {
                boolean zB = com.sigmob.sdk.base.utils.n.b(context.getPackageManager().getLaunchIntentForPackage(packageName));
                SigmobLogger.d(a, "installedWithLInfo: enable = " + zB, new Object[0]);
                return zB;
            } catch (Exception e) {
                SigmobLogger.e(a, "installedWithLInfo: error = " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    public static boolean f(Context context, String packageName) {
        if (context != null && !com.sigmob.sdk.base.utils.m.a((CharSequence) packageName)) {
            try {
                boolean zB = com.sigmob.sdk.base.utils.n.b(context.getPackageManager().getPackageInfo(packageName, 0));
                SigmobLogger.d(a, "installedWithPInfo: enable = " + zB, new Object[0]);
                return zB;
            } catch (Exception e) {
                SigmobLogger.e(a, "installedWithPInfo: error = " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }
}
