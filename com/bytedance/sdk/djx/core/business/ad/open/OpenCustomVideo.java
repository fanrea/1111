package com.bytedance.sdk.djx.core.business.ad.open;

import com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenCustomVideo extends DJXBaseAdCustomVideo {
    private final TTFeedAd.CustomizeVideo mVideo;

    public OpenCustomVideo(TTFeedAd.CustomizeVideo customizeVideo) {
        this.mVideo = customizeVideo;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public String getVideoUrl() {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            return customizeVideo.getVideoUrl();
        }
        return super.getVideoUrl();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoPause(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoContinue(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoBreak(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoStartError(int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i, i2);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAdCustomVideo, com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoError(long j, int i, int i2) {
        TTFeedAd.CustomizeVideo customizeVideo = this.mVideo;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i, i2);
        }
    }
}
