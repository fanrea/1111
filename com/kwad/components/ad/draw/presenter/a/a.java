package com.kwad.components.ad.draw.presenter.a;

import android.view.View;
import com.kwad.components.ad.draw.a.c;
import com.kwad.components.core.video.o;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.widget.n;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private List<Integer> dX;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean mIsPaused = false;
    private volatile boolean gq = false;
    private n gr = new n() { // from class: com.kwad.components.ad.draw.presenter.a.a.1
        @Override // com.kwad.sdk.widget.n
        public final void aY() {
            com.kwad.sdk.utils.n.fm(a.this.mAdTemplate);
        }
    };
    private com.kwad.components.core.video.n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.draw.presenter.a.a.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            a.this.gq = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.fm.eU != null) {
                a.this.fm.eU.onAdShow();
                c.a(a.this.mAdTemplate, 1, b.dB(a.this.mAdTemplate) ? 2 : 1);
            }
            if (a.this.fm.eU != null) {
                try {
                    a.this.fm.eU.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
                a.this.mIsPaused = false;
            }
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            bVar.b(new a.C0576a());
            com.kwad.components.core.u.b.tq().a(a.this.mAdTemplate, null, bVar);
            com.kwad.sdk.core.adlog.c.cm(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            com.kwad.sdk.core.adlog.c.cn(a.this.mAdTemplate);
            if (a.this.fm.eU != null) {
                try {
                    a.this.fm.eU.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (a.this.mIsPaused) {
                a.this.mIsPaused = false;
                if (a.this.fm.eU != null) {
                    try {
                        a.this.fm.eU.onVideoPlayResume();
                        return;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return;
                    }
                }
                return;
            }
            if (a.this.gq) {
                return;
            }
            a.this.gq = true;
            com.kwad.components.core.q.a.ss().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (a.this.fm.eU != null) {
                try {
                    a.this.fm.eU.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
            a.this.mIsPaused = true;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            if (a.this.fm.eU != null) {
                try {
                    a.this.fm.eU.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }
    };

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.fm.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = e.eP(adTemplate);
        this.mAdInfo = adInfoEP;
        this.dX = com.kwad.sdk.core.response.b.a.bv(adInfoEP);
        this.fm.fo.b(this.mVideoPlayStateListener);
        a(this.gr);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fm.fo.a(this.mVideoPlayStateListener);
        a((n) null);
    }

    private void a(n nVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(nVar);
        }
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
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                this.dX.remove(num);
                return;
            }
        }
    }
}
