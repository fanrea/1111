package com.kwad.components.ct.hotspot;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.components.e implements com.kwad.components.ct.api.f {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ct.api.f.class;
    }

    @Override // com.kwad.components.ct.api.f
    public final void loadHotspotData(KsScene ksScene, KsLoadManager.KsHotSpotDataListener ksHotSpotDataListener) {
        g.loadHotspotData(ksScene, ksHotSpotDataListener);
    }

    @Override // com.kwad.components.ct.api.f
    public final void loadHotspotPage(KsScene ksScene, KsLoadManager.KsHotSpotPageListener ksHotSpotPageListener) {
        g.loadHotspotPage(ksScene, ksHotSpotPageListener);
    }
}
