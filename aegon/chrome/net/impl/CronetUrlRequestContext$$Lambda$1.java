package aegon.chrome.net.impl;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class CronetUrlRequestContext$$Lambda$1 implements Runnable {
    private final CronetUrlRequestContext arg$1;

    private CronetUrlRequestContext$$Lambda$1(CronetUrlRequestContext cronetUrlRequestContext) {
        this.arg$1 = cronetUrlRequestContext;
    }

    public static Runnable lambdaFactory$(CronetUrlRequestContext cronetUrlRequestContext) {
        return new CronetUrlRequestContext$$Lambda$1(cronetUrlRequestContext);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CronetUrlRequestContext.nativeSetMinLogLevel(this.arg$1.getLoggingLevel());
    }
}
