package aegon.chrome.base;

import aegon.chrome.base.memory.MemoryPressureCallback;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class MemoryPressureListener$$Lambda$1 implements MemoryPressureCallback {
    private static final MemoryPressureListener$$Lambda$1 instance = new MemoryPressureListener$$Lambda$1();

    private MemoryPressureListener$$Lambda$1() {
    }

    @Override // aegon.chrome.base.memory.MemoryPressureCallback
    public final void onPressure(int i) {
        MemoryPressureListener.nativeOnMemoryPressure(i);
    }
}
