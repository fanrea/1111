package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r10 implements Application.ActivityLifecycleCallbacks {
    private static final String h = "r10";
    private CountDownLatch a;
    private final AtomicBoolean b;
    private final int c;
    private final int d;
    private WeakReference<Activity> e;
    private final Application f;
    private a g;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    public r10() {
        this(r1.d().f().a("swst", 1500), r1.d().f().a("swctt", 6000));
    }

    public boolean f() {
        if (this.f != null && this.c > 0 && this.d > 0 && this.b.compareAndSet(false, true)) {
            e();
            try {
                this.f.registerActivityLifecycleCallbacks(this);
                return true;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return false;
    }

    public a c() {
        CountDownLatch countDownLatch;
        if (this.b.get() && (countDownLatch = this.a) != null) {
            try {
                if (!countDownLatch.await(this.d, TimeUnit.MILLISECONDS) && this.g.d == 0) {
                    this.g.d = 4;
                }
                this.f.unregisterActivityLifecycleCallbacks(this);
            } catch (Throwable th) {
                th.getMessage();
            }
            a aVar = this.g;
            this.b.set(false);
            int unused = aVar.d;
            return aVar;
        }
        return this.g;
    }

    public r10(int i, int i2) {
        this.b = new AtomicBoolean(false);
        this.c = i;
        this.d = i2;
        Context contextA = r1.d().a();
        this.f = contextA instanceof Application ? (Application) contextA : null;
        this.g = new a();
    }

    public void a() {
        b();
        c();
    }

    private void e() {
        this.g = new a();
        this.e = null;
        this.a = new CountDownLatch(1);
    }

    public boolean d() {
        return this.b.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        long unused = this.g.a;
        if (this.g.a <= 0 || !a(activity)) {
            return;
        }
        this.g.c = System.currentTimeMillis();
        this.g.d = 3;
        b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        long unused = this.g.a;
        long unused2 = this.g.c;
        if (this.g.a == 0) {
            this.e = new WeakReference<>(activity);
            this.g.a = System.currentTimeMillis();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        long unused = this.g.a;
        if (this.g.a <= 0 || !a(activity)) {
            return;
        }
        this.g.b = System.currentTimeMillis();
        a aVar = this.g;
        aVar.d = aVar.b - this.g.a <= ((long) this.c) ? 1 : 2;
        b();
    }

    private void b() {
        CountDownLatch countDownLatch = this.a;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* compiled from: A */
    public static class a {
        private long a = 0;
        private long b = 0;
        private long c = 0;
        private int d = 0;

        public boolean f() {
            int i = this.d;
            return (i == 0 || i == 1) ? false : true;
        }

        public boolean e() {
            return this.d == 2;
        }

        public boolean d() {
            return this.d == 3;
        }

        public long c() {
            return this.b;
        }

        public long b() {
            return this.c;
        }

        public long a() {
            return this.a;
        }
    }

    private boolean a(Activity activity) {
        WeakReference<Activity> weakReference = this.e;
        return weakReference != null && weakReference.get() == activity;
    }
}
