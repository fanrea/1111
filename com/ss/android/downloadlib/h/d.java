package com.ss.android.downloadlib.h;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.b.b.d(new File(str));
    }

    public static int d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.b.b.d(str, new File(str2));
    }

    public static String hc(String str) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.mq.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void d() {
        if (com.ss.android.downloadlib.addownload.mq.tt().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.u.d().d(new Runnable() { // from class: com.ss.android.downloadlib.h.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.an.u.gb();
                d.b();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        Field declaredField;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null || (cls = Class.forName("android.app.IActivityManager")) == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0757d(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static void d(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.mq.tt().optInt("hook", 0) == 1 && (objArr[1] instanceof String)) {
            Object obj = objArr[2];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.hc.u.d.equals(intent.getType())) {
                    if (com.ss.android.socialbase.appdownloader.an.u.c()) {
                        String strOptString = com.ss.android.downloadlib.addownload.mq.tt().optString("hook_vivo_arg", "com.android.settings");
                        if (ILogConst.CACHE_PLAY_REASON_NULL.equals(strOptString)) {
                            return;
                        }
                        objArr[1] = strOptString;
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.an.u.u()) {
                        String strOptString2 = com.ss.android.downloadlib.addownload.mq.tt().optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.hc.u.b + ".market");
                        if (!ILogConst.CACHE_PLAY_REASON_NULL.equals(strOptString2)) {
                            objArr[1] = strOptString2;
                        }
                        String strOptString3 = com.ss.android.downloadlib.addownload.mq.tt().optString("hook_kllk_arg2", "com.android.browser");
                        String strOptString4 = com.ss.android.downloadlib.addownload.mq.tt().optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.hc.u.b + "mobile.com");
                        intent.putExtra(com.ss.android.socialbase.downloader.hc.u.b + "_extra_pkg_name", strOptString3);
                        intent.putExtra("refererHost", strOptString4);
                        if (com.ss.android.downloadlib.addownload.mq.tt().optInt("hook_kllk_arg4", 0) == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra(com.ss.android.socialbase.downloader.hc.u.b + "_extra_pkg_name", strOptString3);
                            intent2.putExtra("refererHost", strOptString4);
                            intent.putExtra("android.intent.extra.INTENT", intent2);
                            return;
                        }
                        return;
                    }
                    if (com.ss.android.socialbase.appdownloader.an.u.d()) {
                        String strOptString5 = com.ss.android.downloadlib.addownload.mq.tt().optString("hook_huawei_arg1", "com.huawei.appmarket");
                        if (!ILogConst.CACHE_PLAY_REASON_NULL.equals(strOptString5)) {
                            objArr[1] = strOptString5;
                        }
                        intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.mq.tt().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.h.d$d, reason: collision with other inner class name */
    private static class C0757d implements InvocationHandler {
        private Object d;

        private C0757d(Object obj) {
            this.d = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    d.d(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.d, objArr);
        }
    }
}
