package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends b {
    private final AdLiveCallerContextListener xz = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.vb);
        }
    };
    private final com.kwad.components.core.n.a.a xA = new com.kwad.components.core.n.a.b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            super.c(fVar);
            if (k.this.vb.tu.la()) {
                k.this.vb.tu.lb().onResume();
                if (com.kwad.components.core.u.a.aC(k.this.vb.mContext).to()) {
                    k.this.vb.d(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            if (k.this.vb.tu.la()) {
                k.this.vb.tu.lb().onPause();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.vb.tu.la()) {
            this.vb.tu.lb().registerAdLiveCallerContextListener(this.xz);
            this.vb.Th.add(this.xA);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.vb.tu.la()) {
            this.vb.tu.lb().unRegisterAdLiveCallerContextListener(this.xz);
            this.vb.Th.remove(this.xA);
        }
    }
}
