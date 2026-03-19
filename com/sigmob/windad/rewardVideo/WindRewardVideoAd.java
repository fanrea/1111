package com.sigmob.windad.rewardVideo;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.g;
import com.sigmob.sdk.c;
import com.sigmob.sdk.videoAd.e;
import com.sigmob.sdk.videoAd.j;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.windad.WindAdError;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindRewardVideoAd extends c<e> implements j, k, l {
    protected WindRewardVideoAdListener i;

    public WindRewardVideoAd(WindRewardAdRequest request) {
        super(request, false, 1);
        setAdLoadListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final k kVar, final WindRewardInfo windRewardInfo, final String str) {
        this.a.post(new Runnable() { // from class: com.sigmob.windad.rewardVideo.WindRewardVideoAd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(windRewardInfo, kVar, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WindRewardInfo windRewardInfo, k kVar, String str) {
        if (this.c != 0) {
            ((e) this.c).a("reward_callback", windRewardInfo.getOptions());
        }
        if (kVar != null) {
            SigmobLog.i("onVideoAdRewarded " + str);
            kVar.onVideoAdRewarded(windRewardInfo, str);
        }
    }

    @Override // com.sigmob.sdk.c
    protected void a(final k windAdRewardListener) {
        if (this.c == 0) {
            return;
        }
        g.f(this.e.getPlacementId());
        ((e) this.c).a(new k() { // from class: com.sigmob.windad.rewardVideo.WindRewardVideoAd$$ExternalSyntheticLambda0
            @Override // com.sigmob.sdk.videoAd.k
            public final void onVideoAdRewarded(WindRewardInfo windRewardInfo, String str) {
                this.f$0.a(windAdRewardListener, windRewardInfo, str);
            }
        });
    }

    @Override // com.sigmob.sdk.c
    public e createAdManager() {
        return new e(false);
    }

    @Override // com.sigmob.sdk.c
    public void destroy() {
        this.i = null;
        super.destroy();
    }

    @Override // com.sigmob.sdk.c, com.sigmob.sdk.base.m
    public boolean loadAd() {
        return super.loadAd();
    }

    @Override // com.sigmob.sdk.c, com.sigmob.sdk.base.m
    public boolean loadAd(String bidToken) {
        return super.loadAd(bidToken);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onAdClicked(String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdClicked(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onAdClosed(String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdClosed(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdLoadError(WindAdError error, String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdLoadError(error, placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdLoadSuccess(String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdLoadSuccess(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdPreLoadFail(WindAdError error, String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPreLoadFail(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdPreLoadSuccess(String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPreLoadSuccess(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onAdShow(String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPlayStart(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onAdShowError(WindAdError error, String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPlayError(error, placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onVideoAdPlayComplete(String placementId) {
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onVideoAdPlayEnd(String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdPlayEnd(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.k
    public void onVideoAdRewarded(WindRewardInfo rewardInfo, String placementId) {
        WindRewardVideoAdListener windRewardVideoAdListener = this.i;
        if (windRewardVideoAdListener == null) {
            return;
        }
        windRewardVideoAdListener.onRewardAdRewarded(rewardInfo, placementId);
    }

    public void setWindRewardVideoAdListener(WindRewardVideoAdListener windRewardedVideoAdListener) {
        this.i = windRewardedVideoAdListener;
    }

    public boolean show(HashMap<String, String> options) {
        return super.show(options, this, this);
    }
}
