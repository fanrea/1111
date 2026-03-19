package com.sigmob.windad.Splash;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface WindSplashADListener {
    void onSplashAdClick(String placementId);

    void onSplashAdClose(String placementId);

    void onSplashAdLoadFail(WindAdError error, String placementId);

    void onSplashAdLoadSuccess(String placementId);

    void onSplashAdShow(String placementId);

    void onSplashAdShowError(WindAdError error, String placementId);

    void onSplashAdSkip(String placementId);
}
