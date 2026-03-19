package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g vb;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) amf();
        this.vb = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    protected final void iE() {
        this.vb.iE();
    }

    protected final boolean iF() {
        return com.kwad.sdk.core.response.b.a.bj(com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate));
    }
}
