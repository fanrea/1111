package com.kwad.components.ct.detail.ad.presenter;

import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.detail.b {
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.detail.e.a aoz;
    private final n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.ad.presenter.d.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            d.this.aok.post(d.this.apa);
        }
    };
    private final Runnable apa = new Runnable() { // from class: com.kwad.components.ct.detail.ad.presenter.d.2
        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.yu()) {
                d.this.aoz.restart();
            } else if (d.this.yv()) {
                d.this.aok.bH(true);
            }
        }
    };

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = this.aop.aok;
        com.kwad.components.ct.detail.e.a aVar = this.aop.aoz;
        this.aoz = aVar;
        aVar.c(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aok.removeCallbacks(this.apa);
        this.aoz.d(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yu() {
        return this.aok.CU() || this.aop.aoG || com.kwad.components.ct.detail.d.b.a(this.aop);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yv() {
        if (this.aok.CU()) {
            return true;
        }
        return this.aop.aok.hasNext() && this.aop.aoH;
    }
}
