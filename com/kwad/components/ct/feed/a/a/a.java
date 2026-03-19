package com.kwad.components.ct.feed.a.a;

import com.kwad.components.ct.feed.b;
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
        List<CtAdTemplate> listBh = b.EL().Bh();
        if (listBh == null) {
            return;
        }
        SceneImpl sceneImpl = this.aGP.mSceneImpl;
        ArrayList arrayList = new ArrayList(listBh.size());
        for (CtAdTemplate ctAdTemplate : listBh) {
            ctAdTemplate.mAdScene = sceneImpl;
            arrayList.add(ctAdTemplate);
        }
        g.F(arrayList);
        b.EL().Bi();
        this.aGP.aok.setInitStartPosition(this.aGP.aGI);
    }
}
