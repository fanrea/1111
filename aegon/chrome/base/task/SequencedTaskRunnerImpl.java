package aegon.chrome.base.task;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SequencedTaskRunnerImpl extends TaskRunnerImpl implements SequencedTaskRunner {
    private int mNumUnfinishedNativeTasks;
    private AtomicInteger mPendingTasks;

    SequencedTaskRunnerImpl(TaskTraits taskTraits) {
        super(taskTraits, "SequencedTaskRunnerImpl", 1);
        this.mPendingTasks = new AtomicInteger();
        disableLifetimeCheck();
    }

    @Override // aegon.chrome.base.task.TaskRunnerImpl, aegon.chrome.base.task.TaskRunner
    public void initNativeTaskRunner() {
        synchronized (this.mLock) {
            migratePreNativeTasksToNative();
        }
    }

    @Override // aegon.chrome.base.task.TaskRunnerImpl
    protected void schedulePreNativeTask() {
        if (this.mPendingTasks.getAndIncrement() == 0) {
            super.schedulePreNativeTask();
        }
    }

    @Override // aegon.chrome.base.task.TaskRunnerImpl
    protected void runPreNativeTask() {
        super.runPreNativeTask();
        if (this.mPendingTasks.decrementAndGet() > 0) {
            super.schedulePreNativeTask();
        }
    }

    @Override // aegon.chrome.base.task.TaskRunnerImpl
    public void postDelayedTaskToNative(Runnable runnable, long j) {
        synchronized (this.mLock) {
            int i = this.mNumUnfinishedNativeTasks;
            this.mNumUnfinishedNativeTasks = i + 1;
            if (i == 0) {
                initNativeTaskRunnerInternal();
            }
            super.postDelayedTaskToNative(SequencedTaskRunnerImpl$$Lambda$1.lambdaFactory$(this, runnable), j);
        }
    }

    static /* synthetic */ void lambda$postDelayedTaskToNative$0(SequencedTaskRunnerImpl sequencedTaskRunnerImpl, Runnable runnable) {
        runnable.run();
        synchronized (sequencedTaskRunnerImpl.mLock) {
            int i = sequencedTaskRunnerImpl.mNumUnfinishedNativeTasks - 1;
            sequencedTaskRunnerImpl.mNumUnfinishedNativeTasks = i;
            if (i == 0) {
                sequencedTaskRunnerImpl.destroyInternal();
            }
        }
    }
}
