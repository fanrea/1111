package com.kwad.sdk.api.tube.detail;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.tube.KSTubeData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSTubeEpisodeResult implements Serializable {
    private static final long serialVersionUID = 2457171407475162178L;
    public boolean hasMore;
    public List<KSTubeData> tubeEpisodeList = new ArrayList();
    List<Integer> tubeEpisodeNumList = new ArrayList();

    private KSTubeEpisodeResult() {
    }

    public static KSTubeEpisodeResult obtain() {
        return new KSTubeEpisodeResult();
    }

    public KSTubeEpisodeResult setHasMore(boolean z) {
        this.hasMore = z;
        return this;
    }

    public KSTubeEpisodeResult setTubeEpisodeNumList(List<Integer> list) {
        this.tubeEpisodeNumList = list;
        return this;
    }

    public KSTubeEpisodeResult setTubeEpisodeList(List<KSTubeData> list) {
        this.tubeEpisodeList = list;
        return this;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public List<KSTubeData> getTubeEpisodeList() {
        return this.tubeEpisodeList;
    }

    public List<Integer> getTubeEpisodeNumList() {
        return this.tubeEpisodeNumList;
    }

    public String toString() {
        return "KSTubeEpisodeResult{hasMore=" + this.hasMore + ", tubeEpisodeList=" + this.tubeEpisodeList + ", tubeEpisodeNumList=" + this.tubeEpisodeNumList + '}';
    }
}
