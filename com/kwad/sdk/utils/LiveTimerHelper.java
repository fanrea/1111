package com.kwad.sdk.utils;

import android.os.SystemClock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveTimerHelper {
    private boolean mIsStarting;
    private long mLastStartTime;
    private long mTimeLength;

    public LiveTimerHelper() {
        reset();
    }

    public void startTiming() {
        reset();
        this.mIsStarting = true;
        this.mLastStartTime = SystemClock.elapsedRealtime();
    }

    private void reset() {
        this.mTimeLength = 0L;
        this.mLastStartTime = -1L;
    }

    public void resumeTiming() {
        if (this.mIsStarting && this.mLastStartTime < 0) {
            this.mLastStartTime = SystemClock.elapsedRealtime();
        }
    }

    public void pauseTiming() {
        if (this.mIsStarting && this.mLastStartTime > 0) {
            this.mTimeLength += SystemClock.elapsedRealtime() - this.mLastStartTime;
            this.mLastStartTime = -1L;
        }
    }

    public long stopTiming() {
        if (!this.mIsStarting) {
            return 0L;
        }
        this.mIsStarting = false;
        if (this.mLastStartTime > 0) {
            this.mTimeLength += SystemClock.elapsedRealtime() - this.mLastStartTime;
            this.mLastStartTime = -1L;
        }
        return this.mTimeLength;
    }

    public boolean isStarting() {
        return this.mIsStarting;
    }

    public long getTime() {
        if (this.mLastStartTime > 0) {
            return (this.mTimeLength + SystemClock.elapsedRealtime()) - this.mLastStartTime;
        }
        return this.mTimeLength;
    }
}
