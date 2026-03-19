package aegon.chrome.base.metrics;

import aegon.chrome.base.annotations.JNINamespace;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class StatisticsRecorderAndroid {
    private static native String nativeToJson(int i);

    private StatisticsRecorderAndroid() {
    }

    public static String toJson(int i) {
        return nativeToJson(i);
    }
}
