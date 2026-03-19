package com.kwad.components.ad.interstitial.h;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends j implements View.OnClickListener {
    private static boolean pN;
    private TextView hg;
    private AdTemplate mAdTemplate;
    private TextView mf;
    private com.kwad.components.ad.interstitial.f.c oa;
    private KSCornerImageView pJ;
    private TextView pK;
    private TextView pL;
    private TextView pM;

    public static void e(com.kwad.components.ad.interstitial.f.c cVar) {
        if (pN) {
            return;
        }
        pN = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.f(cVar);
        bVar.show(cVar.mN.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View viewInflate = layoutInflater.inflate(R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        j(viewInflate);
        initData();
        return viewInflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        com.kwad.components.ad.interstitial.f.c cVar = this.oa;
        if (cVar != null) {
            com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().eR(149).eW(9));
        }
    }

    private void j(View view) {
        this.pJ = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.mf = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.hg = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.pK = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.pL = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        this.pM = textView;
        com.kwad.sdk.c.a.a.a(this, this.pJ, this.mf, this.hg, this.pK, this.pL, textView);
    }

    private void initData() {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.pJ, com.kwad.sdk.core.response.b.a.cC(adInfoEP), this.mAdTemplate, 12);
        this.mf.setText(com.kwad.sdk.core.response.b.a.cz(adInfoEP));
        this.hg.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        if (com.kwad.sdk.core.response.b.a.cE(this.mAdTemplate)) {
            this.pK.setText(com.kwad.sdk.core.response.b.a.aH(adInfoEP));
        }
    }

    private void f(com.kwad.components.ad.interstitial.f.c cVar) {
        this.oa = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.oa != null) {
            if (view.equals(this.pJ)) {
                com.kwad.components.ad.interstitial.f.c cVar = this.oa;
                cVar.a(cVar.mN.getContext(), 127, 2, 9);
            } else if (view.equals(this.mf)) {
                com.kwad.components.ad.interstitial.f.c cVar2 = this.oa;
                cVar2.a(cVar2.mN.getContext(), 128, 2, 9);
            } else if (view.equals(this.hg)) {
                com.kwad.components.ad.interstitial.f.c cVar3 = this.oa;
                cVar3.a(cVar3.mN.getContext(), 129, 2, 9);
            } else if (view.equals(this.pK)) {
                com.kwad.components.ad.interstitial.f.c cVar4 = this.oa;
                cVar4.a(cVar4.mN.getContext(), 131, 2, 9);
            } else if (view.equals(this.pL)) {
                com.kwad.sdk.core.adlog.c.c(this.oa.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eW(9));
            } else if (view.equals(this.pM)) {
                com.kwad.components.ad.interstitial.f.c cVar5 = this.oa;
                cVar5.a(false, -1, cVar5.ed);
                this.oa.mN.dismiss();
                com.kwad.sdk.core.adlog.c.e(this.oa.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(151).eW(9));
            }
        }
        dismiss();
        pN = false;
    }
}
