package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ay {
    private static String cmM = "";
    private static volatile Boolean cmN;

    public static String getProcessName(Context context) {
        if (!TextUtils.isEmpty(cmM)) {
            return cmM;
        }
        String strApn = apn();
        cmM = strApn;
        if (!TextUtils.isEmpty(strApn)) {
            return cmM;
        }
        String strApo = apo();
        cmM = strApo;
        if (!TextUtils.isEmpty(strApo)) {
            return cmM;
        }
        String strEe = ee(context);
        cmM = strEe;
        return strEe;
    }

    private static String apn() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String apo() {
        try {
            Object objCallStaticMethod = z.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return objCallStaticMethod instanceof String ? (String) objCallStaticMethod : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String ee(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static boolean isInMainProcess(Context context) {
        if (cmN == null) {
            String processName = getProcessName(context);
            cmN = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return cmN.booleanValue();
    }
}
