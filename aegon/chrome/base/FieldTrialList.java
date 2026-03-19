package aegon.chrome.base;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class FieldTrialList {
    private static native String nativeFindFullName(String str);

    private static native String nativeGetVariationParameter(String str, String str2);

    private static native void nativeLogActiveTrials();

    private static native boolean nativeTrialExists(String str);

    private FieldTrialList() {
    }

    public static String findFullName(String str) {
        return nativeFindFullName(str);
    }

    public static boolean trialExists(String str) {
        return nativeTrialExists(str);
    }

    public static String getVariationParameter(String str, String str2) {
        return nativeGetVariationParameter(str, str2);
    }

    public static void logActiveTrials() {
        nativeLogActiveTrials();
    }
}
