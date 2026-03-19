package com.ss.android.socialbase.downloader.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.e.an;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private volatile int an;
    private final List<InterfaceC0785d> b;
    private int c;
    private Application d;
    private final Application.ActivityLifecycleCallbacks gb;
    private volatile boolean h;
    private b hc;
    private WeakReference<Activity> u;

    public interface b {
    }

    /* renamed from: com.ss.android.socialbase.downloader.d.d$d, reason: collision with other inner class name */
    public interface InterfaceC0785d {
        void b();

        void hc();
    }

    public static d d() {
        return hc.d;
    }

    private static class hc {
        private static final d d = new d();
    }

    private d() {
        this.b = new ArrayList();
        this.an = -1;
        this.h = false;
        this.gb = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.d.d.1
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
                d.this.u = new WeakReference(activity);
                int i = d.this.c;
                d.this.c = activity != null ? activity.hashCode() : i;
                d.this.h = false;
                if (i == 0) {
                    d.this.u();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i = d.this.c;
                d.this.h = false;
                d.this.c = activity != null ? activity.hashCode() : i;
                if (i == 0) {
                    d.this.u();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                d.this.h = true;
                if (d.this.c != 0 || activity == null) {
                    return;
                }
                d.this.c = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == d.this.c) {
                    d.this.c = 0;
                    d.this.an();
                }
                d.this.h = false;
            }
        };
    }

    public void d(Context context) {
        if (this.d == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.d == null) {
                    Application application = (Application) context;
                    this.d = application;
                    application.registerActivityLifecycleCallbacks(this.gb);
                }
            }
        }
    }

    public void d(b bVar) {
        this.hc = bVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    public boolean hc() {
        int i = this.an;
        int i2 = i;
        if (i == -1) {
            ?? H = h();
            this.an = H;
            i2 = H;
        }
        return i2 == 1;
    }

    public boolean b() {
        return hc() && !this.h;
    }

    public void d(InterfaceC0785d interfaceC0785d) {
        if (interfaceC0785d == null) {
            return;
        }
        synchronized (this.b) {
            if (!this.b.contains(interfaceC0785d)) {
                this.b.add(interfaceC0785d);
            }
        }
    }

    public void hc(InterfaceC0785d interfaceC0785d) {
        synchronized (this.b) {
            this.b.remove(interfaceC0785d);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.b) {
            array = this.b.size() > 0 ? this.b.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.an = 1;
        Object[] objArrC = c();
        if (objArrC != null) {
            for (Object obj : objArrC) {
                ((InterfaceC0785d) obj).hc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        this.an = 0;
        Object[] objArrC = c();
        if (objArrC != null) {
            for (Object obj : objArrC) {
                ((InterfaceC0785d) obj).b();
            }
        }
    }

    private boolean h() {
        try {
            Application application = this.d;
            if (application == null) {
                return false;
            }
            application.getSystemService("activity");
            return TextUtils.equals(application.getPackageName(), an.c(application));
        } catch (Throwable th) {
            mq.d(th);
            return false;
        }
    }
}
