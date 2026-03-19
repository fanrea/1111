package com.kwad.components.ad;

import android.content.Context;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.ad.j.d;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements com.kwad.components.ad.b.b {
    @Override // com.kwad.sdk.components.e, com.kwad.sdk.components.b
    public final int priority() {
        return -100;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
        d.nK().init();
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.b.class;
    }

    @Override // com.kwad.components.ad.b.b
    public final String getBidRequestToken(KsScene ksScene) {
        return c.a(SceneImpl.covert(ksScene));
    }

    @Override // com.kwad.components.ad.b.b
    public final String getBidRequestTokenV2(KsScene ksScene) {
        return c.getBidRequestTokenV2(ksScene);
    }
}
