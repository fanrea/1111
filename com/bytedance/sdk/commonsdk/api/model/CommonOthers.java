package com.bytedance.sdk.commonsdk.api.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonOthers {
    public boolean hasMore;
    public Map<Object, Object> others = new HashMap();
    public String requestId;
    public int total;

    public CommonOthers setTotal(int i) {
        this.total = i;
        return this;
    }

    public CommonOthers setHasMore(boolean z) {
        this.hasMore = z;
        return this;
    }

    public CommonOthers setRequestId(String str) {
        this.requestId = str;
        return this;
    }

    public CommonOthers addOther(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            this.others.put(obj, obj2);
        }
        return this;
    }
}
