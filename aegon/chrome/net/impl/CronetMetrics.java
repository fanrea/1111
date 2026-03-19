package aegon.chrome.net.impl;

import aegon.chrome.net.RequestFinishedInfo;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class CronetMetrics extends RequestFinishedInfo.Metrics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long mConnectEndMs;
    private final long mConnectStartMs;
    private final long mDnsEndMs;
    private final long mDnsStartMs;
    private final long mPushEndMs;
    private final long mPushStartMs;
    private final Long mReceivedByteCount;
    private final long mRequestEndMs;
    private final long mRequestStartMs;
    private final long mResponseStartMs;
    private final long mSendingEndMs;
    private final long mSendingStartMs;
    private final Long mSentByteCount;
    private final boolean mSocketReused;
    private final long mSslEndMs;
    private final long mSslStartMs;
    private final Long mTotalTimeMs;
    private final Long mTtfbMs;

    private static boolean checkOrder(long j, long j2) {
        return (j2 >= j && j != -1) || j2 == -1;
    }

    private static Date toDate(long j) {
        if (j != -1) {
            return new Date(j);
        }
        return null;
    }

    public CronetMetrics(Long l, Long l2, Long l3, Long l4) {
        this.mTtfbMs = l;
        this.mTotalTimeMs = l2;
        this.mSentByteCount = l3;
        this.mReceivedByteCount = l4;
        this.mRequestStartMs = -1L;
        this.mDnsStartMs = -1L;
        this.mDnsEndMs = -1L;
        this.mConnectStartMs = -1L;
        this.mConnectEndMs = -1L;
        this.mSslStartMs = -1L;
        this.mSslEndMs = -1L;
        this.mSendingStartMs = -1L;
        this.mSendingEndMs = -1L;
        this.mPushStartMs = -1L;
        this.mPushEndMs = -1L;
        this.mResponseStartMs = -1L;
        this.mRequestEndMs = -1L;
        this.mSocketReused = false;
    }

    public CronetMetrics(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        this.mRequestStartMs = j;
        this.mDnsStartMs = j2;
        this.mDnsEndMs = j3;
        this.mConnectStartMs = j4;
        this.mConnectEndMs = j5;
        this.mSslStartMs = j6;
        this.mSslEndMs = j7;
        this.mSendingStartMs = j8;
        this.mSendingEndMs = j9;
        this.mPushStartMs = j10;
        this.mPushEndMs = j11;
        this.mResponseStartMs = j12;
        this.mRequestEndMs = j13;
        this.mSocketReused = z;
        this.mSentByteCount = Long.valueOf(j14);
        this.mReceivedByteCount = Long.valueOf(j15);
        if (j != -1 && j12 != -1) {
            this.mTtfbMs = Long.valueOf(j12 - j);
        } else {
            this.mTtfbMs = null;
        }
        if (j != -1 && j13 != -1) {
            this.mTotalTimeMs = Long.valueOf(j13 - j);
        } else {
            this.mTotalTimeMs = null;
        }
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getRequestStart() {
        return toDate(this.mRequestStartMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getDnsStart() {
        return toDate(this.mDnsStartMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getDnsEnd() {
        return toDate(this.mDnsEndMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getConnectStart() {
        return toDate(this.mConnectStartMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getConnectEnd() {
        return toDate(this.mConnectEndMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getSslStart() {
        return toDate(this.mSslStartMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getSslEnd() {
        return toDate(this.mSslEndMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getSendingStart() {
        return toDate(this.mSendingStartMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getSendingEnd() {
        return toDate(this.mSendingEndMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getPushStart() {
        return toDate(this.mPushStartMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getPushEnd() {
        return toDate(this.mPushEndMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getResponseStart() {
        return toDate(this.mResponseStartMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Date getRequestEnd() {
        return toDate(this.mRequestEndMs);
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final boolean getSocketReused() {
        return this.mSocketReused;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Long getTtfbMs() {
        return this.mTtfbMs;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Long getTotalTimeMs() {
        return this.mTotalTimeMs;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Long getSentByteCount() {
        return this.mSentByteCount;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Metrics
    public final Long getReceivedByteCount() {
        return this.mReceivedByteCount;
    }
}
