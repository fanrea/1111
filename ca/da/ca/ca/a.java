package ca.da.ca.ca;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import ca.da.ca.ia.j;
import com.apm.applog.AppLog;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: Navigator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    public static int a;
    public static j b;
    public static j c;
    public static long d;
    public static String e;
    public static final HashSet<Integer> f;

    static {
        new HashMap();
        f = new HashSet<>(8);
    }

    public static j a() {
        j jVar = b;
        j jVar2 = c;
        if (jVar2 != null) {
            return jVar2;
        }
        if (jVar != null) {
            return jVar;
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        f.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        f.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Window window;
        j jVarA = a(activity.getClass().getName(), "", System.currentTimeMillis(), e);
        b = jVarA;
        jVarA.o = !f.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild() || (window = activity.getWindow()) == null || window.getDecorView() == null) {
            return;
        }
        window.getDecorView().hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (e != null) {
            int i = a - 1;
            a = i;
            if (i <= 0) {
                e = null;
                d = 0L;
            }
        }
    }

    public void a(String str, int i) {
        j jVarA = a(str, "", System.currentTimeMillis(), e);
        b = jVarA;
        jVarA.o = !f.remove(Integer.valueOf(i)) ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        j jVar = b;
        if (jVar != null) {
            e = jVar.n;
            long jCurrentTimeMillis = System.currentTimeMillis();
            d = jCurrentTimeMillis;
            j jVar2 = b;
            j jVar3 = (j) jVar2.m290clone();
            jVar3.a(jCurrentTimeMillis);
            long j = jCurrentTimeMillis - jVar2.b;
            if (j <= 0) {
                j = 1000;
            }
            jVar3.l = j;
            AppLog.receive(jVar3);
            b = null;
            if (activity != null) {
                activity.isChild();
            }
        }
    }

    public static j a(String str, String str2, long j, String str3) {
        j jVar = new j();
        if (!TextUtils.isEmpty(str2)) {
            jVar.n = str + ":" + str2;
        } else {
            jVar.n = str;
        }
        jVar.a(j);
        jVar.l = -1L;
        if (str3 == null) {
            str3 = "";
        }
        jVar.m = str3;
        AppLog.receive(jVar);
        return jVar;
    }
}
