package com.kwad.components.ct.detail.ad.presenter;

import android.view.ViewGroup;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b {
    private int aoM;
    private boolean aoN;
    private ComplianceTextView fv;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fv = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.aoM = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_detail_ad_margin_top);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (com.kwad.sdk.core.response.b.a.aT(com.kwad.components.ct.response.a.a.eP(this.aop.mAdTemplate))) {
            ym();
            this.fv.setAdTemplate(this.aop.mAdTemplate);
            this.fv.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fv.setVisibility(8);
    }

    private void ym() {
        int statusBarHeight = this.aop.aol.aGL;
        if (this.aoN) {
            return;
        }
        this.aoN = true;
        if (com.kwad.components.core.u.e.e(getActivity())) {
            statusBarHeight += com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fv.getLayoutParams();
        marginLayoutParams.topMargin = this.aoM + statusBarHeight;
        this.fv.setLayoutParams(marginLayoutParams);
    }
}
