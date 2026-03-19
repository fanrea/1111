package aegon.chrome.net.impl;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.Log;
import aegon.chrome.base.annotations.JNINamespace;
import aegon.chrome.net.NetworkChangeNotifier;
import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@JNINamespace("cronet")
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class CronetLibraryLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile boolean sInitThreadInitDone;
    private static final Object sLoadLock = new Object();
    private static final String LIBRARY_NAME = "cronet." + ImplVersion.getCronetVersion();
    private static final String TAG = "CronetLibraryLoader";
    private static InitThreadHandler sInitThreadHandler = new DefaultInitThreadHandler();
    private static volatile boolean sLibraryLoaded = false;
    private static final ConditionVariable sWaitForLibLoad = new ConditionVariable();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface InitThreadHandler {
        boolean onInitThread();

        void postTask(Runnable runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeCronetInitOnInitThread();

    /* JADX INFO: Access modifiers changed from: private */
    public static native String nativeGetCronetVersion();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    static class DefaultInitThreadHandler implements InitThreadHandler {
        private final Object sInitLock;
        private HandlerThread sInitThread;

        private DefaultInitThreadHandler() {
            this.sInitLock = new Object();
        }

        private void ensureThread() {
            synchronized (this.sInitLock) {
                if (this.sInitThread == null) {
                    this.sInitThread = new HandlerThread("CronetInit");
                }
                if (!this.sInitThread.isAlive()) {
                    this.sInitThread.start();
                }
            }
        }

        @Override // aegon.chrome.net.impl.CronetLibraryLoader.InitThreadHandler
        public boolean onInitThread() {
            ensureThread();
            return this.sInitThread.getLooper() == Looper.myLooper();
        }

        @Override // aegon.chrome.net.impl.CronetLibraryLoader.InitThreadHandler
        public void postTask(Runnable runnable) {
            ensureThread();
            if (onInitThread()) {
                runnable.run();
            } else {
                new Handler(this.sInitThread.getLooper()).post(runnable);
            }
        }
    }

    public static void setInitThreadHandler(InitThreadHandler initThreadHandler) {
        if (initThreadHandler != null) {
            sInitThreadHandler = initThreadHandler;
        }
    }

    public static void ensureInitialized(Context context, CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        synchronized (sLoadLock) {
            if (!sInitThreadInitDone) {
                ContextUtils.initApplicationContext(context);
                postToInitThread(new Runnable() { // from class: aegon.chrome.net.impl.CronetLibraryLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CronetLibraryLoader.ensureInitializedOnInitThread();
                    }
                });
            }
            if (!sLibraryLoaded) {
                if (cronetEngineBuilderImpl.libraryLoader() != null) {
                    cronetEngineBuilderImpl.libraryLoader().loadLibrary(LIBRARY_NAME);
                } else {
                    System.loadLibrary(LIBRARY_NAME);
                }
                String cronetVersion = ImplVersion.getCronetVersion();
                if (!cronetVersion.equals(SafeNativeFunctionCaller.EnsureResult(CronetLibraryLoader$$Lambda$1.instance))) {
                    throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", cronetVersion, nativeGetCronetVersion()));
                }
                Log.i(TAG, "Cronet version: %s, arch: %s", cronetVersion, System.getProperty("os.arch"));
                sLibraryLoaded = true;
                sWaitForLibLoad.open();
            }
        }
    }

    private static boolean onInitThread() {
        return sInitThreadHandler.onInitThread();
    }

    static void ensureInitializedOnInitThread() {
        if (sInitThreadInitDone) {
            return;
        }
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.registerToReceiveNotificationsAlways();
        sWaitForLibLoad.block();
        SafeNativeFunctionCaller.Ensure(CronetLibraryLoader$$Lambda$2.instance);
        sInitThreadInitDone = true;
    }

    public static void postToInitThread(Runnable runnable) {
        sInitThreadHandler.postTask(runnable);
    }

    private static String getDefaultUserAgent() {
        return UserAgent.from(ContextUtils.getApplicationContext());
    }

    private static void ensureInitializedFromNative() {
        synchronized (sLoadLock) {
            sLibraryLoaded = true;
            sWaitForLibLoad.open();
        }
        ensureInitialized(ContextUtils.getApplicationContext(), null);
    }

    private static void setNetworkThreadPriorityOnNetworkThread(int i) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(i);
    }
}
