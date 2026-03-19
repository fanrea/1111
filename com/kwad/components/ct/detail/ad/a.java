package com.kwad.components.ct.detail.ad;

import android.os.Bundle;
import android.view.View;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.ct.detail.ad.presenter.d;
import com.kwad.components.ct.detail.ad.presenter.e;
import com.kwad.components.ct.detail.b.f;
import com.kwad.components.ct.detail.b.g;
import com.kwad.components.ct.home.config.b;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.a {
    private int abR;
    private CtAdTemplate mAdTemplate;
    private DetailVideoView mDetailVideoView;

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.components.ct.detail.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            c.e("DetailAdFragment", "bundle is null");
            return;
        }
        this.abR = arguments.getInt("KEY_INDEX_IN_VIEW_PAGER");
        Serializable serializable = getArguments().getSerializable("key_template");
        if (!(serializable instanceof CtAdTemplate)) {
            c.e("DetailAdFragment", "data is not instanceof CtAdTemplate:" + serializable);
            return;
        }
        CtAdTemplate ctAdTemplate = (CtAdTemplate) serializable;
        this.mAdTemplate = ctAdTemplate;
        ctAdTemplate.mIsFromContent = true;
        this.mDetailVideoView = (DetailVideoView) this.pQ.findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_content_alliance_detail_ad_2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.c
    /* renamed from: yl, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ct.detail.c ap() {
        com.kwad.components.ct.detail.c cVar = new com.kwad.components.ct.detail.c();
        cVar.aoy = this;
        cVar.aol = this.aol;
        cVar.aok = this.aok;
        cVar.mAdTemplate = this.mAdTemplate;
        cVar.abR = this.abR;
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate))) {
            cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        com.kwad.components.ct.detail.e.a aVar = new com.kwad.components.ct.detail.e.a(this, this.aok, this.mDetailVideoView, this.mAdTemplate, this.aol);
        cVar.aoq.add(aVar);
        cVar.aor.add(aVar.CH());
        cVar.aoz = aVar;
        return cVar;
    }

    @Override // com.kwad.components.core.n.c
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.detail.b.c());
        presenter.d(new com.kwad.components.ct.detail.ad.presenter.b.a());
        presenter.d(new d());
        presenter.d(new com.kwad.components.ct.detail.b.a());
        presenter.d(new f());
        presenter.d(new g());
        presenter.d(new com.kwad.components.ct.detail.b.b.a());
        if (b.Fw()) {
            presenter.d(new com.kwad.components.ct.detail.b.a.d());
        }
        if (this.aol != null && this.aol.aGJ) {
            presenter.d(new com.kwad.components.ct.detail.ad.presenter.b());
        }
        if (com.kwad.components.ct.a.b.xe()) {
            presenter.d(new com.kwad.components.ct.detail.photo.newui.c.b(this.aol != null && this.aol.aHg));
        }
        presenter.d(new com.kwad.components.ct.detail.ad.presenter.a.c());
        if (!com.kwad.components.ct.detail.d.b.a((com.kwad.components.ct.detail.c) this.Tj)) {
            presenter.d(new com.kwad.components.ct.detail.ad.presenter.c());
        }
        if (com.kwad.components.ct.detail.a.b.yP()) {
            presenter.d(new com.kwad.components.ct.detail.photo.presenter.a());
        }
        presenter.d(new com.kwad.components.ct.detail.ad.presenter.a());
        if (com.kwad.sdk.core.response.b.d.eD(this.mAdTemplate) && !this.mAdTemplate.isDrawAdHasLook) {
            presenter.d(new e());
        }
        return presenter;
    }
}
