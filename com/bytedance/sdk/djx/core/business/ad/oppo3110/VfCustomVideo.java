package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTVfObject;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfCustomVideo extends DJXBaseAdCustomVideo {
    private final TTVfObject.CustomizeVideo mVideo;

    public VfCustomVideo(TTVfObject.CustomizeVideo customizeVideo) {
        this.mVideo = customizeVideo;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public String getVideoUrl() {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            return customizeVideo.getVideoUrl();
        }
        return super.getVideoUrl();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoStart() {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoPause(long j) {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoContinue(long j) {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoFinish() {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoBreak(long j) {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoAutoStart() {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoStartError(int i, int i2) {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i, i2);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoError(long j, int i, int i2) {
        TTVfObject.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i, i2);
        }
    }
}
