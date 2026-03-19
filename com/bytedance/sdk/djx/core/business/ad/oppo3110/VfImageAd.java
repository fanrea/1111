package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTImage;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAdImage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfImageAd extends DJXBaseAdImage {
    private final TTImage mTTImage;

    public VfImageAd(TTImage tTImage) {
        this.mTTImage = tTImage;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdImage, com.bytedance.sdk.djx.core.business.ad.IDJXAd.Image
    public int getWidth() {
        TTImage tTImage = this.mTTImage;
        if (tTImage != null) {
            return tTImage.getWidth();
        }
        return super.getWidth();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdImage, com.bytedance.sdk.djx.core.business.ad.IDJXAd.Image
    public int getHeight() {
        TTImage tTImage = this.mTTImage;
        if (tTImage != null) {
            return tTImage.getHeight();
        }
        return super.getHeight();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdImage, com.bytedance.sdk.djx.core.business.ad.IDJXAd.Image
    public String getUrl() {
        TTImage tTImage = this.mTTImage;
        if (tTImage != null) {
            return tTImage.getImageUrl();
        }
        return super.getUrl();
    }
}
