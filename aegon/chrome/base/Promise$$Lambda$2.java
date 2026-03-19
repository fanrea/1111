package aegon.chrome.base;

import aegon.chrome.base.Promise;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class Promise$$Lambda$2 implements Callback {
    private final Promise arg$1;
    private final Promise.Function arg$2;

    private Promise$$Lambda$2(Promise promise, Promise.Function function) {
        this.arg$1 = promise;
        this.arg$2 = function;
    }

    public static Callback lambdaFactory$(Promise promise, Promise.Function function) {
        return new Promise$$Lambda$2(promise, function);
    }

    @Override // aegon.chrome.base.Callback
    public final void onResult(Object obj) {
        Promise.lambda$then$1(this.arg$1, this.arg$2, obj);
    }
}
