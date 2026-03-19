package com.apm.insight.h;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.ICrashFilter;
import com.apm.insight.IOOMCallback;
import com.apm.insight.Npth;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.o.f;
import com.apm.insight.o.j;
import com.apm.insight.o.l;
import com.apm.insight.o.q;
import com.apm.insight.o.r;
import com.apm.insight.o.v;
import com.apm.insight.runtime.p;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements Thread.UncaughtExceptionHandler {
    private static a a = null;
    private static volatile boolean i = false;
    private static volatile ThreadLocal<Boolean> j = new ThreadLocal<>();
    private static ArrayList<b> o = new ArrayList<>();
    private Thread.UncaughtExceptionHandler b;
    private c c;
    private c d;
    private volatile int e = 0;
    private volatile int f = 0;
    private ConcurrentHashMap<String, Object> g = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> h = new ConcurrentHashMap<>();
    private Stack<Thread.UncaughtExceptionHandler> k = new Stack<>();
    private HashMap<Thread, Throwable> l = new HashMap<>();
    private volatile int m = 0;
    private Runnable n = new Runnable() { // from class: com.apm.insight.h.a.1
        @Override // java.lang.Runnable
        public void run() {
            q.a((Object) "Recheck uncaught exception handler.");
            if (a.this.m < 3) {
                a.b(a.this);
                a.this.d();
                com.apm.insight.runtime.q.b().a(a.this.n, 30000L);
            }
        }
    };

    private a() {
        d();
        if (Npth.getConfigManager().isRegisterJavaCrashEnable()) {
            a(5000L);
        }
    }

    private static int a(Throwable th, Thread thread, boolean z, String str, String str2) {
        int iA = 0;
        for (int i2 = 0; i2 < o.size(); i2++) {
            try {
                b bVar = o.get(i2);
                if (!z) {
                    try {
                        iA |= bVar.a(th, thread);
                    } catch (Throwable th2) {
                        com.apm.insight.b.a().a("NPTH_CATCH", th2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return iA;
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private String a(File file, boolean z, Throwable th, String str, Thread thread, boolean z2) {
        String absolutePath = file.getAbsolutePath();
        this.h.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.c(absolutePath);
        } catch (Throwable unused) {
        }
        String strA = null;
        if (z2) {
            int iH = NativeImpl.h(absolutePath);
            if (iH > 0) {
                try {
                    NativeImpl.a(iH, com.apm.insight.o.a.c(g.f()));
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, th.getMessage());
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, th.getClass().getName());
                    if (th.getMessage() != null) {
                        NativeImpl.a(iH, ": ");
                        NativeImpl.a(iH, th.getMessage());
                    }
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, thread.getName());
                    NativeImpl.a(iH, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.a(iH, "stack:");
                    NativeImpl.a(iH, "\n");
                } catch (Throwable unused3) {
                }
                v.a(th, iH);
                NativeImpl.b(iH);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                if (r.a(32768)) {
                    throw new RuntimeException("test exception before write stack");
                }
                fileOutputStream.write((com.apm.insight.o.a.c(g.f()) + "\n").getBytes());
                fileOutputStream.write((th.getMessage() + "\n").getBytes());
                fileOutputStream.write((th + "\n").getBytes());
                fileOutputStream.write((thread.getName() + "\n").getBytes());
                try {
                    fileOutputStream.write("stack:\n".getBytes());
                } catch (Throwable unused4) {
                }
                try {
                } catch (Throwable th2) {
                    try {
                        if (r.a(16384)) {
                            throw new RuntimeException("test exception system write stack");
                        }
                        th.printStackTrace(new PrintStream(fileOutputStream));
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.write("err:\n".getBytes());
                            fileOutputStream.write((th2 + "\n").getBytes());
                            fileOutputStream.write((th3 + "\n").getBytes());
                        } catch (Throwable unused5) {
                        }
                    }
                }
                if (r.a(8192)) {
                    throw new RuntimeException("test exception npth write stack");
                }
                strA = v.a(th, thread, new PrintStream(fileOutputStream), Looper.getMainLooper() == Looper.myLooper() ? new f.a() { // from class: com.apm.insight.h.a.2
                    boolean a = false;

                    @Override // com.apm.insight.o.f.a
                    public boolean a(String str2) {
                        if (!this.a && str2.contains("android.os.Looper.loop")) {
                            this.a = true;
                        }
                        return !this.a;
                    }
                } : new f.a());
                l.a(fileOutputStream);
                l.a(fileOutputStream);
            } catch (Throwable unused6) {
            }
        }
        return strA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e7 A[Catch: all -> 0x021a, TryCatch #16 {all -> 0x021a, blocks: (B:104:0x01c3, B:105:0x01dd, B:108:0x01e7, B:110:0x01eb, B:112:0x01f1), top: B:218:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x027d A[Catch: all -> 0x02a8, TRY_LEAVE, TryCatch #4 {all -> 0x02a8, blocks: (B:148:0x0277, B:150:0x027d), top: B:194:0x0277 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011e A[Catch: all -> 0x0102, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0102, blocks: (B:48:0x00d1, B:50:0x00d7, B:74:0x011e), top: B:188:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0121 A[Catch: all -> 0x025e, TRY_ENTER, TRY_LEAVE, TryCatch #17 {all -> 0x025e, blocks: (B:46:0x00cb, B:65:0x010c, B:80:0x0141, B:79:0x0128, B:76:0x0121), top: B:220:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0169 A[PHI: r5
  0x0169: PHI (r5v13 long) = (r5v25 long), (r5v26 long), (r5v27 long) binds: [B:81:0x014f, B:82:0x0151, B:84:0x015b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0170 A[Catch: all -> 0x024f, TryCatch #9 {all -> 0x024f, blocks: (B:89:0x016a, B:91:0x0170, B:93:0x0177, B:95:0x017c, B:97:0x01a6, B:100:0x01ac, B:102:0x01b2, B:94:0x017a), top: B:204:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0177 A[Catch: all -> 0x024f, TryCatch #9 {all -> 0x024f, blocks: (B:89:0x016a, B:91:0x0170, B:93:0x0177, B:95:0x017c, B:97:0x01a6, B:100:0x01ac, B:102:0x01b2, B:94:0x017a), top: B:204:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017a A[Catch: all -> 0x024f, TryCatch #9 {all -> 0x024f, blocks: (B:89:0x016a, B:91:0x0170, B:93:0x0177, B:95:0x017c, B:97:0x01a6, B:100:0x01ac, B:102:0x01b2, B:94:0x017a), top: B:204:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a6 A[Catch: all -> 0x024f, TryCatch #9 {all -> 0x024f, blocks: (B:89:0x016a, B:91:0x0170, B:93:0x0177, B:95:0x017c, B:97:0x01a6, B:100:0x01ac, B:102:0x01b2, B:94:0x017a), top: B:204:0x016a }] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.apm.insight.a.a] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.apm.insight.CrashType] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v15, types: [long] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r7v16, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Throwable a(java.lang.Thread r24, java.lang.Throwable r25) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.h.a.a(java.lang.Thread, java.lang.Throwable):java.lang.Throwable");
    }

    private static Throwable a(Throwable th, Thread thread) {
        for (int i2 = 0; i2 < o.size(); i2++) {
            try {
                try {
                    o.get(i2).b(th, thread);
                } catch (Throwable th2) {
                    return th2;
                }
            } catch (Throwable unused) {
            }
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            Looper.loop();
            return null;
        } catch (Throwable th3) {
            return th3;
        }
    }

    private void a(Thread thread, Throwable th, boolean z, long j2) {
        List<IOOMCallback> listA = p.a().a();
        CrashType crashType = z ? CrashType.LAUNCH : CrashType.JAVA;
        Iterator<IOOMCallback> it = listA.iterator();
        while (it.hasNext()) {
            try {
                it.next().onCrash(crashType, th, thread, j2);
            } catch (Throwable th2) {
                q.b(th2);
            }
        }
    }

    public static void a(final Throwable th) {
        if (th == null) {
            return;
        }
        try {
            com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.h.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.apm.insight.entity.a aVarA = com.apm.insight.entity.a.a(System.currentTimeMillis(), g.f(), (Thread) null, th);
                        aVarA.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a aVarA2 = com.apm.insight.runtime.a.f.a().a(CrashType.CUSTOM_JAVA, aVarA);
                        if (aVarA2 != null) {
                            com.apm.insight.n.e.a().b(aVarA2.h());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ int b(a aVar) {
        int i2 = aVar.m;
        aVar.m = i2 + 1;
        return i2;
    }

    public static boolean b() {
        return i;
    }

    public static boolean b(long j2) {
        return e.a(j2);
    }

    private boolean b(Thread thread, Throwable th) {
        ICrashFilter iCrashFilterB = g.b().b();
        if (iCrashFilterB == null) {
            return true;
        }
        try {
            return iCrashFilterB.onJavaCrashFilter(th, thread);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void c(final String str) {
        if (str == null) {
            return;
        }
        try {
            com.apm.insight.runtime.q.b().a(new Runnable() { // from class: com.apm.insight.h.a.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
                        aVar.a("data", (Object) str);
                        aVar.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(CrashType.CUSTOM_JAVA, aVar);
                        if (aVarA != null) {
                            com.apm.insight.n.e.a().b(aVarA.h());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private void c(Thread thread, Throwable th) {
        if (r.a(512)) {
            return;
        }
        d(thread, th);
    }

    public static boolean c() {
        Boolean bool = j.get();
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            if (defaultUncaughtExceptionHandler != null) {
                q.a((Object) ("Put this uncaught exception handler to stack. " + defaultUncaughtExceptionHandler.getClass().getName()));
                this.k.push(defaultUncaughtExceptionHandler);
            }
            this.b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void d(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandlerPop;
        try {
            if (!this.k.isEmpty() && (uncaughtExceptionHandlerPop = this.k.pop()) != null) {
                this.b = uncaughtExceptionHandlerPop;
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
                q.a((Object) "mDefaultHandler != null, call mDefaultHandler.");
                this.b.uncaughtException(thread, th);
                return;
            }
        } catch (Throwable unused) {
        }
        q.a((Object) "Uncaught exception handler null, kill process.");
        Process.killProcess(Process.myPid());
    }

    private void e() {
        synchronized (this) {
            this.f--;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (this.f != 0 && SystemClock.uptimeMillis() - jUptimeMillis < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            SystemClock.sleep(50L);
        }
    }

    private void f() {
        File fileA = com.apm.insight.o.p.a(g.f());
        File fileA2 = com.apm.insight.o.p.a();
        if (j.b(fileA) && j.b(fileA2)) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (!com.apm.insight.n.l.a() && SystemClock.uptimeMillis() - jUptimeMillis < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            try {
                SystemClock.sleep(500L);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean g() {
        return com.apm.insight.runtime.a.a("exception_modules", "oom_callback") == 1;
    }

    public void a(long j2) {
        com.apm.insight.runtime.q.b().b(this.n);
        com.apm.insight.runtime.q.b().a(this.n, j2);
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(String str) {
        this.g.put(str, new Object());
    }

    public void a(Thread thread, Throwable th, boolean z, com.apm.insight.entity.a aVar) {
        List<ICrashCallback> listC;
        CrashType crashType;
        if (z) {
            listC = p.a().b();
            crashType = CrashType.LAUNCH;
        } else {
            listC = p.a().c();
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback iCrashCallback : listC) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                iCrashCallback.onCrash(crashType, v.a(th), thread);
                aVar.b("callback_cost_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            } catch (Throwable th2) {
                q.b(th2);
                aVar.b("callback_err_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public void b(c cVar) {
        this.d = cVar;
    }

    public boolean b(String str) {
        return this.g.containsKey(str);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        do {
            th = a(thread, th);
        } while (th != null);
    }
}
