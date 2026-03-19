package com.bytedance.bdtracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.migrate.MigrateDetectorActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h2 {
    public static volatile h2 e;
    public final PackageManager a;
    public final ComponentName b;
    public final boolean c;
    public final SharedPreferences d;

    public h2(Context context) {
        int componentEnabledSetting;
        int i;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("bdtracker_dr_migrate_detector", 0);
        this.d = sharedPreferences;
        PackageManager packageManager = applicationContext.getPackageManager();
        this.a = packageManager;
        ComponentName componentName = new ComponentName(context, (Class<?>) MigrateDetectorActivity.class);
        this.b = componentName;
        try {
            componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            i = sharedPreferences.getInt("component_state", 0);
            LoggerImpl.global().debug(a.a("MigrateDetector#isMigrateInternal cs=").append(a(componentEnabledSetting)).append(" ss=").append(a(i)).toString(), new Object[0]);
        } catch (Exception unused) {
        }
        boolean z = componentEnabledSetting == 0 && i == 2;
        this.c = z;
        LoggerImpl.global().debug(a.a("MigrateDetector#constructor migrate=").append(z).toString(), new Object[0]);
    }

    public static h2 a(Context context) {
        if (e == null) {
            synchronized (h2.class) {
                if (e == null) {
                    e = new h2(context);
                }
            }
        }
        return e;
    }

    public static String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "STATE_DISABLED" : "STATE_ENABLED" : "STATE_DEFAULT";
    }

    public void a() {
        LoggerImpl.global().debug("MigrateDetector#disableComponent", new Object[0]);
        this.a.setComponentEnabledSetting(this.b, 2, 1);
        this.d.edit().putInt("component_state", 2).apply();
    }
}
