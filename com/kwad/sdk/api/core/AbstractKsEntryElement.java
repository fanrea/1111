package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbstractKsEntryElement implements KsEntryElement {
    @KsAdSdkDynamicApi
    protected abstract View getEntryView2(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener);

    @Override // com.kwad.sdk.api.KsEntryElement
    @KsAdSdkDynamicApi
    public final View getEntryView(Context context, KsEntryElement.OnFeedClickListener onFeedClickListener) {
        return getEntryView2(Wrapper.wrapContextIfNeed(context), onFeedClickListener);
    }
}
