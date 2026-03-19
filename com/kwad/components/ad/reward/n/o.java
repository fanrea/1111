package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o extends s implements View.OnClickListener {
    private KsAuthorIconView EW;
    private RelativeLayout EX;
    private TextView hf;
    private TextView hg;
    private TextView hh;
    private KsLogoView hi;
    private String hl;
    private KsLogoView hm;
    private com.kwad.components.ad.reward.g vb;
    private boolean hd = false;
    private Runnable ht = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.a.a.a(o.this.hg, o.this.hl, KsLogoView.a(o.this.hm));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                o.this.hg.setText(o.this.hl);
                o.this.hg.setVisibility(0);
            }
        }
    };

    public o(com.kwad.components.ad.reward.g gVar) {
        this.vb = gVar;
    }

    public final void c(ViewGroup viewGroup, int i) {
        if (i == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            this.hd = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            this.hd = false;
        }
        initView();
    }

    private void initView() {
        if (this.xM == null) {
            return;
        }
        this.EW = (KsAuthorIconView) this.xM.findViewById(R.id.ksad_live_author_icon);
        this.hf = (TextView) this.xM.findViewById(R.id.kwad_actionbar_title);
        this.hg = (TextView) this.xM.findViewById(R.id.kwad_actionbar_des_text);
        this.hh = (TextView) this.xM.findViewById(R.id.ksad_live_actionbar_btn);
        this.hi = (KsLogoView) this.xM.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.hd) {
            this.EX = (RelativeLayout) this.xM.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.xM.setOnClickListener(this);
        this.hh.setOnClickListener(this);
        this.EW.setOnClickListener(this);
        this.hg.setOnClickListener(this);
        this.hf.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        k(rVar.getAdTemplate());
    }

    private void k(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.hf.setText(com.kwad.sdk.core.response.b.a.cz(adInfoEP));
        com.kwad.components.core.widget.f fVar = new com.kwad.components.core.widget.f();
        this.EW.setVisibility(0);
        this.EW.k(adTemplate);
        this.EW.a(fVar);
        this.hh.setText(com.kwad.sdk.core.response.b.a.aH(adInfoEP));
        if (com.kwad.sdk.core.response.b.a.bl(adInfoEP) == 8) {
            this.hi.setVisibility(0);
            this.hi.aQ(adTemplate);
            this.hg.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        } else {
            this.hl = com.kwad.sdk.core.response.b.a.aw(adInfoEP);
            KsLogoView ksLogoView = new KsLogoView(this.xM.getContext(), false);
            this.hm = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.n.o.1
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void bJ() {
                    o.this.hg.post(o.this.ht);
                }
            });
            this.hm.aQ(adTemplate);
            this.hi.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void ac(boolean z) {
        super.ac(z);
        Context context = this.xM.getContext();
        if (aq.apb()) {
            return;
        }
        if (!this.hd) {
            this.xM.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.EX.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.EX.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.hh.getLayoutParams();
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.hh.setLayoutParams(layoutParams2);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.xM.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.xM.setLayoutParams(layoutParams3);
        i(this.xM, 85);
    }

    private static void i(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.hh)) {
            this.vb.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.EW)) {
            this.vb.a(1, view.getContext(), 30, 1);
            return;
        }
        if (view.equals(this.hg)) {
            this.vb.a(1, view.getContext(), 32, 1);
        } else if (view.equals(this.hf)) {
            this.vb.a(1, view.getContext(), 31, 1);
        } else if (view.equals(this.xM)) {
            this.vb.a(1, view.getContext(), 53, 2);
        }
    }
}
