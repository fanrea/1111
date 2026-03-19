package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ActivityLifeObserver {
    private static final ActivityLifeObserver c = new ActivityLifeObserver();
    private boolean a;
    private Application.ActivityLifecycleCallbacks b;
    private Set<IActivityLifeCallback> d = new LinkedHashSet();

    public interface IActivityLifeCallback {
        void onActivityCreated(Activity activity, Bundle bundle);

        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);

        void onActivitySaveInstanceState(Activity activity, Bundle bundle);

        void onActivityStarted(Activity activity);

        void onActivityStopped(Activity activity);
    }

    public static ActivityLifeObserver instance() {
        return c;
    }

    public void addObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.d) {
            this.d.add(iActivityLifeCallback);
        }
    }

    public void clearObservers() {
        synchronized (this.d) {
            this.d.clear();
        }
    }

    public void removeObserver(IActivityLifeCallback iActivityLifeCallback) {
        synchronized (this.d) {
            this.d.remove(iActivityLifeCallback);
        }
    }

    public void registerActivityLifeCallback(Context context) {
        if (this.a || Build.VERSION.SDK_INT < 14) {
            return;
        }
        doRegister(context);
        this.a = true;
    }

    public void unRegister(Context context) {
        try {
            ((Application) context.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doRegister(Context context) {
        this.b = new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.mobstat.forbes.ActivityLifeObserver.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    Iterator it = ActivityLifeObserver.this.d.iterator();
                    while (it.hasNext()) {
                        ((IActivityLifeCallback) it.next()).onActivityResumed(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    Iterator it = ActivityLifeObserver.this.d.iterator();
                    while (it.hasNext()) {
                        ((IActivityLifeCallback) it.next()).onActivityPaused(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                synchronized (ActivityLifeObserver.this.d) {
                    Iterator it = ActivityLifeObserver.this.d.iterator();
                    while (it.hasNext()) {
                        ((IActivityLifeCallback) it.next()).onActivityCreated(activity, bundle);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    Iterator it = ActivityLifeObserver.this.d.iterator();
                    while (it.hasNext()) {
                        ((IActivityLifeCallback) it.next()).onActivityStarted(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    Iterator it = ActivityLifeObserver.this.d.iterator();
                    while (it.hasNext()) {
                        ((IActivityLifeCallback) it.next()).onActivityStopped(activity);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                synchronized (ActivityLifeObserver.this.d) {
                    Iterator it = ActivityLifeObserver.this.d.iterator();
                    while (it.hasNext()) {
                        ((IActivityLifeCallback) it.next()).onActivitySaveInstanceState(activity, bundle);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                synchronized (ActivityLifeObserver.this.d) {
                    Iterator it = ActivityLifeObserver.this.d.iterator();
                    while (it.hasNext()) {
                        ((IActivityLifeCallback) it.next()).onActivityDestroyed(activity);
                    }
                }
            }
        };
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.b);
        } catch (Exception e) {
            v.c().a("registerActivityLifecycleCallbacks encounter exception");
        }
    }
}
