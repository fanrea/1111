package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends e {
    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        findViewById(R.id.splash_play_card_view).setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.j.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                j.this.dh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh() {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        a(new b(), true);
        a(new c(), true);
        if (com.kwad.sdk.core.response.b.a.bi(adInfoEP)) {
            a(new d(), true);
            a(new t(), true);
        } else {
            a(new h(), true);
        }
        if (this.HX.Hq) {
            a(new s(), true);
        } else {
            boolean zEa = com.kwad.sdk.core.response.b.b.ea(adInfoEP);
            boolean zEe = com.kwad.sdk.core.response.b.b.ee(adInfoEP);
            boolean zEm = com.kwad.sdk.core.response.b.b.em(adInfoEP);
            if (com.kwad.sdk.core.response.b.b.eg(adInfoEP)) {
                a(new q(), true);
            } else if (zEa) {
                a(new o(), true);
            } else if (zEe) {
                a(new m(), true);
            } else if (zEm) {
                a(new s(), true);
            } else {
                a(new s(), true);
            }
        }
        if (com.kwad.sdk.core.response.b.a.aT(adInfoEP)) {
            a(new f(), true);
        }
        if (!this.HX.dA) {
            a(new com.kwad.components.ad.splashscreen.presenter.playcard.b(), true);
        }
        a(new a(), true);
        a(new g(), true);
    }
}
