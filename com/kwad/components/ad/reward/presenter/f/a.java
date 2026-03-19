package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends d {
    private o Bq;

    @Override // com.kwad.components.ad.reward.presenter.f.d
    protected final boolean ka() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.Bq = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            public final boolean isMuted() {
                return !a.this.vb.mVideoPlayConfig.isVideoSoundEnable() || (!com.kwad.sdk.core.config.e.hG() && com.kwad.components.core.u.a.aC(a.this.getContext()).to());
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new x() { // from class: com.kwad.components.ad.reward.presenter.f.a.2
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                a.this.vb.tt.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(a.this.vb.tI, a.this.vb.mAdTemplate, a.this.vb.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                a.this.vb.tt.onVideoPlayEnd();
                a.this.vb.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(a.this.vb);
                if (yVar.wc()) {
                    com.kwad.components.ad.reward.g unused = a.this.vb;
                    com.kwad.components.ad.reward.g.a(a.this.vb.tB, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.g.a
                        /* renamed from: c, reason: merged with bridge method [inline-methods] */
                        public void accept(com.kwad.components.ad.reward.k.a aVar) {
                            com.kwad.components.ad.reward.g unused2 = a.this.vb;
                            aVar.jY();
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                a.this.vb.mAdTemplate.setmCurPlayTime(yVar.sp);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void a(y yVar) {
                super.a(yVar);
                long jWg = yVar.wg();
                a.this.vb.tt.onVideoPlayError(yVar.errorCode, (int) jWg);
                com.kwad.components.ad.reward.monitor.c.a(a.this.vb.tI, a.this.vb.mAdTemplate, a.this.vb.uh, yVar.errorCode, jWg);
                com.kwad.components.ad.reward.monitor.b.c(a.this.vb.tI, a.this.mAdTemplate);
            }
        });
    }

    public void a(ae.a aVar) {
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBv) + 0.5f);
        aVar.height = (int) ((screenHeight / fBv) + 0.5f);
    }
}
