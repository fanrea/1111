package aegon.chrome.base.task;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class SequencedTaskRunnerImpl$$Lambda$1 implements Runnable {
    private final SequencedTaskRunnerImpl arg$1;
    private final Runnable arg$2;

    private SequencedTaskRunnerImpl$$Lambda$1(SequencedTaskRunnerImpl sequencedTaskRunnerImpl, Runnable runnable) {
        this.arg$1 = sequencedTaskRunnerImpl;
        this.arg$2 = runnable;
    }

    public static Runnable lambdaFactory$(SequencedTaskRunnerImpl sequencedTaskRunnerImpl, Runnable runnable) {
        return new SequencedTaskRunnerImpl$$Lambda$1(sequencedTaskRunnerImpl, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SequencedTaskRunnerImpl.lambda$postDelayedTaskToNative$0(this.arg$1, this.arg$2);
    }
}
