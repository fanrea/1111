package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.model.DJXCombo;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ComboRsp extends BaseDjxRsp<List<DJXCombo>> {
    private boolean mHasMore = true;
    private int mTotal;

    public int getTotal() {
        return this.mTotal;
    }

    public void setTotal(int i) {
        this.mTotal = i;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
