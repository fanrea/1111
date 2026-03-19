package com.dhylive.app.ad;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.LogUtils;
import com.dhylive.app.ad.info.KsMobInterstitialAd;
import com.dhylive.app.ad.info.KsMobRewardAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.SdkConfig;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KsMobImpl.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J2\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J*\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J*\u0010\u001f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J*\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006)"}, d2 = {"Lcom/dhylive/app/ad/KsMobImpl;", "Lcom/dhylive/app/ad/MobSdk;", "()V", "TAG", "", "isInit", "", "()Z", "getCustomAd", "", "activity", "Landroid/app/Activity;", "adId", "customAdListener", "Lcom/dhylive/app/ad/CustomAdListener;", "getInterstitialAd", "interstitialAdListener", "Lcom/dhylive/app/ad/InterstitialAdListener;", "initSdk", "context", "Landroid/content/Context;", "appId", "appKey", "needPermission", "initListener", "Lcom/dhylive/app/ad/MobInitListener;", "loadBannerAd", "container", "Landroid/view/ViewGroup;", "bannerAdListener", "Lcom/dhylive/app/ad/BannerAdListener;", "loadCustomAd", "Landroid/widget/FrameLayout;", "loadInterstitialAd", "loadRewardAd", "orderNo", "rewardAdListener", "Lcom/dhylive/app/ad/RewardAdListener;", "loadSplashAd", "splashAdListener", "Lcom/dhylive/app/ad/SplashAdListener;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class KsMobImpl extends MobSdk {
    public static final KsMobImpl INSTANCE = new KsMobImpl();
    private static final String TAG = "KsMobImpl";

    @Override // com.dhylive.app.ad.MobSdk
    public void getCustomAd(Activity activity, String adId, CustomAdListener customAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadCustomAd(Activity activity, String adId, FrameLayout container, CustomAdListener customAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    private KsMobImpl() {
    }

    @Override // com.dhylive.app.ad.MobSdk
    public boolean isInit() {
        return KsAdSDK.haseInit();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void initSdk(Context context, String appId, String appKey, boolean needPermission, final MobInitListener initListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        KsAdSDK.init(context, new SdkConfig.Builder().appId(appId).appName(context.getString(2131755075)).showNotification(true).debug(true).setStartCallback(new KsInitCallback() { // from class: com.dhylive.app.ad.KsMobImpl.initSdk.1
            @Override // com.kwad.sdk.api.KsInitCallback
            public void onSuccess() {
                LogUtils.eTag(KsMobImpl.TAG, "sdk start success");
                MobInitListener mobInitListener = initListener;
                if (mobInitListener != null) {
                    mobInitListener.onSuccess();
                }
            }

            @Override // com.kwad.sdk.api.KsInitCallback
            public void onFail(int code, String msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                LogUtils.eTag(KsMobImpl.TAG, "sdk start fail msg: " + msg);
                MobInitListener mobInitListener = initListener;
                if (mobInitListener != null) {
                    mobInitListener.onFail(code, msg);
                }
            }
        }).build());
        KsAdSDK.start();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadSplashAd(final Activity activity, String adId, final ViewGroup container, final SplashAdListener splashAdListener) {
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        try {
            Result.Companion companion = Result.Companion;
            KsMobImpl ksMobImpl = this;
            obj = Result.constructor-impl(Long.valueOf(Long.parseLong(adId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0L;
        }
        long jLongValue = ((Number) obj).longValue();
        if (jLongValue == 0) {
            LogUtils.eTag(TAG, "loadSplashAd fail adId is error");
            if (splashAdListener != null) {
                splashAdListener.onAdLoadFail();
                return;
            }
            return;
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(jLongValue).build(), new KsLoadManager.SplashScreenAdListener() { // from class: com.dhylive.app.ad.KsMobImpl.loadSplashAd.1
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int p0) {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int p0, String p1) {
                LogUtils.eTag(KsMobImpl.TAG, "loadSplashAd fail code: " + p0 + " msg: " + p1);
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdLoadFail();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(KsSplashScreenAd screenAd) {
                if (screenAd == null || !screenAd.isAdEnable()) {
                    return;
                }
                container.removeAllViews();
                ViewGroup viewGroup = container;
                Activity activity2 = activity;
                final SplashAdListener splashAdListener2 = splashAdListener;
                viewGroup.addView(screenAd.getView(activity2, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.dhylive.app.ad.KsMobImpl$loadSplashAd$1$onSplashScreenAdLoad$1
                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdShowStart() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onDownloadTipsDialogCancel() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdClicked() {
                        SplashAdListener splashAdListener3 = splashAdListener2;
                        if (splashAdListener3 != null) {
                            splashAdListener3.onAdClick();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdShowError(int p0, String p1) {
                        LogUtils.eTag("KsMobImpl", "showSplashAd fail code: " + p0 + " msg: " + p1);
                        SplashAdListener splashAdListener3 = splashAdListener2;
                        if (splashAdListener3 != null) {
                            splashAdListener3.onAdLoadFail();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onAdShowEnd() {
                        SplashAdListener splashAdListener3 = splashAdListener2;
                        if (splashAdListener3 != null) {
                            splashAdListener3.onAdClose();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                    public void onSkippedAd() {
                        SplashAdListener splashAdListener3 = splashAdListener2;
                        if (splashAdListener3 != null) {
                            splashAdListener3.onAdClose();
                        }
                    }
                }));
            }
        });
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadRewardAd(Activity activity, String adId, String orderNo, final RewardAdListener rewardAdListener) {
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        try {
            Result.Companion companion = Result.Companion;
            KsMobImpl ksMobImpl = this;
            obj = Result.constructor-impl(Long.valueOf(Long.parseLong(adId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0L;
        }
        if (((Number) obj).longValue() == 0) {
            LogUtils.eTag(TAG, "loadRewardAd fail adId is error");
            if (rewardAdListener != null) {
                rewardAdListener.onAdLoadFail();
                return;
            }
            return;
        }
        KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(Long.parseLong(adId)).build(), new KsLoadManager.RewardVideoAdListener() { // from class: com.dhylive.app.ad.KsMobImpl.loadRewardAd.1
            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int p0, String p1) {
                LogUtils.eTag(KsMobImpl.TAG, "loadRewardAd fail code: " + p0 + " msg: " + p1);
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdLoadFail();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(List<KsRewardVideoAd> p0) {
                RewardAdListener rewardAdListener2;
                List<KsRewardVideoAd> list = p0;
                if (!(list == null || list.isEmpty()) || (rewardAdListener2 = rewardAdListener) == null) {
                    return;
                }
                rewardAdListener2.onAdLoadFail();
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(List<KsRewardVideoAd> rewardVideoAds) {
                List<KsRewardVideoAd> list = rewardVideoAds;
                if (list == null || list.isEmpty()) {
                    return;
                }
                final KsRewardVideoAd ksRewardVideoAd = rewardVideoAds.get(0);
                final RewardAdListener rewardAdListener2 = rewardAdListener;
                ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener() { // from class: com.dhylive.app.ad.KsMobImpl$loadRewardAd$1$onRewardVideoAdLoad$1
                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onExtraRewardVerify(int p0) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardStepVerify(int p0, int p1) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(Map<String, Object> p0) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayEnd() {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoSkipToEnd(long p0) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onAdClicked() {
                        RewardAdListener rewardAdListener3 = rewardAdListener2;
                        if (rewardAdListener3 != null) {
                            rewardAdListener3.onAdClick();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onPageDismiss() {
                        RewardAdListener rewardAdListener3 = rewardAdListener2;
                        if (rewardAdListener3 != null) {
                            rewardAdListener3.onAdClose();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayError(int p0, int p1) {
                        RewardAdListener rewardAdListener3 = rewardAdListener2;
                        if (rewardAdListener3 != null) {
                            rewardAdListener3.onAdPlayFail();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayStart() {
                        RewardAdListener rewardAdListener3 = rewardAdListener2;
                        if (rewardAdListener3 != null) {
                            rewardAdListener3.onAdPlaySuccess(new KsMobRewardAd(ksRewardVideoAd, GlobalSetting.KS_SDK_WRAPPER, "ksSdk"));
                        }
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify() {
                        RewardAdListener rewardAdListener3 = rewardAdListener2;
                        if (rewardAdListener3 != null) {
                            rewardAdListener3.onAdReward();
                        }
                    }
                });
                RewardAdListener rewardAdListener3 = rewardAdListener;
                if (rewardAdListener3 != null) {
                    rewardAdListener3.onAdLoadSuccess(new KsMobRewardAd(ksRewardVideoAd, null, null, 6, null));
                }
            }
        });
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadBannerAd(Activity activity, String adId, ViewGroup container, BannerAdListener bannerAdListener) {
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        try {
            Result.Companion companion = Result.Companion;
            KsMobImpl ksMobImpl = this;
            obj = Result.constructor-impl(Long.valueOf(Long.parseLong(adId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0L;
        }
        if (((Number) obj).longValue() == 0) {
            LogUtils.eTag(TAG, "loadRewardAd fail adId is error");
            if (bannerAdListener != null) {
                bannerAdListener.onAdLoadFail();
                return;
            }
            return;
        }
        new KsScene.Builder(Long.parseLong(adId)).build();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadInterstitialAd(final Activity activity, String adId, final InterstitialAdListener interstitialAdListener) {
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        try {
            Result.Companion companion = Result.Companion;
            KsMobImpl ksMobImpl = this;
            obj = Result.constructor-impl(Long.valueOf(Long.parseLong(adId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0L;
        }
        if (((Number) obj).longValue() == 0) {
            LogUtils.eTag(TAG, "loadInterstitialAd fail adId is error");
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdLoadFail();
                return;
            }
            return;
        }
        KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(Long.parseLong(adId)).build(), new KsLoadManager.InterstitialAdListener() { // from class: com.dhylive.app.ad.KsMobImpl.loadInterstitialAd.1
            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onRequestResult(int p0) {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onError(int p0, String p1) {
                LogUtils.eTag(KsMobImpl.TAG, "loadInterstitialAd fail code: " + p0 + " msg: " + p1);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onInterstitialAdLoad(List<KsInterstitialAd> interstitialAds) {
                List<KsInterstitialAd> list = interstitialAds;
                if (list == null || list.isEmpty()) {
                    return;
                }
                KsInterstitialAd ksInterstitialAd = interstitialAds.get(0);
                final InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.dhylive.app.ad.KsMobImpl$loadInterstitialAd$1$onInterstitialAdLoad$1
                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onPageDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onSkippedAd() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayEnd() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayStart() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdClicked() {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdClick();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdShow() {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdPlaySuccess();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdClosed() {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdClose();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayError(int p0, int p1) {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdPlayFail();
                        }
                    }
                });
                KsMobInterstitialAd ksMobInterstitialAd = new KsMobInterstitialAd(ksInterstitialAd);
                ksMobInterstitialAd.showAd(activity);
                InterstitialAdListener interstitialAdListener3 = interstitialAdListener;
                if (interstitialAdListener3 != null) {
                    interstitialAdListener3.onAdLoadSuccess(ksMobInterstitialAd);
                }
            }
        });
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void getInterstitialAd(Activity activity, String adId, final InterstitialAdListener interstitialAdListener) {
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        try {
            Result.Companion companion = Result.Companion;
            KsMobImpl ksMobImpl = this;
            obj = Result.constructor-impl(Long.valueOf(Long.parseLong(adId)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            obj = 0L;
        }
        if (((Number) obj).longValue() == 0) {
            LogUtils.eTag(TAG, "loadRewardAd fail adId is error");
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdLoadFail();
                return;
            }
            return;
        }
        KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(Long.parseLong(adId)).build(), new KsLoadManager.InterstitialAdListener() { // from class: com.dhylive.app.ad.KsMobImpl.getInterstitialAd.1
            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onRequestResult(int p0) {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onError(int p0, String p1) {
                LogUtils.eTag(KsMobImpl.TAG, "loadInterstitialAd fail code: " + p0 + " msg: " + p1);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onInterstitialAdLoad(List<KsInterstitialAd> interstitialAds) {
                List<KsInterstitialAd> list = interstitialAds;
                if (list == null || list.isEmpty()) {
                    return;
                }
                KsInterstitialAd ksInterstitialAd = interstitialAds.get(0);
                final InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: com.dhylive.app.ad.KsMobImpl$getInterstitialAd$1$onInterstitialAdLoad$1
                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onPageDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onSkippedAd() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayEnd() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayStart() {
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdClicked() {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdClick();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdShow() {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdPlaySuccess();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onAdClosed() {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdClose();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                    public void onVideoPlayError(int p0, int p1) {
                        InterstitialAdListener interstitialAdListener3 = interstitialAdListener2;
                        if (interstitialAdListener3 != null) {
                            interstitialAdListener3.onAdPlayFail();
                        }
                    }
                });
                KsMobInterstitialAd ksMobInterstitialAd = new KsMobInterstitialAd(ksInterstitialAd);
                InterstitialAdListener interstitialAdListener3 = interstitialAdListener;
                if (interstitialAdListener3 != null) {
                    interstitialAdListener3.onAdLoadSuccess(ksMobInterstitialAd);
                }
            }
        });
    }
}
