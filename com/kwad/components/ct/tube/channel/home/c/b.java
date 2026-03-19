package com.kwad.components.ct.tube.channel.home.c;

import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.home.TubeChannelParam;
import com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.a.a.b<TubeChannelResultData, TubeInfo> {
    public com.kwad.components.core.widget.a.b aFs;
    public TubeChannelParam aWo;
    public SceneImpl mSceneImpl;

    public final void release() {
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.release();
        }
    }
}
