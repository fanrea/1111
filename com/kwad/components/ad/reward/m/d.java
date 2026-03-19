package com.kwad.components.ad.reward.m;

import android.content.Context;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.m;
import com.kwad.components.core.video.o;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.k.b implements g.a {
    private String CZ;
    private AtomicBoolean Da;
    private boolean Db;
    private final List<i.a> Dc;
    private final List<Object> Dd;
    private OfflineOnAudioConflictListener De;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean oX;
    private boolean rM;
    private o rO;
    private g vb;

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.Db = true;
        return true;
    }

    public d(g gVar, DetailVideoView detailVideoView) {
        super(gVar.mAdTemplate, detailVideoView);
        this.Da = new AtomicBoolean(false);
        this.Db = false;
        this.oX = false;
        this.Dc = new ArrayList();
        this.Dd = new ArrayList();
        this.De = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                d.a(d.this, true);
                if (d.this.NN != null) {
                    d.this.NN.setAudioEnabled(false);
                }
                synchronized (d.this.Dc) {
                    Iterator it = d.this.Dc.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (d.this.Dc) {
                    Iterator it = d.this.Dc.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.vb = gVar;
        this.mContext = gVar.mContext;
        this.mVideoPlayConfig = gVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.CZ = getVideoUrl();
    }

    private String getVideoUrl() {
        return kY() ? "" : m.g(this.mContext, this.mAdTemplate);
    }

    public final void kW() {
        if (this.Da.get()) {
            return;
        }
        this.Da.set(true);
        bx();
        this.rO = new o() { // from class: com.kwad.components.ad.reward.m.d.2
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.q.a.ss().g(d.this.mAdTemplate, i, i2);
            }
        };
        this.NN.c(this.rO);
        this.NN.a(new c.e() { // from class: com.kwad.components.ad.reward.m.d.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.c.b.aaf();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        d.this.NN.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        this.NN.start();
        com.kwad.components.core.u.a.aC(this.mContext).a(this.De);
    }

    private void bx() {
        if (kY()) {
            return;
        }
        this.NN.a(new b.a(this.mAdTemplate).ew(this.CZ).ex(h.e(com.kwad.sdk.core.response.b.e.eQ(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.NN.prepareAsync();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        this.oX = false;
        if (!this.Da.get() || this.NN == null || kY() || g.b(this.vb)) {
            return;
        }
        super.resume();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void pause() {
        if (!this.Da.get() || this.NN == null || kY()) {
            return;
        }
        super.pause();
    }

    private void stop() {
        pause();
        this.oX = true;
    }

    @Override // com.kwad.components.ad.k.a
    @Deprecated
    public final void skipToEnd() {
        if (!this.Da.get() || this.NN == null) {
            return;
        }
        this.NN.onPlayStateChanged(9);
        stop();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        com.kwad.components.core.u.a.aC(this.mContext).b(this.De);
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        if (this.Da.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.rM = z;
        if (!this.Da.get() || this.NN == null) {
            return;
        }
        if (z && z2) {
            com.kwad.components.core.u.a.aC(this.mContext).aS(true);
        }
        this.NN.setAudioEnabled(z);
    }

    public final void a(i.a aVar) {
        this.Dc.add(aVar);
    }

    public final void b(i.a aVar) {
        this.Dc.remove(aVar);
    }

    public final void kX() {
        Iterator<Object> it = this.Dd.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hh() {
        this.Db = false;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hi() {
        if (this.oX) {
            return;
        }
        resume();
        if (this.rM || (com.kwad.components.ad.reward.a.b.hG() && this.Db)) {
            com.kwad.components.core.u.a.aC(this.mContext).aS(com.kwad.components.ad.reward.a.b.hG());
            if (com.kwad.components.ad.reward.a.b.hG() && this.Db) {
                this.Db = false;
                this.rM = true;
                setAudioEnabled(true, false);
            } else {
                if (this.vb.ts || !com.kwad.components.core.u.a.aC(this.mContext).to()) {
                    return;
                }
                this.rM = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hj() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hk() {
        this.Db = false;
        if (!this.Da.get() || this.NN == null) {
            return;
        }
        this.NN.d(this.rO);
        this.NN.release();
    }

    private boolean kY() {
        return com.kwad.sdk.core.response.b.a.df(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate));
    }
}
