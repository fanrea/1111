package com.kwad.components.ad.fullscreen.c;

import com.kwad.components.ad.reward.e.m;
import com.kwad.components.core.video.o;
import com.kwad.components.core.webview.tachikoma.c.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private o lv = new o() { // from class: com.kwad.components.ad.fullscreen.c.a.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.vb.gO();
        }
    };
    private final m lw = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.2
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            a.this.vb.tu.release();
            a.this.vb.gO();
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
}
