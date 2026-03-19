package com.kwad.components.ad.nativead.b;

import android.widget.ProgressBar;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class k extends com.kwad.components.ad.nativead.a.a {
    private ProgressBar rK;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.rK = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.rK.setProgress(0);
        this.rK.setVisibility(8);
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.k.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                k.this.U(j != 0 ? (int) ((j2 * 100.0f) / j) : 0);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                k.this.fM();
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                k.this.fM();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i) {
        this.rK.setProgress(i);
        if (this.rK.getVisibility() == 0) {
            return;
        }
        this.rK.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM() {
        if (this.rK.getVisibility() != 0) {
            return;
        }
        this.rK.setVisibility(8);
    }
}
