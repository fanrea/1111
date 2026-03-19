package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.kuaishou.aegon.Aegon;
import com.kwai.video.cache.AwesomeCache;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.cache.AwesomeCacheSoLoader;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.prefetcher.KSPrefetcher;
import com.kwai.video.player.KsMediaPlayer;
import com.kwai.video.player.KsMediaPlayerInitConfig;
import com.kwai.video.player.KsSoLoader;
import com.kwai.video.player.kwai_player.KwaiMediaPlayer;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodPlayerCommonInitConfig {
    private static final String TAG = "KSVodPlayerCommonInitConfig";
    private static boolean sEnableLog = true;
    private static volatile VodSoLoader sInjectedSoLoader;

    public static void setSoLoader(VodSoLoader vodSoLoader) {
        sInjectedSoLoader = vodSoLoader;
    }

    public static void init(Context context) throws PackageManager.NameNotFoundException {
        init(context, getCachePath(context));
    }

    public static void init(Context context, String str) throws PackageManager.NameNotFoundException {
        init(context, str, null);
    }

    public static void init(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        AwesomeCacheInitConfig.setSoLoader(new AwesomeCacheSoLoader() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayerCommonInitConfig.1
            @Override // com.kwai.video.cache.AwesomeCacheSoLoader
            public final void loadLibrary(String str3) {
                if (KSVodPlayerCommonInitConfig.sInjectedSoLoader != null) {
                    KSVodPlayerCommonInitConfig.sInjectedSoLoader.loadLibrary(str3);
                } else {
                    KSVodLogger.w(KSVodPlayerCommonInitConfig.TAG, "WARNING! AwesomeCacheSoLoader is using System.loadLibrary");
                    System.loadLibrary(str3);
                }
            }
        });
        if (TextUtils.isEmpty(str)) {
            getCachePath(context);
        }
        AwesomeCacheInitConfig.init(context);
        KsMediaPlayerInitConfig.setSoLoader(new KsSoLoader() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayerCommonInitConfig.2
            @Override // com.kwai.video.player.KsSoLoader
            public final void loadLibrary(String str3) {
                if (KSVodPlayerCommonInitConfig.sInjectedSoLoader != null) {
                    KSVodPlayerCommonInitConfig.sInjectedSoLoader.loadLibrary(str3);
                } else {
                    KSVodLogger.w(KSVodPlayerCommonInitConfig.TAG, "WARNING! AwesomeCacheSoLoader is using System.loadLibrary");
                    System.loadLibrary(str3);
                }
            }
        });
        KsMediaPlayerInitConfig.init(context);
        KsMediaPlayer.native_profileBegin("libkwaiplayer.so");
        KwaiMediaPlayer.native_setLogLevel(4);
        KwaiMediaPlayer.native_setKwaiLogLevel(4);
        if (!TextUtils.isEmpty(str2)) {
            initAegon(context, str2);
        }
        KSPrefetcher.getInstance().init(context);
    }

    public static boolean isSoLoadCompleted() {
        return KsMediaPlayerInitConfig.isSoLibInited();
    }

    public static void updatePlayerConfig(String str) {
        KSVodPlayerConfig.get().setConfigJsonStr(str);
    }

    public static void clearCache() {
        AwesomeCache.clearCacheDir();
        KSVodPlayStatManager.getInstance().clearCacheStatus();
    }

    public static void initAegon(Context context, String str) {
        if (str != null) {
            Aegon.initialize(context, str, context.getFilesDir().getAbsolutePath(), new Aegon.LibraryLoader() { // from class: com.kwai.video.ksvodplayerkit.KSVodPlayerCommonInitConfig.3
                @Override // com.kuaishou.aegon.Aegon.LibraryLoader
                public final void loadLibrary(String str2) {
                    if (KSVodPlayerCommonInitConfig.sInjectedSoLoader != null) {
                        KSVodPlayerCommonInitConfig.sInjectedSoLoader.loadLibrary(str2);
                    } else {
                        KSVodLogger.w(KSVodPlayerCommonInitConfig.TAG, "WARNING! Aegon is using System.loadLibrary");
                        System.loadLibrary(str2);
                    }
                }
            });
            Aegon.getCronetEngine();
            Aegon.setDebug(false);
        }
    }

    public static String getCachePath(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath() + File.separator + "ACache";
        }
        return context.getDir("vodCache", 0) + File.separator + "ACache";
    }

    public static void enableLog(boolean z) {
        sEnableLog = z;
        if (z) {
            KwaiMediaPlayer.native_setLogLevel(4);
            KwaiMediaPlayer.native_setKwaiLogLevel(4);
        } else {
            KwaiMediaPlayer.native_setLogLevel(8);
            KwaiMediaPlayer.native_setKwaiLogLevel(8);
        }
    }

    public static boolean enableLog() {
        return sEnableLog;
    }
}
