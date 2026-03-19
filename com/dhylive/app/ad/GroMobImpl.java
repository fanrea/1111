package com.dhylive.app.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.bytedance.apm.common.utility.UIUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import com.dhylive.app.ad.info.GroMobCustomAd;
import com.dhylive.app.ad.info.GroMobInterstitialAd;
import com.dhylive.app.ad.info.GroMobRewardAd;
import com.dhylive.app.utils.SPConfig;
import com.kuaishou.weapon.p0.bq;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: GroMobImpl.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J2\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J*\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J*\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020 2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J*\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006)"}, d2 = {"Lcom/dhylive/app/ad/GroMobImpl;", "Lcom/dhylive/app/ad/MobSdk;", "()V", "isInit", "", "()Z", "getCustomAd", "", "activity", "Landroid/app/Activity;", "adId", "", "customAdListener", "Lcom/dhylive/app/ad/CustomAdListener;", "getDramaDrawAd", "getInterstitialAd", "interstitialAdListener", "Lcom/dhylive/app/ad/InterstitialAdListener;", "initSdk", "context", "Landroid/content/Context;", "appId", "appKey", "needPermission", "initListener", "Lcom/dhylive/app/ad/MobInitListener;", "loadBannerAd", "container", "Landroid/view/ViewGroup;", "bannerAdListener", "Lcom/dhylive/app/ad/BannerAdListener;", "loadCustomAd", "Landroid/widget/FrameLayout;", "loadInterstitialAd", "loadRewardAd", "orderNo", "rewardAdListener", "Lcom/dhylive/app/ad/RewardAdListener;", "loadSplashAd", "splashAdListener", "Lcom/dhylive/app/ad/SplashAdListener;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class GroMobImpl extends MobSdk {
    public static final GroMobImpl INSTANCE = new GroMobImpl();

    private GroMobImpl() {
    }

    @Override // com.dhylive.app.ad.MobSdk
    public boolean isInit() {
        return TTAdSdk.isSdkReady();
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void initSdk(Context context, String appId, String appKey, boolean needPermission, final MobInitListener initListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        TTAdSdk.init(context, new TTAdConfig.Builder().appId("5744631").appName("Playlet").titleBarTheme(1).useMediation(true).allowShowNotify(true).supportMultiProcess(true).debug(false).build());
        TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.dhylive.app.ad.GroMobImpl.initSdk.1
            public void success() {
                LogUtils.e("TTAdSdk init success");
                MobInitListener mobInitListener = initListener;
                if (mobInitListener != null) {
                    mobInitListener.onSuccess();
                }
            }

            public void fail(int code, String msg) {
                LogUtils.e("TTAdSdk init fail, code = " + code + " msg = " + msg);
                MobInitListener mobInitListener = initListener;
                if (mobInitListener != null) {
                    mobInitListener.onFail(code, msg);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.dhylive.app.ad.GroMobImpl$loadSplashAd$csjSplashAdShowListener$1] */
    @Override // com.dhylive.app.ad.MobSdk
    public void loadSplashAd(Activity activity, final String adId, final ViewGroup container, final SplashAdListener splashAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Activity activity2 = activity;
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(adId).setImageAcceptedSize(UIUtils.getScreenWidth(activity2), UIUtils.getScreenHeight(activity2)).build();
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity2);
        final ?? r5 = new CSJSplashAd.SplashAdListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadSplashAd$csjSplashAdShowListener$1
            public void onSplashAdShow(CSJSplashAd p0) {
                Intrinsics.checkNotNullParameter(p0, bq.g);
                LogUtils.e("GroMob loadSplashAd onSplashAdShow");
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdLoadSuccess();
                }
            }

            public void onSplashAdClick(CSJSplashAd p0) {
                Intrinsics.checkNotNullParameter(p0, bq.g);
                LogUtils.e("GroMob loadSplashAd onSplashAdClick");
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdClick();
                }
            }

            public void onSplashAdClose(CSJSplashAd p0, int closeType) {
                MediationSplashManager mediationManager;
                Intrinsics.checkNotNullParameter(p0, bq.g);
                if (closeType == 1) {
                    LogUtils.e("开屏广告点击跳过");
                } else if (closeType == 2) {
                    LogUtils.e("开屏广告点击倒计时结束");
                } else if (closeType == 3) {
                    LogUtils.e("点击跳转");
                }
                LogUtils.e("GroMob loadSplashAd onSplashAdClose");
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdClose();
                }
                CSJSplashAd cSJSplashAd = (CSJSplashAd) objectRef.element;
                if (cSJSplashAd == null || (mediationManager = cSJSplashAd.getMediationManager()) == null) {
                    return;
                }
                mediationManager.destroy();
            }
        };
        tTAdNativeCreateAdNative.loadSplashAd(adSlotBuild, new TTAdNative.CSJSplashAdListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadSplashAd$csjSplashAdListener$1
            public void onSplashLoadSuccess(CSJSplashAd ad) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                LogUtils.e("GroMob loadSplashAd onSplashAdLoad");
            }

            public void onSplashLoadFail(CSJAdError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                LogUtils.e("GroMob loadSplashAd onError code = " + error.getCode() + " msg = " + error.getMsg() + ", splashId: " + adId);
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdLoadFail();
                }
            }

            public void onSplashRenderSuccess(CSJSplashAd ad) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                LogUtils.e("GroMob loadSplashAd onSplashRenderSuccess");
                objectRef.element = ad;
                CSJSplashAd cSJSplashAd = (CSJSplashAd) objectRef.element;
                if (cSJSplashAd != null) {
                    cSJSplashAd.setSplashAdListener(r5);
                }
                CSJSplashAd cSJSplashAd2 = (CSJSplashAd) objectRef.element;
                if (cSJSplashAd2 != null) {
                    ViewGroup viewGroup = container;
                    View splashView = cSJSplashAd2.getSplashView();
                    if (splashView != null) {
                        Intrinsics.checkNotNull(splashView);
                        viewGroup.addView(splashView);
                    }
                }
            }

            public void onSplashRenderFail(CSJSplashAd ad, CSJAdError error) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                Intrinsics.checkNotNullParameter(error, "error");
                LogUtils.e("GroMob loadSplashAd onError code = " + error.getCode() + " msg = " + error.getMsg() + ", splashId: " + adId);
                SplashAdListener splashAdListener2 = splashAdListener;
                if (splashAdListener2 != null) {
                    splashAdListener2.onAdLoadFail();
                }
            }
        }, 3500);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.dhylive.app.ad.GroMobImpl$loadRewardAd$rewardAdInteractionListener$1] */
    @Override // com.dhylive.app.ad.MobSdk
    public void loadRewardAd(Activity activity, final String adId, String orderNo, final RewardAdListener rewardAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        HashMap map = new HashMap();
        map.put("pos_id", adId);
        map.put("order_no", String.valueOf(orderNo));
        String json = GsonUtils.toJson(map);
        LogUtils.e(json);
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(adId).setUserID(String.valueOf(SPUtils.getInstance().getLong(SPConfig.KEY_USERID))).setMediaExtra(json).setMediationAdSlot(new MediationAdSlot.Builder().setExtraObject("gromoreExtra", json).build()).setOrientation(1).setAdLoadType(TTAdLoadType.LOAD).build();
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        final ?? r1 = new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadRewardAd$rewardAdInteractionListener$1
            @Deprecated(message = "Deprecated in Java")
            public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int errorCode, String errorMsg) {
            }

            public void onAdShow() {
                MediationRewardManager mediationManager;
                MediationAdEcpmInfo showEcpm;
                LogUtils.e("GroMore loadRewardAd onAdShow");
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) objectRef.element;
                    TTRewardVideoAd tTRewardVideoAd2 = (TTRewardVideoAd) objectRef.element;
                    String sdkName = (tTRewardVideoAd2 == null || (mediationManager = tTRewardVideoAd2.getMediationManager()) == null || (showEcpm = mediationManager.getShowEcpm()) == null) ? null : showEcpm.getSdkName();
                    if (sdkName == null) {
                        sdkName = "";
                    }
                    rewardAdListener2.onAdPlaySuccess(new GroMobRewardAd(tTRewardVideoAd, "gromore", sdkName));
                }
            }

            public void onAdVideoBarClick() {
                LogUtils.e("GroMore loadRewardAd onAdVideoBarClick");
            }

            public void onAdClose() {
                MediationRewardManager mediationManager;
                LogUtils.e("GroMore loadRewardAd onAdClose");
                TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) objectRef.element;
                if (tTRewardVideoAd != null && (mediationManager = tTRewardVideoAd.getMediationManager()) != null) {
                    mediationManager.destroy();
                }
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdClose();
                }
            }

            public void onVideoComplete() {
                LogUtils.e("GroMore loadRewardAd onVideoComplete");
            }

            public void onVideoError() {
                LogUtils.e("GroMore loadRewardAd onVideoError");
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdPlayFail();
                }
            }

            public void onRewardArrived(boolean isRewardValid, int rewardType, Bundle extraInfo) {
                MediationRewardManager mediationManager;
                MediationAdEcpmInfo showEcpm;
                Object[] objArr = new Object[2];
                String sdkName = null;
                objArr[0] = "GroMore loadRewardAd onRewardArrived, extra: " + (extraInfo != null ? extraInfo.toString() : null);
                TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) objectRef.element;
                if (tTRewardVideoAd != null && (mediationManager = tTRewardVideoAd.getMediationManager()) != null && (showEcpm = mediationManager.getShowEcpm()) != null) {
                    sdkName = showEcpm.getSdkName();
                }
                objArr[1] = sdkName;
                LogUtils.e(objArr);
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdReward();
                }
            }

            public void onSkippedVideo() {
                LogUtils.e("GroMore loadRewardAd onSkippedVideo");
            }
        };
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = new TTAdNative.RewardVideoAdListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadRewardAd$rewardVideoAdListener$1
            public void onRewardVideoAdLoad(TTRewardVideoAd ad) {
            }

            @Deprecated(message = "Deprecated in Java")
            public void onRewardVideoCached() {
            }

            public void onError(int code, String message) {
                LogUtils.e("GroMore loadRewardAd onError code = " + code + " msg = " + message + ", rewardId: " + adId);
                RewardAdListener rewardAdListener2 = rewardAdListener;
                if (rewardAdListener2 != null) {
                    rewardAdListener2.onAdLoadFail();
                }
            }

            public void onRewardVideoCached(TTRewardVideoAd ad) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                LogUtils.e("GroMore loadRewardAd onRewardVideoCached");
                objectRef.element = ad;
                TTRewardVideoAd tTRewardVideoAd = (TTRewardVideoAd) objectRef.element;
                if (tTRewardVideoAd != null) {
                    GroMobImpl$loadRewardAd$rewardAdInteractionListener$1 groMobImpl$loadRewardAd$rewardAdInteractionListener$1 = r1;
                    RewardAdListener rewardAdListener2 = rewardAdListener;
                    tTRewardVideoAd.setRewardAdInteractionListener(groMobImpl$loadRewardAd$rewardAdInteractionListener$1);
                    if (rewardAdListener2 != null) {
                        rewardAdListener2.onAdLoadSuccess(new GroMobRewardAd(tTRewardVideoAd, null, null, 6, null));
                    }
                }
            }
        };
        if (tTAdNativeCreateAdNative != null) {
            tTAdNativeCreateAdNative.loadRewardVideoAd(adSlotBuild, rewardVideoAdListener);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.dhylive.app.ad.GroMobImpl$loadBannerAd$expressAdInteractionListener$1] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.dhylive.app.ad.GroMobImpl$loadBannerAd$dislikeInteractionCallback$1] */
    @Override // com.dhylive.app.ad.MobSdk
    public void loadBannerAd(final Activity activity, final String adId, final ViewGroup container, final BannerAdListener bannerAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        container.removeAllViews();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(adId).setImageAcceptedSize(ScreenUtils.getScreenWidth() - SizeUtils.dp2px(24.0f), SizeUtils.dp2px(75.0f)).build();
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        final ?? r3 = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadBannerAd$expressAdInteractionListener$1
            public void onRenderFail(View view, String msg, int code) {
            }

            public void onRenderSuccess(View view, float width, float height) {
            }

            public void onAdClicked(View view, int type) {
                LogUtils.e("GroMore loadBannerAd banner clicked");
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.onAdClick();
                }
            }

            public void onAdShow(View view, int type) {
                LogUtils.e("GroMore loadBannerAd banner show");
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.onAdLoadSuccess();
                }
            }
        };
        final ?? r5 = new TTAdDislike.DislikeInteractionCallback() { // from class: com.dhylive.app.ad.GroMobImpl$loadBannerAd$dislikeInteractionCallback$1
            public void onShow() {
                LogUtils.e("GroMore loadBannerAd banner dislike show");
            }

            public void onSelected(int position, String value, boolean enforce) {
                LogUtils.e("GroMore loadBannerAd banner dislike closed");
                container.removeAllViews();
                container.setVisibility(8);
                TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) objectRef.element;
                if (tTNativeExpressAd != null) {
                    tTNativeExpressAd.destroy();
                }
                objectRef.element = null;
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.onAdClose();
                }
            }

            public void onCancel() {
                LogUtils.e("GroMore loadBannerAd banner dislike cancel");
            }
        };
        TTAdNative.NativeExpressAdListener nativeExpressAdListener = new TTAdNative.NativeExpressAdListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadBannerAd$nativeExpressAdListener$1
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
                List<TTNativeExpressAd> list = ads;
                if (list == null || list.isEmpty()) {
                    return;
                }
                LogUtils.e("GroMore loadBannerAd banner load success: " + ads.size());
                objectRef.element = ads.get(0);
                TTNativeExpressAd tTNativeExpressAd = (TTNativeExpressAd) objectRef.element;
                if (tTNativeExpressAd != null) {
                    tTNativeExpressAd.setExpressInteractionListener(r3);
                }
                TTNativeExpressAd tTNativeExpressAd2 = (TTNativeExpressAd) objectRef.element;
                if (tTNativeExpressAd2 != null) {
                    tTNativeExpressAd2.setDislikeCallback(activity, r5);
                }
                TTNativeExpressAd tTNativeExpressAd3 = (TTNativeExpressAd) objectRef.element;
                View expressAdView = tTNativeExpressAd3 != null ? tTNativeExpressAd3.getExpressAdView() : null;
                if (expressAdView != null) {
                    container.removeAllViews();
                    container.addView(expressAdView);
                    container.setVisibility(0);
                }
            }

            public void onError(int code, String message) {
                LogUtils.e("GroMore loadBannerAd banner load fail: " + code + ", " + message + ", bannerId: " + adId);
                BannerAdListener bannerAdListener2 = bannerAdListener;
                if (bannerAdListener2 != null) {
                    bannerAdListener2.onAdLoadFail();
                }
            }
        };
        if (tTAdNativeCreateAdNative != null) {
            tTAdNativeCreateAdNative.loadBannerExpressAd(adSlotBuild, nativeExpressAdListener);
        }
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.dhylive.app.ad.GroMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1] */
    @Override // com.dhylive.app.ad.MobSdk
    public void loadInterstitialAd(final Activity activity, final String adId, final InterstitialAdListener interstitialAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(adId).setOrientation(1).build();
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        final ?? r5 = new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1
            public void onAdShow() {
                LogUtils.e("GroMore loadInterstitialAd onAdShow");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdPlaySuccess();
                }
            }

            public void onAdVideoBarClick() {
                LogUtils.e("GroMore loadInterstitialAd onAdVideoBarClick");
            }

            public void onAdClose() {
                MediationFullScreenManager mediationManager;
                LogUtils.e("GroMore loadInterstitialAd onAdClose");
                TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) objectRef.element;
                if (tTFullScreenVideoAd != null && (mediationManager = tTFullScreenVideoAd.getMediationManager()) != null) {
                    mediationManager.destroy();
                }
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdClose();
                }
            }

            public void onVideoComplete() {
                LogUtils.e("GroMore loadInterstitialAd onVideoComplete");
            }

            public void onSkippedVideo() {
                LogUtils.e("GroMore loadInterstitialAd onSkippedVideo");
            }
        };
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = new TTAdNative.FullScreenVideoAdListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadInterstitialAd$fullScreenVideoAdListener$1
            public void onError(int code, String message) {
                LogUtils.e("GroMore loadInterstitialAd onError code = " + code + " msg = " + message + ", interstitialId: " + adId);
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadFail();
                }
            }

            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd ad) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                LogUtils.e("GroMore loadInterstitialAd onFullScreenVideoAdLoad");
                objectRef.element = ad;
                TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) objectRef.element;
                if (tTFullScreenVideoAd != null) {
                    GroMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1 groMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1 = r5;
                    Activity activity2 = activity;
                    InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                    if (tTFullScreenVideoAd.getMediationManager().isReady()) {
                        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(groMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1);
                        tTFullScreenVideoAd.showFullScreenVideoAd(activity2);
                        if (interstitialAdListener2 != null) {
                            interstitialAdListener2.onAdLoadSuccess(new GroMobInterstitialAd(tTFullScreenVideoAd));
                            return;
                        }
                        return;
                    }
                    LogUtils.e("GroMore loadInterstitialAd video is not ready");
                }
            }

            @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public void onFullScreenVideoCached() {
                LogUtils.e("GroMore loadInterstitialAd onFullScreenVideoCached");
            }

            public void onFullScreenVideoCached(TTFullScreenVideoAd ad) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                LogUtils.e("GroMore loadInterstitialAd onFullScreenVideoCached");
                objectRef.element = ad;
                TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) objectRef.element;
                if (tTFullScreenVideoAd != null) {
                    GroMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1 groMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1 = r5;
                    Activity activity2 = activity;
                    InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                    if (tTFullScreenVideoAd.getMediationManager().isReady()) {
                        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(groMobImpl$loadInterstitialAd$fullScreenVideoAdInteractionListener$1);
                        tTFullScreenVideoAd.showFullScreenVideoAd(activity2);
                        if (interstitialAdListener2 != null) {
                            interstitialAdListener2.onAdLoadSuccess(new GroMobInterstitialAd(tTFullScreenVideoAd));
                            return;
                        }
                        return;
                    }
                    LogUtils.e("GroMore loadInterstitialAd video is not ready");
                }
            }
        };
        if (tTAdNativeCreateAdNative != null) {
            tTAdNativeCreateAdNative.loadFullScreenVideoAd(adSlotBuild, fullScreenVideoAdListener);
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.dhylive.app.ad.GroMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1] */
    @Override // com.dhylive.app.ad.MobSdk
    public void getInterstitialAd(Activity activity, final String adId, final InterstitialAdListener interstitialAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(adId).setOrientation(1).build();
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        final ?? r2 = new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.dhylive.app.ad.GroMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1
            public void onAdShow() {
                LogUtils.e("GroMore loadInterstitialAd onAdShow");
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdPlaySuccess();
                }
            }

            public void onAdVideoBarClick() {
                LogUtils.e("GroMore loadInterstitialAd onAdVideoBarClick");
            }

            public void onAdClose() {
                MediationFullScreenManager mediationManager;
                LogUtils.e("GroMore loadInterstitialAd onAdClose");
                TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) objectRef.element;
                if (tTFullScreenVideoAd != null && (mediationManager = tTFullScreenVideoAd.getMediationManager()) != null) {
                    mediationManager.destroy();
                }
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdClose();
                }
            }

            public void onVideoComplete() {
                LogUtils.e("GroMore loadInterstitialAd onVideoComplete");
            }

            public void onSkippedVideo() {
                LogUtils.e("GroMore loadInterstitialAd onSkippedVideo");
            }
        };
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = new TTAdNative.FullScreenVideoAdListener() { // from class: com.dhylive.app.ad.GroMobImpl$getInterstitialAd$fullScreenVideoAdListener$1
            public void onError(int code, String message) {
                LogUtils.e("GroMore loadInterstitialAd onError code = " + code + " msg = " + message + ", interstitialId: " + adId);
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdLoadFail();
                }
            }

            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd ad) {
                LogUtils.e("GroMore loadInterstitialAd onFullScreenVideoAdLoad");
                objectRef.element = ad;
                TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) objectRef.element;
                if (tTFullScreenVideoAd != null) {
                    GroMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1 groMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1 = r2;
                    InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                    if (tTFullScreenVideoAd.getMediationManager().isReady()) {
                        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(groMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1);
                        if (interstitialAdListener2 != null) {
                            interstitialAdListener2.onAdLoadSuccess(new GroMobInterstitialAd(tTFullScreenVideoAd));
                            return;
                        }
                        return;
                    }
                    LogUtils.e("GroMore loadInterstitialAd video is not ready");
                }
            }

            @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public void onFullScreenVideoCached() {
                LogUtils.e("GroMore loadInterstitialAd onFullScreenVideoCached");
            }

            public void onFullScreenVideoCached(TTFullScreenVideoAd ad) {
                LogUtils.e("GroMore loadInterstitialAd onFullScreenVideoCached");
                objectRef.element = ad;
                TTFullScreenVideoAd tTFullScreenVideoAd = (TTFullScreenVideoAd) objectRef.element;
                if (tTFullScreenVideoAd != null) {
                    GroMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1 groMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1 = r2;
                    InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                    if (tTFullScreenVideoAd.getMediationManager().isReady()) {
                        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(groMobImpl$getInterstitialAd$fullScreenVideoAdInteractionListener$1);
                        if (interstitialAdListener2 != null) {
                            interstitialAdListener2.onAdLoadSuccess(new GroMobInterstitialAd(tTFullScreenVideoAd));
                            return;
                        }
                        return;
                    }
                    LogUtils.e("GroMore loadInterstitialAd video is not ready");
                }
            }
        };
        if (tTAdNativeCreateAdNative != null) {
            tTAdNativeCreateAdNative.loadFullScreenVideoAd(adSlotBuild, fullScreenVideoAdListener);
        }
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void loadCustomAd(final Activity activity, final String adId, final FrameLayout container, final CustomAdListener customAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(container, "container");
        TTAdSdk.getAdManager().createAdNative(activity).loadFeedAd(new AdSlot.Builder().setCodeId(adId).setImageAcceptedSize(SizeUtils.dp2px(300.0f), SizeUtils.dp2px(200.0f)).setAdCount(1).setMediationAdSlot(new MediationAdSlot.Builder().setExtraObject("key_gdt_video_option", new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(1).build()).setExtraObject("key_baidu_request_parameters", new RequestParameters.Builder().downloadAppConfirmPolicy(2).build()).setExtraObject("key_baidu_cache_video_only_wifi", true).setExtraObject("key_gdt_min_video_duration", 1000).setExtraObject("key_gdt_max_video_duration", 2000).setExtraObject("key_gdt_down_app_config_policy", DownAPPConfirmPolicy.NOConfirm).build()).build(), new TTAdNative.FeedAdListener() { // from class: com.dhylive.app.ad.GroMobImpl.loadCustomAd.1
            public void onError(int code, String msg) {
                LogUtils.e("GroMore loadCustomAd onError code = " + code + " msg = " + msg + ", customId: " + adId);
                CustomAdListener customAdListener2 = customAdListener;
                if (customAdListener2 != null) {
                    customAdListener2.onAdLoadFail();
                }
            }

            public void onFeedAdLoad(List<TTFeedAd> ads) {
                List<TTFeedAd> list = ads;
                if (list == null || list.isEmpty()) {
                    return;
                }
                final TTNativeAd tTNativeAd = (TTFeedAd) ads.get(0);
                Activity activity2 = activity;
                final CustomAdListener customAdListener2 = customAdListener;
                tTNativeAd.setDislikeCallback(activity2, new TTAdDislike.DislikeInteractionCallback() { // from class: com.dhylive.app.ad.GroMobImpl$loadCustomAd$1$onFeedAdLoad$1
                    public void onCancel() {
                    }

                    public void onShow() {
                    }

                    public void onSelected(int p0, String p1, boolean p2) {
                        tTNativeAd.destroy();
                        CustomAdListener customAdListener3 = customAdListener2;
                        if (customAdListener3 != null) {
                            customAdListener3.onAdClose();
                        }
                    }
                });
                if (tTNativeAd.getMediationManager().isExpress()) {
                    final FrameLayout frameLayout = container;
                    final CustomAdListener customAdListener3 = customAdListener;
                    tTNativeAd.setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.dhylive.app.ad.GroMobImpl$loadCustomAd$1$onFeedAdLoad$2
                        public void onRenderFail(View p0, String p1, int p2) {
                        }

                        public void onRenderSuccess(View p0, float p1, float p2, boolean p3) {
                            View adView = tTNativeAd.getAdView();
                            frameLayout.removeAllViews();
                            frameLayout.addView(adView);
                            frameLayout.setVisibility(0);
                        }

                        public void onAdClick() {
                            CustomAdListener customAdListener4 = customAdListener3;
                            if (customAdListener4 != null) {
                                customAdListener4.onAdClick();
                            }
                        }

                        public void onAdShow() {
                            CustomAdListener customAdListener4 = customAdListener3;
                            if (customAdListener4 != null) {
                                customAdListener4.onAdShow();
                            }
                        }
                    });
                    tTNativeAd.render();
                } else {
                    LogUtils.e("GroMore loadCustomAd not support");
                }
                CustomAdListener customAdListener4 = customAdListener;
                if (customAdListener4 != null) {
                    customAdListener4.onAdLoadSuccess(new GroMobCustomAd(tTNativeAd));
                }
            }
        });
    }

    @Override // com.dhylive.app.ad.MobSdk
    public void getCustomAd(final Activity activity, final String adId, final CustomAdListener customAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        TTAdSdk.getAdManager().createAdNative(activity).loadFeedAd(new AdSlot.Builder().setCodeId(adId).setImageAcceptedSize(SizeUtils.dp2px(300.0f), SizeUtils.dp2px(200.0f)).setAdCount(1).setMediationAdSlot(new MediationAdSlot.Builder().setExtraObject("key_gdt_video_option", new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(1).build()).setExtraObject("key_baidu_request_parameters", new RequestParameters.Builder().downloadAppConfirmPolicy(2).build()).setExtraObject("key_baidu_cache_video_only_wifi", true).setExtraObject("key_gdt_min_video_duration", 1000).setExtraObject("key_gdt_max_video_duration", 2000).setExtraObject("key_gdt_down_app_config_policy", DownAPPConfirmPolicy.NOConfirm).build()).build(), new TTAdNative.FeedAdListener() { // from class: com.dhylive.app.ad.GroMobImpl.getCustomAd.1
            public void onError(int code, String msg) {
                LogUtils.e("GroMore loadCustomAd onError code = " + code + " msg = " + msg + ", customId: " + adId);
                CustomAdListener customAdListener2 = customAdListener;
                if (customAdListener2 != null) {
                    customAdListener2.onAdLoadFail();
                }
            }

            public void onFeedAdLoad(List<TTFeedAd> ads) {
                List<TTFeedAd> list = ads;
                if (list == null || list.isEmpty()) {
                    return;
                }
                final TTNativeAd tTNativeAd = (TTFeedAd) ads.get(0);
                Activity activity2 = activity;
                final CustomAdListener customAdListener2 = customAdListener;
                tTNativeAd.setDislikeCallback(activity2, new TTAdDislike.DislikeInteractionCallback() { // from class: com.dhylive.app.ad.GroMobImpl$getCustomAd$1$onFeedAdLoad$1
                    public void onCancel() {
                    }

                    public void onShow() {
                    }

                    public void onSelected(int p0, String p1, boolean p2) {
                        tTNativeAd.destroy();
                        CustomAdListener customAdListener3 = customAdListener2;
                        if (customAdListener3 != null) {
                            customAdListener3.onAdClose();
                        }
                    }
                });
                if (tTNativeAd.getMediationManager().isExpress()) {
                    final CustomAdListener customAdListener3 = customAdListener;
                    tTNativeAd.setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.dhylive.app.ad.GroMobImpl$getCustomAd$1$onFeedAdLoad$2
                        public void onRenderFail(View p0, String p1, int p2) {
                        }

                        public void onRenderSuccess(View p0, float p1, float p2, boolean p3) {
                        }

                        public void onAdClick() {
                            CustomAdListener customAdListener4 = customAdListener3;
                            if (customAdListener4 != null) {
                                customAdListener4.onAdClick();
                            }
                        }

                        public void onAdShow() {
                            CustomAdListener customAdListener4 = customAdListener3;
                            if (customAdListener4 != null) {
                                customAdListener4.onAdShow();
                            }
                        }
                    });
                    tTNativeAd.render();
                } else {
                    LogUtils.e("GroMore loadCustomAd not support");
                }
                CustomAdListener customAdListener4 = customAdListener;
                if (customAdListener4 != null) {
                    customAdListener4.onAdLoadSuccess(new GroMobCustomAd(tTNativeAd));
                }
            }
        });
    }

    public final void getDramaDrawAd(final Activity activity, final String adId, final CustomAdListener customAdListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adId, "adId");
        TTAdSdk.getAdManager().createAdNative(activity).loadDrawFeedAd(new AdSlot.Builder().setCodeId(adId).setImageAcceptedSize(ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight()).setAdCount(1).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(false).build()).build(), new TTAdNative.DrawFeedAdListener() { // from class: com.dhylive.app.ad.GroMobImpl.getDramaDrawAd.1
            public void onError(int code, String msg) {
                LogUtils.e("GroMore loadCustomAd onError code = " + code + " msg = " + msg + ", customId: " + adId);
                CustomAdListener customAdListener2 = customAdListener;
                if (customAdListener2 != null) {
                    customAdListener2.onAdLoadFail();
                }
            }

            public void onDrawFeedAdLoad(List<? extends TTDrawFeedAd> ads) {
                List<? extends TTDrawFeedAd> list = ads;
                if (list == null || list.isEmpty()) {
                    return;
                }
                final TTNativeAd tTNativeAd = (TTDrawFeedAd) ads.get(0);
                Activity activity2 = activity;
                final CustomAdListener customAdListener2 = customAdListener;
                tTNativeAd.setDislikeCallback(activity2, new TTAdDislike.DislikeInteractionCallback() { // from class: com.dhylive.app.ad.GroMobImpl$getDramaDrawAd$1$onDrawFeedAdLoad$1
                    public void onCancel() {
                    }

                    public void onShow() {
                    }

                    public void onSelected(int p0, String p1, boolean p2) {
                        tTNativeAd.destroy();
                        CustomAdListener customAdListener3 = customAdListener2;
                        if (customAdListener3 != null) {
                            customAdListener3.onAdClose();
                        }
                    }
                });
                CustomAdListener customAdListener3 = customAdListener;
                if (customAdListener3 != null) {
                    customAdListener3.onAdLoadSuccess(new GroMobCustomAd(tTNativeAd));
                }
            }
        });
    }
}
