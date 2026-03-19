package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.d.a.c;
import com.kwad.components.ad.reward.presenter.s;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public b(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eP(adTemplate);
        if (z) {
            jI();
        } else {
            jJ();
        }
    }

    private void jI() {
        if (g.g(this.mAdInfo)) {
            d(new s());
        }
        d(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.di(this.mAdTemplate)) {
            d(new c());
        }
        d(new a(this.mAdInfo));
        if (com.kwad.components.ad.reward.a.b.k(this.mAdInfo) || !com.kwad.sdk.core.response.b.a.au(this.mAdInfo)) {
            return;
        }
        d(new com.kwad.components.ad.reward.presenter.d.a.a());
    }

    static class a extends com.kwad.components.ad.reward.presenter.c {
        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iH() {
            return 8;
        }

        public a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.ad.reward.presenter.c
        public final int iG() {
            return R.id.ksad_blur_end_cover;
        }
    }

    private void jJ() {
        d(new com.kwad.components.ad.reward.presenter.d.a.b());
        if (com.kwad.sdk.core.response.b.b.di(this.mAdTemplate)) {
            d(new c());
        }
    }
}
