package com.kwai.video.ksvodplayerkit.prefetcher;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSPrefetcherConfig {
    static int VOD_MAX_CACHE_PREFETCH_INFO_SIZE = 200;
    static int VOD_MAX_RUNNING_TASK_SIZE = 16;
    public int maxConcurrentCount = 1;
    public long playerLoadThreshold = 614400;
    public int speedKbpsThreshold = -1;
    public long preloadBytesWifi = 1048576;
    public long secondPreloadBytesWifi = 0;
    public long preloadBytes4G = 819200;
    public long secondPreloadBytes4G = 0;
    public int preloadMsWifi = 3000;
    public int secondPreloadMsWifi = 0;
    public int preloadMs4G = 3000;
    public int secondPreloadMs4G = 0;
    public double vodBufferLowRatio = 0.5d;
    public int vodPausePreloadMaxCount = 3;
    public int maxSpeedKbps = -1;
    public int vodCacheKbThresholdKb = 200;
    public int taskLimit = VOD_MAX_CACHE_PREFETCH_INFO_SIZE;
    public int queueLimit = VOD_MAX_RUNNING_TASK_SIZE;

    public int getTaskLimit() {
        if (this.taskLimit <= 0) {
            this.taskLimit = VOD_MAX_CACHE_PREFETCH_INFO_SIZE;
        }
        return this.taskLimit;
    }

    public int getQueueLimit() {
        if (this.queueLimit <= 0) {
            this.queueLimit = VOD_MAX_RUNNING_TASK_SIZE;
        }
        return this.queueLimit;
    }
}
