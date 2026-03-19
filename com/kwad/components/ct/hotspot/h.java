package com.kwad.components.ct.hotspot;

import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.api.KsHotspotData;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h implements KsHotspotData {
    private final HotspotInfo mHotspotInfo;

    public h(HotspotInfo hotspotInfo) {
        this.mHotspotInfo = hotspotInfo;
    }

    @Override // com.kwad.sdk.api.KsHotspotData
    public final int getRank() {
        return this.mHotspotInfo.rank;
    }

    @Override // com.kwad.sdk.api.KsHotspotData
    public final String getName() {
        return this.mHotspotInfo.name;
    }

    @Override // com.kwad.sdk.api.KsHotspotData
    public final String getCoverUrl() {
        return this.mHotspotInfo.coverUrl;
    }

    @Override // com.kwad.sdk.api.KsHotspotData
    public final long getPhotoCount() {
        return this.mHotspotInfo.photoCount;
    }

    @Override // com.kwad.sdk.api.KsHotspotData
    public final long getViewCount() {
        return this.mHotspotInfo.viewCount;
    }
}
