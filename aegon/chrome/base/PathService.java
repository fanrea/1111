package aegon.chrome.base;

import aegon.chrome.base.annotations.JNINamespace;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class PathService {
    public static final int DIR_MODULE = 3;

    private static native void nativeOverride(int i, String str);

    private PathService() {
    }

    public static void override(int i, String str) {
        nativeOverride(i, str);
    }
}
