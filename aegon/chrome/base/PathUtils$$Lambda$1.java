package aegon.chrome.base;

import java.util.concurrent.Callable;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final /* synthetic */ class PathUtils$$Lambda$1 implements Callable {
    private static final PathUtils$$Lambda$1 instance = new PathUtils$$Lambda$1();

    private PathUtils$$Lambda$1() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return PathUtils.setPrivateDataDirectorySuffixInternal();
    }
}
