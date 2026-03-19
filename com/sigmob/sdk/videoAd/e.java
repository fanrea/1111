package com.sigmob.sdk.videoAd;

import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.base.utils.n;
import com.sigmob.sdk.videoAd.g;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e extends com.sigmob.sdk.manager.f implements g.a {
    private int q;
    private k r;
    private final boolean s;

    public e(boolean isHalfInterstitial) {
        this.s = isHalfInterstitial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int status, String serverArrived, String rewardType) {
        this.q = status;
        if (this.r == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(WindAds.TRANS_ID, this.h);
        map.put(WindAds.SERVER_ARRIVED, serverArrived);
        map.put(WindAds.REWARD_TYPE, rewardType);
        this.r.onVideoAdRewarded(new WindRewardInfo(true, map), this.g);
    }

    private void s(BaseAdUnit baseAdUnit) {
        if (n.b(baseAdUnit)) {
            String rvCallBackUrl = baseAdUnit.getRvCallBackUrl();
            if (m.b(rvCallBackUrl)) {
                AdTracker adTracker = new AdTracker(AdTracker.MessageType.TRACKING_URL, rvCallBackUrl, "reward_server", baseAdUnit.getRequestId());
                adTracker.setRetryNum(Integer.valueOf(baseAdUnit.getTrackingRetryNum()));
                com.sigmob.sdk.base.network.g.a(adTracker, baseAdUnit, false, true, true, new TrackManager.Listener() { // from class: com.sigmob.sdk.videoAd.e.1
                    public void onErrorResponse(AdTracker tracker, VolleyError error) {
                        if (e.this.q == 1) {
                            e.this.a(2, "0", "1");
                        }
                    }

                    public void onSuccess(AdTracker tracker, NetworkResponse response) {
                        if (e.this.q == 1) {
                            e.this.a(2, "1", "1");
                        }
                    }
                });
                return;
            }
        }
        a(2, "0", "0");
    }

    public void a(k windAdRewardListener) {
        this.r = windAdRewardListener;
    }

    @Override // com.sigmob.sdk.videoAd.g.a
    public void c(BaseAdUnit adUnit, String message) {
        if (m(adUnit)) {
            com.sigmob.sdk.base.common.g.g().e(adUnit);
        }
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_PLAY;
        windAdError.setMessage(message);
        a(windAdError, this.p);
        a(adUnit, "play", this.k.getAdType(), this.g, this.k.getLoadId(), windAdError);
        SigmobLog.d("onVideoPlayFail() called");
    }

    @Override // com.sigmob.sdk.manager.b
    protected void g() {
        if (com.sigmob.sdk.base.utils.e.b(this.m)) {
            for (BaseAdUnit baseAdUnit : this.m) {
                if (baseAdUnit != null) {
                    if (m(baseAdUnit)) {
                        com.sigmob.sdk.base.common.g.g().e(baseAdUnit);
                    }
                    com.sigmob.sdk.base.common.g.b(baseAdUnit);
                }
            }
        }
        this.m = null;
    }

    @Override // com.sigmob.sdk.manager.f
    public com.sigmob.sdk.mraid.e l() {
        return new g(this, this.s);
    }

    @Override // com.sigmob.sdk.manager.f
    protected void n() {
        this.q = 0;
    }

    @Override // com.sigmob.sdk.manager.f
    protected void o() {
        if (this.q == 1) {
            a(0, "0", "1");
        }
    }

    @Override // com.sigmob.sdk.videoAd.g.a
    public void o(BaseAdUnit adUnit) {
        SigmobLogger.d(this.a, "onVideoComplete", new Object[0]);
        this.q = 1;
        if (this.p != null) {
            this.p.onVideoAdPlayComplete(this.g);
        }
        s(adUnit);
    }

    @Override // com.sigmob.sdk.manager.f
    public void p() {
        super.p();
        this.r = null;
    }

    @Override // com.sigmob.sdk.videoAd.g.a
    public void p(BaseAdUnit adUnit) {
        SigmobLog.d("onVideoPlay() called");
    }

    @Override // com.sigmob.sdk.videoAd.g.a
    public void q(BaseAdUnit adUnit) {
        SigmobLog.d("onVideoSkip() called");
    }

    @Override // com.sigmob.sdk.videoAd.g.a
    public void r(BaseAdUnit adUnit) {
        n(adUnit);
    }
}
