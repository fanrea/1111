package com.kwad.sdk.api.tube.log;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.tube.KSTubeChannelData;
import java.io.Serializable;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSTubeLog implements Serializable {
    private static final long serialVersionUID = 3653599442098728767L;
    private KSTubeChannelData ksTubeChannelData;
    private int tubePageType;

    private KSTubeLog() {
    }

    public static KSTubeLog obtain() {
        return new KSTubeLog();
    }

    public KSTubeLog setTubePageType(int i) {
        this.tubePageType = i;
        return this;
    }

    public KSTubeLog setKsTubeChannelData(KSTubeChannelData kSTubeChannelData) {
        this.ksTubeChannelData = kSTubeChannelData;
        return this;
    }

    public int getTubePageType() {
        return this.tubePageType;
    }

    public KSTubeChannelData getKSTubeChannelData() {
        return this.ksTubeChannelData;
    }
}
