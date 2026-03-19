package com.kwad.components.ct.detail.photo.newui.c;

import android.widget.LinearLayout;
import com.kwad.components.ct.detail.photo.e.j;
import com.kwad.components.ct.detail.photo.e.k;
import com.kwad.components.ct.detail.photo.newui.d.d;
import com.kwad.components.ct.hotspot.e;
import com.kwad.components.ct.hotspot.f;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private e aqP = new f() { // from class: com.kwad.components.ct.detail.photo.newui.c.b.1
        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void zp() {
            b.this.aul.setVisibility(4);
        }

        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void bB(int i) {
            b.this.aul.setVisibility(0);
        }
    };
    private LinearLayout aul;
    private k aum;

    public b(boolean z) {
        d(new d());
        if (com.kwad.components.ct.home.config.b.FT()) {
            d(new com.kwad.components.ct.detail.photo.presenter.b());
        }
        if (com.kwad.components.ct.home.config.b.FV()) {
            d(new com.kwad.components.ct.detail.photo.e.f());
        }
        if (com.kwad.components.ct.home.config.b.FU()) {
            k kVar = new k();
            this.aum = kVar;
            d(kVar);
        }
        if (z && com.kwad.components.ct.home.config.b.FG()) {
            d(new j());
        }
    }

    public final k Au() {
        return this.aum;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aul = (LinearLayout) findViewById(R.id.ksad_photo_detail_bottom_toolbar);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (com.kwad.components.ct.response.a.a.bc(this.aop.mAdTemplate)) {
            this.aul.setVisibility(8);
            return;
        }
        this.aul.setVisibility(0);
        if (com.kwad.components.ct.response.a.a.aV(this.aop.mAdTemplate)) {
            this.aop.a(this.aqP);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.b(this.aqP);
    }
}
