package com.kwad.components.ct.home.c;

import android.app.Dialog;
import android.widget.FrameLayout;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.e.b;
import com.kwad.sdk.R;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l extends com.kwad.components.ct.home.e {
    private com.kwad.components.ct.home.h aGQ;
    private int aKr;
    private long aKs;
    private long aKt;
    private boolean aKu;
    private boolean aKv;
    private boolean aKw;
    private com.kwad.components.ct.home.e.a aKx;
    private com.kwad.components.ct.home.e.b aKy;
    private SlidePlayViewPager aok;
    private FrameLayout gO;
    private SceneImpl mScene;
    private final com.kwad.sdk.m.a.b ayk = new com.kwad.sdk.m.a.b() { // from class: com.kwad.components.ct.home.c.l.1
        @Override // com.kwad.sdk.m.a.b
        public final boolean onBackPressed() {
            return l.this.bS(false);
        }
    };
    private final com.kwad.components.ct.home.m aKz = new com.kwad.components.ct.home.m() { // from class: com.kwad.components.ct.home.c.l.2
        @Override // com.kwad.components.ct.home.m
        public final boolean Fu() {
            return l.this.bS(true);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aok = (SlidePlayViewPager) findViewById(R.id.ksad_slide_play_view_pager);
        this.gO = (FrameLayout) findViewById(R.id.ksad_home_stay_ad_container);
        this.aKr = com.kwad.components.ct.home.config.b.FN();
        this.aKt = com.kwad.components.ct.home.config.b.FM();
        this.aKv = com.kwad.components.ct.home.config.b.FP();
        this.aKw = com.kwad.components.ct.home.config.b.FQ();
        this.aKu = com.kwad.components.ct.home.config.b.FR();
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mScene = this.aGP.mSceneImpl;
        if (this.aKv) {
            this.aGP.aGE.addBackPressable(this.ayk);
        }
        if (this.aKw) {
            this.aGP.aGR.a(this.aKz);
        }
        if (this.aKx == null) {
            int statusBarHeight = this.aGP.aGL;
            if (com.kwad.components.core.u.e.e(getActivity())) {
                statusBarHeight += com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
            }
            this.aKx = new com.kwad.components.ct.home.e.a(this.gO, this.aGP.mSceneImpl, statusBarHeight);
        }
        this.aKx.Ds();
        this.aGQ = this.aGP.aGQ;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aKv) {
            this.aGP.aGE.removeBackPressable(this.ayk);
        }
        if (this.aKw) {
            this.aGP.aGR.b(this.aKz);
        }
        com.kwad.components.ct.home.e.a aVar = this.aKx;
        if (aVar != null) {
            aVar.release();
        }
        Fm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bS(final boolean z) {
        boolean z2 = false;
        if (!this.aGP.aol.aFs.ai() || this.aok.isEmpty() || this.aGP.aol.aHt > this.aKr || this.aKx.Gk() || com.kwad.components.ct.home.a.d.Gi().Gk()) {
            return false;
        }
        if (System.currentTimeMillis() - this.aKs >= this.aKt) {
            this.aKs = System.currentTimeMillis();
            z2 = true;
            if (!this.aKx.b(new com.kwad.components.ct.home.a.b() { // from class: com.kwad.components.ct.home.c.l.3
                @Override // com.kwad.components.ct.home.a.b
                public final void Al() {
                }

                @Override // com.kwad.components.ct.home.a.b
                public final void co(int i) {
                    if (i == 1) {
                        l.this.GO();
                    } else if (i == 2) {
                        l.this.bU(z);
                    } else {
                        l.this.GP();
                    }
                }
            })) {
                bT(z);
            }
            pauseVideo();
        }
        return z2;
    }

    private void pauseVideo() {
        this.aGQ.pause();
    }

    private void GN() {
        this.aGQ.resume();
    }

    private void Fm() {
        this.aGQ.Fm();
    }

    private void Fv() {
        this.aGP.aGR.Fv();
    }

    private void bT(final boolean z) {
        com.kwad.components.ct.home.e.b bVar = this.aKy;
        if (bVar == null || !bVar.isShowing()) {
            com.kwad.components.ct.home.e.b bVar2 = new com.kwad.components.ct.home.e.b(getActivity(), new b.a() { // from class: com.kwad.components.ct.home.c.l.4
                @Override // com.kwad.components.ct.home.e.b.a
                public final void b(Dialog dialog) {
                    dialog.dismiss();
                    l.this.GO();
                    com.kwad.components.ct.e.b.JK().m(l.this.mScene);
                }

                @Override // com.kwad.components.ct.home.e.b.a
                public final void c(Dialog dialog) {
                    dialog.dismiss();
                    l.this.bU(z);
                    com.kwad.components.ct.e.b.JK().n(l.this.mScene);
                }

                @Override // com.kwad.components.ct.home.e.b.a
                public final void d(Dialog dialog) {
                    dialog.dismiss();
                    l.this.GP();
                    com.kwad.components.ct.e.b.JK().o(l.this.mScene);
                }
            });
            this.aKy = bVar2;
            bVar2.show();
            com.kwad.components.ct.e.b.JK().l(this.mScene);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO() {
        Fm();
        if (this.aok.bI(this.aKu)) {
            return;
        }
        GN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        Fm();
        if (z) {
            GN();
            Fv();
        } else {
            this.aGP.aGE.iE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        Fm();
        GN();
    }
}
