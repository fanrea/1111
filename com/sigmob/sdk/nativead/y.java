package com.sigmob.sdk.nativead;

import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface y {
    void onNativeAdLoadFail(int error_code, String error_message);

    void onNativeAdLoaded(List<WindNativeAdData> adUnits);
}
