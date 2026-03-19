package aegon.chrome.base;

import aegon.chrome.base.memory.MemoryPressureCallback;
import android.app.Activity;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class MemoryPressureListener {
    private static final String ACTION_LOW_MEMORY = "aegon.chrome.base.ACTION_LOW_MEMORY";
    private static final String ACTION_TRIM_MEMORY = "aegon.chrome.base.ACTION_TRIM_MEMORY";
    private static final String ACTION_TRIM_MEMORY_MODERATE = "aegon.chrome.base.ACTION_TRIM_MEMORY_MODERATE";
    private static final String ACTION_TRIM_MEMORY_RUNNING_CRITICAL = "aegon.chrome.base.ACTION_TRIM_MEMORY_RUNNING_CRITICAL";
    private static final ObserverList<MemoryPressureCallback> sCallbacks = new ObserverList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnMemoryPressure(int i);

    private static void addNativeCallback() {
        addCallback(MemoryPressureListener$$Lambda$1.instance);
    }

    public static void addCallback(MemoryPressureCallback memoryPressureCallback) {
        sCallbacks.addObserver(memoryPressureCallback);
    }

    public static void removeCallback(MemoryPressureCallback memoryPressureCallback) {
        sCallbacks.removeObserver(memoryPressureCallback);
    }

    public static void notifyMemoryPressure(int i) {
        Iterator<MemoryPressureCallback> it = sCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onPressure(i);
        }
    }

    public static boolean handleDebugIntent(Activity activity, String str) {
        if (ACTION_LOW_MEMORY.equals(str)) {
            simulateLowMemoryPressureSignal(activity);
            return true;
        }
        if (ACTION_TRIM_MEMORY.equals(str)) {
            simulateTrimMemoryPressureSignal(activity, 80);
            return true;
        }
        if (ACTION_TRIM_MEMORY_RUNNING_CRITICAL.equals(str)) {
            simulateTrimMemoryPressureSignal(activity, 15);
            return true;
        }
        if (!ACTION_TRIM_MEMORY_MODERATE.equals(str)) {
            return false;
        }
        simulateTrimMemoryPressureSignal(activity, 60);
        return true;
    }

    private static void simulateLowMemoryPressureSignal(Activity activity) {
        activity.getApplication().onLowMemory();
        activity.onLowMemory();
    }

    private static void simulateTrimMemoryPressureSignal(Activity activity, int i) {
        activity.getApplication().onTrimMemory(i);
        activity.onTrimMemory(i);
    }
}
