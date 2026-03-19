package com.kuaishou.common.async;

import android.content.Context;
import com.alipay.sdk.m.u.i;
import com.kuaishou.common.concurrent.DefaultThreadFactory;
import com.kuaishou.common.utility.SystemUtil;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Async {
    private static final int CORE_POOL_SIZE_IN_LOW_LEVEL = 2;
    private static final String KEY_POOL_STATUS = "backgroundThreadPool";
    private static final String KEY_TASKS_COST = "backgroundTasksCost";
    private static Context mContext = null;
    static boolean sDebug = false;
    private Observable mDependantObservable;
    private SystemUtil.LEVEL mDeviceLevel;
    private final KwaiThreadPoolExecutor mGlobalCachedExecutor;
    private KwaiThreadPoolExecutor mGlobalExecutor;
    private final Scheduler mGlobalScheduler;
    private volatile LogDelegate mLogDelegate;
    private final Executor mLogExecutor;
    private final BlockingQueue<String> mPendingInfos;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;

    public void reportThreadPoolStatus() {
    }

    static class Holder {
        static final Async INSTANCE = new Async();

        private Holder() {
        }
    }

    public static Async get() {
        return Holder.INSTANCE;
    }

    private Async() {
        this.mDeviceLevel = null;
        this.mPendingInfos = new LinkedBlockingQueue();
        this.mLogExecutor = Executors.newSingleThreadExecutor(new DefaultThreadFactory("ksad-lc-async-log-thread"));
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Context context = mContext;
        if (context != null) {
            this.mDeviceLevel = SystemUtil.getLevel(context);
        }
        SystemUtil.LEVEL level = this.mDeviceLevel;
        if (level != null && level.getValue() < SystemUtil.LEVEL.MIDDLE.getValue()) {
            this.mGlobalExecutor = new KwaiThreadPoolExecutor(2, MAXIMUM_POOL_SIZE, 2L, timeUnit, new LinkedBlockingQueue(512), new DefaultThreadFactory("global-default-pool"));
        } else {
            this.mGlobalExecutor = new KwaiThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 3L, timeUnit, new LinkedBlockingQueue(1024), new DefaultThreadFactory("global-default-pool"));
        }
        this.mGlobalExecutor.setIsCpuIntensive(true);
        this.mGlobalExecutor.allowCoreThreadTimeOut(true);
        this.mGlobalScheduler = Schedulers.from(this.mGlobalExecutor);
        this.mGlobalCachedExecutor = new KwaiThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("global-cached-pool"));
    }

    public static void execute(Runnable runnable) {
        get().mGlobalExecutor.execute(runnable);
    }

    public static Future<?> submit(Runnable runnable) {
        return get().mGlobalExecutor.submit(runnable);
    }

    public static Future<?> submitToCachedExecutor(Runnable runnable) {
        return get().mGlobalCachedExecutor.submit(runnable);
    }

    public static <V> Observable<? extends V> submit(Callable<? extends V> callable) {
        return Observable.fromCallable(callable).subscribeOn(get().mGlobalScheduler).observeOn(AndroidSchedulers.mainThread());
    }

    public static void setContext(Context context) {
        if (context != null) {
            mContext = context;
        }
    }

    public void setDependantObservable(Observable observable) {
        this.mDependantObservable = observable;
    }

    public static Future<?> scheduleSubmitTask(Runnable runnable) {
        final FutureTask futureTask = new FutureTask(runnable, null);
        if (get().mDependantObservable != null) {
            get().mDependantObservable.observeOn(KwaiSchedulers.ASYNC).doOnNext(new Consumer() { // from class: com.kuaishou.common.async.Async.1
                @Override // io.reactivex.functions.Consumer
                public void accept(Object obj) {
                    Async.execute(futureTask);
                }
            }).subscribe(Functions.emptyConsumer(), Functions.ERROR_CONSUMER);
        } else {
            execute(futureTask);
        }
        return futureTask;
    }

    public void setLogDelegate(LogDelegate logDelegate) {
        this.mLogDelegate = logDelegate;
    }

    void log(final String str, final String str2, final int i, final int i2) {
        this.mLogExecutor.execute(new Runnable() { // from class: com.kuaishou.common.async.Async.2
            @Override // java.lang.Runnable
            public void run() {
                if (Async.this.mLogDelegate != null) {
                    while (!Async.this.mPendingInfos.isEmpty()) {
                        Async.this.mLogDelegate.log(Async.KEY_TASKS_COST, (String) Async.this.mPendingInfos.poll());
                    }
                    Async.this.mLogDelegate.log(Async.KEY_TASKS_COST, Async.toJsonString(str, str2, i, i2));
                    return;
                }
                Async.this.mPendingInfos.offer(Async.toJsonString(str, str2, i, i2));
            }
        });
    }

    public static ThreadPoolExecutor newSingleThreadExecutor(String str) {
        return newFixedThreadPoolExecutor(str, 1);
    }

    public static ThreadPoolExecutor newFixedThreadPoolExecutor(String str, int i) {
        KwaiThreadPoolExecutor kwaiThreadPoolExecutor = new KwaiThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new DefaultThreadFactory(str));
        kwaiThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return kwaiThreadPoolExecutor;
    }

    public static ThreadPoolExecutor newFixedThreadPoolExecutor(String str, int i, BlockingQueue blockingQueue) {
        KwaiThreadPoolExecutor kwaiThreadPoolExecutor = new KwaiThreadPoolExecutor(i, i, 1L, TimeUnit.MINUTES, blockingQueue, new DefaultThreadFactory(str));
        kwaiThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return kwaiThreadPoolExecutor;
    }

    public static ThreadPoolExecutor getCacheThreadPoolExecutor() {
        return get().mGlobalCachedExecutor;
    }

    public static void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        get().mGlobalExecutor.setRejectedExecutionHandler(rejectedExecutionHandler);
        get().mGlobalCachedExecutor.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toJsonString(String str, String str2, int i, int i2) {
        return "{name:" + str + ", threadName:" + str2 + ", findSourceCost:" + i + ", duration: " + i2 + i.d;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }
}
