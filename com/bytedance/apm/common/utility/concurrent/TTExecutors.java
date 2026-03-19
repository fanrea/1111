package com.bytedance.apm.common.utility.concurrent;

import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class TTExecutors {
    public static final int AVAILABLEPROCESSORS;
    public static final int CORE_POOL_SIZE_CPU;
    public static final int CORE_POOL_SIZE_NORMAL;
    public static final int CORE_POOL_SIZE_SCHEDULED = 3;
    public static final int CPU_COUNT;
    public static final int DOWNLOAD_THREAD_COUNT = 2;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE_CPU;
    public static final int MAXIMUM_POOL_SIZE_NORMAL;
    public static final int MAX_POOL_SIZE = 3;
    private static final BackgroundThreadFactory S_BACKGROUND_THREAD_FACTORY;
    private static final DefaultThreadFactory S_CPU_THREAD_FACTORY;
    private static final DefaultThreadFactory S_DEFAULT_THREAD_FACTORY;
    private static final DefaultThreadFactory S_DOWNLOAD_THREAD_FACTORY;
    private static final RejectedExecutionHandler S_HANDLER;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE_CPU;
    private static final BlockingQueue<Runnable> S_POOLWORK_QUEUE_DOWNLOAD;
    private static final DefaultThreadFactory S_SCHEDULED_THREAD_FACTORY;
    private static final DefaultThreadFactory S_SERIAL_THREAD_FACTORY;
    private static ExecutorService sBackgroundThreadPool;
    private static ExecutorService sCPUThreadPool;
    private static ExecutorService sIOThreadPool;
    private static ExecutorService sNormalThreadPool;
    private static ScheduledExecutorService sScheduledThreadPool;
    private static ExecutorService sSerialThreadPool;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        AVAILABLEPROCESSORS = iAvailableProcessors;
        if (iAvailableProcessors <= 0) {
            iAvailableProcessors = 1;
        }
        CPU_COUNT = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 6)) * 2;
        CORE_POOL_SIZE_NORMAL = iMax;
        int i = (iMax * 2) + 1;
        MAXIMUM_POOL_SIZE_NORMAL = i;
        int iMax2 = Math.max(2, Math.min(iAvailableProcessors - 1, 3));
        CORE_POOL_SIZE_CPU = iMax2;
        int i2 = (iAvailableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE_CPU = i2;
        DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory("TTDefaultExecutors");
        S_DEFAULT_THREAD_FACTORY = defaultThreadFactory;
        DefaultThreadFactory defaultThreadFactory2 = new DefaultThreadFactory("TTCpuExecutors");
        S_CPU_THREAD_FACTORY = defaultThreadFactory2;
        DefaultThreadFactory defaultThreadFactory3 = new DefaultThreadFactory("TTScheduledExecutors");
        S_SCHEDULED_THREAD_FACTORY = defaultThreadFactory3;
        DefaultThreadFactory defaultThreadFactory4 = new DefaultThreadFactory("TTDownLoadExecutors");
        S_DOWNLOAD_THREAD_FACTORY = defaultThreadFactory4;
        DefaultThreadFactory defaultThreadFactory5 = new DefaultThreadFactory("TTSerialExecutors");
        S_SERIAL_THREAD_FACTORY = defaultThreadFactory5;
        BackgroundThreadFactory backgroundThreadFactory = new BackgroundThreadFactory("TTBackgroundExecutors");
        S_BACKGROUND_THREAD_FACTORY = backgroundThreadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE = linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE_CPU = linkedBlockingQueue2;
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        S_POOLWORK_QUEUE_DOWNLOAD = linkedBlockingQueue3;
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() { // from class: com.bytedance.apm.common.utility.concurrent.TTExecutors.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Executors.newCachedThreadPool().execute(runnable);
            }
        };
        S_HANDLER = rejectedExecutionHandler;
        TTThreadPoolExecutor tTThreadPoolExecutor = new TTThreadPoolExecutor(iMax, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, defaultThreadFactory, rejectedExecutionHandler);
        sNormalThreadPool = tTThreadPoolExecutor;
        tTThreadPoolExecutor.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor tTThreadPoolExecutor2 = new TTThreadPoolExecutor(iMax2, i2, 30L, TimeUnit.SECONDS, linkedBlockingQueue2, defaultThreadFactory2, rejectedExecutionHandler);
        sCPUThreadPool = tTThreadPoolExecutor2;
        tTThreadPoolExecutor2.allowCoreThreadTimeOut(true);
        sScheduledThreadPool = Executors.newScheduledThreadPool(3, defaultThreadFactory3);
        TTThreadPoolExecutor tTThreadPoolExecutor3 = new TTThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, linkedBlockingQueue3, defaultThreadFactory4, rejectedExecutionHandler);
        sIOThreadPool = tTThreadPoolExecutor3;
        tTThreadPoolExecutor3.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor tTThreadPoolExecutor4 = new TTThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), defaultThreadFactory5);
        sSerialThreadPool = tTThreadPoolExecutor4;
        tTThreadPoolExecutor4.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor tTThreadPoolExecutor5 = new TTThreadPoolExecutor(0, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), backgroundThreadFactory);
        sBackgroundThreadPool = tTThreadPoolExecutor5;
        tTThreadPoolExecutor5.allowCoreThreadTimeOut(true);
    }

    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        DefaultThreadFactory(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = str + "-" + POOL_NUMBER.getAndIncrement() + "-Thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private static class BackgroundThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        BackgroundThreadFactory(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = str + "-" + POOL_NUMBER.getAndIncrement() + "-Thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L) { // from class: com.bytedance.apm.common.utility.concurrent.TTExecutors.BackgroundThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws SecurityException, IllegalArgumentException {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }

    public static ExecutorService getNormalExecutor() {
        return sNormalThreadPool;
    }

    @Deprecated
    public static ExecutorService getDownLoadThreadPool() {
        return sIOThreadPool;
    }

    public static ScheduledExecutorService getScheduledThreadPool() {
        return sScheduledThreadPool;
    }

    public static ExecutorService getCPUThreadPool() {
        return sCPUThreadPool;
    }

    public static ExecutorService getIOThreadPool() {
        return sIOThreadPool;
    }

    public static ExecutorService getSerialThreadPool() {
        return sSerialThreadPool;
    }

    public static ExecutorService getBackgroundThreadPool() {
        return sBackgroundThreadPool;
    }

    public static void setNormalThreadPool(ExecutorService executorService) {
        sNormalThreadPool = executorService;
    }

    public static void setCPUThreadPool(ExecutorService executorService) {
        sCPUThreadPool = executorService;
    }

    public static void setIOThreadPool(ExecutorService executorService) {
        sIOThreadPool = executorService;
    }

    public static void setScheduledThreadPool(ScheduledExecutorService scheduledExecutorService) {
        sScheduledThreadPool = scheduledExecutorService;
    }

    public static void setSerialThreadPool(ExecutorService executorService) {
        sSerialThreadPool = executorService;
    }

    public static void setBackgroundThreadPool(ExecutorService executorService) {
        sBackgroundThreadPool = executorService;
    }
}
