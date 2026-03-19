package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.provider.Settings;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class cb {
    public static boolean a(Context context) {
        return 17 <= x.a(context).a() ? 1 == Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) : 1 == Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0);
    }

    public static String b(Context context) {
        int iMyPid = Process.myPid();
        com.component.c.a aVar = new com.component.c.a(context);
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : aVar.a()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        for (ActivityManager.RunningServiceInfo runningServiceInfo : aVar.a(10)) {
            if (runningServiceInfo.pid == iMyPid) {
                return runningServiceInfo.process;
            }
        }
        return "";
    }

    public static String a() {
        try {
            return (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(x.a(null).a() >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            return "";
        }
    }
}
