package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class i {
    private static volatile String a;

    public static synchronized String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = a;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + (str2.endsWith(Config.replace) ? "" : Config.replace) + d.a(str2);
    }

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            a = Application.getProcessName();
            return a;
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                try {
                    next = it.next();
                } catch (Exception unused) {
                }
                if (next.pid == iMyPid) {
                    a = next.processName;
                    return a;
                }
                continue;
            }
        }
        return null;
    }
}
