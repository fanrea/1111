package aegon.chrome.base.task;

import aegon.chrome.base.BuildConfig;
import aegon.chrome.base.task.AsyncTask;
import android.os.Process;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE;
    private static final int RUNNABLE_WARNING_COUNT = 32;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        MAXIMUM_POOL_SIZE = (iAvailableProcessors * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    /* renamed from: aegon.chrome.base.task.ChromeThreadPoolExecutor$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger mCount = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(ChromeThreadPoolExecutor$1$$Lambda$1.lambdaFactory$(runnable), "CrAsyncTask #" + this.mCount.getAndIncrement());
        }

        static /* synthetic */ void lambda$newThread$0(Runnable runnable) throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            runnable.run();
        }
    }

    ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    ChromeThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }

    private static String getClassName(Runnable runnable) throws NoSuchFieldException {
        Class blamedClass = runnable.getClass();
        try {
            if (blamedClass == AsyncTask.NamedFutureTask.class) {
                blamedClass = ((AsyncTask.NamedFutureTask) runnable).getBlamedClass();
            } else if (blamedClass.getEnclosingClass() == android.os.AsyncTask.class) {
                Field declaredField = blamedClass.getDeclaredField("this$0");
                declaredField.setAccessible(true);
                blamedClass = declaredField.get(runnable).getClass();
            }
        } catch (IllegalAccessException e) {
            if (BuildConfig.DCHECK_IS_ON) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException e2) {
            if (BuildConfig.DCHECK_IS_ON) {
                throw new RuntimeException(e2);
            }
        }
        return blamedClass.getName();
    }

    private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() throws NoSuchFieldException {
        HashMap map = new HashMap();
        for (Runnable runnable : (Runnable[]) getQueue().toArray(new Runnable[0])) {
            String className = getClassName(runnable);
            map.put(className, Integer.valueOf((map.containsKey(className) ? ((Integer) map.get(className)).intValue() : 0) + 1));
        }
        return map;
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() > 32) {
                sb.append(entry.getKey()).append(' ');
            }
        }
        return sb.length() == 0 ? "NO CLASSES FOUND" : sb.toString();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) throws NoSuchFieldException {
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e) {
            throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(getNumberOfClassNameOccurrencesInQueue()), e);
        }
    }
}
