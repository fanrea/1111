package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbstractKsFeedAd implements KsFeedAd {
    @KsAdSdkDynamicApi
    protected abstract View getFeedView2(Context context);

    @Override // com.kwad.sdk.api.KsFeedAd
    @KsAdSdkDynamicApi
    public final View getFeedView(Context context) {
        return getFeedView2(Wrapper.wrapContextIfNeed(context));
    }
}
