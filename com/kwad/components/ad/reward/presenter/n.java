package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n extends b {
    private com.kwad.components.core.video.o lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.iL();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.m lw = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.c.r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            n.this.vb.tu.release();
            n.this.vb.gO();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.tu.a(this.lv);
        com.kwad.components.ad.reward.c.gs().a(this.lw);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lv);
        com.kwad.components.ad.reward.c.gs().b(this.lw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iL() {
        if (com.kwad.components.core.u.m.d(this.vb.mAdTemplate, this.vb.tN)) {
            com.kwad.components.core.u.m.f(this.vb.mContext, this.vb.mAdTemplate);
        }
        if (i.z(this.vb) || com.kwad.components.core.u.m.d(this.vb.mAdTemplate, this.vb.tN)) {
            bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.vb.gO();
                }
            }, 200L);
        } else {
            this.vb.gO();
        }
    }
}
