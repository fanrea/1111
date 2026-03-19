package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements com.kwad.sdk.widget.e {
    private View HM;
    private boolean HN;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.HM = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.HX == null) {
            return;
        }
        this.HN = com.kwad.sdk.core.response.b.d.eE(this.HX.mAdTemplate);
        boolean zN = com.kwad.components.ad.splashscreen.h.n(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate));
        this.HM.setVisibility(zN ? 0 : 8);
        if (zN) {
            new com.kwad.sdk.widget.j(this.HM.getContext(), this.HM, this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        this.HX.c(1, view.getContext(), 53, 2);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        com.kwad.sdk.core.d.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.HN);
        if (this.HN) {
            this.HX.c(1, view.getContext(), 153, 2);
        }
    }
}
