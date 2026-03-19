package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator;
import com.kwad.components.ad.interstitial.aggregate.a;
import com.kwad.components.core.widget.a.c;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.aq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.interstitial.h.a {
    private c gR;
    private final com.kwad.sdk.core.j.c gZ;
    protected AdResultData mAdResultData;
    private final List<AdTemplate> mAdTemplateList;
    protected KsInterstitialAd.AdInteractionListener mH;
    private final View mRootView;
    private TransViewPager mT;
    private a mU;
    private ViewPagerIndicator mV;
    private ValueAnimator mW;
    private boolean mX;
    private int mY;
    private int mZ;
    private boolean na;
    private final ViewPager.OnPageChangeListener nb;

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dF() {
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dG() {
    }

    public b(Context context) {
        this(context, null);
    }

    private b(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.mAdTemplateList = new ArrayList();
        this.mY = 10;
        this.mZ = 0;
        this.gZ = new d() { // from class: com.kwad.components.ad.interstitial.aggregate.b.6
            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void by() {
                super.by();
                if (Build.VERSION.SDK_INT >= 19 && b.this.mX) {
                    if (b.this.mV != null) {
                        b.this.mV.dL();
                    }
                    if (b.this.mW != null) {
                        b.this.mW.resume();
                    }
                    b.this.mX = false;
                }
            }

            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void bz() {
                super.bz();
                if (Build.VERSION.SDK_INT >= 19 && !b.this.mX) {
                    if (b.this.mV != null) {
                        b.this.mV.dK();
                    }
                    if (b.this.mW != null) {
                        b.this.mW.pause();
                    }
                    b.this.mX = true;
                }
            }
        };
        this.nb = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.7
            private int ne = 0;

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                com.kwad.components.ad.interstitial.h.c cVarJ = b.this.mT.J(i);
                if (cVarJ != null) {
                    cVarJ.ff();
                }
                if (this.ne != i) {
                    com.kwad.sdk.core.adlog.c.a((AdTemplate) b.this.mAdTemplateList.get(this.ne), -1L, (JSONObject) null);
                    com.kwad.components.ad.interstitial.h.c cVarJ2 = b.this.mT.J(this.ne);
                    if (cVarJ2 != null) {
                        cVarJ2.fg();
                    }
                }
                this.ne = i;
            }
        };
        this.mContext = context;
        this.mRootView = m.inflate(context, R.layout.ksad_interstitial_multi_ad, this);
        initView();
    }

    private void initView() {
        this.mT = (TransViewPager) this.mRootView.findViewById(R.id.ksad_multi_ad_container);
        this.mV = (ViewPagerIndicator) this.mRootView.findViewById(R.id.ksad_multi_ad_indicator);
        this.gR = new c(this.mRootView, 100);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i) {
        this.mAdResultData = adResultData;
        this.mY = g(adResultData);
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(this.mAdResultData.getAdTemplateList());
        this.mZ = this.mAdTemplateList.size();
        this.mH = adInteractionListener;
        a aVar = new a(this.mAdResultData, dVar, ksAdVideoPlayConfig, adInteractionListener);
        this.mU = aVar;
        aVar.a(new a.b() { // from class: com.kwad.components.ad.interstitial.aggregate.b.1
            @Override // com.kwad.components.ad.interstitial.aggregate.a.b
            public final void a(com.kwad.components.ad.interstitial.h.c cVar, int i2) {
                b.this.mT.a(i2, cVar);
            }
        });
        this.mU.a(new a.InterfaceC0416a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.2
            @Override // com.kwad.components.ad.interstitial.aggregate.a.InterfaceC0416a
            public final void dE() {
                if (b.this.mW != null) {
                    b.this.mW.cancel();
                }
                b.this.mV.setPlayProgressListener(null);
                b.this.mV.setVisibility(8);
            }
        });
        this.mT.setAdapter(this.mU);
        this.mT.setScrollable(false);
        this.mT.setOffscreenPageLimit(this.mAdTemplateList.size() - 1);
        this.mT.addOnPageChangeListener(this.nb);
        this.mU.e(this.mAdTemplateList);
        this.mU.notifyDataSetChanged();
        this.gR.a(this.gZ);
        this.gR.wK();
        if (this.mV == null) {
            return;
        }
        dH();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mV.getLayoutParams();
        if (marginLayoutParams != null) {
            this.na = aq.apb();
            marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, this.na ? 12.0f : 6.0f);
            this.mV.setLayoutParams(marginLayoutParams);
        }
        this.mV.setAdShowTime(this.mY);
        this.mV.setVisibility(0);
        this.mV.setViewPager(this.mT);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mH = adInteractionListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gR.b(this.gZ);
        this.gR.wL();
        this.mAdTemplateList.clear();
        this.mT.clearOnPageChangeListeners();
    }

    private void dH() {
        this.mV.setPlayProgressListener(new ViewPagerIndicator.a() { // from class: com.kwad.components.ad.interstitial.aggregate.b.3
            @Override // com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.a
            public final void I(int i) {
                b.this.H(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final int i) {
        final int width = getWidth();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, width);
        this.mW = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(800L);
        this.mW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (i < b.this.mZ - 1) {
                    int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    b.this.mT.scrollTo((i * width) + iIntValue, 0);
                    b.this.mT.onPageScrolled(i + 1, iIntValue / width, 0);
                }
            }
        });
        this.mW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (i < b.this.mZ - 1) {
                    b.this.mT.setCurrentItem(i + 1);
                }
            }
        });
        this.mW.start();
    }

    private static int g(AdResultData adResultData) {
        AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfoU;
        if (adResultData == null || (cycleAggregationInfoU = com.kwad.sdk.core.response.b.c.u(adResultData)) == null) {
            return 10;
        }
        return cycleAggregationInfoU.cycleAggregationInterval;
    }
}
