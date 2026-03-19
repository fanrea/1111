package com.kwad.components.ct.api.model.hotspot;

import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.components.ct.response.model.hotspot.HotspotListData;
import com.kwad.sdk.utils.ap;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HotspotListParam implements Serializable {
    private static final long serialVersionUID = -3176539585003573126L;
    public HotspotInfo mEntryHotspotInfo;
    public HotspotListData mHotspotListData;

    public static boolean isValid(HotspotListParam hotspotListParam) {
        HotspotListData hotspotListData;
        return (hotspotListParam == null || (hotspotListData = hotspotListParam.mHotspotListData) == null || !ap.aM(hotspotListData.trends) || hotspotListParam.mEntryHotspotInfo == null) ? false : true;
    }
}
