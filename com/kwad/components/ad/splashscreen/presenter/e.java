package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e extends Presenter {
    public com.kwad.components.ad.splashscreen.h HX;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        Object objAmf = amf();
        if (objAmf instanceof com.kwad.components.ad.splashscreen.h) {
            this.HX = (com.kwad.components.ad.splashscreen.h) objAmf;
        }
    }
}
