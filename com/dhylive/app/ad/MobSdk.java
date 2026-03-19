package com.dhylive.app.ad;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.dhylive.app.AppAdConfig;
import com.dhylive.app.ad.impl.BannerAdListenerImpl;
import com.dhylive.app.ad.impl.CustomAdListenerImpl;
import com.dhylive.app.ad.impl.InterstitialAdListenerImpl;
import com.dhylive.app.ad.impl.RewardAdListenerImpl;
import com.dhylive.app.ad.impl.SplashAdListenerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MobSdk.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J8\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J,\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J,\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001f2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J$\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J.\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H&J,\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006)"}, d2 = {"Lcom/dhylive/app/ad/MobSdk;", "", "()V", "isInit", "", "()Z", "getCustomAd", "", "activity", "Landroid/app/Activity;", "adId", "", "customAdListener", "Lcom/dhylive/app/ad/CustomAdListener;", "getInterstitialAd", "interstitialAdListener", "Lcom/dhylive/app/ad/InterstitialAdListener;", "initSdk", "context", "Landroid/content/Context;", "appId", "appKey", "needPermission", "initListener", "Lcom/dhylive/app/ad/MobInitListener;", "loadBannerAd", "container", "Landroid/view/ViewGroup;", "bannerAdListener", "Lcom/dhylive/app/ad/BannerAdListener;", "loadCustomAd", "Landroid/widget/FrameLayout;", "loadInterstitialAd", "loadRewardAd", "orderNo", "rewardAdListener", "Lcom/dhylive/app/ad/RewardAdListener;", "loadSplashAd", "splashAdListener", "Lcom/dhylive/app/ad/SplashAdListener;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class MobSdk {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public abstract void getCustomAd(Activity activity, String adId, CustomAdListener customAdListener);

    public abstract void getInterstitialAd(Activity activity, String adId, InterstitialAdListener interstitialAdListener);

    public abstract void initSdk(Context context, String appId, String appKey, boolean needPermission, MobInitListener initListener);

    public abstract boolean isInit();

    public abstract void loadBannerAd(Activity activity, String adId, ViewGroup container, BannerAdListener bannerAdListener);

    public abstract void loadCustomAd(Activity activity, String adId, FrameLayout container, CustomAdListener customAdListener);

    public abstract void loadInterstitialAd(Activity activity, String adId, InterstitialAdListener interstitialAdListener);

    public abstract void loadRewardAd(Activity activity, String adId, String orderNo, RewardAdListener rewardAdListener);

    public abstract void loadSplashAd(Activity activity, String adId, ViewGroup container, SplashAdListener splashAdListener);

    public static /* synthetic */ void initSdk$default(MobSdk mobSdk, Context context, String str, String str2, boolean z, MobInitListener mobInitListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initSdk");
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            mobInitListener = null;
        }
        mobSdk.initSdk(context, str, str3, z2, mobInitListener);
    }

    public static /* synthetic */ void loadSplashAd$default(MobSdk mobSdk, Activity activity, String str, ViewGroup viewGroup, SplashAdListener splashAdListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSplashAd");
        }
        if ((i & 8) != 0) {
            splashAdListener = new SplashAdListenerImpl();
        }
        mobSdk.loadSplashAd(activity, str, viewGroup, splashAdListener);
    }

    public static /* synthetic */ void loadRewardAd$default(MobSdk mobSdk, Activity activity, String str, String str2, RewardAdListener rewardAdListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadRewardAd");
        }
        if ((i & 8) != 0) {
            rewardAdListener = new RewardAdListenerImpl();
        }
        mobSdk.loadRewardAd(activity, str, str2, rewardAdListener);
    }

    public static /* synthetic */ void loadBannerAd$default(MobSdk mobSdk, Activity activity, String str, ViewGroup viewGroup, BannerAdListener bannerAdListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadBannerAd");
        }
        if ((i & 8) != 0) {
            bannerAdListener = new BannerAdListenerImpl();
        }
        mobSdk.loadBannerAd(activity, str, viewGroup, bannerAdListener);
    }

    public static /* synthetic */ void loadInterstitialAd$default(MobSdk mobSdk, Activity activity, String str, InterstitialAdListener interstitialAdListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadInterstitialAd");
        }
        if ((i & 4) != 0) {
            interstitialAdListener = new InterstitialAdListenerImpl();
        }
        mobSdk.loadInterstitialAd(activity, str, interstitialAdListener);
    }

    public static /* synthetic */ void getInterstitialAd$default(MobSdk mobSdk, Activity activity, String str, InterstitialAdListener interstitialAdListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInterstitialAd");
        }
        if ((i & 4) != 0) {
            interstitialAdListener = new InterstitialAdListenerImpl();
        }
        mobSdk.getInterstitialAd(activity, str, interstitialAdListener);
    }

    public static /* synthetic */ void loadCustomAd$default(MobSdk mobSdk, Activity activity, String str, FrameLayout frameLayout, CustomAdListener customAdListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadCustomAd");
        }
        if ((i & 8) != 0) {
            customAdListener = new CustomAdListenerImpl();
        }
        mobSdk.loadCustomAd(activity, str, frameLayout, customAdListener);
    }

    public static /* synthetic */ void getCustomAd$default(MobSdk mobSdk, Activity activity, String str, CustomAdListener customAdListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCustomAd");
        }
        if ((i & 4) != 0) {
            customAdListener = new CustomAdListenerImpl();
        }
        mobSdk.getCustomAd(activity, str, customAdListener);
    }

    /* compiled from: MobSdk.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/dhylive/app/ad/MobSdk$Companion;", "", "()V", "instance", "Lcom/dhylive/app/ad/MobSdk;", "getInstance", "()Lcom/dhylive/app/ad/MobSdk;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MobSdk getInstance() {
            return AppAdConfig.INSTANCE.getAdSelect() ? SigMobImpl.INSTANCE : GroMobImpl.INSTANCE;
        }
    }
}
