package com.sigmob.sdk.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.bytedance.common.utility.DeviceUtils;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    public static int a = 0;
    public static final int b = 32;
    public static final int c = 8;
    private static int d;
    private static int e;
    private static final AtomicBoolean f = new AtomicBoolean(false);

    public static int a(Activity activity) {
        Resources resources;
        int identifier;
        if (!d(activity) || (resources = activity.getResources()) == null || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) == 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int a(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(String key, Context context) throws ClassNotFoundException {
        if (!a()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(key), new Integer(0))).intValue();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return 0;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public static LinkAction a(List<LinkAction> adLinkActions, Uri uri) {
        if (uri != null && !com.sigmob.sdk.base.utils.e.a(adLinkActions)) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            for (LinkAction linkAction : adLinkActions) {
                if (linkAction != null && linkAction.redirect_count.intValue() >= 0) {
                    if (TextUtils.isEmpty(linkAction.scheme) || TextUtils.isEmpty(linkAction.host)) {
                        if (a(scheme, linkAction.scheme) || b(host, linkAction.host)) {
                            return linkAction;
                        }
                    } else if (a(scheme, linkAction.scheme) && b(host, linkAction.host)) {
                        return linkAction;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sigmob.sdk.base.utils.h a(android.view.WindowInsets r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 28
            if (r0 < r2) goto L1e
            android.view.DisplayCutout r4 = r4.getDisplayCutout()
            if (r4 == 0) goto L4c
            int r1 = r4.getSafeInsetTop()
            int r0 = r4.getSafeInsetLeft()
            int r2 = r4.getSafeInsetRight()
            int r4 = r4.getSafeInsetBottom()
            goto L4f
        L1e:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L35
            int r1 = r4.getStableInsetTop()
            int r0 = r4.getStableInsetLeft()
            int r2 = r4.getStableInsetRight()
            int r4 = r4.getStableInsetBottom()
            goto L4f
        L35:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 20
            if (r0 != r2) goto L4c
            int r1 = r4.getSystemWindowInsetTop()
            int r0 = r4.getSystemWindowInsetLeft()
            int r2 = r4.getSystemWindowInsetRight()
            int r4 = r4.getSystemWindowInsetBottom()
            goto L4f
        L4c:
            r4 = r1
            r0 = r4
            r2 = r0
        L4f:
            com.sigmob.sdk.base.utils.h r3 = new com.sigmob.sdk.base.utils.h
            r3.<init>(r1, r0, r4, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoplayer.c.a(android.view.WindowInsets):com.sigmob.sdk.base.utils.h");
    }

    public static String a(long timeMs) {
        if (timeMs <= 0 || timeMs >= 86400000) {
            return "00:00";
        }
        long j = timeMs / 1000;
        int i = (int) (j % 60);
        int i2 = (int) ((j / 60) % 60);
        int i3 = (int) (j / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i3 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)) : formatter.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i))).toString();
    }

    public static String a(String encryptionString) {
        String str;
        if (TextUtils.isEmpty(encryptionString)) {
            return "";
        }
        String str2 = "KLLK";
        if (encryptionString.contains("KLLK")) {
            str = DeviceUtils.ROM_OPPO;
        } else {
            str2 = "kllk";
            if (!encryptionString.contains("kllk")) {
                return "";
            }
            str = "oppo";
        }
        return encryptionString.replace(str2, str);
    }

    public static void a(Context context, int orientation) {
        Activity activityB = b(context);
        if (activityB == null) {
            return;
        }
        activityB.setRequestedOrientation(orientation);
    }

    public static void a(Window window) {
        if (Build.VERSION.SDK_INT < 21) {
            if (Build.VERSION.SDK_INT < 19 || window == null) {
                return;
            }
            window.addFlags(134217728);
            return;
        }
        if (window != null) {
            a = window.getDecorView().getSystemUiVisibility();
            window.clearFlags(134217728);
            window.getDecorView().setSystemUiVisibility(a | 1024 | 4 | 256 | 512);
            window.addFlags(Integer.MIN_VALUE);
            d = window.getStatusBarColor();
            window.setStatusBarColor(0);
            e = window.getNavigationBarColor();
            window.setNavigationBarColor(0);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
        }
    }

    public static boolean a() {
        try {
            return Class.forName("miui.os.Build") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    private static boolean a(String scheme, String actionScheme) {
        return (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(actionScheme) || !scheme.toLowerCase().equals(actionScheme)) ? false : true;
    }

    public static Activity b(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean b(final Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (activity == null) {
            activity = com.sigmob.sdk.b.i();
        }
        if (activity == null) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean b(String host, String actionHost) {
        return (TextUtils.isEmpty(host) || TextUtils.isEmpty(actionHost) || !host.equals(actionHost)) ? false : true;
    }

    public static Window c(Context context) {
        Activity activityB = b(context);
        if (activityB == null) {
            return null;
        }
        return activityB.getWindow();
    }

    public static boolean c(Activity activity) {
        return b(activity) || a("ro.miui.notch", com.sigmob.sdk.b.e()) == 1 || k(com.sigmob.sdk.b.e()) || m(com.sigmob.sdk.b.e()) || l(com.sigmob.sdk.b.e());
    }

    public static void d(Context context) {
        Window windowC;
        if (!f.p || (windowC = c(context)) == null) {
            return;
        }
        windowC.clearFlags(1024);
    }

    public static boolean d(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(activity).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public static void e(Activity activity) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT == 26 && g(activity)) {
            h(activity);
        }
    }

    public static void e(Context context) {
        Window windowC;
        if (!f.p || (windowC = c(context)) == null) {
            return;
        }
        windowC.setFlags(1024, 1024);
    }

    public static void f(Context context) {
        AudioManager audioManager;
        if (context != null) {
            try {
                AtomicBoolean atomicBoolean = f;
                if (atomicBoolean.get() || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
                    return;
                }
                atomicBoolean.set(true);
                audioManager.requestAudioFocus(null, 3, 2);
            } catch (Throwable unused) {
                f.set(false);
            }
        }
    }

    public static boolean f(Activity activity) {
        Window window = activity != null ? activity.getWindow() : null;
        if (window == null) {
            return true;
        }
        return (window.getDecorView().getSystemUiVisibility() & 1028) == 1028 && (Build.VERSION.SDK_INT < 28 || (window.getAttributes().layoutInDisplayCutoutMode & 1) == 1);
    }

    public static void g(Context context) {
        AudioManager audioManager;
        if (context != null) {
            try {
                AtomicBoolean atomicBoolean = f;
                if (atomicBoolean.get() && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
                    atomicBoolean.set(false);
                    audioManager.abandonAudioFocus(null);
                }
            } catch (Throwable unused) {
                f.set(true);
            }
        }
    }

    public static boolean g(Activity activity) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        try {
            Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void h(Activity activity) throws NoSuchFieldException {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void h(Context context) {
        Window windowC;
        if (Build.VERSION.SDK_INT < 21) {
            if (Build.VERSION.SDK_INT < 19 || (windowC = c(context)) == null) {
                return;
            }
            windowC.addFlags(67108864);
            windowC.addFlags(134217728);
            return;
        }
        Window windowC2 = c(context);
        if (windowC2 == null) {
            return;
        }
        a = windowC2.getDecorView().getSystemUiVisibility();
        windowC2.clearFlags(134217728);
        windowC2.getDecorView().setSystemUiVisibility(a | 4096 | 1024 | 4 | 2 | 256 | 512);
        windowC2.addFlags(Integer.MIN_VALUE);
        d = windowC2.getStatusBarColor();
        windowC2.setStatusBarColor(0);
        e = windowC2.getNavigationBarColor();
        windowC2.setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = windowC2.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            windowC2.setAttributes(attributes);
        }
    }

    public static void i(Context context) {
        c(context);
    }

    public static void j(Context context) {
        Window windowC = c(context);
        if (windowC == null) {
            return;
        }
        windowC.getDecorView().setSystemUiVisibility(a);
        if (Build.VERSION.SDK_INT >= 21) {
            windowC.clearFlags(Integer.MIN_VALUE);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = windowC.getAttributes();
            attributes.layoutInDisplayCutoutMode = 0;
            windowC.setAttributes(attributes);
        }
    }

    public static boolean k(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean m(Context context) {
        return context.getPackageManager().hasSystemFeature(a("com.kllk.feature.screen.heteromorphism"));
    }

    public static int n(Context context) {
        int dimensionPixelSize;
        int iDipsToIntPixels = Dips.dipsToIntPixels(30.0f, com.sigmob.sdk.b.e());
        if (context == null) {
            return iDipsToIntPixels;
        }
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
            } else {
                try {
                    Class<?> cls = Class.forName("com.android.internal.R$dimen");
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return iDipsToIntPixels;
                }
            }
            return dimensionPixelSize;
        } catch (Throwable unused) {
            return iDipsToIntPixels;
        }
    }
}
