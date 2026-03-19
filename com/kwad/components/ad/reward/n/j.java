package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends d implements View.OnClickListener {
    private View AA;
    private DialogFragment Ep;
    private TextView Eq;
    private View Er;
    private View Es;
    private AdTemplate adTemplate;
    private TextView hg;
    private TextView mf;
    private KSCornerImageView pJ;
    private TextView pK;
    private h.a uB;
    private ViewGroup xM;

    public j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.Ep = dialogFragment;
        this.adTemplate = adTemplate;
        this.uB = aVar;
        this.xM = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.pJ = (KSCornerImageView) this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.mf = (TextView) this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.hg = (TextView) this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.Eq = (TextView) this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.pK = (TextView) this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.AA = this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.Er = this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.Es = this.xM.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.AA.setOnClickListener(this);
        this.Er.setOnClickListener(this);
        this.Es.setOnClickListener(this);
        this.pJ.setOnClickListener(this);
        this.mf.setOnClickListener(this);
        this.hg.setOnClickListener(this);
        this.pK.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadAppIcon(this.pJ, cVar.hs(), this.adTemplate, 4);
        this.mf.setText(cVar.getTitle());
        this.hg.setText(cVar.ht());
        this.Eq.setText(cVar.hv());
        if (com.kwad.sdk.core.response.b.a.cE(this.adTemplate)) {
            this.pK.setText(String.format("%s >", com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hT() {
        return this.xM;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.AA)) {
            this.Ep.dismiss();
            h.a aVar2 = this.uB;
            if (aVar2 != null) {
                aVar2.hn();
                return;
            }
            return;
        }
        if (view.equals(this.Er)) {
            this.Ep.dismiss();
            h.a aVar3 = this.uB;
            if (aVar3 != null) {
                aVar3.G(false);
                return;
            }
            return;
        }
        if (view.equals(this.Es)) {
            this.Ep.dismiss();
            h.a aVar4 = this.uB;
            if (aVar4 != null) {
                aVar4.hn();
                return;
            }
            return;
        }
        if (view.equals(this.pJ)) {
            h.a aVar5 = this.uB;
            if (aVar5 != null) {
                aVar5.i(127, 2);
                return;
            }
            return;
        }
        if (view.equals(this.mf)) {
            h.a aVar6 = this.uB;
            if (aVar6 != null) {
                aVar6.i(128, 2);
                return;
            }
            return;
        }
        if (view.equals(this.hg)) {
            h.a aVar7 = this.uB;
            if (aVar7 != null) {
                aVar7.i(129, 2);
                return;
            }
            return;
        }
        if (!view.equals(this.pK) || (aVar = this.uB) == null) {
            return;
        }
        aVar.i(131, 2);
    }
}
