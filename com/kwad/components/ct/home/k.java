package com.kwad.components.ct.home;

import com.kwad.components.core.u.p;
import com.kwad.sdk.api.KsContentAllianceAd;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k {
    public static KsContentAllianceAd loadContentAllianceAd(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        p.tH().b(sceneImplCovert, "loadContentAllianceAd");
        return new com.kwad.components.ct.c(sceneImplCovert);
    }

    public static KsContentPage loadContentPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        p.tH().b(sceneImplCovert, "loadContentPage");
        return new com.kwad.components.ct.d(sceneImplCovert);
    }

    public static KsContentPage loadContentPageByPush(KsScene ksScene, String str) {
        if (ksScene == null) {
            return null;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        p.tH().b(sceneImplCovert, "loadContentPageByPush");
        com.kwad.components.ct.d dVar = new com.kwad.components.ct.d(sceneImplCovert);
        com.kwad.components.ct.e.b.JK().bY(str);
        dVar.bs(str);
        return dVar;
    }

    public static KsContentPage loadContentPageBySchema(KsScene ksScene, String str) {
        if (ksScene == null) {
            return null;
        }
        com.kwad.components.ct.d dVar = new com.kwad.components.ct.d(SceneImpl.covert(ksScene));
        com.kwad.sdk.o.a aVar = new com.kwad.sdk.o.a(str);
        if (com.kwad.sdk.o.b.b(aVar)) {
            com.kwad.components.ct.e.b.JK().bY(aVar.getUrl());
            dVar.bs(aVar.getUrl());
        } else if (com.kwad.sdk.o.b.c(aVar)) {
            com.kwad.components.ct.e.b.JK().bZ(com.kwad.sdk.o.b.ih(aVar.getUrl()));
            dVar.bt(aVar.getUrl());
        }
        return dVar;
    }
}
