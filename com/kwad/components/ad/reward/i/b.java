package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends bo implements bo.a {
    private PlayableSource xn;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.xn = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bo.a
    public final boolean eR() {
        com.kwad.components.ad.reward.a.gl().c(this.xn, new a(this.mContext));
        return false;
    }
}
