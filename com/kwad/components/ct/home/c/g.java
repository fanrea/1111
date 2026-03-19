package com.kwad.components.ct.home.c;

import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.widget.swipe.HorizontalSwipeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ct.home.e {
    private static volatile long aKf;
    private com.kwad.components.ct.api.a.a.a aKe;
    private HorizontalSwipeLayout aoP;
    private final com.kwad.sdk.m.a.b ayk = new com.kwad.sdk.m.a.b() { // from class: com.kwad.components.ct.home.c.g.1
        @Override // com.kwad.sdk.m.a.b
        public final boolean onBackPressed() {
            return g.this.bR(false);
        }
    };
    private final HorizontalSwipeLayout.a aoR = new HorizontalSwipeLayout.a() { // from class: com.kwad.components.ct.home.c.g.2
        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void yp() {
        }

        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void yo() {
            g.this.bR(true);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        this.aoP = (HorizontalSwipeLayout) findViewById(R.id.ksad_swipe);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aKe = this.aGP.ayi.xd();
        this.aoP.a(this.aoR);
        this.aGP.aGE.addBackPressable(this.ayk);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        this.aoP.c(this.aoR);
        this.aGP.aGE.removeBackPressable(this.ayk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bR(boolean z) {
        if (System.currentTimeMillis() - aKf < com.alipay.sdk.m.u.b.a) {
            if (!z) {
                return false;
            }
            this.aGP.aGE.iE();
            return false;
        }
        aKf = System.currentTimeMillis();
        ac.c(getContext(), "再按一次返回键退出", com.alipay.sdk.m.u.b.a);
        this.aKe.refresh(3);
        return true;
    }
}
