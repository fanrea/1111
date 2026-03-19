package com.kwad.components.ct.tube.history;

import com.kwad.components.ct.api.tube.KSTubeParamInner;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeHistoryDetailParam implements Serializable {
    private static final long serialVersionUID = -5238032101385027452L;
    public long mEntryScene;
    public KSTubeParamInner mKSTubeParam;

    public boolean isValid() {
        return this.mEntryScene != 0;
    }
}
