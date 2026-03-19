package com.tencent.turingfd.sdk.ams.au;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.throw, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cthrow {
    public static final WeakHashMap<Activity, Object> a = new WeakHashMap<>();
    public static final AtomicReference<Cdo> b = new AtomicReference<>(null);

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.throw$do, reason: invalid class name */
    public static class Cdo extends com.tencent.turingfd.sdk.ams.au.Cdo implements Cnew, Durian {
        public final AtomicBoolean a = new AtomicBoolean(false);
        public final Cconst b;

        public Cdo(Cconst cconst) {
            this.b = cconst;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            this.a.set(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Window window;
            if (activity != null && (window = activity.getWindow()) != null) {
                String name = activity.getClass().getName();
                try {
                    WeakHashMap<Activity, Object> weakHashMap = Cthrow.a;
                    if (!weakHashMap.containsKey(activity)) {
                        weakHashMap.put(activity, null);
                        Window.Callback callback = window.getCallback();
                        if (callback != null && !(callback instanceof Orange)) {
                            window.setCallback(new Orange(callback, name, this));
                        }
                        ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.addOnPreDrawListener(new Csuper(window, this, name));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.a.set(false);
        }
    }
}
