package com.kwad.components.ct.detail.photo.presenter;

import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.detail.b {
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.detail.e.a aoz;
    private CtAdTemplate mAdTemplate;
    private final n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.photo.presenter.c.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            c.this.aok.post(c.this.apa);
        }
    };
    private final Runnable apa = new Runnable() { // from class: com.kwad.components.ct.detail.photo.presenter.c.2
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.yu()) {
                c.this.aoz.restart();
            } else {
                c.this.aok.bH(true);
            }
        }
    };

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aok = this.aop.aok;
        this.mAdTemplate = this.aop.mAdTemplate;
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
        if (this.aok.CU() || !this.aop.aok.hasNext()) {
            return true;
        }
        com.kwad.sdk.g.c<Boolean> cVar = this.aop.aol.aHq;
        if (cVar == null || !cVar.get().booleanValue()) {
            return com.kwad.components.ct.detail.e.a(this.mAdTemplate);
        }
        return true;
    }
}
