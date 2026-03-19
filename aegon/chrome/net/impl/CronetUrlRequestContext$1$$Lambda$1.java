package aegon.chrome.net.impl;

import aegon.chrome.net.impl.CronetUrlRequestContext;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class CronetUrlRequestContext$1$$Lambda$1 implements Runnable {
    private final CronetUrlRequestContext.AnonymousClass1 arg$1;

    private CronetUrlRequestContext$1$$Lambda$1(CronetUrlRequestContext.AnonymousClass1 anonymousClass1) {
        this.arg$1 = anonymousClass1;
    }

    public static Runnable lambdaFactory$(CronetUrlRequestContext.AnonymousClass1 anonymousClass1) {
        return new CronetUrlRequestContext$1$$Lambda$1(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CronetUrlRequestContext.AnonymousClass1.lambda$run$0(this.arg$1);
    }
}
