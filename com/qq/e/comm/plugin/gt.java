package com.qq.e.comm.plugin;

import android.app.Activity;
import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gt {
    private static final Set<Integer> b;
    private Map<Activity, Integer> a = new WeakHashMap(1);

    static {
        b = Build.VERSION.SDK_INT >= 18 ? Collections.unmodifiableSet(new HashSet(Arrays.asList(-1, 2, 10, 4, 13))) : Collections.unmodifiableSet(new HashSet(Arrays.asList(-1, 2, 10, 4)));
    }

    public void a(Activity activity) {
        try {
            b(activity);
        } catch (Throwable unused) {
        }
    }

    private boolean a() {
        return Build.VERSION.SDK_INT > 8;
    }

    public void b(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        if (b.contains(Integer.valueOf(requestedOrientation))) {
            int i = activity.getResources().getConfiguration().orientation;
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (i == 2) {
                if (a() && (rotation == 2 || rotation == 3)) {
                    activity.setRequestedOrientation(8);
                } else {
                    activity.setRequestedOrientation(0);
                }
            } else if (a() && (rotation == 2 || rotation == 1)) {
                activity.setRequestedOrientation(9);
            } else {
                activity.setRequestedOrientation(1);
            }
            this.a.put(activity, Integer.valueOf(requestedOrientation));
        }
    }

    public void c() {
        Map<Activity, Integer> map = this.a;
        if (map == null) {
            return;
        }
        map.size();
        for (Activity activity : this.a.keySet()) {
            if (activity != null) {
                activity.setRequestedOrientation(this.a.get(activity).intValue());
            }
        }
        this.a.clear();
    }

    public void b() {
        try {
            c();
        } catch (IllegalStateException unused) {
        }
    }
}
