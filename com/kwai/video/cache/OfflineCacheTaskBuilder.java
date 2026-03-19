package com.kwai.video.cache;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class OfflineCacheTaskBuilder extends OfflineCacheTaskBuilderBase {
    public OfflineCacheTaskBuilder(String str, String str2, String str3, AwesomeCacheCallback awesomeCacheCallback) {
        this.mDataSpec.url = str;
        this.mDataSpec.host = str3;
        this.mDataSpec.key = str2;
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public OfflineCacheVodTask build() {
        return AwesomeCache.newOfflineCacheVodFileTask(this.mDataSpec, this.mAwesomeCacheCallback);
    }
}
