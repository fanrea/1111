package com.kwai.video.cache;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker;
import com.kwad.sdk.AdLiveOfflineCompoImpl;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.hodor.Hodor;
import com.kwai.video.hodor.HodorConfig;
import com.kwai.video.hodor.NetworkMonitor;
import com.kwai.video.hodor.util.OnceReadyBarrier;
import com.kwai.video.hodor.util.Timber;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AwesomeCacheInitConfig {
    private static boolean mInited = false;
    private static volatile AwesomeCacheSoLoader sAwesomeCacheSoLoader;
    private static OnceReadyBarrier sSoLibReadyBarrirer = new OnceReadyBarrier();

    public static void setSoLoader(AwesomeCacheSoLoader awesomeCacheSoLoader) {
        sAwesomeCacheSoLoader = awesomeCacheSoLoader;
    }

    public static synchronized void init(Context context) {
        if (mInited) {
            return;
        }
        final Context applicationContext = context == null ? null : context.getApplicationContext();
        final AwesomeCacheSoLoader awesomeCacheSoLoader = sAwesomeCacheSoLoader;
        AwesomeCacheSoLoader awesomeCacheSoLoader2 = new AwesomeCacheSoLoader() { // from class: com.kwai.video.cache.AwesomeCacheInitConfig.1
            @Override // com.kwai.video.cache.AwesomeCacheSoLoader
            public final void loadLibrary(String str) {
                AwesomeCacheSoLoader awesomeCacheSoLoader3 = awesomeCacheSoLoader;
                if (awesomeCacheSoLoader3 != null) {
                    awesomeCacheSoLoader3.loadLibrary(str);
                } else if (applicationContext != null) {
                    ReLinker.recursively().loadLibrary(applicationContext, str);
                } else {
                    Timber.w("WARNING! AwesomeCacheSoLoader is using System.loadLibrary", new Object[0]);
                    System.loadLibrary(str);
                }
            }
        };
        awesomeCacheSoLoader2.loadLibrary("c++_shared");
        awesomeCacheSoLoader2.loadLibrary(AdLiveOfflineCompoImpl.SO_AEGON);
        awesomeCacheSoLoader2.loadLibrary(AdLiveOfflineCompoImpl.SO_HODOR);
        sSoLibReadyBarrirer.setReady();
        Hodor.loadJavaClass();
        HodorConfig.init(context);
        AwesomeCache.VodAdaptive.init(context);
        NetworkMonitor.initNetworkChangeReceiver(applicationContext);
        mInited = true;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.kwai.video.cache.AwesomeCacheInitConfig$2] */
    public static void initAsync(final Context context) {
        new Thread() { // from class: com.kwai.video.cache.AwesomeCacheInitConfig.2
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                AwesomeCacheInitConfig.init(context);
            }
        }.start();
    }

    public static void setReady() {
        sSoLibReadyBarrirer.setReady();
    }

    public static void waitSoLibReady() {
        sSoLibReadyBarrirer.waitReady();
    }
}
