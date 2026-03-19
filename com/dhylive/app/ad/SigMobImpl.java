package com.dhylive.app.ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.dhylive.app.ad.info.SigMobCustomAd;
import com.dhylive.app.ad.info.SigMobInterstitialAd;
import com.dhylive.app.ad.info.SigMobRewardAd;
import com.dhylive.app.utils.SPConfig;
import com.windmill.sdk.WindMillAd;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.banner.WMBannerAdListener;
import com.windmill.sdk.banner.WMBannerAdRequest;
import com.windmill.sdk.banner.WMBannerView;
import com.windmill.sdk.interstitial.WMInterstitialAd;
import com.windmill.sdk.interstitial.WMInterstitialAdListener;
import com.windmill.sdk.interstitial.WMInterstitialAdRequest;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.natives.WMNativeAd;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRequest;
import com.windmill.sdk.reward.WMRewardAd;
import com.windmill.sdk.reward.WMRewardAdListener;
import com.windmill.sdk.reward.WMRewardAdRequest;
import com.windmill.sdk.reward.WMRewardInfo;
import com.windmill.sdk.splash.IWMSplashEyeAd;
import com.windmill.sdk.splash.WMSplashAd;
import com.windmill.sdk.splash.WMSplashAdListener;
import com.windmill.sdk.splash.WMSplashAdRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SigMobImpl.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J2\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J*\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J,\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J*\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006("}, d2 = {"Lcom/dhylive/app/ad/SigMobImpl;", "Lcom/dhylive/app/ad/MobSdk;", "()V", "isInit", "", "()Z", "getCustomAd", "", "activity", "Landroid/app/Activity;", "adId", "", "customAdListener", "Lcom/dhylive/app/ad/CustomAdListener;", "getInterstitialAd", "interstitialAdListener", "Lcom/dhylive/app/ad/InterstitialAdListener;", "initSdk", "context", "Landroid/content/Context;", "appId", "appKey", "needPermission", "initListener", "Lcom/dhylive/app/ad/MobInitListener;", "loadBannerAd", "container", "Landroid/view/ViewGroup;", "bannerAdListener", "Lcom/dhylive/app/ad/BannerAdListener;", "loadCustomAd", "Landroid/widget/FrameLayout;", "loadInterstitialAd", "loadRewardAd", "orderNo", "rewardAdListener", "Lcom/dhylive/app/ad/RewardAdListener;", "loadSplashAd", "splashAdListener", "Lcom/dhylive/app/ad/SplashAdListener;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class SigMobImpl extends MobSdk {
    public static final SigMobImpl INSTANCE = new SigMobImpl();

    private SigMobImpl() {
    }

    @Override // com.dhylive.app.ad.MobSdk
    public boolean isInit() {
        return WindMillAd.sharedAds().isInit();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void initSdk(Context context, String appId, String appKey, boolean needPermission, final MobInitListener initListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        WindMillAd windMillAdSharedAds = WindMillAd.sharedAds();
        windMillAdSharedAds.setAdult(true);
        windMillAdSharedAds.setDebugEnable(true);
        windMillAdSharedAds.startWithAppId(context, appId, new WindMillAd.WindMillAdInitListener() { // from class: com.dhylive.app.ad.SigMobImpl.initSdk.1
            public void onInitSuccess() {
                LogUtils.e("Sigmob init success");
                MobInitListener mobInitListener = initListener;
                if (mobInitListener != null) {
                    mobInitListener.onSuccess();
                }
            }

            public void onInitFailed(int errorCode, String errorMsg) {
                LogUtils.e("Sigmob init fail, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
                MobInitListener mobInitListener = initListener;
                if (mobInitListener != null) {
                    mobInitListener.onFail(errorCode, errorMsg);
                }
            }
        });
        if (needPermission && (context instanceof Activity)) {
            boolean zIsPermissionGranted = ClientMetadata.isPermissionGranted(context, "android.permission.READ_PHONE_STATE");
            boolean zIsPermissionGranted2 = ClientMetadata.isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (zIsPermissionGranted && zIsPermissionGranted2) {
                return;
            }
            ((Activity) context).requestPermissions(new String[]{"android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
        }
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadSplashAd(Activity activity, String adId, final ViewGroup container, final SplashAdListener splashAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        LogUtils.e("loadSplashAd, 广告位id：" + adId + "， 容器：" + container);
        container.setVisibility(0);
        WMSplashAdRequest wMSplashAdRequest = new WMSplashAdRequest(adId, "0", (Map) null);
        wMSplashAdRequest.setDisableAutoHideAd(true);
        new WMSplashAd(activity, wMSplashAdRequest, new WMSplashAdListener() { // from class: com.dhylive.app.ad.SigMobImpl$loadSplashAd$splashAd$1
            public void onSplashAdSuccessPresent(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            }

            public void onSplashAdSuccessLoad(String placementId) {
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadSplashAd success");
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdLoadSuccess();
                }
            }

            public void onSplashAdFailToLoad(WindMillError error, String placementId) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadSplashAd fail  :" + error.getMessage());
                container.removeAllViews();
                container.setVisibility(4);
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdLoadFail();
                }
            }

            public void onSplashAdFailToPresent(WindMillError error, String placementId) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadSplashAd fail  :" + error.getMessage());
                container.removeAllViews();
                container.setVisibility(4);
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdLoadFail();
                }
            }

            public void onSplashAdClicked(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdClick();
                }
            }

            public void onSplashClosed(AdInfo adInfo, IWMSplashEyeAd splashEyeAd) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                container.removeAllViews();
                container.setVisibility(4);
                if (splashEyeAd != null) {
                    splashEyeAd.destroy();
                }
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdClose();
                }
            }
        }).loadAdAndShow(container);
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadRewardAd(Activity activity, String adId, String orderNo, final RewardAdListener rewardAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        LogUtils.e("loadRewardAd, 广告位id：" + adId);
        HashMap map = new HashMap();
        map.put("pos_id", adId);
        map.put("order_no", String.valueOf(orderNo));
        final WMRewardAd wMRewardAd = new WMRewardAd(activity, new WMRewardAdRequest(adId, String.valueOf(SPUtils.getInstance().getLong(SPConfig.KEY_USERID)), map));
        wMRewardAd.setRewardedAdListener(new WMRewardAdListener() { // from class: com.dhylive.app.ad.SigMobImpl.loadRewardAd.1
            public void onVideoAdPlayEnd(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            }

            public void onVideoAdLoadSuccess(String placementId) {
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadRewardAd success");
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdLoadSuccess(new SigMobRewardAd(wMRewardAd, null, null, 6, null));
                }
            }

            public void onVideoAdPlayStart(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    WMRewardAd wMRewardAd2 = wMRewardAd;
                    String networkName = adInfo.getNetworkName();
                    Intrinsics.checkNotNullExpressionValue(networkName, "getNetworkName(...)");
                    rewardAdListener2.onAdPlaySuccess(new SigMobRewardAd(wMRewardAd2, "sigmob", networkName));
                }
            }

            public void onVideoAdClicked(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdClick();
                }
            }

            public void onVideoRewarded(AdInfo adInfo, WMRewardInfo rewardInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                Intrinsics.checkNotNullParameter(rewardInfo, "rewardInfo");
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdReward();
                }
            }

            public void onVideoAdClosed(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdClose();
                }
            }

            public void onVideoAdLoadError(WindMillError error, String placementId) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadRewardAd fail :" + error.getMessage());
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdLoadFail();
                }
            }

            public void onVideoAdPlayError(WindMillError error, String placementId) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadRewardAd fail :" + error.getMessage());
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdPlayFail();
                }
            }
        });
        wMRewardAd.loadAd();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadBannerAd(Activity activity, String adId, final ViewGroup container, final BannerAdListener bannerAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        LogUtils.e("loadBannerAd, 广告位id：" + adId + "， 容器：" + container);
        final WMBannerView wMBannerView = new WMBannerView(activity);
        wMBannerView.setAutoAnimation(true);
        wMBannerView.setAdListener(new WMBannerAdListener() { // from class: com.dhylive.app.ad.SigMobImpl.loadBannerAd.1
            public void onAdAutoRefreshed(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            }

            public void onAdLoadSuccess(String placementId) {
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadBannerAd success");
                if (wMBannerView.isReady()) {
                    container.setVisibility(0);
                    container.removeAllViews();
                    container.addView((View) wMBannerView);
                    BannerAdListener bannerAdListener2 = bannerAdListener;
                    if (bannerAdListener2 != null) {
                        bannerAdListener2.onAdLoadSuccess();
                    }
                }
            }

            public void onAdLoadError(WindMillError error, String placementId) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadBannerAd fail :" + error.getMessage());
                container.setVisibility(8);
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.onAdLoadFail();
                }
            }

            public void onAdShown(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                LogUtils.e("Sigmob loadBannerAd show: " + adInfo);
            }

            public void onAdClicked(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.onAdClick();
                }
            }

            public void onAdClosed(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                container.setVisibility(8);
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.onAdClose();
                }
            }

            public void onAdAutoRefreshFail(WindMillError error, String placementId) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(placementId, "placementId");
                LogUtils.e("Sigmob loadBannerAd fail :" + error.getMessage());
            }
        });
        HashMap map = new HashMap();
        map.put("ad_key_width", Integer.valueOf(SizeUtils.px2dp(ScreenUtils.getScreenWidth()) - 12));
        map.put("ad_key_height", 75);
        wMBannerView.loadAd(new WMBannerAdRequest(adId, String.valueOf(SPUtils.getInstance().getLong(SPConfig.KEY_USERID)), map));
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadInterstitialAd(final Activity activity, String adId, final InterstitialAdListener interstitialAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        LogUtils.e("loadInterstitialAd, 广告位id：" + adId);
        final WMInterstitialAd wMInterstitialAd = new WMInterstitialAd(activity, new WMInterstitialAdRequest(adId, String.valueOf(SPUtils.getInstance().getLong(SPConfig.KEY_USERID)), (Map) null));
        wMInterstitialAd.setInterstitialAdListener(new WMInterstitialAdListener() { // from class: com.dhylive.app.ad.SigMobImpl.loadInterstitialAd.1
            public void onInterstitialAdPlayEnd(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            }

            public void onInterstitialAdLoadSuccess(String p0) {
                LogUtils.e("Sigmob loadInterstitialAd success");
                wMInterstitialAd.show(activity, (HashMap) null);
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadSuccess(new SigMobInterstitialAd(wMInterstitialAd));
                }
            }

            public void onInterstitialAdPlayStart(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdPlaySuccess();
                }
            }

            public void onInterstitialAdClicked(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdClick();
                }
            }

            public void onInterstitialAdClosed(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdClose();
                }
            }

            public void onInterstitialAdLoadError(WindMillError p0, String p1) {
                LogUtils.e("Sigmob loadInterstitialAd fail :" + p0);
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadFail();
                }
            }

            public void onInterstitialAdPlayError(WindMillError p0, String p1) {
                LogUtils.e("Sigmob loadInterstitialAd fail :" + p0);
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadFail();
                }
            }
        });
        wMInterstitialAd.loadAd();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void getInterstitialAd(Activity activity, String adId, final InterstitialAdListener interstitialAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        LogUtils.e("loadInterstitialAd, 广告位id：" + adId);
        final WMInterstitialAd wMInterstitialAd = new WMInterstitialAd(activity, new WMInterstitialAdRequest(adId, String.valueOf(SPUtils.getInstance().getLong(SPConfig.KEY_USERID)), (Map) null));
        wMInterstitialAd.setInterstitialAdListener(new WMInterstitialAdListener() { // from class: com.dhylive.app.ad.SigMobImpl.getInterstitialAd.1
            public void onInterstitialAdPlayEnd(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            }

            public void onInterstitialAdLoadSuccess(String p0) {
                LogUtils.e("Sigmob getInterstitialAd success");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadSuccess(new SigMobInterstitialAd(wMInterstitialAd));
                }
            }

            public void onInterstitialAdPlayStart(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdPlaySuccess();
                }
            }

            public void onInterstitialAdClicked(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdClick();
                }
            }

            public void onInterstitialAdClosed(AdInfo adInfo) {
                Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdClose();
                }
            }

            public void onInterstitialAdLoadError(WindMillError p0, String p1) {
                LogUtils.e("Sigmob getInterstitialAd fail :" + p0);
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadFail();
                }
            }

            public void onInterstitialAdPlayError(WindMillError p0, String p1) {
                LogUtils.e("Sigmob getInterstitialAd fail :" + p0);
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadFail();
                }
            }
        });
        wMInterstitialAd.loadAd();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadCustomAd(final Activity activity, String adId, final FrameLayout container, final CustomAdListener customAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        LogUtils.e("loadNativeAd adId: " + adId);
        String strValueOf = String.valueOf(SPUtils.getInstance().getLong(SPConfig.KEY_USERID));
        HashMap map = new HashMap();
        map.put("ad_key_width", 300);
        map.put("ad_key_height", 200);
        map.put("user_id", strValueOf);
        final WMNativeAd wMNativeAd = new WMNativeAd(activity, new WMNativeAdRequest(adId, strValueOf, 1, map));
        wMNativeAd.loadAd(new WMNativeAd.NativeAdLoadListener() { // from class: com.dhylive.app.ad.SigMobImpl.loadCustomAd.1
            public void onError(WindMillError error, String placementId) {
                LogUtils.e("Sigmob loadNativeAd fail :" + error);
                CustomAdListener customAdListener2 = customAdListener;
                if (customAdListener2 != null) {
                    customAdListener2.onAdLoadFail();
                }
            }

            public void onFeedAdLoad(String placementId) {
                List nativeADDataList = wMNativeAd.getNativeADDataList();
                Intrinsics.checkNotNull(nativeADDataList);
                if (!nativeADDataList.isEmpty()) {
                    WMNativeAdData wMNativeAdData = (WMNativeAdData) nativeADDataList.get(0);
                    final CustomAdListener customAdListener2 = customAdListener;
                    wMNativeAdData.setInteractionListener(new WMNativeAdData.NativeAdInteractionListener() { // from class: com.dhylive.app.ad.SigMobImpl$loadCustomAd$1$onFeedAdLoad$1
                        public void onADExposed(AdInfo adInfo) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                        }

                        public void onADRenderSuccess(AdInfo adInfo, View view, float width, float height) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                        }

                        public void onADClicked(AdInfo adInfo) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                            CustomAdListener customAdListener3 = customAdListener2;
                            if (customAdListener3 != null) {
                                customAdListener3.onAdClick();
                            }
                        }

                        public void onADError(AdInfo adInfo, WindMillError error) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                            CustomAdListener customAdListener3 = customAdListener2;
                            if (customAdListener3 != null) {
                                customAdListener3.onAdLoadFail();
                            }
                        }
                    });
                    Activity activity2 = activity;
                    final FrameLayout frameLayout = container;
                    final CustomAdListener customAdListener3 = customAdListener;
                    wMNativeAdData.setDislikeInteractionCallback(activity2, new WMNativeAdData.DislikeInteractionCallback() { // from class: com.dhylive.app.ad.SigMobImpl$loadCustomAd$1$onFeedAdLoad$2
                        public void onCancel() {
                        }

                        public void onShow() {
                        }

                        public void onSelected(int position, String value, boolean enforce) {
                            frameLayout.removeAllViews();
                            CustomAdListener customAdListener4 = customAdListener3;
                            if (customAdListener4 != null) {
                                customAdListener4.onAdClose();
                            }
                        }
                    });
                    CustomAdListener customAdListener4 = customAdListener;
                    if (customAdListener4 != null) {
                        Intrinsics.checkNotNull(wMNativeAdData);
                        customAdListener4.onAdLoadSuccess(new SigMobCustomAd(wMNativeAdData));
                    }
                    if (wMNativeAdData.isExpressAd()) {
                        wMNativeAdData.render();
                        container.setVisibility(0);
                        container.removeAllViews();
                        container.addView(wMNativeAdData.getExpressAdView());
                        CustomAdListener customAdListener5 = customAdListener;
                        if (customAdListener5 != null) {
                            customAdListener5.onAdShow();
                            return;
                        }
                        return;
                    }
                    View wMNativeAdContainer = new WMNativeAdContainer(activity);
                    wMNativeAdData.connectAdToView(activity, wMNativeAdContainer, new NativeAdRender());
                    container.removeAllViews();
                    container.addView(wMNativeAdContainer);
                    CustomAdListener customAdListener6 = customAdListener;
                    if (customAdListener6 != null) {
                        customAdListener6.onAdShow();
                    }
                }
            }
        });
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void getCustomAd(final Activity activity, String adId, final CustomAdListener customAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        LogUtils.e("getCustomAd adId: " + adId);
        String strValueOf = String.valueOf(SPUtils.getInstance().getLong(SPConfig.KEY_USERID));
        HashMap map = new HashMap();
        map.put("ad_key_width", 300);
        map.put("ad_key_height", 200);
        map.put("user_id", strValueOf);
        final WMNativeAd wMNativeAd = new WMNativeAd(activity, new WMNativeAdRequest(adId, strValueOf, 1, map));
        wMNativeAd.loadAd(new WMNativeAd.NativeAdLoadListener() { // from class: com.dhylive.app.ad.SigMobImpl.getCustomAd.1
            public void onError(WindMillError error, String placementId) {
                LogUtils.e("Sigmob loadNativeAd fail :" + error);
                CustomAdListener customAdListener2 = customAdListener;
                if (customAdListener2 != null) {
                    customAdListener2.onAdLoadFail();
                }
            }

            public void onFeedAdLoad(String placementId) {
                List nativeADDataList = wMNativeAd.getNativeADDataList();
                Intrinsics.checkNotNull(nativeADDataList);
                if (!nativeADDataList.isEmpty()) {
                    WMNativeAdData wMNativeAdData = (WMNativeAdData) nativeADDataList.get(0);
                    final CustomAdListener customAdListener2 = customAdListener;
                    wMNativeAdData.setInteractionListener(new WMNativeAdData.NativeAdInteractionListener() { // from class: com.dhylive.app.ad.SigMobImpl$getCustomAd$1$onFeedAdLoad$1
                        public void onADExposed(AdInfo adInfo) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                        }

                        public void onADRenderSuccess(AdInfo adInfo, View view, float width, float height) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                        }

                        public void onADClicked(AdInfo adInfo) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                            CustomAdListener customAdListener3 = customAdListener2;
                            if (customAdListener3 != null) {
                                customAdListener3.onAdClick();
                            }
                        }

                        public void onADError(AdInfo adInfo, WindMillError error) {
                            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
                            CustomAdListener customAdListener3 = customAdListener2;
                            if (customAdListener3 != null) {
                                customAdListener3.onAdLoadFail();
                            }
                        }
                    });
                    Activity activity2 = activity;
                    final CustomAdListener customAdListener3 = customAdListener;
                    wMNativeAdData.setDislikeInteractionCallback(activity2, new WMNativeAdData.DislikeInteractionCallback() { // from class: com.dhylive.app.ad.SigMobImpl$getCustomAd$1$onFeedAdLoad$2
                        public void onCancel() {
                        }

                        public void onShow() {
                        }

                        public void onSelected(int position, String value, boolean enforce) {
                            CustomAdListener customAdListener4 = customAdListener3;
                            if (customAdListener4 != null) {
                                customAdListener4.onAdClose();
                            }
                        }
                    });
                    CustomAdListener customAdListener4 = customAdListener;
                    if (customAdListener4 != null) {
                        Intrinsics.checkNotNull(wMNativeAdData);
                        customAdListener4.onAdLoadSuccess(new SigMobCustomAd(wMNativeAdData));
                    }
                }
            }
        });
    }
}
