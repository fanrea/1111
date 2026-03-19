package com.component.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    public static final int a = 65536;
    public static final int b = 131072;
    public static final int c = 64;
    public static final int d = 128;
    private final PackageManager e;

    public d(Context context) {
        this.e = context.getPackageManager();
    }

    public List<ResolveInfo> a(Intent intent, int i) {
        if (Build.VERSION.SDK_INT >= 33) {
            return this.e.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(i));
        }
        return this.e.queryIntentActivities(intent, i);
    }

    public PackageInfo a(String str, int i) {
        return this.e.getPackageInfo(str, i);
    }

    @Deprecated
    public int a(List<IntentFilter> list, List<ComponentName> list2, String str) {
        return this.e.getPreferredActivities(list, list2, str);
    }

    public Intent a(String str) {
        return this.e.getLaunchIntentForPackage(str);
    }

    public ApplicationInfo b(String str, int i) {
        return this.e.getApplicationInfo(str, i);
    }
}
