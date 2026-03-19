package com.kwad.components.ct.tube.panel.b;

import com.kwad.components.ct.tube.panel.TubePanelTabParam;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.widget.a.b aFs;
    public List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> aPS;
    public TubePanelTabParam aXQ;
    public PagerSlidingTabStrip aXR;
    public KsFragment alG;
    public SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.release();
        }
    }
}
