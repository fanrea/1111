package com.sigmob.sdk.base;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class p extends WindAdRequest {
    public p(String placementId, String userId, Map<String, Object> options) {
        super(placementId, userId, options, 1);
    }

    @Deprecated
    public p(String placementId, String userId, boolean needReward, Map<String, Object> options) {
        super(placementId, userId, options, needReward ? 1 : 4);
    }
}
