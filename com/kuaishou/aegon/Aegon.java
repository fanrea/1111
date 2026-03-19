package com.kuaishou.aegon;

import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.impl.CronetLibraryLoader;
import aegon.chrome.net.impl.CronetUrlRequestContext;
import aegon.chrome.net.impl.NativeCronetEngineBuilderWithLibraryLoaderImpl;
import android.content.Context;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class Aegon {
    private static final long CREATE_CRONET_CONTEXT_DELAY_MS = 3000;
    private static String LIBRARY_NAME = "aegon";
    private static final String TAG = "Aegon";
    private static Context sApplicationContext;
    private static volatile CronetUrlRequestContext sCronetContext;
    private static final Object sCronetContextMutex = new Object();
    private static AtomicBoolean sInitialized = new AtomicBoolean();
    private static NetworkStateHelper sNetworkStateHelper;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static abstract class InitThreadHandler implements CronetLibraryLoader.InitThreadHandler {
        @Override // aegon.chrome.net.impl.CronetLibraryLoader.InitThreadHandler
        public boolean onInitThread() {
            return true;
        }

        @Override // aegon.chrome.net.impl.CronetLibraryLoader.InitThreadHandler
        public abstract void postTask(Runnable runnable);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static abstract class LibraryLoader {
        public abstract void loadLibrary(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeAddExtraRequestHeader(String str, String str2);

    static native void nativeClearHttpCache();

    static native String nativeGetEffectiveConfig();

    static native long nativeGetHttpCacheUsedBytes();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native String nativeGetPublicIP();

    static native String nativeGetRequestExtraInfo(String str);

    static native String nativeGetVersionString();

    static native void nativeOnBackground();

    static native void nativeOnForeground();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetAutonomousNetworkAccessAllowed(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetDebug(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetInitialized(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetKProxyConfig(String str, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetLoggingCallback(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetPreconnectUrlsByIps(String str, String[] strArr, String[] strArr2, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeSetProxySwitch(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void nativeUpdateConfig(String str, String str2);

    public static void initialize(Context context, String str, String str2, LibraryLoader libraryLoader) {
        e.a(TAG, "Initializing, jsonConfig=" + str + ", storagePath=" + str2);
        long jNanoTime = System.nanoTime();
        if (libraryLoader != null) {
            libraryLoader.loadLibrary(LIBRARY_NAME);
        } else {
            System.loadLibrary(LIBRARY_NAME);
        }
        com.kuaishou.aegon.a.a.a(Aegon$$Lambda$1.lambdaFactory$(str, str2));
        e.a(TAG, "Initialize finished, cost = " + (System.nanoTime() - jNanoTime));
        sApplicationContext = context;
        sInitialized.set(true);
        new Handler(context.getMainLooper()).postDelayed(Aegon$$Lambda$2.instance, 3000L);
    }

    public static void setProxySwitch(boolean z) {
        com.kuaishou.aegon.a.a.a(Aegon$$Lambda$3.lambdaFactory$(z));
    }

    public static String getEffectiveConfig() {
        return !sInitialized.get() ? "" : (String) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$4.instance);
    }

    public static void addLogger(a aVar) {
        AegonLoggerDispatcher.a(aVar);
    }

    public static void removeLogger(a aVar) {
        AegonLoggerDispatcher.b(aVar);
    }

    public static void setDebug(boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$5.lambdaFactory$(z));
        }
    }

    public static void setInitThreadHandler(InitThreadHandler initThreadHandler) {
        CronetLibraryLoader.setInitThreadHandler(initThreadHandler);
    }

    public static void setPreconnectUrls(String str, String[] strArr) {
        setPreconnectUrlsByIps(str, strArr, null, false);
    }

    public static void setPreconnectUrlsByIps(String str, String[] strArr, String[] strArr2, boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$6.lambdaFactory$(str, strArr, strArr2, z));
        }
    }

    public static long getHttpCacheUsedBytes() {
        if (sInitialized.get()) {
            return ((Long) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$7.instance)).longValue();
        }
        return 0L;
    }

    public static void clearHttpCache() {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.a(Aegon$$Lambda$8.instance);
        }
    }

    public static void onBackground() {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.a(Aegon$$Lambda$9.instance);
        }
    }

    public static void onForeground() {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.a(Aegon$$Lambda$10.instance);
        }
    }

    public static void shutdown() {
        synchronized (sCronetContextMutex) {
            if (sCronetContext == null) {
                return;
            }
            sCronetContext.shutdown();
            sCronetContext = null;
        }
    }

    public static CronetEngine getCronetEngine() {
        CronetUrlRequestContext cronetUrlRequestContext;
        CronetUrlRequestContext cronetUrlRequestContext2 = sCronetContext;
        if (cronetUrlRequestContext2 != null) {
            return cronetUrlRequestContext2;
        }
        if (!sInitialized.get()) {
            return null;
        }
        synchronized (sCronetContextMutex) {
            if (sCronetContext == null && sApplicationContext != null) {
                long jNanoTime = System.nanoTime();
                NativeCronetEngineBuilderWithLibraryLoaderImpl nativeCronetEngineBuilderWithLibraryLoaderImpl = new NativeCronetEngineBuilderWithLibraryLoaderImpl(sApplicationContext);
                nativeCronetEngineBuilderWithLibraryLoaderImpl.setLibraryLoader(new CronetEngine.Builder.LibraryLoader() { // from class: com.kuaishou.aegon.Aegon.1
                    @Override // aegon.chrome.net.CronetEngine.Builder.LibraryLoader
                    public final void loadLibrary(String str) {
                    }
                });
                CronetLibraryLoader.ensureInitialized(sApplicationContext.getApplicationContext(), nativeCronetEngineBuilderWithLibraryLoaderImpl);
                CronetLibraryLoader.postToInitThread(Aegon$$Lambda$11.instance);
                sCronetContext = new CronetUrlRequestContext(nativeCronetEngineBuilderWithLibraryLoaderImpl);
                com.kuaishou.aegon.a.a.a(Aegon$$Lambda$12.instance);
                e.a(TAG, "Create cronet engine finished, cost = " + (System.nanoTime() - jNanoTime));
            }
            cronetUrlRequestContext = sCronetContext;
        }
        return cronetUrlRequestContext;
    }

    static /* synthetic */ void lambda$getCronetEngine$4() {
        sNetworkStateHelper = new NetworkStateHelper(sApplicationContext);
    }

    public static String getVersionString() {
        if (sInitialized.get()) {
            return (String) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$13.instance);
        }
        return null;
    }

    public static void setNativeLoggingCallbackFunction(long j, boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$14.lambdaFactory$(j, z));
        }
    }

    public static void setLoggingCallback(d dVar, boolean z) {
        AegonLoggingDispatcher.a(dVar);
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$15.lambdaFactory$(z));
        }
    }

    public static void addExtraRequestHeader(String str, String str2) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$16.lambdaFactory$(str, str2));
        }
    }

    public static void setAutonomousNetworkAccessAllowed(boolean z) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$17.lambdaFactory$(z));
        }
    }

    public static void startKProxy(String str, int i, int i2) {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$18.lambdaFactory$(str, i, i2));
        }
    }

    public static void stopKProxy() {
        if (sInitialized.get()) {
            com.kuaishou.aegon.a.a.b(Aegon$$Lambda$19.instance);
        }
    }

    public static String getPublicIP() {
        return !sInitialized.get() ? "" : (String) com.kuaishou.aegon.a.a.a(Aegon$$Lambda$20.instance);
    }

    public static boolean isInitialized() {
        return sInitialized.get();
    }
}
