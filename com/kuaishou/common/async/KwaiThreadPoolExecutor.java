package com.kuaishou.common.async;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KwaiThreadPoolExecutor extends ThreadPoolExecutor {
    private ThreadLocal<RunnableInfo> mInfo;
    private boolean mIsCpuIntensive;

    public KwaiThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.mInfo = new ThreadLocal<>();
        this.mIsCpuIntensive = false;
    }

    public KwaiThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.mInfo = new ThreadLocal<>();
        this.mIsCpuIntensive = false;
    }

    public void setIsCpuIntensive(boolean z) {
        this.mIsCpuIntensive = z;
    }

    public static String getSource(Object obj) throws IllegalAccessException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.offer(obj);
        while (!linkedBlockingQueue.isEmpty()) {
            Object objPoll = linkedBlockingQueue.poll();
            hashSet.add(Integer.valueOf(objPoll.hashCode()));
            String name = objPoll.getClass().getName();
            if (!name.startsWith("java.util") && !name.startsWith("io.reactivex")) {
                arrayList.add(name);
            }
            for (Field field : getPotentialWrapperFields(objPoll.getClass(), objPoll)) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    try {
                        Object obj2 = field.get(objPoll);
                        if (obj2 != null && !hashSet.contains(Integer.valueOf(obj2.hashCode()))) {
                            hashSet.add(Integer.valueOf(obj2.hashCode()));
                            linkedBlockingQueue.offer(obj2);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return "Unknown";
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            sb.append((String) arrayList.get(size));
            sb.append(' ');
            if (sb.length() >= 100) {
                break;
            }
        }
        return sb.toString();
    }

    private static List<Field> getPotentialWrapperFields(Class<?> cls, Object obj) throws IllegalAccessException, IllegalArgumentException {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if ((obj2 instanceof Runnable) || (obj2 instanceof Callable) || (obj2 instanceof Observer) || (obj2 instanceof Observable) || (obj2 instanceof Consumer) || (obj2 instanceof Action)) {
                        arrayList.add(field);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) throws IllegalAccessException, IllegalArgumentException {
        if (Async.sDebug) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.mInfo.set(new RunnableInfo(getSource(runnable), thread.getName(), System.currentTimeMillis() - jCurrentTimeMillis));
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        RunnableInfo runnableInfo;
        super.afterExecute(runnable, th);
        if (!Async.sDebug || (runnableInfo = this.mInfo.get()) == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - runnableInfo.startTimestamp;
        if (jCurrentTimeMillis >= (this.mIsCpuIntensive ? 500L : 5000L) || runnableInfo.findSourceCost >= 200) {
            Async.get().log(runnableInfo.source, runnableInfo.threadName, (int) runnableInfo.findSourceCost, (int) jCurrentTimeMillis);
        }
    }
}
