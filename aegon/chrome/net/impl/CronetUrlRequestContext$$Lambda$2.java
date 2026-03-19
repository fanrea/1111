package aegon.chrome.net.impl;

import aegon.chrome.net.impl.SafeNativeFunctionCaller;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class CronetUrlRequestContext$$Lambda$2 implements SafeNativeFunctionCaller.Supplier {
    private final CronetEngineBuilderImpl arg$1;

    private CronetUrlRequestContext$$Lambda$2(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        this.arg$1 = cronetEngineBuilderImpl;
    }

    public static SafeNativeFunctionCaller.Supplier lambdaFactory$(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        return new CronetUrlRequestContext$$Lambda$2(cronetEngineBuilderImpl);
    }

    @Override // aegon.chrome.net.impl.SafeNativeFunctionCaller.Supplier
    public final Object get() {
        return CronetUrlRequestContext.lambda$new$1(this.arg$1);
    }
}
