package com.bytedance.sdk.djx.core.business.ad.open;

import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenBannerAd extends OpenExpressInteractionAd {

    public static class DislikeCallbackAdapter implements IDJXAd.DislikeInteractionCallback {
        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
        public void onRefuse() {
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
        public void onSelected(int i, String str) {
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.DislikeInteractionCallback
        public void onShow() {
        }
    }

    public OpenBannerAd(TTNativeExpressAd tTNativeExpressAd, long j) {
        super(tTNativeExpressAd, j);
    }

    public TTNativeExpressAd getNativeExpressAd() {
        return this.mNativeExpressAd;
    }
}
