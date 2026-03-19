package aegon.chrome.base;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class Promise$$Lambda$5 implements Callback {
    private final Promise arg$1;

    private Promise$$Lambda$5(Promise promise) {
        this.arg$1 = promise;
    }

    public static Callback lambdaFactory$(Promise promise) {
        return new Promise$$Lambda$5(promise);
    }

    @Override // aegon.chrome.base.Callback
    public final void onResult(Object obj) {
        this.arg$1.reject((Exception) obj);
    }
}
