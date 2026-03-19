package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements Application.ActivityLifecycleCallbacks {
    private static volatile hc d;
    private final b hc;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private hc(Application application) {
        this.hc = b.d(application);
    }

    public static hc d(Application application) {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc(application);
                    application.registerActivityLifecycleCallbacks(d);
                }
            }
        }
        return d;
    }

    public void hc(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public String d(String str, long j, int i, boolean z) {
        b bVar = this.hc;
        if (bVar != null) {
            return bVar.d(str, j, i, z);
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        b bVar = this.hc;
        if (bVar != null) {
            bVar.d(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT >= 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        d.d(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        View decorView;
        if (Build.VERSION.SDK_INT < 29 || activity == null || activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return;
        }
        d.d(decorView);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        b bVar = this.hc;
        if (bVar != null) {
            bVar.hc(activity);
        }
    }
}
