package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends Presenter {
    public c oa;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.oa = (c) amf();
    }

    public void dW() {
        List<Presenter> listAme = ame();
        if (listAme == null) {
            return;
        }
        for (Presenter presenter : listAme) {
            if (presenter instanceof b) {
                ((b) presenter).dW();
            }
        }
    }

    public void dX() {
        List<Presenter> listAme = ame();
        if (listAme == null) {
            return;
        }
        for (Presenter presenter : listAme) {
            if (presenter instanceof b) {
                ((b) presenter).dX();
            }
        }
    }
}
