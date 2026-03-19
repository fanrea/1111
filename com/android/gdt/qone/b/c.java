package com.android.gdt.qone.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class c {
    public static Context a;

    public static Context a() {
        Context context;
        synchronized (c.class) {
            if (a == null) {
                Context context2 = null;
                try {
                    context2 = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                a = context2;
            }
            context = a;
        }
        return context;
    }

    public static String a(Context context) {
        String packageName;
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && !TextUtils.isEmpty(applicationInfo.packageName)) {
                packageName = applicationInfo.packageName;
            } else {
                packageName = a().getPackageName();
            }
            return packageName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str) {
        String str2;
        try {
            str2 = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }
}
