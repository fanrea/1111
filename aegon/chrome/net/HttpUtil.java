package aegon.chrome.net;

import aegon.chrome.base.annotations.JNINamespace;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("net")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class HttpUtil {
    private static native boolean nativeIsAllowedHeader(String str, String str2);

    public static boolean isAllowedHeader(String str, String str2) {
        return nativeIsAllowedHeader(str, str2);
    }
}
