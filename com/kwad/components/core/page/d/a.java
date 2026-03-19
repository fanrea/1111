package com.kwad.components.core.page.d;

import android.content.Context;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.m;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements com.kwad.components.core.n.a.a {
    private String CZ;
    private boolean Db = false;
    private final List<i.a> Dc = new ArrayList();
    private OfflineOnAudioConflictListener De = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.d.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.NN != null) {
                a.this.NN.setAudioEnabled(false);
            }
            synchronized (a.this.Dc) {
                Iterator it = a.this.Dc.iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).onAudioBeOccupied();
                }
            }
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            synchronized (a.this.Dc) {
                Iterator it = a.this.Dc.iterator();
                while (it.hasNext()) {
                    ((i.a) it.next()).onAudioBeReleased();
                }
            }
        }
    };
    private b NN;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean rM;
    private o rO;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.Db = true;
        return true;
    }

    public a(final AdTemplate adTemplate, DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        this.mContext = detailVideoView.getContext();
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.CZ = m.g(this.mContext, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.NN = new b(detailVideoView, adTemplate);
        bx();
        o oVar = new o() { // from class: com.kwad.components.core.page.d.a.2
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.q.a.ss().g(adTemplate, i, i2);
            }
        };
        this.rO = oVar;
        this.NN.c(oVar);
        this.NN.a(new c.e() { // from class: com.kwad.components.core.page.d.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    a.this.NN.start();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        com.kwad.components.core.u.a.aC(this.mContext).a(this.De);
    }

    private void bx() {
        this.NN.a(new b.a(this.mAdTemplate).ew(this.CZ).ex(h.e(e.eQ(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.NN.prepareAsync();
    }

    private void resume() {
        this.NN.resume();
    }

    private void pause() {
        if (this.mAdTemplate.mXiaomiAppStoreDetailViewOpen && this.mAdTemplate.mAdScene != null && this.mAdTemplate.mAdScene.getAdStyle() == 2) {
            return;
        }
        this.NN.pause();
    }

    public final void a(n nVar) {
        if (nVar == null) {
            return;
        }
        this.NN.c(nVar);
    }

    public final void b(n nVar) {
        if (nVar == null) {
            return;
        }
        this.NN.d(nVar);
    }

    public final void release() {
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            bVar.clear();
            this.NN.release();
        }
        com.kwad.components.core.u.a.aC(this.mContext).b(this.De);
    }

    @Override // com.kwad.components.core.n.a.a
    public final void hc() {
        this.Db = false;
        if (this.NN.tT() == null) {
            bx();
        }
    }

    @Override // com.kwad.components.core.n.a.a
    public final void c(f fVar) {
        resume();
    }

    @Override // com.kwad.components.core.n.a.a
    public final void d(f fVar) {
        pause();
    }

    @Override // com.kwad.components.core.n.a.a
    public final void hd() {
        this.Db = false;
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            bVar.d(this.rO);
            this.NN.release();
        }
    }

    private void setAudioEnabled(boolean z, boolean z2) {
        this.rM = z;
        this.NN.setAudioEnabled(z);
    }
}
