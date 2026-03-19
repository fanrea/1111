package aegon.chrome.base.task;

import aegon.chrome.base.annotations.JNINamespace;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class PostTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Executor sPrenativeThreadPoolExecutorOverride;
    private static final Object sLock = new Object();
    private static Set<TaskRunner> sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
    private static final Executor sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
    private static final TaskExecutor[] sTaskExecutors = getInitialTaskExecutors();

    private static native void nativePostDelayedTask(boolean z, int i, boolean z2, boolean z3, byte b, byte[] bArr, Runnable runnable, long j);

    private static TaskExecutor[] getInitialTaskExecutors() {
        TaskExecutor[] taskExecutorArr = new TaskExecutor[5];
        taskExecutorArr[0] = new DefaultTaskExecutor();
        return taskExecutorArr;
    }

    public static TaskRunner createTaskRunner(TaskTraits taskTraits) {
        TaskRunner taskRunnerCreateTaskRunner;
        synchronized (sLock) {
            taskRunnerCreateTaskRunner = getTaskExecutorForTraits(taskTraits).createTaskRunner(taskTraits);
        }
        return taskRunnerCreateTaskRunner;
    }

    public static SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        SequencedTaskRunner sequencedTaskRunnerCreateSequencedTaskRunner;
        synchronized (sLock) {
            sequencedTaskRunnerCreateSequencedTaskRunner = getTaskExecutorForTraits(taskTraits).createSequencedTaskRunner(taskTraits);
        }
        return sequencedTaskRunnerCreateSequencedTaskRunner;
    }

    public static SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        SingleThreadTaskRunner singleThreadTaskRunnerCreateSingleThreadTaskRunner;
        synchronized (sLock) {
            singleThreadTaskRunnerCreateSingleThreadTaskRunner = getTaskExecutorForTraits(taskTraits).createSingleThreadTaskRunner(taskTraits);
        }
        return singleThreadTaskRunnerCreateSingleThreadTaskRunner;
    }

    public static void postTask(TaskTraits taskTraits, Runnable runnable) {
        postDelayedTask(taskTraits, runnable, 0L);
    }

    public static void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        synchronized (sLock) {
            if (sPreNativeTaskRunners != null || taskTraits.mIsChoreographerFrame) {
                getTaskExecutorForTraits(taskTraits).postDelayedTask(taskTraits, runnable, j);
            } else {
                nativePostDelayedTask(taskTraits.mPrioritySetExplicitly, taskTraits.mPriority, taskTraits.mMayBlock, taskTraits.mUseThreadPool, taskTraits.mExtensionId, taskTraits.mExtensionData, runnable, j);
            }
        }
    }

    public static void runOrPostTask(TaskTraits taskTraits, Runnable runnable) {
        if (getTaskExecutorForTraits(taskTraits).canRunTaskImmediately(taskTraits)) {
            runnable.run();
        } else {
            postTask(taskTraits, runnable);
        }
    }

    @Deprecated
    public static <T> T runSynchronously(TaskTraits taskTraits, Callable<T> callable) {
        return (T) runSynchronouslyInternal(taskTraits, new FutureTask(callable));
    }

    @Deprecated
    public static void runSynchronously(TaskTraits taskTraits, Runnable runnable) {
        runSynchronouslyInternal(taskTraits, new FutureTask(runnable, null));
    }

    private static <T> T runSynchronouslyInternal(TaskTraits taskTraits, FutureTask<T> futureTask) {
        runOrPostTask(taskTraits, futureTask);
        try {
            return futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerTaskExecutor(int i, TaskExecutor taskExecutor) {
        synchronized (sLock) {
            sTaskExecutors[i] = taskExecutor;
        }
    }

    public static void setPrenativeThreadPoolExecutorForTesting(Executor executor) {
        synchronized (sLock) {
            sPrenativeThreadPoolExecutorOverride = executor;
        }
    }

    public static void resetPrenativeThreadPoolExecutorForTesting() {
        synchronized (sLock) {
            sPrenativeThreadPoolExecutorOverride = null;
        }
    }

    static Executor getPrenativeThreadPoolExecutor() {
        synchronized (sLock) {
            Executor executor = sPrenativeThreadPoolExecutorOverride;
            if (executor != null) {
                return executor;
            }
            return sPrenativeThreadPoolExecutor;
        }
    }

    static boolean registerPreNativeTaskRunnerLocked(TaskRunner taskRunner) {
        Set<TaskRunner> set = sPreNativeTaskRunners;
        if (set == null) {
            return false;
        }
        set.add(taskRunner);
        return true;
    }

    private static TaskExecutor getTaskExecutorForTraits(TaskTraits taskTraits) {
        return sTaskExecutors[taskTraits.mExtensionId];
    }

    private static void onNativeSchedulerReady() {
        synchronized (sLock) {
            Set<TaskRunner> set = sPreNativeTaskRunners;
            sPreNativeTaskRunners = null;
            Iterator<TaskRunner> it = set.iterator();
            while (it.hasNext()) {
                it.next().initNativeTaskRunner();
            }
        }
    }

    private static void onNativeSchedulerShutdown() {
        synchronized (sLock) {
            sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
        }
    }
}
