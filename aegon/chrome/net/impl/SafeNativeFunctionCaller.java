package aegon.chrome.net.impl;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class SafeNativeFunctionCaller {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface Supplier<T> {
        T get();
    }

    SafeNativeFunctionCaller() {
    }

    public static void Ensure(Runnable runnable) {
        try {
            try {
                runnable.run();
            } catch (UnsatisfiedLinkError unused) {
                runnable.run();
            }
        } catch (UnsatisfiedLinkError unused2) {
            runnable.run();
        }
    }

    public static <T> T EnsureResult(Supplier<T> supplier) {
        try {
            try {
                return supplier.get();
            } catch (UnsatisfiedLinkError unused) {
                return supplier.get();
            }
        } catch (UnsatisfiedLinkError unused2) {
            return supplier.get();
        }
    }

    public static void Maybe(Runnable runnable) {
        try {
            runnable.run();
        } catch (UnsatisfiedLinkError unused) {
        }
    }
}
