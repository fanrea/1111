package com.bytedance.sdk.djx.core.business.ad.oppo;

import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.ttshell.sdk.api.TTNativeOb;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ObNativeAd extends DJXBaseAd {
    private final TTNativeOb mNativeAd;

    ObNativeAd(TTNativeOb tTNativeOb) {
        this.mNativeAd = tTNativeOb;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OppoObUtils.getAdRequestId(this.mNativeAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoObUtils.getMediaExtraInfo(this.mNativeAd);
    }
}
