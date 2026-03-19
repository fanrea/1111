package com.alliance.ssp.ad.api.expressfeed;

import com.alliance.ssp.ad.api.BaseAllianceAd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface SAExpressFeedAd extends BaseAllianceAd {
    int getAdInteractionType();

    int getAdMode();

    void render();

    void setExpressFeedAdInteractionListener(SAExpressFeedAdInteractionListener sAExpressFeedAdInteractionListener);

    void setExpressFeedAdVideoListener(SAExpressFeedAdVideoListener sAExpressFeedAdVideoListener);
}
