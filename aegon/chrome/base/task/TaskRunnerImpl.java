package aegon.chrome.base.task;

import aegon.chrome.base.LifetimeAssert;
import aegon.chrome.base.TraceEvent;
import aegon.chrome.base.annotations.JNINamespace;
import android.os.Process;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class TaskRunnerImpl implements TaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mIsDestroying;
    private final LifetimeAssert mLifetimeAssert;
    protected final Object mLock;
    protected long mNativeTaskRunnerAndroid;
    protected List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    protected LinkedList<Runnable> mPreNativeTasks;
    protected final Runnable mRunPreNativeTaskClosure;
    private final int mTaskRunnerType;
    private final TaskTraits mTaskTraits;
    private final String mTraceEvent;

    private native void nativeDestroy(long j);

    private native long nativeInit(int i, boolean z, int i2, boolean z2, boolean z3, byte b, byte[] bArr);

    private native void nativePostDelayedTask(long j, Runnable runnable, long j2);

    protected native boolean nativeBelongsToCurrentThread(long j);

    TaskRunnerImpl(TaskTraits taskTraits) {
        this(taskTraits, "TaskRunnerImpl", 0);
    }

    protected TaskRunnerImpl(TaskTraits taskTraits, String str, int i) {
        this.mLock = new Object();
        this.mRunPreNativeTaskClosure = TaskRunnerImpl$$Lambda$1.lambdaFactory$(this);
        this.mLifetimeAssert = LifetimeAssert.create(this);
        this.mPreNativeTasks = new LinkedList<>();
        this.mPreNativeDelayedTasks = new ArrayList();
        this.mTaskTraits = taskTraits;
        this.mTraceEvent = str + ".PreNativeTask.run";
        this.mTaskRunnerType = i;
        if (PostTask.registerPreNativeTaskRunnerLocked(this)) {
            return;
        }
        initNativeTaskRunner();
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void destroy() {
        synchronized (this.mLock) {
            LifetimeAssert.setSafeToGc(this.mLifetimeAssert, true);
            this.mIsDestroying = true;
            destroyInternal();
        }
    }

    protected void destroyInternal() {
        long j = this.mNativeTaskRunnerAndroid;
        if (j != 0) {
            nativeDestroy(j);
        }
        this.mNativeTaskRunnerAndroid = 0L;
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void disableLifetimeCheck() {
        LifetimeAssert.setSafeToGc(this.mLifetimeAssert, true);
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void postTask(Runnable runnable) {
        postDelayedTask(runnable, 0L);
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void postDelayedTask(Runnable runnable, long j) {
        synchronized (this.mLock) {
            LinkedList<Runnable> linkedList = this.mPreNativeTasks;
            if (linkedList == null) {
                postDelayedTaskToNative(runnable, j);
                return;
            }
            if (j == 0) {
                linkedList.add(runnable);
                schedulePreNativeTask();
            } else {
                this.mPreNativeDelayedTasks.add(new Pair<>(runnable, Long.valueOf(j)));
            }
        }
    }

    protected void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }

    protected void runPreNativeTask() {
        TraceEvent traceEventScoped = TraceEvent.scoped(this.mTraceEvent);
        try {
            synchronized (this.mLock) {
                LinkedList<Runnable> linkedList = this.mPreNativeTasks;
                if (linkedList == null) {
                    if (traceEventScoped != null) {
                        traceEventScoped.close();
                        return;
                    }
                    return;
                }
                Runnable runnablePoll = linkedList.poll();
                int i = this.mTaskTraits.mPriority;
                if (i == 1) {
                    Process.setThreadPriority(0);
                } else if (i == 2) {
                    Process.setThreadPriority(-1);
                } else {
                    Process.setThreadPriority(10);
                }
                runnablePoll.run();
                if (traceEventScoped != null) {
                    traceEventScoped.close();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (traceEventScoped != null) {
                    try {
                        traceEventScoped.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // aegon.chrome.base.task.TaskRunner
    public void initNativeTaskRunner() {
        synchronized (this.mLock) {
            initNativeTaskRunnerInternal();
            migratePreNativeTasksToNative();
        }
    }

    protected void initNativeTaskRunnerInternal() {
        if (this.mNativeTaskRunnerAndroid == 0) {
            this.mNativeTaskRunnerAndroid = nativeInit(this.mTaskRunnerType, this.mTaskTraits.mPrioritySetExplicitly, this.mTaskTraits.mPriority, this.mTaskTraits.mMayBlock, this.mTaskTraits.mUseThreadPool, this.mTaskTraits.mExtensionId, this.mTaskTraits.mExtensionData);
        }
    }

    protected void migratePreNativeTasksToNative() {
        LinkedList<Runnable> linkedList = this.mPreNativeTasks;
        if (linkedList != null) {
            Iterator<Runnable> it = linkedList.iterator();
            while (it.hasNext()) {
                postDelayedTaskToNative(it.next(), 0L);
            }
            for (Pair<Runnable, Long> pair : this.mPreNativeDelayedTasks) {
                postDelayedTaskToNative((Runnable) pair.first, ((Long) pair.second).longValue());
            }
            this.mPreNativeTasks = null;
            this.mPreNativeDelayedTasks = null;
        }
    }

    protected void postDelayedTaskToNative(Runnable runnable, long j) {
        nativePostDelayedTask(this.mNativeTaskRunnerAndroid, runnable, j);
    }
}
