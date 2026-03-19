package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t {
    private static boolean a = true;
    private static int b = 0;
    private static String c = "";
    private static int d = 0;

    public static boolean a() {
        return a;
    }

    public static void a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
        } catch (Exception e) {
        }
    }

    public static Intent b(Context context, String str) {
        try {
            return a(context, new File(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static Intent a(Context context, File file) {
        Uri uriB;
        if (file != null) {
            try {
                if (!file.exists()) {
                    return null;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                if (!a(context)) {
                    intent.addFlags(268435456);
                    uriB = Uri.fromFile(file);
                } else {
                    intent.addFlags(268435457);
                    uriB = b(context, file);
                }
                if (uriB == null) {
                    return null;
                }
                intent.setDataAndType(uriB, "application/vnd.android.package-archive");
                if (a()) {
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                }
                return intent;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static boolean a(Context context) {
        return x.a(context).a() >= 24;
    }

    public static Uri b(Context context, File file) {
        try {
            return a(context, context.getPackageName() + ".bd.provider", file);
        } catch (Exception e) {
            return null;
        }
    }

    public static Uri a(Context context, String str, File file) {
        Class<? super Object> superclass;
        Object objA = null;
        try {
            try {
                superclass = Class.forName(ay.d).getSuperclass();
            } catch (Throwable th) {
                bq.a().a("TAG", "getUriForFile exception.");
            }
        } catch (ClassNotFoundException e) {
            superclass = null;
        }
        objA = bo.a(superclass, (Object) null, "getUriForFile", (Class<?>[]) new Class[]{Context.class, String.class, File.class}, new Object[]{context, str, file});
        return (Uri) objA;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (!a(context) || c(context)) {
                return true;
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                if (g(context, bw.a(externalFilesDir.getPath()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean c(Context context) {
        File fileC;
        return x.a(context).a() <= 28 && bl.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && bl.a("permission_storage") && (fileC = com.component.c.c.c()) != null && g(context, bw.a(fileC.getPath()));
    }

    private static boolean g(Context context, String str) {
        if (!a(context)) {
            return true;
        }
        try {
            File file = new File(str + "t");
            if (!file.exists()) {
                file.mkdir();
            }
            return b(context, file) != null;
        } catch (Exception e) {
            bq.a().c(e);
            return false;
        }
    }

    public static void c(Context context, File file) {
        try {
            context.startActivity(a(context, file));
        } catch (Exception e) {
        }
    }

    public static void c(Context context, String str) {
        try {
            context.startActivity(b(context, str));
        } catch (Exception e) {
        }
    }

    public static String d(Context context, String str) {
        try {
            PackageInfo packageInfoA = bk.a(context, str, 128);
            return packageInfoA == null ? "" : String.valueOf(packageInfoA.versionCode);
        } catch (Throwable th) {
            return "";
        }
    }

    public static int d(Context context) {
        return bk.a(context, context.getPackageName(), 16384).versionCode;
    }

    public static a e(Context context, String str) {
        try {
            PackageInfo packageInfoA = bk.a(context, str, 1);
            if (packageInfoA != null) {
                return new a(packageInfoA);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean f(Context context, String str) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : new com.component.c.a(context).a()) {
                String str2 = runningAppProcessInfo.processName;
                int iMyPid = Process.myPid();
                if (!str2.equals(str) && runningAppProcessInfo.pid != iMyPid) {
                }
                if (runningAppProcessInfo.importance != 100) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static int e(Context context) {
        try {
            if (b <= 0) {
                b = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        } catch (Exception e) {
        }
        return b;
    }

    public static String f(Context context) {
        if (context == null) {
            return "";
        }
        return context.getPackageName();
    }

    public static String g(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            c = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0)).toString();
            return c;
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.f(th.getMessage());
            return "";
        }
    }

    public static int h(Context context) {
        if (d != 0) {
            return d;
        }
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo packageInfoA = bk.a(context, context.getPackageName(), 0);
            if (packageInfoA != null) {
                d = packageInfoA.versionCode;
                return d;
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.f(th.getMessage());
        }
        return 0;
    }

    public static boolean a(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != 0;
    }

    public static String b() {
        String property = System.getProperty("https.proxyHost");
        String property2 = System.getProperty("https.proxyPort");
        if (property != null && property2 != null) {
            return property + ":" + property2;
        }
        String property3 = System.getProperty("http.proxyHost");
        String property4 = System.getProperty("http.proxyPort");
        if (property3 != null && property4 != null) {
            return property3 + ":" + property4;
        }
        return null;
    }

    public static boolean c() {
        try {
            return new File("/system/bin/su").exists();
        } catch (Throwable th) {
            return false;
        }
    }

    public static int i(Context context) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration.touchscreen != 3) {
                if (configuration.touchscreen != 2) {
                    return 0;
                }
            }
            return 1;
        } catch (Throwable th) {
            return 1;
        }
    }

    public static Class<?> d() {
        Object objA = null;
        try {
            objA = bo.a(Class.forName(ay.b), (Object) null, "getActivityClass", (Class<?>[]) null, (Object[]) null);
        } catch (Exception e) {
            bq.a().a("TAG", "getActivityClass exception.");
        }
        if (objA == null) {
            try {
                return Class.forName(ay.b);
            } catch (ClassNotFoundException e2) {
                bq.a().a("TAG", "getActivityClass ClassNotFoundException.");
            }
        }
        return (Class) objA;
    }

    public static Class<?> e() {
        Object objA = null;
        try {
            objA = bo.a(Class.forName(ay.a), (Object) null, "getActivityClass", (Class<?>[]) null, (Object[]) null);
        } catch (Exception e) {
            bq.a().a("TAG", "getShellActivityClass exception.");
        }
        if (objA == null) {
            try {
                return Class.forName(ay.a);
            } catch (ClassNotFoundException e2) {
                bq.a().a("TAG", "getShellActivityClass ClassNotFoundException.");
            }
        }
        return (Class) objA;
    }

    public static class a {
        public final int a;
        public final String b = "";
        public final String c;
        public final String d;
        private PackageInfo e;

        public a(PackageInfo packageInfo) {
            this.e = packageInfo;
            this.c = packageInfo.packageName;
            this.d = packageInfo.versionName;
            this.a = packageInfo.versionCode;
        }

        public JSONObject a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", this.c);
                jSONObject.put("v", this.d);
                jSONObject.put("c", this.a);
                jSONObject.put("s", new File(this.e.applicationInfo.sourceDir).lastModified());
            } catch (JSONException e) {
            }
            return jSONObject;
        }

        public JSONObject b() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("p", this.c);
                jSONObject.put("v", this.d);
                jSONObject.put("c", this.a);
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }
}
