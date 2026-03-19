package com.alliance.ssp.ad.d0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.alliance.ssp.ad.api.BaseAdLoadListener;
import com.alliance.ssp.ad.api.SAAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
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
import com.alliance.ssp.ad.impl.expressfeed.NMExpressFeedAdImpl;
import com.alliance.ssp.ad.impl.splash.NMSplashAdImpl;
import com.alliance.ssp.ad.o0.i;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.template.SAAllianceContainerView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;

/* compiled from: SAAllianceAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g implements SAAllianceAd {
    public WeakReference<Activity> a;
    public com.alliance.ssp.ad.impl.banner.a b;
    public com.alliance.ssp.ad.impl.interstitial.a c;
    public com.alliance.ssp.ad.impl.reward.a d;
    public NMSplashAdImpl e;
    public NMExpressFeedAdImpl f;
    public com.alliance.ssp.ad.a0.b g;
    public com.alliance.ssp.ad.x.c h;

    public g(Activity activity) {
        this.a = null;
        if (com.alliance.ssp.ad.h0.a.a(activity)) {
            return;
        }
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.a = weakReference;
        com.alliance.ssp.ad.h0.a.a(weakReference.get());
    }

    public final void a(int i, Activity activity, ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMExpressFeedAdImpl nMExpressFeedAdImpl;
        if (i == 1) {
            NMSplashAdImpl nMSplashAdImpl = this.e;
            if (nMSplashAdImpl != null) {
                nMSplashAdImpl.getClass();
                nMSplashAdImpl.T = "" + viewGroup.getWidth();
                nMSplashAdImpl.U = com.alliance.ssp.ad.a.b.a("").append(viewGroup.getHeight()).toString();
                int i2 = l.a;
                nMSplashAdImpl.y1 = viewGroup;
                Context contextA = com.alliance.ssp.ad.o0.b.a(nMSplashAdImpl.f);
                try {
                    SAAllianceContainerView sAAllianceContainerView = new SAAllianceContainerView(contextA, nMSplashAdImpl.D0);
                    viewGroup.addView(sAAllianceContainerView);
                    FrameLayout frameLayout = new FrameLayout(contextA);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    sAAllianceContainerView.addView(frameLayout);
                    nMSplashAdImpl.F0 = frameLayout;
                    frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new com.alliance.ssp.ad.z.f(nMSplashAdImpl));
                } catch (Exception e) {
                    new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMSplashAdImpl 008: ")), e);
                }
                com.alliance.ssp.ad.impl.splash.b bVar = new com.alliance.ssp.ad.impl.splash.b(nMSplashAdImpl, Looper.getMainLooper());
                nMSplashAdImpl.k1 = bVar;
                bVar.sendEmptyMessageDelayed(0, 50L);
                int i3 = l.a;
                nMSplashAdImpl.A();
                return;
            }
            return;
        }
        if (i == 4) {
            com.alliance.ssp.ad.impl.banner.a aVar = this.b;
            if (aVar == null || Build.VERSION.SDK_INT < 17) {
                return;
            }
            aVar.b1 = viewGroup;
            aVar.a(viewGroup);
            aVar.b1.getViewTreeObserver().addOnGlobalLayoutListener(new com.alliance.ssp.ad.u.e(aVar));
            Handler handler = aVar.e1;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 50L);
            }
            aVar.A();
            aVar.T = "" + viewGroup.getWidth();
            aVar.U = com.alliance.ssp.ad.a.b.a("").append(viewGroup.getHeight()).toString();
            int i4 = l.a;
            return;
        }
        if (i == 5) {
            com.alliance.ssp.ad.impl.interstitial.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.E0 = activity;
                com.alliance.ssp.ad.w.h hVar = new com.alliance.ssp.ad.w.h(aVar2, Looper.getMainLooper());
                aVar2.C1 = hVar;
                hVar.sendEmptyMessageDelayed(0, 50L);
                int i5 = l.a;
                aVar2.A();
                return;
            }
            return;
        }
        if (i != 6) {
            if (i != 3 || (nMExpressFeedAdImpl = this.f) == null) {
                return;
            }
            nMExpressFeedAdImpl.getClass();
            int i6 = l.a;
            return;
        }
        com.alliance.ssp.ad.impl.reward.a aVar3 = this.d;
        if (aVar3 != null) {
            aVar3.getClass();
            int i7 = l.a;
            aVar3.L0 = activity;
            com.alliance.ssp.ad.y.c cVar = new com.alliance.ssp.ad.y.c(aVar3, Looper.getMainLooper());
            aVar3.O0 = cVar;
            cVar.sendEmptyMessageDelayed(0, 50L);
            aVar3.A();
        }
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSABannerAd(SAAllianceAdParams sAAllianceAdParams, ViewGroup viewGroup, SABannerAdLoadListener sABannerAdLoadListener) {
        a(sAAllianceAdParams, 4, 0, -1, viewGroup, sABannerAdLoadListener);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSAExpressFeedAd(SAAllianceAdParams sAAllianceAdParams, ViewGroup viewGroup, SAExpressFeedAdLoadListener sAExpressFeedAdLoadListener) {
        a(sAAllianceAdParams, 3, 0, -1, (ViewGroup) null, sAExpressFeedAdLoadListener);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSAInterstitialAd(SAAllianceAdParams sAAllianceAdParams, SAInterstitialAdLoadListener sAInterstitialAdLoadListener) {
        a(sAAllianceAdParams, 5, 0, -1, (ViewGroup) null, sAInterstitialAdLoadListener);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSANativeFeedAd(SAAllianceAdParams sAAllianceAdParams, SANativeFeedAdLoadListener sANativeFeedAdLoadListener) {
        Log.i("ADallianceLog", "dealNativeFeedAd load");
        new com.alliance.ssp.ad.x.c(3, this.a, sAAllianceAdParams, sANativeFeedAdLoadListener, this);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSARewardAd(SAAllianceAdParams sAAllianceAdParams, SARewardVideoAdLoadListener sARewardVideoAdLoadListener) {
        a(sAAllianceAdParams, 6, 0, -1, (ViewGroup) null, sARewardVideoAdLoadListener);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSASplashAd(SAAllianceAdParams sAAllianceAdParams, ViewGroup viewGroup, int i, SASplashAdLoadListener sASplashAdLoadListener) {
        a(sAAllianceAdParams, 1, 0, i, viewGroup, sASplashAdLoadListener);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSAStreamAd(SAAllianceAdParams sAAllianceAdParams, SAStreamAdLoadListener sAStreamAdLoadListener) {
        a(sAAllianceAdParams, 2, 0, -1, (ViewGroup) null, sAStreamAdLoadListener);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void loadSAUnifiedFeedAd(SAAllianceAdParams sAAllianceAdParams, SAUnifiedFeedAdLoadListener sAUnifiedFeedAdLoadListener) {
        a(sAAllianceAdParams, 3, 1, -1, (ViewGroup) null, sAUnifiedFeedAdLoadListener);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void notifyBiddingLose(float f, CurrencyEnum currencyEnum, AdnTypeEnum adnTypeEnum, LoseReasonEnum loseReasonEnum, HashMap<String, Object> map) {
        if (currencyEnum == null) {
            try {
                currencyEnum = CurrencyEnum.CNY;
            } catch (Exception unused) {
                return;
            }
        }
        if (adnTypeEnum == null) {
            adnTypeEnum = AdnTypeEnum.OTHER_ADN;
        }
        if (loseReasonEnum == null) {
            loseReasonEnum = LoseReasonEnum.OTHER;
        }
        a(false, f, currencyEnum.ordinal(), adnTypeEnum.ordinal(), loseReasonEnum.ordinal(), map);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void notifyBiddingWin(float f, CurrencyEnum currencyEnum, AdnTypeEnum adnTypeEnum, HashMap<String, Object> map) {
        if (currencyEnum == null) {
            try {
                currencyEnum = CurrencyEnum.CNY;
            } catch (Exception unused) {
                return;
            }
        }
        if (adnTypeEnum == null) {
            adnTypeEnum = AdnTypeEnum.OTHER_ADN;
        }
        a(true, f, currencyEnum.ordinal(), adnTypeEnum.ordinal(), -1, map);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void onActivityDestroy() {
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void onActivityResume() {
        NMSplashAdImpl nMSplashAdImpl = this.e;
        if (nMSplashAdImpl != null) {
            nMSplashAdImpl.getClass();
            int i = l.a;
        }
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.c;
        if (aVar != null) {
            aVar.F();
        }
        NMExpressFeedAdImpl nMExpressFeedAdImpl = this.f;
        if (nMExpressFeedAdImpl != null) {
            nMExpressFeedAdImpl.n();
        }
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void onActivityStop() {
        NMSplashAdImpl nMSplashAdImpl = this.e;
        if (nMSplashAdImpl != null) {
            nMSplashAdImpl.getClass();
            int i = l.a;
        }
        com.alliance.ssp.ad.impl.interstitial.a aVar = this.c;
        if (aVar != null) {
            aVar.o();
        }
        NMExpressFeedAdImpl nMExpressFeedAdImpl = this.f;
        if (nMExpressFeedAdImpl != null) {
            nMExpressFeedAdImpl.o();
        }
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void reportBiddingSucceed(boolean z) {
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void showBanner(ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(4, null, viewGroup);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    @Deprecated
    public void showFeedAd(ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(3, null, viewGroup);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void showInterstitial(Activity activity) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(5, activity, null);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void showRewardAd(Activity activity) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(6, activity, null);
    }

    @Override // com.alliance.ssp.ad.api.SAAllianceAd
    public void showSplash(ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        a(1, null, viewGroup);
    }

    public void a(boolean z, float f, int i, int i2, int i3, HashMap<String, Object> map) {
        try {
            com.alliance.ssp.ad.impl.interstitial.a aVar = this.c;
            if (aVar != null) {
                aVar.a(z, f, i, i2, i3, map);
            } else {
                NMSplashAdImpl nMSplashAdImpl = this.e;
                if (nMSplashAdImpl != null) {
                    nMSplashAdImpl.a(z, f, i, i2, i3, map);
                } else {
                    com.alliance.ssp.ad.impl.banner.a aVar2 = this.b;
                    if (aVar2 != null) {
                        aVar2.a(z, f, i, i2, i3, map);
                    } else {
                        com.alliance.ssp.ad.impl.reward.a aVar3 = this.d;
                        if (aVar3 != null) {
                            aVar3.a(z, f, i, i2, i3, map);
                        } else {
                            com.alliance.ssp.ad.x.c cVar = this.h;
                            if (cVar != null) {
                                cVar.a(z, f, i, i2, i3, map);
                            } else {
                                NMExpressFeedAdImpl nMExpressFeedAdImpl = this.f;
                                if (nMExpressFeedAdImpl != null) {
                                    nMExpressFeedAdImpl.a(z, f, i, i2, i3, map);
                                } else {
                                    com.alliance.ssp.ad.a0.b bVar = this.g;
                                    if (bVar != null) {
                                        bVar.a(z, f, i, i2, i3, map);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams, int i, int i2, int i3, ViewGroup viewGroup, BaseAdLoadListener baseAdLoadListener) {
        String str = i.a;
        if (str != null && !str.isEmpty()) {
            if (sAAllianceAdParams.getPosId() == null || sAAllianceAdParams.getPosId().isEmpty()) {
                com.alliance.ssp.ad.t.i.a(InputDeviceCompat.SOURCE_TOUCHSCREEN, "请求失败，请检查是否设置代码位ID。");
                baseAdLoadListener.onError(InputDeviceCompat.SOURCE_TOUCHSCREEN, "请求失败，请检查是否设置代码位ID。");
                return;
            }
            if (i2 == 1) {
                if (i == 3) {
                    Log.i("ADallianceLog", "dealUnifiedFeedAd load");
                    new com.alliance.ssp.ad.b0.b(7, this.a, sAAllianceAdParams, (SAUnifiedFeedAdLoadListener) baseAdLoadListener, this);
                    return;
                }
                return;
            }
            if (i2 == 0) {
                if (i == 1) {
                    Log.i("ADallianceLog", "dealSplashAd load");
                    new NMSplashAdImpl(1, this.a, viewGroup, i3, sAAllianceAdParams, (SASplashAdLoadListener) baseAdLoadListener, this);
                    return;
                }
                if (i == 4) {
                    Log.i("ADallianceLog", "dealBannerAd load");
                    new com.alliance.ssp.ad.impl.banner.a(4, this.a, viewGroup, sAAllianceAdParams, (SABannerAdLoadListener) baseAdLoadListener, this);
                    return;
                }
                if (i == 3) {
                    Log.i("ADallianceLog", "dealExpressFeedAd load");
                    new NMExpressFeedAdImpl(3, this.a, sAAllianceAdParams, (SAExpressFeedAdLoadListener) baseAdLoadListener, this);
                    return;
                }
                if (i == 5) {
                    Log.i("ADallianceLog", "dealInterstitialAd load");
                    new com.alliance.ssp.ad.impl.interstitial.a(5, this.a, sAAllianceAdParams, (SAInterstitialAdLoadListener) baseAdLoadListener, this);
                    return;
                } else if (i == 6) {
                    Log.i("ADallianceLog", "dealRewardAd load");
                    new com.alliance.ssp.ad.impl.reward.a(6, this.a, sAAllianceAdParams, (SARewardVideoAdLoadListener) baseAdLoadListener, this);
                    return;
                } else {
                    if (i == 2) {
                        Log.i("ADallianceLog", "dealStreamAd load");
                        new com.alliance.ssp.ad.a0.b(2, this.a, sAAllianceAdParams, (SAStreamAdLoadListener) baseAdLoadListener, this);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        com.alliance.ssp.ad.t.i.a(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, "请求失败，请检查是否初始化SDK。");
        baseAdLoadListener.onError(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, "请求失败，请检查是否初始化SDK。");
    }
}
