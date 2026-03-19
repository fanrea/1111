package com.kwai.video.ksvodplayerkit.MultiRate;

import com.kwai.video.ksvodplayerkit.HttpDns.DnsResolvedUrl;
import com.kwai.video.ksvodplayerkit.HttpDns.Switcher;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HlsRepresentation {
    public int averageBandwidth;
    public List<String> backupUrl;
    public String baseUrl;
    public String cacheKey;
    public String codecs;
    public double duration;
    public double frameRate;
    public int height;
    public transient String host;
    public String m3u8;
    public String m3u8Slice;
    public String url;
    public transient Switcher<DnsResolvedUrl> urlSwitcher;
    public int width;
}
