package com.kwad.components.ct.tube.channel.home;

import com.kwad.components.ct.api.tube.KSTubeParamInner;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeChannelParam implements Serializable {
    private static final long serialVersionUID = -5238032101385027454L;
    public final long mEntryScene;
    public final int mPageScene;
    public KSTubeParamInner mTubeParam;

    public TubeChannelParam(long j, int i) {
        this.mEntryScene = j;
        this.mPageScene = i;
    }

    public boolean isValid() {
        return this.mEntryScene != 0;
    }
}
