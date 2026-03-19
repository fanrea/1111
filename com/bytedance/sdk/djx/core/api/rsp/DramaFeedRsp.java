package com.bytedance.sdk.djx.core.api.rsp;

import com.bytedance.sdk.djx.model.DJXEpisodeStatus;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaFeed;
import com.bytedance.sdk.djx.net.api.BaseDjxRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: DramaFeedRsp.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/djx/core/api/rsp/DramaFeedRsp;", "Lcom/bytedance/sdk/djx/net/api/BaseDjxRsp;", "", "Lcom/bytedance/sdk/djx/model/DramaFeed;", "()V", "drama", "Lcom/bytedance/sdk/djx/model/Drama;", "getDrama", "()Lcom/bytedance/sdk/djx/model/Drama;", "setDrama", "(Lcom/bytedance/sdk/djx/model/Drama;)V", "episodeStatusList", "Lcom/bytedance/sdk/djx/model/DJXEpisodeStatus;", "getEpisodeStatusList", "()Ljava/util/List;", "setEpisodeStatusList", "(Ljava/util/List;)V", "getData", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DramaFeedRsp extends BaseDjxRsp<List<? extends DramaFeed>> {
    private Drama drama;
    private List<DJXEpisodeStatus> episodeStatusList;

    public final List<DJXEpisodeStatus> getEpisodeStatusList() {
        return this.episodeStatusList;
    }

    public final void setEpisodeStatusList(List<DJXEpisodeStatus> list) {
        this.episodeStatusList = list;
    }

    public final Drama getDrama() {
        return this.drama;
    }

    public final void setDrama(Drama drama) {
        this.drama = drama;
    }

    @Override // com.bytedance.sdk.djx.net.api.BaseRsp
    public List<DramaFeed> getData() {
        List<DramaFeed> list = (List) super.getData();
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
