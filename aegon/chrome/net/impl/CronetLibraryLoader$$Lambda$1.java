package aegon.chrome.net.impl;

import aegon.chrome.net.impl.SafeNativeFunctionCaller;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class CronetLibraryLoader$$Lambda$1 implements SafeNativeFunctionCaller.Supplier {
    private static final CronetLibraryLoader$$Lambda$1 instance = new CronetLibraryLoader$$Lambda$1();

    private CronetLibraryLoader$$Lambda$1() {
    }

    @Override // aegon.chrome.net.impl.SafeNativeFunctionCaller.Supplier
    public final Object get() {
        return CronetLibraryLoader.nativeGetCronetVersion();
    }
}
