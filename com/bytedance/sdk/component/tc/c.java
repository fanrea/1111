package com.bytedance.sdk.component.tc;

import com.baidu.mobstat.forbes.Config;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static final c d = new c();
    private hc b;
    private d c;
    private final List<WeakReference<ThreadPoolExecutor>> hc = new ArrayList();

    public interface d {
    }

    public interface hc {
    }

    private ScheduledExecutorService hc() {
        return mk.hc.mq();
    }

    public synchronized void d(com.bytedance.sdk.component.tc.c.c cVar) {
        hc(cVar);
        this.hc.add(new WeakReference<>(cVar));
    }

    public synchronized void hc(com.bytedance.sdk.component.tc.c.c cVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.hc.iterator();
        while (it.hasNext()) {
            if (it.next().get() == cVar) {
                it.remove();
            }
        }
    }

    public String d(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.bytedance.sdk.component.tc.d.d) {
            return ((com.bytedance.sdk.component.tc.d.d) blockingQueue).d();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor d(String str, String str2) throws NoSuchFieldException {
        List<ThreadPoolExecutor> listD = d(str2, false, true);
        d(listD, str);
        ThreadPoolExecutor threadPoolExecutor = listD.size() > 0 ? listD.get(0) : null;
        d();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> d(String str, boolean z, boolean z2) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z3;
        arrayList = new ArrayList();
        for (WeakReference<ThreadPoolExecutor> weakReference : this.hc) {
            if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.bytedance.sdk.component.tc.d.d) {
                    z3 = ((com.bytedance.sdk.component.tc.d.d) queue).hc() instanceof PriorityBlockingQueue;
                } else {
                    z3 = queue instanceof PriorityBlockingQueue;
                }
                if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z3)) {
                    if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                        arrayList.add(threadPoolExecutor);
                        if (z) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z2 && !z) {
            try {
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.bytedance.sdk.component.tc.c.1
                    @Override // java.util.Comparator
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        return poolSize > poolSize2 ? -1 : 0;
                    }
                });
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            arrayList.size();
            this.hc.size();
        } else {
            arrayList.size();
            this.hc.size();
        }
        return arrayList;
    }

    public void d() {
        if (mk.hc.d()) {
            hc().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.2
                @Override // java.lang.Runnable
                public void run() throws NoSuchFieldException {
                    c.this.b();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() throws NoSuchFieldException {
        List<ThreadPoolExecutor> listD = d(null, false, false);
        if (listD == null || listD.size() == 0) {
            return;
        }
        if (this.b != null) {
            u.d();
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : listD) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof tc) {
                    map.put(((tc) threadFactory).d + Config.replace + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.tc.d.c) {
                    map.put(((com.bytedance.sdk.component.tc.d.c) threadFactory).d() + Config.replace + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + Config.replace + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                d(threadPoolExecutor);
            }
        }
        if (this.b != null) {
            u.d();
        }
    }

    private void d(final ThreadPoolExecutor threadPoolExecutor) {
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.NANOSECONDS);
        final boolean zAllowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.NANOSECONDS);
        if (zAllowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        hc().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j = keepAliveTime;
                if (j == 0) {
                    j = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(zAllowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void d(List<ThreadPoolExecutor> list, String str) throws NoSuchFieldException {
        if (list == null || list.size() == 0 || this.c == null) {
            return;
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof tc) {
                    map.put(((tc) threadFactory).d + Config.replace + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.tc.d.c) {
                    map.put(((com.bytedance.sdk.component.tc.d.c) threadFactory).d() + Config.replace + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + Config.replace + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap map2 = new HashMap();
        ThreadGroup threadGroupHc = u.hc();
        int iActiveCount = threadGroupHc.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroupHc.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            Thread thread = threadArr[i];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                String strReplaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) map2.get(strReplaceAll);
                map2.put(strReplaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public void d(String str) throws NoSuchFieldException {
        List<ThreadPoolExecutor> listD = d(null, false, true);
        if (listD == null || listD.size() == 0) {
            return;
        }
        d(listD, str);
        listD.size();
        ThreadPoolExecutor threadPoolExecutor = listD.get(0);
        if (threadPoolExecutor != null) {
            d(threadPoolExecutor);
        }
        d();
    }

    private c() {
        hc().schedule(new Runnable() { // from class: com.bytedance.sdk.component.tc.c.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }
}
