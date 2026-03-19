package com.kwad.sdk.core.response.model;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AdGlobalConfigInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -2622260965144406821L;
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public CycleAggregationInfo cycleAggregationInfo;
    public int neoPageType;
    public NeoScanAggregationSceneInfo neoScanAggregationSceneInfo;
    public boolean uaidEnable;

    public static class CycleAggregationInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 6065877559133029298L;
        public int cycleAggregationInterval;
        public boolean cycleAggregationSwitch;
    }

    public static class NeoScanAggregationSceneInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -4381505798843439175L;
        public boolean guidSwipezShowMore;
        public boolean mute;
        public boolean neoCountDownNeedSwipeTrigger;
        public int neoCountDownTime;
        public boolean noActionStopCountDown;
        public int noActionTime;
    }

    public boolean isNeoScan() {
        return this.neoPageType == 1;
    }
}
