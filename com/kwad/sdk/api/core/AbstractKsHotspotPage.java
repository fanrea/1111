package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsHotspotPage;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbstractKsHotspotPage implements KsHotspotPage {
    @KsAdSdkDynamicApi
    protected abstract View getHotspotEntryView2(Context context);

    @Override // com.kwad.sdk.api.KsHotspotPage
    @KsAdSdkDynamicApi
    public final View getHotspotEntryView(Context context) {
        return getHotspotEntryView2(Wrapper.wrapContextIfNeed(context));
    }
}
