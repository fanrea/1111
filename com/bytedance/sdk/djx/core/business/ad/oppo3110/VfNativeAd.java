package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTNtObject;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class VfNativeAd extends DJXBaseAd {
    private final TTNtObject mNativeAd;

    VfNativeAd(TTNtObject tTNtObject) {
        this.mNativeAd = tTNtObject;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OppoVfUtils.getAdRequestId(this.mNativeAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoVfUtils.getMediaExtraInfo(this.mNativeAd);
    }
}
