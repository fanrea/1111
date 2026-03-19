package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends b implements com.kwad.sdk.app.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.app.a
    public final void X(String str) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
        com.kwad.sdk.app.b.Wd().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.app.b.Wd().b(this);
    }

    @Override // com.kwad.sdk.app.a
    public final void W(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.aB(this.mAdInfo), str)) {
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
            if (com.kwad.sdk.core.response.b.a.aS(adInfoEP) && com.kwad.sdk.core.response.b.a.aR(adInfoEP) == 1) {
                return;
            }
            if (this.vb.tt != null) {
                this.vb.tt.onRewardVerify();
            }
            this.vb.tu.pause();
            this.vb.gO();
        }
    }
}
