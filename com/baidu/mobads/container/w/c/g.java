package com.baidu.mobads.container.w.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.container.util.ay;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class g implements Application.ActivityLifecycleCallbacks, e {
    private volatile boolean a = false;

    @Override // com.baidu.mobads.container.w.c.e
    public synchronized void d() {
        if (!this.a) {
            this.a = true;
            a();
        }
    }

    @Override // com.baidu.mobads.container.w.c.e
    public synchronized void e() {
        if (this.a) {
            this.a = false;
            b();
        }
    }

    protected void a() {
    }

    protected void b() {
    }

    @Override // com.baidu.mobads.container.w.c.e
    public boolean c() {
        return this.a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getClass() != null && TextUtils.equals(activity.getClass().getName(), ay.c)) {
            b(activity, bundle, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity.getClass() != null && TextUtils.equals(activity.getClass().getName(), ay.c)) {
            e(activity, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.getClass() != null && TextUtils.equals(activity.getClass().getName(), ay.c)) {
            b(activity, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (activity.getClass() != null && TextUtils.equals(activity.getClass().getName(), ay.c)) {
            a(activity, bundle, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity.getClass() != null && TextUtils.equals(activity.getClass().getName(), ay.c)) {
            d(activity, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity.getClass() != null && TextUtils.equals(activity.getClass().getName(), ay.c)) {
            a(activity, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity.getClass() != null && TextUtils.equals(activity.getClass().getName(), ay.c)) {
            c(activity, activity.getClass().getName());
        }
    }

    public void a(Activity activity, String str) {
    }

    public void b(Activity activity, String str) {
    }

    public void a(Activity activity, Bundle bundle, String str) {
    }

    public void c(Activity activity, String str) {
    }

    public void d(Activity activity, String str) {
    }

    public void e(Activity activity, String str) {
    }

    public void b(Activity activity, Bundle bundle, String str) {
    }
}
