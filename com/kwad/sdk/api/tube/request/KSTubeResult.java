package com.kwad.sdk.api.tube.request;

import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.tube.KSTubeChannelData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSTubeResult implements Serializable {
    private static final long serialVersionUID = 6228161005692192003L;
    public boolean hasMore;
    public List<KSTubeChannelData> tubeList = new ArrayList();

    private KSTubeResult() {
    }

    public static KSTubeResult obtain() {
        return new KSTubeResult();
    }

    public String toString() {
        return "KSTubeResult{hasMore=" + this.hasMore + ", tubeList=" + this.tubeList + '}';
    }
}
