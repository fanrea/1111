package com.kwad.components.ad.k;

import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends a<n> {
    public com.kwad.components.core.video.b NN;
    private boolean NO;
    private n NP;
    protected DetailVideoView mDetailVideoView;

    public b(AdTemplate adTemplate, DetailVideoView detailVideoView) {
        super(adTemplate);
        this.NO = false;
        this.NP = new o() { // from class: com.kwad.components.ad.k.b.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                b.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                b.this.mAdTemplate.setmCurPlayTime(j2);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                try {
                    super.onMediaPlayError(i, i2);
                    if (!b.this.NO) {
                        b.this.nN();
                    } else if (e.YI()) {
                        b.this.nN();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.mDetailVideoView = detailVideoView;
        this.NN = new com.kwad.components.core.video.b(this.mDetailVideoView, adTemplate);
        nL();
    }

    private void nL() {
        this.NN.c(this.NP);
    }

    private void nM() {
        n nVar;
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar == null || (nVar = this.NP) == null) {
            return;
        }
        bVar.d(nVar);
        this.NP = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN() {
        com.kwad.components.core.q.a.ss().f(this.mAdTemplate, 21008);
        this.NO = true;
    }

    @Override // com.kwad.components.ad.k.a
    public long getPlayDuration() {
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            return bVar.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.k.a
    public void resume() {
        this.NN.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public void pause() {
        this.NN.pause();
    }

    @Override // com.kwad.components.ad.k.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(n nVar) {
        com.kwad.components.core.video.b bVar;
        if (nVar == null || (bVar = this.NN) == null) {
            return;
        }
        bVar.c(nVar);
    }

    @Override // com.kwad.components.ad.k.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void a(n nVar) {
        if (nVar == null) {
            return;
        }
        this.NN.d(nVar);
    }

    @Override // com.kwad.components.ad.k.a
    public void release() {
        super.release();
        this.NO = false;
        nM();
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            bVar.clear();
            this.NN.release();
        }
    }
}
