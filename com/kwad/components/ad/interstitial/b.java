package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private com.kwad.components.core.internal.api.c dl;
    private d mA;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    private c mz;

    public b(AdResultData adResultData) {
        super(adResultData);
        this.dl = new com.kwad.components.core.internal.api.c();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        com.kwad.components.ad.interstitial.report.c.eX().z(this.mAdTemplate);
        if (com.kwad.sdk.core.config.e.XF() && (activity == null || activity.isFinishing())) {
            com.kwad.sdk.core.c.b.aaf();
            activity = com.kwad.sdk.core.c.b.getCurrentActivity();
        }
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd activity must not be null");
            com.kwad.components.ad.interstitial.report.realtime.a.fb();
            com.kwad.components.ad.interstitial.report.realtime.a.H(this.mAdTemplate);
            com.kwad.components.ad.interstitial.report.c.eX().a(this.mAdTemplate, com.kwad.sdk.core.network.e.bCE.errorCode, com.kwad.sdk.core.network.e.bCE.msg);
            return;
        }
        if (!l.UL().TT()) {
            com.kwad.components.ad.interstitial.report.c.eX().a(this.mAdTemplate, com.kwad.sdk.core.network.e.bCF.errorCode, com.kwad.sdk.core.network.e.bCF.msg);
            com.kwad.sdk.core.d.c.e("InterstitialAdControl", "showInterstitialAd please init sdk first");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        com.kwad.sdk.commercial.d.c.bZ(this.mAdTemplate);
        this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            this.mAdTemplate.mInitVoiceStatus = 2;
        } else {
            this.mAdTemplate.mInitVoiceStatus = 1;
        }
        com.kwad.sdk.a.a.c.VC().cs(true);
        if (this.mA == null) {
            try {
                d dVar = new d(activity, this.mAdResultData, ksVideoPlayConfig, this.mz);
                this.mA = dVar;
                dVar.show();
                com.kwad.components.ad.interstitial.c.b.J(activity);
            } catch (Throwable th) {
                com.kwad.components.ad.interstitial.report.realtime.a.fb();
                com.kwad.components.ad.interstitial.report.realtime.a.a(th.getMessage(), this.mAdTemplate);
            }
            com.kwad.components.ad.interstitial.report.c.eX().A(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.mz == null) {
            this.mz = new c() { // from class: com.kwad.components.ad.interstitial.b.1
                @Override // com.kwad.components.ad.interstitial.c, com.kwad.components.ad.fullscreen.h
                public final void onAdShow() {
                    super.onAdShow();
                    com.kwad.components.ad.interstitial.report.a.eT().w(b.this.mAdTemplate);
                    b.this.dl.h(b.this);
                }

                @Override // com.kwad.components.ad.interstitial.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    com.kwad.components.ad.interstitial.report.a.eT().x(b.this.mAdTemplate);
                    b.this.dl.i(b.this);
                }
            };
        }
        this.mz.a(adInteractionListener);
        d dVar = this.mA;
        if (dVar != null) {
            dVar.setAdInteractionListener(this.mz);
        }
    }
}
