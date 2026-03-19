package com.kwad.components.ct.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.sdk.core.network.d {
    private SceneImpl mScene;

    public g(k.a aVar, HotspotInfo hotspotInfo) {
        JSONArray jSONArray = new JSONArray();
        for (ImpInfo impInfo : aVar.anZ) {
            aa.a(jSONArray, impInfo.toJson());
            if (this.mScene == null) {
                this.mScene = impInfo.adScene;
            }
        }
        putBody("impInfo", jSONArray);
        putBody("contentInfo", aVar.aUG);
        putBody("trendId", hotspotInfo.trendId);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.Ti();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final SceneImpl getScene() {
        return this.mScene;
    }
}
