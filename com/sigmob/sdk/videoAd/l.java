package com.sigmob.sdk.videoAd;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface l {
    void onAdClicked(String placementId);

    void onAdClosed(String placementId);

    void onAdShow(String placementId);

    void onAdShowError(WindAdError error, String placementId);

    void onVideoAdPlayComplete(String placementId);

    void onVideoAdPlayEnd(String placementId);
}
