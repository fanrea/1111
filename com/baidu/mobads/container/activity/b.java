package com.baidu.mobads.container.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.style.widget.viewpager2.State;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    private final List<a> a;
    private Activity b;
    private State c;

    public b() {
        this.c = State.DESTROYED;
        this.a = new CopyOnWriteArrayList();
    }

    public b(Activity activity) {
        this();
        a(activity);
    }

    public static b a(Activity activity, a aVar) {
        b bVar = new b(activity);
        bVar.a(aVar);
        return bVar;
    }

    public Activity a() {
        return this.b;
    }

    public State b() {
        return this.c;
    }

    public void a(State state) {
        this.c = state;
    }

    public void a(Activity activity) {
        this.b = activity;
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(this);
            return;
        }
        Application application = activity.getApplication();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this);
        }
    }

    public void c() {
        if (this.b == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.b.unregisterActivityLifecycleCallbacks(this);
        } else {
            Application application = this.b.getApplication();
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this);
            }
        }
        this.b = null;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.a.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.a.remove(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.b == activity) {
            this.c = State.CREATED;
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(this, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.b == activity) {
            this.c = State.STARTED;
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityStarted(this);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.b == activity) {
            this.c = State.RESUMED;
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(this);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.b == activity) {
            this.c = State.STARTED;
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(this);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.b == activity) {
            this.c = State.CREATED;
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityStopped(this);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this.b == activity) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(this, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.b == activity) {
            this.c = State.DESTROYED;
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(this);
            }
            this.a.clear();
            this.b = null;
        }
    }

    public static abstract class a {
        public void onActivityCreated(b bVar, Bundle bundle) {
        }

        public void onActivityStarted(b bVar) {
        }

        public void onActivityResumed(b bVar) {
        }

        public void onActivityPaused(b bVar) {
        }

        public void onActivityStopped(b bVar) {
        }

        public void onActivitySaveInstanceState(b bVar, Bundle bundle) {
        }

        public void onActivityDestroyed(b bVar) {
        }
    }
}
