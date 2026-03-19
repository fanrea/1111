package aegon.chrome.base;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class Promise$$Lambda$6 implements Runnable {
    private final Callback arg$1;
    private final Object arg$2;

    private Promise$$Lambda$6(Callback callback, Object obj) {
        this.arg$1 = callback;
        this.arg$2 = obj;
    }

    public static Runnable lambdaFactory$(Callback callback, Object obj) {
        return new Promise$$Lambda$6(callback, obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.arg$1.onResult(this.arg$2);
    }
}
