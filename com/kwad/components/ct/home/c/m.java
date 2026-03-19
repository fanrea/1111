package com.kwad.components.ct.home.c;

import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.refreshview.KsAdHotRefreshView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends com.kwad.components.ct.home.e {
    private KsAdHotRefreshView aHa;
    private SlidePlayViewPager amK;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAdHotRefreshView ksAdHotRefreshView = (KsAdHotRefreshView) findViewById(R.id.ksad_refresh_layout);
        this.aHa = ksAdHotRefreshView;
        ksAdHotRefreshView.setRefreshInitialOffset(0.0f);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.i("HomeViewPagerPresenter", "onBind");
        SlidePlayViewPager slidePlayViewPager = this.aGP.aok;
        this.amK = slidePlayViewPager;
        slidePlayViewPager.a(this.aGP, this.aHa);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.i("HomeViewPagerPresenter", "onUnbind");
        this.amK.destroy();
    }
}
