package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class z00 {
    private Handler a;
    private Context b;
    private t00 c;
    private x00 d;
    private Runnable e;
    private Runnable f;
    private Runnable g;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.SDK_INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.ITEM_ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.PAGE_SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[l.NETWORK_CHANGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: A */
    private enum l {
        SDK_INIT,
        BACKGROUND,
        ITEM_ADD,
        PAGE_SWITCH,
        NETWORK_CHANGE
    }

    /* compiled from: A */
    private static final class m {
        private static final z00 a = new z00(null);
    }

    static /* synthetic */ Context a(z00 z00Var) {
        return (Context) pro.getobjresult(138, 1, z00Var);
    }

    private void a() {
        pro.getVresult(139, 0, this);
    }

    private <T extends u00> void a(v0<T> v0Var, T t, boolean z) {
        pro.getVresult(140, 0, this, v0Var, t, Boolean.valueOf(z));
    }

    private void b() {
        pro.getVresult(141, 0, this);
    }

    static /* synthetic */ void b(z00 z00Var) {
        pro.getVresult(142, 1, z00Var);
    }

    public static z00 c() {
        return (z00) pro.getobjresult(143, 1, new Object[0]);
    }

    static /* synthetic */ void c(z00 z00Var) {
        pro.getVresult(144, 1, z00Var);
    }

    static /* synthetic */ t00 d(z00 z00Var) {
        return (t00) pro.getobjresult(145, 1, z00Var);
    }

    private void d() {
        pro.getVresult(146, 0, this);
    }

    static /* synthetic */ x00 e(z00 z00Var) {
        return (x00) pro.getobjresult(147, 1, z00Var);
    }

    private void e() {
        pro.getVresult(148, 0, this);
    }

    private void f() {
        pro.getVresult(149, 0, this);
    }

    static /* synthetic */ void f(z00 z00Var) {
        pro.getVresult(150, 1, z00Var);
    }

    static /* synthetic */ void g(z00 z00Var) {
        pro.getVresult(151, 1, z00Var);
    }

    static /* synthetic */ void h(z00 z00Var) {
        pro.getVresult(152, 1, z00Var);
    }

    public void a(Context context) {
        pro.getVresult(153, 0, this, context);
    }

    void a(r00 r00Var, boolean z) {
        pro.getVresult(154, 0, this, r00Var, Boolean.valueOf(z));
    }

    void a(v00 v00Var) {
        pro.getVresult(155, 0, this, v00Var);
    }

    void a(l lVar) {
        pro.getVresult(156, 0, this, lVar);
    }

    private z00() {
        this.e = new d();
        this.f = new e();
        this.g = new f();
        Context contextA = r1.d().a();
        this.b = contextA;
        this.c = new t00(contextA);
        this.d = new x00(this.b);
        HandlerThread handlerThread = new HandlerThread("gdt_stat_service");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            this.a = new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Context context = this.b;
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(new k(this));
            }
        }
        a(this.b);
        a(l.SDK_INIT);
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new b());
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p00.a(z00.a(z00.this).getApplicationContext()).c();
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ v0 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ u00 c;

        c(v0 v0Var, boolean z, u00 u00Var) {
            this.a = v0Var;
            this.b = z;
            this.c = u00Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.a(this.b);
                this.a.a((v0) this.c);
                if (this.b) {
                    this.a.f();
                } else {
                    z00.this.a(l.ITEM_ADD);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z00.b(z00.this);
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z00.c(z00.this);
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (s3.b().c()) {
                return;
            }
            z00.this.a(l.BACKGROUND);
        }

        f() {
        }
    }

    /* compiled from: A */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z00.d(z00.this).g();
            z00.e(z00.this).g();
        }
    }

    /* compiled from: A */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z00.d(z00.this).a();
            z00.e(z00.this).a();
        }
    }

    /* synthetic */ z00(b bVar) {
        this();
    }

    /* compiled from: A */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z00.d(z00.this).f();
            z00.e(z00.this).f();
        }
    }

    /* compiled from: A */
    class j extends BroadcastReceiver {
        j() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            z00.f(z00.this);
        }
    }

    /* compiled from: A */
    private static final class k implements Application.ActivityLifecycleCallbacks {
        private z00 a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        public k(z00 z00Var) {
            this.a = z00Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            this.a.a(l.PAGE_SWITCH);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            z00.g(this.a);
            z00.h(this.a);
        }
    }
}
