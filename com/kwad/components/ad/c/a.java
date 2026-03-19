package com.kwad.components.ad.c;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ad.b.a {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.a.class;
    }

    @Override // com.kwad.components.ad.b.a
    public final void loadBannerAd(KsScene ksScene, KsLoadManager.BannerAdListener bannerAdListener) {
        if (!l.UL().Vn()) {
            bannerAdListener.onError(com.kwad.sdk.core.network.e.bCH.errorCode, com.kwad.sdk.core.network.e.bCH.msg);
        } else {
            g.loadBannerAd(ksScene, bannerAdListener);
        }
    }
}
