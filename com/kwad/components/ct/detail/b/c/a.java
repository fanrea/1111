package com.kwad.components.ct.detail.b.c;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.n;
import com.kwad.sdk.widget.swipe.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b {
    private static boolean axI = false;
    private int abR;
    private SlidePlayViewPager aok;
    private com.kwad.components.core.widget.a.b asB;
    private c avG;
    private bw ayY;
    private bw ayZ;
    private long azc;
    private int azd;
    private CtAdTemplate mAdTemplate;
    private View mRootView;
    private SceneImpl mSceneImpl;
    private l zg;
    private boolean aza = false;
    private boolean azb = false;
    private n gr = new n() { // from class: com.kwad.components.ct.detail.b.c.a.1
        @Override // com.kwad.sdk.widget.n
        public final void aY() {
            com.kwad.sdk.utils.n.fm(a.this.mAdTemplate);
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.detail.b.c.a.2
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            a.this.Cz();
            if (a.this.ayY.AI()) {
                a.this.ayY.AG();
                if (a.axI) {
                    com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onPageVisible resumeTiming stayDuration: " + a.this.ayY.getTime());
                    return;
                }
                return;
            }
            a.this.ayY.startTiming();
            if (a.axI) {
                com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onPageVisible startTiming stayDuration: " + a.this.ayY.getTime());
            }
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            a.this.ayY.AH();
            if (a.axI) {
                com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onPageInvisible stayDuration: " + a.this.ayY.getTime());
            }
        }
    };
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.c.a.3
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (a.axI) {
                com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " becomesAttachedOnPageSelected");
            }
            if (a.this.asB != null) {
                com.kwad.sdk.utils.n.fm(a.this.mAdTemplate);
                a.this.asB.a(a.this.gZ);
            } else {
                com.kwad.sdk.core.d.c.w("DetailLogPagePresenter", "mVisibleHelper is null");
            }
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            com.kwad.sdk.utils.n.fk(a.this.mAdTemplate);
            if (a.axI) {
                com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " becomesDetachedOnPageSelected");
            }
            if (a.this.asB != null) {
                a.this.asB.b(a.this.gZ);
                a.this.m(a.this.ayY.aqq(), a.this.ayZ.aqq());
                a.this.Cy();
                return;
            }
            com.kwad.sdk.core.d.c.w("DetailLogPagePresenter", "mVisibleHelper is null");
        }
    };
    private com.kwad.sdk.widget.swipe.a aqH = new com.kwad.sdk.widget.swipe.b() { // from class: com.kwad.components.ct.detail.b.c.a.4
        @Override // com.kwad.sdk.widget.swipe.b, com.kwad.sdk.widget.swipe.a
        public final void j(float f) {
            if (a.this.azb || f == 0.0f) {
                return;
            }
            a aVar = a.this;
            aVar.h(aVar.aop.mAdTemplate);
        }
    };
    boolean aze = false;
    boolean azf = false;
    private com.kwad.components.core.video.n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.b.c.a.5
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            if (a.this.ayZ.AI()) {
                a.this.ayZ.AG();
            }
            if (a.axI) {
                com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onVideoPlayStart resumeTiming playDuration: " + a.this.ayZ.getTime());
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.azc = j2;
            a.this.CB();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (a.this.ayZ.AI()) {
                a.this.ayZ.AG();
                if (a.axI) {
                    com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onVideoPlaying resumeTiming playDuration: " + a.this.ayZ.getTime());
                }
            } else {
                a.this.ayZ.startTiming();
                if (a.axI) {
                    com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onVideoPlaying startTiming playDuration: " + a.this.ayZ.getTime());
                }
            }
            a.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.ayZ.AH();
            if (a.axI) {
                com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onVideoPlayPaused playDuration: " + a.this.ayZ.getTime());
            }
            a.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            a.this.ayZ.AH();
            a.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.ayZ.AH();
            if (a.axI) {
                com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + a.this.abR + " onVideoPlayCompleted playDuration: " + a.this.ayZ.getTime());
            }
            a.m(a.this);
            a.this.azc = 0L;
            a.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.zg.uB();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.zg.uB();
        }
    };

    static /* synthetic */ int m(a aVar) {
        int i = aVar.azd;
        aVar.azd = i + 1;
        return i;
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mRootView = getRootView();
        j jVar = this.aop.aol;
        if (jVar != null) {
            this.asB = jVar.aFs;
            this.mSceneImpl = jVar.mSceneImpl;
            this.avG = jVar.avG;
        }
        this.mAdTemplate = this.aop.mAdTemplate;
        this.abR = this.aop.abR;
        View view = this.mRootView;
        if (view instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) view).setVisibleListener(this.gr);
        }
        this.aok = this.aop.aok;
        this.ayY = new bw();
        this.ayZ = new bw();
        this.zg = new l();
        Cy();
        this.aop.aoq.add(0, this.aoQ);
        if (this.aop.aoz != null) {
            this.mAdTemplate.mMediaPlayerType = this.aop.aoz.getMediaPlayerType();
            this.aop.aoz.c(this.mVideoPlayStateListener);
        }
        this.aop.aot.add(this.aqH);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.mVideoPlayStateListener);
        }
        this.aop.aot.remove(this.aqH);
        View view = this.mRootView;
        if (view instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) view).setVisibleListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy() {
        this.azd = 0;
        this.azc = 0L;
        this.aza = false;
        this.azb = false;
        l lVar = this.zg;
        if (lVar != null) {
            lVar.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        if (this.aza) {
            return;
        }
        this.aza = true;
        SlidePlayViewPager slidePlayViewPager = this.aok;
        if (slidePlayViewPager == null) {
            return;
        }
        int preItem = slidePlayViewPager.getPreItem();
        int currentItem = this.aok.getCurrentItem();
        int i = 3;
        if (!this.aok.Dc()) {
            this.aok.setReportedItemImpression(true);
        } else if (currentItem > preItem) {
            i = 1;
        } else if (currentItem < preItem) {
            i = 2;
        }
        if (axI) {
            com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + this.abR + " reportItemImpression enterType=" + i);
        }
        com.kwad.components.ct.e.b.JK().a(this.mAdTemplate, i, com.kwad.components.core.video.c.ub().ue());
        d.g(com.kwad.components.ec.api.a.class);
        this.aop.aol.aHt++;
        if (this.azb || CA()) {
            return;
        }
        h(this.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(long j, long j2) {
        long jLongValue;
        if (j == 0) {
            return;
        }
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            jLongValue = com.kwad.sdk.core.response.b.a.M(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate)) * 1000;
        } else {
            jLongValue = com.kwad.components.ct.response.a.c.f((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate)).longValue();
        }
        if (this.aok == null) {
            return;
        }
        if (axI) {
            com.kwad.sdk.core.d.c.d("DetailLogPagePresenter", "position: " + this.abR + " reportPlayFinish videoDuration: " + jLongValue + " stayDuration: " + j + " playDuration " + j2);
        }
        int i = (this.azd <= 0 || this.azc != 0) ? 2 : 1;
        this.aok.getPreItem();
        this.aok.getCurrentItem();
        l.a aVarUE = this.zg.uE();
        com.kwad.components.ct.e.b.JK().a(this.mSceneImpl, this.mAdTemplate, j2, i, j, aVarUE.uH(), aVarUE.uG(), 0);
        d.g(com.kwad.components.ec.api.a.class);
    }

    private boolean CA() {
        if (this.avG == null) {
            return false;
        }
        SlidePlayViewPager slidePlayViewPager = this.aok;
        return !(slidePlayViewPager == null || slidePlayViewPager.getSourceType() == 0) || this.avG.aqZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CtAdTemplate ctAdTemplate) {
        this.azb = true;
        if (this.aop.aoB) {
            com.kwad.components.ct.e.b.JK().aj(ctAdTemplate);
        }
        if (this.aop.aoC) {
            com.kwad.components.ct.e.b.JK().ak(ctAdTemplate);
        }
        if (this.aop.aoD) {
            com.kwad.components.ct.e.b.JK().al(ctAdTemplate);
        }
        if (this.aop.aoE) {
            com.kwad.components.ct.e.b.JK().am(ctAdTemplate);
        }
        if (this.aop.aoF) {
            com.kwad.components.ct.e.b.JK().an(ctAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB() {
        if (((com.kwad.components.ec.api.a) d.g(com.kwad.components.ec.api.a.class)) == null) {
            return;
        }
        long j = this.azc;
        if (j >= com.alipay.sdk.m.u.b.a && j < 5000) {
            if (this.aze) {
                return;
            }
            this.aze = true;
        } else {
            if (j < 5000 || this.azf) {
                return;
            }
            this.azf = true;
        }
    }
}
