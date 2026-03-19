package com.kwad.components.ad.draw.c;

import android.content.Context;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.o;
import com.kwad.components.core.widget.a.c;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b {
    private long gQ;
    private c gR;
    private com.kwad.sdk.contentalliance.a.a.a gS;
    private boolean gT;
    private boolean gU;
    private int gV;
    public boolean gW;
    public int gX;
    private boolean gY;
    private final com.kwad.sdk.core.j.c gZ;
    private Context mContext;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.gY = true;
        return true;
    }

    public a(AdTemplate adTemplate, c cVar, DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.gU = false;
        this.gV = -1;
        this.gW = true;
        this.gX = 0;
        this.gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.draw.c.a.3
            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                if (a.this.gS == null) {
                    a aVar = a.this;
                    aVar.gS = com.kwad.sdk.contentalliance.a.a.a.cf(aVar.mAdTemplate);
                    a.this.NN.a(a.this.gS);
                }
                if (a.this.gY || a.this.gT || !a.this.bu()) {
                    return;
                }
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                a.this.pause();
            }
        };
        this.gQ = com.kwad.sdk.core.response.b.a.ad(e.eP(this.mAdTemplate));
        this.gR = cVar;
        this.mContext = detailVideoView.getContext();
        bx();
        if (com.kwad.sdk.core.response.b.a.ck(e.eP(this.mAdTemplate))) {
            this.NN.setVolume(0.0f, 0.0f);
            this.gU = true;
        }
        this.NN.a(new c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar2) {
                try {
                    a.this.start(n.fn(a.this.mAdTemplate));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    public final void bt() {
        long jFn = n.fn(this.mAdTemplate);
        if (this.NN.tT() == null) {
            bx();
        }
        start(jFn);
        this.gR.a(this.gZ);
        b((com.kwad.components.core.video.n) new o() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                a.a(a.this, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.gR.ai() && bu() && !this.gY) {
            this.NN.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j));
            this.NN.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bu() {
        int i = this.gX;
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return this.gW;
        }
        return false;
    }

    public final void setVideoSound(boolean z) {
        if (this.NN == null) {
            return;
        }
        if (z) {
            this.NN.setVolume(1.0f, 1.0f);
            this.gU = false;
        } else {
            this.NN.setVolume(0.0f, 0.0f);
            this.gU = true;
        }
        this.gV = 1;
    }

    public final void bv() {
        this.gS = null;
        this.gR.b(this.gZ);
        this.NN.release();
    }

    public final void g(boolean z) {
        this.gT = z;
    }

    public final boolean bw() {
        return this.gY;
    }

    private void bx() {
        this.NN.a(new b.a(this.mAdTemplate).ew(e.eR(this.mAdTemplate)).ex(h.e(e.eQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).WR(), this.mDetailVideoView);
        this.NN.prepareAsync();
        if (this.gV != -1 || this.gU) {
            setVideoSound(!this.gU);
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.u.a.aC(this.mContext).aS(false);
    }
}
