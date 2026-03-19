package com.bytedance.bdtracker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class w implements Application.ActivityLifecycleCallbacks {
    public static final k0 a = new k0(null, "@APPLOG_APP_USE");
    public static boolean b = false;
    public static int c;
    public static d4 d;
    public static d4 e;
    public static long f;
    public static String g;
    public static Object h;
    public static long i;
    public static final Map<Integer, List<d4>> j;
    public static final List<WeakReference<Object>> k;
    public static d4 l;
    public static final HashSet<Integer> m;
    public static volatile w n;

    static {
        Arrays.asList("android.arch.lifecycle.ReportFragment", "androidx.lifecycle.ReportFragment");
        Collections.singletonList("com.bumptech.glide.manager.SupportRequestManagerFragment");
        c = 0;
        j = new HashMap();
        k = new ArrayList();
        m = new HashSet<>(8);
        n = null;
    }

    public static d4 a() {
        d4 d4Var = d;
        d4 d4Var2 = e;
        if (d4Var2 != null) {
            return d4Var2;
        }
        if (d4Var != null) {
            return d4Var;
        }
        return null;
    }

    public static d4 a(boolean z, d4 d4Var, long j2) {
        d4 d4Var2 = (d4) d4Var.m347clone();
        d4Var2.a(j2);
        long j3 = j2 - d4Var.c;
        if (j3 <= 0) {
            j3 = 1000;
        }
        d4Var2.s = j3;
        d4Var2.D = z;
        b.a(d4Var2, new v(d4Var2));
        b.a(new t(d4Var2), new u());
        return d4Var2;
    }

    public static synchronized w a(Application application) {
        if (n == null) {
            n = new w();
            application.registerActivityLifecycleCallbacks(n);
        }
        return n;
    }

    public void a(Activity activity, int i2) {
        d4 d4VarA = a(activity.getClass(), false, activity.getClass().getName(), "", u4.c(activity), u4.b(activity), System.currentTimeMillis(), u4.d(activity));
        d = d4VarA;
        d4VarA.A = !m.remove(Integer.valueOf(i2)) ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a.a(jCurrentTimeMillis);
        b = false;
        IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
        Object[] objArr = new Object[1];
        objArr[0] = activity != null ? activity.getClass().getName() : "";
        iAppLogLoggerGlobal.debug("onActivityPaused:{}", objArr);
        d4 d4Var = e;
        if (d4Var != null) {
            Object obj = h;
            if (d4Var != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                i = jCurrentTimeMillis2;
                a(true, e, jCurrentTimeMillis2);
                e = null;
                h = null;
            }
            if (obj != null) {
                Iterator<WeakReference<Object>> it = k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<Object> next = it.next();
                    if (next != null && next.get() == obj) {
                        it.remove();
                        break;
                    }
                }
            }
        }
        d4 d4Var2 = d;
        if (d4Var2 != null) {
            g = d4Var2.u;
            f = jCurrentTimeMillis;
            a(false, d4Var2, jCurrentTimeMillis);
            d = null;
            if (activity != null) {
                activity.isChild();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a.c(jCurrentTimeMillis);
        b = true;
        String strC = u4.c(activity);
        LoggerImpl.global().debug("onActivityResumed:{} {}", strC, activity.getClass().getName());
        d4 d4VarA = a(activity.getClass(), false, activity.getClass().getName(), "", strC, u4.b(activity), jCurrentTimeMillis, u4.d(activity));
        d = d4VarA;
        d4VarA.A = !m.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        activity.isChild();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        c++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (g != null) {
            int i2 = c - 1;
            c = i2;
            if (i2 <= 0) {
                g = null;
                i = 0L;
                f = 0L;
                b.a(new c());
            }
        }
    }

    public static d4 a(Class<?> cls, boolean z, String str, String str2, String str3, String str4, long j2, JSONObject jSONObject) {
        d4 d4Var = new d4();
        d4Var.E = cls;
        if (TextUtils.isEmpty(str2)) {
            d4Var.u = str;
        } else {
            d4Var.u = str + ":" + str2;
        }
        d4Var.a(j2);
        d4Var.z = j2;
        d4Var.s = -1L;
        d4 d4Var2 = l;
        d4Var.t = d4Var2 != null ? d4Var2.u : "";
        if (str3 == null) {
            str3 = "";
        }
        d4Var.v = str3;
        d4 d4Var3 = l;
        d4Var.w = d4Var3 != null ? d4Var3.v : "";
        if (str4 == null) {
            str4 = "";
        }
        d4Var.x = str4;
        d4 d4Var4 = l;
        d4Var.y = d4Var4 != null ? d4Var4.x : "";
        d4Var.o = jSONObject;
        d4Var.D = z;
        b.a(d4Var, new v(d4Var));
        l = d4Var;
        return d4Var;
    }
}
