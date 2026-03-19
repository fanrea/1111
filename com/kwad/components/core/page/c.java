package com.kwad.components.core.page;

import android.content.Context;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.e;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.page.c.a.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.core.n.d<com.kwad.components.core.page.c.a.b> {
    private AdWebViewActivityProxy.a Vi;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private com.kwad.components.core.page.a.a mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.components.core.n.d
    public final void initData() {
    }

    private c(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.n.d
    public final void ao() {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.release();
            this.mAdWebView = null;
        }
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    public static c a(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.b(context, aVar);
        return cVar;
    }

    private void b(Context context, AdWebViewActivityProxy.a aVar) {
        this.Vi = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.rf();
        this.mPageTitle = aVar.re();
        this.mShowPermission = aVar.rh();
        this.mAutoShow = aVar.rj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* renamed from: rl, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.page.c.a.b ap() {
        com.kwad.components.core.page.c.a.b bVar = new com.kwad.components.core.page.c.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.Vi = this.Vi;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.Vy = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.lz = this.pQ;
        return bVar;
    }

    public final void setLandPageViewListener(com.kwad.components.core.page.a.a aVar) {
        this.mLandPageViewListener = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView != null || bVar == null) {
            return;
        }
        bVar.b(null);
    }

    public final boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.c.a.b) this.mPresenter.amf()).rs();
    }

    public final void rm() {
        ((com.kwad.components.core.page.c.a.b) this.mPresenter.amf()).rm();
    }

    @Override // com.kwad.components.core.n.d
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new f());
        presenter.d(new e());
        if (com.kwad.sdk.core.response.b.e.P(((com.kwad.components.core.page.c.a.b) this.Tj).mAdTemplate)) {
            presenter.d(new com.kwad.components.core.page.c.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.eP(((com.kwad.components.core.page.c.a.b) this.Tj).mAdTemplate)) && com.kwad.components.core.s.a.sX().td() && com.kwad.components.core.s.a.sX().sY() == 1) {
            presenter.d(new com.kwad.components.core.page.c.a.d());
        }
        presenter.d(new g());
        return presenter;
    }
}
