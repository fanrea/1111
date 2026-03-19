package com.component.c;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private final ActivityManager a;

    public a(Context context) {
        this.a = new b(context).a();
    }

    public List<ActivityManager.RunningAppProcessInfo> a() {
        return this.a.getRunningAppProcesses();
    }

    public List<ActivityManager.RunningServiceInfo> a(int i) {
        return this.a.getRunningServices(i);
    }

    @Deprecated
    public List<ActivityManager.RunningTaskInfo> b(int i) {
        return this.a.getRunningTasks(i);
    }

    public List<ActivityManager.ProcessErrorStateInfo> b() {
        return this.a.getProcessesInErrorState();
    }

    public void a(ActivityManager.MemoryInfo memoryInfo) {
        this.a.getMemoryInfo(memoryInfo);
    }

    @Deprecated
    public List<ActivityManager.RecentTaskInfo> a(int i, int i2) {
        return this.a.getRecentTasks(i, i2);
    }
}
