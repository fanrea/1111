package com.alliance.ssp.ad.x;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdVideoListener;
import com.alliance.ssp.ad.api.nativead.SANativeFeedAd;
import com.alliance.ssp.ad.api.nativead.SANativeFeedAdInteractionListener;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import java.util.List;

/* compiled from: NMNativeFeedAdView.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h extends com.alliance.ssp.ad.t.g implements SANativeFeedAd {
    public SANativeFeedAdInteractionListener c;
    public SAExpressFeedAdVideoListener d;
    public int e = -1;
    public int f = -1;
    public SAAllianceAdData g;
    public c h;

    @Override // com.alliance.ssp.ad.t.g
    public String a() {
        return "1";
    }

    @Override // com.alliance.ssp.ad.api.BaseAllianceAd
    public void destroy() {
    }

    @Override // com.alliance.ssp.ad.api.nativead.SANativeFeedAd
    public int getAdInteractionType() {
        return this.f;
    }

    @Override // com.alliance.ssp.ad.api.nativead.SANativeFeedAd
    public int getAdMode() {
        return this.e;
    }

    @Override // com.alliance.ssp.ad.api.nativead.SANativeFeedAd
    public /* bridge */ /* synthetic */ void registerView(Activity activity, ViewGroup viewGroup, List list, b bVar) {
    }

    @Override // com.alliance.ssp.ad.api.nativead.SANativeFeedAd
    public void setExpressFeedAdVideoListener(SAExpressFeedAdVideoListener sAExpressFeedAdVideoListener) {
        this.d = sAExpressFeedAdVideoListener;
    }

    @Override // com.alliance.ssp.ad.api.nativead.SANativeFeedAd
    public void setNativeFeedInteractionListener(View view, SANativeFeedAdInteractionListener sANativeFeedAdInteractionListener) {
        this.c = sANativeFeedAdInteractionListener;
    }
}
