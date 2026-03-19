package com.kwad.components.ad.interstitial.f;

import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends b implements a.c {
    private static long oS = 1000;
    private AdTemplate mAdTemplate;
    private a oT;
    private int oU;
    private c oa;

    @Override // com.kwad.components.core.video.a.c
    public final void au() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) amf();
        this.oa = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        long j = adInfoEP.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.oU = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(adInfoEP), j);
        } else {
            this.oU = com.kwad.components.ad.interstitial.b.b.b(adInfoEP);
        }
        if (this.oa.ob != null) {
            this.oa.ob.b(true, this.oU);
        }
        if (com.kwad.sdk.core.response.b.a.bi(adInfoEP)) {
            this.oT = null;
            this.oa.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.oT = aVar;
            bx.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.oa.b(this);
        a aVar = this.oT;
        if (aVar != null) {
            aVar.r(true);
            bx.d(this.oT);
            this.oT = null;
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dW() {
        super.dW();
        a aVar = this.oT;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dX() {
        super.dX();
        a aVar = this.oT;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i) {
        if (this.oa.ob == null) {
            return;
        }
        if (i == 0) {
            if (this.oa.ea()) {
                return;
            }
            this.oa.c(getContext(), this.mAdTemplate);
            eA();
            c cVar = this.oa;
            cVar.a(true, -1, cVar.ed);
            return;
        }
        this.oa.ob.b(true, i);
    }

    private void eA() {
        if (this.oa.ed != null) {
            this.oa.ed.release();
        }
        this.oa.mN.dismiss();
        this.oa.ac();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j) {
        P(this.oU - ((int) (j / 1000)));
    }

    @Override // com.kwad.components.core.video.a.c
    public final void av() {
        if (this.oa.ea()) {
            return;
        }
        this.oa.c(getContext(), this.mAdTemplate);
        eA();
    }

    class a implements Runnable {
        private int oV;
        private boolean oW;
        private boolean oX;

        private a() {
            this.oV = Integer.MIN_VALUE;
            this.oW = false;
            this.oX = false;
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void r(boolean z) {
            this.oX = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.oX) {
                return;
            }
            if (this.oW) {
                bx.a(this, null, e.oS);
                return;
            }
            if (this.oV == Integer.MIN_VALUE) {
                this.oV = e.this.oU;
            }
            if (this.oV < 0) {
                return;
            }
            com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.oV);
            e.this.P(this.oV);
            this.oV--;
            bx.a(this, null, e.oS);
        }

        public final void s(boolean z) {
            this.oW = z;
        }
    }
}
