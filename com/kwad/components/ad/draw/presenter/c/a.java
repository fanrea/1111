package com.kwad.components.ad.draw.presenter.c;

import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private com.kwad.components.ad.l.b fs;
    private DrawVideoTailFrame gM;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.draw.presenter.c.a.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            if (a.this.fs == null || !a.this.fs.bb()) {
                a.this.bs();
            } else {
                a.this.gM.setVisibility(8);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gM = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.fs = this.fm.fs;
        this.gM.k(this.fm.mAdTemplate);
        this.gM.setAdBaseFrameLayout(this.fm.mRootContainer);
        this.gM.setApkDownloadHelper(this.fm.mApkDownloadHelper);
        this.gM.setVisibility(8);
        this.gM.setAdInteractionListener(this.fm.eU);
        this.fm.fo.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fm.fo.a(this.mVideoPlayStateListener);
        this.gM.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs() {
        this.gM.cb();
        this.gM.setVisibility(0);
    }
}
