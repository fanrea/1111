package com.kwad.sdk.core.threads;

import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class GlobalThreadPools {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static String TAG;
    private static final int bHC;
    private static Map<String, WeakReference<ExecutorService>> bHD;
    private static Map<String, Integer> bHE;
    private static boolean bHF;

    enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    interface a {
        ExecutorService acr();
    }

    public static void abZ() {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        if (iAvailableProcessors <= 0) {
            iAvailableProcessors = 9;
        }
        CORE_POOL_SIZE = iAvailableProcessors;
        bHC = iAvailableProcessors;
        TAG = "GlobalThreadPools";
        bHD = new ConcurrentHashMap();
        bHE = new ConcurrentHashMap();
        bHF = true;
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] bHG;

        static {
            int[] iArr = new int[ParamType.values().length];
            bHG = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bHG[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                bHG[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(String str, ParamType paramType, int i2) {
        String str2;
        int i3 = AnonymousClass4.bHG[paramType.ordinal()];
        if (i3 == 1) {
            str2 = str + "_core";
        } else if (i3 == 2) {
            str2 = str + "_max";
        } else {
            if (i3 != 3) {
                return i2;
            }
            str2 = str + "_keep_alive";
        }
        try {
            if (bHE.containsKey(str2) && bHE.get(str2) != null) {
                return bHE.get(str2).intValue();
            }
        } catch (Exception unused) {
        }
        return i2;
    }

    public static void v(String str, int i2) {
        bHE.put(str, Integer.valueOf(i2));
    }

    public static boolean aca() {
        return bHF;
    }

    public static void acb() {
        for (String str : bHD.keySet()) {
            if (bHD.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) bHD.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS);
                int iA = a(str, ParamType.CORE, corePoolSize);
                int iA2 = a(str, ParamType.MAX, maximumPoolSize);
                try {
                    threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), TimeUnit.SECONDS);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
                if (corePoolSize != iA || maximumPoolSize != iA2) {
                    if (corePoolSize <= iA2) {
                        threadPoolExecutor.setMaximumPoolSize(iA2);
                        threadPoolExecutor.setCorePoolSize(iA);
                    } else if (iA <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(iA);
                        threadPoolExecutor.setMaximumPoolSize(iA2);
                    }
                }
            }
        }
    }

    public static ExecutorService acc() {
        if (aca()) {
            return acm();
        }
        return a("lruDiskCache", new g((byte) 0));
    }

    public static ExecutorService acd() {
        return a("backSingle", new i((byte) 0));
    }

    public static synchronized ExecutorService ace() {
        com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTask");
        return a("ksImageLoaderTask", new f((byte) 0));
    }

    public static synchronized ExecutorService acf() {
        com.kwad.sdk.core.d.c.d(TAG, "forBaseBatchReporter");
        if (aca()) {
            return acm();
        }
        return a("report", new h((byte) 0));
    }

    public static synchronized ExecutorService acg() {
        com.kwad.sdk.core.d.c.d(TAG, "forAdReportManager");
        if (aca()) {
            return acm();
        }
        return a("report", new h((byte) 0));
    }

    public static ExecutorService ach() {
        com.kwad.sdk.core.d.c.d(TAG, "forBaseNetwork");
        if (aca()) {
            return acm();
        }
        return a("httpIO", new b((byte) 0));
    }

    public static ExecutorService aci() {
        com.kwad.sdk.core.d.c.d(TAG, "forCoreNetwork");
        if (aca()) {
            return acj();
        }
        return ach();
    }

    private static ExecutorService acj() {
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor");
        ExecutorService executorServiceA = a("httpIOForCoreV1", new c(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorServiceA;
        int poolSize = threadPoolExecutor.getPoolSize();
        int iA = a("httpIOForCoreV1", ParamType.CORE, 5);
        int iA2 = a("httpIOForCoreExtraV1", ParamType.MAX, 3);
        ExecutorService executorServiceA2 = a("httpIOForCoreExtraV1", new d(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) executorServiceA2;
        int poolSize2 = threadPoolExecutor2.getPoolSize();
        int activeCount = threadPoolExecutor.getActiveCount();
        int activeCount2 = threadPoolExecutor2.getActiveCount();
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize:" + poolSize + " configSize:" + iA);
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor extraPoolSize:" + poolSize2 + " extraConfigSize:" + iA2);
        com.kwad.sdk.core.d.c.e(TAG, "getCoreExecutor queueSize:" + (threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size()) + " extraQueueSize:" + (threadPoolExecutor2.getQueue() != null ? threadPoolExecutor2.getQueue().size() : 0));
        if (poolSize < iA) {
            com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize < configSize");
            return executorServiceA;
        }
        if (activeCount < iA) {
            com.kwad.sdk.core.d.c.e(TAG, "activeCount < configSize");
            return executorServiceA;
        }
        if (activeCount2 == iA2) {
            com.kwad.sdk.core.d.c.e(TAG, "extraActiveCount == extraConfigSize");
            return executorServiceA;
        }
        com.kwad.sdk.core.d.c.e(TAG, "use extra");
        return executorServiceA2;
    }

    public static ExecutorService ack() {
        com.kwad.sdk.core.d.c.d(TAG, "forHttpCacheServer");
        if (aca()) {
            return acm();
        }
        return a("videoCache", new j((byte) 0));
    }

    public static ExecutorService acl() {
        com.kwad.sdk.core.d.c.d(TAG, "forAppStatusHelper");
        if (aca()) {
            return acm();
        }
        return new com.kwad.sdk.core.threads.a.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService acm() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService acr() {
                e eVar = new e(5, "async");
                int i2 = GlobalThreadPools.aca() ? 5 : 3;
                return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, i2), GlobalThreadPools.a("async", ParamType.MAX, i2), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), eVar);
            }
        });
    }

    public static ScheduledExecutorService acn() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsyncSchedule");
        ExecutorService executorServiceA = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService acr() {
                return new com.kwad.sdk.core.threads.a.a(1, new e(5, "async-schedule"));
            }
        });
        if (executorServiceA instanceof ScheduledExecutorService) {
            return (ScheduledExecutorService) executorServiceA;
        }
        return new com.kwad.sdk.core.threads.a.a(1, new e(5, "async-schedule"));
    }

    private static ExecutorService a(String str, a aVar) {
        WeakReference<ExecutorService> weakReference = bHD.get(str);
        if (weakReference == null || weakReference.get() == null) {
            ExecutorService executorServiceAcr = aVar.acr();
            bHD.put(str, new WeakReference<>(executorServiceAcr));
            return executorServiceAcr;
        }
        return weakReference.get();
    }

    static class i implements a {
        private i() {
        }

        /* synthetic */ i(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            return new com.kwad.sdk.core.threads.a.b(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new e(5, "backSingle"));
        }
    }

    static class g implements a {
        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new e(5, "lruDiskCache"));
        }
    }

    static class h implements a {
        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("report", ParamType.CORE, 1), GlobalThreadPools.a("report", ParamType.MAX, 1), GlobalThreadPools.a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new e(3, "report-"));
        }
    }

    static class j implements a {
        private j() {
        }

        /* synthetic */ j(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new e(5, "videoCache"));
        }
    }

    static class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.CORE_POOL_SIZE), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.bHC), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new e(5, "diskAndHttp"));
        }
    }

    static class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            e eVar = new e(5, "ForCore");
            try {
                int iA = GlobalThreadPools.a("httpIOForCoreV1", ParamType.CORE, 5);
                int iA2 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.MAX, 5);
                if (iA < 0) {
                    iA = 5;
                }
                if (iA2 < 0) {
                    iA2 = 5;
                }
                if (iA2 < iA) {
                    iA = 5;
                    iA2 = 5;
                }
                com.kwad.sdk.core.d.c.d(GlobalThreadPools.TAG, "HttpIOCreatorForCore create, coreSize:" + iA + ", maxSize:" + iA2);
                int i = 60;
                int iA3 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.KEEP_ALIVE, 60);
                if (iA3 >= 0) {
                    i = iA3;
                }
                return new com.kwad.sdk.core.threads.a.b(iA, iA2, GlobalThreadPools.a("httpIOForCoreV1", ParamType.KEEP_ALIVE, i), TimeUnit.SECONDS, new LinkedBlockingQueue(), eVar);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.e(GlobalThreadPools.TAG, Log.getStackTraceString(e));
                return new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), eVar);
            }
        }
    }

    static class d implements a {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.CORE, 0), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.MAX, 3), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new e(5, "ForCoreExtra"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    static class f implements a {
        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService acr() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new e(5, "uil-pool-"));
        }
    }

    public static class e implements ThreadFactory {
        private static final AtomicInteger bin = new AtomicInteger(1);
        private final int bHH;
        private final String bhf;
        private final AtomicInteger bhh = new AtomicInteger(1);
        private final ThreadGroup bhg = Thread.currentThread().getThreadGroup();

        public e(int i, String str) {
            this.bHH = i;
            this.bhf = "ksad-" + str + bin.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.bhg, runnable, this.bhf + this.bhh.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.bHH);
            return thread;
        }
    }
}
