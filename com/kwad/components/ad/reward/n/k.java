package com.kwad.components.ad.reward.n;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends d implements com.kwad.sdk.widget.e {
    private KsPriceView DV;
    private TextView DY;
    private TextView DZ;
    private View Ea;
    private ViewStub Et;
    private ViewGroup Eu;
    private KsStyledTextButton Ev;
    private KsStyledTextButton Ew;
    private TextView hg;
    private TextView mf;
    private KSCornerImageView pJ;
    private com.kwad.components.ad.reward.g vb;

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.Et = viewStub;
        this.vb = gVar;
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.Eu = viewGroup;
        this.vb = gVar;
    }

    public final void hide() {
        ViewGroup viewGroup = this.Eu;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hT() {
        return this.Eu;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) throws Resources.NotFoundException {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.S(rVar.getAdTemplate()));
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) throws Resources.NotFoundException {
        KSImageLoader.loadAppIcon(this.pJ, aVar.hs(), adTemplate, 8);
        this.mf.setText(aVar.getTitle());
        this.hg.setText(aVar.ht());
        int dimensionPixelSize = this.Eu.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.DV.getConfig().as(dimensionPixelSize).au(dimensionPixelSize).at(this.Eu.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.DV.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String strIk = aVar.ik();
        this.Ea.setVisibility(TextUtils.isEmpty(strIk) ? 8 : 0);
        if (strIk != null) {
            this.DY.setText(strIk);
        }
        this.DZ.setText(aVar.il());
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        f(view, true);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.vb.mAdTemplate)) {
            f(view, false);
        }
    }

    private void f(View view, boolean z) {
        if (view.equals(this.Ew)) {
            this.vb.a(2, view.getContext(), z ? 38 : 153, 1);
        } else if (view.equals(this.Ev)) {
            this.vb.a(2, view.getContext(), z ? 37 : 153, 1);
        } else if (view.equals(this.Eu)) {
            this.vb.a(2, view.getContext(), z ? 2 : 153, 2);
        }
    }
}
