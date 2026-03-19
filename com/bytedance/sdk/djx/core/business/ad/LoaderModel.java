package com.bytedance.sdk.djx.core.business.ad;

import com.bytedance.sdk.djx.model.Feed;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LoaderModel {
    public String mAdm;
    public Feed mFeed;

    public static LoaderModel build() {
        return new LoaderModel();
    }

    private LoaderModel() {
    }

    public LoaderModel adm(String str) {
        this.mAdm = str;
        return this;
    }

    public LoaderModel feed(Feed feed) {
        this.mFeed = feed;
        return this;
    }
}
