package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.tube.KSTubeParam;
import java.util.List;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsLoadManager {

    @KsAdSdkApi
    public interface BannerAdListener {
        @KsAdSdkApi
        void onBannerAdLoad(KsBannerAd ksBannerAd);

        @KsAdSdkApi
        void onError(int i, String str);
    }

    @KsAdSdkApi
    public interface DrawAdListener {
        @KsAdSdkApi
        void onDrawAdLoad(List<KsDrawAd> list);

        @KsAdSdkApi
        void onError(int i, String str);
    }

    @KsAdSdkApi
    public interface EntryElementListener<T> {
        @KsAdSdkApi
        void onEntryLoad(T t);

        @KsAdSdkApi
        void onError(int i, String str);
    }

    @KsAdSdkApi
    public interface FeedAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onFeedAdLoad(List<KsFeedAd> list);
    }

    @KsAdSdkApi
    public interface FullScreenVideoAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list);

        @KsAdSdkApi
        void onFullScreenVideoResult(List<KsFullScreenVideoAd> list);
    }

    @KsAdSdkApi
    public interface InterstitialAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onInterstitialAdLoad(List<KsInterstitialAd> list);

        @KsAdSdkApi
        void onRequestResult(int i);
    }

    @KsAdSdkApi
    public interface KsHorizontalVideoDataListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onKsHorizontalVideoDataLoad(List<KsHorizontalVideoModel> list);
    }

    @KsAdSdkApi
    public interface KsHotSpotDataListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onKsHotspotDataLoad(List<KsHotspotData> list);
    }

    @KsAdSdkApi
    public interface KsHotSpotPageListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onKsHotspotPageLoad(KsHotspotPage ksHotspotPage);
    }

    @KsAdSdkApi
    public interface NativeAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onNativeAdLoad(List<KsNativeAd> list);
    }

    @KsAdSdkApi
    public interface RewardVideoAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onRewardVideoAdLoad(List<KsRewardVideoAd> list);

        @KsAdSdkApi
        void onRewardVideoResult(List<KsRewardVideoAd> list);
    }

    @KsAdSdkApi
    public interface SplashScreenAdListener {
        @KsAdSdkApi
        void onError(int i, String str);

        @KsAdSdkApi
        void onRequestResult(int i);

        @KsAdSdkApi
        void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd);
    }

    String getBidRequestToken(KsScene ksScene);

    @KsAdSdkApi
    String getBidRequestTokenV2(KsScene ksScene);

    @KsAdSdkApi
    void loadBannerAd(KsScene ksScene, BannerAdListener bannerAdListener);

    @KsAdSdkApi
    void loadConfigFeedAd(KsScene ksScene, FeedAdListener feedAdListener);

    @KsAdSdkApi
    @Deprecated
    KsContentAllianceAd loadContentAllianceAd(KsScene ksScene);

    @KsAdSdkApi
    KsContentPage loadContentPage(KsScene ksScene);

    @KsAdSdkApi
    KsContentPage loadContentPageByPush(KsScene ksScene, String str);

    @KsAdSdkApi
    KsContentPage loadContentPageBySchema(KsScene ksScene, String str);

    @KsAdSdkApi
    KsContentWallpaperPage loadContentWallpaperPage(KsScene ksScene);

    @KsAdSdkApi
    void loadDrawAd(KsScene ksScene, DrawAdListener drawAdListener);

    @KsAdSdkApi
    void loadEntryElement(KsScene ksScene, EntryElementListener<KsEntryElement> entryElementListener);

    @KsAdSdkApi
    void loadEntryElement(KsScene ksScene, EntryElementListener<KsEntryElement> entryElementListener, boolean z);

    @KsAdSdkApi
    @Deprecated
    void loadFeedAd(KsScene ksScene, FeedAdListener feedAdListener);

    @KsAdSdkApi
    KsFeedPage loadFeedPage(KsScene ksScene);

    @KsAdSdkApi
    void loadFullScreenVideoAd(KsScene ksScene, FullScreenVideoAdListener fullScreenVideoAdListener);

    @KsAdSdkApi
    KsHorizontalFeedPage loadHorizontalFeedPage(KsScene ksScene);

    @KsAdSdkApi
    KsHorizontalFeedPage loadHorizontalPlayFeedPage(KsScene ksScene);

    void loadHorizontalVideoData(KsScene ksScene, KsHorizontalVideoDataListener ksHorizontalVideoDataListener);

    void loadHotspotData(KsScene ksScene, KsHotSpotDataListener ksHotSpotDataListener);

    @KsAdSdkApi
    void loadHotspotPage(KsScene ksScene, KsHotSpotPageListener ksHotSpotPageListener);

    @KsAdSdkApi
    void loadInterstitialAd(KsScene ksScene, InterstitialAdListener interstitialAdListener);

    @KsAdSdkApi
    KsContentPage loadLivePage(KsScene ksScene);

    @KsAdSdkApi
    void loadNativeAd(KsScene ksScene, NativeAdListener nativeAdListener);

    @KsAdSdkApi
    void loadRewardVideoAd(KsScene ksScene, RewardVideoAdListener rewardVideoAdListener);

    @KsAdSdkApi
    void loadSplashScreenAd(KsScene ksScene, SplashScreenAdListener splashScreenAdListener);

    KsTubePage loadTubePage(KsScene ksScene, KSTubeParam kSTubeParam);

    @KsAdSdkApi
    KsWallpaperFeedPage loadWallpaperFeedPage(KsScene ksScene);
}
