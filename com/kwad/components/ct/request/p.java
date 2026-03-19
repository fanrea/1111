package com.kwad.components.ct.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p extends com.kwad.sdk.core.network.d {
    private final SceneImpl mScene;

    public static class a {
        public ImpInfo Tk;
        public com.kwad.components.ct.request.a.a aUG;
        public String aUV;
        public int contentSourceType;
        public int contentType;
    }

    public p(a aVar) {
        this.mScene = aVar.Tk.adScene;
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, aVar.Tk.toJson());
        putBody("impInfo", jSONArray);
        putBody("contentInfo", aVar.aUG);
        putBody("photoId", aVar.aUV);
        putBody("contentSourceType", aVar.contentSourceType);
        putBody("contentType", aVar.contentType);
        putBody("appTag", ag.aoD());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.Tu();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final SceneImpl getScene() {
        return this.mScene;
    }
}
