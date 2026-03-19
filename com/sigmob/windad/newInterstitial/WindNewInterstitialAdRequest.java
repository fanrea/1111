package com.sigmob.windad.newInterstitial;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindNewInterstitialAdRequest extends WindAdRequest {
    private boolean b;
    private boolean c;

    public WindNewInterstitialAdRequest(String placementId, String userId, Map<String, Object> options) {
        super(placementId, userId, options, 6);
    }

    public boolean isEnableKeepOn() {
        return this.c;
    }

    public boolean isEnableScreenLockDisPlayAd() {
        return this.b;
    }

    public void setEnableKeepOn(boolean enableKeepOn) {
        this.c = enableKeepOn;
    }

    public void setEnableScreenLockDisPlayAd(boolean enableScreenLockDisPlayAd) {
        this.b = enableScreenLockDisPlayAd;
    }
}
