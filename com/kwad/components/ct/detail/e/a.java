package com.kwad.components.ct.detail.e;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kwad.components.core.k.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.i;
import com.kwai.video.ksvodplayerkit.prefetcher.AdaptivePrefetchModel;
import com.kwai.video.ksvodplayerkit.prefetcher.BasePrefetchModel;
import com.kwai.video.ksvodplayerkit.prefetcher.KSPrefetcher;
import com.kwai.video.ksvodplayerkit.prefetcher.NomalPrefetchModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements com.kwad.components.core.k.a, g, cb.a {
    private static boolean azy = false;
    private String CZ;
    private b NN;
    private i aao;
    private c.d acb;
    private KsFragment alG;
    private SlidePlayViewPager aok;
    private j aol;
    private long aww;
    private boolean ayh;
    private ViewGroup azx;
    private cb dC;
    private CtAdTemplate mAdTemplate;
    private Context mContext;
    private final int mCurrentPosition;
    private DetailVideoView mDetailVideoView;
    private o rO;
    private com.kwad.sdk.contentalliance.a.a.a gS = null;
    private int azz = 0;
    private AtomicBoolean azA = new AtomicBoolean(false);
    public final com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.detail.e.a.3
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            a.this.CK();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            a.this.CL();
        }
    };
    private com.kwad.components.core.k.c azB = new d() { // from class: com.kwad.components.ct.detail.e.a.4
        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onResume() {
            if (ca.a(a.this.azx, 70, false) && a.this.ayh) {
                com.kwad.components.core.video.c.ub().a(a.this);
            }
        }

        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onPause() {
            if (com.kwad.components.ct.response.a.a.eH(a.this.mAdTemplate) && a.this.CP() && (a.this.azz == 2 || a.this.azz == 1)) {
                a.a(a.this, 0);
            }
            a.this.pause();
        }

        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onDestroyView() {
            com.kwad.sdk.core.d.c.d("DetailPlayModule", "onDestroyView mCurrentPosition" + a.this.mCurrentPosition);
            a.this.wL();
            a.this.NN.b(a.this.acb);
            a.this.NN.release();
        }

        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onDestroy() {
            com.kwad.sdk.core.d.c.d("DetailPlayModule", "onDestroy mCurrentPosition=" + a.this.mCurrentPosition);
            a.this.wL();
            a.this.NN.b(a.this.acb);
            a.this.NN.d(a.this.rO);
            a.this.CO();
            a.this.NN.release();
        }
    };
    private List<InterfaceC0507a> azC = new ArrayList();
    private List<com.kwad.sdk.core.j.c> azD = new ArrayList();

    /* renamed from: com.kwad.components.ct.detail.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0507a {
        boolean yM();
    }

    @Override // com.kwad.components.core.k.a
    public final void qA() {
    }

    @Override // com.kwad.components.core.k.a
    public final void qB() {
    }

    static /* synthetic */ int a(a aVar, int i) {
        aVar.azz = 0;
        return 0;
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        return aVar.bD(false);
    }

    public a(KsFragment ksFragment, SlidePlayViewPager slidePlayViewPager, DetailVideoView detailVideoView, final CtAdTemplate ctAdTemplate, j jVar) {
        this.alG = ksFragment;
        this.mContext = ksFragment.getContext();
        this.aok = slidePlayViewPager;
        this.mAdTemplate = ctAdTemplate;
        int showPosition = ctAdTemplate.getShowPosition();
        this.mCurrentPosition = showPosition;
        this.aol = jVar;
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
            this.CZ = com.kwad.sdk.core.response.b.a.L(adInfoEP);
            this.aww = com.kwad.sdk.core.response.b.a.ad(adInfoEP);
        } else {
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
            this.CZ = com.kwad.components.ct.response.a.c.d((PhotoInfo) ctPhotoInfoAy);
            this.aww = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
        }
        this.aao = new i(ksFragment.getContext());
        this.mDetailVideoView = detailVideoView;
        this.NN = new b(detailVideoView, showPosition);
        bx();
        this.aao = new i(ksFragment.getContext());
        this.NN.a(new c.e() { // from class: com.kwad.components.ct.detail.e.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    if (a.a(a.this, false) && a.this.ayh && a.this.alG.isResumed() && ca.v(a.this.azx, 70)) {
                        a.this.NN.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        o oVar = new o() { // from class: com.kwad.components.ct.detail.e.a.2
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                a.this.mAdTemplate.setmCurPlayTime(j2);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                super.onMediaPlaying();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                a.this.mAdTemplate.setmCurPlayTime(-1L);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.ct.e.b.JK().g(ctAdTemplate, i, i2);
            }
        };
        this.rO = oVar;
        this.NN.c(oVar);
        this.NN.a(CM());
        this.azx = (ViewGroup) detailVideoView.getParent().getParent();
    }

    public final boolean isPlaying() {
        return this.NN.isPlaying();
    }

    public final boolean isPreparing() {
        return this.NN.isPreparing();
    }

    public final int getMediaPlayerType() {
        return this.NN.getMediaPlayerType();
    }

    @Override // com.kwad.components.core.k.a
    public final void qy() {
        com.kwad.sdk.core.d.c.d("DetailPlayModule", "becomesAttachedOnPageSelected mCurrentPosition=" + this.mCurrentPosition);
        com.kwad.components.core.video.c.ub().a(this);
        wK();
        this.ayh = true;
        if (this.NN.tT() == null) {
            bx();
        }
        if (bD(false)) {
            this.NN.start();
        }
        j jVar = this.aol;
        if (jVar != null) {
            jVar.aFs.a(this.gZ);
            this.aol.aGQ.r(this);
        }
    }

    @Override // com.kwad.components.core.k.a
    public final void qz() {
        com.kwad.sdk.core.d.c.d("DetailPlayModule", "becomesDetachedOnPageSelected mCurrentPosition=" + this.mCurrentPosition);
        wL();
        this.ayh = false;
        com.kwad.components.core.video.c.ub().b(this);
        this.gS = null;
        this.NN.release();
        CO();
        j jVar = this.aol;
        if (jVar != null) {
            jVar.aFs.b(this.gZ);
            this.aol.aGQ.s(this);
            CL();
        }
    }

    public final com.kwad.components.core.k.c CH() {
        return this.azB;
    }

    public final void c(n nVar) {
        this.NN.c(nVar);
    }

    public final void d(n nVar) {
        this.NN.d(nVar);
    }

    private void bx() {
        com.kwad.sdk.core.d.c.d("DetailPlayModule", "createPlayerAndPrepare()");
        com.kwad.sdk.contentalliance.a.a.b bVarWR = new b.a(this.mAdTemplate).ew(CI()).ex(com.kwad.components.ct.response.a.c.e((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR();
        com.kwad.sdk.core.d.c.e("DetailPlayModule", "mPhotoId =" + this.aww + " clickTime=" + bVarWR.buO.clickTime);
        this.NN.a(bVarWR, this.mDetailVideoView);
        this.NN.prepareAsync();
    }

    private String CI() {
        if (com.kwad.components.ct.a.b.xh()) {
            return com.kwad.sdk.core.videocache.c.a.ch(this.mContext.getApplicationContext()).ga(this.CZ);
        }
        return this.CZ;
    }

    public final void a(InterfaceC0507a interfaceC0507a) {
        this.azC.add(interfaceC0507a);
    }

    public final void b(InterfaceC0507a interfaceC0507a) {
        this.azC.remove(interfaceC0507a);
    }

    @Override // com.kwad.components.core.video.g
    public final void resume() {
        bC(false);
    }

    public final void bC(boolean z) {
        if (this.ayh && this.alG.isResumed() && bD(z)) {
            this.NN.resume();
        }
    }

    private boolean bD(boolean z) {
        boolean z2;
        loop0: while (true) {
            for (InterfaceC0507a interfaceC0507a : this.azC) {
                z2 = z2 || interfaceC0507a.yM();
            }
        }
        if (z2) {
            this.azz = 3;
            return false;
        }
        if (this.azz != 3 && !z) {
            return !CP();
        }
        this.azz = 0;
        return true;
    }

    public final void CJ() {
        new b.a(this.mAdTemplate).ew(CI()).ex(com.kwad.components.ct.response.a.c.e((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR();
        this.NN.tW();
    }

    public final void setSpeed(float f) {
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            bVar.setSpeed(f);
        }
    }

    @Override // com.kwad.components.core.video.g
    public final void pause() {
        if (this.ayh) {
            this.NN.pause();
        }
    }

    public final void restart() {
        this.NN.restart();
    }

    public final void seekTo(long j) {
        this.NN.seekTo(j);
    }

    private void wK() {
        if (this.dC == null) {
            this.dC = new cb(this);
        }
        this.dC.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL() {
        cb cbVar = this.dC;
        if (cbVar == null) {
            return;
        }
        cbVar.removeCallbacksAndMessages(null);
        this.dC = null;
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        int i;
        if (message.what == 1) {
            KsFragment ksFragment = this.alG;
            if (ksFragment == null) {
                return;
            }
            boolean z = (ksFragment.isResumed() && !this.alG.isAllFragmentIsHidden() && this.alG.isVisible()) ? false : true;
            if (ca.a(this.azx, 50, false) && !z) {
                if (azy) {
                    com.kwad.sdk.core.d.c.d("DetailPlayModule", "removeMessages(MSG_UPDATE_SESSION_ID)");
                    this.dC.removeMessages(2);
                    azy = false;
                }
                if (this.gS == null) {
                    com.kwad.sdk.contentalliance.a.a.a aVarCf = com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate);
                    this.gS = aVarCf;
                    this.NN.a(aVarCf);
                }
                bE(true);
                if (!this.NN.isPlaying()) {
                    resume();
                }
            } else {
                if (!azy) {
                    com.kwad.sdk.core.d.c.d("DetailPlayModule", "sendEmptyMessageDelayed(MSG_UPDATE_SESSION_ID)");
                    this.dC.sendEmptyMessageDelayed(2, 300000L);
                    azy = true;
                }
                bE(false);
                if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate) && CP() && ((i = this.azz) == 2 || i == 1)) {
                    this.azz = 0;
                }
                if (this.NN.isPlaying()) {
                    pause();
                }
            }
            this.dC.sendEmptyMessageDelayed(1, 500L);
            return;
        }
        if (message.what == 2) {
            t.abr();
            azy = false;
        }
    }

    public final void release() {
        wL();
        com.kwad.components.core.video.b bVar = this.NN;
        if (bVar != null) {
            bVar.clear();
            this.NN.release();
        }
        com.kwad.components.core.video.c.ub().b(this);
    }

    public final void c(com.kwad.sdk.core.j.c cVar) {
        this.azD.add(cVar);
    }

    public final void d(com.kwad.sdk.core.j.c cVar) {
        this.azD.remove(cVar);
    }

    private void bE(boolean z) {
        if (z) {
            Iterator<com.kwad.sdk.core.j.c> it = this.azD.iterator();
            while (it.hasNext()) {
                it.next().by();
            }
        } else {
            Iterator<com.kwad.sdk.core.j.c> it2 = this.azD.iterator();
            while (it2.hasNext()) {
                it2.next().bz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CK() {
        this.aao.anK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL() {
        this.aao.anL();
    }

    private c.d CM() {
        if (this.acb == null) {
            this.acb = new c.d() { // from class: com.kwad.components.ct.detail.e.a.5
                @Override // com.kwad.sdk.core.video.a.c.d
                public final boolean o(int i, int i2) {
                    if (!a.this.ayh || i != 10209 || !e.TO() || 2 != a.this.getMediaPlayerType()) {
                        return false;
                    }
                    a.this.CN();
                    return false;
                }
            };
        }
        return this.acb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CN() {
        if (this.azA.get()) {
            return;
        }
        this.azA.set(true);
        for (int i = 2; i < 5; i++) {
            int i2 = this.mCurrentPosition + i;
            BasePrefetchModel basePrefetchModelW = w(i2, 1000 - i2);
            if (basePrefetchModelW != null) {
                KSPrefetcher.getInstance().addTask(basePrefetchModelW);
                com.kwad.sdk.core.d.c.d("DetailPlayModule", "在当前页" + this.mCurrentPosition + "添加预加载任务preLoadPosition=" + i2);
            }
        }
    }

    private BasePrefetchModel w(int i, int i2) {
        CtAdTemplate ctAdTemplate;
        List<CtAdTemplate> data = this.aok.getData();
        if (data == null || i < 0 || i >= data.size() || (ctAdTemplate = data.get(i)) == null) {
            return null;
        }
        String strE = com.kwad.components.ct.response.a.c.e((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
        if (!TextUtils.isEmpty(strE) && com.kwad.components.ct.a.b.wQ()) {
            return new AdaptivePrefetchModel(strE, String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate)), i2);
        }
        String strAA = com.kwad.components.ct.response.a.a.aA(ctAdTemplate);
        if (bq.isNullString(strAA)) {
            return null;
        }
        return new NomalPrefetchModel(strAA, String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate)), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CO() {
        c cVarTT = this.NN.tT();
        if (cVarTT == null || cVarTT.getMediaPlayerType() != 2) {
            return;
        }
        KSPrefetcher.getInstance().removeAll();
    }

    public final String getCurrentPlayingUrl() {
        return this.NN.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.core.video.g
    public final int uc() {
        return this.azz;
    }

    @Override // com.kwad.components.core.video.g
    public final void bk(int i) {
        this.azz = i;
    }

    @Override // com.kwad.components.core.video.g
    public final void ut() {
        if (ca.a(this.azx, 70, false) && this.ayh) {
            return;
        }
        int i = this.azz;
        if (i == 2 || i == 1) {
            this.azz = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean CP() {
        return e.Yn() && this.azz == 2;
    }
}
