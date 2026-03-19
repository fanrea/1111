package com.kwad.components.ct.detail.c.a;

import com.kwad.components.core.k.d;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.j.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private int abR;
    private com.kwad.components.ct.g.a aoI;
    private com.kwad.components.core.widget.a.b asB;
    private KsContentPage.SubShowItem azo;
    private int azt;
    private CtAdTemplate mAdTemplate;
    private c azu = new c() { // from class: com.kwad.components.ct.detail.c.a.b.1
        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            if (b.this.azt == 1) {
                return;
            }
            b.this.azt = 1;
            if (b.this.azo != null) {
                b.this.azo.onPageVisibleChange(true);
            }
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (b.this.azt == -1) {
                return;
            }
            b.this.azt = -1;
            if (b.this.azo != null) {
                b.this.azo.onPageVisibleChange(false);
            }
        }
    };
    private com.kwad.components.core.k.c azv = new d() { // from class: com.kwad.components.ct.detail.c.a.b.2
        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onDestroy() {
        }

        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onResume() {
            if (b.this.azo != null) {
                b.this.azo.onPageResume();
            }
        }

        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onPause() {
            if (b.this.azo != null) {
                b.this.azo.onPagePause();
            }
        }

        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void qC() {
            if (b.this.azo != null) {
                b.this.azo.onPageCreate();
            }
        }

        @Override // com.kwad.components.core.k.d, com.kwad.components.core.k.c
        public final void onDestroyView() {
            if (b.this.azo != null) {
                b.this.azo.onPageDestroy();
            }
        }
    };
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.c.a.b.3
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (b.this.asB == null) {
                return;
            }
            b.this.asB.a(b.this.azu);
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            if (b.this.asB == null) {
                return;
            }
            b.this.azu.bz();
            b.this.asB.b(b.this.azu);
        }
    };

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        CtAdTemplate ctAdTemplate;
        super.ay();
        j jVar = this.aop.aol;
        if (jVar != null) {
            this.asB = jVar.aFs;
        }
        this.azt = 0;
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aoI = this.aop.aoI;
        this.abR = this.aop.abR;
        com.kwad.components.ct.g.a aVar = this.aoI;
        if (aVar == null || (ctAdTemplate = this.mAdTemplate) == null) {
            return;
        }
        KsContentPage.SubShowItem subShowItemBg = aVar.bg(ctAdTemplate);
        this.azo = subShowItemBg;
        if (subShowItemBg == null) {
            return;
        }
        this.aop.aor.add(this.azv);
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aop != null) {
            this.aop.aoq.remove(this.aoQ);
        }
    }
}
