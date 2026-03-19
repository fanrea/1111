package com.yxcorp.livestream.longconnection;

import com.yxcorp.livestream.longconnection.LongConnectionParams;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ConnectionSumStatistics {
    private LongConnectionParams.ServerUriInfo mCurrentServerUriInfo;
    public final List<String> mFailedHostPorts = new ArrayList();
    private long mFirstFeedReceivedTime;
    private int mLastErrorCode;
    private int mRetryCount;
    private long mStartTime;

    public ConnectionSumStatistics onStartConnect() {
        this.mStartTime = System.currentTimeMillis();
        return this;
    }

    public ConnectionSumStatistics onFirstFeedReceived() {
        this.mFirstFeedReceivedTime = System.currentTimeMillis();
        return this;
    }

    public long getFirstFeedCostInLastConnection() {
        return Math.max(this.mFirstFeedReceivedTime - this.mStartTime, 0L);
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public LongConnectionParams.ServerUriInfo getCurrentServerUriInfo() {
        return this.mCurrentServerUriInfo;
    }

    public void setCurrentServerUriInfo(LongConnectionParams.ServerUriInfo serverUriInfo) {
        this.mCurrentServerUriInfo = serverUriInfo;
    }

    public void addRetryCount() {
        this.mRetryCount++;
    }

    public void addFailedHostPort(String str) {
        if (this.mFailedHostPorts.contains(str)) {
            return;
        }
        this.mFailedHostPorts.add(str);
    }

    public int getLastErrorCode() {
        return this.mLastErrorCode;
    }

    public void setLastErrorCode(int i) {
        this.mLastErrorCode = i;
    }
}
