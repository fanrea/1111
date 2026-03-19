package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BESeekStart extends BusEvent {
    private boolean mIsStart;

    public boolean isStart() {
        return this.mIsStart;
    }

    public BESeekStart setStart(boolean z) {
        this.mIsStart = z;
        return this;
    }
}
