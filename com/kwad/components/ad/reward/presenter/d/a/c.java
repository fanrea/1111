package com.kwad.components.ad.reward.presenter.d.a;

import android.widget.FrameLayout;
import com.kwad.components.ad.l.b;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private com.kwad.components.ad.l.b fs;
    private FrameLayout gO;
    private DetailVideoView mDetailVideoView;
    private int yt = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (c.this.fs == null || !g.Q(c.this.vb.mAdTemplate)) {
                return;
            }
            c.this.fs.ai(true);
        }
    };
    private com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.c.2
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            c.this.vb.tt.db();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gO = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.vb.mAdTemplate;
        j jVar = this.vb.tx;
        this.fs = jVar;
        if (jVar == null) {
            return;
        }
        com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
        this.fs.a(this.gF);
        this.fs.a(this.gO, this.vb.mRootContainer, adTemplate, this.vb.mApkDownloadHelper, this.vb.mScreenOrientation);
        this.fs.a((b.InterfaceC0426b) null);
        com.kwad.components.ad.l.b bVar = this.fs;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        int i;
        super.onUnbind();
        com.kwad.components.ad.l.b bVar = this.fs;
        if (bVar != null) {
            bVar.nQ();
            this.fs.nC();
        }
        com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView == null || (i = this.yt) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.c.a.a.u(detailVideoView, i);
    }

    @Override // com.kwad.components.ad.l.b.a
    public final void jP() {
        iE();
    }
}
