package com.kwad.components.ct;

import com.kwad.components.ct.home.i;
import com.kwad.sdk.api.core.AbstractKsContentAllianceAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends AbstractKsContentAllianceAd {
    private SceneImpl mAdScene;

    public c(SceneImpl sceneImpl) {
        this.mAdScene = sceneImpl;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentAllianceAd
    public final KsFragment getFragment2() {
        return i.c(this.mAdScene);
    }
}
