package com.qq.e.comm.plugin;

import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o7 {
    private static long a;

    public static void b(Throwable th) {
        ja jaVar = new ja();
        jaVar.a("data", th.getMessage());
        jaVar.a("msg", Log.getStackTraceString(th));
        b10.b(9730000, new f5(), 0, jaVar);
    }

    public static void c() {
        if (r1.d().f().a("rece", 0) == 0) {
            return;
        }
        a = System.currentTimeMillis();
        qg.f.schedule(new a(), 1000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() throws Throwable {
        Thread.setDefaultUncaughtExceptionHandler(new b(Thread.getDefaultUncaughtExceptionHandler()));
        e();
    }

    private static void e() throws Throwable {
        File fileB = b();
        if (fileB == null || !fileB.exists()) {
            return;
        }
        String strD = gu.d(fileB);
        fileB.delete();
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        ja jaVar = new ja();
        jaVar.a("msg", strD);
        jaVar.a("azd", ma.ANDROIDID.c().b(r1.d().a()));
        b10.b(9120017, new f5(), 0, jaVar);
    }

    private static void f() {
        SharedPreferences sharedPreferences = r1.d().a().getSharedPreferences("start_crash", 0);
        sharedPreferences.edit().putInt("crash_count", sharedPreferences.getInt("crash_count", 0) + 1).commit();
    }

    private static File b() {
        File file = new File(r1.d().a().getCacheDir(), "gdt_crash");
        if (file.exists() || !file.mkdirs()) {
            return new File(file, "crash");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Throwable th) {
        File fileB = b();
        if (fileB == null) {
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (!TextUtils.isEmpty(stackTraceString) && stackTraceString.contains("com.qq.e")) {
            gu.c(fileB, stackTraceString);
        }
        if (System.currentTimeMillis() - a <= com.alipay.sdk.m.u.b.a) {
            f();
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            SystemClock.sleep(1000L);
            o7.d();
        }
    }

    /* compiled from: A */
    class b implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ Thread.UncaughtExceptionHandler a;

        b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            o7.c(th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
        }
    }
}
