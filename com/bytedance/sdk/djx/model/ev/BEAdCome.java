package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class BEAdCome extends BusEvent {
    private static final int TYPE_REWARD = 1;
    private String mCodeId;
    private boolean mIsLoadSuccess;
    private int mType;

    public static BEAdCome build() {
        return new BEAdCome();
    }

    private BEAdCome() {
    }

    public String getCodeId() {
        return this.mCodeId;
    }

    public BEAdCome setCodeId(String str) {
        this.mCodeId = str;
        return this;
    }

    public BEAdCome setReward() {
        this.mType = 1;
        return this;
    }

    public BEAdCome setLoadSuccess(boolean z) {
        this.mIsLoadSuccess = z;
        return this;
    }

    public boolean isReward() {
        return this.mType == 1;
    }

    public boolean isLoadSuccess() {
        return this.mIsLoadSuccess;
    }
}
