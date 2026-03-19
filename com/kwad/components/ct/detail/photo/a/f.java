package com.kwad.components.ct.detail.photo.a;

import android.widget.LinearLayout;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.detail.b {
    private LinearLayout aqO;
    private com.kwad.components.ct.hotspot.e aqP = new com.kwad.components.ct.hotspot.f() { // from class: com.kwad.components.ct.detail.photo.a.f.1
        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void zp() {
            f.this.aqO.setVisibility(4);
        }

        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void bB(int i) {
            f.this.aqO.setVisibility(0);
        }
    };

    public f(com.kwad.components.ec.api.live.a aVar) {
        d(new com.kwad.components.ct.detail.b.a.a());
        d(new com.kwad.components.ct.detail.b.a.b());
        d(new com.kwad.components.ct.detail.b.a.c());
        if (com.kwad.components.ct.detail.a.b.zf()) {
            d(new h());
        } else {
            d(new i());
        }
        EcLiveComponents ecLiveComponents = (EcLiveComponents) com.kwad.sdk.components.d.g(EcLiveComponents.class);
        if (ecLiveComponents != null) {
            d(ecLiveComponents.LK());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aqO = (LinearLayout) findViewById(R.id.ksad_bottom_content_container);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
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
