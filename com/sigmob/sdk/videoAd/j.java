package com.sigmob.sdk.videoAd;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface j {
    void onAdLoadError(WindAdError error, String placementId);

    void onAdLoadSuccess(String placementId);

    void onAdPreLoadFail(WindAdError error, String placementId);

    void onAdPreLoadSuccess(String placementId);
}
