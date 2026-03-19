package com.kwad.components.ad.fullscreen.c;

import android.view.View;
import com.kwad.components.ad.fullscreen.c.a.e;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements j {
    private View lJ;
    private View lK;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.c.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            c.this.j(false);
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    public c() {
        d(new e());
        d(new com.kwad.components.ad.fullscreen.c.b.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lJ = findViewById(R.id.ksad_play_detail_top_toolbar);
        this.lK = findViewById(R.id.ksad_play_end_top_toolbar);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gl().a(this);
        this.lJ.setVisibility(0);
        this.lK.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gl().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        if ((this.vb.tK || this.vb.tJ) && !z) {
            this.lJ.setVisibility(8);
            this.lK.setVisibility(8);
        } else {
            this.lJ.setVisibility(8);
            this.lK.setVisibility(0);
        }
    }

    /* renamed from: do, reason: not valid java name */
    private void m452do() {
        if (this.vb.tK || this.vb.tJ) {
            return;
        }
        this.lJ.setVisibility(0);
        this.lK.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dp() {
        m452do();
        if (this.vb.tJ && this.lK.getVisibility() == 0) {
            this.lK.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        j(true);
    }
}
