package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements j {
    private View AI;
    private View AJ;
    private ImageView AK;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            e.this.jH();
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    public e() {
        d(new com.kwad.components.ad.reward.presenter.platdetail.a());
        d(new com.kwad.components.ad.reward.presenter.d.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.AI = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.AJ = findViewById(R.id.ksad_play_end_top_toolbar);
        this.AK = (ImageView) findViewById(R.id.ksad_blur_end_cover);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.AI.setVisibility(0);
        this.AJ.setVisibility(8);
        this.vb.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gl().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        jG();
        this.vb.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gl().b(this);
        this.AJ.setVisibility(8);
    }

    private void jG() {
        if (!this.vb.tK) {
            this.AJ.setVisibility(8);
        }
        this.AI.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.g.P(this.vb.mAdTemplate) && aq.apb()) {
            this.AK.setVisibility(8);
        }
    }

    public final void jH() {
        if (this.vb.tK) {
            this.AI.setVisibility(8);
        } else {
            this.AI.setVisibility(8);
            this.AJ.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.g.P(this.vb.mAdTemplate) && aq.apb()) {
            this.AK.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dp() {
        jG();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        jH();
    }
}
