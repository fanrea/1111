package com.kwad.components.core.t.a;

import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.n;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.core.n.a {
    public StyleTemplate ZR;
    public n ZV;
    public k ZW;
    public AdResultData mAdResultData;
    public AdBaseFrameLayout mRootContainer;

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = c.s(adResultData);
    }

    public b(a aVar) {
        super(aVar);
    }
}
