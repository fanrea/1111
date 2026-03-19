package com.kwad.components.ad.draw.presenter.livecard;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.draw.b.a implements View.OnClickListener {
    private KSFrameLayout fP;
    private KsLiveAuthorView fQ;
    private TextView fR;
    private TextView fS;
    private TextView fT;
    private final AdLivePlayStateListener fU = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.draw.presenter.livecard.b.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (b.this.fP != null) {
                b.this.fP.setVisibility(0);
            }
        }
    };
    private IAdLivePlayModule fp;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.fp = this.fm.fp;
        AdTemplate adTemplate = this.fm.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eP(adTemplate);
        if (this.fp == null) {
            return;
        }
        initView();
        aX();
    }

    private void aX() {
        this.fp.registerAdLivePlayStateListener(this.fU);
        this.fP.setOnClickListener(this);
        this.fQ.setOnClickListener(this);
        this.fS.setOnClickListener(this);
        this.fT.setOnClickListener(this);
        this.fR.setOnClickListener(this);
    }

    private void initView() {
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_draw_live_end);
        this.fP = kSFrameLayout;
        this.fQ = (KsLiveAuthorView) kSFrameLayout.findViewById(R.id.ksad_draw_author_icon);
        this.fR = (TextView) this.fP.findViewById(R.id.ksad_draw_live_end_app_name);
        this.fT = (TextView) this.fP.findViewById(R.id.ksad_live_actionbar_btn);
        this.fS = (TextView) this.fP.findViewById(R.id.ksad_draw_live_end_text);
        this.fQ.k(this.fm.mAdTemplate);
        this.fR.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
        this.fS.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        this.fT.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        this.fP.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        IAdLivePlayModule iAdLivePlayModule = this.fp;
        if (iAdLivePlayModule == null) {
            return;
        }
        iAdLivePlayModule.unRegisterAdLivePlayStateListener(this.fU);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.fP)) {
            this.fm.a(2, view.getContext(), 53, 2);
            return;
        }
        if (view.equals(this.fQ)) {
            this.fm.a(2, view.getContext(), 15, 2);
            return;
        }
        if (view.equals(this.fS)) {
            this.fm.a(2, view.getContext(), 17, 2);
        } else if (view.equals(this.fR)) {
            this.fm.a(2, view.getContext(), 16, 2);
        } else if (view.equals(this.fT)) {
            this.fm.a(2, view.getContext(), 26, 1);
        }
    }
}
