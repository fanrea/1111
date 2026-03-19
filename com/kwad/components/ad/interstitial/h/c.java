package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.ad.interstitial.f.f;
import com.kwad.components.ad.interstitial.h.d;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends a {
    private KsAdVideoPlayConfig dG;
    protected AdInfo mAdInfo;
    protected AdResultData mAdResultData;
    protected AdTemplate mAdTemplate;
    protected KsInterstitialAd.AdInteractionListener mH;
    private com.kwad.components.ad.interstitial.d mN;
    protected com.kwad.components.ad.interstitial.f.c oa;
    private boolean oe;
    private c.a of;
    private g oh;
    private int oo;
    protected com.kwad.components.ad.interstitial.f.b pO;
    private boolean pP;
    protected ViewGroup pQ;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.pP = false;
        return false;
    }

    public c(Context context) {
        this(context, null);
    }

    private c(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.oo = -1;
        this.oh = new g() { // from class: com.kwad.components.ad.interstitial.h.c.1
            @Override // com.kwad.components.core.webview.tachikoma.f.b
            public final void x(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    if (c.this.pO != null) {
                        c.this.pO.nC();
                    }
                    c cVar = c.this;
                    cVar.pO = cVar.fe();
                    c.this.pO.ak(c.this.pQ);
                    c.this.pO.K(c.this.oa);
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.f.g
            public final void a(String str, long j, long j2, long j3) {
                c.this.oa.on = true;
            }
        };
        this.pQ = (ViewGroup) m.inflate(context, getLayoutId(), this);
    }

    protected final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    private com.kwad.components.ad.interstitial.f.c fd() {
        com.kwad.components.ad.interstitial.f.c cVar = new com.kwad.components.ad.interstitial.f.c();
        cVar.a(this.mAdResultData);
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.mH = this.mH;
        cVar.mN = this.mN;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        cVar.dG = this.dG;
        cVar.ed = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        cVar.hG = (KSFrameLayout) this.pQ.findViewById(R.id.ksad_container);
        cVar.mF = new com.kwad.components.ad.interstitial.g.b(cVar.hG, com.kwad.sdk.core.config.e.XM());
        cVar.mF.wK();
        cVar.oo = this.oo;
        cVar.oe = this.oe;
        cVar.of = this.of;
        cVar.oh = this.oh;
        cVar.ob = a(this.mContext, com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate), cVar);
        return cVar;
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.f.c cVar) {
        boolean zA = com.kwad.components.ad.interstitial.f.c.a(this.mContext, adInfo);
        d.a aVar = new d.a();
        aVar.w(zA);
        boolean z = true;
        aVar.x(!cVar.M(context) && com.kwad.components.ad.interstitial.b.b.dN());
        aVar.R(com.kwad.components.ad.interstitial.b.b.dO());
        if (com.kwad.sdk.core.response.b.a.ba(adInfo) && aq.apb()) {
            z = false;
        }
        aVar.y(z);
        return new d(context, aVar);
    }

    public final com.kwad.components.ad.interstitial.f.b fe() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b();
        if (this.pP) {
            bVar.d(new com.kwad.components.ad.interstitial.f.a.b());
        } else {
            if (com.kwad.sdk.core.response.b.a.bi(this.mAdInfo)) {
                bVar.d(new f());
            }
            bVar.d(new com.kwad.components.ad.interstitial.f.g());
            bVar.d(new com.kwad.components.ad.interstitial.f.d());
            if (com.kwad.sdk.core.response.b.a.aT(this.mAdInfo)) {
                bVar.d(new com.kwad.components.ad.interstitial.f.a());
            }
            if (this.oa.M(getContext())) {
                bVar.d(new com.kwad.components.ad.interstitial.f.e());
            }
        }
        return bVar;
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mH = adInteractionListener;
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            cVar.mH = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.oe = z;
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            cVar.oe = z;
        }
    }

    public final void setAdAggregateClickActionListener(c.a aVar) {
        this.of = aVar;
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            cVar.of = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i) {
        List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
        if (adTemplateList != null && i < adTemplateList.size()) {
            this.mAdTemplate = adTemplateList.get(i);
        } else {
            this.mAdTemplate = com.kwad.sdk.core.response.b.c.s(adResultData);
        }
        this.mAdResultData = com.kwad.sdk.core.response.b.c.a(adResultData, this.mAdTemplate);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        this.mAdTemplate.realShowType = 2;
        this.dG = ksAdVideoPlayConfig;
        this.mN = dVar;
        this.pP = com.kwad.sdk.core.response.b.b.dG(this.mAdTemplate);
        this.mH = adInteractionListener;
        this.oa = fd();
        if (this.pO == null) {
            this.pO = fe();
        }
        this.pO.ak(this.pQ);
        this.pO.K(this.oa);
    }

    public final void setAggregateShowTriggerType(int i) {
        this.oo = i;
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            cVar.oo = i;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.pO;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dF() {
        com.kwad.components.ad.interstitial.f.b bVar = this.pO;
        if (bVar != null) {
            bVar.dW();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dG() {
        com.kwad.components.ad.interstitial.f.b bVar = this.pO;
        if (bVar != null) {
            bVar.dX();
        }
    }

    public final void ff() {
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar == null || !cVar.om) {
            return;
        }
        this.oa.dY();
    }

    public final void fg() {
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            if (this.pP || cVar.om) {
                this.oa.dZ();
            }
        }
    }

    public final void fh() {
        if (this.oa != null) {
            this.oa.a(new c.C0420c(this.mContext).l(true).M(1).n(true).L(2));
        }
    }

    public final boolean fi() {
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            return cVar.on;
        }
        return false;
    }
}
