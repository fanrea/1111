package com.alliance.ssp.ad.y;

import com.alliance.ssp.ad.api.reward.SARewardVideoAd;
import com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener;
import com.alliance.ssp.ad.t.g;

/* compiled from: NMRewardVideoAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f extends g implements SARewardVideoAd {
    public static final Object d = new Object();
    public SARewardVideoAdInteractionListener c = null;

    @Override // com.alliance.ssp.ad.t.g
    public String a() {
        return "1";
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public void destroy() {
    }

    @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAd
    public void setRewardVideoAdInteractionListener(SARewardVideoAdInteractionListener sARewardVideoAdInteractionListener) {
        synchronized (d) {
            this.c = sARewardVideoAdInteractionListener;
        }
    }
}
