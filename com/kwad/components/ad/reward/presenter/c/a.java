package com.kwad.components.ad.reward.presenter.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.ad.reward.presenter.b;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.o;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b {
    private List<Integer> dX;
    private AdInfo mAdInfo;
    private o xH;
    private final l zg = new l();
    private long tY = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean zh = true;
    private volatile boolean gq = false;
    private Runnable zi = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.zg.uD()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.zg.uF();
                int iUG = a.this.zg.uE().uG();
                a.this.vb.a(jElapsedRealtime, a.this.zg.uE().uH(), iUG);
            } else if (a.this.zh) {
                a.this.vb.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.q.a.ss().aL(a.this.mAdTemplate);
        }
    };
    private o xI = new o() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.iL();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.c(j2);
            a.this.tY = j2;
            a.this.zg.uC();
            a.a(a.this, false);
            a.this.vb.tY = j2;
            if (a.this.gq) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.q.a.ss().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.vb.tI, a.this.mAdTemplate, a.this.vb.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.jf();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.zg.uC();
        }
    };
    private o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.jf();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
            a.this.tY = j2;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.zg.uC();
            a.a(a.this, false);
            if (a.this.gq) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.q.a.ss().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            c.b(a.this.vb.tI, a.this.mAdTemplate, a.this.vb.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            c.a(a.this.vb.tI, a.this.vb.mAdTemplate, a.this.vb.uh, i, i2);
            com.kwad.components.ad.reward.monitor.b.c(a.this.vb.tI, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.zg.uB();
            a.this.mHandler.removeCallbacks(a.this.zi);
            a.this.mHandler.postDelayed(a.this.zi, 5000L);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.zg.uB();
            a.this.mHandler.removeCallbacks(a.this.zi);
            a.this.mHandler.postDelayed(a.this.zi, 5000L);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            a.this.iL();
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.zh = false;
        return false;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.gq = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdInfo adInfoEP = e.eP(this.mAdTemplate);
        this.mAdInfo = adInfoEP;
        this.dX = com.kwad.sdk.core.response.b.a.bv(adInfoEP);
        if (this.vb.tu.la()) {
            this.xH = this.xI;
        } else {
            this.xH = this.lv;
        }
        this.vb.tu.a(this.xH);
        this.mHandler.postDelayed(this.zi, 5000L);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.vb.tu.b(this.xH);
        l.a aVarUE = this.zg.uE();
        com.kwad.components.core.q.a.ss().a(this.vb.mAdTemplate, this.tY, aVarUE.uH(), aVarUE.uG());
    }

    public final void iL() {
        if (!this.vb.tI || !this.vb.tN) {
            com.kwad.sdk.core.adlog.c.g(this.mAdTemplate, this.vb.mReportExtData);
        }
        this.zg.uC();
    }

    public final void jf() {
        this.gq = false;
        EcOrderCardStyle ecOrderCardStyleCreateFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        if (ecOrderCardStyleCreateFromAdInfo != null) {
            a.C0576a c0576a = new a.C0576a();
            c0576a.bvm = String.valueOf(ecOrderCardStyleCreateFromAdInfo.getValue());
            bVar.b(c0576a);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        com.kwad.components.ad.reward.j.b.a(true, this.mAdTemplate, null, bVar);
        com.kwad.sdk.core.adlog.c.f(this.mAdTemplate, this.vb.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.dX) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, this.vb.mReportExtData);
                this.dX.remove(num);
                return;
            }
        }
    }

    private void checkExposure() {
        long j = this.mAdInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || com.kwad.sdk.core.response.b.a.ai(this.mAdInfo) <= 5000) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            @Override // java.lang.Runnable
            public final void run() {
                m.a(1, a.this.vb);
            }
        }, j);
    }
}
