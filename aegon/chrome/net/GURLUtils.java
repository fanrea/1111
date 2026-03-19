package aegon.chrome.net;

import aegon.chrome.base.annotations.JNINamespace;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("net")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class GURLUtils {
    private static native String nativeGetOrigin(String str);

    private static native String nativeGetScheme(String str);

    public static String getOrigin(String str) {
        return nativeGetOrigin(str);
    }

    public static String getScheme(String str) {
        return nativeGetScheme(str);
    }
}
