package com.kwad.components.ad.reward.presenter;

import android.content.res.Resources;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, at.b {
    private com.kwad.components.core.webview.tachikoma.f.g lE;
    private float xP;
    private boolean ye;
    private a yf;
    private q yg;
    private o yh;
    private p yi;
    private int yj;
    private boolean yk;
    private boolean yl;
    private boolean ym;

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public r(AdTemplate adTemplate, boolean z, boolean z2) {
        this.yj = 0;
        this.yk = false;
        this.yl = z;
        this.ym = z2;
        if (com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
            p pVar = new p();
            this.yi = pVar;
            d(pVar);
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bT(adInfoEP)) {
            if (!this.vb.tJ) {
                bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        r.this.iT();
                    }
                }, 100L);
            } else {
                com.kwad.components.core.webview.tachikoma.e.c.wq().a(dm());
            }
        } else if (!com.kwad.sdk.core.response.b.a.bW(adInfoEP)) {
            com.kwad.components.core.q.a.ss().aK(this.vb.mAdTemplate);
        }
        this.vb.b(this);
        if (this.vb.tv != null) {
            this.vb.tv.a(this);
        }
        boolean zHK = com.kwad.components.ad.reward.a.b.hK();
        this.xP = com.kwad.components.ad.reward.a.b.hJ();
        if (zHK) {
            this.yf = new a(this, (byte) 0);
            if (this.vb.tu != null) {
                this.vb.tu.a(this.yf);
            }
        }
        com.kwad.components.ad.reward.a.gl().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.c(this);
        if (this.vb.tv != null) {
            this.vb.tv.b(this);
        }
        if (this.yf != null && this.vb.tu != null) {
            this.vb.tu.b(this.yf);
        }
        com.kwad.components.ad.reward.a.gl().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.wq().b(this.lE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT() {
        if (this.ym) {
            q qVar = new q(this);
            this.yg = qVar;
            a((Presenter) qVar, true);
        }
        if (this.yl) {
            o oVar = new o(this);
            this.yh = oVar;
            a((Presenter) oVar, true);
        }
    }

    public final boolean onBackPressed() {
        boolean zGY = this.vb.gY();
        if (!this.vb.gK() || zGY) {
            return false;
        }
        com.kwad.components.ad.reward.a.gl().gm();
        this.vb.A(false);
        return true;
    }

    @Override // com.kwad.components.core.webview.jshandler.at.b
    public final void a(at.a aVar) throws Resources.NotFoundException {
        a aVar2;
        boolean zIsSuccess = aVar.isSuccess();
        this.ye = zIsSuccess;
        if (!zIsSuccess || (aVar2 = this.yf) == null) {
            return;
        }
        b(aVar2.videoDuration, this.yf.yo, false);
    }

    private com.kwad.components.core.webview.tachikoma.f.g dm() {
        if (this.lE == null) {
            this.lE = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void x(String str) {
                    r.this.iT();
                }
            };
        }
        return this.lE;
    }

    private boolean iU() {
        return this.ye;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, boolean z) throws Resources.NotFoundException {
        q qVar;
        if (iU() && j2 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT && ((float) j2) >= ((float) j) * this.xP) {
            if (com.kwad.components.ad.reward.a.b.hL()) {
                if (this.yk || (qVar = this.yg) == null) {
                    return;
                }
                qVar.iP();
                this.yj = 1;
                this.yk = true;
                return;
            }
            o oVar = this.yh;
            if (oVar != null) {
                oVar.I(!z);
                this.yj = 2;
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dc() {
        RewardActionBarControl.ShowActionBarResult showActionBarResultJv = this.vb.tw.jv();
        if (showActionBarResultJv != null) {
            showActionBarResultJv.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.yi == null || this.vb.gU()) {
            return;
        }
        if (iU()) {
            this.yi.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.yi.iO();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.vb.A(true);
        int i = this.yj;
        if (i == 1 && (qVar = this.yg) != null) {
            qVar.iQ();
        } else {
            if (i != 2 || (oVar = this.yh) == null) {
                return;
            }
            oVar.hide();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dp() throws Resources.NotFoundException {
        this.vb.A(false);
        a aVar = this.yf;
        if (aVar == null || this.yj != 2) {
            return;
        }
        b(aVar.videoDuration, this.yf.yo, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }

    class a extends com.kwad.components.core.video.o {
        private long videoDuration;
        private long yo;

        private a() {
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) throws Resources.NotFoundException {
            super.onMediaPlayProgress(j, j2);
            this.yo = j2;
            this.videoDuration = j;
            if (r.this.vb.gK()) {
                return;
            }
            r.this.b(j, j2, false);
        }
    }
}
