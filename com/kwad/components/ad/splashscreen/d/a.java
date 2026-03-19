package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b implements c {
    private String CZ;
    private final List<i.a> Dc;
    private OfflineOnAudioConflictListener De;
    public int Id;
    private boolean Ld;
    public long Le;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean rM;

    public a(AdTemplate adTemplate, final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.Dc = new ArrayList();
        this.De = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
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
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String strBf = com.kwad.sdk.core.response.b.a.bf(e.eP(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        e.eP(adTemplate);
        this.Id = h.ad(adTemplate) ? 2 : 1;
        File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(strBf);
        if (fileDw != null && fileDw.exists()) {
            this.CZ = fileDw.getAbsolutePath();
        }
        this.NN.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        com.kwad.components.ad.splashscreen.monitor.b.md();
                        com.kwad.components.ad.splashscreen.monitor.b.a(a.this.mAdTemplate, 1, a.this.Id, 2, jElapsedRealtime - a.this.Le, jElapsedRealtime - a.this.mAdTemplate.showTime);
                        boolean zA = ca.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + zA);
                        if (zA) {
                            a.this.NN.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.u.a.aC(this.mContext).a(this.De);
    }

    public final long getCurrentPosition() {
        return this.NN.getCurrentPosition();
    }

    private void bx() {
        com.kwad.sdk.contentalliance.a.a.b bVarWR = new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).ew(this.CZ).ex(com.kwad.sdk.core.response.b.h.e(e.eQ(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR();
        this.Le = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, 1, this.Id);
        this.NN.a(bVarWR, this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.NN.prepareAsync();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        if (this.rM && this.Ld) {
            com.kwad.components.core.u.a.aC(this.mContext).aS(false);
            if (com.kwad.components.core.u.a.aC(this.mContext).to()) {
                this.rM = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        com.kwad.components.core.u.a.aC(this.mContext).b(this.De);
    }

    public final void ag(boolean z) {
        this.Ld = true;
    }

    public final void no() {
        if (this.NN.tT() == null) {
            bx();
        }
        this.NN.start();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.rM = z;
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

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        resume();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        pause();
    }
}
