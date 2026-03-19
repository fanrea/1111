package aegon.chrome.base.task;

import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class AsyncTask$$Lambda$2 implements Executor {
    private static final AsyncTask$$Lambda$2 instance = new AsyncTask$$Lambda$2();

    private AsyncTask$$Lambda$2() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        AsyncTask.lambda$static$0(runnable);
    }
}
