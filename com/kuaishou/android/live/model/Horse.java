package com.kuaishou.android.live.model;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Horse implements Serializable {
    public boolean mChosen;
    public long mCost;
    public String mHostAndPort;
    public long mStartTime;
    public boolean mSuccess;
    public String mTag = "";
    public String mErrorDescription = "";

    public com.kuaishou.protobuf.livestream.nano.Horse toProto() {
        com.kuaishou.protobuf.livestream.nano.Horse horse = new com.kuaishou.protobuf.livestream.nano.Horse();
        horse.tag = this.mTag;
        horse.hostAndPort = this.mHostAndPort;
        horse.success = this.mSuccess;
        horse.chosen = this.mChosen;
        horse.cost = this.mCost;
        horse.startTime = this.mStartTime;
        horse.errorDescription = this.mErrorDescription;
        return horse;
    }

    public void clearState() {
        this.mSuccess = false;
        this.mChosen = false;
        this.mStartTime = 0L;
        this.mCost = 0L;
        this.mErrorDescription = "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Horse{");
        sb.append("mHostAndPort='");
        sb.append(this.mHostAndPort);
        sb.append('\'');
        sb.append(", mTag='");
        sb.append(this.mTag);
        sb.append('\'');
        sb.append(", mSuccess=");
        sb.append(this.mSuccess);
        sb.append(", mChosen=");
        sb.append(this.mChosen);
        sb.append(", mStartTime=");
        sb.append(this.mStartTime);
        sb.append(", mCost=");
        sb.append(this.mCost);
        sb.append(", mErrorDescription='");
        sb.append(this.mErrorDescription);
        sb.append('\'');
        sb.append('}');
        return sb.substring(0);
    }
}
