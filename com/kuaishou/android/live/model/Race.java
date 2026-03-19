package com.kuaishou.android.live.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Race implements Serializable {
    public long mCost;
    public long mStartTime;
    public boolean mSuccess;
    public List<Round> mRounds = new ArrayList();
    public String mTag = "";

    public void clearState() {
        this.mStartTime = 0L;
        this.mCost = 0L;
        this.mSuccess = false;
        Iterator<Round> it = this.mRounds.iterator();
        while (it.hasNext()) {
            it.next().clearState();
        }
    }
}
