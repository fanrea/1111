package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b1 implements Application.ActivityLifecycleCallbacks {
    private static volatile b1 c;
    private int a;
    SparseArray<LinkedHashMap<Integer, Integer>> b = new SparseArray<>();

    private void a(Activity activity, String str) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private b1() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Map.Entry<Integer, Integer> entryB = b(activity);
        if (entryB != null) {
            if (entryB.getValue().intValue() == 6) {
                a(activity).remove(entryB.getKey());
            } else if (entryB.getValue().intValue() == 5) {
                this.a = activity.hashCode();
            }
        }
        a(activity, "onActivityCreated");
        a(activity, 1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        a(activity, "onActivityStarted");
        a(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity, "onActivityResumed");
        a(activity, 3);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity, "onActivityPaused");
        a(activity, 4);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        a(activity, "onActivityStopped");
        a(activity, 5);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity.isChangingConfigurations()) {
            a(activity, 6);
        } else {
            a(activity).remove(Integer.valueOf(activity.hashCode()));
        }
        if (activity.hashCode() == this.a) {
            this.a = 0;
        }
        a(activity, "onActivityDestroyed");
    }

    private LinkedHashMap<Integer, Integer> a(Activity activity) {
        LinkedHashMap<Integer, Integer> linkedHashMap = this.b.get(activity.getTaskId());
        if (linkedHashMap != null) {
            return linkedHashMap;
        }
        LinkedHashMap<Integer, Integer> linkedHashMap2 = new LinkedHashMap<>();
        this.b.put(activity.getTaskId(), linkedHashMap2);
        return linkedHashMap2;
    }

    private Map.Entry<Integer, Integer> b(Activity activity) {
        Iterator<Map.Entry<Integer, Integer>> it = a(activity).entrySet().iterator();
        Map.Entry<Integer, Integer> next = null;
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static b1 b() {
        if (c == null) {
            synchronized (b1.class) {
                if (c == null) {
                    c = new b1();
                }
            }
        }
        return c;
    }

    public int a() {
        return this.a;
    }

    private void a(Activity activity, int i) {
        a(activity).put(Integer.valueOf(activity.hashCode()), Integer.valueOf(i));
    }
}
