package com.kwad.sdk.api;

import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.tube.KSTubeDetailParam;
import com.kwad.sdk.api.tube.KSTubeParam;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsLoadManagerDefault implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public String getBidRequestToken(KsScene ksScene) {
        return "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public String getBidRequestTokenV2(KsScene ksScene) {
        return "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentAllianceAd loadContentAllianceAd(KsScene ksScene) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPage(KsScene ksScene) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPageByPush(KsScene ksScene, String str) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadContentPageBySchema(KsScene ksScene, String str) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentWallpaperPage loadContentWallpaperPage(KsScene ksScene) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsFeedPage loadFeedPage(KsScene ksScene) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsHorizontalFeedPage loadHorizontalFeedPage(KsScene ksScene) {
        return null;
    }

    public KsHorizontalFeedPage loadHorizontalNewsFeedPage(KsScene ksScene) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsHorizontalFeedPage loadHorizontalPlayFeedPage(KsScene ksScene) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsContentPage loadLivePage(KsScene ksScene) {
        return null;
    }

    public KsContentPage loadTubeContentPage(KSTubeDetailParam kSTubeDetailParam) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsTubePage loadTubePage(KsScene ksScene, KSTubeParam kSTubeParam) {
        return null;
    }

    public KsTubePage loadTubePage(KsScene ksScene, boolean z) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public KsWallpaperFeedPage loadWallpaperFeedPage(KsScene ksScene) {
        return null;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFullScreenVideoAd(KsScene ksScene, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        fullScreenVideoAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        rewardVideoAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        feedAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        feedAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadBannerAd(KsScene ksScene, KsLoadManager.BannerAdListener bannerAdListener) {
        bannerAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadDrawAd(KsScene ksScene, KsLoadManager.DrawAdListener drawAdListener) {
        drawAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener) {
        nativeAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        splashScreenAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadInterstitialAd(KsScene ksScene, KsLoadManager.InterstitialAdListener interstitialAdListener) {
        interstitialAdListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadHorizontalVideoData(KsScene ksScene, KsLoadManager.KsHorizontalVideoDataListener ksHorizontalVideoDataListener) {
        ksHorizontalVideoDataListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener) {
        entryElementListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadEntryElement(KsScene ksScene, KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener, boolean z) {
        entryElementListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadHotspotData(KsScene ksScene, KsLoadManager.KsHotSpotDataListener ksHotSpotDataListener) {
        ksHotSpotDataListener.onError(0, "SDK not init success");
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public void loadHotspotPage(KsScene ksScene, KsLoadManager.KsHotSpotPageListener ksHotSpotPageListener) {
        ksHotSpotPageListener.onError(0, "SDK not init success");
    }
}
