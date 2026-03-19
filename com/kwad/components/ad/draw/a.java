package com.kwad.components.ad.draw;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.l;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements com.kwad.components.ad.b.c {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.c.class;
    }

    @Override // com.kwad.components.ad.b.c
    public final void loadDrawAd(KsScene ksScene, KsLoadManager.DrawAdListener drawAdListener) {
        if (!l.UL().Vn()) {
            drawAdListener.onError(com.kwad.sdk.core.network.e.bCH.errorCode, com.kwad.sdk.core.network.e.bCH.msg);
        } else {
            d.loadDrawAd(ksScene, drawAdListener);
        }
    }
}
