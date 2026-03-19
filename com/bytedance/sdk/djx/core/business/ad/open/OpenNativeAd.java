package com.bytedance.sdk.djx.core.business.ad.open;

import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class OpenNativeAd extends DJXBaseAd {
    private final TTNativeAd mNativeAd;

    OpenNativeAd(TTNativeAd tTNativeAd) {
        this.mNativeAd = tTNativeAd;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OpenAdUtils.getAdRequestId(this.mNativeAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OpenAdUtils.getMediaExtraInfo(this.mNativeAd);
    }
}
