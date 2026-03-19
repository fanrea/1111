package com.kwad.components.ad.splashscreen;

import android.content.Context;
import com.kwad.components.ad.b.i;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.components.e implements i {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class<i> getComponentsType() {
        return i.class;
    }

    @Override // com.kwad.components.ad.b.i
    public final void loadSplashScreenAd(KsScene ksScene, KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        if (!l.UL().Vn()) {
            splashScreenAdListener.onError(com.kwad.sdk.core.network.e.bCH.errorCode, com.kwad.sdk.core.network.e.bCH.msg);
        } else {
            b.loadSplashScreenAd(ksScene, splashScreenAdListener);
        }
    }

    @Override // com.kwad.components.ad.b.i
    public final List<String> W() {
        return SplashPreloadManager.lH().W();
    }
}
