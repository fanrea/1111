package com.kwad.components.ct.home.c;

import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends com.kwad.components.ct.home.e {
    private KSPageLoadingView aFX;
    private SlidePlayViewPager amK;
    private com.kwad.components.core.widget.a.b amL;
    private com.kwad.components.ct.api.a.a.c ayi;
    private boolean ayj;
    private KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.home.c.i.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            if (i.this.ayi != null) {
                i.this.ayi.refresh(0);
            }
        }
    };
    private ViewPager.OnPageChangeListener nb = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.home.c.i.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            i.this.ayj = false;
        }
    };
    private SlidePlayTouchViewPager.a ayl = new SlidePlayTouchViewPager.a() { // from class: com.kwad.components.ct.home.c.i.3
        @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager.a
        public final void Cp() {
        }

        @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager.a
        public final void Cq() {
            i.this.ayj = true;
        }
    };
    private com.kwad.components.ct.api.a.a.b ayn = new com.kwad.components.ct.api.a.a.b() { // from class: com.kwad.components.ct.home.c.i.4
        @Override // com.kwad.components.ct.api.a.a.b
        public final void a(boolean z, boolean z2, int i, int i2) {
            switch (i) {
                case 0:
                case 4:
                    i.this.aFX.Fi();
                    break;
                case 1:
                    i.this.aFX.hide();
                    break;
                case 2:
                case 3:
                    i.this.aFX.LD();
                    break;
                case 5:
                case 6:
                    if (i.this.ayj) {
                        i.this.aFX.Fi();
                        break;
                    } else {
                        i.this.aFX.hide();
                        break;
                    }
            }
        }

        @Override // com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            i.this.aFX.hide();
        }

        @Override // com.kwad.components.ct.api.a.a.b
        public final void onError(int i, String str) {
            i.this.aFX.hide();
            if (!i.this.amK.isEmpty()) {
                if (i.this.ayj) {
                    if (com.kwad.sdk.core.network.e.bCw.errorCode == i) {
                        ac.dm(i.this.getContext());
                        return;
                    } else if (com.kwad.sdk.core.network.e.bCI.errorCode != i) {
                        ac.dn(i.this.getContext());
                        return;
                    } else {
                        if (com.kwad.sdk.core.config.e.isShowTips()) {
                            ac.m462do(i.this.getContext());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (com.kwad.sdk.core.network.e.bCI.errorCode == i) {
                if (i.this.aGP.aGH) {
                    i.this.aFX.LB();
                    return;
                } else {
                    i.this.aFX.Lg();
                    return;
                }
            }
            if (!ao.isNetworkConnected(i.this.aFX.getContext())) {
                i.this.aFX.cc(i.this.amL.wO());
            } else if (com.kwad.sdk.core.network.e.bCL.errorCode == i) {
                i.this.aFX.LC();
            } else {
                i.this.aFX.cd(i.this.amL.wO());
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.amK = (SlidePlayViewPager) findViewById(R.id.ksad_slide_play_view_pager);
        this.aFX = (KSPageLoadingView) findViewById(R.id.ksad_page_loading);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.ayi = this.aGP.ayi;
        this.amL = this.aGP.aol.aFs;
        this.ayi.a(this.ayn);
        this.amK.a(this.ayl);
        this.amK.addOnPageChangeListener(this.nb);
        this.aFX.setRetryClickListener(this.asf);
        this.aFX.setScene(this.aGP.mSceneImpl);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.ayj = false;
        this.ayi.b(this.ayn);
        this.aFX.setRetryClickListener(null);
        this.amK.b(this.ayl);
        this.amK.removeOnPageChangeListener(this.nb);
    }
}
