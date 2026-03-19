package com.sigmob.windad.Splash;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindSplashAdRequest extends WindAdRequest {
    private int b;
    private boolean c;

    public WindSplashAdRequest(String placementId, String userId, Map<String, Object> options) {
        super(placementId, userId, options, 2);
        this.b = 5;
        this.c = false;
    }

    public int getFetchDelay() {
        return Math.max(this.b, 3);
    }

    public boolean isDisableAutoHideAd() {
        return this.c;
    }

    public void setDisableAutoHideAd(boolean disableAutoHideAd) {
        this.c = disableAutoHideAd;
    }

    public void setFetchDelay(int fetchDelay) {
        this.b = fetchDelay;
    }
}
