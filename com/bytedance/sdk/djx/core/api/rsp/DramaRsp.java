package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaRsp extends BaseDjxRsp<List<Drama>> {
    private boolean hasMore;
    public long parseDuration = 0;
    private int total;

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }
}
