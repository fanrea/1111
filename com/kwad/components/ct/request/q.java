package com.kwad.components.ct.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q extends com.kwad.sdk.core.network.d {
    private final SceneImpl mScene;

    public static class a {
        public ImpInfo Tk;
        public com.kwad.components.ct.request.a.a aUG;
        public long authorId;
        public String pcursor;
        public long tabId;
    }

    public q(a aVar) {
        this.mScene = aVar.Tk.adScene;
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, aVar.Tk.toJson());
        putBody("impInfo", jSONArray);
        putBody(URLPackage.KEY_AUTHOR_ID, aVar.authorId);
        putBody("tabId", aVar.tabId);
        putBody("contentInfo", aVar.aUG);
        putBody("pcursor", aVar.pcursor);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.Tl();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final SceneImpl getScene() {
        return this.mScene;
    }
}
