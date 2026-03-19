package aegon.chrome.base.task;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class TaskRunnerImpl$$Lambda$1 implements Runnable {
    private final TaskRunnerImpl arg$1;

    private TaskRunnerImpl$$Lambda$1(TaskRunnerImpl taskRunnerImpl) {
        this.arg$1 = taskRunnerImpl;
    }

    public static Runnable lambdaFactory$(TaskRunnerImpl taskRunnerImpl) {
        return new TaskRunnerImpl$$Lambda$1(taskRunnerImpl);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.arg$1.runPreNativeTask();
    }
}
