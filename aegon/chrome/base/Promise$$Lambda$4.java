package aegon.chrome.base;

import aegon.chrome.base.Promise;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class Promise$$Lambda$4 implements Callback {
    private final Promise.AsyncFunction arg$1;
    private final Promise arg$2;

    private Promise$$Lambda$4(Promise.AsyncFunction asyncFunction, Promise promise) {
        this.arg$1 = asyncFunction;
        this.arg$2 = promise;
    }

    public static Callback lambdaFactory$(Promise.AsyncFunction asyncFunction, Promise promise) {
        return new Promise$$Lambda$4(asyncFunction, promise);
    }

    @Override // aegon.chrome.base.Callback
    public final void onResult(Object obj) {
        Promise.lambda$then$2(this.arg$1, this.arg$2, obj);
    }
}
