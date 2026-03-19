package com.kwad.components.ad.nativead.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.nativead.a.a implements View.OnClickListener {
    private KsAdVideoPlayConfig dG;
    private AdInfo mAdInfo;
    private ViewGroup ro;
    private ImageView rp;
    private TextView rq;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dG = ksAdVideoPlayConfig;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ro = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.rp = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.rq = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.rg.mAdTemplate);
        this.mAdInfo = adInfoEP;
        if (!e(adInfoEP)) {
            this.rq.setText(bv.aP(com.kwad.sdk.core.response.b.a.M(this.mAdInfo) * 1000));
            this.rp.setOnClickListener(this);
            this.rg.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.ro.setVisibility(0);
        } else {
            this.ro.setVisibility(8);
        }
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.a.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                a.this.fD();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                a.this.fD();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
    }

    private boolean e(AdInfo adInfo) {
        if (adInfo.isAllowVideoAutoPlay) {
            return true;
        }
        if (!ao.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dG;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ao.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return ao.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ao.isMobileConnected(getContext()));
            }
        }
        if (com.kwad.sdk.core.response.b.a.cl(adInfo)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.cm(adInfo) && ao.isWifiConnected(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD() {
        if (this.ro.getVisibility() != 0) {
            return;
        }
        this.ro.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.rp) {
            this.rg.rh.fQ();
            this.mAdInfo.isAllowVideoAutoPlay = true;
        }
    }
}
