package com.baidu.mobads.container.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bn {
    private static final bn b = new bn();
    private String a;

    private bn() {
    }

    public static bn a() {
        return b;
    }

    public String a(Context context) {
        try {
            com.component.c.a aVar = new com.component.c.a(context);
            if (this.a == null) {
                int iMyPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> listA = aVar.a();
                if (listA != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : listA) {
                        if (runningAppProcessInfo.pid == iMyPid) {
                            this.a = runningAppProcessInfo.processName;
                        }
                    }
                }
            }
            return this.a;
        } catch (Exception e) {
            return this.a;
        }
    }

    public int b() {
        try {
            return Process.myPid();
        } catch (Exception e) {
            return 0;
        }
    }
}
