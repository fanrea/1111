package com.kwad.components.ct.tube.history.b;

import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.detail.request.ChannelDetailResultData;
import com.kwad.components.ct.tube.history.TubeHistoryDetailParam;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.a.a.b<ChannelDetailResultData, TubeInfo> {
    public com.kwad.components.core.widget.a.b aFs;
    public TubeHistoryDetailParam aWO;
    public long aWW = com.kwad.components.ct.tube.history.a.a.Ku();
    public long aWX = com.kwad.components.ct.tube.history.a.a.Ku();
    public SceneImpl mSceneImpl;

    public final void release() {
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.release();
        }
    }
}
