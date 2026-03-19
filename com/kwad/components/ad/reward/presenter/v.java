package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class v extends b {
    private DetailVideoView yM;
    private ViewGroup yN;
    private FrameLayout yO;
    private ImageView yP;
    private ViewGroup.LayoutParams yQ = null;
    private com.kwad.components.core.video.o lv = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.yM.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.yM.setVisibility(0);
                }
            }, 200L);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.yM = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.yN = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.yP = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.yO = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        iZ();
        ViewGroup.LayoutParams layoutParams = this.yM.getLayoutParams();
        if (layoutParams != null) {
            this.yQ = new ViewGroup.LayoutParams(layoutParams);
        }
        this.vb.tu.a(this.lv);
        ja();
    }

    private void iZ() {
    }

    private void ja() {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
        getContext();
        boolean z = !aq.apb();
        boolean zBT = com.kwad.sdk.core.response.b.a.bT(adInfoEP);
        boolean z2 = com.kwad.sdk.core.response.b.a.cX(adInfoEP) && com.kwad.components.ad.reward.a.b.hQ();
        boolean z3 = com.kwad.components.ad.reward.g.O(this.vb.mAdTemplate) || com.kwad.components.ad.reward.g.P(this.vb.mAdTemplate) || zBT || z2;
        if (z && z3) {
            this.yN.setVisibility(z2 ? 4 : 0);
            if (zBT) {
                this.yP.setVisibility(8);
                ac(R.layout.ksad_playable_end_info);
            } else {
                ac(R.layout.ksad_activity_apk_info_landscape);
            }
            if (!com.kwad.sdk.core.response.b.a.bc(adInfoEP)) {
                this.yM.updateTextureViewGravity(17);
                return;
            } else {
                this.yM.updateTextureViewGravity(21);
                return;
            }
        }
        this.yN.setVisibility(8);
    }

    private void ac(int i) {
        this.yO.addView(com.kwad.sdk.p.m.a(getContext(), i, this.yO, false), -1, -1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.vb.tu.b(this.lv);
        if (this.yQ == null || (detailVideoView = this.yM) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.yQ.width;
            layoutParams.height = this.yQ.height;
            this.yM.setLayoutParams(layoutParams);
        }
        DetailVideoView detailVideoView2 = this.yM;
        if (detailVideoView2 != null) {
            detailVideoView2.setVisibility(4);
        }
        this.yQ = null;
    }
}
