package com.kwad.components.ct.horizontal.detail;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HorizontalFeedParam implements Serializable {
    private static final long serialVersionUID = 7464637143888889638L;
    public CtAdTemplate mAdTemplate;
    public long mEnterPlayPosition;
    public SceneImpl mScene;

    public long getEntryScene() {
        SceneImpl sceneImpl = this.mScene;
        if (sceneImpl == null) {
            return 0L;
        }
        return sceneImpl.entryScene;
    }
}
