package com.sigmob.windad.natives;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindNativeAdRequest extends WindAdRequest {
    @Deprecated
    public WindNativeAdRequest(String placementId, String userId, int adCount, Map<String, Object> options) {
        super(placementId, userId, options, 5);
        this.a = adCount;
    }

    public WindNativeAdRequest(String placementId, String userId, Map<String, Object> options) {
        super(placementId, userId, options, 5);
    }

    public static WindNativeAdRequest getWindVideoAdRequest(WindAdRequest adRequest) {
        if (adRequest == null) {
            return null;
        }
        return new WindNativeAdRequest(adRequest.getPlacementId(), adRequest.getUserId(), 1, adRequest.getOptions());
    }
}
