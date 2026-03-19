package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class BEDetailVideoLoad extends BusEvent {
    private boolean isRetry;
    private int position;

    public BEDetailVideoLoad(int i, boolean z) {
        this.position = i;
        this.isRetry = z;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public boolean isRetry() {
        return this.isRetry;
    }

    public void setRetry(boolean z) {
        this.isRetry = z;
    }
}
