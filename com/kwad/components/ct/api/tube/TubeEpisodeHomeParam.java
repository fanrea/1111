package com.kwad.components.ct.api.tube;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeEpisodeHomeParam implements Serializable {
    private static final long serialVersionUID = -6597203831126070193L;
    public long mEntryScene;
    public KSTubeParamInner mKSTubeParam;
    public long mTubeId;
    public int watchEpisodeNum;

    private TubeEpisodeHomeParam() {
    }

    public static TubeEpisodeHomeParam obtain() {
        return new TubeEpisodeHomeParam();
    }

    public TubeEpisodeHomeParam setEntryScene(long j) {
        this.mEntryScene = j;
        return this;
    }

    public TubeEpisodeHomeParam setKSTubeParam(KSTubeParamInner kSTubeParamInner) {
        this.mKSTubeParam = kSTubeParamInner;
        return this;
    }

    public TubeEpisodeHomeParam setTubeId(long j) {
        this.mTubeId = j;
        return this;
    }

    public TubeEpisodeHomeParam setWatchEpisodeNum(int i) {
        this.watchEpisodeNum = i;
        return this;
    }
}
