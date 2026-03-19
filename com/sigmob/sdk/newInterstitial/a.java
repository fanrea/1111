package com.sigmob.sdk.newInterstitial;

import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.newInterstitial.e;
import com.sigmob.windad.WindAdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.sigmob.sdk.manager.f implements e.a {
    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void c(BaseAdUnit adUnit, String message) {
        if (m(adUnit)) {
            com.sigmob.sdk.base.common.g.g().e(adUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(message);
        a(windAdError, this.p);
        a(adUnit, "play", this.k.getAdType(), this.g, this.k.getLoadId(), windAdError);
        SigmobLog.d("onAdShowFail() called");
    }

    @Override // com.sigmob.sdk.manager.b
    protected void g() {
        if (com.sigmob.sdk.base.utils.e.a(this.m)) {
            this.m = null;
            return;
        }
        BaseAdUnit baseAdUnitE = e();
        if (m(baseAdUnitE)) {
            com.sigmob.sdk.base.common.g.g().e(baseAdUnitE);
        }
        this.m = null;
    }

    @Override // com.sigmob.sdk.manager.f
    public com.sigmob.sdk.mraid.e l() {
        return new e(this);
    }

    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void o(BaseAdUnit adUnit) {
        if (this.b == AdStatus.AdStatusClose) {
            return;
        }
        n(adUnit);
    }

    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void p(BaseAdUnit adUnit) {
        SigmobLog.d("onVideoSkip() called");
    }

    @Override // com.sigmob.sdk.newInterstitial.e.a
    public void q(BaseAdUnit adUnit) {
        SigmobLog.d("onAdShow() called");
    }
}
