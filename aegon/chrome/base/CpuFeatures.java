package aegon.chrome.base;

import aegon.chrome.base.annotations.JNINamespace;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class CpuFeatures {
    private static native int nativeGetCoreCount();

    private static native long nativeGetCpuFeatures();

    public static int getCount() {
        return nativeGetCoreCount();
    }

    public static long getMask() {
        return nativeGetCpuFeatures();
    }
}
