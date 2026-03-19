package com.kwad.components.core.e.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends KSFrameLayout {
    private final d Qa;
    private a Qj;
    private final d Ql;
    private final com.kwad.components.core.widget.a.c gR;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;
    private boolean sK;

    public g(Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.Ql = new d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.e.a.d
            public final void oR() {
                g.this.eQ();
            }
        };
        this.mAdTemplate = adTemplate;
        this.Qa = dVar;
        this.gR = new com.kwad.components.core.widget.a.c(this, 70);
        initMVP();
    }

    private void initMVP() {
        this.Qj = oY();
        Presenter presenterOnCreatePresenter = onCreatePresenter();
        this.mPresenter = presenterOnCreatePresenter;
        presenterOnCreatePresenter.ak(this);
        this.mPresenter.K(this.Qj);
    }

    private a oY() {
        a aVar = new a();
        aVar.PY = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.PZ = this.gR;
        aVar.Qa = this.Ql;
        return aVar;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new f());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewAttached");
        this.gR.wK();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewDetached");
        this.gR.release();
        this.mPresenter.destroy();
        this.Qj.release();
        eQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ() {
        if (this.sK) {
            return;
        }
        this.sK = true;
        this.Qa.oR();
    }
}
