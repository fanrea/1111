package com.kwad.components.ad.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.components.ad.nativead.b.g;
import com.kwad.components.ad.nativead.b.h;
import com.kwad.components.ad.nativead.b.i;
import com.kwad.components.ad.nativead.b.j;
import com.kwad.components.ad.nativead.b.k;
import com.kwad.components.ad.nativead.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends KSFrameLayout {
    private com.kwad.components.core.widget.a.c gR;
    private n gr;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private Presenter mPresenter;
    private KsNativeAd.VideoPlayListener qH;
    private d.a qN;
    private AdBasePvFrameLayout rb;
    private com.kwad.components.ad.nativead.a.b rg;
    public com.kwad.components.ad.nativead.c.a rh;
    private KsAdVideoPlayConfig ri;
    private boolean rj;
    private boolean rk;

    public f(Context context) {
        this(context, null);
    }

    private f(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.rj = false;
        this.rk = false;
        this.gr = new n() { // from class: com.kwad.components.ad.nativead.f.1
            @Override // com.kwad.sdk.widget.n
            public final void aY() {
                com.kwad.sdk.utils.n.fm(f.this.mAdTemplate);
            }
        };
        B(context);
    }

    public final void h(int i, int i2) {
        if (i == 0) {
            this.rk = true;
        }
        if (i2 == 0) {
            this.rj = true;
        }
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.rb = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.qN = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.qH = videoPlayListener;
    }

    public final void setPlayState(int i) {
        com.kwad.components.ad.nativead.c.a aVar = this.rh;
        if (aVar != null) {
            aVar.V(i);
        }
    }

    public final void a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.ri = ksAdVideoPlayConfig;
        this.rb.setVisibleListener(this.gr);
        this.gR = new com.kwad.components.core.widget.a.c(getParent() == null ? this : (View) getParent(), 30);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        if (this.rh == null) {
            this.rh = new com.kwad.components.ad.nativead.c.a(this.mAdTemplate, this.gR, this.mDetailVideoView, this.ri);
        }
        this.rg = fA();
        Presenter presenterBI = bI();
        this.mPresenter = presenterBI;
        presenterBI.ak(this.rb);
        this.mPresenter.K(this.rg);
        this.gR.wK();
        this.rh.bt();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.nativead.f.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (f.this.gR != null) {
                    f.this.gR.release();
                }
                if (f.this.rh != null) {
                    f.this.rh.bv();
                }
                if (f.this.rg != null) {
                    f.this.rg.release();
                }
                if (f.this.mPresenter != null) {
                    f.this.mPresenter.destroy();
                }
            }
        });
    }

    private com.kwad.components.ad.nativead.a.b fA() {
        com.kwad.components.ad.nativead.a.b bVar = new com.kwad.components.ad.nativead.a.b();
        bVar.rb = this.rb;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.qN = this.qN;
        bVar.qH = this.qH;
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))) {
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar == null) {
                bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            } else {
                cVar.pI();
                bVar.mApkDownloadHelper = this.mApkDownloadHelper;
            }
        }
        bVar.rn = this.rk;
        bVar.rm = this.rj;
        bVar.rh = this.rh;
        return bVar;
    }

    private Presenter bI() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ad.nativead.b.e());
        presenter.d(new com.kwad.components.ad.nativead.b.c());
        presenter.d(new i());
        presenter.d(new j());
        presenter.d(new com.kwad.components.ad.nativead.b.d());
        presenter.d(new com.kwad.components.ad.nativead.b.b());
        presenter.d(new k());
        presenter.d(new com.kwad.components.ad.nativead.b.a(this.ri));
        presenter.d(new g());
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))) {
            presenter.d(new com.kwad.components.ad.nativead.b.f());
        } else {
            presenter.d(new h());
        }
        return presenter;
    }
}
