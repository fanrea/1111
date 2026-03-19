package com.kwad.components.ad.feed.monitor;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FeedErrorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = 5562303989639679849L;
    public long errorType;
    public long feedType;
    public long materialType;
    public long width;

    public FeedErrorInfo setMaterialType(long j) {
        this.materialType = j;
        return this;
    }

    public FeedErrorInfo setWidth(long j) {
        this.width = j;
        return this;
    }

    public FeedErrorInfo setFeedType(int i) {
        this.feedType = i;
        return this;
    }

    public FeedErrorInfo setErrorType(int i) {
        this.errorType = i;
        return this;
    }
}
