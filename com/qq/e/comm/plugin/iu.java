package com.qq.e.comm.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class iu {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static volatile long d;
    private static int e;

    public static long b() {
        return d;
    }

    public static boolean c() {
        return c.get();
    }

    public static boolean d() {
        return a.get();
    }

    public static boolean e() {
        return e == 1;
    }

    @Deprecated
    private static void g(Context context) {
        if (o50.c()) {
            r1.d().c().e();
        }
        lv.a();
        new x2();
        c(context);
        t1.c();
    }

    private static void i(Context context) throws ClassNotFoundException {
        if (System.currentTimeMillis() - yy.a("iret", 0L) < 86400000) {
            return;
        }
        yy.b("iret", System.currentTimeMillis());
        i50.g();
        xt.b();
        o3.d().e();
        t3.i();
        if (su.h() >= 460) {
            b10.a(9130003, null, Integer.valueOf(o50.a()), Integer.valueOf(r1.d().c().n()), null);
        }
        j(context);
        b10.a(9200007, null, Integer.valueOf(t10.d() ? 1 : 2), Integer.valueOf(t10.b()), null);
        lv.b();
        if (!GlobalSetting.isEnableVideoDownloadingCache()) {
            b10.a(1130124, (f5) null);
        }
        xt.a(context);
        yh.f();
        jt.a();
        lz.d();
    }

    private static void b(Context context) {
        if (n3.c()) {
            new qx().h();
        }
    }

    private static void c(Context context) {
        if (GlobalSetting.isAgreePrivacyStrategy() && r1.d().f().a("adson", 1) == 1) {
            ((l2) ma.ALLID.c()).c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) throws JSONException, ClassNotFoundException {
        com.qq.e.comm.plugin.b.c();
        boolean zB = o1.b();
        if (zB) {
            f(context);
            u2.a().c();
        }
        if (e()) {
            com.qq.e.comm.dynamic.c.a().c();
            j60.a().b();
        }
        sf.l().j();
        ub.c().d();
        f();
        e(context);
        if (!zB) {
            g(context);
        }
        b(context);
        lf.a();
        kp.b().a();
        ui.a().b();
        s1.d().f();
        o3.d().b(context);
        vv.h();
        vs.l().a(context);
        z1.b();
        tb.a(1);
        com.qq.e.comm.plugin.apkmanager.l.e().g();
        i(context);
        a3.a();
        d8.a();
        ro.b().d();
        c.set(true);
        zu.a(context);
    }

    private static void e(Context context) {
        boolean zB = o50.b();
        String defaultUserAgent = (!zB || Build.VERSION.SDK_INT < 17) ? null : WebSettings.getDefaultUserAgent(context);
        if (TextUtils.isEmpty(defaultUserAgent)) {
            a(context, zB);
        } else {
            r1.d().c().a(defaultUserAgent);
            a(context, false);
        }
    }

    public static void a(Context context, JSONObject jSONObject) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        j20 j20Var = new j20();
        j20Var.d();
        r1.d().b(context, jSONObject);
        j20Var.c();
        j2.l().a(context, "e_qq_com_dog");
        j20Var.a();
        as.a(context);
        j20Var.d();
        vx vxVarF = r1.d().f();
        vxVarF.k();
        j20Var.c();
        p5.b().c();
        j20Var.a();
        h(context);
        s3.b().a(context);
        wt wtVarB = new wt(2130302).b(SystemClock.elapsedRealtime() - jElapsedRealtime).b(e);
        ja jaVarA = new ja().a("data", j20Var.toString()).a("data2", vxVarF.f()).a("data3", vxVarF.g()).a("pv", Integer.valueOf(r1.d().e().b()));
        b10.a(wtVarB);
        wtVarB.a(jaVarA);
        if (su.h() < 560) {
            a((JSONObject) null);
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                iu.d(this.a);
            } catch (Throwable unused) {
            }
        }
    }

    private static void f(Context context) {
        try {
            ma.IMEI.c().a(context);
            ma.ANDROIDID.c().a(context);
            c(context);
            lv.a();
            t1.c();
            if (o50.c()) {
                r1.d().c().e();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static void f() {
        jh.c().j();
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;

        b(Context context, boolean z) {
            this.a = context;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                jm jmVarA = new qh(this.a).a();
                if (this.b) {
                    r1.d().c().a(jmVarA.e());
                }
                jmVarA.d();
            } catch (Throwable unused) {
            }
        }
    }

    private static void h(Context context) {
        if (context == null || r1.d().f().a("bgac", 0) == 0 || !(context.getApplicationContext() instanceof Application)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(b1.b());
    }

    private static void j(Context context) throws ClassNotFoundException {
        int i;
        int i2 = -1;
        try {
            Class.forName("com.tencent.bugly.crashreport.CrashReport");
            i = 1;
        } catch (Exception e2) {
            e2.getMessage();
            i = -1;
        }
        if (i == -1) {
            try {
                Class.forName("com.tencent.feedback.eup.CrashReport");
                i = 2;
            } catch (Exception e3) {
                e3.getMessage();
            }
        }
        try {
            i2 = context.getApplicationInfo().targetSdkVersion;
        } catch (Exception e4) {
            e4.getMessage();
        }
        b10.a(9200006, null, Integer.valueOf(i), Integer.valueOf(i2), null);
    }

    private static void a(Context context, boolean z) {
        if (z || r1.d().f().a("piwv", 0) == 1) {
            xo.d(new b(context, z));
        }
    }

    public static int a() {
        return e;
    }

    public static void a(JSONObject jSONObject) throws JSONException {
        if (a.compareAndSet(false, true)) {
            e = r1.d().f().a("sioe", 0);
            boolean zE = e();
            d = SystemClock.elapsedRealtime();
            j20 j20Var = new j20();
            j20Var.d();
            r1.d().b(jSONObject);
            Context contextA = r1.d().a();
            j20Var.c();
            jd.l().a(contextA);
            j20Var.c();
            c20.b(contextA);
            j20Var.c();
            bv.c().b();
            j20Var.c();
            jh.c().l();
            j20Var.c();
            kg.d().q();
            j20Var.c();
            if (!zE) {
                j60.a().b();
            }
            j20Var.c();
            q8.a();
            j20Var.c();
            if (!zE) {
                com.qq.e.comm.dynamic.c.a().c();
            }
            j20Var.c();
            s20.a().a(true);
            j20Var.a();
            o7.c();
            com.qq.e.comm.plugin.apkmanager.e.a().b();
            j20Var.d();
            c0.e().a(true);
            j20Var.a();
            pf.a();
            qg.b.submit(new a(contextA));
            b10.a();
            b.set(true);
            wt wtVarB = new wt(2130303).b(SystemClock.elapsedRealtime() - d).b(e);
            wtVarB.a(new ja().a("data", j20Var.toString()).a("pv", Integer.valueOf(r1.d().e().b())));
            b10.a(wtVarB);
        }
    }
}
