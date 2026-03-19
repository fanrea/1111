package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BESettingUpdate extends BusEvent {
    private boolean mIsOnline;

    public static BESettingUpdate build(boolean z) {
        return new BESettingUpdate(z);
    }

    private BESettingUpdate(boolean z) {
        this.mIsOnline = z;
    }

    public boolean isOnline() {
        return this.mIsOnline;
    }
}
