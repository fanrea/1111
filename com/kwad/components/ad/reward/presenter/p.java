package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p extends b {
    private com.kwad.components.core.playable.a tv;
    private PlayableSource xV;
    private final com.kwad.components.ad.reward.e.j xW = new com.kwad.components.ad.reward.e.k() { // from class: com.kwad.components.ad.reward.presenter.p.1
        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
            p.this.xV = playableSource;
            if (p.this.tv != null && p.this.tv.sf()) {
                p.this.tv.e(playableSource);
                if (p.this.vb != null) {
                    p.this.vb.d(playableSource);
                    p.this.vb.C(true);
                    if (p.this.vb.tu.la()) {
                        p.this.vb.tu.lb().pause();
                    }
                }
                com.kwad.components.ad.reward.a.gl().b(playableSource);
                return;
            }
            if (p.this.tv != null) {
                p.this.tv.iO();
            }
            if (nVar != null) {
                nVar.ih();
                com.kwad.sdk.core.d.c.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(p.this.vb.mAdTemplate))) {
                DownloadLandPageActivity.launch(p.this.getActivity(), p.this.vb.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.e.k, com.kwad.components.ad.reward.e.j
        public final void dp() {
            p.this.tv.iO();
            if (p.this.vb != null) {
                p.this.vb.d((PlayableSource) null);
                if (p.this.vb.tu.la()) {
                    p.this.vb.tu.lb().resume();
                }
            }
        }
    };

    public final void e(PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.tv;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.xV);
            }
        }
    }

    public final void iO() {
        com.kwad.components.core.playable.a aVar = this.tv;
        if (aVar != null) {
            aVar.iO();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.playable.a aVar = this.vb.tv;
        this.tv = aVar;
        if (aVar == null) {
            return;
        }
        aVar.a(this.vb.mAdTemplate, this.vb.mRootContainer, this.vb.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.c.a(this.vb.tI, "playable");
        com.kwad.components.ad.reward.monitor.c.a(this.vb.mAdTemplate, this.vb.tI, "playable", com.kwad.sdk.core.response.b.a.bZ(com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate)));
        this.tv.se();
        this.tv.a(new at.b() { // from class: com.kwad.components.ad.reward.presenter.p.2
            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar2) {
                if (aVar2.isSuccess()) {
                    return;
                }
                AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(p.this.vb.mAdTemplate);
                long loadTime = p.this.vb.tv.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.a(p.this.vb.mAdTemplate, p.this.vb.tI, "playable", com.kwad.sdk.core.response.b.a.bZ(adInfoEP), System.currentTimeMillis() - loadTime, 3);
            }
        });
        this.tv.a(new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(p.this.vb.mAdTemplate, p.this.vb.tI, "playable", com.kwad.sdk.core.response.b.a.bZ(com.kwad.sdk.core.response.b.e.eP(p.this.vb.mAdTemplate)), System.currentTimeMillis() - p.this.vb.tv.getLoadTime(), 2);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(p.this.vb.mAdTemplate);
                long loadTime = p.this.vb.tv.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.c.a(p.this.vb.tI, "playable", com.kwad.sdk.core.response.b.a.bZ(adInfoEP), System.currentTimeMillis() - loadTime);
            }
        });
        com.kwad.components.ad.reward.a.gl().a(this.xW);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.tv;
        if (aVar == null) {
            return;
        }
        aVar.sd();
        this.tv.iO();
        com.kwad.components.ad.reward.a.gl().b(this.xW);
    }
}
