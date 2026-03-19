package com.bytedance.sdk.djx.core.business.ad;

import com.bytedance.sdk.djx.core.business.ad.IDJXAd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class DJXBaseAdCustomVideo implements IDJXAd.CustomVideo {
    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoAutoStart() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoBreak(long j) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoContinue(long j) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoError(long j, int i, int i2) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoFinish() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoPause(long j) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoStart() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.CustomVideo
    public void reportVideoStartError(int i, int i2) {
    }
}
