package com.kwad.components.ad.interstitial;

import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public static KsInterstitialAd f(AdResultData adResultData) {
        int iFd = com.kwad.sdk.core.response.b.e.fd(com.kwad.sdk.core.response.b.c.s(adResultData));
        if (iFd == 1) {
            return new com.kwad.components.ad.interstitial.e.a(true, adResultData);
        }
        if (iFd == 2) {
            return new com.kwad.components.ad.interstitial.e.a(false, adResultData);
        }
        return new b(adResultData);
    }
}
