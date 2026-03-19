package com.kwai.video.ksvodplayerkit;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CacheReceipt {
    public long mBytesReadFromSource;
    public String mCdnStatJson;
    public String mDownloadUUID;
    public int mErrorCode;
    public int mFragmentIndex;
    public String mHost;
    public int mHttpResponseCode;
    public long mInitAvailableBytesOfCache;
    public String mIp;
    private long mPreloadThresholdBytes = KSVodPlayerConfig.get().getPreloadThreshold();
    public long mReadSourceFinishTimeMills;
    public long mReadSourceStartTimeMills;
    public long mReadSourceTimeCostMills;
    public String mSessionUUID;
    public String mSignature;
    public int mStopReason;
    public long mTotalBytesOfResponse;
    public long mTotalBytesOfSource;
    public String mUrl;
    public String mXKsHttpHeader;

    public boolean reachPreloadThreshold() {
        long j = this.mBytesReadFromSource;
        if (j <= 0) {
            return false;
        }
        long j2 = this.mTotalBytesOfSource;
        if (j2 > 0) {
            return j >= j2 || j >= this.mPreloadThresholdBytes;
        }
        return false;
    }
}
