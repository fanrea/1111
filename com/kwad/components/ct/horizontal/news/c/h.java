package com.kwad.components.ct.horizontal.news.c;

import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.components.ct.horizontal.news.b.a {
    private long aFZ;
    private String aGa;
    private KsContentPage.ContentItem aLE;
    private KsHorizontalFeedPage.NewsPageListener aNA;
    private boolean aNi;
    private com.kwad.components.core.widget.a.b amL;
    private boolean axK = false;
    private final com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.horizontal.news.c.h.1
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (h.this.aNi) {
                com.kwad.components.ct.e.b.JK().g(h.this.mSceneImpl);
            } else {
                h.a(h.this, true);
                com.kwad.components.ct.e.b.JK().f(h.this.mSceneImpl);
                h.this.Ip();
            }
            h.this.aFZ = System.currentTimeMillis();
            h.this.BY();
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (h.this.aFZ > 0) {
                com.kwad.components.ct.e.b.JK().a(h.this.mSceneImpl, System.currentTimeMillis() - h.this.aFZ);
                h.this.aFZ = 0L;
                h.this.BZ();
            }
        }
    };
    private SceneImpl mSceneImpl;

    static /* synthetic */ boolean a(h hVar, boolean z) {
        hVar.aNi = true;
        return true;
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = this.aNz.aFs;
        this.amL = bVar;
        if (bVar == null) {
            return;
        }
        this.aLE = this.aNz.aLE;
        this.aNA = this.aNz.aNA;
        this.amL.a(this.gZ);
        this.mSceneImpl = this.aNz.mSceneImpl;
        this.aGa = String.valueOf(this.aNz.aGE.hashCode());
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
        com.kwad.sdk.core.d.c.d("NewsDetailShowPresenter", "onPageEnter");
        KsHorizontalFeedPage.NewsPageListener newsPageListener = this.aNA;
        if (newsPageListener != null) {
            newsPageListener.onPageEnter(this.aLE);
        }
    }

    private void Iq() {
        if (this.aNi) {
            com.kwad.sdk.core.d.c.d("NewsDetailShowPresenter", "onPageLeave");
            KsHorizontalFeedPage.NewsPageListener newsPageListener = this.aNA;
            if (newsPageListener != null) {
                newsPageListener.onPageLeave(this.aLE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BY() {
        if (!this.axK) {
            com.kwad.sdk.core.d.c.d("NewsDetailShowPresenter", "onPageResume");
            KsHorizontalFeedPage.NewsPageListener newsPageListener = this.aNA;
            if (newsPageListener != null) {
                newsPageListener.onPageResume(this.aLE);
            }
        }
        this.axK = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BZ() {
        if (this.axK) {
            com.kwad.sdk.core.d.c.d("NewsDetailShowPresenter", "onPagePause");
            KsHorizontalFeedPage.NewsPageListener newsPageListener = this.aNA;
            if (newsPageListener != null) {
                newsPageListener.onPagePause(this.aLE);
            }
        }
        this.axK = false;
    }
}
