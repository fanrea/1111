package com.apm.insight.nativecrash;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.b.f;
import com.apm.insight.g;
import com.apm.insight.o.p;
import com.apm.insight.o.u;
import com.apm.insight.o.x;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NativeImpl {
    private static volatile boolean a = false;
    private static volatile boolean b = false;
    private static boolean c = true;

    public static int a(int i) {
        if (a && i >= 0) {
            try {
                return doLock("", i);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static String a(String str) {
        if (a) {
            return doGetCrashHeader(str);
        }
        return null;
    }

    public static void a(int i, String str) {
        if (!a || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            doWriteFile(i, str, str.length());
        } catch (Throwable unused) {
        }
    }

    public static void a(long j) {
    }

    public static void a(File file) {
        if (a) {
            doRebuildTombstone(p.c(file).getAbsolutePath(), p.b(file).getAbsolutePath(), p.d(file).getAbsolutePath());
        }
    }

    public static void a(String str, String str2, String str3) {
        if (a) {
            try {
                doDumpLogcat(str, str2, str3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z) {
        c = z;
        if (a) {
            doSetResendSigQuit(z ? 1 : 0);
        }
    }

    public static boolean a() {
        if (b) {
            return a;
        }
        b = true;
        if (!a) {
            a = u.a("apminsighta");
        }
        return a;
    }

    public static boolean a(Context context) {
        String strA;
        boolean zA = a();
        if (zA) {
            String str = p.j(context) + "/apminsight";
            new File(str).mkdirs();
            if (new File(context.getApplicationInfo().nativeLibraryDir, "libapminsightb.so").exists()) {
                strA = context.getApplicationInfo().nativeLibraryDir;
            } else {
                strA = com.apm.insight.i.b.a();
                com.apm.insight.i.b.b("apminsightb");
            }
            doStart(Build.VERSION.SDK_INT, strA, str, g.e(), g.k());
        }
        return zA;
    }

    public static int b() {
        if (a) {
            return doCreateCallbackThread();
        }
        return -1;
    }

    public static void b(int i) {
        if (a) {
            try {
                doCloseFile(i);
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(long j) {
        if (a) {
            try {
                doSetAlogFlushAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str) {
        if (a) {
            doDumpHprof(str);
        }
    }

    public static int c(String str) {
        if (a && !TextUtils.isEmpty(str)) {
            try {
                return doLock(str, -1);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static long c(int i) {
        if (a) {
            return doGetThreadCpuTime(i);
        }
        return 0L;
    }

    public static void c() {
        if (a) {
            try {
                String strE = g.e();
                File fileI = p.i(g.f());
                fileI.mkdirs();
                doSetAlogConfigPath(fileI.getPath() + "/native_" + strE + ".atmp");
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(long j) {
        if (a) {
            try {
                doSetAlogLogDirAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(String str) {
        if (a) {
            try {
                doDumpMemInfo(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean d() {
        if (!a) {
            return false;
        }
        try {
            return doCheckNativeCrash();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static native boolean doCheckNativeCrash();

    private static native void doCloseFile(int i);

    private static native int doCreateCallbackThread();

    private static native void doDump(String str);

    private static native void doDumpFds(String str);

    private static native void doDumpHprof(String str);

    private static native void doDumpLogcat(String str, String str2, String str3);

    private static native void doDumpMaps(String str);

    private static native void doDumpMemInfo(String str);

    private static native void doDumpThreads(String str);

    private static native long doGetAppCpuTime();

    private static native long doGetChildCpuTime();

    private static native String doGetCrashHeader(String str);

    private static native long doGetDeviceCpuTime();

    private static native int doGetFDCount();

    private static native String[] doGetFdDump(int i, int i2, int[] iArr, String[] strArr);

    private static native long doGetFreeMemory();

    private static native long doGetThreadCpuTime(int i);

    private static native int doGetThreadsCount();

    private static native long doGetTotalMemory();

    private static native long doGetVMSize();

    private static native void doInitThreadDump();

    private static native int doLock(String str, int i);

    private static native int doOpenFile(String str);

    private static native void doRebuildTombstone(String str, String str2, String str3);

    private static native void doSetAlogConfigPath(String str);

    private static native void doSetAlogFlushAddr(long j);

    private static native void doSetAlogLogDirAddr(long j);

    private static native void doSetResendSigQuit(int i);

    private static native void doSetUploadEnd();

    private static native void doSignalMainThread();

    private static native int doStart(int i, String str, String str2, String str3, int i2);

    private static native void doStartAnrMonitor(int i);

    private static native void doWriteFile(int i, String str, int i2);

    public static void e(String str) {
        if (a) {
            try {
                doDumpFds(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean e() {
        if (!a) {
            return false;
        }
        try {
            return is64Bit();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void f() {
        x.a(new Runnable() { // from class: com.apm.insight.nativecrash.NativeImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    NativeImpl.l();
                } catch (Throwable th) {
                    try {
                        com.apm.insight.b.a(th, "NPTH_ANR_MONITOR_ERROR");
                    } catch (Throwable unused) {
                    }
                }
            }
        }, "NPTH-AnrMonitor");
    }

    public static void f(String str) {
        if (a) {
            try {
                doDumpMaps(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void g(String str) {
        if (a) {
            try {
                doDumpThreads(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean g() {
        return c;
    }

    public static int h(String str) {
        if (!a) {
            return -1;
        }
        try {
            return doOpenFile(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void h() {
        if (a) {
            doSignalMainThread();
        }
    }

    private static void handleNativeCrash(String str) {
        NativeCrashCollector.onNativeCrash(str);
    }

    public static void i() {
        if (a) {
            doSetUploadEnd();
        }
    }

    public static void i(String str) {
        if (a) {
            doDump(str);
        }
    }

    private static native boolean is64Bit();

    public static void j() {
        if (a) {
            doInitThreadDump();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        if (a) {
            try {
                doStartAnrMonitor(Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
            }
        }
    }

    private static void reportEventForAnrMonitor() {
        try {
            System.currentTimeMillis();
            g.i();
            f.b(true);
            com.apm.insight.b.g.f();
        } catch (Throwable unused) {
        }
    }
}
