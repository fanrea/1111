package com.kwad.components.ad.c;

import android.content.Context;
import android.widget.FrameLayout;
import com.kwad.components.ad.c.b;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends com.kwad.components.core.n.d<b> {
    private f dQ;
    private Context dR;
    private KsAdVideoPlayConfig dv;
    private List<AdTemplate> dw;
    private KsBannerAd.BannerAdInteractionListener dx;
    private d dy;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.core.n.d
    public final boolean am() {
        return true;
    }

    @Override // com.kwad.components.core.n.d
    public final void ao() {
    }

    public i(Context context, AdResultData adResultData, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context);
        this.dR = context;
        this.mAdResultData = adResultData;
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        this.mAdTemplate = adTemplateS;
        this.mAdScene = adTemplateS.mAdScene;
        this.dw = this.mAdResultData.getAdTemplateList();
        this.dv = ksAdVideoPlayConfig;
        qG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* renamed from: an, reason: merged with bridge method [inline-methods] */
    public b ap() {
        f fVar = new f(this.pQ, com.kwad.sdk.core.response.b.a.cU(this.mAdInfo));
        this.dQ = fVar;
        fVar.wK();
        b bVar = new b();
        bVar.a(this.mAdResultData);
        bVar.a(this.dx);
        bVar.setBannerUpdateAdResultDataListener(this.dy);
        bVar.mAdScene = this.mAdScene;
        bVar.dt = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        bVar.dz = d(this.mAdTemplate);
        bVar.dw = this.dw;
        bVar.mContext = this.dR;
        bVar.dv = this.dv;
        bVar.a(new b.a() { // from class: com.kwad.components.ad.c.i.1
            @Override // com.kwad.components.ad.c.b.a
            public final void ad() {
                i.this.mPresenter.a(new com.kwad.components.ad.c.c.c(), true);
            }
        });
        return bVar;
    }

    @Override // com.kwad.components.core.n.d
    public final Presenter onCreatePresenter() {
        return a(getContext(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.d
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        return R.layout.ksad_banner_base;
    }

    private static Presenter a(Context context, AdTemplate adTemplate) {
        com.kwad.sdk.core.response.b.e.eP(adTemplate);
        Presenter presenter = new Presenter();
        if (b.b(adTemplate)) {
            presenter.d(new com.kwad.components.ad.c.d.a(context));
        } else {
            presenter.d(new com.kwad.components.ad.c.c.c());
        }
        return presenter;
    }

    public final void setBannerAdListener(KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener) {
        this.dx = bannerAdInteractionListener;
    }

    public final void setBannerUpdateAdResultDataListener(d dVar) {
        this.dy = dVar;
    }

    private static StyleTemplate d(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.el(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (matrixTemplateK != null) {
            styleTemplate.templateId = matrixTemplateK.templateId;
            styleTemplate.templateMd5 = matrixTemplateK.templateMd5;
            styleTemplate.templateUrl = matrixTemplateK.templateUrl;
            styleTemplate.templateVersionCode = (int) matrixTemplateK.templateVersionCode;
        }
        return styleTemplate;
    }
}
