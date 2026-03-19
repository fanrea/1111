package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.model.SourceMode;
import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class BEHomeLoadFrame extends BusEvent {
    public int mPosition;
    public SourceMode mSource;

    public BEHomeLoadFrame(int i, SourceMode sourceMode) {
        this.mPosition = i;
        this.mSource = sourceMode;
    }
}
