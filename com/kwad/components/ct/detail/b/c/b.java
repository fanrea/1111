package com.kwad.components.ct.detail.b.c;

import android.os.SystemClock;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.e;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private static boolean axI = false;
    private int abR;
    private SlidePlayViewPager aok;
    private com.kwad.components.core.widget.a.b asB;
    private volatile long azl;
    private CtAdTemplate mAdTemplate;
    private SceneImpl mSceneImpl;
    private long azh = 0;
    private boolean azi = false;
    private int azj = 0;
    private boolean azk = true;
    private boolean azm = false;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.b.c.b.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.aop.aol.aHl = b.this.aop.mAdTemplate;
            b.this.azk = false;
            b.c(b.this);
            c.d("DetailLogVideoPresenter", "onVideoPlayStart() mPlayTimes=" + b.this.azj);
            if (b.this.azj > 1) {
                b.this.CD();
                if (((com.kwad.components.ec.api.a) d.g(com.kwad.components.ec.api.a.class)) != null) {
                    CtAdTemplate unused = b.this.mAdTemplate;
                }
            }
            if (!b.this.azm) {
                b.this.azh = SystemClock.elapsedRealtime();
            }
            b.this.azl = SystemClock.elapsedRealtime();
            if (b.axI) {
                c.d("DetailLogVideoPresenter", "position: " + b.this.abR + " onVideoPlayStart");
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (b.axI) {
                c.d("DetailLogVideoPresenter", "position: " + b.this.abR + " onVideoPlaying");
            }
            b.this.CE();
            b.this.azl = SystemClock.elapsedRealtime();
            if (b.this.azi && b.this.azk) {
                com.kwad.components.ct.e.b.JK().f(b.this.mAdTemplate, com.kwad.components.core.video.c.ub().ue());
            }
            b.this.azk = false;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.azk = true;
            if (b.this.azi) {
                com.kwad.components.ct.e.b.JK().a(b.this.mSceneImpl, b.this.mAdTemplate, b.this.azl > 0 ? SystemClock.elapsedRealtime() - b.this.azl : -1L, com.kwad.components.core.video.c.ub().ue());
            }
        }
    };
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.c.b.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (b.axI) {
                c.d("DetailLogVideoPresenter", "position: " + b.this.abR + " becomesAttachedOnPageSelected");
            }
            b.this.azh = SystemClock.elapsedRealtime();
            if (b.this.asB != null) {
                b.this.asB.a(b.this.gZ);
            } else {
                c.w("DetailLogVideoPresenter", "mVisibleHelper is null");
            }
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            if (b.axI) {
                c.d("DetailLogVideoPresenter", "position: " + b.this.abR + " becomesDetachedOnPageSelected");
            }
            if (b.this.asB != null) {
                b.this.asB.b(b.this.gZ);
                b.this.Cy();
            } else {
                c.w("DetailLogVideoPresenter", "mVisibleHelper is null");
            }
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.detail.b.c.b.3
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (b.axI) {
                c.d("DetailLogVideoPresenter", "position: " + b.this.abR + " onPageVisible");
            }
            b.this.azm = true;
            b.this.azh = SystemClock.elapsedRealtime();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            b.this.azm = false;
        }
    };

    static /* synthetic */ int c(b bVar) {
        int i = bVar.azj;
        bVar.azj = i + 1;
        return i;
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        j jVar = this.aop.aol;
        if (jVar != null) {
            this.asB = jVar.aFs;
            this.mSceneImpl = jVar.mSceneImpl;
        }
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aok = this.aop.aok;
        this.abR = this.aop.abR;
        Cy();
        this.aop.aoq.add(this.aoQ);
        if (this.aop.aoz != null) {
            this.aop.aoz.c(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.mVideoPlayStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy() {
        this.azm = false;
        this.azi = false;
        this.azk = false;
        this.azl = 0L;
        this.azj = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CD() {
        if (e.a(this.mAdTemplate)) {
            com.kwad.components.ct.e.b.JK().q(this.mAdTemplate, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CE() {
        if (this.azi) {
            return;
        }
        this.azi = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.azh;
        if (axI) {
            c.d("DetailLogVideoPresenter", "position: " + this.abR + " startPlayDuration startPlayDuration: " + jElapsedRealtime);
        }
        com.kwad.components.ct.e.b.JK().a(this.mAdTemplate, jElapsedRealtime, this.aop.aoz != null ? this.aop.aoz.getCurrentPlayingUrl() : "", com.kwad.components.core.video.c.ub().ue());
        CF();
    }

    private void CF() {
        SlidePlayViewPager slidePlayViewPager = this.aok;
        int i = 1;
        if (slidePlayViewPager != null) {
            int preItem = slidePlayViewPager.getPreItem();
            int currentItem = this.aok.getCurrentItem();
            if (currentItem > preItem) {
                i = 3;
            } else if (currentItem < preItem) {
                i = 2;
            }
        }
        com.kwad.components.ct.e.b.JK().a((AdTemplate) this.mAdTemplate, System.currentTimeMillis(), i);
    }
}
