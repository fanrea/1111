package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.aspectj.lang.JoinPoint;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static volatile boolean bMH = false;
    private static volatile boolean bMI = false;
    private static volatile boolean bMJ = false;
    private static Handler aeI = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] bMK = {"c++_shared", "plt-base", "plt-unwind", JoinPoint.EXCEPTION_HANDLER};
    private static boolean bML = false;
    private static boolean bMM = false;

    public static boolean adO() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : bMK) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "loadExceptionLibSo load " + str);
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "loadExceptionLibSo fail\n" + Log.getStackTraceString(th));
            ISLOADED.set(false);
            return false;
        }
    }

    public static void a(c cVar) {
        if (cVar.dR == null || bMJ) {
            return;
        }
        bMJ = true;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.dR);
            com.kwad.sdk.crash.a.a.init(cVar.dR, cVar.bNa);
            e.aef().a(cVar);
            cq(cVar.dR);
            adR();
        } catch (Throwable unused) {
        }
    }

    public static void b(c cVar) {
        bML = cVar.bML;
        bMM = cVar.bMM;
        if (cp(cVar.dR)) {
            return;
        }
        if (bML || bMM) {
            g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                @Override // com.kwad.sdk.crash.g.a
                public final void adY() {
                    GlobalThreadPools.acm().execute(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                b.adP();
                                b.adS();
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                        }
                    });
                }

                @Override // com.kwad.sdk.crash.g.a
                public final void adZ() {
                    com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init fail");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void adP() {
        if (Build.VERSION.SDK_INT <= 23) {
            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "initNativeFunc 版本过低, 会有崩溃");
            return;
        }
        com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "ExceptionSoLoadHelper.init onLoad：enableAnrReport:" + bML + " *enableNativeReport" + bMM);
        if (bML) {
            adQ();
        }
        if (bMM) {
            c(false, "/sdcard/");
        }
    }

    private static boolean cp(Context context) {
        return context == null || ag.dK(context) >= 3;
    }

    public static void s(final Throwable th) {
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.t(th)) {
                        com.kwad.sdk.crash.handler.a.u(th);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
    }

    private static void cq(Context context) {
        com.kwad.sdk.crash.handler.c.aeu().init(com.kwad.sdk.crash.a.a.aep(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.aef().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File aea() {
                return new File(com.kwad.sdk.crash.a.a.aeo(), "java_crash/upload");
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    private static void adQ() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.aeq(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.aef().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                if (exceptionMessage == null || TextUtils.isEmpty(exceptionMessage.mCrashDetail) || !com.kwad.sdk.crash.b.a.gV(exceptionMessage.mCrashDetail)) {
                    return;
                }
                com.kwad.sdk.core.d.c.e("AnrAndNativeExceptionCollector", "ANR true upload:" + exceptionMessage.mCrashDetail);
                a(exceptionMessage, 3, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File aea() {
                return new File(com.kwad.sdk.crash.a.a.aeo(), "anr_log/upload");
            }
        });
    }

    private static void c(boolean z, String str) {
        if (com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.aer())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.aer(), false, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                    try {
                        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "Native upload");
                        if (exceptionMessage == null) {
                            com.kwad.sdk.core.d.c.w("AnrAndNativeExceptionCollector", "Native upload but msg is null");
                        } else if (com.kwad.sdk.crash.b.a.gU(exceptionMessage.mThreadName) || com.kwad.sdk.crash.b.a.gV(exceptionMessage.mCrashDetail)) {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "true upload msg:" + exceptionMessage.mCrashDetail);
                            a(exceptionMessage, 4, countDownLatch);
                        }
                    } catch (Throwable unused) {
                    }
                }

                @Override // com.kwad.sdk.crash.report.e
                public final File aea() {
                    return new File(com.kwad.sdk.crash.a.a.aeo(), "native_crash_log/upload");
                }
            });
        }
    }

    private static synchronized void adR() {
        if (!bMH) {
            bMH = true;
            com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.adT();
                    } catch (Throwable unused) {
                    }
                }
            }, d.bNp, TimeUnit.SECONDS);
        }
    }

    public static synchronized void adS() {
        if (!bMI) {
            bMI = true;
            com.kwad.sdk.utils.h.schedule(new Runnable() { // from class: com.kwad.sdk.crash.b.9
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.adU();
                    } catch (Throwable unused) {
                    }
                }
            }, d.bNp, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void adT() {
        adV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void adU() {
        if (bML) {
            adW();
        }
        if (bMM) {
            adX();
        }
    }

    private static void adV() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.aeu().getUploader());
        fVar.D(com.kwad.sdk.crash.a.a.aep());
    }

    private static void adW() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.D(com.kwad.sdk.crash.a.a.aeq());
    }

    private static void adX() {
        com.kwad.sdk.core.d.c.d("AnrAndNativeExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.D(com.kwad.sdk.crash.a.a.aer());
    }
}
