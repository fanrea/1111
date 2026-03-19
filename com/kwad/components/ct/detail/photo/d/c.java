package com.kwad.components.ct.detail.photo.d;

import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends n {
    private com.kwad.components.ct.detail.photo.newui.b.a asS;
    private String asT;

    @Override // com.kwad.components.ct.detail.photo.d.n, com.kwad.components.ct.detail.photo.e.d
    /* renamed from: Ae, reason: merged with bridge method [inline-methods] */
    public final LinearLayout Ag() {
        com.kwad.components.ct.detail.photo.newui.b.a aVar = new com.kwad.components.ct.detail.photo.newui.b.a(getContext());
        this.asS = aVar;
        return aVar;
    }

    @Override // com.kwad.components.ct.detail.photo.d.n, com.kwad.components.ct.detail.photo.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.asN = this.asK.ati;
        this.asS.setButtonImageResource(((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj().aqz);
        String str = com.kwad.components.ct.response.a.a.bc((AdTemplate) this.asN.mAdTemplate) == 2 ? "复制商品链接" : "复制商品口令";
        this.asT = str;
        this.asS.setButtonText(str);
        this.asS.setImageViewMargin(24);
    }

    @Override // com.kwad.components.ct.detail.photo.d.n, android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.utils.o.a(getContext(), "ksadsdk_share_url", com.kwad.components.ct.response.a.a.bb((AdTemplate) this.asN.mAdTemplate));
        ac.ae(getContext(), this.asT);
        if (this.asO != null) {
            this.asO.b(this);
        }
    }
}
