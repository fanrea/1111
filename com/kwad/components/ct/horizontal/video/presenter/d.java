package com.kwad.components.ct.horizontal.video.presenter;

import android.os.SystemClock;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bw;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.video.a.a {
    private static boolean axI = false;
    private com.kwad.components.ct.horizontal.video.b aLG;
    private bw ayY;
    private bw ayZ;
    private volatile long azl;
    private CtAdTemplate mAdTemplate;
    private l zg;
    private boolean aza = false;
    private boolean azi = false;
    private boolean aMQ = false;
    private boolean aOU = true;
    private boolean azk = true;
    private boolean om = false;
    private com.kwad.components.ct.horizontal.video.d aOH = new com.kwad.components.ct.horizontal.video.d() { // from class: com.kwad.components.ct.horizontal.video.presenter.d.1
        @Override // com.kwad.components.ct.horizontal.video.d
        public final void update() {
            d.a(d.this, false);
            d.this.azk = false;
            d.c(d.this, false);
            d.this.azl = 0L;
            if (d.this.zg != null) {
                d.this.zg.reset();
            }
            d dVar = d.this;
            dVar.aLG = dVar.aOD.aLG;
            if (d.this.aLG != null) {
                d.this.mAdTemplate.mMediaPlayerType = d.this.aLG.getMediaPlayerType();
                d.this.aLG.c(d.this.aMT);
            }
        }
    };
    private o aMT = new o() { // from class: com.kwad.components.ct.horizontal.video.presenter.d.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            d.this.CE();
            d.this.azl = SystemClock.elapsedRealtime();
            if (d.this.azi && d.this.azk) {
                com.kwad.components.ct.e.b.JK().f(d.this.mAdTemplate, com.kwad.components.core.video.c.ub().ue());
            }
            if (d.this.ayZ.AI()) {
                d.this.ayZ.AG();
                if (d.axI) {
                    com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onVideoPlaying resumeTiming playDuration: " + d.this.ayZ.getTime());
                }
            } else {
                d.this.ayZ.startTiming();
                if (d.axI) {
                    com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onVideoPlaying startTiming playDuration: " + d.this.ayZ.getTime());
                }
            }
            d.this.zg.uC();
            d.this.azk = false;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            if (d.this.ayZ.AI()) {
                d.this.ayZ.AG();
            }
            d.this.azk = false;
            d.this.azl = SystemClock.elapsedRealtime();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (j == j2) {
                d.d(d.this, true);
                d.this.HL();
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            d.this.ayZ.AH();
            d.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            d.this.ayZ.AH();
            if (d.axI) {
                com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onVideoPlayCompleted playDuration: " + d.this.ayZ.getTime());
            }
            d.d(d.this, true);
            d.this.zg.uC();
            d.this.HL();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            d.this.azk = true;
            if (d.this.azi) {
                com.kwad.components.ct.e.b.JK().a(d.this.aOD.mSceneImpl, d.this.mAdTemplate, d.this.azl > 0 ? SystemClock.elapsedRealtime() - d.this.azl : -1L, com.kwad.components.core.video.c.ub().ue());
            }
            d.this.ayZ.AH();
            if (d.axI) {
                com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onVideoPlayPaused playDuration: " + d.this.ayZ.getTime());
            }
            d.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            d.this.zg.uB();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            d.this.zg.uB();
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.horizontal.video.presenter.d.3
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            d.this.Cz();
            if (d.this.ayY.AI()) {
                d.this.ayY.AG();
                if (d.axI) {
                    com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onPageVisible resumeTiming stayDuration: " + d.this.ayY.getTime());
                    return;
                }
                return;
            }
            d.this.ayY.startTiming();
            if (d.axI) {
                com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onPageVisible startTiming stayDuration: " + d.this.ayY.getTime());
            }
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            d.this.ayY.AH();
            if (d.axI) {
                com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onPageInvisible stayDuration: " + d.this.ayY.getTime());
            }
        }
    };

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.azi = false;
        return false;
    }

    static /* synthetic */ boolean c(d dVar, boolean z) {
        dVar.aMQ = false;
        return false;
    }

    static /* synthetic */ boolean d(d dVar, boolean z) {
        dVar.om = true;
        return true;
    }

    @Override // com.kwad.components.ct.horizontal.video.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.ayY = new bw();
        this.ayZ = new bw();
        this.zg = new l();
        Cy();
        if (this.aOD.aLD != null) {
            this.aOD.aLD.a(this);
            this.aOD.aLD.a(this.aOH);
        }
        if (this.aOD.aFs != null) {
            this.aOD.aFs.a(this.gZ);
        }
        A(this.aOD.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aOD.aLD != null) {
            this.aOD.aLD.b(this);
            this.aOD.aLD.b(this.aOH);
        }
        com.kwad.components.ct.horizontal.video.b bVar = this.aLG;
        if (bVar != null) {
            bVar.d(this.aMT);
        }
        if (this.aOD.aFs != null) {
            this.aOD.aFs.b(this.gZ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        b(this.ayY.aqq(), this.ayZ.aqq(), 4);
    }

    private void Cy() {
        this.aza = false;
        this.azi = false;
        this.azk = false;
        this.om = false;
        this.aMQ = false;
        this.azl = 0L;
        l lVar = this.zg;
        if (lVar != null) {
            lVar.reset();
        }
    }

    @Override // com.kwad.components.ct.horizontal.video.c
    public final void A(CtAdTemplate ctAdTemplate) {
        this.mAdTemplate = ctAdTemplate;
        com.kwad.components.ct.horizontal.video.b bVar = this.aOD.aLG;
        this.aLG = bVar;
        if (bVar != null) {
            this.mAdTemplate.mMediaPlayerType = bVar.getMediaPlayerType();
            this.aLG.c(this.aMT);
        }
        if (!this.aOU) {
            b(this.ayY.aqq(), this.ayZ.aqq(), 3);
        }
        Cy();
        this.aOU = false;
        Cz();
        if (this.ayY.AI()) {
            this.ayY.AG();
            if (axI) {
                com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onPageVisible resumeTiming stayDuration: " + this.ayY.getTime());
                return;
            }
            return;
        }
        this.ayY.startTiming();
        if (axI) {
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " onPageVisible startTiming stayDuration: " + this.ayY.getTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        if (this.aza) {
            return;
        }
        this.aza = true;
        com.kwad.components.ct.e.b.JK().a(this.mAdTemplate, 0, com.kwad.components.core.video.c.ub().ue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CE() {
        if (this.azi || this.mAdTemplate == null) {
            return;
        }
        this.azi = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.aLG.Iu();
        String currentPlayingUrl = this.aOD.aLG != null ? this.aOD.aLG.getCurrentPlayingUrl() : "";
        String str = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate).videoInfo.width + "*" + com.kwad.components.ct.response.a.a.ay(this.mAdTemplate).videoInfo.height;
        if (axI) {
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", "reportPlayStart  startPlayDuration:" + jElapsedRealtime + "  p:" + str);
        }
        com.kwad.components.ct.e.b.JK().a(this.mAdTemplate, jElapsedRealtime, currentPlayingUrl, str, com.kwad.components.core.video.c.ub().ue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (this.aMQ || this.mAdTemplate == null) {
            return;
        }
        this.aMQ = true;
        com.kwad.components.ct.e.b.JK().ai(this.mAdTemplate);
    }

    private void b(long j, long j2, int i) {
        long jLongValue;
        if (j == 0) {
            return;
        }
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            jLongValue = com.kwad.sdk.core.response.b.a.M(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate)) * 1000;
        } else {
            jLongValue = com.kwad.components.ct.response.a.c.f((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate)).longValue();
        }
        if (axI) {
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerLogPresenter", " reportPlayFinish videoDuration: " + jLongValue + " stayDuration: " + j + " playDuration " + j2);
        }
        int i2 = this.om ? 1 : 2;
        l.a aVarUE = this.zg.uE();
        com.kwad.components.ct.e.b.JK().a(this.aOD.mSceneImpl, this.mAdTemplate, j2, i, j, aVarUE.uH(), aVarUE.uG(), i2);
    }
}
