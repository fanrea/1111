package com.yxcorp.livestream.longconnection;

import android.os.SystemClock;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ConnectionStatistics {
    private long mBootstrapElapsedTime;
    private long mBootstrapEndTime;
    private long mBootstrapEnterRoomAckInterval;
    private long mBootstrapFirstFeedInterval;
    private long mBootstrapStartTime;
    private long mFirstBootstrapStartTime;
    private int mReconnectCount;

    public ConnectionStatistics startBootstrap() {
        this.mBootstrapElapsedTime = 0L;
        this.mBootstrapStartTime = SystemClock.elapsedRealtime();
        if (this.mFirstBootstrapStartTime == 0) {
            this.mFirstBootstrapStartTime = SystemClock.elapsedRealtime();
        }
        return this;
    }

    public ConnectionStatistics endBootStrap() {
        if (this.mBootstrapStartTime > 0) {
            this.mBootstrapEndTime = SystemClock.elapsedRealtime();
            this.mBootstrapElapsedTime = this.mBootstrapEndTime - this.mBootstrapStartTime;
            this.mBootstrapStartTime = 0L;
        }
        return this;
    }

    public ConnectionStatistics onEnterRoomAck() {
        if (this.mBootstrapEndTime > 0) {
            this.mBootstrapEnterRoomAckInterval = SystemClock.elapsedRealtime() - this.mBootstrapEndTime;
        }
        return this;
    }

    public ConnectionStatistics onFirstFeedReceived() {
        if (this.mBootstrapEndTime > 0) {
            this.mBootstrapFirstFeedInterval = SystemClock.elapsedRealtime() - this.mBootstrapEndTime;
        }
        return this;
    }

    public long getBootstrapElapsedTime() {
        return this.mBootstrapElapsedTime;
    }

    public long getBootstrapEnterRoomAckInterval() {
        return this.mBootstrapEnterRoomAckInterval;
    }

    public long getFirstBootstrapStartTime() {
        return this.mFirstBootstrapStartTime;
    }

    public long getBootstrapFirstFeedInterval() {
        return this.mBootstrapFirstFeedInterval;
    }

    public int getReconnectCount() {
        return this.mReconnectCount;
    }

    void setReconnectCount(int i) {
        this.mReconnectCount = i;
    }
}
