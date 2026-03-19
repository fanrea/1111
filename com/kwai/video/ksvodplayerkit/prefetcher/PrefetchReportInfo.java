package com.kwai.video.ksvodplayerkit.prefetcher;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PrefetchReportInfo {
    public long downloadBytes;
    public boolean fillPreload;
    public long preloadBytes;
    public String preloadUrl;

    public PrefetchReportInfo() {
        this.fillPreload = false;
    }

    public PrefetchReportInfo(boolean z, String str, long j, long j2) {
        this.fillPreload = z;
        this.preloadUrl = str;
        this.preloadBytes = j;
        this.downloadBytes = j2;
    }
}
