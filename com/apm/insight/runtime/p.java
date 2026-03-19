package com.apm.insight.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.CrashInfoCallback;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.IUploadCallback;
import com.apm.insight.nativecrash.NativeImpl;
import java.io.File;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class p {
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static c f = new c();
    private static volatile boolean g = false;
    private static boolean h = false;

    public static c a() {
        return f;
    }

    public static void a(long j) {
        NativeImpl.a(j);
    }

    public static synchronized void a(Application application, Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (a) {
            return;
        }
        a = true;
        if (context == null || application == null) {
            throw new IllegalArgumentException("context or Application must be not null.");
        }
        com.apm.insight.g.a(application, context);
        if (com.apm.insight.g.s() && (a(application) || b(application) || q())) {
            Log.e("apminsight", "Inner npth checked.");
            return;
        }
        if (z || z2) {
            com.apm.insight.h.a aVarA = com.apm.insight.h.a.a();
            if (z2) {
                aVarA.a(new com.apm.insight.j.b(context));
            }
            if (z) {
                aVarA.b(new com.apm.insight.h.d(context));
            }
            b = true;
        }
        NativeImpl.a();
        if (z3) {
            boolean zA = NativeImpl.a(context);
            d = zA;
            if (!zA) {
                e = true;
            }
        }
        if (z4 && Looper.myLooper() == Looper.getMainLooper()) {
            g = true;
            NativeImpl.h();
        }
        g(z4);
        com.apm.insight.o.q.a((Object) ("Npth.init takes " + (SystemClock.uptimeMillis() - jUptimeMillis) + " ms."));
    }

    public static synchronized void a(Context context, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        Application applicationG;
        if (com.apm.insight.g.g() != null) {
            applicationG = com.apm.insight.g.g();
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
        a(applicationG, context, z, z2, z3, z4, j);
    }

    public static void a(CrashInfoCallback crashInfoCallback) {
        a().a(crashInfoCallback);
    }

    public static void a(ICrashCallback iCrashCallback, CrashType crashType) {
        a().a(iCrashCallback, crashType);
    }

    public static void a(IOOMCallback iOOMCallback) {
        a().a(iOOMCallback);
    }

    public static void a(IOOMCallback iOOMCallback, CrashType crashType) {
        a().b(iOOMCallback);
    }

    public static void a(com.apm.insight.d dVar) {
        com.apm.insight.g.h().setEncryptImpl(dVar);
    }

    public static void a(com.apm.insight.n.k kVar) {
        com.apm.insight.n.f.a(kVar);
    }

    public static void a(k kVar) {
        l.a(kVar);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str);
    }

    public static void a(String str, com.apm.insight.a.b bVar, com.apm.insight.a.c cVar) {
    }

    public static void a(final String str, final com.apm.insight.e eVar) {
        q.b().a(new Runnable() { // from class: com.apm.insight.runtime.p.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.apm.insight.o.a.b(com.apm.insight.g.f())) {
                    com.apm.insight.b.d.a(str, eVar);
                }
            }
        });
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, IUploadCallback iUploadCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, iUploadCallback);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, IUploadCallback iUploadCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, map3, iUploadCallback);
    }

    @Deprecated
    public static void a(Throwable th) {
        if (com.apm.insight.g.h().isReportErrorEnable()) {
            com.apm.insight.h.a.a(th);
        }
    }

    public static void a(boolean z) {
        com.apm.insight.g.b(z);
    }

    private static boolean a(Context context) {
        try {
            return new File(com.apm.insight.o.p.j(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(long j) {
        NativeImpl.b(j);
    }

    public static void b(ICrashCallback iCrashCallback, CrashType crashType) {
        a().b(iCrashCallback, crashType);
    }

    @Deprecated
    public static void b(String str) {
        if (com.apm.insight.g.h().isReportErrorEnable()) {
            com.apm.insight.h.a.c(str);
        }
    }

    public static void b(boolean z) {
        com.apm.insight.g.c(z);
    }

    public static boolean b() {
        return b;
    }

    private static boolean b(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libnpth.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(long j) {
        NativeImpl.c(j);
    }

    public static void c(String str) {
        NativeImpl.b(str);
    }

    public static void c(boolean z) {
        com.apm.insight.g.d(z);
    }

    public static boolean c() {
        return c;
    }

    public static void d(boolean z) {
        com.apm.insight.g.e(z);
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        return a;
    }

    public static void f() {
        if (!a || b) {
            return;
        }
        Context contextF = com.apm.insight.g.f();
        com.apm.insight.h.a aVarA = com.apm.insight.h.a.a();
        aVarA.a(new com.apm.insight.j.b(contextF));
        aVarA.b(new com.apm.insight.h.d(contextF));
    }

    public static void g() {
        if (a) {
            com.apm.insight.b.g.a(com.apm.insight.g.f()).a();
            c = true;
        }
    }

    private static void g(final boolean z) {
        q.b().a(new Runnable() { // from class: com.apm.insight.runtime.p.2
            @Override // java.lang.Runnable
            public void run() {
                if (z && !p.g) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.apm.insight.runtime.p.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean unused = p.g = true;
                            NativeImpl.h();
                        }
                    });
                }
                p.h(z);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(boolean r3) {
        /*
            android.content.Context r0 = com.apm.insight.g.f()
            com.apm.insight.runtime.a.f.a()
            com.apm.insight.runtime.n.a()
            java.lang.String r1 = "Npth.initAsync-createCallbackThread"
            com.apm.insight.i.a(r1)
            int r1 = com.apm.insight.nativecrash.NativeImpl.b()
            com.apm.insight.i.a()
            com.apm.insight.nativecrash.NativeImpl.c()
            boolean r2 = com.apm.insight.runtime.p.e
            if (r2 == 0) goto L27
            com.apm.insight.c r1 = com.apm.insight.b.a()
            java.lang.String r2 = "NativeLibraryLoad faild"
        L23:
            r1.a(r2)
            goto L30
        L27:
            if (r1 >= 0) goto L30
            com.apm.insight.c r1 = com.apm.insight.b.a()
            java.lang.String r2 = "createCallbackThread faild"
            goto L23
        L30:
            java.lang.String r1 = "Npth.initAsync-NpthDataManager"
            com.apm.insight.i.a(r1)
            com.apm.insight.e.a r1 = com.apm.insight.e.a.a()
            r1.a(r0)
            com.apm.insight.i.a()
            com.apm.insight.b.a()
            java.lang.String r1 = "Npth.initAsync-LaunchScanner"
            com.apm.insight.i.a(r1)
            com.apm.insight.n.l.a(r0)
            com.apm.insight.i.a()
            if (r3 == 0) goto L60
            java.lang.String r1 = "Npth.initAsync-CrashANRHandler"
            com.apm.insight.i.a(r1)
            com.apm.insight.b.g r1 = com.apm.insight.b.g.a(r0)
            r1.a()
            com.apm.insight.i.a()
            com.apm.insight.runtime.p.c = r3
        L60:
            java.lang.String r1 = "Npth.initAsync-EventUploadQueue"
            com.apm.insight.i.a(r1)
            com.apm.insight.n.i r1 = com.apm.insight.n.i.a()
            r1.b()
            com.apm.insight.i.a()
            java.lang.String r1 = "Npth.initAsync-BlockMonitor"
            com.apm.insight.i.a(r1)
            com.apm.insight.i.a()
            java.lang.String r1 = "Npth.initAsync-OriginExceptionMonitor"
            com.apm.insight.i.a(r1)
            com.apm.insight.i.a()
            com.apm.insight.h.a()
            if (r3 == 0) goto Lab
            com.apm.insight.nativecrash.NativeImpl.f()
            java.lang.String r3 = "fastbot"
            java.io.File r3 = r0.getExternalFilesDir(r3)     // Catch: java.lang.Throwable -> Lab
            android.content.Context r0 = com.apm.insight.g.f()     // Catch: java.lang.Throwable -> Lab
            boolean r0 = com.apm.insight.o.a.b(r0)     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto Lab
            if (r3 == 0) goto Lab
            boolean r0 = r3.exists()     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto Lab
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> Lab
            com.apm.insight.runtime.p$3 r0 = new com.apm.insight.runtime.p$3     // Catch: java.lang.Throwable -> Lab
            r0.<init>()     // Catch: java.lang.Throwable -> Lab
            com.apm.insight.b.d.a(r3, r0)     // Catch: java.lang.Throwable -> Lab
        Lab:
            com.apm.insight.n.o.d()
            com.apm.insight.nativecrash.NativeImpl.j()
            java.lang.String r3 = "afterNpthInitAsync"
            java.lang.String r0 = "noValue"
            com.apm.insight.runtime.s.a(r3, r0)
            boolean r3 = com.apm.insight.g.v()
            if (r3 == 0) goto Ldd
            java.lang.String r3 = com.apm.insight.f.f()     // Catch: java.lang.Throwable -> Ldd
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Ldd
            if (r0 == 0) goto Lc9
            return
        Lc9:
            boolean r3 = com.apm.insight.runtime.a.g(r3)     // Catch: java.lang.Throwable -> Ldd
            if (r3 != 0) goto Ld0
            return
        Ld0:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ldd
            r0 = 29
            if (r3 < r0) goto Ldd
            android.app.Application r3 = com.apm.insight.g.g()     // Catch: java.lang.Throwable -> Ldd
            com.apm.insight.k.a.a(r3)     // Catch: java.lang.Throwable -> Ldd
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.p.h(boolean):void");
    }

    public static boolean h() {
        if (a && !d) {
            boolean zA = NativeImpl.a(com.apm.insight.g.f());
            d = zA;
            if (!zA) {
                e = true;
            }
        }
        return d;
    }

    public static boolean i() {
        return com.apm.insight.b.c.c();
    }

    public static void j() {
        if (a) {
            com.apm.insight.b.g.a(com.apm.insight.g.f()).b();
            c = false;
        }
    }

    public static boolean k() {
        return com.apm.insight.h.a.b() || NativeImpl.d();
    }

    public static boolean l() {
        return com.apm.insight.h.a.c() || NativeImpl.d();
    }

    public static boolean m() {
        return com.apm.insight.h.a.b();
    }

    public static boolean n() {
        return h;
    }

    public static void o() {
        h = true;
    }

    private static boolean q() {
        return false;
    }
}
