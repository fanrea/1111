package com.kwad.components.ad.nativead.c;

import android.content.Context;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.l.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.o;
import com.kwad.components.core.widget.a.c;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b {
    private KsAdVideoPlayConfig dG;
    private boolean ec;
    private OfflineOnAudioConflictListener eo;
    private c gR;
    private final com.kwad.sdk.core.j.c gZ;
    private boolean hasNoCache;
    private a.b ho;
    private final AdInfo mAdInfo;
    private Context mContext;
    private boolean rM;
    private boolean rN;
    private o rO;
    private int rP;
    private long rQ;

    static /* synthetic */ int a(a aVar, int i) {
        aVar.rP = 3;
        return 3;
    }

    static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.ec = false;
        return false;
    }

    public a(final AdTemplate adTemplate, c cVar, DetailVideoView detailVideoView, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.nativead.c.a.4
            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                com.kwad.components.core.l.a.qD().a(a.this.getCurrentVoiceItem());
                a.this.fO();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                com.kwad.components.core.l.a.qD().c(a.this.ho);
                a.this.pause();
            }
        };
        this.eo = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.nativead.c.a.6
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }
        };
        this.gR = cVar;
        AdInfo adInfoEP = e.eP(this.mAdTemplate);
        this.mAdInfo = adInfoEP;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.rM = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.rM = com.kwad.sdk.core.response.b.a.cj(adInfoEP);
        }
        this.dG = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        this.rO = new o() { // from class: com.kwad.components.ad.nativead.c.a.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.q.a.ss().g(adTemplate, i, i2);
            }
        };
        this.NN.c(this.rO);
        bx();
        this.NN.a(new c.e() { // from class: com.kwad.components.ad.nativead.c.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar2) {
                try {
                    if (a.this.fP() && a.this.gR.ai() && a.this.fN()) {
                        a.this.NN.a(com.kwad.sdk.contentalliance.a.a.a.cf(a.this.mAdTemplate));
                        com.kwad.components.core.l.a.qD().a(a.this.getCurrentVoiceItem());
                        a.this.NN.start(a.this.rQ);
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fN() {
        int i = this.rP;
        return (i == 3 || i == 2) ? false : true;
    }

    public final void bt() {
        n.fm(this.mAdTemplate);
        if (this.NN.tT() == null) {
            bx();
        }
        if (fP() && this.gR.ai()) {
            this.NN.a(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate));
            com.kwad.components.core.l.a.qD().a(getCurrentVoiceItem());
            this.NN.start(this.rQ);
        }
        this.NN.c(new o() { // from class: com.kwad.components.ad.nativead.c.a.3
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                if (j != 0) {
                    a.this.rQ = j2;
                }
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                super.onMediaPlayCompleted();
                a.this.rQ = 0L;
                a.a(a.this, 3);
            }
        });
        this.gR.a(this.gZ);
    }

    public final void bv() {
        n.fk(this.mAdTemplate);
        this.gR.b(this.gZ);
        this.NN.release();
        com.kwad.components.core.l.a.qD().c(this.ho);
        com.kwad.components.core.u.a.aC(this.mContext).b(this.eo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO() {
        int i = this.rP;
        if (i == 1) {
            start();
            return;
        }
        if (i == 2) {
            pause();
        } else if (i == 3) {
            stop();
        } else {
            resume();
        }
    }

    private void start() {
        if (this.rN) {
            resume();
        } else {
            fQ();
        }
    }

    private void stop() {
        this.NN.complete();
    }

    private void bx() {
        this.NN.a(new b.a(this.mAdTemplate).ew(e.eR(this.mAdTemplate)).ex(h.e(e.eQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).cu(this.hasNoCache).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR(), true, true, this.mDetailVideoView);
        setAudioEnabled(h(this.rM));
        if (fP()) {
            this.NN.prepareAsync();
            com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        com.kwad.components.core.l.a.qD().a(getCurrentVoiceItem());
        setAudioEnabled(h(this.rM));
        if (fP()) {
            this.NN.start(this.rQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (this.ho != null) {
            com.kwad.components.core.l.a.qD();
            if (!com.kwad.components.core.l.a.b(this.ho)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.e.hG()) {
            if (com.kwad.components.core.u.a.aC(this.mContext).tp()) {
                return !com.kwad.components.core.u.a.aC(this.mContext).to();
            }
            return com.kwad.components.core.u.a.aC(this.mContext).aS(false);
        }
        if (!this.ec) {
            this.ec = com.kwad.components.core.u.a.aC(this.mContext).aS(true);
        }
        return this.ec;
    }

    public final void V(int i) {
        this.rP = i;
        if (this.gR.ai()) {
            fO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        this.NN.setAudioEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fP() {
        if (this.rN) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dG;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ao.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ao.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return ao.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ao.isMobileConnected(this.mContext));
            }
        }
        if (com.kwad.sdk.core.response.b.a.cl(this.mAdInfo) && ao.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.cm(this.mAdInfo) && ao.isWifiConnected(this.mContext);
    }

    public final void fQ() {
        this.rN = true;
        this.mAdInfo.isAllowVideoAutoPlay = true;
        if (this.gR.ai()) {
            n.fl(this.mAdTemplate);
            this.NN.a(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate));
            com.kwad.components.core.l.a.qD().a(getCurrentVoiceItem());
            this.NN.start(this.rQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.ho == null) {
            this.ho = new a.b(new a.c() { // from class: com.kwad.components.ad.nativead.c.a.5
                @Override // com.kwad.components.core.l.a.c
                public final void bK() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.h(aVar.rM));
                }
            });
        }
        return this.ho;
    }
}
