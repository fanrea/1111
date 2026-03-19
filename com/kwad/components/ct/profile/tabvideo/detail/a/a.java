package com.kwad.components.ct.profile.tabvideo.detail.a;

import com.kwad.components.ct.home.b.g;
import com.kwad.components.ct.home.e;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e {
    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.profile.tabvideo.detail.a.Jn();
        List<CtAdTemplate> listJo = com.kwad.components.ct.profile.tabvideo.detail.a.Jo();
        if (listJo == null) {
            return;
        }
        SceneImpl sceneImpl = this.aGP.mSceneImpl;
        ArrayList arrayList = new ArrayList(listJo.size());
        for (CtAdTemplate ctAdTemplate : listJo) {
            ctAdTemplate.mAdScene = sceneImpl;
            arrayList.add(ctAdTemplate);
        }
        g.F(arrayList);
        com.kwad.components.ct.profile.tabvideo.detail.a.Jn();
        com.kwad.components.ct.profile.tabvideo.detail.a.wZ();
        this.aGP.aok.setInitStartPosition(this.aGP.aGI);
    }
}
