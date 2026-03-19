package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.model.DJXEpisodeStatus;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaDetailRsp extends BaseDjxRsp<List<DramaDetail>> {
    private Drama drama;
    private List<DJXEpisodeStatus> episodeStatusList;

    public List<DJXEpisodeStatus> getEpisodeStatusList() {
        return this.episodeStatusList;
    }

    public void setEpisodeStatusList(List<DJXEpisodeStatus> list) {
        this.episodeStatusList = list;
    }

    public Drama getDrama() {
        return this.drama;
    }

    public void setDrama(Drama drama) {
        this.drama = drama;
    }
}
