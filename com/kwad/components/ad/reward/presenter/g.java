package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.j.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends b implements a.InterfaceC0474a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() throws JSONException {
        super.ay();
        boolean zAai = com.kwad.sdk.core.local.a.aai();
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + zAai);
        if (this.mAdTemplate.mAdScene == null || !zAai) {
            return;
        }
        com.kwad.components.core.j.a.a(this.mAdTemplate.mAdScene, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void onError(int i, String str) {
        List<a.InterfaceC0474a> listGV = this.vb.gV();
        if (listGV != null) {
            Iterator<a.InterfaceC0474a> it = listGV.iterator();
            while (it.hasNext()) {
                it.next().onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void onRequestResult(int i) {
        List<a.InterfaceC0474a> listGV = this.vb.gV();
        if (listGV != null) {
            Iterator<a.InterfaceC0474a> it = listGV.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC0474a
    public final void f(List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean zDc = com.kwad.sdk.core.response.b.b.dc(adTemplate);
        List<a.InterfaceC0474a> listGV = this.vb.gV();
        if (zDc) {
            com.kwad.sdk.core.local.a.i(com.kwad.sdk.core.response.b.b.cZ(adTemplate), com.kwad.sdk.core.response.b.b.da(adTemplate));
            if (listGV != null) {
                Iterator<a.InterfaceC0474a> it = listGV.iterator();
                while (it.hasNext()) {
                    it.next().f(list);
                }
            }
        }
    }
}
