package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import com.kwad.components.core.webview.tachikoma.c.m;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getLandingPageInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            String strAW = com.kwad.sdk.core.response.b.a.aW(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            if (TextUtils.isEmpty(strAW)) {
                cVar.onError(-1, "landing page url is null");
                return;
            }
            m mVar = new m();
            mVar.ajf = strAW;
            cVar.a(mVar);
            return;
        }
        cVar.onError(-1, "adTemplate is null");
    }
}
