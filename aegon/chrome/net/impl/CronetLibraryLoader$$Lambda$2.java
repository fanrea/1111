package aegon.chrome.net.impl;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class CronetLibraryLoader$$Lambda$2 implements Runnable {
    private static final CronetLibraryLoader$$Lambda$2 instance = new CronetLibraryLoader$$Lambda$2();

    private CronetLibraryLoader$$Lambda$2() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CronetLibraryLoader.nativeCronetInitOnInitThread();
    }
}
