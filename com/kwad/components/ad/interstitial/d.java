package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.proxy.g;
import com.kwad.components.core.widget.h;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends g {
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private com.kwad.components.ad.interstitial.h.a mD;
    private boolean mE;
    private com.kwad.components.ad.interstitial.g.b mF;
    private final KsAdVideoPlayConfig mG;
    private KsInterstitialAd.AdInteractionListener mH;
    private final h mI;
    private bw mTimerHelper;

    @Override // com.kwad.components.core.proxy.g
    public final float dA() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mH = adInteractionListener;
        com.kwad.components.ad.interstitial.h.a aVar = this.mD;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }

    public final bw getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bw();
        }
        return this.mTimerHelper;
    }

    public d(Activity activity, AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.mI = new h() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.h
            public final void k(boolean z) {
                if (d.this.mE) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.c.b.aaf();
                    if (activity2 == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.adlog.c.j(d.this.mAdTemplate, z ? 2 : 1);
                        d.this.dC();
                    }
                }
            }
        };
        this.mH = adInteractionListener;
        this.mG = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.dM()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dB() {
        com.kwad.components.core.widget.g gVar = new com.kwad.components.core.widget.g(this.mContext);
        gVar.setOrientationChangeListener(this.mI);
        return gVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        com.kwad.components.core.e.a.h.a(getWindow());
        dC();
        com.kwad.components.ad.interstitial.report.c.eX().B(this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.ca(this.mAdTemplate);
    }

    private static boolean e(AdResultData adResultData) {
        return com.kwad.sdk.core.response.b.c.v(adResultData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC() {
        com.kwad.components.ad.interstitial.h.a cVar;
        if (e(this.mAdResultData)) {
            cVar = new com.kwad.components.ad.interstitial.aggregate.b(this.mContext);
        } else {
            cVar = new com.kwad.components.ad.interstitial.h.c(this.mContext);
        }
        com.kwad.components.ad.interstitial.h.a aVar = cVar;
        this.mD = aVar;
        aVar.a(this.mAdResultData, this, this.mG, this.mH, 0);
        this.Eu.removeAllViews();
        this.Eu.addView(this.mD);
        dD();
    }

    private void dD() {
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(this.mD, 100);
        this.mF = bVar;
        bVar.a(new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                d.this.getTimerHelper().AG();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                d.this.getTimerHelper().AH();
            }
        });
        this.mF.wK();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.g.b bVar = this.mF;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mE = z;
        com.kwad.components.ad.interstitial.h.a aVar = this.mD;
        if (aVar != null) {
            if (z) {
                aVar.dF();
            } else {
                aVar.dG();
            }
        }
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            com.kwad.sdk.a.a.c.VC().VE();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.mH;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            com.kwad.components.ad.interstitial.h.a aVar = this.mD;
            if ((aVar instanceof com.kwad.components.ad.interstitial.h.c) && !((com.kwad.components.ad.interstitial.h.c) aVar).fi() && com.kwad.sdk.core.response.b.a.dg(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))) {
                com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
            }
            com.kwad.components.core.e.a.h.oZ();
            com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.bt(this.mAdTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.dQ()) {
            super.onBackPressed();
        }
    }
}
