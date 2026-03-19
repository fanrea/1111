package com.bytedance.sdk.component.tc;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u {
    private static void d(Throwable th) {
        String.valueOf(th.getMessage());
    }

    public static int d() throws NoSuchFieldException {
        ThreadGroup threadGroupHc = hc();
        if (threadGroupHc == null) {
            return 0;
        }
        int iActiveCount = threadGroupHc.activeCount();
        try {
            return threadGroupHc.enumerate(new Thread[(iActiveCount / 2) + iActiveCount]);
        } catch (Throwable unused) {
            return iActiveCount;
        }
    }

    public static ThreadGroup hc() throws NoSuchFieldException {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            d(e);
            return null;
        }
    }

    public static void d(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            try {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                d(e);
            }
            executorService.execute(new Runnable() { // from class: com.bytedance.sdk.component.tc.u.1
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    u.hc(threadPoolExecutor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException {
        try {
            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            d(e);
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        while (true) {
            if (queue != null) {
                try {
                    if (queue.size() > 0) {
                        while (true) {
                            Runnable runnablePoll = queue.poll(0L, TimeUnit.MILLISECONDS);
                            if (runnablePoll == null) {
                                break;
                            } else {
                                runnablePoll.run();
                            }
                        }
                    }
                } catch (Exception unused) {
                    continue;
                }
            }
            if (threadPoolExecutor.getActiveCount() != 0) {
                Thread.sleep(1000L);
            } else {
                threadPoolExecutor.shutdown();
                return;
            }
        }
    }
}
