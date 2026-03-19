package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BEInflate extends BusEvent {
    private Feed inflated;

    public BEInflate() {
    }

    public BEInflate(Feed feed) {
        this.inflated = feed;
    }

    public void setInflated(Feed feed) {
        this.inflated = feed;
    }

    public Feed getInflated() {
        return this.inflated;
    }
}
