package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends com.kwad.components.ad.nativead.a.a {
    private View rI;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.rI = findViewById(R.id.ksad_video_error_container);
    }

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.rI.setVisibility(8);
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.j.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayError(int i, int i2) {
                j.this.fL();
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL() {
        if (this.rI.getVisibility() == 0) {
            return;
        }
        this.rI.setVisibility(0);
    }
}
