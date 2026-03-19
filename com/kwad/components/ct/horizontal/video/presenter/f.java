package com.kwad.components.ct.horizontal.video.presenter;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.horizontal.video.a.a {
    private long aFZ;
    private String aGa;
    private KsContentPage.ContentItem aLE;
    private boolean aNi;
    private KsContentPage.PageListener alM;
    private com.kwad.components.core.widget.a.b amL;
    private boolean axK = false;
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.horizontal.video.presenter.f.1
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (f.this.aNi) {
                com.kwad.components.ct.e.b.JK().g(f.this.mSceneImpl);
            } else {
                f.a(f.this, true);
                com.kwad.components.ct.e.b.JK().f(f.this.mSceneImpl);
                f.this.Ip();
            }
            f.this.aFZ = System.currentTimeMillis();
            f.this.BY();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (f.this.aFZ > 0) {
                com.kwad.components.ct.e.b.JK().a(f.this.mSceneImpl, System.currentTimeMillis() - f.this.aFZ);
                f.this.aFZ = 0L;
                f.this.BZ();
            }
        }
    };
    private SceneImpl mSceneImpl;

    @Override // com.kwad.components.ct.horizontal.video.c
    public final void A(CtAdTemplate ctAdTemplate) {
    }

    static /* synthetic */ boolean a(f fVar, boolean z) {
        fVar.aNi = true;
        return true;
    }

    @Override // com.kwad.components.ct.horizontal.video.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = this.aOD.aFs;
        this.amL = bVar;
        if (bVar == null) {
            return;
        }
        this.aLE = this.aOD.aLE;
        this.alM = this.aOD.alM;
        this.amL.a(this.gZ);
        this.mSceneImpl = this.aOD.mSceneImpl;
        this.aGa = String.valueOf(this.aOD.aoy.hashCode());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.widget.a.b bVar = this.amL;
        if (bVar != null) {
            bVar.b(this.gZ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.scene.b.abP().fS(this.aGa);
        Iq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ip() {
        com.kwad.sdk.core.d.c.d("HorizontalVideoShowPresenter", "onPageEnter");
        KsContentPage.PageListener pageListener = this.alM;
        if (pageListener != null) {
            pageListener.onPageEnter(this.aLE);
        }
    }

    private void Iq() {
        com.kwad.sdk.core.d.c.e("wzw", "notifyPageLeave hasFirstCreated: " + this.aNi);
        if (this.aNi) {
            com.kwad.sdk.core.d.c.d("HorizontalVideoShowPresenter", "onPageLeave");
            KsContentPage.PageListener pageListener = this.alM;
            if (pageListener != null) {
                pageListener.onPageLeave(this.aLE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BY() {
        if (!this.axK) {
            com.kwad.sdk.core.d.c.d("HorizontalVideoShowPresenter", "onPageResume");
            KsContentPage.PageListener pageListener = this.alM;
            if (pageListener != null) {
                pageListener.onPageResume(this.aLE);
            }
        }
        this.axK = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BZ() {
        if (this.axK) {
            com.kwad.sdk.core.d.c.d("HorizontalVideoShowPresenter", "onPagePause");
            KsContentPage.PageListener pageListener = this.alM;
            if (pageListener != null) {
                pageListener.onPagePause(this.aLE);
            }
        }
        this.axK = false;
    }
}
