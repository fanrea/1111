package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class yo implements Application.ActivityLifecycleCallbacks {
    private static String an = null;
    private static long b = 0;
    private static String c = null;
    private static int d = 0;
    private static int h = -1;
    private static i hc;
    private static final HashSet<Integer> tt = new HashSet<>(8);
    private static long u;
    private final an gb;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public yo(an anVar) {
        this.gb = anVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        i iVarD = d(activity.getClass().getName(), "", System.currentTimeMillis(), c);
        hc = iVarD;
        iVarD.rf = !tt.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            h = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e) {
            um.hc(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        i iVar = hc;
        if (iVar != null) {
            c = iVar.k;
            long jCurrentTimeMillis = System.currentTimeMillis();
            b = jCurrentTimeMillis;
            d(hc, jCurrentTimeMillis);
            hc = null;
            if (activity.isChild()) {
                return;
            }
            h = -1;
        }
    }

    public static i d(String str, String str2, long j, String str3) {
        i iVar = new i();
        if (!TextUtils.isEmpty(str2)) {
            iVar.k = str + ":" + str2;
        } else {
            iVar.k = str;
        }
        iVar.hc = j;
        iVar.mq = -1L;
        if (str3 == null) {
            str3 = "";
        }
        iVar.uo = str3;
        de.d(iVar);
        return iVar;
    }

    public static i d(i iVar, long j) {
        i iVar2 = (i) iVar.clone();
        iVar2.hc = j;
        long j2 = j - iVar.hc;
        if (j2 >= 0) {
            iVar2.mq = j2;
        } else {
            um.hc((Throwable) null);
        }
        de.d(iVar2);
        return iVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        d++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (c != null) {
            int i = d - 1;
            d = i;
            if (i <= 0) {
                c = null;
                an = null;
                u = 0L;
                b = 0L;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        tt.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        tt.add(Integer.valueOf(activity.hashCode()));
    }
}
