package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.HttpDns.DnsResolverAegonImpl;
import com.kwai.video.ksvodplayerkit.HttpDns.HttpDns;
import com.kwai.video.player.KsMediaPlayerInitConfig;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSVodPlayerCoreInitConfig {
    private static final String TAG = "KSVodPlayerCoreInitConfig";

    public static void setSoLoader(VodSoLoader vodSoLoader) {
        KSVodPlayerCommonInitConfig.setSoLoader(vodSoLoader);
    }

    public static void init(Context context) {
        init(context, KSVodPlayerCommonInitConfig.getCachePath(context));
    }

    public static void init(Context context, String str) throws PackageManager.NameNotFoundException {
        init(context, str, true, null);
    }

    public static void init(Context context, String str, boolean z, String str2) throws PackageManager.NameNotFoundException {
        KsMediaPlayerInitConfig.setReady();
        KSVodPlayerCommonInitConfig.init(context, str, str2);
        if (z && TextUtils.isEmpty(str2)) {
            KSVodPlayerCommonInitConfig.initAegon(context, "{\"enable_quic\":true,\"quic_hints\":[[\"g-br-cdn.kwai.net\",80,443],[\"tx-br-cdn.kwai.net\",80,443],[\"g-ind-cdn.kwai.net\",80,443],[\"tx-ind-cdn.kwai.net\",80,443]],\"quic_idle_timeout_sec\":30,\"preconnect_urls\":[\"http:\\/\\/g-api.kwai.com\"],\"preconnect_num_streams\":3,\"preconnect_non_altsvc\":true,\"altsvc_broken_time_base\":300,\"altsvc_broken_time_max\":86400}");
        }
        HttpDns.get().updateConfig(DnsResolverAegonImpl.DEFAULT_HTTP_DNS_JSON);
    }

    public static void updatePlayerConfig(String str) {
        KSVodPlayerConfig.get().setConfigJsonStr(str);
    }

    public static void enableLog(boolean z) {
        KSVodPlayerCommonInitConfig.enableLog(z);
    }

    public static boolean enableLog() {
        return KSVodPlayerCommonInitConfig.enableLog();
    }

    public static void clearCache() {
        KSVodPlayerCommonInitConfig.clearCache();
    }
}
