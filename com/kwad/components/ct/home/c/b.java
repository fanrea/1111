package com.kwad.components.ct.home.c;

import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.home.e {
    private com.kwad.components.ct.response.model.a.a aCR;
    private int aJH;
    private com.kwad.components.core.widget.a.b amL;
    private SlidePlayViewPager aok;
    private boolean aJG = false;
    private boolean aJI = false;
    private com.kwad.sdk.core.j.d aJJ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.home.c.b.1
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            b.this.GD();
        }
    };
    private ViewPager.OnPageChangeListener nb = new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ct.home.c.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            if (Math.abs(b.this.aok.getAdapter().bO(i) - b.this.aGP.aGI) >= b.this.aJH) {
                b.a(b.this, true);
            }
        }
    };

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.aJI = true;
        return true;
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.widget.a.b bVar = this.aGP.aol.aFs;
        this.amL = bVar;
        bVar.a(this.aJJ);
        SlidePlayViewPager slidePlayViewPager = this.aGP.aok;
        this.aok = slidePlayViewPager;
        slidePlayViewPager.addOnPageChangeListener(this.nb);
        com.kwad.components.ct.api.b bVar2 = (com.kwad.components.ct.api.b) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.b.class);
        com.kwad.components.ct.response.model.cached.a aVarWY = bVar2 != null ? bVar2.wY() : null;
        if (aVarWY == null) {
            return;
        }
        this.aCR = aVarWY.aCR;
        this.aJH = com.kwad.components.ct.a.a.amp.getValue().intValue();
        if (aVarWY.aCR.aVa == 1) {
            this.aJH = 2;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.ct.e.b.JK().a(this.aCR, GD());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GD() {
        boolean z = this.aJG;
        if (z || !this.aJI) {
            return z;
        }
        this.aJG = true;
        com.kwad.components.ct.api.b bVar = (com.kwad.components.ct.api.b) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.b.class);
        if (bVar == null) {
            return false;
        }
        bVar.aF(getContext());
        return true;
    }
}
