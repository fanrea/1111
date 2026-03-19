package com.kwai.video.ksliveplayer.switcher;

import android.content.Context;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface DnsResolver {
    void evictIp(String str);

    void initialize(Context context);

    void onBackground();

    void onForeground();

    void onHostsFromFeed(List<String> list);

    List<ResolvedIP> resolveHost(String str);

    void updateConfig(String str);
}
