package com.alliance.ssp.ad.a0;

import android.view.View;
import com.alliance.ssp.ad.api.stream.SAStreamAd;
import com.alliance.ssp.ad.api.stream.SAStreamAdInteractionListener;

/* compiled from: NMStreamAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i extends com.alliance.ssp.ad.t.g implements SAStreamAd {
    public SAStreamAdInteractionListener c = null;
    public View d = null;

    @Override // com.alliance.ssp.ad.t.g
    public String a() {
        return "1";
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public void destroy() {
    }

    @Override // com.alliance.ssp.ad.api.stream.SAStreamAd
    public View getStreamView() {
        return this.d;
    }

    @Override // com.alliance.ssp.ad.api.stream.SAStreamAd
    public void setStreamAdInteractionListener(SAStreamAdInteractionListener sAStreamAdInteractionListener) {
        this.c = sAStreamAdInteractionListener;
    }
}
