package com.kwai.video.ksvodplayerkit.HttpDns;

import android.content.Context;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface DnsResolver {
    void evictIp(String str);

    void initialize(Context context);

    void onBackground();

    void onForeground();

    void onHostsFromFeed(List<String> list);

    List<ResolvedIP> resolveHost(String str);

    void updateConfig(String str);
}
