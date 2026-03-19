package aegon.chrome.base.task;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class AsyncTask$$Lambda$1 implements Runnable {
    private final AsyncTask arg$1;
    private final Object arg$2;

    private AsyncTask$$Lambda$1(AsyncTask asyncTask, Object obj) {
        this.arg$1 = asyncTask;
        this.arg$2 = obj;
    }

    public static Runnable lambdaFactory$(AsyncTask asyncTask, Object obj) {
        return new AsyncTask$$Lambda$1(asyncTask, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.arg$1.finish(this.arg$2);
    }
}
