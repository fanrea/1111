package com.kwad.components.ct.detail.c;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ct.detail.c;
import com.kwad.components.ct.e.b;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.a {
    private int abR;
    private com.kwad.components.ct.g.a aoI;
    private KsContentPage.SubShowItem azo;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_fragment_empty_container;
    }

    @Override // com.kwad.components.ct.detail.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.abR = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
        Serializable serializable = getArguments().getSerializable("key_template");
        if (serializable instanceof CtAdTemplate) {
            CtAdTemplate ctAdTemplate = (CtAdTemplate) serializable;
            this.mAdTemplate = ctAdTemplate;
            ctAdTemplate.mIsFromContent = true;
            if (this.aoI == null) {
                this.aoI = new com.kwad.components.ct.g.a();
            }
            this.azo = this.aoI.bg(this.mAdTemplate);
            this.pQ.removeAllViews();
            KsContentPage.SubShowItem subShowItem = this.azo;
            if (subShowItem != null) {
                View viewInstantiateItem = subShowItem.instantiateItem();
                if (viewInstantiateItem != null) {
                    if (viewInstantiateItem.getParent() != null) {
                        ((ViewGroup) viewInstantiateItem.getParent()).removeView(viewInstantiateItem);
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 16;
                    this.pQ.addView(viewInstantiateItem, layoutParams);
                    return;
                }
                b.JK().S(this.mAdTemplate);
            }
        }
    }

    public final void a(com.kwad.components.ct.g.a aVar) {
        this.aoI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.c
    /* renamed from: yl, reason: merged with bridge method [inline-methods] */
    public c ap() {
        c cVar = new c();
        cVar.aoy = this;
        cVar.aol = this.aol;
        cVar.mAdTemplate = this.mAdTemplate;
        cVar.abR = this.abR;
        cVar.aoI = this.aoI;
        cVar.aok = this.aok;
        return cVar;
    }

    @Override // com.kwad.components.core.n.c
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.detail.b.c());
        if (!this.mAdTemplate.thirdFromAdx) {
            presenter.d(new com.kwad.components.ct.detail.b.c.a());
            presenter.d(new com.kwad.components.ct.detail.c.a.a());
        }
        presenter.d(new com.kwad.components.ct.detail.c.a.b());
        return presenter;
    }
}
