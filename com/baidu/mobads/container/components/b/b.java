package com.baidu.mobads.container.components.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    private static volatile b a;
    private volatile boolean b = false;
    private final CopyOnWriteArrayList<a> c = new CopyOnWriteArrayList<>();

    private b() {
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public boolean a(Context context, a aVar) {
        if (context != null && aVar != null) {
            if (!this.b) {
                this.b = a(context);
            }
            if (this.b) {
                return this.c.add(aVar);
            }
            return false;
        }
        return false;
    }

    public void b(Context context, a aVar) {
        this.c.remove(aVar);
        if (this.c.isEmpty()) {
            this.b = !b(context);
        }
    }

    private boolean a(Context context) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Application) {
                    ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private boolean b(Context context) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Application) {
                    ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this);
                    return true;
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.a(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.b(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.c(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.d(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.b(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Iterator<a> it = this.c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.e(activity);
            }
        }
    }
}
