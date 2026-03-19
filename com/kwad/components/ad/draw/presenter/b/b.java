package com.kwad.components.ad.draw.presenter.b;

import android.view.ViewGroup;
import com.kwad.components.ad.draw.presenter.b.a;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.draw.b.a {
    private ViewGroup fA;
    private a.InterfaceC0407a gt = new a.InterfaceC0407a() { // from class: com.kwad.components.ad.draw.presenter.b.b.1
        @Override // com.kwad.components.ad.draw.presenter.b.a.InterfaceC0407a
        public final void ba() {
            b.this.ba();
        }
    };
    private DrawCardApp gw;
    private DrawCardH5 gx;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fA = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.gw = (DrawCardApp) findViewById(R.id.ksad_card_app_container);
        this.gx = (DrawCardH5) findViewById(R.id.ksad_card_h5_container);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.fm.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eP(adTemplate);
        this.fm.fr.a(this.gt);
        this.gw.setVisibility(8);
        this.gx.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.gw.release();
        this.gx.release();
        this.fm.fr.a((a.InterfaceC0407a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            bc();
        } else {
            bd();
        }
    }

    private void bc() {
        this.fA.setVisibility(8);
        this.gw.a(this.mAdTemplate, new DrawCardApp.a() { // from class: com.kwad.components.ad.draw.presenter.b.b.2
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void bf() {
                b.this.fA.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void bg() {
                b.this.be();
            }
        });
        this.gw.setVisibility(0);
        this.gw.bY();
    }

    private void bd() {
        this.fA.setVisibility(8);
        this.gx.a(this.mAdTemplate, new DrawCardH5.a() { // from class: com.kwad.components.ad.draw.presenter.b.b.3
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void bf() {
                b.this.fA.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void bg() {
                b.this.be();
            }
        });
        this.gx.setVisibility(0);
        this.gx.bY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 29, this.fm.mRootContainer.getTouchCoords());
        if (this.fm.eU != null) {
            this.fm.eU.onAdClicked();
        }
    }
}
