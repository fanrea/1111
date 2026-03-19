package com.kwad.components.ct.detail.ad.presenter;

import android.view.View;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.widget.swipe.HorizontalSwipeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private View aoO;
    private HorizontalSwipeLayout aoP;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.ad.presenter.b.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            b.this.aoP.a(b.this.aoR);
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            if (b.this.aoP.b(b.this.aoR)) {
                b.this.aoP.c(b.this.aoR);
            }
        }
    };
    private HorizontalSwipeLayout.a aoR = new HorizontalSwipeLayout.a() { // from class: com.kwad.components.ct.detail.ad.presenter.b.2
        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void yo() {
        }

        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void yp() {
            if (!com.kwad.components.ct.detail.a.b.yW() || com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(b.this.mAdTemplate))) {
                return;
            }
            if ((b.this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
                com.kwad.components.ct.e.b.JK().b(b.this.aop.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, 12, (aj.a) null);
            b.this.yn();
        }
    };
    private CtAdTemplate mAdTemplate;

    private void c(KsFragment ksFragment) {
        if (this.aoO != null) {
            return;
        }
        View view = ksFragment.getParentFragment().getView();
        this.aoO = view;
        this.aoP = (HorizontalSwipeLayout) view.findViewById(R.id.ksad_swipe);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c(this.aop.aoy);
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        this.aop.aoq.remove(this.aoQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn() {
        AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
    }
}
