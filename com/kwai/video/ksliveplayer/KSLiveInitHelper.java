package com.kwai.video.ksliveplayer;

import android.content.Context;
import android.content.pm.PackageManager;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.cache.AwesomeCacheSoLoader;
import com.kwai.video.ksliveplayer.midd.KSMiddHttpDnsResolver;
import com.kwai.video.ksliveplayer.switcher.HttpDns;
import com.kwai.video.player.KsMediaPlayerInitConfig;
import com.kwai.video.player.KsSoLoader;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveInitHelper {
    private static volatile KSLiveSoLoader sSoLoader;
    private static KsSoLoader sKsSoLoader = new KsSoLoader() { // from class: com.kwai.video.ksliveplayer.KSLiveInitHelper.1
        @Override // com.kwai.video.player.KsSoLoader
        public final void loadLibrary(String str) {
            if (KSLiveInitHelper.sSoLoader != null) {
                KSLiveInitHelper.sSoLoader.loadLibrary(str);
            } else {
                System.loadLibrary(str);
            }
        }
    };
    private static AwesomeCacheSoLoader sAwesomeSoLoader = new AwesomeCacheSoLoader() { // from class: com.kwai.video.ksliveplayer.KSLiveInitHelper.2
        @Override // com.kwai.video.cache.AwesomeCacheSoLoader
        public final void loadLibrary(String str) {
            if (KSLiveInitHelper.sSoLoader != null) {
                KSLiveInitHelper.sSoLoader.loadLibrary(str);
            } else {
                System.loadLibrary(str);
            }
        }
    };

    public static void setSoLoader(KSLiveSoLoader kSLiveSoLoader) {
        sSoLoader = kSLiveSoLoader;
    }

    public static void initAll(Context context, KSLiveSoLoader kSLiveSoLoader) throws PackageManager.NameNotFoundException {
        sSoLoader = kSLiveSoLoader;
        initAll(context);
    }

    public static void initAll(Context context) throws PackageManager.NameNotFoundException {
        KsMediaPlayerInitConfig.setSoLoader(sKsSoLoader);
        AwesomeCacheInitConfig.setSoLoader(sAwesomeSoLoader);
        if (context.getExternalCacheDir() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getExternalCacheDir().getAbsolutePath());
            sb.append(File.separator);
            sb.append("ACache");
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getDir("liveCache", 0));
            sb2.append(File.separator);
            sb2.append("ACache");
        }
        AwesomeCacheInitConfig.init(context);
        KsMediaPlayerInitConfig.init(context);
        HttpDns.get().setImpl(new KSMiddHttpDnsResolver());
        HttpDns.get().init(context);
    }
}
