package com.sigmob.windad.rewardVideo;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface WindRewardVideoAdListener {
    void onRewardAdClicked(String placementId);

    void onRewardAdClosed(String placementId);

    void onRewardAdLoadError(WindAdError error, String placementId);

    void onRewardAdLoadSuccess(String placementId);

    void onRewardAdPlayEnd(String placementId);

    void onRewardAdPlayError(WindAdError error, String placementId);

    void onRewardAdPlayStart(String placementId);

    void onRewardAdPreLoadFail(String placementId);

    void onRewardAdPreLoadSuccess(String placementId);

    void onRewardAdRewarded(WindRewardInfo rewardInfo, String placementId);
}
