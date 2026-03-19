package com.kwad.components.ad.interstitial.e;

import android.app.Activity;
import com.kwad.components.ad.fullscreen.g;
import com.kwad.components.ad.interstitial.c;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private final boolean nR;
    private g nS;
    private com.kwad.components.ad.interstitial.b nT;
    private final c nU;

    public a(boolean z, AdResultData adResultData) {
        super(adResultData);
        this.nR = z;
        if (z) {
            this.nS = new g(adResultData);
        } else {
            this.nT = new com.kwad.components.ad.interstitial.b(adResultData);
        }
        this.nU = new c();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (this.nR) {
            this.nS.showFullScreenVideoAd(activity, ksVideoPlayConfig);
        } else {
            this.nT.showInterstitialAd(activity, ksVideoPlayConfig);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.nU.a(adInteractionListener);
        if (this.nR) {
            this.nS.setFullScreenVideoAdInteractionListener(this.nU);
        } else {
            this.nT.setAdInteractionListener(this.nU);
        }
    }
}
