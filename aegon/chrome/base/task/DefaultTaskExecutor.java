package aegon.chrome.base.task;

import aegon.chrome.base.ThreadUtils;
import android.view.Choreographer;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap = new HashMap();

    @Override // aegon.chrome.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits taskTraits) {
        return false;
    }

    DefaultTaskExecutor() {
    }

    @Override // aegon.chrome.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new TaskRunnerImpl(taskTraits);
    }

    @Override // aegon.chrome.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new SequencedTaskRunnerImpl(taskTraits);
    }

    @Override // aegon.chrome.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new SingleThreadTaskRunnerImpl(null, taskTraits);
    }

    @Override // aegon.chrome.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        if (taskTraits.hasExtension()) {
            TaskRunner taskRunnerCreateTaskRunner = createTaskRunner(taskTraits);
            taskRunnerCreateTaskRunner.postDelayedTask(runnable, j);
            taskRunnerCreateTaskRunner.destroy();
        } else {
            TaskRunner taskRunnerCreateTaskRunner2 = this.mTraitsToRunnerMap.get(taskTraits);
            if (taskRunnerCreateTaskRunner2 == null) {
                taskRunnerCreateTaskRunner2 = createTaskRunner(taskTraits);
                taskRunnerCreateTaskRunner2.disableLifetimeCheck();
                this.mTraitsToRunnerMap.put(taskTraits, taskRunnerCreateTaskRunner2);
            }
            taskRunnerCreateTaskRunner2.postDelayedTask(runnable, j);
        }
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        return (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(DefaultTaskExecutor$$Lambda$1.instance);
    }

    static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }
}
