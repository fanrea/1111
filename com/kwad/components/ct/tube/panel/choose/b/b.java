package com.kwad.components.ct.tube.panel.choose.b;

import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.tube.panel.choose.TubeEpisodeChooseParam;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.a.a.b<CtAdResultData, CtAdTemplate> {
    public com.kwad.components.core.widget.a.b aFs;
    public TubeEpisodeChooseParam aXr;
    public SceneImpl mSceneImpl;

    public final void release() {
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.release();
        }
    }
}
