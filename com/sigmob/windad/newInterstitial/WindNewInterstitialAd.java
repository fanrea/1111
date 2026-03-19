package com.sigmob.windad.newInterstitial;

import com.sigmob.sdk.c;
import com.sigmob.sdk.newInterstitial.a;
import com.sigmob.sdk.videoAd.j;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.windad.WindAdError;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindNewInterstitialAd extends c<a> implements j, l {
    protected WindNewInterstitialAdListener i;

    public WindNewInterstitialAd(WindNewInterstitialAdRequest request) {
        super(request, false, 6);
        setAdLoadListener(this);
    }

    @Override // com.sigmob.sdk.c
    public a createAdManager() {
        return new a();
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
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdClicked(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onAdClosed(String placementId) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdClosed(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdLoadError(WindAdError error, String placementId) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdLoadError(error, placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdLoadSuccess(String placementId) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdLoadSuccess(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdPreLoadFail(WindAdError error, String placementId) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdPreLoadFail(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.j
    public void onAdPreLoadSuccess(String placementId) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdPreLoadSuccess(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onAdShow(String placementId) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdShow(placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onAdShowError(WindAdError error, String placementId) {
        WindNewInterstitialAdListener windNewInterstitialAdListener = this.i;
        if (windNewInterstitialAdListener == null) {
            return;
        }
        windNewInterstitialAdListener.onInterstitialAdShowError(error, placementId);
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onVideoAdPlayComplete(String placementId) {
    }

    @Override // com.sigmob.sdk.videoAd.l
    public void onVideoAdPlayEnd(String placementId) {
    }

    public void setWindNewInterstitialAdListener(WindNewInterstitialAdListener windNewInterstitialAdListener) {
        this.i = windNewInterstitialAdListener;
    }

    public boolean show(HashMap<String, String> options) {
        return super.show(options, this);
    }
}
