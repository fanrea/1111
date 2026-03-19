package com.apm.insight;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.apm.applog.network.INetworkClient;
import com.apm.insight.n.j;
import com.apm.insight.n.m;
import com.apm.insight.n.n;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.u;
import com.baidu.mobstat.forbes.Config;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class g {
    private static Context a = null;
    private static Application b = null;
    private static long c = 0;
    private static String d = "default";
    private static boolean e = false;
    private static com.apm.insight.runtime.d f;
    private static volatile ConcurrentHashMap<Integer, String> i;
    private static volatile String n;
    private static boolean s;
    private static boolean t;
    private static boolean u;
    private static boolean v;
    private static boolean w;
    private static boolean x;
    private static ConfigManager g = new ConfigManager();
    private static a h = new a();
    private static u j = null;
    private static volatile String k = null;
    private static Object l = new Object();
    private static volatile int m = 0;
    private static int o = 0;
    private static INetworkClient p = null;
    private static int q = ExitType.NONE.type;
    private static boolean r = false;

    static {
        s = Build.VERSION.SDK_INT < 31 || !com.apm.insight.o.d.c();
        t = true;
        u = true;
        v = false;
        w = true;
        x = false;
    }

    public static j a(String str, String str2, Map<String, String> map, boolean z) {
        INetworkClient iNetworkClient = p;
        return (iNetworkClient == null || (iNetworkClient instanceof com.apm.insight.n.h)) ? new m(str, str2, map, z) : new n(str, str2, map, z);
    }

    public static com.apm.insight.runtime.d a() {
        if (f == null) {
            f = com.apm.insight.runtime.j.a(a);
        }
        return f;
    }

    public static String a(long j2, CrashType crashType, boolean z, boolean z2) {
        return j2 + Config.replace + crashType.getName() + '_' + e() + '_' + (z ? "oom_" : "normal_") + i() + '_' + (z2 ? "ignore_" : "normal_") + Long.toHexString(new Random().nextLong()) + "G";
    }

    public static void a(int i2) {
        o = i2;
    }

    static void a(int i2, String str) {
        if (i == null) {
            synchronized (g.class) {
                if (i == null) {
                    i = new ConcurrentHashMap<>();
                }
            }
        }
        i.put(Integer.valueOf(i2), str);
    }

    public static void a(Application application) {
        if (application != null) {
            b = application;
        }
    }

    public static void a(Application application, Context context) {
        if (b == null) {
            c = System.currentTimeMillis();
            a = context;
            b = application;
            k = Long.toHexString(new Random().nextLong()) + "G";
        }
    }

    static void a(Application application, Context context, ICommonParams iCommonParams) {
        a(application, context);
        f = new com.apm.insight.runtime.d(a, iCommonParams, a());
    }

    public static synchronized void a(Context context, ICommonParams iCommonParams) {
        Application applicationG;
        if (g() != null) {
            applicationG = g();
        } else if (context instanceof Application) {
            applicationG = (Application) context;
            if (applicationG.getBaseContext() == null) {
                throw new IllegalArgumentException("初始化时传入的Application还未attach, 请在init时传入attachBaseContext的参数, 并在init之前手动调用Npth.setApplication(Application).");
            }
        } else {
            applicationG = (Application) context.getApplicationContext();
            if (applicationG == null) {
                throw new IllegalArgumentException("初始化时传入了baseContext, 导致无法获取Application实例, 请在init之前手动调用Npth.setApplication(Application).");
            }
            if (applicationG.getBaseContext() != null) {
                context = applicationG.getBaseContext();
            }
        }
        a(applicationG, context, iCommonParams);
    }

    public static void a(INetworkClient iNetworkClient) {
        p = iNetworkClient;
    }

    public static void a(com.apm.insight.runtime.d dVar) {
        f = dVar;
    }

    static void a(String str) {
        d = str;
    }

    static void a(boolean z) {
        e = z;
    }

    public static a b() {
        return h;
    }

    public static void b(int i2) {
        q = i2;
    }

    static void b(int i2, String str) {
        m = i2;
        n = str;
    }

    public static void b(boolean z) {
        t = z;
    }

    public static u c() {
        if (j == null) {
            synchronized (g.class) {
                j = new u(a);
            }
        }
        return j;
    }

    public static void c(boolean z) {
        u = z;
    }

    public static String d() {
        return e() + '_' + Long.toHexString(new Random().nextLong()) + "G";
    }

    public static void d(boolean z) {
        v = z;
    }

    public static String e() {
        if (k == null) {
            synchronized (l) {
                if (k == null) {
                    k = Long.toHexString(new Random().nextLong()) + "U";
                }
            }
        }
        return k;
    }

    public static void e(boolean z) {
        w = z;
    }

    public static Context f() {
        return a;
    }

    public static void f(boolean z) {
        x = z;
    }

    public static Application g() {
        return b;
    }

    public static void g(boolean z) {
        r = z;
    }

    public static ConfigManager h() {
        return g;
    }

    public static void h(boolean z) {
        s = z && s;
    }

    public static long i() {
        return c;
    }

    public static String j() {
        return d;
    }

    public static int k() {
        return o;
    }

    public static boolean l() {
        return e;
    }

    public static ConcurrentHashMap<Integer, String> m() {
        return i;
    }

    public static int n() {
        return m;
    }

    public static String o() {
        return n;
    }

    public static INetworkClient p() {
        if (p == null) {
            p = new com.apm.insight.n.h();
        }
        return p;
    }

    public static boolean q() {
        return t;
    }

    public static boolean r() {
        return u;
    }

    public static boolean s() {
        return v;
    }

    public static boolean t() {
        return w;
    }

    public static int u() {
        return q;
    }

    public static boolean v() {
        return x;
    }

    public static boolean w() {
        return r;
    }

    public static boolean x() {
        return s;
    }
}
