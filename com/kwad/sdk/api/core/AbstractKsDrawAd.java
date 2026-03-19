package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbstractKsDrawAd implements KsDrawAd {
    @KsAdSdkDynamicApi
    protected abstract View getDrawView2(Context context);

    @Override // com.kwad.sdk.api.KsDrawAd
    @KsAdSdkDynamicApi
    public final View getDrawView(Context context) {
        return getDrawView2(Wrapper.wrapContextIfNeed(context));
    }
}
