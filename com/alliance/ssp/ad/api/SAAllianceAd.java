package com.alliance.ssp.ad.api;

import android.app.Activity;
import android.view.ViewGroup;
import com.alliance.ssp.ad.api.banner.SABannerAdLoadListener;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdLoadListener;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdLoadListener;
import com.alliance.ssp.ad.api.nativead.SANativeFeedAdLoadListener;
import com.alliance.ssp.ad.api.reward.SARewardVideoAdLoadListener;
import com.alliance.ssp.ad.api.splash.SASplashAdLoadListener;
import com.alliance.ssp.ad.api.stream.SAStreamAdLoadListener;
import com.alliance.ssp.ad.api.unifiedfeed.SAUnifiedFeedAdLoadListener;
import com.alliance.ssp.ad.event.AdnTypeEnum;
import com.alliance.ssp.ad.event.CurrencyEnum;
import com.alliance.ssp.ad.event.LoseReasonEnum;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface SAAllianceAd {
    void loadSABannerAd(SAAllianceAdParams sAAllianceAdParams, ViewGroup viewGroup, SABannerAdLoadListener sABannerAdLoadListener);

    void loadSAExpressFeedAd(SAAllianceAdParams sAAllianceAdParams, ViewGroup viewGroup, SAExpressFeedAdLoadListener sAExpressFeedAdLoadListener);

    void loadSAInterstitialAd(SAAllianceAdParams sAAllianceAdParams, SAInterstitialAdLoadListener sAInterstitialAdLoadListener);

    void loadSANativeFeedAd(SAAllianceAdParams sAAllianceAdParams, SANativeFeedAdLoadListener sANativeFeedAdLoadListener);

    void loadSARewardAd(SAAllianceAdParams sAAllianceAdParams, SARewardVideoAdLoadListener sARewardVideoAdLoadListener);

    void loadSASplashAd(SAAllianceAdParams sAAllianceAdParams, ViewGroup viewGroup, int i, SASplashAdLoadListener sASplashAdLoadListener);

    void loadSAStreamAd(SAAllianceAdParams sAAllianceAdParams, SAStreamAdLoadListener sAStreamAdLoadListener);

    void loadSAUnifiedFeedAd(SAAllianceAdParams sAAllianceAdParams, SAUnifiedFeedAdLoadListener sAUnifiedFeedAdLoadListener);

    void notifyBiddingLose(float f, CurrencyEnum currencyEnum, AdnTypeEnum adnTypeEnum, LoseReasonEnum loseReasonEnum, HashMap<String, Object> map);

    void notifyBiddingWin(float f, CurrencyEnum currencyEnum, AdnTypeEnum adnTypeEnum, HashMap<String, Object> map);

    void onActivityDestroy();

    void onActivityResume();

    void onActivityStop();

    @Deprecated
    void reportBiddingSucceed(boolean z);

    void showBanner(ViewGroup viewGroup);

    void showFeedAd(ViewGroup viewGroup);

    void showInterstitial(Activity activity);

    void showRewardAd(Activity activity);

    void showSplash(ViewGroup viewGroup);
}
