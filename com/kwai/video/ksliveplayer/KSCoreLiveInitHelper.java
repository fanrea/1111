package com.kwai.video.ksliveplayer;

import android.app.Application;
import android.text.TextUtils;
import com.kuaishou.aegon.Aegon;
import com.kwai.kanas.Kanas;
import com.kwai.kanas.interfaces.KanasConfig;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.function.Supplier;
import com.kwai.middleware.azeroth.utils.DeviceIDUtil;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.cache.AwesomeCacheSoLoader;
import com.kwai.video.ksliveplayer.switcher.DnsResolverAegonImpl;
import com.kwai.video.ksliveplayer.switcher.HttpDns;
import com.kwai.video.player.KsMediaPlayerInitConfig;
import com.kwai.video.player.KsSoLoader;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSCoreLiveInitHelper {
    private static boolean sCanGetAndroidId;
    private static volatile KSLiveSoLoader sInjectedSoLoader;

    public static void setSoLoader(KSLiveSoLoader kSLiveSoLoader) {
        sInjectedSoLoader = kSLiveSoLoader;
    }

    public static void setCanGetAndroidId(boolean z) {
        sCanGetAndroidId = z;
    }

    public static void initAll(Application application, KSCoreLiveParams kSCoreLiveParams) {
        AwesomeCacheInitConfig.setSoLoader(new AwesomeCacheSoLoader() { // from class: com.kwai.video.ksliveplayer.KSCoreLiveInitHelper.1
            @Override // com.kwai.video.cache.AwesomeCacheSoLoader
            public final void loadLibrary(String str) {
                if (KSCoreLiveInitHelper.sInjectedSoLoader != null) {
                    KSCoreLiveInitHelper.sInjectedSoLoader.loadLibrary(str);
                } else {
                    System.loadLibrary(str);
                }
            }
        });
        if (application.getExternalCacheDir() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(application.getExternalCacheDir().getAbsolutePath());
            sb.append(File.separator);
            sb.append("ACache");
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(application.getDir("liveCache", 0));
            sb2.append(File.separator);
            sb2.append("ACache");
        }
        AwesomeCacheInitConfig.init(application);
        KsMediaPlayerInitConfig.setSoLoader(new KsSoLoader() { // from class: com.kwai.video.ksliveplayer.KSCoreLiveInitHelper.2
            @Override // com.kwai.video.player.KsSoLoader
            public final void loadLibrary(String str) {
                if (KSCoreLiveInitHelper.sInjectedSoLoader != null) {
                    KSCoreLiveInitHelper.sInjectedSoLoader.loadLibrary(str);
                } else {
                    System.loadLibrary(str);
                }
            }
        });
        KsMediaPlayerInitConfig.init(application);
        Aegon.initialize(application, "{\"enable_quic\":true,\"quic_hints\":[[\"g-br-cdn.kwai.net\",80,443],[\"tx-br-cdn.kwai.net\",80,443],[\"g-ind-cdn.kwai.net\",80,443],[\"tx-ind-cdn.kwai.net\",80,443]],\"quic_idle_timeout_sec\":30,\"preconnect_urls\":[\"http:\\/\\/g-api.kwai.com\"],\"preconnect_num_streams\":3,\"preconnect_non_altsvc\":true,\"altsvc_broken_time_base\":300,\"altsvc_broken_time_max\":86400}", application.getFilesDir().getAbsolutePath(), new Aegon.LibraryLoader() { // from class: com.kwai.video.ksliveplayer.KSCoreLiveInitHelper.3
            @Override // com.kuaishou.aegon.Aegon.LibraryLoader
            public final void loadLibrary(String str) {
                if (KSCoreLiveInitHelper.sInjectedSoLoader != null) {
                    KSCoreLiveInitHelper.sInjectedSoLoader.loadLibrary(str);
                } else {
                    System.loadLibrary(str);
                }
            }
        });
        Aegon.getCronetEngine();
        Aegon.setDebug(false);
        HttpDns.get().updateConfig(DnsResolverAegonImpl.DEFAULT_HTTP_DNS_JSON);
        HttpDns.get().init(application);
        String deviceId = kSCoreLiveParams.deviceId;
        DeviceIDUtil.setCanGetAndroidId(sCanGetAndroidId);
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = DeviceIDUtil.getDeviceId(application);
        }
        Azeroth.get().init(new AzerothInitParams(application, kSCoreLiveParams.appId, deviceId, kSCoreLiveParams.kpn));
        Kanas.get().startWithConfig(KanasConfig.builder().oaid(new Supplier<String>() { // from class: com.kwai.video.ksliveplayer.KSCoreLiveInitHelper.4
            @Override // com.kwai.middleware.azeroth.function.Supplier
            public final String get() {
                return "";
            }
        }).deviceId(deviceId).build());
    }
}
