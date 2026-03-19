package com.alliance.ssp.ad.t;

import com.alliance.ssp.ad.api.BaseAllianceAd;
import com.alliance.ssp.ad.api.YTAdInfo;

/* compiled from: BaseAllianceAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class g implements BaseAllianceAd {
    public String a = "";
    public YTAdInfo b;

    public abstract String a();

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public YTAdInfo getAdInfo() {
        return this.b;
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public String getAdPlatformType() {
        return a();
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public String getECPM() {
        return this.a;
    }
}
