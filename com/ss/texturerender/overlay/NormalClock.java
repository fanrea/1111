package com.ss.texturerender.overlay;

import android.os.SystemClock;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NormalClock {
    private static final String TAG = "NormalClock";
    private int mTexType;
    private long mPts = 0;
    private long mUpdateTime = 0;
    private int mStatus = 3;
    private boolean mIsUpdated = false;

    public NormalClock(int i) {
        this.mTexType = i;
    }

    public synchronized void start() {
        this.mStatus = 1;
    }

    public synchronized void pause() {
        this.mStatus = 2;
        this.mUpdateTime = 0L;
    }

    public synchronized void stop() {
        this.mStatus = 3;
        this.mUpdateTime = 0L;
        this.mIsUpdated = false;
        this.mPts = 0L;
    }

    public synchronized void updateClock(long j) {
        TextureRenderLog.d(this.mTexType, TAG, "updateClock masetr:" + j + " mIsUpdated:" + this.mIsUpdated + " mStatus:" + this.mStatus);
        if (!this.mIsUpdated) {
            this.mIsUpdated = true;
            this.mStatus = 1;
        }
        if (this.mStatus == 1) {
            this.mPts = j;
            this.mUpdateTime = SystemClock.elapsedRealtime();
        }
    }

    public synchronized long getClock() {
        long j;
        long jElapsedRealtime;
        j = this.mPts;
        jElapsedRealtime = 0;
        if (this.mUpdateTime > 0 && this.mStatus == 1) {
            jElapsedRealtime = SystemClock.elapsedRealtime() - this.mUpdateTime;
        }
        return j + jElapsedRealtime;
    }
}
