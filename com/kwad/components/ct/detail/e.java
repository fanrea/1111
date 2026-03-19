package com.kwad.components.ct.detail;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    public static boolean a(CtAdTemplate ctAdTemplate) {
        SceneImpl sceneImpl = ctAdTemplate.mAdScene;
        int pageScene = sceneImpl != null ? sceneImpl.getPageScene() : 0;
        if (pageScene == 1 || pageScene == 12) {
            if (com.kwad.components.ct.home.config.b.Fz() != 1) {
                return false;
            }
        } else if (!com.kwad.sdk.core.scene.a.fw(pageScene) || com.kwad.components.ct.home.config.b.FA() != 1) {
            return false;
        }
        return true;
    }
}
