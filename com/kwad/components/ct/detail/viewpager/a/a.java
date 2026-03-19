package com.kwad.components.ct.detail.viewpager.a;

import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.api.a.a.c;
import com.kwad.components.ct.api.g;
import com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.detail.viewpager.f;
import com.kwad.components.ct.home.b.d;
import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.components.ct.refreshview.e;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.cached.CacheTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends f {
    private boolean aBu;
    private g aBw;
    private SlidePlayViewPager aok;
    private c<CtAdTemplate> ayi;
    private e azU;
    private final RefreshLayout.b aBx = new RefreshLayout.b() { // from class: com.kwad.components.ct.detail.viewpager.a.a.1
        @Override // com.kwad.components.ct.refreshview.RefreshLayout.b
        public final void onRefresh() {
            a.this.Dv();
        }
    };
    private final SlidePlayTouchViewPager.a ayl = new SlidePlayTouchViewPager.a() { // from class: com.kwad.components.ct.detail.viewpager.a.a.2
        @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager.a
        public final void Cp() {
            if (a.this.aBu) {
                a.this.Dw();
            }
        }

        @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager.a
        public final void Cq() {
            a.this.Du();
        }
    };
    private final ViewPager.OnPageChangeListener nj = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.detail.viewpager.a.a.3
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            a.this.Ds();
        }
    };
    private final com.kwad.components.ct.api.tube.a aBy = new com.kwad.components.ct.api.tube.a() { // from class: com.kwad.components.ct.detail.viewpager.a.a.6
        @Override // com.kwad.components.ct.api.tube.a
        public final void a(List<CtAdTemplate> list, TubeEpisode tubeEpisode) {
            ArrayList arrayList = new ArrayList();
            Iterator<CtAdTemplate> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new CacheTemplate(it.next(), a.this.azZ.mScene));
            }
            a.this.ayi.t(arrayList);
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                CtAdTemplate ctAdTemplate = (CtAdTemplate) it2.next();
                if (tubeEpisode.episodeNumber == com.kwad.components.ct.response.a.c.z(ctAdTemplate.photoInfo)) {
                    a.this.aok.a(ctAdTemplate, 0, true);
                    break;
                }
            }
            a.this.Ds();
        }
    };
    private final com.kwad.components.ct.api.a.a.b ayn = new d() { // from class: com.kwad.components.ct.detail.viewpager.a.a.7
        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void a(boolean z, boolean z2, int i, int i2) {
            super.a(z, z2, i, i2);
            a.this.aok.Db();
            if (i == 4) {
                a.this.aok.A(a.this.ayi.xc());
                a.this.aok.Dd();
            }
        }

        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            super.c(z, i, i2);
            if (z) {
                if (a.this.azU != null) {
                    a.this.azU.setRefreshing(false);
                }
                a.this.aok.postDelayed(a.this.aBz, 300L);
                return;
            }
            List<CtAdTemplate> listXc = a.this.ayi.xc();
            if (i2 == 0) {
                a.this.aok.bW(a.this.azZ.aBv.apply(listXc).intValue());
            }
            if (a.this.aok.getCurrentData() == null || !a.this.aBu) {
                a.this.aok.z(a.this.ayi.xc());
            } else {
                a.this.aok.a(a.this.aok.getCurrentData(), 0, false);
            }
            a.this.aok.Dd();
        }

        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void onError(int i, String str) {
            if (com.kwad.sdk.core.network.e.bCI.errorCode == i && (a.this.aok.getAdapter() instanceof com.kwad.components.ct.detail.viewpager.a)) {
                ((com.kwad.components.ct.detail.viewpager.a) a.this.aok.getAdapter()).CQ();
            }
            if (a.this.azU != null) {
                a.this.azU.setRefreshing(false);
            }
            a.this.aok.Dd();
        }
    };
    private final Runnable aBz = new Runnable() { // from class: com.kwad.components.ct.detail.viewpager.a.a.8
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.azZ.alG.getHost() == null) {
                return;
            }
            a.this.aok.A(a.this.ayi.xc());
            a.this.aok.Dd();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aBw = (g) com.kwad.sdk.components.d.g(g.class);
    }

    @Override // com.kwad.components.ct.detail.viewpager.f, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.ayi = this.azZ.ayi;
        SlidePlayViewPager slidePlayViewPager = this.azZ.aok;
        this.aok = slidePlayViewPager;
        slidePlayViewPager.addOnPageChangeListener(this.nj);
        this.ayi.a(this.ayn);
        this.azU = this.azZ.azU;
        this.aBu = this.azZ.aBu;
        e eVar = this.azU;
        if (eVar != null) {
            eVar.setOnRefreshListener(this.aBx);
        }
        this.aok.a(this.ayl);
        if (this.aBw != null || com.kwad.sdk.core.scene.a.fx(this.azZ.mScene.getPageScene())) {
            this.aBw.a(this.aBy);
        }
        Dt();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        g gVar = this.aBw;
        if (gVar != null) {
            gVar.b(this.aBy);
        }
        this.aok.removeOnPageChangeListener(this.nj);
        this.ayi.b(this.ayn);
        this.aok.removeCallbacks(this.aBz);
        this.ayi.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds() {
        int realPosition = this.aok.getRealPosition();
        int iCR = this.aok.getAdapter().CR();
        if (iCR <= 0) {
            return;
        }
        if (realPosition >= iCR - 3) {
            this.aok.post(new bh() { // from class: com.kwad.components.ct.detail.viewpager.a.a.4
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    a.this.Du();
                }
            });
        }
        if (!this.aBu || realPosition > 3) {
            return;
        }
        this.aok.post(new bh() { // from class: com.kwad.components.ct.detail.viewpager.a.a.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.Dw();
            }
        });
    }

    private void Dt() {
        com.kwad.sdk.core.d.c.d("ViewPagerDataFetcherPresenter", "loadData");
        this.ayi.refresh(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Du() {
        com.kwad.sdk.core.d.c.d("ViewPagerDataFetcherPresenter", "loadMore");
        this.ayi.bk(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dv() {
        com.kwad.sdk.core.d.c.d("ViewPagerDataFetcherPresenter", "loadData");
        this.ayi.refresh(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dw() {
        com.kwad.sdk.core.d.c.d("ViewPagerDataFetcherPresenter", "pullLoadMore");
        this.ayi.bk(true);
    }
}
