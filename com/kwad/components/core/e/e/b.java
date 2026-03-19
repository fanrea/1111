package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends Presenter {
    protected c RI;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        c cVar = (c) amf();
        this.RI = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(cVar.RH.getAdTemplate());
    }
}
