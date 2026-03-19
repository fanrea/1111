package aegon.chrome.base;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class Promise$$Lambda$1 implements Callback {
    private static final Promise$$Lambda$1 instance = new Promise$$Lambda$1();

    private Promise$$Lambda$1() {
    }

    @Override // aegon.chrome.base.Callback
    public final void onResult(Object obj) {
        Promise.lambda$then$0((Exception) obj);
    }
}
