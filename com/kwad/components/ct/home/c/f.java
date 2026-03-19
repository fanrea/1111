package com.kwad.components.ct.home.c;

import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.home.e {
    private SlidePlayViewPager amK;
    private com.kwad.components.ct.api.a.a.c ayi;
    private final com.kwad.components.ct.api.a.a.b ayn = new com.kwad.components.ct.home.b.d() { // from class: com.kwad.components.ct.home.c.f.1
        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            super.c(z, i, i2);
            if (com.kwad.components.core.e.c.b.pe()) {
                com.kwad.components.core.e.c.b.pf();
            }
        }
    };
    private final ViewPager.OnPageChangeListener nb = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.home.c.f.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            if (com.kwad.components.core.e.c.b.pe()) {
                com.kwad.components.core.e.c.b.pf();
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.amK = (SlidePlayViewPager) findViewById(R.id.ksad_slide_play_view_pager);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        SlidePlayViewPager slidePlayViewPager = this.amK;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.addOnPageChangeListener(this.nb);
        }
        com.kwad.components.ct.api.a.a.c<CtAdTemplate> cVar = this.aGP.ayi;
        this.ayi = cVar;
        cVar.a(this.ayn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        SlidePlayViewPager slidePlayViewPager = this.amK;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.removeOnPageChangeListener(this.nb);
        }
        this.ayi.b(this.ayn);
    }
}
