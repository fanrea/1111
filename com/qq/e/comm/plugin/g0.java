package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.qq.e.comm.plugin.jk;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class g0 implements jk, Application.ActivityLifecycleCallbacks {
    protected final Activity a;
    protected final long b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    protected final AtomicBoolean h = new AtomicBoolean();

    abstract String b();

    protected abstract void c();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public g0(Activity activity, long j) {
        this.a = activity;
        this.b = j;
        activity.getApplication().registerActivityLifecycleCallbacks(this);
    }

    @Override // com.qq.e.comm.plugin.jk
    public void start() {
        this.h.set(true);
    }

    @Override // com.qq.e.comm.plugin.jk
    public final void stop() {
        this.a.getApplication().unregisterActivityLifecycleCallbacks(this);
    }

    protected void a(int i) {
        if (i < 3) {
            this.c++;
            return;
        }
        if (i < 9) {
            this.d++;
            return;
        }
        if (i < 24) {
            this.e++;
        } else if (i < 42) {
            this.f++;
        } else {
            this.g++;
        }
    }

    @Override // com.qq.e.comm.plugin.jk
    public jk.a a() {
        return new jk.a(this.c, this.d, this.e, this.f, this.g);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (activity == this.a && !this.h.get()) {
            b();
            start();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (activity != this.a) {
            return;
        }
        b();
        this.h.set(false);
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity != this.a) {
            return;
        }
        b();
        activity.getApplication().unregisterActivityLifecycleCallbacks(this);
    }
}
