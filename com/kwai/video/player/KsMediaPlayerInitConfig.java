package com.kwai.video.player;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.getkeepsafe.relinker.ReLinker;
import com.kwad.sdk.AdLiveOfflineCompoImpl;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.util.OnceReadyBarrier;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsMediaPlayerInitConfig {
    public static String packageName;
    public static String packageVersion;
    private static volatile KsSoLoader sInjectedSoLoader;
    private static AtomicBoolean sSoLibInited = new AtomicBoolean(false);
    private static OnceReadyBarrier sSoLibReadyBarrirer = new OnceReadyBarrier();

    public static void setSoLoader(KsSoLoader ksSoLoader) {
        sInjectedSoLoader = ksSoLoader;
    }

    public static boolean isSoLibInited() {
        return sSoLibInited.get();
    }

    public static void init(Context context) throws PackageManager.NameNotFoundException {
        final Context applicationContext = context.getApplicationContext();
        final KsSoLoader ksSoLoader = sInjectedSoLoader;
        KsSoLoader ksSoLoader2 = new KsSoLoader() { // from class: com.kwai.video.player.KsMediaPlayerInitConfig.1
            @Override // com.kwai.video.player.KsSoLoader
            public final void loadLibrary(String str) {
                KsSoLoader ksSoLoader3 = ksSoLoader;
                if (ksSoLoader3 != null) {
                    ksSoLoader3.loadLibrary(str);
                } else if (applicationContext != null) {
                    ReLinker.recursively().loadLibrary(applicationContext, str);
                } else {
                    System.loadLibrary(str);
                }
            }
        };
        ksSoLoader2.loadLibrary("c++_shared");
        ksSoLoader2.loadLibrary(AdLiveOfflineCompoImpl.SO_KWAI_PLAYER);
        sSoLibInited.set(true);
        sSoLibReadyBarrirer.setReady();
        Timber.v("[KsMediaPlayerInitConfig.init] to KwaiMediaPlayer.native_init", new Object[0]);
        KwaiMediaPlayer.native_init();
        Timber.v("[KsMediaPlayerInitConfig.init] to initPackageName", new Object[0]);
        initPackageName(context);
        Timber.v("[KsMediaPlayerInitConfig.init] all finish", new Object[0]);
    }

    private static void initPackageName(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                packageName = packageInfo.packageName;
                packageVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.kwai.video.player.KsMediaPlayerInitConfig$4] */
    public static void initAsync(final Context context) {
        new Thread() { // from class: com.kwai.video.player.KsMediaPlayerInitConfig.4
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                KsMediaPlayerInitConfig.init(context);
            }
        }.start();
    }

    public static void setReady() {
        sSoLibReadyBarrirer.setReady();
    }

    public static void waitSoLibReady() {
        AwesomeCacheInitConfig.waitSoLibReady();
        sSoLibReadyBarrirer.waitReady();
    }

    public static int getPlayerAliveCnt() {
        if (isSoLibInited()) {
            return KwaiMediaPlayer._getPlayerAliveCnt();
        }
        return -1;
    }
}
