package com.kwai.video.ksvodplayerkit.prefetcher;

import com.kwai.video.hodor.AbstractHodorPreloadTask;
import com.kwai.video.ksvodplayerkit.HttpDns.HostSwitcher;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BasePrefetchModel {
    static final int VOD_PRELOAD_TYPE_FEED = 1;
    static final int VOD_PRELOAD_TYPE_SLIDE = 0;
    protected String mCacheKey;
    protected KSPrefetcherConfig mConfig;
    protected HostSwitcher mHostSwitcher;
    protected boolean mIsSecondPreload;
    protected String mPrefetchUrl;
    protected int mPreloadType;
    protected int mPriority;
    protected AtomicInteger mRetryCount = new AtomicInteger();
    protected AbstractHodorPreloadTask mTask;
    protected String mVideoId;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    @interface VodPreloadType {
    }

    abstract String getDataSource();

    abstract AbstractHodorPreloadTask getTask();

    abstract AbstractHodorPreloadTask switchNextAndGetTask();

    protected int getPriority() {
        return this.mPriority;
    }

    protected void setPriority(int i) {
        this.mPriority = i;
    }

    protected AtomicInteger getRetryCount() {
        return this.mRetryCount;
    }

    protected String getVideoId() {
        return this.mVideoId;
    }

    protected String getCacheKey() {
        return this.mCacheKey;
    }
}
