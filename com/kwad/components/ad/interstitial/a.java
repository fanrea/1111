package com.kwad.components.ad.interstitial;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.f {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.f.class;
    }

    @Override // com.kwad.components.ad.b.f
    public final void loadInterstitialAd(KsScene ksScene, KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!l.UL().Vn()) {
            interstitialAdListener.onError(com.kwad.sdk.core.network.e.bCH.errorCode, com.kwad.sdk.core.network.e.bCH.msg);
        } else {
            f.loadInterstitialAd(ksScene, interstitialAdListener);
        }
    }
}
