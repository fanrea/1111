package com.kuaishou.android.live.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Round implements Serializable {
    public long mCost;
    public long mStartTime;
    public boolean mSuccess;
    public List<Horse> mHorses = new ArrayList();
    public long mTimeout = 500;
    public int mPolicy = 1;
    public long[] mBarriers = new long[0];
    public String mTag = "";

    public com.kuaishou.protobuf.livestream.nano.Round toProto() {
        com.kuaishou.protobuf.livestream.nano.Round round = new com.kuaishou.protobuf.livestream.nano.Round();
        round.barrier = this.mBarriers;
        round.policy = this.mPolicy;
        round.timeout = this.mTimeout;
        round.success = this.mSuccess;
        round.cost = this.mCost;
        round.startTime = this.mStartTime;
        round.tag = this.mTag;
        round.horse = new com.kuaishou.protobuf.livestream.nano.Horse[this.mHorses.size()];
        for (int i = 0; i < this.mHorses.size(); i++) {
            round.horse[i] = this.mHorses.get(i).toProto();
        }
        return round;
    }

    public void clearState() {
        this.mSuccess = false;
        this.mStartTime = 0L;
        this.mCost = 0L;
        Iterator<Horse> it = this.mHorses.iterator();
        while (it.hasNext()) {
            it.next().clearState();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Round{");
        sb.append("mHorses=");
        sb.append(this.mHorses);
        sb.append(", mTimeout=");
        sb.append(this.mTimeout);
        sb.append(", mPolicy=");
        sb.append(this.mPolicy);
        sb.append(", mBarriers=");
        sb.append(Arrays.toString(this.mBarriers));
        sb.append(", mTag='");
        sb.append(this.mTag);
        sb.append('\'');
        sb.append(", mSuccess=");
        sb.append(this.mSuccess);
        sb.append(", mStartTime=");
        sb.append(this.mStartTime);
        sb.append(", mCost=");
        sb.append(this.mCost);
        sb.append('}');
        return sb.substring(0);
    }
}
