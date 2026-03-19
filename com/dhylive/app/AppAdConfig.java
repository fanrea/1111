package com.dhylive.app;

import com.alipay.sdk.m.p0.b;
import com.baidu.mobads.container.config.a;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.data.mine.InterstitialAdShow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppAdConfig.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b#\u0010\u0006R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b&\u0010\u0012R\u0011\u0010'\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b'\u0010\u0012R\u0011\u0010(\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b(\u0010\u0012R\u0011\u0010)\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0011\u0010*\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b*\u0010\u0012R\u0011\u0010+\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b+\u0010\u0012R\u0011\u0010,\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b,\u0010\u0012R\u0011\u0010-\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b-\u0010\u0012R\u0011\u0010.\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b.\u0010\u0012R\u0011\u0010/\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b/\u0010\u0012R\u0011\u00100\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b1\u0010\u0006R\u0011\u00102\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b3\u0010\u001fR\u0011\u00104\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b5\u0010\u001fR\u0011\u00106\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b7\u0010\u0006R\u0011\u00108\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b9\u0010\u0006R\u0011\u0010:\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b;\u0010\u0006R\u0011\u0010<\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b=\u0010\u0006¨\u0006>"}, d2 = {"Lcom/dhylive/app/AppAdConfig;", "", "()V", "adAppId", "", "getAdAppId", "()Ljava/lang/String;", "adAppKey", "getAdAppKey", "adLoadTimeOutHint", "getAdLoadTimeOutHint", "adLoadTimeoutDuration", "", "getAdLoadTimeoutDuration", "()J", "adSelect", "", "getAdSelect", "()Z", "bannerAdId", "getBannerAdId", b.d, "Lcom/dhylive/app/data/mine/ConfigurationInfo;", "config", "getConfig", "()Lcom/dhylive/app/data/mine/ConfigurationInfo;", "setConfig", "(Lcom/dhylive/app/data/mine/ConfigurationInfo;)V", "dramaFreeNum", "", "getDramaFreeNum", "()I", "dramaUnlockNum", "getDramaUnlockNum", "interstitialAdId", "getInterstitialAdId", "interstitialAdShow", "Lcom/dhylive/app/data/mine/InterstitialAdShow;", "isAdInterstitialAdEnable", "isMineInterstitialAdEnable", "isOpenInterstitialAdEnable", "isPassInterstitialAdEnable", "isRewardAdEnable", "isSignInInterstitialAdEnable", "isStayInterstitialAdEnable", "isTaskInterstitialAdEnable", "isTeamInterstitialAdEnable", "isWithDrawInterstitialAdEnable", "nativeAdId", "getNativeAdId", "novFreeNum", "getNovFreeNum", "novUnlockNum", "getNovUnlockNum", "rewardAdId", "getRewardAdId", "shareType", "getShareType", "splashAdId", "getSplashAdId", a.w, "getWxAppid", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class AppAdConfig {
    public static final AppAdConfig INSTANCE = new AppAdConfig();
    private static ConfigurationInfo config;
    private static InterstitialAdShow interstitialAdShow;

    public final String getAdAppKey() {
        return "";
    }

    public final int getNovFreeNum() {
        return 2;
    }

    public final int getNovUnlockNum() {
        return 2;
    }

    private AppAdConfig() {
    }

    public final ConfigurationInfo getConfig() {
        return config;
    }

    public final void setConfig(ConfigurationInfo configurationInfo) {
        config = configurationInfo;
        interstitialAdShow = configurationInfo != null ? configurationInfo.getInterstitial_ad_show() : null;
    }

    public final String getShareType() {
        String shareChannel;
        ConfigurationInfo configurationInfo = config;
        return (configurationInfo == null || (shareChannel = configurationInfo.getShareChannel()) == null) ? "" : shareChannel;
    }

    public final long getAdLoadTimeoutDuration() {
        Long adLoadTimeoutDuration;
        ConfigurationInfo configurationInfo = config;
        return ((configurationInfo == null || (adLoadTimeoutDuration = configurationInfo.getAdLoadTimeoutDuration()) == null) ? 40L : adLoadTimeoutDuration.longValue()) * 1000;
    }

    public final String getAdLoadTimeOutHint() {
        String adTimeoutHint;
        ConfigurationInfo configurationInfo = config;
        return (configurationInfo == null || (adTimeoutHint = configurationInfo.getAdTimeoutHint()) == null) ? "广告无价值，请重试" : adTimeoutHint;
    }

    public final int getDramaFreeNum() {
        ConfigurationInfo configurationInfo = config;
        if (configurationInfo != null) {
            return configurationInfo.getMovie_free_num();
        }
        return 5;
    }

    public final int getDramaUnlockNum() {
        ConfigurationInfo configurationInfo = config;
        if (configurationInfo != null) {
            return configurationInfo.getMovie_num();
        }
        return 2;
    }

    public final String getWxAppid() {
        String wxAppid;
        ConfigurationInfo configurationInfo = config;
        return (configurationInfo == null || (wxAppid = configurationInfo.getWxAppid()) == null) ? BuildConfig.WX_APP_ID : wxAppid;
    }

    public final String getAdAppId() {
        String csjAppId;
        if (getAdSelect()) {
            ConfigurationInfo configurationInfo = config;
            if (configurationInfo == null || (csjAppId = configurationInfo.getAdc_sigmob_app_id()) == null) {
                return "";
            }
        } else {
            ConfigurationInfo configurationInfo2 = config;
            if (configurationInfo2 == null || (csjAppId = configurationInfo2.getCsjAppId()) == null) {
                return "";
            }
        }
        return csjAppId;
    }

    public final boolean getAdSelect() {
        ConfigurationInfo configurationInfo = config;
        return Intrinsics.areEqual(configurationInfo != null ? configurationInfo.getPriority() : null, "sigmob");
    }

    public final boolean isRewardAdEnable() {
        String adc_redraw_ad_status = null;
        if (getAdSelect()) {
            ConfigurationInfo configurationInfo = config;
            if (configurationInfo != null) {
                adc_redraw_ad_status = configurationInfo.getAdc_sigmob_redraw_ad_status();
            }
        } else {
            ConfigurationInfo configurationInfo2 = config;
            if (configurationInfo2 != null) {
                adc_redraw_ad_status = configurationInfo2.getAdc_redraw_ad_status();
            }
        }
        return Intrinsics.areEqual(adc_redraw_ad_status, "1");
    }

    public final String getRewardAdId() {
        String adc_redraw_ad_id;
        if (getAdSelect()) {
            ConfigurationInfo configurationInfo = config;
            if (configurationInfo == null || (adc_redraw_ad_id = configurationInfo.getAdc_sigmob_reward_ad_id()) == null) {
                return "";
            }
        } else {
            ConfigurationInfo configurationInfo2 = config;
            if (configurationInfo2 == null || (adc_redraw_ad_id = configurationInfo2.getAdc_redraw_ad_id()) == null) {
                return "";
            }
        }
        return adc_redraw_ad_id;
    }

    public final String getSplashAdId() {
        String adc_splash_ad_id;
        if (getAdSelect()) {
            ConfigurationInfo configurationInfo = config;
            if (configurationInfo == null || (adc_splash_ad_id = configurationInfo.getAdc_sigmob_splash_ad_id()) == null) {
                return "";
            }
        } else {
            ConfigurationInfo configurationInfo2 = config;
            if (configurationInfo2 == null || (adc_splash_ad_id = configurationInfo2.getAdc_splash_ad_id()) == null) {
                return "";
            }
        }
        return adc_splash_ad_id;
    }

    public final String getBannerAdId() {
        String adc_banner_ad_id;
        if (getAdSelect()) {
            ConfigurationInfo configurationInfo = config;
            if (configurationInfo == null || (adc_banner_ad_id = configurationInfo.getAdc_sigmob_banner_ad_id()) == null) {
                return "";
            }
        } else {
            ConfigurationInfo configurationInfo2 = config;
            if (configurationInfo2 == null || (adc_banner_ad_id = configurationInfo2.getAdc_banner_ad_id()) == null) {
                return "";
            }
        }
        return adc_banner_ad_id;
    }

    public final String getInterstitialAdId() {
        String adc_inters_ad_id;
        if (getAdSelect()) {
            ConfigurationInfo configurationInfo = config;
            if (configurationInfo == null || (adc_inters_ad_id = configurationInfo.getAdc_sigmob_interstitial_ad_id()) == null) {
                return "";
            }
        } else {
            ConfigurationInfo configurationInfo2 = config;
            if (configurationInfo2 == null || (adc_inters_ad_id = configurationInfo2.getAdc_inters_ad_id()) == null) {
                return "";
            }
        }
        return adc_inters_ad_id;
    }

    public final String getNativeAdId() {
        String adc_sigmob_native_ad_id;
        ConfigurationInfo configurationInfo = config;
        return (configurationInfo == null || (adc_sigmob_native_ad_id = configurationInfo.getAdc_sigmob_native_ad_id()) == null) ? "" : adc_sigmob_native_ad_id;
    }

    public final boolean isTaskInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getTask() == 1;
    }

    public final boolean isMineInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getMine() == 1;
    }

    public final boolean isWithDrawInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getWithdraw() == 1;
    }

    public final boolean isOpenInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getOpen() == 1;
    }

    public final boolean isPassInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getPass() == 1;
    }

    public final boolean isSignInInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getSign_in() == 1;
    }

    public final boolean isStayInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getStay() == 1;
    }

    public final boolean isAdInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getAd() == 1;
    }

    public final boolean isTeamInterstitialAdEnable() {
        InterstitialAdShow interstitialAdShow2 = interstitialAdShow;
        return interstitialAdShow2 != null && interstitialAdShow2.getTeam() == 1;
    }
}
