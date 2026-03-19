package aegon.chrome.base.metrics;

import aegon.chrome.base.ThreadUtils;
import aegon.chrome.base.annotations.JNINamespace;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("base::android")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class RecordUserAction {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Throwable sDisabledBy;
    private static long sNativeActionCallback;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface UserActionCallback {
        void onActionRecorded(String str);
    }

    private static native long nativeAddActionCallbackForTesting(UserActionCallback userActionCallback);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRecordUserAction(String str);

    private static native void nativeRemoveActionCallbackForTesting(long j);

    public static void setDisabledForTests(boolean z) {
        if (z && sDisabledBy != null) {
            throw new IllegalStateException("UserActions are already disabled.", sDisabledBy);
        }
        sDisabledBy = z ? new Throwable() : null;
    }

    public static void record(final String str) {
        if (sDisabledBy != null) {
            return;
        }
        if (ThreadUtils.runningOnUiThread()) {
            nativeRecordUserAction(str);
        } else {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: aegon.chrome.base.metrics.RecordUserAction.1
                @Override // java.lang.Runnable
                public void run() {
                    RecordUserAction.nativeRecordUserAction(str);
                }
            });
        }
    }

    public static void setActionCallbackForTesting(UserActionCallback userActionCallback) {
        sNativeActionCallback = nativeAddActionCallbackForTesting(userActionCallback);
    }

    public static void removeActionCallbackForTesting() {
        nativeRemoveActionCallbackForTesting(sNativeActionCallback);
        sNativeActionCallback = 0L;
    }
}
