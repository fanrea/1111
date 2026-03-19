package com.sigmob.windad.newInterstitial;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface WindNewInterstitialAdListener {
    void onInterstitialAdClicked(final String placementId);

    void onInterstitialAdClosed(final String placementId);

    void onInterstitialAdLoadError(final WindAdError error, final String placementId);

    void onInterstitialAdLoadSuccess(final String placementId);

    void onInterstitialAdPreLoadFail(final String placementId);

    void onInterstitialAdPreLoadSuccess(final String placementId);

    void onInterstitialAdShow(final String placementId);

    void onInterstitialAdShowError(final WindAdError error, final String placementId);
}
