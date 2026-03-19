package com.kwad.components.ct.home.c;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.components.ct.home.e {
    private ViewGroup aKh;
    private SlidePlayViewPager amK;
    private com.kwad.components.ct.api.a.a.c ayi;
    private final com.kwad.components.ct.api.a.a.b ayn = new com.kwad.components.ct.home.b.d() { // from class: com.kwad.components.ct.home.c.h.1
        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            super.c(z, i, i2);
            if (i != 0 || z) {
                return;
            }
            bx.a(h.this.avO, "", 50L);
        }
    };
    private final Runnable avO = new Runnable() { // from class: com.kwad.components.ct.home.c.h.2
        @Override // java.lang.Runnable
        public final void run() {
            h.this.GJ();
        }
    };
    private final ViewPager.OnPageChangeListener nb = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.home.c.h.3
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            h.this.GJ();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        com.kwad.sdk.core.d.c.d("[IAd]HomeInterstitialAdPresenter", "onCreate");
        this.amK = (SlidePlayViewPager) findViewById(R.id.ksad_slide_play_view_pager);
        this.aKh = (ViewGroup) findViewById(R.id.ksad_home_interstitial_ad_container);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("[IAd]HomeInterstitialAdPresenter", "onBind");
        com.kwad.components.ct.home.a.d.Gi();
        if (com.kwad.components.ct.home.a.d.Gm()) {
            this.aGP.aol.aHs = GI();
        }
        SlidePlayViewPager slidePlayViewPager = this.amK;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.addOnPageChangeListener(this.nb);
        }
        com.kwad.components.ct.api.a.a.c<CtAdTemplate> cVar = this.aGP.ayi;
        this.ayi = cVar;
        cVar.a(this.ayn);
        bx.runOnUiThread(this.avO);
    }

    private com.kwad.components.core.k.f GI() {
        return new com.kwad.components.core.k.f() { // from class: com.kwad.components.ct.home.c.h.4
            @Override // com.kwad.components.core.k.f
            public final void aF(boolean z) {
                if (z && com.kwad.components.ct.home.a.d.Gi().ad(System.currentTimeMillis())) {
                    h.this.cs(2);
                }
            }
        };
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        SlidePlayViewPager slidePlayViewPager = this.amK;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.removeOnPageChangeListener(this.nb);
        }
        this.ayi.b(this.ayn);
        com.kwad.components.ct.home.a.d.Gi().bS("home_interstitial_ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GJ() {
        if (this.amK.isEmpty()) {
            return;
        }
        CtAdTemplate currentData = this.amK.getCurrentData();
        com.kwad.components.ct.home.a.d.Gi().Gl();
        if (u(currentData)) {
            cs(1);
        } else {
            com.kwad.components.ct.home.a.d.Gi().a("home_interstitial_ad", getScene());
        }
    }

    private SceneImpl getScene() {
        return this.aGP.mSceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(int i) {
        int statusBarHeight = this.aGP.aGL;
        if (com.kwad.components.core.u.e.e(getActivity())) {
            statusBarHeight += com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
        }
        com.kwad.components.ct.home.a.d.Gi().a(i, this.aKh, this.aGP.mSceneImpl, "home_interstitial_ad", statusBarHeight);
    }

    private static boolean u(CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate == null || com.kwad.components.ct.response.a.a.eH(ctAdTemplate) || com.kwad.components.ct.response.a.a.aq(ctAdTemplate) || com.kwad.components.ct.response.a.a.ar(ctAdTemplate)) {
            return false;
        }
        return ctAdTemplate.photoAd.requestInsertScreenAd;
    }
}
