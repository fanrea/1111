package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BEDramaCard extends BusEvent {
    private boolean isMute;

    private BEDramaCard() {
    }

    public static BEDramaCard obtain() {
        return new BEDramaCard();
    }

    public boolean isMute() {
        return this.isMute;
    }

    public BEDramaCard setMute(boolean z) {
        this.isMute = z;
        return this;
    }
}
